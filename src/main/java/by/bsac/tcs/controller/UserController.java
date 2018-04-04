package by.bsac.tcs.controller;

import by.bsac.tcs.model.User;
import by.bsac.tcs.repository.ClientRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


public class UserController {

  @Autowired
  private Logger logger;

  private ClientRepository repository;

  @Autowired
  public UserController(ClientRepository repository) {
    this.repository = repository;
  }

  /*@RequestMapping("/")
  public String getDeviceStatus() {
    return "OK!";
  }*/

  @RequestMapping(value = "/clients", method = RequestMethod.POST)
  public String addNewClient(@RequestParam String id, @RequestParam String login) {
    return "saved!";
  }

  @RequestMapping(value = "/clients/{login}")
  public User getClientByLogin(@PathVariable String login) {
    return repository.findByLogin(login);
  }
}
