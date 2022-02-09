//package com.example.EcoHealth.Controllers;
//
////import com.example.EcoHealth.Repositories.CustomerRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import javax.servlet.http.HttpSession;
//
//@Controller
//public class LoginController {
//
//    @Autowired
////    private CustomerRepository customerRepository;
//
//    @GetMapping("/login")
//    public String loginPage (HttpSession session, @RequestParam String persNo, @RequestParam String password) {
//        if (persNo.equals("931104xxxx") && password.equals("test123")) {
//            session.setAttribute("admin", true);
//            return "redirect:/";
//
//        }
//        return "login";
//    }
//}
//
//
