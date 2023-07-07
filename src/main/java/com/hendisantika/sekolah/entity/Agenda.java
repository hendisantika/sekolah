package com.hendisantika.sekolah.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.time.LocalDate;
import java.util.UUID;

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
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tbl_agenda")
@SQLDelete(sql = "UPDATE tbl_agenda SET status_record='INACTIVE' WHERE id=?")
@Where(clause = "status_record='ACTIVE'")
public class Agenda extends AuditTableEntity<UUID> {

    @Column(name = "nama")
    @Size(min = 3, max = 200)
    private String nama;

    @Column(name = "deskripsi")
    private String deskripsi;

    @Column(name = "mulai")
    private LocalDate mulai;

    @Column(name = "selesai")
    private LocalDate selesai;

    @Column(name = "tempat")
    @Size(min = 5, max = 90)
    private String tempat;

    @Column(name = "waktu")
    @Size(min = 5, max = 30)
    private String waktu;

    @Column(name = "keterangan")
    @Size(min = 5, max = 200)
    private String keterangan;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Agenda agenda)) return false;
        if (!super.equals(o)) return false;

        if (!getNama().equals(agenda.getNama())) return false;
        if (!getDeskripsi().equals(agenda.getDeskripsi())) return false;
        if (!getMulai().equals(agenda.getMulai())) return false;
        if (!getSelesai().equals(agenda.getSelesai())) return false;
        if (!getTempat().equals(agenda.getTempat())) return false;
        if (!getWaktu().equals(agenda.getWaktu())) return false;
        return getKeterangan().equals(agenda.getKeterangan());
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getNama().hashCode();
        result = 31 * result + getDeskripsi().hashCode();
        result = 31 * result + getMulai().hashCode();
        result = 31 * result + getSelesai().hashCode();
        result = 31 * result + getTempat().hashCode();
        result = 31 * result + getWaktu().hashCode();
        result = 31 * result + getKeterangan().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Agenda{" +
                "nama='" + nama + '\'' +
                ", deskripsi='" + deskripsi + '\'' +
                ", mulai=" + mulai +
                ", selesai=" + selesai +
                ", tempat='" + tempat + '\'' +
                ", waktu='" + waktu + '\'' +
                ", keterangan='" + keterangan + '\'' +
                '}';
    }
}
