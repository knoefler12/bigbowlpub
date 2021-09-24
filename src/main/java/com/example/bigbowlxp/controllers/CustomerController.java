package com.example.bigbowlxp.controllers;

import com.example.bigbowlxp.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    public CustomerService getCustomerService() {
        return customerService;
    }

    @GetMapping("/kunder")
    public String fetchCustomers(Model model){
        model.addAttribute("customers", customerService.fetchCustomer());
        return "kunder.html";
    }
}
