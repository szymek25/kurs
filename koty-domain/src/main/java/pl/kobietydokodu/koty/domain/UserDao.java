package pl.kobietydokodu.koty.domain;

import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User, String> {

}
