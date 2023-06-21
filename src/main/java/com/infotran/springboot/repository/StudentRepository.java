package com.infotran.springboot.repository;

import java.util.List;

import com.infotran.springboot.model.Member;
import com.infotran.springboot.model.Student;

public interface StudentRepository {
	
	void save(Student student);
	List<Student>	 findAll();
	Student	 findById(Integer id);
	void	 deleteById(Integer id);
	Student   update(Student student);
	void detach(Student student);
}
