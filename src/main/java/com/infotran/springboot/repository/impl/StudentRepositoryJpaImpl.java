package com.infotran.springboot.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.infotran.springboot.model.Student;
import com.infotran.springboot.repository.StudentRepository;

@Repository
public class StudentRepositoryJpaImpl implements StudentRepository{
	@PersistenceContext 
	EntityManager em;
	
	@Override
	public void save(Student student) {
		em.persist(student);
	}
	@Override
	public List<Student> findAll() {
		String hql = "FROM Student";
		return em.createQuery(hql, Student.class)
	             .getResultList();
	}
	@Override
	public Student findById(Integer id) {
		return em.find(Student.class, id);
	}
	@Override
	public void deleteById(Integer id) {
		Student student = em.find(Student.class, id);
		em.remove(student);
	}
	@Override
	public Student update(Student student) {
		// 如果傳入之物件沒有oid，則執行INSERT INTO SQL命令
		// 否則執行UPDATE SQL命令
		return em.merge(student);
	}
	@Override
	public void detach(Student student) {
		em.detach(student);    // session.evict(member);
	}

}
