package com.cg.student.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class StudentJPA.
 */
@Entity
@Table(name = "student_information")
public class StudentJPA {

	/** The roll number. */
	@Id
	String rollNumber;
	
	/** The name. */
	String name;
	
	/** The grade. */
	String grade;
	
	/** The mark 3. */
	int mark1, mark2, mark3;
	
	/** The total. */
	int total;
	/*
	 * @OneToMany - directly mentioning 1 student, many hobbies
	 * 
	 * @JoinColumn - mentioning the column on which need to join
	 */
//	@OneToMany(targetEntity = HobbyJPA.class, cascade = CascadeType.ALL)
//	@JoinColumn(name = "student_hobby_fk", referencedColumnName = "rollNumber")
//	List<HobbyJPA> hobbyList;

	/**
	 * Instantiates a new student JPA.
	 */
	public StudentJPA() {
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
	 * Gets the grade.
	 *
	 * @return the grade
	 */
	public String getGrade() {
		return grade;
	}

	/**
	 * Gets the mark 1.
	 *
	 * @return the mark 1
	 */
	public int getMark1() {
		return mark1;
	}

	/**
	 * Gets the mark 2.
	 *
	 * @return the mark 2
	 */
	public int getMark2() {
		return mark2;
	}

	/**
	 * Gets the mark 3.
	 *
	 * @return the mark 3
	 */
	public int getMark3() {
		return mark3;
	}

	/**
	 * Gets the total.
	 *
	 * @return the total
	 */
	public int getTotal() {
		return total;
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
	 * Sets the grade.
	 *
	 * @param grade the new grade
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}

	/**
	 * Sets the mark 1.
	 *
	 * @param mark1 the new mark 1
	 */
	public void setMark1(int mark1) {
		this.mark1 = mark1;
	}

	/**
	 * Sets the mark 2.
	 *
	 * @param mark2 the new mark 2
	 */
	public void setMark2(int mark2) {
		this.mark2 = mark2;
	}

	/**
	 * Sets the mark 3.
	 *
	 * @param mark3 the new mark 3
	 */
	public void setMark3(int mark3) {
		this.mark3 = mark3;
	}

	/**
	 * Sets the total.
	 *
	 * @param total the new total
	 */
	public void setTotal(int total) {
		this.total = total;
	}

}
