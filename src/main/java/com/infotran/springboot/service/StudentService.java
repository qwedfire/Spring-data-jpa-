package com.infotran.springboot.service;

import java.util.List;

import com.infotran.springboot.model.Member;
import com.infotran.springboot.model.Student;

public interface StudentService {

	void save(Student studnet);
	List<Student>	 findAll();
	Student	 findById(Integer id);
	void	 deleteById(Integer id);
	Student   update(Student studnet);
	void   detach(Student studnet);
	
}
