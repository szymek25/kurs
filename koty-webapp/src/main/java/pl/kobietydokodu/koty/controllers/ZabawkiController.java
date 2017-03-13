package pl.kobietydokodu.koty.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.kobietydokodu.koty.domain.Kot;
import pl.kobietydokodu.koty.domain.Zabawka;
import pl.kobietydokodu.koty.dto.ZabawkaDTO;
import pl.kobietydokodu.koty.services.DaoService;

@Controller
public class ZabawkiController {
	
	@Autowired
	DaoService dao;
	
	@RequestMapping("/kot-{imie}/dodajZabawke")
	public String dodajZabawke(HttpServletRequest request,  @ModelAttribute("zabawkaDto") @Valid ZabawkaDTO zabawkaDto, BindingResult result, @PathVariable("imie") String imie, Model model) {
		model.addAttribute("kot", dao.kotDao.findByImie(imie));
		if (request.getMethod().equalsIgnoreCase("post") && !result.hasErrors()){
			Zabawka zabawka = new Zabawka();
			
			Kot kot = new Kot();
			kot = dao.kotDao.findByImie(imie);
			zabawka.setNazwa(zabawkaDto.getNazwa());
			zabawka.setWlasciciel(kot);
			dao.zabawkaDao.save(zabawka);
			return "redirect:/kot-{imie}";
		}
		return "dodajZabawke";
		}
	
	@RequestMapping("/kot-{imie}/usun/{zabawka}")
	public String usuwanieZabawki(@PathVariable("imie") String imie,@PathVariable("zabawka") String zabawka, Model model) {
		dao.zabawkaDao.delete(zabawka);;
		
		return "redirect:/kot-{imie}";
	}
}
