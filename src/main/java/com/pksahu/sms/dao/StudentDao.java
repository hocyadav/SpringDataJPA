package com.pksahu.sms.dao;

import com.pksahu.sms.entities.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentDao extends CrudRepository<Student, Integer>{

}
