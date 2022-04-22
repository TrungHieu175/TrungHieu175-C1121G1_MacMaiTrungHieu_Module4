package com.example.repository.service;

import com.example.model.customer.Customer;
import com.example.model.customer.CustomerType;
import com.example.model.service.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IServiceRepository extends JpaRepository<Service,Integer> {

    Page<Service> findAllByNameContaining(String name, Pageable pageable);

    Page<Service> findAllByOrderByName(Pageable pageable);
}
