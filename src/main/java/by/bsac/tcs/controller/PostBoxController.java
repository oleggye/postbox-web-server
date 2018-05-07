package by.bsac.tcs.controller;

import by.bsac.tcs.model.Postbox;
import by.bsac.tcs.service.PostBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
  public Postbox getPostBoxById(@PathVariable long id) {
    return postBoxService.getPostBoxById(id);
  }

  @GetMapping(value = "/{id}/report")
  public ModelAndView getReportPage(@PathVariable long id) {
    final Postbox postBox = postBoxService.getPostBoxById(id);

    ModelAndView mav = new ModelAndView();
    mav.addObject("postBox", postBox);
    mav.setViewName("reports");
    return mav;
  }

  @GetMapping("/{id}/presentation")
  public ModelAndView presentation(@PathVariable long id) {
    final Postbox postBox = postBoxService.getPostBoxById(id);

    ModelAndView mav = new ModelAndView();
    mav.addObject("postBox", postBox);
    mav.setViewName("presentation");
    return mav;
  }
}
