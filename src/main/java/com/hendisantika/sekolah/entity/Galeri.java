package com.hendisantika.sekolah.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Arrays;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
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
@Entity(name = "tbl_galeri")
@EntityListeners(AuditingEntityListener.class)
public class Galeri {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "judul")
    @Size(max = 60)
    private String judul;

    @Column(name = "author")
    @Size(max = 60)
    private String author;

    @Column(name = "gambar")
    @Size(max = 40)
    private String gambar;

    @Column(name = "photo_base64")
    private String photoBase64;

    @Column(name = "filename")
    @Size(max = 50)
    private String filename;

    @Column(name = "file_content")
    private byte[] fileContent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "album_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ToString.Exclude
    @NotNull
    private Album album;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pengguna_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ToString.Exclude
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
        if (!(o instanceof Galeri galeri)) return false;

        if (getId() != null ? !getId().equals(galeri.getId()) : galeri.getId() != null) return false;
        if (getJudul() != null ? !getJudul().equals(galeri.getJudul()) : galeri.getJudul() != null) return false;
        if (getAuthor() != null ? !getAuthor().equals(galeri.getAuthor()) : galeri.getAuthor() != null) return false;
        if (getGambar() != null ? !getGambar().equals(galeri.getGambar()) : galeri.getGambar() != null) return false;
        if (getPhotoBase64() != null ? !getPhotoBase64().equals(galeri.getPhotoBase64()) : galeri.getPhotoBase64() != null)
            return false;
        if (getFilename() != null ? !getFilename().equals(galeri.getFilename()) : galeri.getFilename() != null)
            return false;
        if (!Arrays.equals(getFileContent(), galeri.getFileContent())) return false;
        if (getAlbum() != null ? !getAlbum().equals(galeri.getAlbum()) : galeri.getAlbum() != null) return false;
        if (getPengguna() != null ? !getPengguna().equals(galeri.getPengguna()) : galeri.getPengguna() != null)
            return false;
        if (getCreatedBy() != null ? !getCreatedBy().equals(galeri.getCreatedBy()) : galeri.getCreatedBy() != null)
            return false;
        if (getCreatedOn() != null ? !getCreatedOn().equals(galeri.getCreatedOn()) : galeri.getCreatedOn() != null)
            return false;
        if (getModifiedBy() != null ? !getModifiedBy().equals(galeri.getModifiedBy()) : galeri.getModifiedBy() != null)
            return false;
        return getModifiedOn() != null ? getModifiedOn().equals(galeri.getModifiedOn()) : galeri.getModifiedOn() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getJudul() != null ? getJudul().hashCode() : 0);
        result = 31 * result + (getAuthor() != null ? getAuthor().hashCode() : 0);
        result = 31 * result + (getGambar() != null ? getGambar().hashCode() : 0);
        result = 31 * result + (getPhotoBase64() != null ? getPhotoBase64().hashCode() : 0);
        result = 31 * result + (getFilename() != null ? getFilename().hashCode() : 0);
        result = 31 * result + Arrays.hashCode(getFileContent());
        result = 31 * result + (getAlbum() != null ? getAlbum().hashCode() : 0);
        result = 31 * result + (getPengguna() != null ? getPengguna().hashCode() : 0);
        result = 31 * result + (getCreatedBy() != null ? getCreatedBy().hashCode() : 0);
        result = 31 * result + (getCreatedOn() != null ? getCreatedOn().hashCode() : 0);
        result = 31 * result + (getModifiedBy() != null ? getModifiedBy().hashCode() : 0);
        result = 31 * result + (getModifiedOn() != null ? getModifiedOn().hashCode() : 0);
        return result;
    }
}
