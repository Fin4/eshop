package rldev.eshop.dao;

import java.util.List;

public interface GeneralDAO<T> {

    void save(T persistentObject);

    void delete(T persistentObject);

    void update(T persistentObject);

    T readById(Long id);

    List<T> readAll();

}
