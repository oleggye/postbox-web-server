package by.bsac.tcs.service;

import by.bsac.tcs.controller.dto.ReportMode;
import by.bsac.tcs.model.EventLog;
import by.bsac.tcs.model.Postbox;
import by.bsac.tcs.service.exception.PostBoxServiceException;
import by.bsac.tcs.service.exception.ServiceValidationException;
import java.util.List;
import java.util.Set;

public interface PostBoxService {

  void registration(final Postbox postBox)
      throws PostBoxServiceException, ServiceValidationException;

  void removePostBox(final Postbox postBox)
      throws PostBoxServiceException, ServiceValidationException;

  Postbox getPostBoxById(final long id);

  Set<Postbox> getPostBoxesByUserName(final String userName);

  Set<Postbox> getPostBoxesByUserId(final long userId);

  List<EventLog> getEventLogsForPostBox(final Postbox postBox);

  List<EventLog> getEventLogsForPostBox(final Postbox postBox, final ReportMode reportMode);

  long getLastCloseTime(final Postbox postbox);

  long getLastLetterTime(final Postbox postbox);

  List<EventLog> getEventLogsForPostBox(final Postbox postBox, final int count,
      final int pageNumber);

  int getLettersCount(Postbox postBox);
}
