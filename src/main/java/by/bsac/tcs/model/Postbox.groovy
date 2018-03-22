package by.bsac.tcs.model

import groovy.transform.Canonical
import groovy.transform.EqualsAndHashCode

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToMany
import javax.persistence.ManyToOne
import javax.persistence.OneToMany
import javax.persistence.OneToOne


@Entity
@EqualsAndHashCode(excludes = "users")
@Canonical
class Postbox {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id

    @ManyToOne
    @JoinColumn(name = "id_address", referencedColumnName = "id", nullable = false)
    Address address

    @ManyToOne
    @JoinColumn(name = "id_postoffice", referencedColumnName = "id", nullable = false)
    Postoffice postoffice

    @ManyToMany(mappedBy = "postboxes")
    Set<User> users = new HashSet<>(0)

    @OneToMany(mappedBy = "postbox")
    Set<EventLog> eventLogs = new HashSet<>(0)
}
