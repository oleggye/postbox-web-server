package by.bsac.tcs.model

import groovy.transform.Canonical

import javax.persistence.*

@Entity
@Table(name = "event_log")
@Canonical
class EventLog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_post_box", referencedColumnName = "id", nullable = false)
    Postbox postbox

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_event", referencedColumnName = "id", nullable = false)
    Event event

    @Column(nullable = true)
    int quantity

    @Column
    long time
}
