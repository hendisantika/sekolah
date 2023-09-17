package com.hendisantika.sekolah.entity;

import com.hendisantika.sekolah.enumeration.STATUSRECORD;
import com.hendisantika.sekolah.listener.UpdatedCreatedAtAware;
import com.hendisantika.sekolah.listener.impl.UpdatedCreatedAtListener;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.LocalDateTime;

// Ini hanya sebuah parent class tapi bukan IS-A Relationship
@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
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
    @Size(max = 50)
    private String createdBy;

    @Column(name = "created_on")
    @CreatedDate
    private LocalDateTime createdOn;

    @Column(name = "modified_by")
    @LastModifiedBy
    @Size(max = 50)
    private String modifiedBy;

    @Column(name = "modified_on")
    @LastModifiedDate
    private LocalDateTime modifiedOn;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status_record")
    private STATUSRECORD statusRecord = STATUSRECORD.ACTIVE;

    @Version
    private Long version;

}
