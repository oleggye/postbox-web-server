package by.bsac.tcs.repository;

import by.bsac.tcs.model.EventLog;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EventLogRepository extends PagingAndSortingRepository<EventLog, Long> {

  List<EventLog> findAllByPostbox_IdOrderByIdDesc(final long postBoxId);

  @Query("select elog from EventLog elog join elog.postbox pb"
      + " where pb.id = :postBoxId and elog.id > :eventLogId order by elog.id")
  List<EventLog> findAllByPostbox_IdAndIdGreaterThanOrderById(
      @Param("postBoxId") final long postBoxId,
      @Param("eventLogId") final long eventLogId);

  Page<EventLog> findByPostbox_id(final long postBoxId, Pageable pageable);


}
