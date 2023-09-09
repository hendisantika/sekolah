package com.hendisantika.sekolah.dto;

import java.util.List;
import lombok.Builder;

@Builder
public record WebResponse<T>(
        T data,
        List<String> errors,
        PagingResponse paging
) {
}
