package com.SpringStandards.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student_info")
public class StudentJPA {

	@Id
	String rollNumber;
	String name;
	String grade;
	int mark1, mark2, mark3;
	int total;

	public StudentJPA() {
	}

	public String getRollNumber() {
		return rollNumber;
	}

	public String getName() {
		return name;
	}

	public String getGrade() {
		return grade;
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

	public void setRollNumber(String rollNumber) {
		this.rollNumber = rollNumber;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setGrade(String grade) {
		this.grade = grade;
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

}
