package com.digitalaube.checkart.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.digitalaube.checkart.bean.User;

@Repository
public interface UserDao extends JpaRepository<User, Long>{
	User findByNom(String nom);
	User findByPrenom(String prenom);
	User findByEmail(String email);
}
