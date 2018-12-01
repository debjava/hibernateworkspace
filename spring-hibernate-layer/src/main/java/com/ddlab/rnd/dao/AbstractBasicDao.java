package com.ddlab.rnd.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.ddlab.rnd.domain.entity.IEntity;

public abstract class AbstractBasicDao<E extends IEntity, K extends Serializable> implements ICoreDao<E, K> {

    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;

    public void addAll(List<E> list) {
        for (E e : list) {
            this.save(e);
        }
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public E getByName(String name) {
        //JPA Criteria
        Criteria criteria = getSession().createCriteria(getEntityClass()).add(Restrictions.eq("name", name));
        E result = (E) criteria.uniqueResult();
        
        criteria.setCacheable(true);
        System.out.println(sessionFactory.getStatistics().getSecondLevelCacheStatistics("countryByNameCache"));
        return result;
    }

    @Override
    public void deleteAll() {
        getSession().createQuery("DELETE FROM " + getEntityClass().getSimpleName()).executeUpdate();
    }

    @Override
    public void delete(E e) {
        getSession().delete(e);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<E> getAll() {
        return getSession().createCriteria(getEntityClass()).setCacheable(true).list();
    }

    @Override
    public void save(E e) {
        getSession().saveOrUpdate(e);
    }

    public E getById(K id) {
        E e = (E) getSession().get(getEntityClass(), id);
        return e;
    }

}
