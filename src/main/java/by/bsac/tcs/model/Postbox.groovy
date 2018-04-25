package by.bsac.tcs.model

import groovy.transform.Canonical
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

import javax.persistence.*

@Entity
@Table(name = "post_box")
@Canonical
@ToString(excludes = ["users", "eventLogs"])
@EqualsAndHashCode(excludes = ["users", "eventLogs"])
class Postbox {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_address", referencedColumnName = "id", nullable = false)
    Address address

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_post_office", referencedColumnName = "id", nullable = false)
    PostOffice postOffice

    @ManyToMany(mappedBy = "postboxes", fetch = FetchType.LAZY)
    Set<User> users

    @OneToMany(mappedBy = "postbox", fetch = FetchType.LAZY)
    Set<EventLog> eventLogs
}
