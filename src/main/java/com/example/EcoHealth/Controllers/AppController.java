package com.example.EcoHealth.Controllers;

import com.example.EcoHealth.Repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/")
    public String homePage () {
        return "homePage";
    }

    @GetMapping("/form")
    public String form () {
        return "form";
    }
}
