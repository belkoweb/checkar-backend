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
	public void save(Origine origine) {
		origineDao.save(origine);
		
	}

	@Override
	public List<Origine> findAll() {
		return origineDao.findAll();
	}

	@Override
	public Origine findByRegion(String region) {
		
		return origineDao.findByRegion(region);
	}

}
