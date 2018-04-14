package by.bsac.tcs.controller.rest;

import by.bsac.tcs.controller.dto.EventLogDto;
import by.bsac.tcs.model.EventLog;
import by.bsac.tcs.model.Postbox;
import by.bsac.tcs.service.PostBoxService;
import by.bsac.tcs.service.exception.PostBoxServiceException;
import by.bsac.tcs.service.exception.ServiceValidationException;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/secure/postbox")
public class PostBoxRestController {

  private PostBoxService postBoxService;

  @Autowired
  public PostBoxRestController(PostBoxService postBoxService) {
    this.postBoxService = postBoxService;
  }

  @GetMapping(value = "/{id}/events")
  public ResponseEntity<?> getEventLogs(@PathVariable long id)
      throws PostBoxServiceException, ServiceValidationException {
    final Postbox postBox = postBoxService.getPostBoxById(id);
    Set<EventLog> eventLogs = postBox.getEventLogs();

    EventLogDto eventLogDto = new EventLogDto();
    eventLogDto.setEventLogs(eventLogs);

    return ResponseEntity.ok().body(eventLogDto);
  }

}
