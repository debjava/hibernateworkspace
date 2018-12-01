package com.ddlab.rnd.orm;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * The Class Owner.
 * 
 * @author Debadatta Mishra
 */
@Entity
@Table(name = "OWNER4")
@AttributeOverrides({
// @AttributeOverride(name="personId", column=@Column(name="personId")),
@AttributeOverride(name = "name", column = @Column(name = "name")) })
public class Owner extends Person {

	/** The city. */
	@Column(name = "city")
	private String city;

	/**
	 * Instantiates a new owner.
	 */
	public Owner() {
	}

	/**
	 * Instantiates a new owner.
	 *
	 * @param name
	 *            the name
	 * @param city
	 *            the city
	 */
	public Owner(String name, String city) {
		super(name);
		this.city = city;
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

}