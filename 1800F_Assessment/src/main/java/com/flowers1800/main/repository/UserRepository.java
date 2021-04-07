package com.flowers1800.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.flowers1800.main.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	
	
}
