package by.bsac.tcs.controller.dto

import by.bsac.tcs.model.Address
import groovy.transform.Canonical

import javax.validation.constraints.NotNull

@Canonical
class PostBoxDto {

    long id

    @NotNull
    Address address
}
