package com.flowers1800.main.service;



import java.util.List;
import java.util.Optional;

import com.flowers1800.main.model.User;

public interface UserService 
{

public void addSingleUser(User u);
public Iterable<User> saveAll(Iterable<User> users);
public Iterable<User> findAll();
public User save(User userToChange);
public Optional<User> findById(int id);


}
