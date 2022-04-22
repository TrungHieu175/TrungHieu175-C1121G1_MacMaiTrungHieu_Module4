package com.example.service.service;

import com.example.model.customer.Customer;
import com.example.model.customer.CustomerType;
import com.example.model.service.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IServiceService {

    List<Service> findAll();

    void save(Service service);

    void deleteById(Integer id);

    Service findById(Integer id);

    Page<Service> findAllPaging(String keyword, Pageable pageable);

    Page<Service> findAllService(Pageable pageable);
}
