package com.cg.student.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.UniqueElements;

import lombok.NoArgsConstructor;

// TODO: Auto-generated Javadoc
/**
 * The Class StudentDetails.
 */
@Entity
@NoArgsConstructor
@Table(name = "student_details")
public class StudentDetails implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new student details.
	 */
	public StudentDetails() {
	}

	/** The roll number. */
	@Id
	@UniqueElements
	private String rollNumber;

	/** The name. */
	private String name;

	/** The address. */
	private String address;

	/** The phone number. */
	private long phoneNumber;

	/**
	 * Gets the roll number.
	 *
	 * @return the roll number
	 */
	public String getRollNumber() {
		return rollNumber;
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
	 * Gets the address.
	 *
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Gets the phone number.
	 *
	 * @return the phone number
	 */
	public long getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Sets the roll number.
	 *
	 * @param rollNumber the new roll number
	 */
	public void setRollNumber(String rollNumber) {
		this.rollNumber = rollNumber;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Sets the address.
	 *
	 * @param address the new address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Sets the phone number.
	 *
	 * @param phoneNumber the new phone number
	 */
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
