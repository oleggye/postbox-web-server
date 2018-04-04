package by.bsac.tcs.config;

import by.bsac.tcs.model.User;
import by.bsac.tcs.repository.ClientRepository;
import java.util.Collections;
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

  @Override
  public UserDetails loadUserByUsername(String login) {
    final User user = clientRepository.findByLogin(login);

    final GrantedAuthority authority = new SimpleGrantedAuthority(user.getRole());
    return new org.springframework.security.core.userdetails.User(
        user.getLogin(),
        user.getPassword(), Collections.singleton((authority)));
  }
}
