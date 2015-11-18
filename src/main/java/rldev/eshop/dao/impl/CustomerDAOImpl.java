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

        Set roles = new HashSet<UserRole>();
        roles.add(new UserRole((long) 1, "ROLE_CUSTOMER", customer));
        roles.add(new UserRole((long) 2, "ROLE_ADMIN", customer));
        customer.setRoles(roles);

        //customer.setRoles(new HashSet<UserRole>(getRolesByUserId(customer.getId())));
        return customer;
    }

    public List getRolesByUserId(Long userId) {

        String roleQuery = "from rldev.eshop.entity.UserRole as roles where role.user.id =:id";
        return getSessionFactory().createQuery(roleQuery).setParameter("id", userId).list();
    }
}
