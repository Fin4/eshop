package rldev.eshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rldev.eshop.dao.ProductDAO;
import rldev.eshop.entity.Product;
import rldev.eshop.service.ProductService;

import java.util.List;

@Service("productService")
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDAO productDAO;

    public void save(Product persistentObject) {
        productDAO.save(persistentObject);
    }

    public void delete(Product persistentObject) {
        productDAO.delete(persistentObject);
    }

    public void update(Product persistentObject) {
        productDAO.update(persistentObject);
    }

    public Product readById(Long id) {
        return productDAO.readById(id);
    }

    public List<Product> readAll() {
        return productDAO.readAll();
    }
}
