package by.bsac.tcs.service;

import by.bsac.tcs.model.Postbox;
import by.bsac.tcs.service.exception.PostBoxServiceException;
import by.bsac.tcs.service.exception.ServiceValidationException;
import java.util.Set;

public interface PostBoxService {

  void registration(Postbox postBox)
      throws PostBoxServiceException, ServiceValidationException;

  void removePostBox(Postbox postBox) throws PostBoxServiceException, ServiceValidationException;

  Postbox getPostBoxById(long id) throws PostBoxServiceException, ServiceValidationException;

  Set<Postbox> getPostBoxesByUserName(final String userName);
}
