package pl.kobietydokodu.koty.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.kobietydokodu.koty.domain.KotDao;
import pl.kobietydokodu.koty.domain.UserDao;
import pl.kobietydokodu.koty.domain.ZabawkaDAO;

@Service
public class DaoService {
	
	@Autowired
	public KotDao kotDao;
	
	@Autowired
	public ZabawkaDAO zabawkaDao;
	
	@Autowired
	public UserDao userDao;

}
