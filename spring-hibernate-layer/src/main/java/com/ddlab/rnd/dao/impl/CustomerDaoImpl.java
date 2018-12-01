package com.ddlab.rnd.dao.impl;

import org.springframework.stereotype.Repository;

import com.ddlab.rnd.dao.AbstractBasicDao;
import com.ddlab.rnd.dao.ICustomerDao;
import com.ddlab.rnd.domain.entity.Customer;

@Repository(value = "customerDao")
public class CustomerDaoImpl extends AbstractBasicDao<Customer,Long> implements ICustomerDao {

	@Override
	public Class getEntityClass() {
		return Customer.class;
	}
}
