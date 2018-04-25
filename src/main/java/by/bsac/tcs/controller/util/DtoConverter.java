package by.bsac.tcs.controller.util;

import by.bsac.tcs.controller.dto.EventLogDto;
import by.bsac.tcs.controller.dto.PostBoxDto;
import by.bsac.tcs.controller.dto.UserDto;
import by.bsac.tcs.model.EventLog;
import by.bsac.tcs.model.Postbox;
import by.bsac.tcs.model.User;
import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneId;

public final class DtoConverter {

  private DtoConverter() {
  }

  public static EventLogDto convertToDto(final EventLog eventLog) {
    final EventLogDto dto = new EventLogDto();

    dto.setId(eventLog.getId());
    dto.setEvent(eventLog.getEvent().getName());
    dto.setQuantity(eventLog.getQuantity());
    final LocalTime time = convertEpochToLocalDateTime(eventLog.getTime());
    dto.setTime(time);

    return dto;
  }

  public static PostBoxDto convertToDto(final Postbox postbox) {
    final PostBoxDto dto = new PostBoxDto();

    dto.setId(postbox.getId());
    dto.setAddress(postbox.getAddress());

    return dto;
  }

  public static UserDto convertToDto(final User user) {
    final UserDto dto = new UserDto();

    dto.setId(user.getId());
    dto.setLogin(user.getLogin());
    dto.setAddress(user.getAddress());

    return dto;
  }

  private static LocalTime convertEpochToLocalDateTime(final long epochTime) {
    return Instant.ofEpochMilli(epochTime).atZone(ZoneId.systemDefault()).toLocalTime();
  }
}
