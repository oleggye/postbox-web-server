package by.bsac.tcs.repository;

import by.bsac.tcs.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface ClientRepository extends CrudRepository<User, String> {

  User findByLogin(String login);
}
