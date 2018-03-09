package by.bsac.tcs.service;

import by.bsac.tcs.model.Postbox;
import by.bsac.tcs.service.exception.PostBoxServiceException;
import by.bsac.tcs.service.exception.ServiceValidationException;

public interface PostBoxService {

  void registration(Postbox postBox)
      throws PostBoxServiceException, ServiceValidationException;

  Postbox getPostBox(long id) throws PostBoxServiceException, ServiceValidationException;

  void removePostBox(Postbox postBox) throws PostBoxServiceException, ServiceValidationException;
}
