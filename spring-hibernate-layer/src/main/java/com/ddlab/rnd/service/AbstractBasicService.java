package com.ddlab.rnd.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ddlab.rnd.dao.ICoreDao;
import com.ddlab.rnd.domain.entity.IEntity;

@Transactional
public abstract class AbstractBasicService<E extends IEntity, K extends Serializable, D extends ICoreDao<E, K>> implements ICoreService<E, K> {

    public abstract D getDao();

    @Override
    public E getById(K id) {
        return getDao().getById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public E getByName(String name) {
        return getDao().getByName(name);
    }

    @Override
    public E save(E entity) {
        getDao().save(entity);
        return entity;
    }

    @Override
    @Transactional
    public void delete(E entity) {
        getDao().delete(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<E> getAll() {
        return getDao().getAll();
    }

    @Override
    @Transactional
    public void deleteAll() {
        getDao().deleteAll();
    }

    @Override
    @Transactional
    public void saveAll(List<E> entities) {
        getDao().addAll(entities);
    }
}
