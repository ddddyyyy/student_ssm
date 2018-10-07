package com.mdy.student.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mdy.student.bean.Page;
import com.mdy.student.bean.Student;
import com.mdy.student.exception.UserException;
import com.mdy.student.mapper.StudentMapper;

@Service
public class StudentService implements com.mdy.student.service.StudentService {

	@Autowired(required = true)
	private StudentMapper studentMapper;

	@Override
	@Transactional
	public void insertStudent(Student student){
		if(studentMapper.selectStudent(student.getName())==null) {
			studentMapper.newStudent(student);
		}
		else {
			throw new UserException("该学生已存在");
		}
	}

	@Override
	@Transactional
	public void deleteStudent(String id) {
		studentMapper.delStudent(id);
	}

	@Override
	@Transactional
	public void updateStudent(Student student) {
		studentMapper.updateStudent(student);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Student> searchStudent(Page<Student> page) {
		page.setList(studentMapper.searchStudent(page));
		page.setTotalDate(studentMapper.getStudentNum(page));
		return page;
	}

	@Override
	@Transactional(readOnly = true)
	public Student selectStudent(String id) {
		return studentMapper.selectStudent(id);
	}
}
