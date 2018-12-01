package com.ddlab.rnd.dao;

import java.util.List;

import com.ddlab.rnd.entity.UserEntity;

public interface IUserDAO extends ICoreDAO<UserEntity, Long> {
	
	public List<UserEntity> getUsersById(Long id);
}
