package by.bsac.tcs.controller;

import by.bsac.tcs.model.Postbox;
import by.bsac.tcs.model.User;
import by.bsac.tcs.service.ClientService;
import by.bsac.tcs.service.PostBoxService;
import by.bsac.tcs.service.exception.ClientServiceException;
import java.security.Principal;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("secure")
public class WebController {

  private final ClientService clientService;
  private final PostBoxService postBoxService;

  @Autowired
  public WebController(ClientService clientService,
      final PostBoxService postBoxService) {
    this.clientService = clientService;
    this.postBoxService = postBoxService;
  }

  @GetMapping("/home")
  public ModelAndView home() {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("home");
    return mav;
  }

  @GetMapping("/hello")
  public ModelAndView hello(final Principal principal) {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("hello");
    return mav;
  }

  @GetMapping("/index")
  public ModelAndView index() {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("index");
    return mav;
  }

  @GetMapping("/overview")
  public ModelAndView overview(final Principal principal) throws ClientServiceException {
    final String userName = principal.getName();
    final User user = clientService.getUserByName(userName);
    Set<Postbox> postboxes = user.getPostboxes();

    ModelAndView mav = new ModelAndView();
    mav.addObject("postboxes", postboxes);
    mav.setViewName("overview");
    return mav;
  }

  @GetMapping("/reports")
  public ModelAndView reports() {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("reports");
    return mav;
  }

  @GetMapping("/template")
  public String template() {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("template");
    return "template";
  }
}
