package pl.kobietydokodu.koty.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class KotDAO {

	@PersistenceContext
    EntityManager entityManager;
	
	List<Kot> koty = new ArrayList<Kot>();
	
	
	public void dodajKota(Kot kot) {
		//koty.add(kot);
		entityManager=entityManager.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.merge(kot);
		entityManager.getTransaction().commit();
	}
	
	public List<Kot> getKoty() {
		koty = getKotyByDatabase();
		return koty;
	}
	
	public Kot getKotById(Integer id) {
		koty = getKotyByDatabase();
		
		if (id<koty.size()) {
			return koty.get(id);
		} else {
			return null;
		}
	}
	
	public List<Kot> getKotyByDatabase()
	{
		Query query = entityManager.createQuery("SELECT k FROM Kot k");
		List<Kot> koty = query.getResultList();
		return koty;
	}
	
}
