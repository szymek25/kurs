package pl.kobietydokodu.koty.dto;

import org.hibernate.validator.constraints.NotBlank;

public class ZabawkaDTO {
	
	@NotBlank
	private String nazwa;
	
	private String wlasciciel;

	public String getWlasciciel() {
		return wlasciciel;
	}

	public void setWlasciciel(String wlasciciel) {
		this.wlasciciel = wlasciciel;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

}
