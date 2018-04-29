package by.bsac.tcs.controller.rest;

import static by.bsac.tcs.controller.util.DtoConverter.convertToDto;

import by.bsac.tcs.controller.dto.EventLogDto;
import by.bsac.tcs.controller.dto.PostBoxDto;
import by.bsac.tcs.controller.dto.ReportMode;
import by.bsac.tcs.controller.util.DtoConverter;
import by.bsac.tcs.model.EventLog;
import by.bsac.tcs.model.Postbox;
import by.bsac.tcs.service.PostBoxService;
import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/secure/postboxes")
public class PostBoxRestController {

  private PostBoxService postBoxService;
  private Logger logger;

  @Autowired
  public PostBoxRestController(PostBoxService postBoxService) {
    this.postBoxService = postBoxService;
  }

  @GetMapping(value = "/{id}")
  public PostBoxDto getPostBox(@PathVariable long id) {
    final Postbox postBox = postBoxService.getPostBoxById(id);
    return convertToDto(postBox);
  }

  @GetMapping(value = "/{id}/events")
  public List<EventLogDto> getEventLogs(@PathVariable long id,
      @RequestParam @Validated ReportMode reportMode) {

    final Postbox postBox = postBoxService.getPostBoxById(id);
    List<EventLog> eventLogs = postBoxService.getEventLogsForPostBox(postBox, reportMode);

    return eventLogs.stream().map(DtoConverter::convertToDto)
        .collect(Collectors.toList());
  }

  @ExceptionHandler(IllegalArgumentException.class)
  @ResponseStatus(value = HttpStatus.NOT_FOUND)
  public String noSuchPostBox(final IllegalArgumentException exception) {
    if (logger.isWarnEnabled()) {
      logger.warn(exception.toString());
    }
    return exception.getMessage();
  }

  @Autowired
  public void setLogger(final Logger logger) {
    this.logger = logger;
  }
}
