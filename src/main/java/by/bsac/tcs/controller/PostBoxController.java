package by.bsac.tcs.controller;

import by.bsac.tcs.controller.dto.ReportMode;
import by.bsac.tcs.model.Postbox;
import by.bsac.tcs.service.PostBoxService;
import by.bsac.tcs.service.exception.PostBoxServiceException;
import by.bsac.tcs.service.exception.ServiceValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/secure/postbox")
public class PostBoxController {

  private PostBoxService postBoxService;

  @Autowired
  public PostBoxController(PostBoxService postBoxService) {
    this.postBoxService = postBoxService;
  }

  @GetMapping(value = "/{id}")
  public Postbox getPostBoxById(@PathVariable long id)
      throws PostBoxServiceException, ServiceValidationException {
    return postBoxService.getPostBoxById(id);
  }

  @GetMapping(value = "/{id}/report")
  public ModelAndView getReportPage(@PathVariable long id)
      throws PostBoxServiceException, ServiceValidationException {
    final Postbox postBox = postBoxService.getPostBoxById(id);

    ModelAndView mav = new ModelAndView();
    mav.addObject("postBox", postBox);
    mav.setViewName("reports");
    return mav;
  }


  @PostMapping
  public void registerPostBox(Postbox postBox)
      throws PostBoxServiceException, ServiceValidationException {
    postBoxService.registration(postBox);
  }
}
