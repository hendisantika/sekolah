package com.hendisantika.sekolah.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.UuidGenerator;
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
 * Date: 18/03/20
 * Time: 18.49
 */
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tbl_siswa")
@EntityListeners(AuditingEntityListener.class)
public class Siswa {
    @Id
    @GeneratedValue(generator = "uuid2")
    @UuidGenerator
    @Column(name = "id")
    @NotNull
    private UUID id;

    @Column(name = "nis", unique = true)
    @Size(max = 20)
    private String nis;

    @Column(name = "nama")
    @Size(max = 75)
    private String nama;

    @Column(name = "jenkel")
    @Size(max = 2)
    private String jenkel;

    @Column(name = "photo")
    @Size(max = 40)
    private String photo;

    @Column(name = "photo_base64")
    private String photoBase64;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "kelas_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ToString.Exclude
    @NotNull
    private Kelas kelas;

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
        if (!(o instanceof Siswa siswa)) return false;

        if (getId() != null ? !getId().equals(siswa.getId()) : siswa.getId() != null) return false;
        if (getNis() != null ? !getNis().equals(siswa.getNis()) : siswa.getNis() != null) return false;
        if (getNama() != null ? !getNama().equals(siswa.getNama()) : siswa.getNama() != null) return false;
        if (getJenkel() != null ? !getJenkel().equals(siswa.getJenkel()) : siswa.getJenkel() != null) return false;
        if (getPhoto() != null ? !getPhoto().equals(siswa.getPhoto()) : siswa.getPhoto() != null) return false;
        if (getPhotoBase64() != null ? !getPhotoBase64().equals(siswa.getPhotoBase64()) : siswa.getPhotoBase64() != null)
            return false;
        if (getKelas() != null ? !getKelas().equals(siswa.getKelas()) : siswa.getKelas() != null) return false;
        if (getFilename() != null ? !getFilename().equals(siswa.getFilename()) : siswa.getFilename() != null)
            return false;
        if (!Arrays.equals(getFileContent(), siswa.getFileContent())) return false;
        if (getCreatedBy() != null ? !getCreatedBy().equals(siswa.getCreatedBy()) : siswa.getCreatedBy() != null)
            return false;
        if (getCreatedOn() != null ? !getCreatedOn().equals(siswa.getCreatedOn()) : siswa.getCreatedOn() != null)
            return false;
        if (getModifiedBy() != null ? !getModifiedBy().equals(siswa.getModifiedBy()) : siswa.getModifiedBy() != null)
            return false;
        return getModifiedOn() != null ? getModifiedOn().equals(siswa.getModifiedOn()) : siswa.getModifiedOn() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getNis() != null ? getNis().hashCode() : 0);
        result = 31 * result + (getNama() != null ? getNama().hashCode() : 0);
        result = 31 * result + (getJenkel() != null ? getJenkel().hashCode() : 0);
        result = 31 * result + (getPhoto() != null ? getPhoto().hashCode() : 0);
        result = 31 * result + (getPhotoBase64() != null ? getPhotoBase64().hashCode() : 0);
        result = 31 * result + (getKelas() != null ? getKelas().hashCode() : 0);
        result = 31 * result + (getFilename() != null ? getFilename().hashCode() : 0);
        result = 31 * result + Arrays.hashCode(getFileContent());
        result = 31 * result + (getCreatedBy() != null ? getCreatedBy().hashCode() : 0);
        result = 31 * result + (getCreatedOn() != null ? getCreatedOn().hashCode() : 0);
        result = 31 * result + (getModifiedBy() != null ? getModifiedBy().hashCode() : 0);
        result = 31 * result + (getModifiedOn() != null ? getModifiedOn().hashCode() : 0);
        return result;
    }
}
