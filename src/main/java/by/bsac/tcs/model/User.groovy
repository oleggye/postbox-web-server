package by.bsac.tcs.model

import groovy.transform.Canonical
import groovy.transform.EqualsAndHashCode

import javax.persistence.*

@Entity
@Canonical
@EqualsAndHashCode(excludes = "postboxes")
class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    String id

    @Column
    String name

    @Column
    String surname

    @Column
    String login

    @Column
    String password

    @Column
    String role

    @ManyToOne
    @JoinColumn(name = "id_address", referencedColumnName = "id", nullable = false)
    Address address

    @ManyToMany
    @JoinTable(name = "subscription",
            joinColumns = @JoinColumn(name = "id_user", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_post_box", referencedColumnName = "id"))
    Set<Postbox> postboxes = new HashSet<>(0)
}
