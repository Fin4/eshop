package rldev.eshop.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import rldev.eshop.dao.AbstractDAO;
import rldev.eshop.dao.ProductDAO;
import rldev.eshop.entity.Product;

import java.util.List;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl extends AbstractDAO implements ProductDAO {

    public void save(Product persistentObject) {
        getSessionFactory().save(persistentObject);
    }

    public void delete(Product persistentObject) {
        getSessionFactory().delete(persistentObject);
    }

    public Product readById(Long id) {
        return (Product) getSessionFactory().get(Product.class, id);
    }

    public void update(Product persistentObject) {
        getSessionFactory().update(persistentObject);
    }

    @SuppressWarnings("unchecked")
    public List<Product> readAll() {
        return getSessionFactory().createQuery("from rldev.eshop.entity.Product").list();
    }
}
