package com.cg.student.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.validator.constraints.UniqueElements;

import lombok.NoArgsConstructor;

// TODO: Auto-generated Javadoc
/**
 * The Class StudentExamResults.
 */
@Entity
@NoArgsConstructor
@Table(name = "student_exam_results")
public class StudentExamResults implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The roll number. */
	@Id
	@UniqueElements
	private String rollNumber;

	/** The mark 1. */
	private int mark1;

	/** The mark 2. */
	private int mark2;

	/** The mark 3. */
	private int mark3;

	/** The total. */
	private int total;

	/** The grade. */
	private String grade;

	/**
	 * Gets the roll number.
	 *
	 * @return the roll number
	 */
	public String getRollNumber() {
		return rollNumber;
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
	 * Gets the grade.
	 *
	 * @return the grade
	 */
	public String getGrade() {
		return grade;
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

	/**
	 * Sets the grade.
	 *
	 * @param grade the new grade
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}

}
