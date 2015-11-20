package rldev.eshop.service;

import org.springframework.security.access.annotation.Secured;

import java.util.List;

public interface GeneralEntityService<T> {

    void save(T persistentObject);

    void delete(T persistentObject);

    void update(T persistentObject);

    T readById(Long id);

    @Secured("ROLE_ADMIN")
    List<T> readAll();
}
