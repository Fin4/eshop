package rldev.eshop.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import rldev.eshop.dao.AbstractDAO;
import rldev.eshop.dao.CustomerDAO;
import rldev.eshop.entity.Customer;
import rldev.eshop.entity.UserRole;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository("customerDAO")
@Transactional
public class CustomerDAOImpl extends AbstractDAO implements CustomerDAO {

    public void save(Customer persistentObject) {
        getSessionFactory().save(persistentObject);
    }

    public void delete(Customer persistentObject) {
        getSessionFactory().delete(persistentObject);
    }

    public void update(Customer persistentObject) {
        getSessionFactory().update(persistentObject);
    }

    public Customer readById(Long id) {
        return (Customer) getSessionFactory().get(Customer.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Customer> readAll() {
        return getSessionFactory().createQuery("from rldev.eshop.entity.Customer ").list();
    }

    @SuppressWarnings("unchecked")
    public Customer findByUsername(String username) {
        String customerQuery = "from rldev.eshop.entity.Customer as customer where customer.username =:username";
        Customer customer = (Customer) getSessionFactory().createQuery(customerQuery).setParameter("username", username).uniqueResult();

        return customer;
    }

    public List getRolesByUsername(String username) {

        String roleQuery = "from rldev.eshop.entity.UserRole as role where role.username =:username";
        return getSessionFactory().createQuery(roleQuery).setParameter("username", username).list();
    }
}
