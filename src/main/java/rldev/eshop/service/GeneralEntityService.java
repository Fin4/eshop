package rldev.eshop.service;

import java.util.List;

public interface GeneralEntityService<T> {

    void save(T persistentObject);

    void delete(T persistentObject);

    void update(T persistentObject);

    T readById(Long id);

    List<T> readAll();
}
