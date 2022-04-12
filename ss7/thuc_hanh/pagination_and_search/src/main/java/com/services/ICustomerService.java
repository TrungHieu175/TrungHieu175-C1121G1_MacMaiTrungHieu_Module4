package com.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.models.Customer;


public interface ICustomerService extends IGeneralService<Customer> {
    Page<Customer> findAll(Pageable pageable);
    Page<Customer> findAllByFirstNameContaining(String firstname, Pageable pageable);
}
