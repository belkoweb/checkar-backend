package com.digitalaube.checkart.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalaube.checkart.bean.Role;
import com.digitalaube.checkart.dao.RoleDao;
import com.digitalaube.checkart.service.RoleService;
@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleDao roleDao;
	@Override
	public void save(Role role) {
		roleDao.save(role);
		
	}

	@Override
	public List<Role> findAll() {
		// TODO Auto-generated method stub
		return roleDao.findAll();
	}

	@Override
	public Role findByLibelle(String libelle) {
		// TODO Auto-generated method stub
		return roleDao.findByLibelle(libelle);
	}

}
