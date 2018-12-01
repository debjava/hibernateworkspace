package com.ddlab.rnd.orm;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * The Class Employee.
 * 
 * @author Debadatta Mishra
 */
@Entity
@Table(name = "EMPLOYEE4")
@AttributeOverrides({
// @AttributeOverride(name="personId", column=@Column(name="personId")),
@AttributeOverride(name = "name", column = @Column(name = "name")) })
public class Employee extends Person {

	/** The dept name. */
	@Column(name = "deptName")
	private String deptName;

	/**
	 * Instantiates a new employee.
	 */
	public Employee() {

	}

	/**
	 * Instantiates a new employee.
	 *
	 * @param name
	 *            the name
	 * @param deptName
	 *            the dept name
	 */
	public Employee(String name, String deptName) {
		super(name);
		this.deptName = deptName;
	}

	/**
	 * Gets the dept name.
	 *
	 * @return the dept name
	 */
	public String getDeptName() {
		return deptName;
	}

	/**
	 * Sets the dept name.
	 *
	 * @param deptName
	 *            the new dept name
	 */
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

}