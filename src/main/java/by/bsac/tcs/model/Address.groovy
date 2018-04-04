package by.bsac.tcs.model

import groovy.transform.Canonical

import javax.persistence.*

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
