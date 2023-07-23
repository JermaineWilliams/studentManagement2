package com.tutorial.service;

import java.util.List;

import com.tutorial.entity.Student;

public interface StudentService {
	List<Student> ListStudent();
	Student AddStudent(Student student);
	Student getStudentById(Long id);
	Student UpdateStudent(Student student);
	void DeleteStudent(Long id);
}

