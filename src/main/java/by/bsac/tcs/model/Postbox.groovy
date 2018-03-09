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

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id

    private String address

    @ManyToMany(mappedBy = "postboxes")
    private Set<User> users = new HashSet<>(0)
}
