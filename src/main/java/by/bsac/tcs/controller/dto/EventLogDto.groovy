package by.bsac.tcs.controller.dto

import groovy.transform.Canonical

import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.PositiveOrZero
import javax.validation.constraints.Size
import java.time.LocalTime

@Canonical
class EventLogDto {

    @PositiveOrZero(message = "id cannot be negative")
    long id

    @NotBlank(message = "event cannot be blank")
    @Size(min = 5, max = 30)
    String event

    @PositiveOrZero(message = "quantity cannot be negative")
    int quantity

    @NotNull(message = "time cannot be null")
    LocalTime time
}
