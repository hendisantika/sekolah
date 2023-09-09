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
@Entity(name = "tbl_inbox")
@EntityListeners(AuditingEntityListener.class)
public class Inbox {
    @Id
    @GeneratedValue(generator = "uuid2")
    @UuidGenerator
    @Column(name = "id")
    private UUID id;

    @Column(name = "nama")
    @Size(max = 40)
    private String nama;

    @Column(name = "email")
    @Size(max = 60)
    @Email
    private String email;

    @Column(name = "kontak")
    @Size(max = 20)
    private String kontak;

    @Column(name = "pesan")
    private String pesan;

    @Column(name = "status")
    @PositiveOrZero
    private int status;

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
        if (!(o instanceof Inbox inbox)) return false;

        if (getStatus() != inbox.getStatus()) return false;
        if (getId() != null ? !getId().equals(inbox.getId()) : inbox.getId() != null) return false;
        if (getNama() != null ? !getNama().equals(inbox.getNama()) : inbox.getNama() != null) return false;
        if (getEmail() != null ? !getEmail().equals(inbox.getEmail()) : inbox.getEmail() != null) return false;
        if (getKontak() != null ? !getKontak().equals(inbox.getKontak()) : inbox.getKontak() != null) return false;
        if (getPesan() != null ? !getPesan().equals(inbox.getPesan()) : inbox.getPesan() != null) return false;
        if (getCreatedBy() != null ? !getCreatedBy().equals(inbox.getCreatedBy()) : inbox.getCreatedBy() != null)
            return false;
        if (getCreatedOn() != null ? !getCreatedOn().equals(inbox.getCreatedOn()) : inbox.getCreatedOn() != null)
            return false;
        if (getModifiedBy() != null ? !getModifiedBy().equals(inbox.getModifiedBy()) : inbox.getModifiedBy() != null)
            return false;
        return getModifiedOn() != null ? getModifiedOn().equals(inbox.getModifiedOn()) : inbox.getModifiedOn() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getNama() != null ? getNama().hashCode() : 0);
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        result = 31 * result + (getKontak() != null ? getKontak().hashCode() : 0);
        result = 31 * result + (getPesan() != null ? getPesan().hashCode() : 0);
        result = 31 * result + getStatus();
        result = 31 * result + (getCreatedBy() != null ? getCreatedBy().hashCode() : 0);
        result = 31 * result + (getCreatedOn() != null ? getCreatedOn().hashCode() : 0);
        result = 31 * result + (getModifiedBy() != null ? getModifiedBy().hashCode() : 0);
        result = 31 * result + (getModifiedOn() != null ? getModifiedOn().hashCode() : 0);
        return result;
    }
}
