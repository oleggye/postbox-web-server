package by.bsac.tcs.security;

import by.bsac.tcs.model.User;
import by.bsac.tcs.model.UserPrivate;
import by.bsac.tcs.repository.ClientRepository;
import java.util.Collections;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class ApplicationUserDetailsService implements UserDetailsService {

  @Autowired
  private ClientRepository clientRepository;

  @Autowired
  private Logger logger;

  @Override
  public UserDetails loadUserByUsername(String login) {
    logger.info("login{}", login);

    final User user = clientRepository.findByLogin(login);
    UserPrivate userPrivate = user.getUserPrivate();
    final GrantedAuthority authority = new SimpleGrantedAuthority(userPrivate.getRole().name());
    return new org.springframework.security.core.userdetails.User(
        user.getLogin(),
        userPrivate.getPassword(), Collections.singleton((authority)));
  }
}
