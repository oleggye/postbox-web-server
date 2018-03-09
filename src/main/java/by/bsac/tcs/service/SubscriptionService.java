package by.bsac.tcs.service;

import by.bsac.tcs.model.Postbox;
import by.bsac.tcs.model.User;
import by.bsac.tcs.service.exception.ServiceValidationException;
import by.bsac.tcs.service.exception.SubscriptionServiceException;

public interface SubscriptionService {

  void linkClientToPostBox(User user, Postbox postBox)
      throws SubscriptionServiceException, ServiceValidationException;

  void unlinkClientToPostBox(User user, Postbox postBox)
      throws SubscriptionServiceException, ServiceValidationException;
}
