package com.digitalaube.checkart.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalaube.checkart.bean.Tapis;
import com.digitalaube.checkart.dao.TapisDao;
import com.digitalaube.checkart.service.TapisService;

@Service
public class TapisServiceImpl implements TapisService {

		@Autowired
		private TapisDao tapisDao;
		
		@Override
		public void save(Tapis tapis) {
			tapisDao.save(tapis);
		}
		
		@Override
		public List<Tapis> findAll() {
			return tapisDao.findAll();
		}
		@Override
		public Tapis findByNom(String nom) {
			return tapisDao.findByNom(nom);
		}
}
