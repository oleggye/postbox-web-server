package by.bsac.tcs.controller;

import by.bsac.tcs.model.Postbox;
import by.bsac.tcs.model.User;
import by.bsac.tcs.service.ClientService;
import by.bsac.tcs.service.exception.ClientServiceException;
import java.security.Principal;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/secure")
public class WebController {

  private final ClientService clientService;

  @Autowired
  public WebController(ClientService clientService) {
    this.clientService = clientService;
  }

  @GetMapping("/home")
  public ModelAndView overview(final Principal principal) throws ClientServiceException {
    final String userName = principal.getName();
    final User user = clientService.getUserByName(userName);
    Set<Postbox> postboxes = user.getPostboxes();

    ModelAndView mav = new ModelAndView();
    mav.addObject("userId", user.getId());
    mav.addObject("postboxes", postboxes);
    mav.setViewName("home");
    return mav;
  }

  @GetMapping("/reports")
  public ModelAndView reports() {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("reports");
    return mav;
  }
}
