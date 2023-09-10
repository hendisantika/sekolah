package com.hendisantika.sekolah.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.UUID;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tbl_guru")
@EntityListeners(AuditingEntityListener.class)
public class Guru {

    @Id
    @GeneratedValue(generator = "uuid2")
    @UuidGenerator
    @Column(name = "id")
    private UUID id;

    @Column(name = "nip")
    @Size(max = 30)
    private String nip;

    @Column(name = "nama")
    @Size(max = 70)
    private String nama;

    @Column(name = "jenkel")
    @Size(max = 2)
    private String jenkel;

    @Column(name = "tmp_lahir")
    @Size(max = 80)
    private String tmpLahir;

    @Column(name = "tgl_lahir")
    private LocalDate tglLahir;

    @Column(name = "mapel")
    @Size(max = 120)
    private String mapel;

    @Column(name = "photo")
    @Size(max = 40)
    private String photo;

    @Column(name = "photo_base64")
    private String photoBase64;

    @Column(name = "filename")
    @Size(max = 50)
    private String filename;

    @Column(name = "file_content")
    private byte[] fileContent;

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
        if (!(o instanceof Guru guru)) return false;

        if (getId() != null ? !getId().equals(guru.getId()) : guru.getId() != null) return false;
        if (getNip() != null ? !getNip().equals(guru.getNip()) : guru.getNip() != null) return false;
        if (getNama() != null ? !getNama().equals(guru.getNama()) : guru.getNama() != null) return false;
        if (getJenkel() != null ? !getJenkel().equals(guru.getJenkel()) : guru.getJenkel() != null) return false;
        if (getTmpLahir() != null ? !getTmpLahir().equals(guru.getTmpLahir()) : guru.getTmpLahir() != null)
            return false;
        if (getTglLahir() != null ? !getTglLahir().equals(guru.getTglLahir()) : guru.getTglLahir() != null)
            return false;
        if (getMapel() != null ? !getMapel().equals(guru.getMapel()) : guru.getMapel() != null) return false;
        if (getPhoto() != null ? !getPhoto().equals(guru.getPhoto()) : guru.getPhoto() != null) return false;
        if (getPhotoBase64() != null ? !getPhotoBase64().equals(guru.getPhotoBase64()) : guru.getPhotoBase64() != null)
            return false;
        if (getFilename() != null ? !getFilename().equals(guru.getFilename()) : guru.getFilename() != null)
            return false;
        if (!Arrays.equals(getFileContent(), guru.getFileContent())) return false;
        if (getCreatedBy() != null ? !getCreatedBy().equals(guru.getCreatedBy()) : guru.getCreatedBy() != null)
            return false;
        if (getCreatedOn() != null ? !getCreatedOn().equals(guru.getCreatedOn()) : guru.getCreatedOn() != null)
            return false;
        if (getModifiedBy() != null ? !getModifiedBy().equals(guru.getModifiedBy()) : guru.getModifiedBy() != null)
            return false;
        return getModifiedOn() != null ? getModifiedOn().equals(guru.getModifiedOn()) : guru.getModifiedOn() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getNip() != null ? getNip().hashCode() : 0);
        result = 31 * result + (getNama() != null ? getNama().hashCode() : 0);
        result = 31 * result + (getJenkel() != null ? getJenkel().hashCode() : 0);
        result = 31 * result + (getTmpLahir() != null ? getTmpLahir().hashCode() : 0);
        result = 31 * result + (getTglLahir() != null ? getTglLahir().hashCode() : 0);
        result = 31 * result + (getMapel() != null ? getMapel().hashCode() : 0);
        result = 31 * result + (getPhoto() != null ? getPhoto().hashCode() : 0);
        result = 31 * result + (getPhotoBase64() != null ? getPhotoBase64().hashCode() : 0);
        result = 31 * result + (getFilename() != null ? getFilename().hashCode() : 0);
        result = 31 * result + Arrays.hashCode(getFileContent());
        result = 31 * result + (getCreatedBy() != null ? getCreatedBy().hashCode() : 0);
        result = 31 * result + (getCreatedOn() != null ? getCreatedOn().hashCode() : 0);
        result = 31 * result + (getModifiedBy() != null ? getModifiedBy().hashCode() : 0);
        result = 31 * result + (getModifiedOn() != null ? getModifiedOn().hashCode() : 0);
        return result;
    }
}
