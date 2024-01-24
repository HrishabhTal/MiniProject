package com.project.miniproject.controller;

import java.net.URI;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.miniproject.entity.User;
import com.project.miniproject.service.UserService;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))

public class UserController {


	@Autowired
    private final UserService userService;

	private static final String USERENDPOINT = "/users";;
	
	@GetMapping(USERENDPOINT)
	public ResponseEntity<?> retrieveAllUsers() {
		List<User> response = userService.getAllUsers();
		return  ResponseEntity.ok().body(response);
	}

	
	
	@GetMapping(USERENDPOINT + "/{id}")
	public ResponseEntity<?> retrieveUser(@PathVariable int id) {
		
		User user = userService.findUser(id);

		if(user.getId() == null){
            String response = "User Not Found.";
            return ResponseEntity.status(404).body(response);
        }
		
		return ResponseEntity.ok().body(user);
	}
	
	
	@DeleteMapping(USERENDPOINT+"/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable int id) {
		userService.deleteUser(id);
		return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
	}

	
	@PostMapping(USERENDPOINT)
	public ResponseEntity<User> createUser(@RequestBody User user) {
		
		User response = userService.addUser(user);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
    
}
