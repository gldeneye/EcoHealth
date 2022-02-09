package com.example.EcoHealth.Controllers;

import com.example.EcoHealth.Customer;
import com.example.EcoHealth.Repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RESTController {

    @Autowired
    private CustomerRepository customerRepository;

}
