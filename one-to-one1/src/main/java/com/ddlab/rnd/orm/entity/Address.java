package com.ddlab.rnd.orm.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * The Class Address.
 * 
 * @author Debadatta Mishra
 */
@Entity
@Table(name = "address")
public class Address implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6494554948746566564L;

	/** The address id. */
	@Id
	@Column(name = "addressId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int addressId;

	/** The city. */
	@Column(name = "city")
	private String city;

	/** The customer. */
	@OneToOne(mappedBy = "address")
	private Customer customer;

	/**
	 * Instantiates a new address.
	 */
	public Address() {

	}

	/**
	 * Instantiates a new address.
	 *
	 * @param city
	 *            the city
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
	 * @param addressId
	 *            the new address id
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
	 * @param city
	 *            the new city
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
	 * @param customer
	 *            the new customer
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
