package by.bsac.tcs.service.impl;

import by.bsac.tcs.model.Postbox;
import by.bsac.tcs.service.PostBoxService;
import by.bsac.tcs.service.exception.PostBoxServiceException;
import by.bsac.tcs.service.exception.ServiceValidationException;
import org.springframework.stereotype.Service;

@Service
public class PostBoxServiceImpl implements PostBoxService {

  @Override
  public void registration(Postbox postBox)
      throws PostBoxServiceException, ServiceValidationException {
    throw new UnsupportedOperationException("Not implemented!");
  }

  @Override
  public Postbox getPostBox(long id) throws PostBoxServiceException, ServiceValidationException {
    throw new UnsupportedOperationException("Not implemented!");
  }

  @Override
  public void removePostBox(Postbox postBox)
      throws PostBoxServiceException, ServiceValidationException {
    throw new UnsupportedOperationException("Not implemented!");
  }
}
