package rldev.eshop.service;

import rldev.eshop.entity.Customer;

public interface CustomerService extends GeneralEntityService<Customer> {

    Customer findByUsername(String username);
}
