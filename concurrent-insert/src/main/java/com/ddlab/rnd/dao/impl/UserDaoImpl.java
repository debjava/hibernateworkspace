package com.ddlab.rnd.dao.impl;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.ddlab.rnd.dao.AbstractBasicDAO;
import com.ddlab.rnd.dao.IUserDAO;
import com.ddlab.rnd.entity.UserEntity;

@Repository(value = "userDao")
public class UserDaoImpl extends AbstractBasicDAO<UserEntity,Long> implements IUserDAO {

	public List<UserEntity> getUsersById(Long id) {
		System.out.println("UserDaoImpl : getUsersById");
		return null;
	}
}
