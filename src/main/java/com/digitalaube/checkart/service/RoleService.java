package com.digitalaube.checkart.service;

import java.util.List;

import com.digitalaube.checkart.bean.Rolev;

public interface RoleService  {
	public void save(Rolev role);
	public List<Rolev> findAll();
	public Rolev findByLibelle( String libelle);
}
