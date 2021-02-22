package com.digitalaube.checkart.service;

import java.util.List;


import com.digitalaube.checkart.bean.User;

public interface UserService {
	public void save(User user);
	public List<User> findAll();
	public User findByNom( String nom);
	public User findByPrenom( String prenom);
	public User findByEmail( String email);
}
