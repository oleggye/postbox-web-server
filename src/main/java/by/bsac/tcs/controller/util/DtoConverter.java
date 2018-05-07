package by.bsac.tcs.controller.util;

import by.bsac.tcs.controller.dto.EventLogDto;
import by.bsac.tcs.controller.dto.LetterInfoDto;
import by.bsac.tcs.controller.dto.PostBoxDto;
import by.bsac.tcs.controller.dto.UserDto;
import by.bsac.tcs.model.Event.EventType;
import by.bsac.tcs.model.EventLog;
import by.bsac.tcs.model.Postbox;
import by.bsac.tcs.model.User;
import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.EnumMap;
import java.util.Map;

public final class DtoConverter {

  private static final String TIME_ZONE_ID = "Atlantic/Azores";
  private static final Map<EventType, String> map;

  static {
    map = new EnumMap<>(EventType.class);

    map.put(EventType.HAS_OPENED, "Ящик открыт");
    map.put(EventType.HAS_CLOSED, "Ящик закрыт");
    map.put(EventType.KEEP_ALIVE, "Проверка cвязи");
    map.put(EventType.QUANTITY_CHANGED, "Количество писем изменилось");
    map.put(EventType.REGISTRATION, "Регистрация ящика");
  }

  private DtoConverter() {
  }

  public static EventLogDto convertToDto(final EventLog eventLog) {
    final EventLogDto dto = new EventLogDto();

    dto.setId(eventLog.getId());
    String name = eventLog.getEvent().getName();
    EventType eventType = EventType.valueOf(name);
    String eventTypeRus = map.get(eventType);
    dto.setEvent(eventTypeRus);
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

  public static LetterInfoDto convertToDto(
      final int lettersCount,
      final long lastLetterTime,
      final long lastCloseTime) {
    final LetterInfoDto dto = new LetterInfoDto();

    dto.setLettersCount(lettersCount);
    dto.setLastLetterTime(convertEpochToLocalDateTime(lastLetterTime));
    dto.setLastCloseTime(convertEpochToLocalDateTime(lastCloseTime));
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
    return Instant.ofEpochSecond(epochTime).atZone(ZoneId.of(TIME_ZONE_ID))
        .toLocalTime();
  }
}
