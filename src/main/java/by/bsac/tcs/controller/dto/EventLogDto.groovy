package by.bsac.tcs.controller.dto

import groovy.transform.Canonical

import javax.validation.constraints.NotNull
import java.time.LocalTime

@Canonical
class EventLogDto {

    long id

    @NotNull
    String event

    int quantity

    @NotNull
    LocalTime time
}
