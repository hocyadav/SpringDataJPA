package com.pksahu;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
		student.setStudentName("Ram");
		student.setStudentDob("16-05-2002");
		student.setStudentClass("10");
		student.setStudentBirthplace("Pune");
		student.setStudentGender("Male");
		student.setStudentPhone("9999955555");
		
		studentService.createStudent(student);
	}
	
	@Test
	public void testGetStudentById(){
		StudentService studentService = context.getBean("studentService", StudentService.class);
		Student student = studentService.getStudentById(2);
		System.out.println(student);
	}
	
	@Test
	public void testGetAllBookedStudent(){
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
}
