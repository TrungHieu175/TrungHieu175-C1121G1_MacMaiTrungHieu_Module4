package com.repositories;

import com.models.Customer;

import java.util.List;

public interface ICustomerRepository extends IGeneralRepository<Customer> {

    void update(Customer customer);

    List<Customer> searchByName(String nameSearch);

    boolean insertWithStoredProcedure(Customer customer);
}