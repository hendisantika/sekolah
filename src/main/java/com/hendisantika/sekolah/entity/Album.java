package com.hendisantika.sekolah.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * Project : sekolah
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 17/03/20
 * Time: 15.19
 */
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tbl_album")
@EntityListeners(AuditingEntityListener.class)
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nama")
    @Size(max = 50)
    private String nama;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pengguna_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ToString.Exclude
    @NotNull
    private Pengguna pengguna;

    @Column(name = "count")
    @PositiveOrZero
    private int count;

    @Column(name = "cover")
    @Size(max = 40)
    private String cover;

    @Column(name = "photo_base64")
    private String photoBase64;

    @Column(name = "filename")
    @Size(max = 50)
    private String filename;

    @Column(name = "file_content")
    private byte[] fileContent;

    @Column(name = "author")
    @Size(max = 60)
    private String author;

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
        if (!(o instanceof Album album)) return false;

        if (getCount() != album.getCount()) return false;
        if (getId() != null ? !getId().equals(album.getId()) : album.getId() != null) return false;
        if (getNama() != null ? !getNama().equals(album.getNama()) : album.getNama() != null) return false;
        if (getPengguna() != null ? !getPengguna().equals(album.getPengguna()) : album.getPengguna() != null)
            return false;
        if (getCover() != null ? !getCover().equals(album.getCover()) : album.getCover() != null) return false;
        if (getPhotoBase64() != null ? !getPhotoBase64().equals(album.getPhotoBase64()) : album.getPhotoBase64() != null)
            return false;
        if (getFilename() != null ? !getFilename().equals(album.getFilename()) : album.getFilename() != null)
            return false;
        if (!Arrays.equals(getFileContent(), album.getFileContent())) return false;
        if (getAuthor() != null ? !getAuthor().equals(album.getAuthor()) : album.getAuthor() != null) return false;
        if (getCreatedBy() != null ? !getCreatedBy().equals(album.getCreatedBy()) : album.getCreatedBy() != null)
            return false;
        if (getCreatedOn() != null ? !getCreatedOn().equals(album.getCreatedOn()) : album.getCreatedOn() != null)
            return false;
        if (getModifiedBy() != null ? !getModifiedBy().equals(album.getModifiedBy()) : album.getModifiedBy() != null)
            return false;
        return getModifiedOn() != null ? getModifiedOn().equals(album.getModifiedOn()) : album.getModifiedOn() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getNama() != null ? getNama().hashCode() : 0);
        result = 31 * result + (getPengguna() != null ? getPengguna().hashCode() : 0);
        result = 31 * result + getCount();
        result = 31 * result + (getCover() != null ? getCover().hashCode() : 0);
        result = 31 * result + (getPhotoBase64() != null ? getPhotoBase64().hashCode() : 0);
        result = 31 * result + (getFilename() != null ? getFilename().hashCode() : 0);
        result = 31 * result + Arrays.hashCode(getFileContent());
        result = 31 * result + (getAuthor() != null ? getAuthor().hashCode() : 0);
        result = 31 * result + (getCreatedBy() != null ? getCreatedBy().hashCode() : 0);
        result = 31 * result + (getCreatedOn() != null ? getCreatedOn().hashCode() : 0);
        result = 31 * result + (getModifiedBy() != null ? getModifiedBy().hashCode() : 0);
        result = 31 * result + (getModifiedOn() != null ? getModifiedOn().hashCode() : 0);
        return result;
    }
}
