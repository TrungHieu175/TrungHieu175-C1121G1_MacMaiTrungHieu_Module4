package com.services;

import com.models.Customer;
import com.repositories.IGeneralRepository;

import java.util.List;

public interface ICustomerService extends IGeneralRepository<Customer> {
    List<Customer> findAll();

    void save(Customer customer);

    Customer findById(Long id);

    void update(Customer customer);

    void remove(Long id);

    List<Customer> searchByName(String nameSearch);

    boolean insertWithStoredProcedure(Customer customer);
}
