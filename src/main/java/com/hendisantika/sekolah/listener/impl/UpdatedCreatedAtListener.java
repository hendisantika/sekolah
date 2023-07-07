package com.hendisantika.sekolah.listener.impl;

import com.hendisantika.sekolah.listener.UpdatedCreatedAtAware;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.time.LocalDateTime;

public class UpdatedCreatedAtListener {

    @PreUpdate
    public void setLastUpdatedAt(UpdatedCreatedAtAware object) {
        object.setModifiedOn(LocalDateTime.now());
    }

    @PrePersist
    public void setLastCreatedAt(UpdatedCreatedAtAware object) {
        object.setCreatedOn(LocalDateTime.now());
    }

}
