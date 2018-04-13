package by.bsac.tcs.service;

import by.bsac.tcs.model.Postbox;
import by.bsac.tcs.model.User;
import by.bsac.tcs.service.exception.ServiceValidationException;
import by.bsac.tcs.service.exception.SubscriptionServiceException;
import java.util.Set;

public interface SubscriptionService {

  void linkClientToPostBox(User user, Postbox postBox)
      throws SubscriptionServiceException, ServiceValidationException;

  void unlinkClientToPostBox(User user, Postbox postBox)
      throws SubscriptionServiceException, ServiceValidationException;

  Set<Postbox> fetchPostBoxedForUser(final String userId)
      throws SubscriptionServiceException, ServiceValidationException;
}
