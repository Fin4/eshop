package rldev.eshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rldev.eshop.dao.CustomerDAO;
import rldev.eshop.entity.Customer;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

@Component
@ManagedBean
@SessionScoped
public class TestBean {

    @Autowired private CustomerDAO customerDAO;

    public List<Customer> getCustomers() {
        return customerDAO.readAll();
    }
}
