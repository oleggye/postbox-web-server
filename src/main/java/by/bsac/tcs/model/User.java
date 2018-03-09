package by.bsac.tcs.model;

import groovy.transform.Canonical;
import groovy.transform.EqualsAndHashCode;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Canonical
@EqualsAndHashCode(excludes = "postboxes")
@Entity
public class User {

  private String id;
  private String login;
  private String surname;
  private Set<Postbox> postboxes = new HashSet<>(0);

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public String getId() {
    return id;
  }

  @ManyToMany
  @JoinTable(name = "subscription",
      joinColumns = @JoinColumn(name = "id_user", referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(name = "id_post_box", referencedColumnName = "id"))
  public Set<Postbox> getPostboxes() {
    return postboxes;
  }
}
