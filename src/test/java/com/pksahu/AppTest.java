package com.pksahu;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;

import com.pksahu.sms.entities.Student;
import com.pksahu.sms.service.StudentService;

public class AppTest {

	private ApplicationContext context;
	
	@Before
	public void before() {
		context = new ClassPathXmlApplicationContext("spring.xml");
	}

	@Test
	public void testCreateStudent(){
		StudentService studentService = context.getBean("studentService", StudentService.class);
		
		Student student = new Student();
		student.setStudentName("Shyam");
		student.setStudentDob("16-05-2003");
		student.setStudentClass("9");
		student.setStudentBirthplace("Pune");
		student.setStudentGender("Male");
		student.setStudentPhone("7777755555");
		
		studentService.createStudent(student);
	}
	
	@Test
	public void testGetStudentById(){
		StudentService studentService = context.getBean("studentService", StudentService.class);
		Student student = studentService.getStudentById(2);
		System.out.println(student);
	}
	
	@Test
	public void testGetAllStudent(){
		StudentService studentService = context.getBean("studentService", StudentService.class);
		Iterable<Student> listOfStudent= studentService.getAllStudent();
		for(Student student:listOfStudent)
			System.out.println("Student : " + student);
	}
	
	@Test
	public void testDeleteStudent(){
		StudentService studentService = context.getBean("studentService", StudentService.class);
		Student student = new Student();
		student.setStudentId(1);
		studentService.deleteStudent(1);
	}
	
	@Test
	public void testUpdateStudent(){
		StudentService studentService = context.getBean("studentService", StudentService.class);
		studentService.updateStudent(2, "4444422222");
	}
	
	@Test // To test user-define method on studentName
	public void testGetStudentInfoByName(){
		StudentService studentService = context.getBean("studentService", StudentService.class);
		List<Student> studentList = studentService.getStudentInfoByName("Ram");
		for(Student student : studentList) {
			System.out.println(student);
		}	
	}
	
	@Test // To test user-define method on studentName and studentClass
	public void testGetStudentInfoByNameAndClass(){
		StudentService studentService = context.getBean("studentService", StudentService.class);
		List<Student> studentList = studentService.getStudentInfoByNameAndClass("Ram", "5");
		for(Student student : studentList) {
			System.out.println(student);
		}	
	}
	
	@Test // To test @Query with JPQL
	public void testGetStudentInfoByGender(){
		StudentService studentService = context.getBean("studentService", StudentService.class);
		List<Student> studentList = studentService.getStudentInfoByGender("Female");
		for(Student student : studentList) {
			System.out.println(student);
		}	
	}
	
	@Test // To test @Query with SQL
	public void testGetStudentInfoByClass(){
		StudentService studentService = context.getBean("studentService", StudentService.class);
		List<Student> studentList = studentService.getStudentInfoByClass("5");
		for(Student student : studentList) {
			System.out.println(student);
		}	
	}
	
	@Test // To test pagination with PageRequest
	public void testGetStudentInfoByStudentBirthplace(){
		StudentService studentService = context.getBean("studentService", StudentService.class);
		List<Student> studentList = studentService.getStudentInfoByStudentBirthplace("Pune",
				new PageRequest(1,3, Direction.ASC, "studentBirthplace"));
		for(Student student : studentList) {
			System.out.println(student);
		}	
	}
	
	@Test // To test @Param 
	public void testGetStudentInfoByStudentDobOrStudentClass(){
		StudentService studentService = context.getBean("studentService", StudentService.class);
		List<Student> studentList = studentService.getStudentInfoByStudentDobOrStudentClass("18-02-2009","5");
		for(Student student : studentList) {
			System.out.println(student);
		}	
	}
	
	@Test // To test Update studentPhone 
	public void testUpdateStudentPhoneById(){
		StudentService studentService = context.getBean("studentService", StudentService.class);
		studentService.updateStudentPhoneById(1, "7777755555");
	}
}
