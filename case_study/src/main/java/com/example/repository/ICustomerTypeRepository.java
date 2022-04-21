package com.example.repository;

import com.example.model.customer.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerTypeRepository extends JpaRepository<CustomerType,Integer> {

    Page<CustomerType> findAllByOrderByTypeName (Pageable pageable);

}
