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
	public Motif save(Motif motif) {
		return motifDao.save(motif);
	}
	
	@Override
	public List<Motif> findAll() {
		return motifDao.findAll();
	}
	
	@Override
	public Motif findBySymbole(String signe) {
		return motifDao.findBySymbole(signe);
	}

	@Override
	public void delete(Long id) {
		motifDao.deleteById(id);
		
	}

	@Override
	public Motif update(Long id, Motif motif) {
		// TODO Auto-generated method stub
		return motifDao.save(motif);
	}
}
