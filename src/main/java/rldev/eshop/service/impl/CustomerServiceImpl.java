package rldev.eshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rldev.eshop.dao.CustomerDAO;
import rldev.eshop.entity.Customer;
import rldev.eshop.service.CustomerService;

import java.util.List;

@Service("customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    public void save(Customer persistentObject) {
        customerDAO.save(persistentObject);
    }

    public void delete(Customer persistentObject) {
        customerDAO.delete(persistentObject);
    }

    public void update(Customer persistentObject) {
        customerDAO.update(persistentObject);
    }

    public Customer readById(Long id) {
        return customerDAO.readById(id);
    }

    public List<Customer> readAll() {
        return customerDAO.readAll();
    }

    public Customer findByUsername(String username) {
        return customerDAO.findByUsername(username);
    }
}
