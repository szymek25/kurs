package pl.kobietydokodu.koty.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KotDao extends CrudRepository<Kot, String>
{
	public Kot findByImie(String imie);
}
