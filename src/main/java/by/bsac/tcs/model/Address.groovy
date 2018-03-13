package by.bsac.tcs.model

import javax.persistence.Entity

@Entity
class Address {
    Long id
    String country
    String city
    String street
    String building;
}
