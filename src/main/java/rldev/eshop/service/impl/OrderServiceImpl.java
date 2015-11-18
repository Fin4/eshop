package rldev.eshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rldev.eshop.dao.OrderDAO;
import rldev.eshop.entity.Order;
import rldev.eshop.service.OrderService;

import java.util.List;

@Service("orderService")
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDAO orderDAO;

    public void save(Order persistentObject) {
        orderDAO.save(persistentObject);
    }

    public void delete(Order persistentObject) {
        orderDAO.delete(persistentObject);
    }

    public void update(Order persistentObject) {
        orderDAO.update(persistentObject);
    }

    public Order readById(Long id) {
        return orderDAO.readById(id);
    }

    public List<Order> readAll() {
        return orderDAO.readAll();
    }
}
