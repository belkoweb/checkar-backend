package com.digitalaube.checkart.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalaube.checkart.bean.User;
import com.digitalaube.checkart.dao.UserDao;
import com.digitalaube.checkart.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		userDao.save(user);
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userDao.findAll();
	}

	@Override
	public User findByNom(String nom) {
		// TODO Auto-generated method stub
		return userDao.findByNom(nom);
	}

	@Override
	public User findByPrenom(String prenom) {
		// TODO Auto-generated method stub
		return userDao.findByPrenom(prenom);
	}

	@Override
	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		return userDao.findByEmail(email);
	}
	
}
