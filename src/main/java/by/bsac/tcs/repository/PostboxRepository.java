package by.bsac.tcs.repository;

import by.bsac.tcs.model.Postbox;
import java.util.Set;
import org.springframework.data.repository.CrudRepository;

public interface PostboxRepository extends CrudRepository<Postbox, Long> {

  Set<Postbox> findByUsers_Name(final String userName);
}
