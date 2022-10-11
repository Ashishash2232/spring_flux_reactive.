package com.example.reactivewebservice.service;

import com.example.reactivewebservice.dao.CustomerRepository;
import com.example.reactivewebservice.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository dao;

    public List<Customer> loadAllCustomer() {
        long start = System.currentTimeMillis();
        List<Customer> customers = dao.getCustomers();
        long end = System.currentTimeMillis();
        System.out.println("TOtal execution time : " + (end - start));
        return customers;

    }
    public Flux<Customer> loadAllCustomerStream() {
        long start = System.currentTimeMillis();
        Flux<Customer> customers = dao.getCustomersStream();
        long end = System.currentTimeMillis();
        System.out.println("TOtal execution time flux : " + (end - start));
        return customers;

    }

}
