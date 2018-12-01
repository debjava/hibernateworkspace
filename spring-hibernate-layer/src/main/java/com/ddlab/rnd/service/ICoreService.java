package com.ddlab.rnd.service;

import java.util.List;

public interface ICoreService<E, K> {


    public E getById(K id);

    public E getByName(String name);

    public E save(E entity);

    public void saveAll(List<E> entities);

    public void delete(E entity);

    List<E> getAll();

    void deleteAll();
}
