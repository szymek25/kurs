package pl.kobietydokodu.koty.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.kobietydokodu.koty.domain.Kot;
import pl.kobietydokodu.koty.services.DaoService;

@Controller
@RequestMapping("/rest")
public class KotyApiController {
	
	@Autowired
	DaoService daoService;
	
	@RequestMapping(value="/{imie}", method=RequestMethod.GET)
	 public ResponseEntity<Kot> get(@PathVariable("imie") String imie) {
	 Kot kot = daoService.kotDao.findByImie(imie);
	 return new ResponseEntity<Kot>(kot, new HttpHeaders(), HttpStatus.OK);
	 
	 }
}
