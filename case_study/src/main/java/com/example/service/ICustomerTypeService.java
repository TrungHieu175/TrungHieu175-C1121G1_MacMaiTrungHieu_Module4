package com.example.service;

import com.example.model.customer.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerTypeService {
    List<CustomerType> findAll();

    void save(CustomerType customerType);

    void deleteById(Integer id);

    CustomerType findById(Integer id);


    Page<CustomerType> findAllCustomerType(Pageable pageable);
}
