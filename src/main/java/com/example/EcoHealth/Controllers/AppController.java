package com.example.EcoHealth.Controllers;

import com.example.EcoHealth.Customer;
import com.example.EcoHealth.Repositories.CustomerRepository;
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

@Controller
public class AppController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/")
    public String homePage () {
        return "login";
    }

    @PostMapping("/check")
    public String kontrolleraInlog(HttpSession session, Model model, @RequestParam String persNo, @RequestParam String password) {
       boolean check = customerRepository.checkPassword(persNo, password);
       if (check) {
           Customer customer = new Customer();
           customer.setPersNo(persNo);
           model.addAttribute("customer",customer);

           boolean hasMortgage = customerRepository.checkProduct(persNo,"Mortgage");
           boolean hasBufferSavings = customerRepository.checkProduct(persNo,"BufferSavings");
           boolean hasChildrensSavings = customerRepository.checkProduct(persNo,"ChildrensSavings");
           boolean hasPensionsSavings = customerRepository.checkProduct(persNo,"PensionsSavings");
           boolean hasInsurance = customerRepository.checkProduct(persNo,"Insurance");

           boolean hasChildren = customerRepository.getHasChildren(persNo);
           customer.setHasChildren(hasChildren);

           String maritalStatus = customerRepository.getMaritalOrAccommodationStatus(persNo, "maritalStatus");
           customer.setMaritalStatus(maritalStatus);

           String typeOfLiving = customerRepository.getMaritalOrAccommodationStatus(persNo, "accommodation");
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
       }
       else {
           return "redirect:/";
       }
    }

    @PostMapping("/form")
    public String saveInfo (HttpSession session, Model model, @ModelAttribute Customer customer) {
        int tokens = customerRepository.calcCustomerTokens(customer.getPersNo());
        System.out.println(tokens);
        model.addAttribute("tokens", tokens);
        model.addAttribute(session.getAttribute("hasMortgage"));
        System.out.println("Kund har bolån? " + session.getAttribute("hasMortgage"));

        int numOfAgreements = customerRepository.getNumberOfAgreements(customer.getPersNo());
        switch (numOfAgreements) {
            case(0):
                model.addAttribute("image", "/img/0.jpg");
                break;
            case(1):
                model.addAttribute("image", "/img/20.jpg");
                break;
            case(2):
                model.addAttribute("image", "/img/40.jpg");
                break;
            case(3):
                model.addAttribute("image", "/img/60.jpg");
                break;
            case(4):
                model.addAttribute("image", "/img/80.jpg");
                break;
            case(5):
                model.addAttribute("image", "/img/100.jpg");
                break;

        }

        HashMap<String, Boolean> agreements = new HashMap<>();
        agreements.put("hasMortgage", (boolean)session.getAttribute("hasMortgage"));
        agreements.put("hasBufferSavings",(boolean) session.getAttribute("hasBufferSavings"));
        agreements.put("hasChildSavings",(boolean) session.getAttribute("hasChildSavings"));
        agreements.put("hasInsurance",(boolean) session.getAttribute("hasInsurance"));
        agreements.put("hasPensionSavings",(boolean) session.getAttribute("hasPensionSavings"));
        model.addAttribute("agreements", agreements);

        return "result";
    }


}
