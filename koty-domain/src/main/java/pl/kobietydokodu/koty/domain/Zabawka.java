package pl.kobietydokodu.koty.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="zab")
public class Zabawka {
	
	
	
	@Id
	private String nazwa;

	@ManyToOne
	private Kot wlasciciel;

	public Kot getWlasciciel() {
		return wlasciciel;
	}

	public void setWlasciciel(Kot imie) {
		this.wlasciciel = imie;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

}