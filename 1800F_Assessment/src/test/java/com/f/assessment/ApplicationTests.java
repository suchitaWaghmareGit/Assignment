package com.f.assessment;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.flowers1800.main.Application;
import com.flowers1800.main.model.User;
import com.flowers1800.main.repository.UserRepository;
import com.flowers1800.main.service.UserService;


@SpringBootTest(classes = Application.class)
class ApplicationTests {
	@MockBean
private UserRepository userrepository;

@Autowired
private UserService userservice;
@Test
public void getusersTest()
{
when(userrepository.findAll()).
thenReturn(Stream.of(new User(11,102,"new title","new body"),new User(18,103,"new title1","new body2")).
		collect(Collectors.toList()));	
assertEquals(2, ((List<User>) userservice.findAll()).size());
}

//@Test
//public void updateUserTest()
//{
//	int id=11;
//	when(userrepository.findById(id)).thenReturn(Stream.of(new User(11,102,"new title","new body")).collect(Collectors.toList()));
//	assertEquals(1, userservice.findById(id));
//}
	

@Test
public void saveUsersTest()
{
	User user=new User(99,205,"savenewuser","savenewuserbody");
	
	when(userrepository.save(user)).thenReturn(user);
	assertEquals(user, userservice.save(user));
}
}
