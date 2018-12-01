package com.ddlab.rnd.service;

import java.util.List;

import com.ddlab.rnd.domain.entity.Car;
import com.ddlab.rnd.domain.entity.Customer;

public interface ICarService extends ICoreService<Car, Long> {

	public List<Car> getCarsByCustomerId(Long id);
	
	public List<Customer> getCustomerByCarId(Long id);
}
