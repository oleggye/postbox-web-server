package by.bsac.tcs.service.impl;

import by.bsac.tcs.model.User;
import by.bsac.tcs.repository.ClientRepository;
import by.bsac.tcs.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

  private final ClientRepository clientRepository;

  @Autowired
  public ClientServiceImpl(final ClientRepository clientRepository) {
    this.clientRepository = clientRepository;
  }

  @Override
  public User getUserByName(String userName) {
    return clientRepository.findByLogin(userName);
  }
}
