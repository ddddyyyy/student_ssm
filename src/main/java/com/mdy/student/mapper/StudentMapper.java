package com.mdy.student.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mdy.student.bean.Page;
import com.mdy.student.bean.Student;

@Repository
public interface StudentMapper {
	
	Student selectStudent(String id);
	
	void newStudent(Student student);

	void delStudent(String id);

	void updateStudent(Student student);

	List<Student> searchStudent(Page<Student> page);
	
	long getStudentNum(Page<Student> page);
}
