package com.ddlab.rnd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ddlab.rnd.dao.ICustomerDao;
import com.ddlab.rnd.domain.entity.Car;
import com.ddlab.rnd.domain.entity.Customer;
import com.ddlab.rnd.service.AbstractBasicService;
import com.ddlab.rnd.service.ICustomerService;
@Service(value = "customerService")
public class CustomerServiceImpl extends AbstractBasicService<Customer, Long, ICustomerDao> implements ICustomerService {

	@Autowired
    @Qualifier("customerDao")
    ICustomerDao customerDao;
	
	@Override
	public List<Car> getCars(Customer customer) {
		return null;
	}

	@Override
	public ICustomerDao getDao() {
		return customerDao;
	}

}
