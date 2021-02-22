package com.digitalaube.checkart.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digitalaube.checkart.bean.Motif;

@Repository
public interface MotifDao extends JpaRepository<Motif, Long>{
	Motif findBySigne(String signe);
}
