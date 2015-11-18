package rldev.eshop.dao;

import rldev.eshop.entity.Customer;
import rldev.eshop.entity.UserRole;

import java.util.List;
import java.util.Set;

public interface CustomerDAO extends GeneralDAO<Customer> {

    Customer findByUsername(String username);

    List getRolesByUserId(Long userId);
}
