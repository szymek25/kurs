package pl.kobietydokodu.koty.domain;

import org.springframework.data.repository.CrudRepository;

public interface AtachmentDao extends CrudRepository<Photo, String> {
	public Photo findBykot_imie(String imie);

}
