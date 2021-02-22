package com.digitalaube.checkart.service;

import java.util.List;

import com.digitalaube.checkart.bean.Role;

public interface RoleService  {
	public void save(Role role);
	public List<Role> findAll();
	public Role findByLibelle( String libelle);
}
