package com.hendisantika.sekolah.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * Project : sekolah
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 18/03/20
 * Time: 18.52
 */
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tbl_testimoni")
@SQLDelete(sql = "UPDATE tbl_testimoni SET status_record='INACTIVE' WHERE id=?")
@Where(clause = "status_record='ACTIVE'")
public class Testimoni extends AuditTableEntity<UUID> {

    @Column(name = "nama ")
    private String nama;

    @Column(name = "isi ")
    private String isi;

    @Column(name = "email")
    private String email;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Testimoni testimoni)) return false;
        if (!super.equals(o)) return false;

        if (!getNama().equals(testimoni.getNama())) return false;
        if (!getIsi().equals(testimoni.getIsi())) return false;
        return getEmail().equals(testimoni.getEmail());
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getNama().hashCode();
        result = 31 * result + getIsi().hashCode();
        result = 31 * result + getEmail().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Testimoni{" +
                "nama='" + nama + '\'' +
                ", isi='" + isi + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
