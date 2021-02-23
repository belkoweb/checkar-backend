package com.digitalaube.checkart.service;

import java.util.List;
import java.util.Optional;

import com.digitalaube.checkart.bean.User;

public interface UserService {
	public User save(User user);
	public List<User> findAll();
	public User findByNom( String nom);
	public User findByPrenom( String prenom);
	public User  findByEmail( String email);
	public void delete(Long id);
	public User update(Long id, User user);
}
