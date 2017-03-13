package pl.kobietydokodu.koty.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZabawkaDAO extends CrudRepository<Zabawka, String> {

}
