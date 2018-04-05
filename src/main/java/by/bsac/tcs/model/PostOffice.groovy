package by.bsac.tcs.model

import groovy.transform.Canonical
import groovy.transform.EqualsAndHashCode

import javax.persistence.*

@Entity
@Canonical
@EqualsAndHashCode(excludes = "postboxes")
class PostOffice {

    @Id
    @GeneratedValue
    long id

    @ManyToOne
    @JoinColumn(name = "id_address", referencedColumnName = "id", nullable = false)
    Address address

    @Column
    String title

    @Column
    int postIndex

    @OneToMany(mappedBy = "postOffice")
    Set<Postbox> postboxes = new HashSet<>(0)
}
