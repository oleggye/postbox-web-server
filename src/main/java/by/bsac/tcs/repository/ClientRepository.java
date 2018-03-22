package by.bsac.tcs.repository;

import by.bsac.tcs.model.User;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<User, String> {

  User findByLogin(String login);
}
