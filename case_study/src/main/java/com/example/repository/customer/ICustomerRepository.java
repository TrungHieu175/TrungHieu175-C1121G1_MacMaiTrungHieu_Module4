package com.example.repository.customer;

import com.example.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ICustomerRepository extends JpaRepository<Customer,Integer> {

    Page<Customer> findAllByNameContaining(String name, Pageable pageable);

    Page<Customer> findAllByOrderByName(Pageable pageable);
}
