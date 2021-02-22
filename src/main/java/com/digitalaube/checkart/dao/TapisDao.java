package com.digitalaube.checkart.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digitalaube.checkart.bean.*;

@Repository
public interface TapisDao extends JpaRepository<Tapis, Long> {
 Tapis findByNom (String nom);
}