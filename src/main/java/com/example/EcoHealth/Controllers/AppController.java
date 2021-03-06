package com.example.EcoHealth.Controllers;

import com.example.EcoHealth.Customer;
import com.example.EcoHealth.Product;
import com.example.EcoHealth.Repositories.CustomerRepository;
import com.example.EcoHealth.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

@Controller
public class AppController {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/")
    public String homePage() {
        return "login";
    }

    @PostMapping("/check")
    public String kontrolleraInlog(HttpSession session, Model model, @RequestParam String persNo, @RequestParam String password) {
        boolean check = customerRepository.checkPassword(persNo, password);
        if (check) {
            Customer customer = new Customer();
            customer.setPersNo(persNo);
            model.addAttribute("customer", customer);

            boolean hasMortgage = customerRepository.checkProduct(persNo, "Mortgage");
            boolean hasBufferSavings = customerRepository.checkProduct(persNo, "BufferSavings");
            boolean hasChildrensSavings = customerRepository.checkProduct(persNo, "ChildrensSavings");
            boolean hasPensionsSavings = customerRepository.checkProduct(persNo, "PensionsSavings");
            boolean hasInsurance = customerRepository.checkProduct(persNo, "Insurance");

            boolean hasChildren = customerRepository.getHasChildren(persNo);
            System.out.println("barn: " + hasChildren);
            customer.setHasChildren(hasChildren);

            String maritalStatus = customerRepository.getMaritalOrAccommodationStatus(persNo, "maritalStatus");
            System.out.println("civilst??nd: " + maritalStatus);
            customer.setMaritalStatus(maritalStatus);

            String typeOfLiving = customerRepository.getMaritalOrAccommodationStatus(persNo, "accommodation");
            System.out.println("boende: " + typeOfLiving);
            customer.setTypeOfLiving(typeOfLiving);

            String getEmail = customerRepository.getEmail(persNo);
            customer.setEmail(getEmail);

            String retrieveFullName = customerRepository.getFullName(persNo);
            customer.setFirstName(retrieveFullName.split("_")[0]);
            customer.setLastName(retrieveFullName.split("_")[1]);

//           System.out.println(customer.getFirstName() + "" + customer.getLastName());
//           System.out.println("Has children: " + hasChildren);
//           System.out.println("Marital status: " + maritalStatus);
//           System.out.println("Type of living: " + typeOfLiving);
//           System.out.println("Email: " + getEmail);


            model.addAttribute("hasMortgage", hasMortgage);
            model.addAttribute("hasBufferSavings", hasBufferSavings);
            model.addAttribute("hasChildSavings", hasChildrensSavings);
            model.addAttribute("hasInsurance", hasInsurance);
            model.addAttribute("hasPensionSavings", hasPensionsSavings);

//           System.out.println("Mortgage: " + hasMortgage);
//           System.out.println("Buffer: " + hasBufferSavings);
//           System.out.println("Child Savings: " + hasChildrensSavings);
//           System.out.println("Insurance: " + hasInsurance);
//           System.out.println("Pension Savings: " + hasPensionsSavings);

            session.setAttribute("hasMortgage", hasMortgage);
            session.setAttribute("hasBufferSavings", hasBufferSavings);
            session.setAttribute("hasChildSavings", hasChildrensSavings);
            session.setAttribute("hasInsurance", hasInsurance);
            session.setAttribute("hasPensionSavings", hasPensionsSavings);

            return "form";
        } else {
            return "redirect:/";
        }
    }

