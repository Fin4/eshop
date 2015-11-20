package rldev.eshop.dao;

import rldev.eshop.entity.Customer;
import java.util.List;

public interface CustomerDAO extends GeneralDAO<Customer> {

    Customer findByUsername(String username);

    List getRolesByUsername(String username);
}
