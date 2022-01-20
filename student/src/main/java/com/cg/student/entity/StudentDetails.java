package com.cg.student.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.UniqueElements;

import lombok.NoArgsConstructor;

// TODO: Auto-generated Javadoc
/**
 * The Class StudentDetails.
 */
@Entity
@Table(name = "student_details")
public class StudentDetails implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new student details.
	 */

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
	 * Instantiates a new student details.
	 */
	public StudentDetails() {
	}

	/**
	 * Instantiates a new student details.
	 *
	 * @param rollNumber the roll number
	 * @param name the name
	 * @param address the address
	 * @param phoneNumber the phone number
	 * @param results the results
	 */
	public StudentDetails(@UniqueElements String rollNumber, String name, String address, long phoneNumber,
			StudentExamResults results) {
		super();
		this.rollNumber = rollNumber;
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.results = results;
	}

	/** The results. */
	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "rollNumber", referencedColumnName = "rollNumber")
	private StudentExamResults results;

	/**
	 * Gets the results.
	 *
	 * @return the results
	 */
	public StudentExamResults getResults() {
		return results;
	}

	/**
	 * Sets the results.
	 *
	 * @param results the new results
	 */
	public void setResults(StudentExamResults results) {
		this.results = results;
	}

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
