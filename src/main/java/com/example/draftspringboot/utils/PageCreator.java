package com.example.draftspringboot.utils;

import org.springframework.data.domain.PageRequest;

public class PageCreator {

    static final int defaultRowLimit = 10;
    static final int defaultNumberOfPage = 0;

    public static PageRequest createPageable(final Integer page, final Integer limit) {
        if (limit != null) {
            if (page != null) {
                return createPageable(page.intValue(), limit.intValue());
            }
            return createPageable(defaultNumberOfPage, limit.intValue());
        }
        if (page != null) {
            return createPageable(page.intValue(), defaultRowLimit);
        }
        return createPageable(defaultNumberOfPage, defaultRowLimit);
    }

    private static PageRequest createPageable(final int page, final int limit) {
        return PageRequest.of(page, limit);
    }
}
