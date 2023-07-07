package com.hendisantika.sekolah.entity;

import com.hendisantika.sekolah.enumeration.StatusRecord;
import com.hendisantika.sekolah.listener.UpdatedCreatedAtAware;
import com.hendisantika.sekolah.listener.impl.UpdatedCreatedAtListener;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.LocalDateTime;

// Ini hanya sebuah parent class tapi bukan IS-A Relationship
@MappedSuperclass
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners({
        AuditingEntityListener.class,
        UpdatedCreatedAtListener.class
})
// ini dimana T itu harus extends Serializable
public abstract class AuditTableEntity<T extends Serializable> implements UpdatedCreatedAtAware {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private T id;

    @Column(name = "created_by")
    @CreatedBy
    private String createdBy;

    @Column(name = "created_on")
    @CreatedDate
    private LocalDateTime createdOn;

    @Column(name = "modified_by")
    @LastModifiedBy
    private String modifiedBy;

    @Column(name = "modified_on")
    @LastModifiedDate
    private LocalDateTime modifiedOn;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status_record")
    private StatusRecord statusRecord = StatusRecord.ACTIVE;

    @Version
    private Long version;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AuditTableEntity<?> that)) return false;

        if (!getId().equals(that.getId())) return false;
        if (!getCreatedBy().equals(that.getCreatedBy())) return false;
        if (!getCreatedOn().equals(that.getCreatedOn())) return false;
        if (!getModifiedBy().equals(that.getModifiedBy())) return false;
        if (!getModifiedOn().equals(that.getModifiedOn())) return false;
        if (getStatusRecord() != that.getStatusRecord()) return false;
        return getVersion().equals(that.getVersion());
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getCreatedBy().hashCode();
        result = 31 * result + getCreatedOn().hashCode();
        result = 31 * result + getModifiedBy().hashCode();
        result = 31 * result + getModifiedOn().hashCode();
        result = 31 * result + getStatusRecord().hashCode();
        result = 31 * result + getVersion().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "AuditTableEntity{" +
                "id=" + id +
                ", createdBy='" + createdBy + '\'' +
                ", createdOn=" + createdOn +
                ", modifiedBy='" + modifiedBy + '\'' +
                ", modifiedOn=" + modifiedOn +
                ", statusRecord=" + statusRecord +
                ", version=" + version +
                '}';
    }
}
