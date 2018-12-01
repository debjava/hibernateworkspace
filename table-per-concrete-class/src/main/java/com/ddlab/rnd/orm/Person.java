package com.ddlab.rnd.orm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 * The Class Person.
 * 
 * @author Debadatta Mishra
 */
@Entity
@Table(name = "PERSON4")
// @Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Person {

	/** The person id. */
	@Id
	@Column(name = "PERSON_ID")
	private Long personId;

	/** The name. */
	@Column(name = "name")
	private String name;

	/**
	 * Instantiates a new person.
	 */
	public Person() {

	}

	/**
	 * Instantiates a new person.
	 *
	 * @param name
	 *            the name
	 */
	public Person(String name) {
		this.name = name;
	}

	/**
	 * Gets the person id.
	 *
	 * @return the person id
	 */
	public Long getPersonId() {
		return personId;
	}

	/**
	 * Sets the person id.
	 *
	 * @param personId
	 *            the new person id
	 */
	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name
	 *            the new name
	 */
	public void setName(String name) {
		this.name = name;
	}
}