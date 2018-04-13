package by.bsac.tcs.model

import groovy.transform.Canonical
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

import javax.persistence.*

@Entity
@Table(name = "post_office")
@Canonical
@ToString(excludes = "postboxes")
@EqualsAndHashCode(excludes = "postboxes")
class PostOffice {

    @Id
    @GeneratedValue
    long id

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_address", referencedColumnName = "id", nullable = false)
    Address address

    @Column
    String title

    @Column(name = "post_index")
    int postIndex

    @OneToMany(mappedBy = "postOffice", fetch = FetchType.LAZY)
    Set<Postbox> postboxes = new HashSet<>(0)
}
