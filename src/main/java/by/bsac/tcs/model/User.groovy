package by.bsac.tcs.model

import groovy.transform.Canonical
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

import javax.persistence.*

@Entity
@Canonical
@ToString(excludes = ["postboxes", "userPrivate"])
@EqualsAndHashCode(excludes = "postboxes")
class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id

    @Column
    String name

    @Column
    String surname

    @Column
    String login

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    UserPrivate userPrivate

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_address", referencedColumnName = "id", nullable = false)
    Address address

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "subscription",
            joinColumns = @JoinColumn(name = "id_user", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_post_box", referencedColumnName = "id"))
    Set<Postbox> postboxes
}

@Entity
@Table(name = "user_private")
class UserPrivate {

    @Id
    long id

    @Column
    String password

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    Role role
}

enum Role {
    ROLE_ADMIN, ROLE_USER
}
