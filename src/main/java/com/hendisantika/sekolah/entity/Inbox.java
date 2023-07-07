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
@Table(name = "tbl_inbox")
@SQLDelete(sql = "UPDATE tbl_inbox SET status_record='INACTIVE' WHERE id=?")
@Where(clause = "status_record='ACTIVE'")
public class Inbox extends AuditTableEntity<UUID> {

    @Column(name = "nama")
    private String nama;

    @Column(name = "email")
    private String email;

    @Column(name = "kontak")
    private String kontak;

    @Column(name = "pesan")
    private String pesan;

    @Column(name = "status")
    private int status;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Inbox inbox)) return false;
        if (!super.equals(o)) return false;

        if (getStatus() != inbox.getStatus()) return false;
        if (!getNama().equals(inbox.getNama())) return false;
        if (!getEmail().equals(inbox.getEmail())) return false;
        if (!getKontak().equals(inbox.getKontak())) return false;
        return getPesan().equals(inbox.getPesan());
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getNama().hashCode();
        result = 31 * result + getEmail().hashCode();
        result = 31 * result + getKontak().hashCode();
        result = 31 * result + getPesan().hashCode();
        result = 31 * result + getStatus();
        return result;
    }

    @Override
    public String toString() {
        return "Inbox{" +
                "nama='" + nama + '\'' +
                ", email='" + email + '\'' +
                ", kontak='" + kontak + '\'' +
                ", pesan='" + pesan + '\'' +
                ", status=" + status +
                '}';
    }
}
