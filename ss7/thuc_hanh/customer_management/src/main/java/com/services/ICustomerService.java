package com.services;

import com.models.Customer;
import com.models.Province;

public interface ICustomerService extends IGeneralService<Customer> {
    Iterable<Customer> findAllByProvince(Province province);
}
