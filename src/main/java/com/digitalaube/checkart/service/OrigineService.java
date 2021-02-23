package com.digitalaube.checkart.service;

import java.util.List;

import com.digitalaube.checkart.bean.Origine;



public interface OrigineService {
	public Origine save(Origine origine);
	public List<Origine> findAll();
	public Origine findByRegion( String region);
	public Origine findByNom(String nom);
	public Origine findById(Long id);
	public void delete(Long id);
	public Origine update(Long id, Origine origine);		// TODO Auto-generated method stub
	

}
