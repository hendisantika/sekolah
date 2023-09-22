package com.hendisantika.sekolah.listener.impl;

import com.hendisantika.sekolah.listener.UpdatedCreatedAtAware;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.time.LocalDateTime;

public class UpdatedCreatedAtListener {
    @PreUpdate
    public void setLastModifiedOn(Object object) {
        UpdatedCreatedAtAware updatedAtAware = (UpdatedCreatedAtAware) object;
        updatedAtAware.setModifiedOn(LocalDateTime.now());
    }

    @PrePersist
    public void setLastCreatedOn(Object object) {
        UpdatedCreatedAtAware createdAtAware = (UpdatedCreatedAtAware) object;
        createdAtAware.setCreatedOn(LocalDateTime.now());
    }
}
