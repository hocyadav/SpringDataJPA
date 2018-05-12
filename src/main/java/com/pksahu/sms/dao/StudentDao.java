package com.pksahu.sms.dao;

import com.pksahu.sms.entities.Student;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface StudentDao extends CrudRepository<Student, Integer>{

	List<Student> findByStudentName(String studentName);
	
	List<Student> findByStudentNameAndStudentClass(String studentName, String studentClass);
	
	@Query(value="SELECT s FROM Student s WHERE s.studentGender=?1")
	List<Student> getStudentInfoByGender(String studentGender);
	
	@Query(value="SELECT * FROM student_tbl WHERE student_class=?1", nativeQuery=true)
	List<Student> getStudentInfoByClass(String studentClass);
	
	List<Student> findByStudentBirthplace(String studentBirthplace, Pageable pageable);
	
	@Query("SELECT s FROM Student s WHERE s.studentDob=:studentDob Or s.studentClass=:studentClass")
	List<Student> findByStudentDobOrStudentClass(@Param("studentDob")String studentDob, 
												 @Param("studentClass")String studentClass);

	@Transactional
	@Modifying(clearAutomatically=true)
	@Query(value="UPDATE Student set studentPhone=:studentPhone WHERE studentId=:studentId")
	void updateStudentPhoneById(@Param("studentId")int studentId,
							    @Param("studentPhone") String studentPhone);
}
