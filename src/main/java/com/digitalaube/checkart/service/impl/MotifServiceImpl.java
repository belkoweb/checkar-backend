package com.digitalaube.checkart.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalaube.checkart.bean.Motif;
import com.digitalaube.checkart.dao.MotifDao;
import com.digitalaube.checkart.service.MotifService;
@Service
public class MotifServiceImpl implements MotifService {
	@Autowired
	private MotifDao motifDao;
	
	@Override
	public void save(Motif motif) {
		motifDao.save(motif);
	}
	
	@Override
	public List<Motif> findAll() {
		return motifDao.findAll();
	}
	
	@Override
	public Motif findBySigne(String signe) {
		return motifDao.findBySigne(signe);
	}
}
