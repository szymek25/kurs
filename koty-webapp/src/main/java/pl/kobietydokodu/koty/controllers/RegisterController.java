package pl.kobietydokodu.koty.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.kobietydokodu.koty.domain.User;
import pl.kobietydokodu.koty.dto.KotDTO;
import pl.kobietydokodu.koty.dto.UserDTO;
import pl.kobietydokodu.koty.services.DaoService;

@Controller
public class RegisterController {
	
	@Autowired
	DaoService dao;
	
	@RequestMapping("/")
	public String login(Model model) {
		
		return "login";
	}
	
	@RequestMapping("/rejestracja")
	public String dodajuzytkownika(HttpServletRequest request,  @ModelAttribute("userDto") @Valid UserDTO userDto, BindingResult result) {
		if (request.getMethod().equalsIgnoreCase("post") && !result.hasErrors()){
			User user = new User();
			
			user.setUsername(userDto.getUsername());
			user.setPassword(userDto.getPassword());
			
			dao.userDao.save(user);
			return "redirect:/";
		}

		return "rejestracja";
	}
}
