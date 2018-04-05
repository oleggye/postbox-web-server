package by.bsac.tcs.model

import groovy.transform.Canonical

import javax.persistence.*

@Entity
@Canonical
class EventLog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_post_box")
    Postbox postbox

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    Event event

    @Column
    int quantity

    @Column
    long time
}
