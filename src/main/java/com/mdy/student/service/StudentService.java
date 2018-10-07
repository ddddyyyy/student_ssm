package com.mdy.student.service;

import com.mdy.student.bean.Page;
import com.mdy.student.bean.Student;

public interface StudentService {
	
	Student selectStudent(String id);
	
	void insertStudent(Student student);

	void deleteStudent(String id);

	void updateStudent(Student student);
	
	Page<Student> searchStudent(Page<Student> page);
}
