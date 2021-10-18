package com.ab.bankingapp.services;

import com.ab.bankingapp.models.Customer;
import com.ab.bankingapp.repos.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepo repo;

    public List<Customer> listAll() {
        return repo.findAll();
    }

    public void save(Customer c) {
        repo.save(c);
    }

    public Customer get(int c) {
        return repo.findById(c).get();
    }

    public void delete(int c) {
        repo.deleteById(c);
    }
}
