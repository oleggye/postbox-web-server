package by.bsac.tcs.service.util

import org.springframework.data.domain.Page

class EntityMapper {

    private EntityMapper() {}

    static <T> List<T> mapToList(final Page<T> pages) {
        return pages.asList()
    }
}
