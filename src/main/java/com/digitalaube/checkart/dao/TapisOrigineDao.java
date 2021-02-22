package com.digitalaube.checkart.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digitalaube.checkart.bean.TapisOrigine;

@Repository
public interface TapisOrigineDao extends JpaRepository<TapisOrigine, Long>{

}
