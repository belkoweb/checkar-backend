package com.digitalaube.checkart.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalaube.checkart.bean.Origine;
import com.digitalaube.checkart.dao.OrigineDao;
import com.digitalaube.checkart.service.OrigineService;

@Service
public class OrigineServiceImpl implements OrigineService  {
	
	@Autowired
	private OrigineDao origineDao;

	@Override
	public Origine save(Origine origine) {
		return origineDao.save(origine);
		
	}

	@Override
	public List<Origine> findAll() {
		return origineDao.findAll();
	}

	@Override
	public Origine findByRegion(String region) {
		
		return origineDao.findByRegion(region);
	}

	@Override
	public Origine findByNom(String nom) {
		// TODO Auto-generated method stub
		return origineDao.findByRegion(nom);
	}

	@Override
	public Origine findById(Long id) {
		// TODO Auto-generated method stub
		return origineDao.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		origineDao.deleteById(id);
		
	}

	@Override
	public Origine update(Long id, Origine origine) {
		// TODO Auto-generated method stub
		return origineDao.save(origine);
	}

}
