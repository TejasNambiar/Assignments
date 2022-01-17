package com.cg.student.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.UniqueElements;

import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Table(name = "student_exam_results")
public class StudentExamResults implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@UniqueElements
	private String rollNumber;

	@Range(min = 0, max = 100, message = "total should be between 0-100")
	@NotNull(message = "mark1 should not be null")
	private int mark1;

	@Range(min = 0, max = 100, message = "total should be between 0-100")
	@NotNull(message = "mark2 should not be null")
	private int mark2;

	@Range(min = 0, max = 100, message = "total should be between 0-100")
	@NotNull(message = "mark3 should not be null")
	private int mark3;

	private int total;

	@Pattern(regexp = "\\s*|[A-D F]{1}$", message = "grade should be A,B,C,D,F or Empty('') only")
	private String grade;

	public String getRollNumber() {
		return rollNumber;
	}

	public int getMark1() {
		return mark1;
	}

	public int getMark2() {
		return mark2;
	}

	public int getMark3() {
		return mark3;
	}

	public int getTotal() {
		return total;
	}

	public String getGrade() {
		return grade;
	}

	public void setRollNumber(String rollNumber) {
		this.rollNumber = rollNumber;
	}

	public void setMark1(int mark1) {
		this.mark1 = mark1;
	}

	public void setMark2(int mark2) {
		this.mark2 = mark2;
	}

	public void setMark3(int mark3) {
		this.mark3 = mark3;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public void updateTotal() {
		int temp = (int) (this.mark1 + this.mark2 + this.mark3) / 3;
		setTotal(temp);
	}

	public void updateGrade() {

		if (this.total >= 275)
			setGrade("A");
		else if (this.total >= 250)
			setGrade("B");
		else if (this.total >= 225)
			setGrade("C");
		else if (this.total >= 200)
			setGrade("D");
		else
			setGrade("F");

	}

}
