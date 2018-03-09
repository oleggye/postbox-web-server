package by.bsac.tcs.model

import groovy.transform.Canonical
import groovy.transform.EqualsAndHashCode

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToMany

@Entity
@EqualsAndHashCode(excludes = "users")
@Canonical
class Postbox {

    private long id
    private String address
    private Set<User> users = new HashSet<>(0)

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long getId() {
        return id;
    }


    @ManyToMany(mappedBy = "postboxes")
    Set<User> getUsers() {
        return users
    }
}
