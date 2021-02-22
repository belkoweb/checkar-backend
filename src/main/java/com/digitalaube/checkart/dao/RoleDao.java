package com.digitalaube.checkart.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digitalaube.checkart.bean.Origine;
import com.digitalaube.checkart.bean.Role;

@Repository
public interface RoleDao extends JpaRepository<Role, Long>{
	Role findByLibelle(String libelle);
}
