package com.digitalaube.checkart.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalaube.checkart.bean.Motif;
import com.digitalaube.checkart.bean.Origine;
import com.digitalaube.checkart.bean.Tapis;
import com.digitalaube.checkart.bean.TapisMotif;
import com.digitalaube.checkart.bean.TapisOrigine;
import com.digitalaube.checkart.dao.MotifDao;
import com.digitalaube.checkart.dao.OrigineDao;
import com.digitalaube.checkart.dao.TapisDao;
import com.digitalaube.checkart.dao.TapisMotifDao;
import com.digitalaube.checkart.dao.TapisOrigineDao;
import com.digitalaube.checkart.service.TapisService;

@Service
public class TapisServiceImpl implements TapisService {

		@Autowired
		private TapisDao tapisDao;
		@Autowired
		OrigineDao origineDao;
		@Autowired
		MotifDao motifDao;
		@Autowired
		TapisOrigineDao tapisOrigineDao;
		@Autowired
		TapisMotifDao tapisMotifDao;
		@Override
		public Tapis save(Tapis tapis) {
			tapisDao.save(tapis);
			if(tapis.getTapis_origines() != null)
			{
				for (TapisOrigine tapis_origine : tapis.getTapis_origines()) {
					Origine origine = origineDao.findByRegion(tapis_origine.getOrigine().getregion());
					if (origine == null) {
						origine = tapis_origine.getOrigine();
						origineDao.save(origine);
					}
					tapis_origine.setOrigine(origine);
					tapis_origine.setTapis(tapis);
					tapisOrigineDao.save(tapis_origine);
				}
			} 
			
			
			if(tapis.getTapis_motifs() != null)
			{
				for (TapisMotif tapis_motif : tapis.getTapis_motifs()) {
					Motif motif = motifDao.findBySymbole(tapis_motif.getMotif().getSymbole());
					if (motif == null) {
						motif = tapis_motif.getMotif();
						motifDao.save(motif);
					}
					tapis_motif.setMotif(motif);
					tapis_motif.setTapis(tapis);
					tapisMotifDao.save(tapis_motif);
				}
			} 
			
			
			
			
			return tapisDao.save(tapis);
		}
		
		@Override
		public List<Tapis> findAll() {
			return tapisDao.findAll();
		}
		@Override
		public Tapis findByNom(String nom) {
			return tapisDao.findByNom(nom);
		}

		@Override
		public Tapis update(Long id, Tapis tapis) {
			
				return tapisDao.save(tapis);

		}

		@Override
		public void delete(Long id) {
			
			tapisDao.deleteById(id);
		}
}
