package com.hendisantika.sekolah.dto;

import lombok.Builder;

@Builder
public record PagingResponse(
        Integer currentPage,
        Integer totalPage,
        Integer size
) {
}
