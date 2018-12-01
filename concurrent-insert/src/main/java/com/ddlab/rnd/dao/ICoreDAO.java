package com.ddlab.rnd.dao;
import java.io.Serializable;
import java.util.List;
import com.ddlab.rnd.entity.IEntity;

public interface ICoreDAO<E extends IEntity , K extends Serializable> {

	public void save(E e);
	
	public void delete(E e);
	
	public List<E> getAll();

    public E getById(K id);
	
}