    @PostMapping("/form")
    public String saveInfo(HttpSession session, Model model, @ModelAttribute Customer customer) {
        int tokens = customerRepository.calcCustomerTokens(customer.getPersNo());
        System.out.println(tokens);
        model.addAttribute("tokens", tokens);
        model.addAttribute(session.getAttribute("hasMortgage"));
        System.out.println("Kund har bol??n? " + session.getAttribute("hasMortgage"));

        String levels = customerRepository.calcCustomerLevel(customer.getPersNo());
        model.addAttribute("levels", levels);


        if (tokens >= 11000) {
            model.addAttribute("image", "/img/Level5.jpg");
        } else if (tokens >= 5000) {
            model.addAttribute("image", "/img/Level4.jpg");
        } else if (tokens >= 3000) {
            model.addAttribute("image", "/img/Level3.jpg");
        } else if (tokens >= 1500) {
            model.addAttribute("image", "/img/Level2.jpg");
        } else {
            model.addAttribute("image", "/img/Crown1.jpg");
        }


        HashMap<String, Boolean> agreements = new HashMap<>();
        agreements.put("hasMortgage", (boolean)session.getAttribute("hasMortgage"));
        agreements.put("hasBufferSavings",(boolean) session.getAttribute("hasBufferSavings"));
        agreements.put("hasChildSavings",(boolean) session.getAttribute("hasChildSavings"));
        agreements.put("hasInsurance",(boolean) session.getAttribute("hasInsurance"));
        agreements.put("hasPensionSavings",(boolean) session.getAttribute("hasPensionSavings"));
        model.addAttribute("agreements", agreements);


        HashMap<String, Product> hasAgreements = new HashMap<>();
        HashMap<String, Product> doesNotHaveAgreements = new HashMap<>();

        Product Mortgage = new Product("Bol??n", "Flytta ditt bol??n till Handelsbanken","#", productRepository.getTokens("Mortgage"));
        Product Buffer = new Product("Buffertsparande", "Trygga din ekonomi med en buffert f??r of??rusedda utgifter", "#",productRepository.getTokens("BufferSavings") );
        Product ChildrenSavings = new Product("Sparande till barn","Spara f??r ditt barns framtid", "#",productRepository.getTokens("ChildrensSavings"));
        Product PensionSavings = new Product("Pensionssparande", "Spara f??r din framtid", "#",productRepository.getTokens("PensionsSavings"));
        Product Insurance = new Product("F??rs??kring","Ekonomisk ers??ttning i h??ndelse av olyckor, sjukdom och d??dsfall", "#",productRepository.getTokens("Insurance"));
        Product housingSavings = new Product("Spara till din egen bostad","Sparande ??r viktigt f??r att man ska kunna finansiera kontantinsatsen", "#", productRepository.getTokens("HousingSavings"));

        if ((boolean) session.getAttribute("hasMortgage")) {
            hasAgreements.put("hasMortgage", Mortgage);
        } else if ((boolean) session.getAttribute("hasMortgage")==false && customerRepository.getMaritalOrAccommodationStatus(customer.getPersNo(),"Accommodation").equals("Rental")) {
            doesNotHaveAgreements.put("housingSavings", housingSavings);
        }
        else {
            doesNotHaveAgreements.put("hasMortgage", Mortgage);
        };

        if ((boolean) session.getAttribute("hasChildSavings")) {
            hasAgreements.put("hasChildSavings", ChildrenSavings);
        } else if ((boolean)session.getAttribute("hasChildSavings") == false && customerRepository.getHasChildren(customer.getPersNo()) == false){
            System.out.println("Kund saknar barn");
        } else {
            doesNotHaveAgreements.put("hasChildSavings", ChildrenSavings);
        };

        if ((boolean) session.getAttribute("hasBufferSavings")) {
            hasAgreements.put("hasBufferSavings", Buffer);
        } else {
            doesNotHaveAgreements.put("hasBufferSavings", Buffer);
        };

        if ((boolean) session.getAttribute("hasInsurance")) {
            hasAgreements.put("hasInsurance", Insurance);
        } else {
            doesNotHaveAgreements.put("hasInsurance", Insurance);
        };

        if ((boolean) session.getAttribute("hasPensionSavings")) {
            hasAgreements.put("hasPensionSavings", PensionSavings);
        } else {
            doesNotHaveAgreements.put("hasPensionSavings", PensionSavings);
        };

        
        model.addAttribute("hasAgreements", hasAgreements);
        model.addAttribute("doesNotHaveAgreements", doesNotHaveAgreements);

        boolean show = false;
        if (hasAgreements.size()>0) {
            show = true;
        };


        boolean show2 = false;
        if (doesNotHaveAgreements.size()>0) {
            show2 = true;
        };


        model.addAttribute("show2", show2);
        model.addAttribute("show", show);

     

        return "result";
    }


}