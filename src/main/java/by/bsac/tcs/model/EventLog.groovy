package by.bsac.tcs.model

import groovy.transform.Canonical

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
@Canonical
class EventLog {
    private long id
    private long postBoxId
    private by.bsac.tcs.model.Event event

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long getId() {
        return id
    }

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    Event getEvent() {
        return event
    }
}
