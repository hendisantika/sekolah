package com.hendisantika.sekolah.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.UUID;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
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
 * Time: 23.26
 */
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tbl_tulisan")
@EntityListeners(AuditingEntityListener.class)
public class Tulisan {
    @Id
    @GeneratedValue(generator = "uuid2")
    @UuidGenerator
    @Column(name = "id")
    @NotNull
    private UUID id;

    @Column(name = "judul")
    @Size(max = 100)
    private String judul;

    @Column(name = "isi")
    private String isi;

    @Column(name = "author")
    @Size(max = 100)
    private String author;

    @Column(name = "views")
    @PositiveOrZero
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
    @PositiveOrZero
    private int imgSlider;

    @Column(name = "slug")
    @Size(max = 200)
    private String slug;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "kategori_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    private Kategori kategori;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pengguna_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    private Pengguna pengguna;

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
        if (!(o instanceof Tulisan tulisan)) return false;

        if (getViews() != tulisan.getViews()) return false;
        if (getImgSlider() != tulisan.getImgSlider()) return false;
        if (getId() != null ? !getId().equals(tulisan.getId()) : tulisan.getId() != null) return false;
        if (getJudul() != null ? !getJudul().equals(tulisan.getJudul()) : tulisan.getJudul() != null) return false;
        if (getIsi() != null ? !getIsi().equals(tulisan.getIsi()) : tulisan.getIsi() != null) return false;
        if (getAuthor() != null ? !getAuthor().equals(tulisan.getAuthor()) : tulisan.getAuthor() != null) return false;
        if (getGambar() != null ? !getGambar().equals(tulisan.getGambar()) : tulisan.getGambar() != null) return false;
        if (getPhotoBase64() != null ? !getPhotoBase64().equals(tulisan.getPhotoBase64()) : tulisan.getPhotoBase64() != null)
            return false;
        if (getFilename() != null ? !getFilename().equals(tulisan.getFilename()) : tulisan.getFilename() != null)
            return false;
        if (!Arrays.equals(getFileContent(), tulisan.getFileContent())) return false;
        if (getSlug() != null ? !getSlug().equals(tulisan.getSlug()) : tulisan.getSlug() != null) return false;
        if (getKategori() != null ? !getKategori().equals(tulisan.getKategori()) : tulisan.getKategori() != null)
            return false;
        if (getPengguna() != null ? !getPengguna().equals(tulisan.getPengguna()) : tulisan.getPengguna() != null)
            return false;
        if (getCreatedBy() != null ? !getCreatedBy().equals(tulisan.getCreatedBy()) : tulisan.getCreatedBy() != null)
            return false;
        if (getCreatedOn() != null ? !getCreatedOn().equals(tulisan.getCreatedOn()) : tulisan.getCreatedOn() != null)
            return false;
        if (getModifiedBy() != null ? !getModifiedBy().equals(tulisan.getModifiedBy()) : tulisan.getModifiedBy() != null)
            return false;
        return getModifiedOn() != null ? getModifiedOn().equals(tulisan.getModifiedOn()) : tulisan.getModifiedOn() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getJudul() != null ? getJudul().hashCode() : 0);
        result = 31 * result + (getIsi() != null ? getIsi().hashCode() : 0);
        result = 31 * result + (getAuthor() != null ? getAuthor().hashCode() : 0);
        result = 31 * result + getViews();
        result = 31 * result + (getGambar() != null ? getGambar().hashCode() : 0);
        result = 31 * result + (getPhotoBase64() != null ? getPhotoBase64().hashCode() : 0);
        result = 31 * result + (getFilename() != null ? getFilename().hashCode() : 0);
        result = 31 * result + Arrays.hashCode(getFileContent());
        result = 31 * result + getImgSlider();
        result = 31 * result + (getSlug() != null ? getSlug().hashCode() : 0);
        result = 31 * result + (getKategori() != null ? getKategori().hashCode() : 0);
        result = 31 * result + (getPengguna() != null ? getPengguna().hashCode() : 0);
        result = 31 * result + (getCreatedBy() != null ? getCreatedBy().hashCode() : 0);
        result = 31 * result + (getCreatedOn() != null ? getCreatedOn().hashCode() : 0);
        result = 31 * result + (getModifiedBy() != null ? getModifiedBy().hashCode() : 0);
        result = 31 * result + (getModifiedOn() != null ? getModifiedOn().hashCode() : 0);
        return result;
    }
}
