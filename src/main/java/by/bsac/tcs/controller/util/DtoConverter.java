package by.bsac.tcs.controller.util;

import by.bsac.tcs.controller.dto.EventLogDto;
import by.bsac.tcs.model.EventLog;
import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneId;

public final class DtoConverter {
private DtoConverter(){}

  public static EventLogDto convertToDto(final EventLog eventLog) {
    EventLogDto dto = new EventLogDto();

    dto.setId(eventLog.getId());
    dto.setEvent(eventLog.getEvent().getName());
    dto.setQuantity(eventLog.getQuantity());
    final LocalTime time = convertEpochToLocalDateTime(eventLog.getTime());
    dto.setTime(time);

    return dto;
  }

  private static LocalTime convertEpochToLocalDateTime(final long epochTime) {
    return Instant.ofEpochMilli(epochTime).atZone(ZoneId.systemDefault()).toLocalTime();
  }
}
