package com.example.bigbowlxp.services;

import com.example.bigbowlxp.repositories.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private CustomerRepo customerRepo;

    @Autowired
    public void setCustomerRepo(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    public CustomerRepo getCustomerRepo() {
        return customerRepo;
    }
}
