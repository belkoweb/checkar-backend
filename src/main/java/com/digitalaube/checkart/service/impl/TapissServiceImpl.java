package com.digitalaube.checkart.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalaube.checkart.bean.Motif;
import com.digitalaube.checkart.bean.Origine;
import com.digitalaube.checkart.bean.Tapis;
import com.digitalaube.checkart.bean.TapisMotif;
import com.digitalaube.checkart.bean.TapisOrigine;
import com.digitalaube.checkart.bean.Tapiss;
import com.digitalaube.checkart.dao.MotifDao;
import com.digitalaube.checkart.dao.OrigineDao;
import com.digitalaube.checkart.dao.TapisDao;
import com.digitalaube.checkart.dao.TapisMotifDao;
import com.digitalaube.checkart.dao.TapisOrigineDao;
import com.digitalaube.checkart.dao.TapissDao;
import com.digitalaube.checkart.service.TapisService;
import com.digitalaube.checkart.service.TapissService;

@Service
public class TapissServiceImpl implements TapissService {

		@Autowired
		private TapissDao  tapissDao;

		@Override
		public  Tapiss save( Tapiss tapiss) {
			return tapissDao.save( tapiss);
		}
		
		@Override
		public List<Tapiss> findAll() {
			return tapissDao.findAll();
		}
		@Override
		public Tapiss findByNom(String nom) {
			return tapissDao.findByNom(nom);
		}

		@Override
		public Tapiss update(Long id, Tapiss tapiss) {
			
				return tapissDao.save(tapiss);

		}

		@Override
		public void delete(Long id) {
			
			tapissDao.deleteById(id);
		}
}
