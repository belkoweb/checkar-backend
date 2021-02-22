package com.digitalaube.checkart.service;

import java.util.List;

import com.digitalaube.checkart.bean.Origine;



public interface OrigineService {
	public void save(Origine origine);
	public List<Origine> findAll();
	public Origine findByRegion( String region);

}
