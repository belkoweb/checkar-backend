package com.digitalaube.checkart.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.digitalaube.checkart.bean.User;
import com.digitalaube.checkart.dao.UserDao;
import com.digitalaube.checkart.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	 @Autowired
	    private PasswordEncoder passwordEncoder;
	@Autowired
	private UserDao userDao;
	@Override
	public User save(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userDao.save(user);
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
		return userDao.findByEmail(email).orElse(null);	}

	@Override
	public void delete(Long id) {
		userDao.deleteById(id);
		
	}

	@Override
	public User update(Long id, User user) {
		// TODO Auto-generated method stub
		return userDao.save(user);
	}

	@Override
	public User findByEmailAndPassword(String email, String password) {
		return userDao.findByEmailAndPassword(email, passwordEncoder.encode(password));
	}
	
}
