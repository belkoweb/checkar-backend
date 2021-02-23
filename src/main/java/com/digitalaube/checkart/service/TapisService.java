package com.digitalaube.checkart.service;

import java.util.List;

import com.digitalaube.checkart.bean.Tapis;

public interface TapisService {
	

		public Tapis save(Tapis tapis);
		public List<Tapis> findAll();
		public Tapis findByNom( String nom);
		public Tapis update(Long id, Tapis tapis);
		public void delete(Long id);
	
}
