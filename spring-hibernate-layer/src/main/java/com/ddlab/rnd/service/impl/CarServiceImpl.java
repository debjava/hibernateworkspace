package com.ddlab.rnd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ddlab.rnd.dao.ICarDao;
import com.ddlab.rnd.domain.entity.Car;
import com.ddlab.rnd.domain.entity.Customer;
import com.ddlab.rnd.service.AbstractBasicService;
import com.ddlab.rnd.service.ICarService;
@Service(value = "carService")
public class CarServiceImpl extends AbstractBasicService<Car, Long, ICarDao> implements ICarService {

	@Autowired
    @Qualifier("carDao")
    ICarDao carDao;
	
	@Override
	public ICarDao getDao() {
		return carDao;
	}
	
	@Override
	public List<Car> getCarsByCustomerId(Long id) {
		return carDao.getCarsByCustomerId(id);
	}

	@Override
	public List<Customer> getCustomerByCarId(Long id) {
		return null;
	}
	
}
