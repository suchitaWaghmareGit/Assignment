package com.flowers1800.main.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.flowers1800.main.model.User;
import com.flowers1800.main.service.UserService;


@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping("/saveSingleUser")
	public void addSingleUser(@RequestBody User user)
	{
		userService.addSingleUser(user);
	}

	
	@PostMapping("/save")
	@ResponseBody
	public String saveUsers(@RequestBody Iterable<User> users) {
		users = userService.saveAll(users);
		return  "Users saved successfully";

	}

	@GetMapping("/users/")
	public Integer getUsers()
	{
      List<User> list = new ArrayList<User>();
		Iterable<User> users = userService.findAll();
		for (User user : users) {
			list.add(user);
		}
		int count = (int) list.stream().count();
		System.out.println("no. of unique user ids:"+count);
		return count;
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateUser(@PathVariable("id") int id,@RequestBody User user){
		Optional<User> singleUser = userService.findById(id);
		User userToChange= singleUser.get();
		userToChange.setBody(user.getBody());
//		userToChange.setId(user.getId());
		userToChange.setTitle(user.getTitle());
//		userToChange.setUserId(user.getUserId());
		
		userToChange = userService.save(userToChange);
		System.out.println("updated user details:");
		System.out.println("id is:"+userToChange.getId());
		System.out.println("userid is"+userToChange.getUserId());
		
		System.out.println("title is"+userToChange.getTitle());
		System.out.println("body is"+userToChange.getBody());
		
		return ResponseEntity.ok().body(userToChange);
		
	}

	
	
}
