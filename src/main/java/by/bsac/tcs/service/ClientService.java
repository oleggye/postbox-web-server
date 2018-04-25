package by.bsac.tcs.service;

import by.bsac.tcs.model.User;

public interface ClientService {

  void singUp(User user);

  void signIn(User user);

  void signOut();

  User getUserByName(final String userName);
}
