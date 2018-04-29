package by.bsac.tcs.controller.dto

import by.bsac.tcs.model.Address
import groovy.transform.Canonical

import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.PositiveOrZero
import javax.validation.constraints.Size

@Canonical
class UserDto {

    @PositiveOrZero(message = "id cannot be negative")
    long id

    @NotBlank(message = "login cannot be blank")
    @Size(min = 5, max = 50, message = "login must be between 5 and 50")
    String login

    @NotNull(message = "address cannot be null")
    Address address
}
