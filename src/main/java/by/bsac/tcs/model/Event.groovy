package by.bsac.tcs.model

import groovy.transform.Canonical

import javax.persistence.*

@Entity
@Canonical
class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id

    @Column
    String name

    enum EventType {
        REGISTRATION, KEEP_ALIVE, HAS_OPENED, HAS_CLOSED, QUANTITY_CHANGED, LOG
    }
}
