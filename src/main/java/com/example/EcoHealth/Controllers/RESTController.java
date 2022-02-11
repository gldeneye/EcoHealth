package com.example.EcoHealth.Controllers;

import com.example.EcoHealth.Repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.EcoHealth.Customer;

@RestController
public class RESTController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/restTokens/{persNo}")
    public int getCustomerTokens(@PathVariable String persNo) {
        return customerRepository.calcCustomerTokens(persNo);
    }

    @GetMapping("/restMortgage/{persNo}/{productType}")
    public boolean checkMortgage(@PathVariable String persNo, @PathVariable String productType) {
        return customerRepository.checkProduct(persNo, productType);
    }

//    @GetMapping("/restType/{persNo}/{infoType}")
//    public String checkInfoType(@PathVariable String persNo, @PathVariable String infoType) {
//        return customerRepository.getInfoType(persNo, infoType);
//    }
}
