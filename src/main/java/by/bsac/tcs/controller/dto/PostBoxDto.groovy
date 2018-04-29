package by.bsac.tcs.controller.dto

import by.bsac.tcs.model.Address
import groovy.transform.Canonical

import javax.validation.constraints.NotNull
import javax.validation.constraints.PositiveOrZero

@Canonical
class PostBoxDto {

    @PositiveOrZero(message = "id cannot be negative")
    long id

    @NotNull(message = "address cannot be null")
    Address address
}
