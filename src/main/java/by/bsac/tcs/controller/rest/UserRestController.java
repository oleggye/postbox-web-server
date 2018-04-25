package by.bsac.tcs.controller.rest;

import static by.bsac.tcs.controller.util.DtoConverter.convertToDto;
import static java.util.stream.Collectors.toList;

import by.bsac.tcs.controller.dto.PostBoxDto;
import by.bsac.tcs.controller.dto.UserDto;
import by.bsac.tcs.controller.util.DtoConverter;
import by.bsac.tcs.model.Postbox;
import by.bsac.tcs.model.User;
import by.bsac.tcs.service.ClientService;
import by.bsac.tcs.service.PostBoxService;
import java.security.Principal;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/secure/users")
public class UserRestController {

  private final PostBoxService postBoxService;
  private final ClientService clientService;

  @Autowired
  public UserRestController(final PostBoxService postBoxService,
      ClientService clientService) {
    this.postBoxService = postBoxService;
    this.clientService = clientService;
  }

  @GetMapping
  public UserDto getUser(final Principal principal) {
    final String userName = principal.getName();
    final User user = clientService.getUserByName(userName);
    return convertToDto(user);
  }

  @GetMapping(value = "/{id}/postboxes")
  public List<PostBoxDto> getPostBoxes(@PathVariable long id) {
    Set<Postbox> postboxes = postBoxService.getPostBoxesByUserId(id);

    return postboxes.stream().map(DtoConverter::convertToDto).collect(toList());
  }
}
