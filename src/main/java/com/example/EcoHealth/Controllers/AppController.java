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
        return "result";
    }


}
