package com.tutorial.Impl;
import java.util.List;

import org.springframework.stereotype.Service;

import com.tutorial.entity.Student;
import com.tutorial.repository.StudentRepository;
import com.tutorial.service.StudentService;

@Service 
public class StudentServiceImpl implements StudentService {

	StudentRepository studentRepository;
	
	public StudentServiceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	
	@Override
	public Student AddStudent(Student student) {
		// TODO Auto-generated method stub
		
		return studentRepository.save(student);
	}

	@Override
	public Student UpdateStudent(Student student) {
		// TODO Auto-generated method stub
		return studentRepository.save(student);
	}

	
	@Override
	public void DeleteStudent(Long id) {
		// TODO Auto-generated method stub
		studentRepository.deleteById(id);
	}
	

	@Override
	public List<Student> ListStudent() {
		// list all student
		return studentRepository.findAll();
	}


	@Override
	public Student getStudentById(Long id) {
		// TODO Auto-generated method stub
		return studentRepository.findById(id).get();
	}

}
