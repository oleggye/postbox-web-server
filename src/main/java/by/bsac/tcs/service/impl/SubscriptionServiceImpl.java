package by.bsac.tcs.service.impl;

import by.bsac.tcs.model.Postbox;
import by.bsac.tcs.model.User;
import by.bsac.tcs.service.SubscriptionService;
import by.bsac.tcs.service.exception.ServiceValidationException;
import by.bsac.tcs.service.exception.SubscriptionServiceException;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

  @Override
  public void linkClientToPostBox(User user, Postbox postBox)
      throws SubscriptionServiceException, ServiceValidationException {
    throw new UnsupportedOperationException("Not implemented!");
  }

  @Override
  public void unlinkClientToPostBox(User user, Postbox postBox)
      throws SubscriptionServiceException, ServiceValidationException {
    throw new UnsupportedOperationException("Not implemented!");
  }
}
