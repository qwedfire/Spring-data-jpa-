package com.infotran.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.infotran.springboot.model.Student;
import com.infotran.springboot.service.StudentService;

@Controller
public class StudentController {
	final static Logger log = LoggerFactory.getLogger(StudentController.class);
	StudentService studentService;
	@Autowired
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}
	
	@GetMapping("/saveStudent/{id}/{name}")
	public void save(@PathVariable("id") Integer id, @PathVariable("name") String name) {
		Student student=new Student();
		student.setId(id);
		student.setName(name);
		studentService.save(student);
		log.info("我使用了saveStudent方法-------------------------");
	}
	@GetMapping("/findStudentById/{id}")
	public void findStudentById(@PathVariable("id") Integer id) {
		log.info("查詢結果為--------------------"+studentService.findById(id));
	}
	@GetMapping("/deleteStudents/{id}")
	public void deletById(@PathVariable("id") Integer id) {
		studentService.deleteById(id);
		log.info("我使用了deleteStudent方法-------------------------");
	}
	
}
