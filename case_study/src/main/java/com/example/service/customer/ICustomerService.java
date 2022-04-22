package com.example.service.customer;

import com.example.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

    void save(Customer customer);

    void deleteById(Integer id);

    Customer findById(Integer id);

    Page<Customer> findAllPaging(String keyword, Pageable pageable);

    Page<Customer> findAllCustomer(Pageable pageable);
}
