package by.bsac.tcs.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.OneToMany

@Entity
class Postoffice {

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

    @OneToMany(mappedBy = "postoffice")
    Set<Postbox> postboxes = new HashSet<>(0)
}
