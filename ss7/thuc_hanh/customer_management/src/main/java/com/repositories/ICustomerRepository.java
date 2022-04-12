package com.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.models.Customer;
import com.models.Province;

import java.util.List;

@Repository
public interface ICustomerRepository extends PagingAndSortingRepository<Customer,Long> {

    void update(Customer customer);
    List<Customer> searchByName(String nameSearch);

    Iterable<Customer> findAllByProvince(Province province);
}