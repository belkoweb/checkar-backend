package com.digitalaube.checkart.rest;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity.BodyBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.digitalaube.checkart.bean.Motif;
import com.digitalaube.checkart.bean.Origine;
import com.digitalaube.checkart.bean.Tapis;
import com.digitalaube.checkart.bean.TapisMotif;
import com.digitalaube.checkart.bean.TapisOrigine;
import com.digitalaube.checkart.bean.User;
import com.digitalaube.checkart.service.FileService;
import com.digitalaube.checkart.service.MotifService;
import com.digitalaube.checkart.service.OrigineService;
import com.digitalaube.checkart.service.TapisService;
import com.digitalaube.checkart.service.UserService;

@RestController
@RequestMapping("/checkart/api/admin")
public class AdminRest {
	 @Autowired
	    private UserService userService;

	    @Autowired
	    private OrigineService origineService;

	    @Autowired
	    private MotifService motifService;

	    @Autowired
	    private TapisService tapisService;
	    @Autowired
	    FileService fileService;
	    
	    String subPath = "tapis";
	    

	    @PutMapping("/user-update")
	    public ResponseEntity<?> updateUser(@RequestBody User user) {
	        User existuser =userService.findByEmail(user.getEmail());
	        if (existuser != null && !existuser.getId().equals(user.getId())) {
	            return new ResponseEntity<>(HttpStatus.CONFLICT);
	        }
	        return new ResponseEntity<>(userService.update(user.getId(),user), HttpStatus.CREATED);
	    }

	    @PostMapping("/user-delete")
	    public ResponseEntity<?> deleteUser(@RequestBody User user){
	       userService.delete(user.getId());
	        return new ResponseEntity<>(HttpStatus.OK);
	    }
	    @PostMapping("/user-create")
	    public ResponseEntity<?> createUser(@RequestBody User user){
	       return new ResponseEntity<>( userService.save(user), HttpStatus.CREATED);
	    }


	    @GetMapping("/user-all")
	    public ResponseEntity<?> findAllusers(){
	        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
	    }

	
	    @PostMapping("/origine-create")
	    public ResponseEntity<?> createOrigine(@RequestBody Origine Origine){
	        return new ResponseEntity<>(origineService.save(Origine), HttpStatus.CREATED);
	    }

	    @PutMapping("/origine-update")
	    public ResponseEntity<?> updateOrigine(@RequestBody Origine origine){
	        return new ResponseEntity<>(origineService.update(origine.getId(),origine), HttpStatus.CREATED);
	    }

	    @PostMapping("/origine-delete")
	    public ResponseEntity<?> deleteOrigine(@RequestBody Origine Origine){
	        origineService.delete(Origine.getId());
	        return new ResponseEntity<>(HttpStatus.OK);
	    }

	    @GetMapping("/origine-all")
	    public ResponseEntity<?> findAllOrigines(){
	        return new ResponseEntity<>(origineService.findAll(), HttpStatus.OK);
	    }

		
	    @PostMapping("/motif-create")
	    public ResponseEntity<?> createMotif(@RequestBody Motif motif){
	        return new ResponseEntity<>(motifService.save(motif), HttpStatus.CREATED);
	    }

	    @PutMapping("/motif-update")
	    public ResponseEntity<?> updateMotif(@RequestBody Motif motif){
	        return new ResponseEntity<>(motifService.update(motif.getId(),motif), HttpStatus.CREATED);
	    }

	    @PostMapping("/motif-delete")
	    public ResponseEntity<?> deleteMotif(@RequestBody Motif motif){
	    	motifService.delete(motif.getId());
	        return new ResponseEntity<>(HttpStatus.OK);
	    }

	    @GetMapping("/motif-all")
	    public ResponseEntity<?> findAllMotifs(){
	        return new ResponseEntity<>(motifService.findAll(), HttpStatus.OK);
	    }
	    
	    
	    
	    
	    @PostMapping("/tapis-create")
	    public ResponseEntity<?> createTapis( @RequestParam(value = "nom") String nom,
				@RequestParam(value =  "description") String description, @RequestParam(value ="taille") Float taille, @RequestParam(value ="couleur") String couleur, @RequestParam(value ="tapis_origines") List<TapisOrigine> tapis_origines, @RequestParam(value ="tapis_motifs") List<TapisMotif> tapis_motifs, @RequestParam(value = "image",required = false) MultipartFile file){
	    	String imageName = "product.jpg";

			if (file != null) {
				imageName = fileService.saveFile(file, this.subPath);
			}
			
			Tapis  tapis = new Tapis();
			tapis.setNom(nom);
			tapis.setDescription(description);
			tapis.setTaille(78);
			tapis.setCouleur(couleur);
			tapis.setTapis_origines(tapis_origines);
			tapis.setTapis_motifs(tapis_motifs);
			tapis.setUri(imageName);
			
	    	System.out.println(tapis.getNom());
	        return new ResponseEntity<>(tapisService.save(tapis), HttpStatus.CREATED);
	    }

	    @PutMapping("/tapis-update")
	    public ResponseEntity<?> updateTapis(@RequestBody Tapis tapis){
	        return new ResponseEntity<>(tapisService.update(tapis.getId(),tapis), HttpStatus.CREATED);
	    }

	    @PostMapping("/tapis-delete")
	    public ResponseEntity<?> deleteTapis(@RequestBody Tapis tapis){
	    	tapisService.delete(tapis.getId());
	        return new ResponseEntity<>(HttpStatus.OK);
	    }

	    @GetMapping("/tapis-all")
	    public ResponseEntity<?> findAllTapis(){
	        return new ResponseEntity<>(tapisService.findAll(), HttpStatus.OK);
	    }
	    
	/*	@PostMapping
		public ResponseEntity create(@RequestParam(name = "image",required = false) MultipartFile file, @RequestParam("name") String name,
				@RequestParam("description") String description, @RequestParam("price") float price) {

			String imageName = "product.jpg";

			if (file != null) {
				imageName = fileService.saveFile(file, this.subPath);
			}

			//Product product = new Product();

			product.setName(name);
			product.setDescription(description);
			product.setPrice(price);
			product.setImage(imageName);

			return ResponseEntity.ok(serviceProduct.save(product));
		}*/
	    
	       
	   

}