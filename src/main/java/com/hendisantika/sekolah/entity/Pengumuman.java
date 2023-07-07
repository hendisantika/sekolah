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
 * Time: 06.41
 */
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tbl_pengumuman")
@SQLDelete(sql = "UPDATE tbl_pengumuman SET status_record='INACTIVE' WHERE id=?")
@Where(clause = "status_record='ACTIVE'")
public class Pengumuman extends AuditTableEntity<UUID> {

    @Column(name = "judul")
    private String judul;

    @Column(name = "deskripsi")
    private String deskripsi;

    @Column(name = "author")
    private String author;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pengumuman that)) return false;
        if (!super.equals(o)) return false;

        if (!getJudul().equals(that.getJudul())) return false;
        if (!getDeskripsi().equals(that.getDeskripsi())) return false;
        return getAuthor().equals(that.getAuthor());
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getJudul().hashCode();
        result = 31 * result + getDeskripsi().hashCode();
        result = 31 * result + getAuthor().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Pengumuman{" +
                "judul='" + judul + '\'' +
                ", deskripsi='" + deskripsi + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
