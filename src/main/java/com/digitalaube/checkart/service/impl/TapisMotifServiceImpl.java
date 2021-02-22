package com.digitalaube.checkart.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.digitalaube.checkart.bean.TapisMotif;
import com.digitalaube.checkart.dao.TapisMotifDao;
import com.digitalaube.checkart.service.TapisMotifService;

public class TapisMotifServiceImpl implements TapisMotifService{
	@Autowired
	private TapisMotifDao tapisMotifDao;
	@Override
	public void save(TapisMotif tapisMotif) {
		tapisMotifDao.save(tapisMotif)		;
	}

}
