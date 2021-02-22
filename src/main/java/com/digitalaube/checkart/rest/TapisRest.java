package com.digitalaube.checkart.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.digitalaube.checkart.bean.Motif;
import com.digitalaube.checkart.bean.Origine;
import com.digitalaube.checkart.bean.Tapis;
import com.digitalaube.checkart.bean.TapisMotif;
import com.digitalaube.checkart.bean.TapisOrigine;
import com.digitalaube.checkart.service.TapisMotifService;
import com.digitalaube.checkart.service.TapisOrigineService;
import com.digitalaube.checkart.service.TapisService;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@RestController
@RequestMapping("checkart/tapis")
public class TapisRest {
	@Value("${upoadDir}")
	private String uploadFolder;

	@Autowired
	private TapisService tapisService ;
	
	@Autowired
	private TapisMotifService tapisMotifService ;
	
	@Autowired
	private TapisOrigineService tapisOrigineService ;
	

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@GetMapping(value = {"/", "/home"})
	public String addProductPage() {
		return "index";
	}
	
	@PostMapping("/tapis/savetapis")
	public @ResponseBody ResponseEntity<?> createTapis(@RequestParam("non") String nom,
			@RequestParam("description") String description,@RequestParam("couleur") String couleur, @RequestParam("taille") float taille, Model model, HttpServletRequest request
			,@RequestBody List<Motif> motifs,@RequestBody List<Origine> origines,final @RequestParam("image") MultipartFile file) {
		try {
			//String uploadDirectory = System.getProperty("user.dir") + uploadFolder;
			String uploadDirectory = request.getServletContext().getRealPath(uploadFolder);
			log.info("uploadDirectory:: " + uploadDirectory);
			String fileName = file.getOriginalFilename();
			String filePath = Paths.get(uploadDirectory, fileName).toString();
			log.info("FileName: " + file.getOriginalFilename());
			if (fileName == null || fileName.contains("..")) {
				model.addAttribute("invalid", "Sorry! Filename contains invalid path sequence \" + fileName");
				return new ResponseEntity<>("Sorry! Filename contains invalid path sequence " + fileName, HttpStatus.BAD_REQUEST);
			}
			//String[] names = name.split(",");
			//String[] descriptions = description.split(",");
			
			//log.info("Name: " + names[0]+" "+filePath);
			//log.info("description: " + descriptions[0]);
			//log.info("price: " + price);
			try {
				File dir = new File(uploadDirectory);
				if (!dir.exists()) {
					log.info("Folder Created");
					dir.mkdirs();
				}
				// Save the file locally
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
				stream.write(file.getBytes());
				stream.close();
			} catch (Exception e) {
				log.info("in catch");
				e.printStackTrace();
			}
			byte[] imageData = file.getBytes();
			Tapis tapis = new Tapis();
			TapisMotif tapisMotif = new TapisMotif();
			TapisOrigine tapisOrigine = new TapisOrigine();
			tapis.setNom(nom);
			tapis.setPhoto(imageData);
			tapis.setTaille(taille);
			tapis.setDescription(description);
			tapis.setCouleur(couleur);
			tapis.setDescription(description);
			tapis.setUri(filePath);
			tapisService.save(tapis);
			for (Motif m : motifs) {
				tapisMotif.setTapis(tapis);
				tapisMotif.setMotif(m);
				tapisMotifService.save(tapisMotif);
			}
			for (Origine o : origines) {
				tapisOrigine.setTapis(tapis);
				tapisOrigine.setOrigine(o);
				tapisOrigineService.save(tapisOrigine);
			}
		
			
			log.info("HttpStatus===" + new ResponseEntity<>(HttpStatus.OK));
			return new ResponseEntity<>("Tapis Saved With File - " + fileName, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Exception: " + e);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
