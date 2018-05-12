package com.pksahu.sms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pksahu.sms.dao.StudentDao;
import com.pksahu.sms.entities.Student;

@Service
public class StudentService {

	@Autowired
	private StudentDao studentDao;
	
	public Student createStudent(Student student) {
		return studentDao.save(student);
	}
	
	public Student getStudentById(Integer studentId) {
		return studentDao.findOne(studentId);
	}
	
	public Iterable<Student> getAllStudent() {
		return studentDao.findAll();
	}
	
	public void deleteStudent(Integer studentId) {
		studentDao.delete(studentId);
	}
	
	public Student updateStudent(Integer studentId, String phoneNumber) {
		Student fetchedStudent = studentDao.findOne(studentId);
		fetchedStudent.setStudentPhone(phoneNumber);
		Student upadedStudent = studentDao.save(fetchedStudent);
		return upadedStudent;
	}
}
