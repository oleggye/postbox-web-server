package by.bsac.tcs.model

import groovy.transform.Canonical
import groovy.transform.EqualsAndHashCode

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.JoinTable
import javax.persistence.ManyToMany
import javax.persistence.ManyToOne

@Canonical
@EqualsAndHashCode(excludes = "postboxes")
@Entity
class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    String id

    @Column
    String login

    @Column
    String name

    @Column
    String surname

    @ManyToMany
    @JoinTable(name = "subscription",
            joinColumns = @JoinColumn(name = "id_user", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_post_box", referencedColumnName = "id"))
    Set<Postbox> postboxes = new HashSet<>(0)
}
