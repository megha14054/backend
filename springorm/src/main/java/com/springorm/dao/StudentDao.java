package com.springorm.dao;

import java.util.List;

import javax.transaction.Transactional;

//import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.springorm.entities.Student;

//import jakarta.transaction.Transactional;

public class StudentDao {

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	private HibernateTemplate hibernateTemplate;
	
	//insert
	@Transactional
	public int insert(Student student) {
		
		Integer i=(Integer)this.hibernateTemplate.save(student);
		return i;
		
	}
	
	
	//get the single data
	public Student getStudent(int studentId) {
		Student student=this.hibernateTemplate.get(Student.class,studentId);
		return student;
	}
	
	//get all object
	
	public List<Student> getAllStudents(){
		List<Student> students=this.hibernateTemplate.loadAll(Student.class);
		return students;
	}
	
	//delete
	@Transactional
	public void deleteStudent(int studentId) {
		Student student=this.hibernateTemplate.get(Student.class,studentId);
		this.hibernateTemplate.delete(student);
		
	}
	
	//update
	@Transactional
	public void updateStudent(Student student)
	{
		this.hibernateTemplate.update(student);
		
	}
}
