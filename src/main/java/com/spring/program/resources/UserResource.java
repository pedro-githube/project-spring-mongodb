package com.spring.program.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.program.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
   
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		User ricky = new User("1", "Ricky", "ricky@gmail.com");
		User alex = new User("2", "Alex", "alex@gmail.com");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(ricky,alex));
		return ResponseEntity.ok().body(list);
	}
}
