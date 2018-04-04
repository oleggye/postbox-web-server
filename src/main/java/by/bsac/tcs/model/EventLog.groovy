package by.bsac.tcs.model

import groovy.transform.Canonical

import javax.persistence.*

@Entity
@Canonical
class EventLog implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_post_box")
    Postbox postbox

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    Event event
}
