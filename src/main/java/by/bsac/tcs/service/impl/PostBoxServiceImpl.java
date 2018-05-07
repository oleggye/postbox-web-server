package by.bsac.tcs.service.impl;

import static by.bsac.tcs.controller.dto.ReportMode.ModeName.LAST_N;
import static by.bsac.tcs.service.util.EntityMapper.mapToList;
import static java.util.Objects.nonNull;

import by.bsac.tcs.controller.dto.ReportMode;
import by.bsac.tcs.model.Event.EventType;
import by.bsac.tcs.model.EventLog;
import by.bsac.tcs.model.Postbox;
import by.bsac.tcs.repository.EventLogRepository;
import by.bsac.tcs.repository.PostboxRepository;
import by.bsac.tcs.service.PostBoxService;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

@Service
public class PostBoxServiceImpl implements PostBoxService {

  private static final int DEFAULT_PAGE_NUMBER = 0;

  private final PostboxRepository postboxRepository;
  private final EventLogRepository eventLogRepository;

  @Autowired
  public PostBoxServiceImpl(final PostboxRepository postboxRepository,
      EventLogRepository eventLogRepository) {
    this.postboxRepository = postboxRepository;
    this.eventLogRepository = eventLogRepository;
  }

  @Override
  public void registration(final Postbox postBox) {
    throw new UnsupportedOperationException("Not implemented!");
  }

  @Override
  public void removePostBox(final Postbox postBox) {
    throw new UnsupportedOperationException("Not implemented!");
  }

  public Postbox getPostBoxById(final long id) {
    return postboxRepository.findById(id).orElseThrow(
        () -> {
          final String errorMessage = String.format("No such postbox id:%s", id);
          return new IllegalArgumentException(errorMessage);
        });
  }

  @Override
  public Set<Postbox> getPostBoxesByUserName(final String userName) {
    return postboxRepository.findByUsers_Name(userName);
  }

  @Override
  public Set<Postbox> getPostBoxesByUserId(long userId) {
    return postboxRepository.findByUsers_Id(userId);
  }

  @Override
  public List<EventLog> getEventLogsForPostBox(final Postbox postBox) {
    final long postBoxId = postBox.getId();
    return eventLogRepository.findAllByPostbox_IdOrderByIdDesc(postBoxId);
  }

  @Override
  public List<EventLog> getEventLogsForPostBox(final Postbox postBox, final ReportMode reportMode) {

    if (LAST_N.equals(reportMode.getModeName())) {
      return getEventLogsForPostBox(postBox, reportMode.getItemsCount(), DEFAULT_PAGE_NUMBER);
    } else {

      final long postboxId = postBox.getId();
      long logId = reportMode.getLastLogId();
      return eventLogRepository
          .findAllByPostbox_IdAndIdGreaterThanOrderById(postboxId, logId);
    }
  }

  @Override
  public List<EventLog> getEventLogsForPostBox(final Postbox postBox, final int size,
      int pageNumber) {
    final long postboxId = postBox.getId();
    final Pageable pageable = PageRequest.of(pageNumber, size, Direction.DESC, "id");

    final Page<EventLog> pagedPostboxes = eventLogRepository
        .findByPostbox_id(postboxId, pageable);

    return mapToList(pagedPostboxes);
  }

  @Override
  public int getLettersCount(Postbox postBox) {
    final EventLog quantityChangedEvent = getLastEventLogByType(postBox,
        EventType.QUANTITY_CHANGED);
    final EventLog hasClosedEvent = getLastEventLogByType(postBox, EventType.HAS_CLOSED);

    final long quantityChangedEventTime =
        nonNull(quantityChangedEvent) ? quantityChangedEvent.getTime() : 0;

    final long hasClosedEventTime = nonNull(hasClosedEvent) ? hasClosedEvent.getTime() : 0;

    if (quantityChangedEventTime > hasClosedEventTime) {
      return nonNull(quantityChangedEvent) ? quantityChangedEvent.getQuantity() : 0;
    } else {
      return 0;
    }
  }

  @Override
  public long getLastCloseTime(Postbox postbox) {
    final EventType hasClosedEvent = EventType.HAS_CLOSED;
    return getTimeForEvent(postbox, hasClosedEvent);
  }

  @Override
  public long getLastLetterTime(Postbox postbox) {
    final EventType quantityChangedEvent = EventType.QUANTITY_CHANGED;
    return getTimeForEvent(postbox, quantityChangedEvent);
  }

  private long getTimeForEvent(final Postbox postbox, final EventType eventType) {
    final EventLog eventLog = getLastEventLogByType(postbox, eventType);
    return nonNull(eventLog) ? eventLog.getTime() : 0;
  }

  private EventLog getLastEventLogByType(final Postbox postbox, final EventType eventType) {
    final Optional<EventLog> quantityChangedEventLog = eventLogRepository
        .findFirstByPostboxIdAndEventNameOrderByIdDesc(postbox.getId(),
            eventType.name());

    return quantityChangedEventLog.orElse(null);
  }
}
