package com.hendisantika.sekolah.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record WebResponse<T>(
        T data,
        List<String> errors,
        PagingResponse paging
) {
}
