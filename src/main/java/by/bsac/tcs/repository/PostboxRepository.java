package by.bsac.tcs.repository;

import by.bsac.tcs.model.Postbox;
import java.util.Set;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostboxRepository extends CrudRepository<Postbox, Long> {

  Set<Postbox> findByUsers_Name(final String userName);

  Set<Postbox> findByUsers_Id(final long userId);
}
