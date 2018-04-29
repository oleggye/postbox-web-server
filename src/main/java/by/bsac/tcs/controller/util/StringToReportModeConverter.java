package by.bsac.tcs.controller.util;

import by.bsac.tcs.controller.dto.ReportMode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToReportModeConverter implements Converter<String, ReportMode> {

  private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

  @Override
  public ReportMode convert(String value) {
    try {
      return OBJECT_MAPPER.readValue(value, ReportMode.class);
    } catch (IOException e) {
      final String errorMessage = String.format("Can't parse %s to reportMode", value);
      throw new IllegalArgumentException(errorMessage);
    }
  }
}
