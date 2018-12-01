package com.ddlab.rnd.service;
import java.util.List;
import com.ddlab.rnd.entity.UserEntity;

public interface IUserService extends ICoreService<UserEntity, Long> {

	public List<UserEntity> getAllFilteredUsers(List<Long> ids);
}
