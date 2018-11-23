package com.mdy.student.web.student;

import com.mdy.student.bean.Page;
import com.mdy.student.bean.Student;
import com.mdy.student.exception.UserException;
import com.mdy.student.service.StudentService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/manager")
public class StudentController {
	private final StudentService studentService;

	@Autowired
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	// 查看学生信息界面
	@RequestMapping(value = "/viewStudent", method = RequestMethod.GET)
	public String viewStudent() {
		return "search";
	}

	// 檢索学生信息
	@RequestMapping(value = "/searchStudentJson", method = RequestMethod.POST, produces = "application/json")
	//表明返回json格式的数据
	@ResponseBody
	public Page<Student> searchStudentJson(Page<Student> pagebean) {
		return studentService.searchStudent(pagebean);
	}

	// 跳转添加学生界面
	@RequestMapping(value = "/addStudent", method = RequestMethod.GET)
	public String student() {
		return "add_student";
	}
	// 添加学生
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addStudent(ModelMap model, Student student) {
		model.addAttribute("name", student.getName());
		try {
			studentService.insertStudent(student);
		}catch(UserException e) {
			model.addAttribute("error", e.getMessage());
			return "add_student";
		}
		return "add_success";
	}

	// 跳转到修改学生信息界面
	@RequestMapping(value = "/editStudent", method = RequestMethod.GET)
	public String editStudent(String id, ModelMap model) {
		Student student = studentService.selectStudent(id);
		model.addAttribute("student", student);
		return "revise";
	}

	// 修改学生
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String edit(Student student, ModelMap model) {
		studentService.updateStudent(student);
		model.addAttribute("pagebean", model.get("pagebean"));
		return "search";
	}

	// 删除学生
	@RequiresRoles(value = "admin")
	@RequestMapping(value = "/delStudent", method = RequestMethod.GET)
	public String delStudent(String id, ModelMap model) {
		studentService.deleteStudent(id);
		model.addAttribute("name", id);
		return "search";
	}
}
