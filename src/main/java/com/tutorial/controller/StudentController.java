package com.tutorial.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.Impl.StudentServiceImpl;
import com.tutorial.entity.Student;

@RestController("/students")
public class StudentController {

	StudentServiceImpl studentServiceImpl;

	public StudentController(StudentServiceImpl studentServiceImpl) {
		super();
		this.studentServiceImpl = studentServiceImpl;
	}

	// List all the student
	@GetMapping("/list")
	public List<Student> listStudent() {
		return studentServiceImpl.ListStudent();
	}

	// add new student to database
	@PostMapping("/add")
	public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
		return new ResponseEntity<Student>(studentServiceImpl.AddStudent(student), HttpStatus.CREATED);
	}

	@PostMapping("/edit/{id}")
	public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
		Student existingStudent = studentServiceImpl.getStudentById(id);
		existingStudent.setFirstname(student.getFirstname());
		existingStudent.setLastname(student.getLastname());
		existingStudent.setEmail(student.getEmail());

		studentServiceImpl.UpdateStudent(existingStudent);

		return existingStudent;
	}

	
	// delete student
	@DeleteMapping("/delete/{id}")
	public String studentDelete(@PathVariable Long id) {

		// stores the form data from add student in student
		studentServiceImpl.DeleteStudent(id);
		return "DELETED";
	}

}
