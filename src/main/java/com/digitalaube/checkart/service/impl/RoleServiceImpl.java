package com.digitalaube.checkart.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalaube.checkart.bean.Rolev;
import com.digitalaube.checkart.dao.RoleDao;
import com.digitalaube.checkart.service.RoleService;
@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleDao roleDao;
	@Override
	public void save(Rolev role) {
		roleDao.save(role);
		
	}

	@Override
	public List<Rolev> findAll() {
		// TODO Auto-generated method stub
		return roleDao.findAll();
	}

	@Override
	public Rolev findByLibelle(String libelle) {
		// TODO Auto-generated method stub
		return roleDao.findByLibelle(libelle);
	}

}
