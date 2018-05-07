package by.bsac.tcs.controller.dto

import groovy.transform.Canonical

import javax.validation.constraints.NotNull
import javax.validation.constraints.PositiveOrZero
import java.time.LocalTime

@Canonical
class LetterInfoDto {

    @PositiveOrZero(message = "id cannot be negative")
    int lettersCount

    @NotNull(message = "time cannot be null")

    LocalTime lastLetterTime
    @NotNull(message = "time cannot be null")
    LocalTime lastCloseTime
}
