package com.ddlab.rnd.service;
import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.transaction.annotation.Transactional;

import com.ddlab.rnd.dao.ICoreDAO;
import com.ddlab.rnd.entity.IEntity;
@Transactional
public abstract class AbstractBasicService<E extends IEntity, K extends Serializable, D extends ICoreDAO<E, K>> implements ICoreService<E, K> {

	public abstract D getDao();

	@Transactional(rollbackFor = HibernateException.class)
	public void save(E e) {
		getDao().save(e);
	}

	@Transactional(rollbackFor = HibernateException.class)
	public void saveAll(List<E> entities) {
		for(E e : entities) {
			getDao().save(e);
		}
	}

	public void delete(E e) {
		getDao().delete(e);
	}

	public void deleteAll(List<E> entities) {
		
	}

	public List<E> getAll() {
		return getDao().getAll();
	}

	public E getById(K id) {
		return getDao().getById(id);
	}
}
