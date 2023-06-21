package com.infotran.springboot.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infotran.springboot.model.Student;
import com.infotran.springboot.repository.StudentRepository;
import com.infotran.springboot.service.StudentService;
import com.infotran.springboot.service.StudentService;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
	
	final static Logger log = LoggerFactory.getLogger(StudentServiceImpl.class);
	
	StudentRepository StudentRepository;
	
	@Autowired
	public StudentServiceImpl(StudentRepository StudentRepository) {
		this.StudentRepository = StudentRepository;
	}
	
	@Override
	public void save(Student student) {
		log.info("=====>StudentRepository#save()");
		StudentRepository.save(student);
	}
	
	@Override
	public List<Student> findAll() {
		log.info("=====>StudentRepository#findAll()");
		return StudentRepository.findAll();
	}
	
	@Override
	public Student findById(Integer id) {
		log.info("=====>StudentRepository#findById()");
//		Optional<Student> opt = StudentRepository.findById(id); 
		Student student = StudentRepository.findById(id); 
		return student;
	}
	
	@Override
	public void deleteById(Integer id) {
		log.info("=====>StudentRepository#deleteById()");
		StudentRepository.deleteById(id);
	}
	
	@Override
	public Student update(Student student) {
		log.info("=====>StudentRepository#update()");
		return StudentRepository.update(student);
	}

	@Override
	public void detach(Student student) {
		log.info("=====>StudentRepository#findByStudentId()");
		StudentRepository.detach(student);
	}
}
