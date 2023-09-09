package com.hendisantika.sekolah.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * Created by IntelliJ IDEA.
 * Project : sekolah
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 17/03/20
 * Time: 13.59
 */
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tbl_agenda")
@EntityListeners(AuditingEntityListener.class)
public class Agenda {
    @Id
    @GeneratedValue(generator = "uuid2")
    @UuidGenerator
    @Column(name = "id")
    private UUID id;

    @Column(name = "nama")
    @Size(max = 200)
    private String nama;

    @Column(name = "deskripsi")
    private String deskripsi;

    @Column(name = "mulai")
    private LocalDate mulai;

    @Column(name = "selesai")
    private LocalDate selesai;

    @Column(name = "tempat")
    @Size(max = 90)
    private String tempat;

    @Column(name = "waktu")
    @Size(max = 30)
    private String waktu;

    @Column(name = "keterangan")
    @Size(max = 200)
    private String keterangan;

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
        if (!(o instanceof Agenda agenda)) return false;

        if (getId() != null ? !getId().equals(agenda.getId()) : agenda.getId() != null) return false;
        if (getNama() != null ? !getNama().equals(agenda.getNama()) : agenda.getNama() != null) return false;
        if (getDeskripsi() != null ? !getDeskripsi().equals(agenda.getDeskripsi()) : agenda.getDeskripsi() != null)
            return false;
        if (getMulai() != null ? !getMulai().equals(agenda.getMulai()) : agenda.getMulai() != null) return false;
        if (getSelesai() != null ? !getSelesai().equals(agenda.getSelesai()) : agenda.getSelesai() != null)
            return false;
        if (getTempat() != null ? !getTempat().equals(agenda.getTempat()) : agenda.getTempat() != null) return false;
        if (getWaktu() != null ? !getWaktu().equals(agenda.getWaktu()) : agenda.getWaktu() != null) return false;
        if (getKeterangan() != null ? !getKeterangan().equals(agenda.getKeterangan()) : agenda.getKeterangan() != null)
            return false;
        if (getCreatedBy() != null ? !getCreatedBy().equals(agenda.getCreatedBy()) : agenda.getCreatedBy() != null)
            return false;
        if (getCreatedOn() != null ? !getCreatedOn().equals(agenda.getCreatedOn()) : agenda.getCreatedOn() != null)
            return false;
        if (getModifiedBy() != null ? !getModifiedBy().equals(agenda.getModifiedBy()) : agenda.getModifiedBy() != null)
            return false;
        return getModifiedOn() != null ? getModifiedOn().equals(agenda.getModifiedOn()) : agenda.getModifiedOn() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getNama() != null ? getNama().hashCode() : 0);
        result = 31 * result + (getDeskripsi() != null ? getDeskripsi().hashCode() : 0);
        result = 31 * result + (getMulai() != null ? getMulai().hashCode() : 0);
        result = 31 * result + (getSelesai() != null ? getSelesai().hashCode() : 0);
        result = 31 * result + (getTempat() != null ? getTempat().hashCode() : 0);
        result = 31 * result + (getWaktu() != null ? getWaktu().hashCode() : 0);
        result = 31 * result + (getKeterangan() != null ? getKeterangan().hashCode() : 0);
        result = 31 * result + (getCreatedBy() != null ? getCreatedBy().hashCode() : 0);
        result = 31 * result + (getCreatedOn() != null ? getCreatedOn().hashCode() : 0);
        result = 31 * result + (getModifiedBy() != null ? getModifiedBy().hashCode() : 0);
        result = 31 * result + (getModifiedOn() != null ? getModifiedOn().hashCode() : 0);
        return result;
    }
}
