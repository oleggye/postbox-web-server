package by.bsac.tcs.controller.dto

import javax.validation.constraints.Max
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

class ReportMode {

    @NotNull
    @Size(max = 10)
    ModeName modeName

    @Max(50L)
    Integer itemsCount

    Long lastLogId

    void setModeName(final String modeName) {
        this.modeName = ModeName.valueOf(modeName)
    }

    enum ModeName {
        LAST_N, ALL_FROM
    }
}
