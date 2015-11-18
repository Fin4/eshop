package rldev.eshop.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import rldev.eshop.dao.AbstractDAO;
import rldev.eshop.dao.OrderDAO;
import rldev.eshop.entity.Order;

import java.util.List;


@Repository("orderDAO")
@Transactional
public class OrderDAOImpl extends AbstractDAO implements OrderDAO {

    public void save(Order persistentObject) {
        getSessionFactory().save(persistentObject);
    }

    public void delete(Order persistentObject) {
        getSessionFactory().delete(persistentObject);
    }

    public void update(Order persistentObject) {
        getSessionFactory().update(persistentObject);
    }

    public Order readById(Long id) {
        return (Order) getSessionFactory().get(Order.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Order> readAll() {
        return getSessionFactory().createQuery("from rldev.eshop.entity.Order").list();
    }
}
