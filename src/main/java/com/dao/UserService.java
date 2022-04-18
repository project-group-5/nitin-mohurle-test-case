package com.dao;

public class UserService {

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.User;

@Service

public class UserService {
	@Autowired
	UserDAO userDAOImpl;

	public void add(User user) {
		userDAOImpl.addUser(user);
		
	}
	public User find(int id) {
		return userDAOImpl.findUser(id);
	}
	public List<User> findAll(){
		return userDAOImpl.findAllUser();
	}
	public boolean update(User user) {
		return userDAOImpl.updateUser(user);
	}
	public boolean delete(User user) {
		return userDAOImpl.deleteUser(user);
	}
}

}
