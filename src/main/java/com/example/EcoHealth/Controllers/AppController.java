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

    @PostMapping("/homePage")
    public String tamighem() {
        return "homePage";
    }

    @GetMapping("/form")
    public String form (Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer",customer);
        return "form";
        //Addera inloggad kund till modellen
    }

    @PostMapping("/result")
    public String saveInfo (@ModelAttribute Customer customer, @RequestParam String maritalStatus) {
        customer.setMaritalStatus(maritalStatus);
        System.out.println(customer.getMaritalStatus());
        return "result";
    }


}
