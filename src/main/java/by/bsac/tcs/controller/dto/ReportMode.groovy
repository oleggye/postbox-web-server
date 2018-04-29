package by.bsac.tcs.controller.dto

import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

class ReportMode {

    @NotNull(message = "modeName cannot be null")
    @Size(min = 5, max = 10, message = "modeName must be between 5 and 10")
    ModeName modeName

    Integer itemsCount

    Long lastLogId

    void setModeName(final String modeName) {
        this.modeName = ModeName.valueOf(modeName)
    }

    enum ModeName {
        LAST_N, ALL_FROM
    }
}
