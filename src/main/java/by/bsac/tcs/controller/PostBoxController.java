package by.bsac.tcs.controller;

import by.bsac.tcs.model.Postbox;
import by.bsac.tcs.service.PostBoxService;
import by.bsac.tcs.service.exception.PostBoxServiceException;
import by.bsac.tcs.service.exception.ServiceValidationException;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostBoxController {

  @Autowired
  private Logger logger;

  private PostBoxService postBoxService;

  @Autowired
  public PostBoxController(PostBoxService postBoxService)
  {
    this.postBoxService = postBoxService;
  }

  @RequestMapping(value = "/postbox/{id}", method = RequestMethod.GET)
  public Postbox getPostBoxById(@PathVariable long id)
      throws PostBoxServiceException, ServiceValidationException {
    logger.info("getPostBoxById {}", id);
    return postBoxService.getPostBox(id);
  }

  @RequestMapping(value = "/postbox/registration", method = RequestMethod.POST)
  public void registerPostBox(Postbox postBox)
      throws PostBoxServiceException, ServiceValidationException {
    logger.info("getPostBoxById {}", postBox);
    postBoxService.registration(postBox);
  }
}
