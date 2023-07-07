package com.hendisantika.sekolah.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.UUID;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tbl_komentar")
@SQLDelete(sql = "UPDATE tbl_komentar SET status_record='INACTIVE' WHERE id=?")
@Where(clause = "status_record='ACTIVE'")
public class Komentar extends AuditTableEntity<UUID> {

    @Column(name = "nama")
    private String nama;

    @Column(name = "email")
    private String email;

    @Column(name = "isi")
    private String isi;

    @Column(name = "status")
    private String status;

    @Column(name = "tulisan_id")
    private UUID tulisanId;

    @Column(name = "parent")
    private int parent;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Komentar komentar)) return false;
        if (!super.equals(o)) return false;

        if (getParent() != komentar.getParent()) return false;
        if (!getNama().equals(komentar.getNama())) return false;
        if (!getEmail().equals(komentar.getEmail())) return false;
        if (!getIsi().equals(komentar.getIsi())) return false;
        if (!getStatus().equals(komentar.getStatus())) return false;
        return getTulisanId().equals(komentar.getTulisanId());
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getNama().hashCode();
        result = 31 * result + getEmail().hashCode();
        result = 31 * result + getIsi().hashCode();
        result = 31 * result + getStatus().hashCode();
        result = 31 * result + getTulisanId().hashCode();
        result = 31 * result + getParent();
        return result;
    }

    @Override
    public String toString() {
        return "Komentar{" +
                "nama='" + nama + '\'' +
                ", email='" + email + '\'' +
                ", isi='" + isi + '\'' +
                ", status='" + status + '\'' +
                ", tulisanId=" + tulisanId +
                ", parent=" + parent +
                '}';
    }
}
