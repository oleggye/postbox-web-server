package by.bsac.tcs.model

import groovy.transform.Canonical
import groovy.transform.EqualsAndHashCode

import javax.persistence.*

@Entity
@Canonical
@EqualsAndHashCode(excludes = "users")
class Postbox {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id

    @ManyToOne
    @JoinColumn(name = "id_address", referencedColumnName = "id", nullable = false)
    Address address

    @ManyToOne
    @JoinColumn(name = "id_post_office", referencedColumnName = "id", nullable = false)
    PostOffice postOffice

    @ManyToMany(mappedBy = "postboxes")
    Set<User> users = new HashSet<>(0)

    @OneToMany(mappedBy = "postbox")
    Set<EventLog> eventLogs = new HashSet<>(0)
}
