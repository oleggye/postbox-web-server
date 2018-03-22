package by.bsac.tcs.model

import groovy.transform.Canonical

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
@Canonical
class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id

    @Column
    String country
    @Column
    String city
    @Column
    String street
    @Column
    String building;
}
