package com.example.demo.service;

import java.util.List;
import java.util.Optional;


import com.example.demo.config.Student;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;
	public ResponseEntity<List<Student>> getUsers(){
		return new ResponseEntity<List<Student>>(userRepo.findAll(), HttpStatus.CREATED);
	}

	public ResponseEntity<?> addUser(Student student) {
		String responseMessage = null;
		Optional<Student> userByName = userRepo.findUserByName(student.getName());

		if (student.getName().isEmpty()) {
			if (userByName.isPresent()){
				throw new ResourceNotFoundException();
			}
 			throw new ResourceNotFoundException();

		}else {
			userRepo.save(student);
			return new ResponseEntity<String>("User Added", HttpStatus.ACCEPTED);
		}
	}

	public ResponseEntity<?> deleteUser(String name) {
		Optional<Student> deleteStudent = userRepo.findUserByName(name);
		if(deleteStudent.isPresent()){
			Student delUser = deleteStudent.get();
			Long ID = delUser.getId();
			userRepo.deleteById(ID);
			return new ResponseEntity<>(HttpStatus.RESET_CONTENT);
		}else {
			return new ResponseEntity<String>("User Not Found", HttpStatus.BAD_REQUEST);
		}
	}

	public String putUser(Long id, Student student) {
		try {
			Student updatedStudentRepo = userRepo.findUserByID(id).orElseThrow(() -> new IllegalStateException("User with ID" + id + "already exists"));
			updatedStudentRepo.setName(student.getName());
			updatedStudentRepo.setEmail(student.getEmail());
			userRepo.save(updatedStudentRepo);
			return "User Saved";
		}catch(Exception e){
			return e.getMessage();
		}
	}
}
