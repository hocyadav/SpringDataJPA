package com.pksahu.sms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
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
	
	public List<Student> getStudentInfoByName(String studentName) {
		return studentDao.findByStudentName(studentName);
	}
	
	public List<Student> getStudentInfoByNameAndClass(String studentName, String studentClass) {
		return studentDao.findByStudentNameAndStudentClass(studentName, studentClass);
	}
	
	public List<Student> getStudentInfoByGender(String studentGender){
		return studentDao.getStudentInfoByGender(studentGender);
	}
	
	public List<Student> getStudentInfoByClass(String studentClass){
		return studentDao.getStudentInfoByClass(studentClass);
	}
	
	public List<Student> getStudentInfoByStudentBirthplace(String studentBirthplace, PageRequest pageRequest){
		return studentDao.findByStudentBirthplace(studentBirthplace, pageRequest);
	}
	
	public List<Student> getStudentInfoByStudentDobOrStudentClass(String studentDob, String studentClass){
		return studentDao.findByStudentDobOrStudentClass(studentDob, studentClass);
	}
	
	public void updateStudentPhoneById(int studentId, String studentPhone) {
		studentDao.updateStudentPhoneById(studentId, studentPhone);
	}
}
