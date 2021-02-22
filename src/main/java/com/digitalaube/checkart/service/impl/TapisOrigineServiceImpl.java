package com.digitalaube.checkart.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalaube.checkart.bean.TapisOrigine;
import com.digitalaube.checkart.dao.TapisOrigineDao;
import com.digitalaube.checkart.service.TapisOrigineService;

@Service
public class TapisOrigineServiceImpl implements TapisOrigineService {
			@Autowired
			private TapisOrigineDao tapisOrigineDao;
			
			@Override
			public void save(TapisOrigine tapisOrigine) {
					
				tapisOrigineDao.save(tapisOrigine);
			}
}
