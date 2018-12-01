package com.ddlab.rnd.service;

import java.util.List;

public interface ICoreService<E,K> {

	public void save(E e);
	
	public void saveAll(List<E> entities);

	public void delete(E e);
	
	public void deleteAll(List<E> entities);

	public List<E> getAll();

	public E getById(K id);

}
