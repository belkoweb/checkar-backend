package com.digitalaube.checkart.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digitalaube.checkart.bean.Tapis;
import com.digitalaube.checkart.bean.Tapiss;

@Repository
public interface TapissDao extends JpaRepository<Tapiss, Long> {
 Tapiss findByNom (String nom);
}