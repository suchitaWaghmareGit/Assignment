package com.flowers1800.main.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flowers1800.main.model.User;
import com.flowers1800.main.repository.UserRepository;
import com.flowers1800.main.service.UserService;

@Service
public class UserServiceIMPL implements UserService{

	@Autowired
	UserRepository userRepository;
	
	

	

	@Override
	public void addSingleUser(User u) 
	{
	userRepository.save(u);
	}

	@Override
	public Iterable<User> saveAll(Iterable<User> users) {
		
		return userRepository.saveAll(users);
	}

	@Override
	public Iterable<User> findAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User save(User userToChange) {
		// TODO Auto-generated method stub
		return userRepository.save(userToChange);
	}

	@Override
	
	public Optional<User> findById(int id) {
		
		return userRepository.findById(id);
	}

	
}
