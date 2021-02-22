package com.digitalaube.checkart.service;

import java.util.List;

import com.digitalaube.checkart.bean.Motif;

public interface MotifService {
	public void save(Motif motif);
	public List<Motif> findAll();
	public Motif findBySigne( String signe);
}
