package by.bsac.tcs.controller;

import by.bsac.tcs.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;


public class SubscriptionController {

  @Autowired
  private SubscriptionService subscriptionService;

  /*@RequestMapping(value = "/subsciption", method = RequestMethod.GET)
  public List<Subscription> getSubscriptions(){

  }*/
}
