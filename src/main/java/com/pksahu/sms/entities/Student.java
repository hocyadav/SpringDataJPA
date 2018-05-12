package com.pksahu.sms.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student_tbl")
public class Student {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="student_id")
	private Integer studentId;
	
	@Column(name="student_name")
	private String studentName;
	
	@Column(name="student_dob")
	private String studentDob;
	
	@Column(name="student_gender")
	private String studentGender;
	
	@Column(name="student_class")
	private String studentClass;
	
	@Column(name="student_birthplace")
	private String studentBirthplace;
	
	@Column(name="student_phone")
	private String studentPhone;

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentDob() {
		return studentDob;
	}

	public void setStudentDob(String studentDob) {
		this.studentDob = studentDob;
	}

	public String getStudentGender() {
		return studentGender;
	}

	public void setStudentGender(String studentGender) {
		this.studentGender = studentGender;
	}

	public String getStudentClass() {
		return studentClass;
	}

	public void setStudentClass(String studentClass) {
		this.studentClass = studentClass;
	}

	public String getStudentBirthplace() {
		return studentBirthplace;
	}

	public void setStudentBirthplace(String studentBirthplace) {
		this.studentBirthplace = studentBirthplace;
	}

	public String getStudentPhone() {
		return studentPhone;
	}

	public void setStudentPhone(String studentPhone) {
		this.studentPhone = studentPhone;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentDob=" + studentDob
				+ ", studentGender=" + studentGender + ", studentClass=" + studentClass + ", studentBirthplace="
				+ studentBirthplace + ", studentPhone=" + studentPhone + "]";
	}	
	
}