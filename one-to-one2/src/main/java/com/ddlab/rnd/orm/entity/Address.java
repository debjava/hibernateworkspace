package com.ddlab.rnd.orm.entity;

import java.io.Serializable;

/**
 * The Class Address.
 * @author Debadatta Mishra
 */
public class Address implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6494554948746566564L;

	/** The address id. */
	private int addressId;

	/** The city. */
	private String city;

	/** The customer. */
	private Customer customer;

	/**
	 * Instantiates a new address.
	 */
	public Address() {

	}

	/**
	 * Instantiates a new address.
	 *
	 * @param city the city
	 */
	public Address(String city) {
		this.city = city;
	}

	/**
	 * Gets the address id.
	 *
	 * @return the address id
	 */
	public int getAddressId() {
		return addressId;
	}

	/**
	 * Sets the address id.
	 *
	 * @param addressId the new address id
	 */
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	/**
	 * Gets the city.
	 *
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Sets the city.
	 *
	 * @param city the new city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Gets the customer.
	 *
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * Sets the customer.
	 *
	 * @param customer the new customer
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
