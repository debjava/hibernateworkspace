package com.ddlab.rnd.dao;

import java.util.List;

import com.ddlab.rnd.domain.entity.Car;
import com.ddlab.rnd.domain.entity.Customer;

public interface ICarDao extends ICoreDao<Customer, Long> {

    List<Car> getCarsByCustomerId(Long id);
}