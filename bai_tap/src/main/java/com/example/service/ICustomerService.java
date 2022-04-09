package com.example.service;

import com.example.model.Customer;
import com.example.model.SaveNote;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {

    void save(Customer customer);

    void deleteById(Integer id);

    Customer findById(Integer id);

    Page<Customer> findAllCustomer(Pageable pageable);

    List<Customer> findAll();
}
