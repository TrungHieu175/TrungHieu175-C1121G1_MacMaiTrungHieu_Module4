package com.example.repository;

import com.example.model.Customer;
import com.example.model.SaveNote;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer,Integer> {

    Page<Customer> findAllByOrderByName(Pageable pageable);
}
