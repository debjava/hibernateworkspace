package com.ddlab.rnd.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.ddlab.rnd.dao.IUserDAO;
import com.ddlab.rnd.entity.UserEntity;
import com.ddlab.rnd.service.AbstractBasicService;
import com.ddlab.rnd.service.IUserService;

@Service(value = "userService")
public class UserServiceImpl extends AbstractBasicService<UserEntity, Long, IUserDAO> implements IUserService {

	@Autowired
    @Qualifier("userDao")
    IUserDAO userDao;

    @Override
    public IUserDAO getDao() {
        return userDao;
    }
    
	public List<UserEntity> getAllFilteredUsers(List<Long> ids) {
		return null;
	}
	
	@Override
	public void save(UserEntity e) {
		super.save(e);
	}

}
