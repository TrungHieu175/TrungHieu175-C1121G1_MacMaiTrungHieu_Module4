package com.example.service.impl;

import com.example.model.customer.CustomerType;
import com.example.repository.ICustomerTypeRepository;
import com.example.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class CustomerTypeService implements ICustomerTypeService {

    @Autowired
    private ICustomerTypeRepository iCustomerTypeRepository;

    @Override
    public List<CustomerType> findAll() {
        return iCustomerTypeRepository.findAll();
    }

    @Override
    public void save(CustomerType customerType) {
        iCustomerTypeRepository.save(customerType);
    }

    @Override
    public void deleteById(Integer id) {
        iCustomerTypeRepository.deleteById(id);
    }

    @Override
    public CustomerType findById(Integer id) {
        return iCustomerTypeRepository.findById(id).orElse(null);
    }

    @Override
    public Page<CustomerType> findAllCustomerType(Pageable pageable) {
        return iCustomerTypeRepository.findAllByOrderByTypeName(pageable);
    }
}
