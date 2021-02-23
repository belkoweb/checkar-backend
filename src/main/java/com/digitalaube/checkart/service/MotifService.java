package com.digitalaube.checkart.service;

import java.util.List;

import com.digitalaube.checkart.bean.Motif;

public interface MotifService {
	public Motif save(Motif motif);
	public List<Motif> findAll();
	public Motif findBySymbole( String signe);
	public void delete(Long id);
	public Motif update(Long id, Motif motif);
}
