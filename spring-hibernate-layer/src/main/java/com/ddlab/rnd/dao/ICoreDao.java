package com.ddlab.rnd.dao;

import java.io.Serializable;
import java.util.List;

import com.ddlab.rnd.domain.entity.IEntity;

public interface ICoreDao<E extends IEntity, K extends Serializable> {

    Class getEntityClass();

    void save(E e);

    void addAll(List<E> list);

    void deleteAll();

    void delete(E e);

    List<E> getAll();

    E getById(K id);

    E getByName(String name);
}
