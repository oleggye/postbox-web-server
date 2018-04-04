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
    Long id;

    @ManyToOne
    @JoinColumn(name = "id_address", referencedColumnName = "id", nullable = false)
    Address address;

    @Column
    String title;

    @Column
    String postIndex;

    @OneToMany(mappedBy = "postOffice")
    Set<Postbox> postboxes = new HashSet<>(0)
}
