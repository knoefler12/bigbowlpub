package com.example.bigbowlxp.services;

import com.example.bigbowlxp.models.Customer;
import com.example.bigbowlxp.models.Menu;
import com.example.bigbowlxp.repositories.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private CustomerRepo customerRepo;

    public List<Customer> fetchCustomer(){
        return customerRepo.fetchCustomer();
    }

    @Autowired
    public void setCustomerRepo(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    public CustomerRepo getCustomerRepo() {
        return customerRepo;
    }
}
