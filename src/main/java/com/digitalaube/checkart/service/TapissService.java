package com.digitalaube.checkart.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.digitalaube.checkart.bean.Tapis;
import com.digitalaube.checkart.bean.Tapiss;

public interface TapissService {
	

	public Tapiss save(Tapiss tapiss);
	public List<Tapiss> findAll();
	public Tapiss findByNom( String nom);
	public Tapiss update(Long id, Tapiss tapiss);
	public void delete(Long id);

}
