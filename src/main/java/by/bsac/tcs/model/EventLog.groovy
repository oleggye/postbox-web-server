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

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id

    private long postBoxId

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Event event
}
