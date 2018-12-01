package com.ddlab.rnd.dao;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import com.ddlab.rnd.entity.IEntity;

public abstract class AbstractBasicDAO<E extends IEntity, K extends Serializable> implements ICoreDAO<E, K> {

    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;
    
    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }
    
	public void save(E e) {
		System.out.println("Going to save--->"+e);
		getSession().save(e);
	}

	public void delete(E e) {
		
		System.out.println("Going to delete--->"+e);
	}

	public List<E> getAll() {
		String hql = "FROM UserEntity";
		return getSession().createQuery(hql).list();
	}

	public E getById(K id) {
		String hql = "FROM UserEntity u where u.id =:id";
		Query query = getSession().createQuery(hql);
		query.setParameter("id", id);
		return (E) query.list().get(0);
	}
	
}
