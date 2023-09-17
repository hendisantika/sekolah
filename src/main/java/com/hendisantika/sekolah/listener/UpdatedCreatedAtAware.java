package com.hendisantika.sekolah.listener;

import java.time.LocalDateTime;

public interface UpdatedCreatedAtAware {
    void setModifiedOn(LocalDateTime localDateTime);
    void setCreatedOn(LocalDateTime localDateTime);
}
