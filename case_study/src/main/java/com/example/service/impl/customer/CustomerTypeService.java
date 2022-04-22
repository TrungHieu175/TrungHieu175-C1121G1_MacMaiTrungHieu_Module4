package com.example.service.impl.customer;

import com.example.model.customer.CustomerType;
import com.example.repository.customer.ICustomerTypeRepository;
import com.example.service.customer.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
