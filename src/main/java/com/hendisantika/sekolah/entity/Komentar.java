package com.hendisantika.sekolah.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tbl_komentar")
@EntityListeners(AuditingEntityListener.class)
public class Komentar {
    @Id
    @GeneratedValue(generator = "uuid2")
    @UuidGenerator
    @Column(name = "id")
    private UUID id;

    @Column(name = "nama")
    @Size(max = 200)
    private String nama;

    @Column(name = "email")
    @Email
    @Size(max = 60)
    private String email;

    @Column(name = "isi")
    @Size(max = 120)
    private String isi;

    @Column(name = "status")
    @Size(max = 2)
    private String status;

    @Column(name = "tulisan_id")
    private UUID tulisanId;

    @Column(name = "parent")
    @PositiveOrZero
    private int parent;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Komentar komentar)) return false;

        if (getParent() != komentar.getParent()) return false;
        if (getId() != null ? !getId().equals(komentar.getId()) : komentar.getId() != null) return false;
        if (getNama() != null ? !getNama().equals(komentar.getNama()) : komentar.getNama() != null) return false;
        if (getEmail() != null ? !getEmail().equals(komentar.getEmail()) : komentar.getEmail() != null) return false;
        if (getIsi() != null ? !getIsi().equals(komentar.getIsi()) : komentar.getIsi() != null) return false;
        if (getStatus() != null ? !getStatus().equals(komentar.getStatus()) : komentar.getStatus() != null)
            return false;
        if (getTulisanId() != null ? !getTulisanId().equals(komentar.getTulisanId()) : komentar.getTulisanId() != null)
            return false;
        if (getCreatedBy() != null ? !getCreatedBy().equals(komentar.getCreatedBy()) : komentar.getCreatedBy() != null)
            return false;
        if (getCreatedOn() != null ? !getCreatedOn().equals(komentar.getCreatedOn()) : komentar.getCreatedOn() != null)
            return false;
        if (getModifiedBy() != null ? !getModifiedBy().equals(komentar.getModifiedBy()) : komentar.getModifiedBy() != null)
            return false;
        return getModifiedOn() != null ? getModifiedOn().equals(komentar.getModifiedOn()) : komentar.getModifiedOn() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getNama() != null ? getNama().hashCode() : 0);
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        result = 31 * result + (getIsi() != null ? getIsi().hashCode() : 0);
        result = 31 * result + (getStatus() != null ? getStatus().hashCode() : 0);
        result = 31 * result + (getTulisanId() != null ? getTulisanId().hashCode() : 0);
        result = 31 * result + getParent();
        result = 31 * result + (getCreatedBy() != null ? getCreatedBy().hashCode() : 0);
        result = 31 * result + (getCreatedOn() != null ? getCreatedOn().hashCode() : 0);
        result = 31 * result + (getModifiedBy() != null ? getModifiedBy().hashCode() : 0);
        result = 31 * result + (getModifiedOn() != null ? getModifiedOn().hashCode() : 0);
        return result;
    }
}
