package pl.kobietydokodu.koty.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="kota")
public class Kot {
	@Id
	@Column(name="imie", nullable=false)
    private String imie;
    private Date dataUrodzenia;
	@Column(name="waga", nullable=false)
    private Float waga;
	@Column(name="imieOpiekuna", nullable=false)
    private String imieOpiekuna;
	@OneToMany(mappedBy="wlasciciel", fetch=FetchType.EAGER)
	private List<Zabawka> zabawki;

 

	public List<Zabawka> getZabawki() {
		return zabawki;
	}

	public void setZabawki(List<Zabawka> zabawki) {
		this.zabawki = zabawki;
	}

	public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public Date getDataUrodzenia() {
        return dataUrodzenia;
    }

    public void setDataUrodzenia(Date dataUrodzenia) {
        this.dataUrodzenia = dataUrodzenia;
    }

    public Float getWaga() {
        return waga;
    }

    public void setWaga(Float waga) {
        this.waga = waga;
    }

    public String getImieOpiekuna() {
        return imieOpiekuna;
    }

    public void setImieOpiekuna(String imieOpiekuna) {
        this.imieOpiekuna = imieOpiekuna;
    }


}

