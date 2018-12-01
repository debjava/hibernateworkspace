package com.ddlab.rnd.service;

import java.util.List;

import com.ddlab.rnd.domain.entity.Car;
import com.ddlab.rnd.domain.entity.Customer;

public interface ICustomerService extends ICoreService<Customer,Long> {
	
	public List<Car> getCars(Customer customer);
	
}
