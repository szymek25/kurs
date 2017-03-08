package pl.kobietydokodu.koty.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.kobietydokodu.koty.domain.KotDaoJpa;

@Service
public class DaoService {
	
	@Autowired
	public KotDaoJpa dao;

}
