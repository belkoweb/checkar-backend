package com.digitalaube.checkart;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.digitalaube.checkart.bean.Motif;
import com.digitalaube.checkart.bean.Origine;
import com.digitalaube.checkart.bean.Role;
import com.digitalaube.checkart.bean.Tapis;
import com.digitalaube.checkart.bean.TapisMotif;
import com.digitalaube.checkart.bean.TapisOrigine;
import com.digitalaube.checkart.bean.Tapiss;
import com.digitalaube.checkart.bean.User;
import com.digitalaube.checkart.dao.MotifDao;
import com.digitalaube.checkart.dao.OrigineDao;
import com.digitalaube.checkart.dao.TapisDao;
import com.digitalaube.checkart.dao.TapisMotifDao;
import com.digitalaube.checkart.dao.TapisOrigineDao;
import com.digitalaube.checkart.dao.TapissDao;
import com.digitalaube.checkart.dao.UserDao;

@SpringBootApplication
public class CheckArtApplication implements CommandLineRunner{
	@Autowired
	private UserDao userDao;
	@Autowired
	private TapisDao tapisDao;
	@Autowired
	private MotifDao motifDao;
	@Autowired
	private OrigineDao origineDao;
	 @Autowired
	    private PasswordEncoder passwordEncoder;
	 @Autowired
	private TapisOrigineDao tapisOrigineDao;
	 @Autowired
	 TapisMotifDao   tapisMotifDao;
	 
	 @Autowired
		private TapissDao tapissDao;
	public static void main(String[] args) {
		SpringApplication.run(CheckArtApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		   Tapis tapis1 = new Tapis("Azlal", "SSSSSSSSSSSSSSSSSSS",25, "blue");
	        Tapis tapis2 = new Tapis("Azlal", "SSSSSSSSSSSSSSSSSSS",25, "blue");
	        Tapis tapis3 = new Tapis("Azlal", "SSSSSSSSSSSSSSSSSSS",25, "blue");
		
		tapisDao.save(tapis1);
		tapisDao.save(tapis2);
		tapisDao.save(tapis3);
		
		
		Stream.of("Marrakech", "Rabat", "Agadir", "Tanger").forEach(region -> {
			Origine origine = new Origine();
	
 	       origine.setregion(region);
			origineDao.save(origine);
			

 	     	TapisOrigine tapisOrigine1 = new TapisOrigine(tapis1, origine);
			TapisOrigine tapisOrigine2 = new TapisOrigine(tapis2, origine);
			TapisOrigine tapisOrigine3 = new TapisOrigine(tapis3, origine);
			
			tapisOrigineDao.save(tapisOrigine1);
 			tapisOrigineDao.save(tapisOrigine2);
 			tapisOrigineDao.save(tapisOrigine3);
			
 		


 		

		});
		
		Stream.of("Losange", "Caree", "Chevron", "Traits").forEach(symbole -> {
			Motif motif = new Motif();
			motif.setSignification("ooooooooooooooooooooooooooooooooooo");
			motif.setSymbole(symbole);
 			motifDao.save(motif);
 			
 			TapisMotif tapisMotif1 = new TapisMotif(tapis1, motif);

 			TapisMotif tapisMotif2 = new TapisMotif(tapis2, motif);

 			TapisMotif tapisMotif3 = new TapisMotif(tapis3, motif);
 			
 			tapisMotifDao.save(tapisMotif1);
 			tapisMotifDao.save(tapisMotif2);
 			tapisMotifDao.save(tapisMotif3);
			

		});
		
		
		
		 Tapiss tapis11 = new Tapiss();
		 tapis11.setNom("GRAND TAPIS ZANAFI");
		 tapis11.setCouleur("Noir, gris, blanc");
		 tapis11.setDescription(" Le tapis Zanafi se distingue par ses motifs à votre intérieur. ");
		 tapis11.setTaille("315x185 cm");
		 tapis11.setOrigine("Origine: Haut Atlas marocain");
		 tapis11.setMotif("Motis: Losange, le losange représente \nla fécondité et la maternité");
		 tapis11.setUri("azilal");
		  tapissDao.save(tapis11);

		  Tapiss tapiss2 = new Tapiss();
		  tapiss2.setNom("GRAND TAPIS ZANAFI");
		  tapiss2.setCouleur("Noir, gris, blanc");
		  tapiss2.setDescription(" Le tapis Zanafi se distingue par ses motifs intérieur. ");
		  tapiss2.setTaille("315x185 cm");
		  tapiss2.setOrigine("Origine: Haut Atlas marocain");
		  tapiss2.setMotif("Motis: Losange, le losange représente \nla fécondité et la maternité");
		  tapiss2.setUri("azilal");
		  
		  tapissDao.save(tapiss2);
		 
		 Tapiss tapis33 = new Tapiss();
	        tapis33.setNom("TAPIS BERBERE BOUJAD");
	        tapis33.setCouleur("Noir, Blanc");
	        tapis33.setDescription("Magnifique tapis berbère de la ville de Boujad");
	        tapis33.setMotif("Motis: Lignes en forme de zig-zag, une ligne en forme de zig-zag");

	        tapis33.setTaille("370x185 cm");
	        tapis33.setOrigine("Origine: Boujad");
	        tapis33.setUri("azilal");
	        tapissDao.save(tapis33);
		
		User admin = new User();
		admin.setEmail("belkoweb@gmail.com");
		admin.setPassword(passwordEncoder.encode("12345"));
		admin.setNom("Soumana Abdou");
		admin.setPrenom("Amadou");
		admin.setRole(Role.ADMIN);
		admin.setTel("555555555555");
		
		userDao.save(admin);
		User user1 = new User("Amadou", "Soumana", "gor@gmail.com", passwordEncoder.encode("12345"), "00000555", Role.ADMIN);
		User user2 = new User("AmadouY", "SoumanaY", "gory@gmail.com",passwordEncoder.encode("12345"), "00000555", Role.USER);

		User user3 = new User("AmadouZ", "SoumanaZ", "gorz@gmail.com", passwordEncoder.encode("12345"), "00000555", Role.USER);
		
		userDao.save(user1);
		userDao.save(user2);
		userDao.save(user2);
        

		
		
		
	}

}
