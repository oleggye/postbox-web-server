package by.bsac.tcs.service.impl;

import by.bsac.tcs.model.Postbox;
import by.bsac.tcs.repository.PostboxRepository;
import by.bsac.tcs.service.PostBoxService;
import by.bsac.tcs.service.exception.PostBoxServiceException;
import by.bsac.tcs.service.exception.ServiceValidationException;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostBoxServiceImpl implements PostBoxService {

  private final PostboxRepository postboxRepository;

  @Autowired
  public PostBoxServiceImpl(final PostboxRepository postboxRepository) {
    this.postboxRepository = postboxRepository;
  }

  @Override
  public void registration(final Postbox postBox)
      throws PostBoxServiceException, ServiceValidationException {
    throw new UnsupportedOperationException("Not implemented!");
  }

  @Override
  public void removePostBox(Postbox postBox)
      throws PostBoxServiceException, ServiceValidationException {
    throw new UnsupportedOperationException("Not implemented!");
  }

  public Postbox getPostBoxById(final long id)
      throws PostBoxServiceException, ServiceValidationException {
    return postboxRepository.findById(id).orElseThrow(
        () -> {
          final String errorMessage = String.format("No such postbox id:%s", id);
          return new IllegalArgumentException(errorMessage);
        });
  }

  @Override
  public Set<Postbox> getPostBoxesByUserName(final String userName) {
    return postboxRepository.findByUsers_Name(userName);
  }
}
