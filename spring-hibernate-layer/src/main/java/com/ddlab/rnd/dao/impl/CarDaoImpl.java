package com.ddlab.rnd.dao.impl;

import java.util.List;

import com.ddlab.rnd.dao.AbstractBasicDao;
import com.ddlab.rnd.dao.ICarDao;
import com.ddlab.rnd.domain.entity.Car;

public class CarDaoImpl extends AbstractBasicDao<Car, Long> implements ICarDao {
	
	@Override
	public Class getEntityClass() {
		return Car.class;
	}
	
	public List<Car> getCarsByCustomerId(Long id) {
		
		return null;
	}

}
