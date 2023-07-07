package com.hendisantika.sekolah.entity;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * Project : sekolah
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 17/03/20
 * Time: 23.26
 */
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tbl_tulisan")
@SQLDelete(sql = "UPDATE tbl_tulisan SET status_record='INACTIVE' WHERE id=?")
@Where(clause = "status_record='ACTIVE'")
public class Tulisan extends AuditTableEntity<UUID> {

    @Column(name = "judul")
    private String judul;

    @Column(name = "isi")
    private String isi;

    @Column(name = "author")
    private String author;

    @Column(name = "views")
    private int views;

    @Column(name = "gambar")
    private String gambar;

    @Column(name = "photo_base64")
    private String photoBase64;

    @Column(name = "filename")
    private String filename;

    @Column(name = "file_content")
    private byte[] fileContent;

    @Column(name = "img_slider")
    private int imgSlider;

    @Column(name = "slug")
    private String slug;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "kategori_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Kategori kategori;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pengguna_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ToString.Exclude
    private Pengguna pengguna;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tulisan tulisan)) return false;
        if (!super.equals(o)) return false;

        if (getViews() != tulisan.getViews()) return false;
        if (getImgSlider() != tulisan.getImgSlider()) return false;
        if (!getJudul().equals(tulisan.getJudul())) return false;
        if (!getIsi().equals(tulisan.getIsi())) return false;
        if (!getAuthor().equals(tulisan.getAuthor())) return false;
        if (!getGambar().equals(tulisan.getGambar())) return false;
        if (!getPhotoBase64().equals(tulisan.getPhotoBase64())) return false;
        if (!getFilename().equals(tulisan.getFilename())) return false;
        if (!Arrays.equals(getFileContent(), tulisan.getFileContent())) return false;
        if (!getSlug().equals(tulisan.getSlug())) return false;
        if (!getKategori().equals(tulisan.getKategori())) return false;
        return getPengguna().equals(tulisan.getPengguna());
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getJudul().hashCode();
        result = 31 * result + getIsi().hashCode();
        result = 31 * result + getAuthor().hashCode();
        result = 31 * result + getViews();
        result = 31 * result + getGambar().hashCode();
        result = 31 * result + getPhotoBase64().hashCode();
        result = 31 * result + getFilename().hashCode();
        result = 31 * result + Arrays.hashCode(getFileContent());
        result = 31 * result + getImgSlider();
        result = 31 * result + getSlug().hashCode();
        result = 31 * result + getKategori().hashCode();
        result = 31 * result + getPengguna().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Tulisan{" +
                "judul='" + judul + '\'' +
                ", isi='" + isi + '\'' +
                ", author='" + author + '\'' +
                ", views=" + views +
                ", gambar='" + gambar + '\'' +
                ", photoBase64='" + photoBase64 + '\'' +
                ", filename='" + filename + '\'' +
                ", fileContent=" + Arrays.toString(fileContent) +
                ", imgSlider=" + imgSlider +
                ", slug='" + slug + '\'' +
                ", kategori=" + kategori +
                ", pengguna=" + pengguna +
                '}';
    }
}
