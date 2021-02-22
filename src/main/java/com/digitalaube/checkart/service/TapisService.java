package com.digitalaube.checkart.service;

import java.util.List;

import com.digitalaube.checkart.bean.Tapis;

public interface TapisService {
	

		public void save(Tapis tapis);
		public List<Tapis> findAll();
		public Tapis findByNom( String nom);
	
}
