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
    public String kontrolleraInlog(Model model, @RequestParam String persNo, @RequestParam String password) {
       boolean check = customerRepository.checkPassword(persNo, password);
       if (check) {
           Customer customer = new Customer();
           customer.setPersNo(persNo);
           model.addAttribute("customer",customer);
           return "form";
       }
       else {
           return "redirect:/";
       }
    }

    @PostMapping("/form")
    public String saveInfo (Model model, @ModelAttribute Customer customer) {
        int tokens = customerRepository.calcCustomerTokens(customer.getPersNo());
        System.out.println(tokens);
        model.addAttribute("tokens", tokens);
        return "result";
    }


}
