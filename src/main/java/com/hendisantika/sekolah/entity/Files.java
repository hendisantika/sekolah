package com.hendisantika.sekolah.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * Project : sekolah
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 17/03/20
 * Time: 15.55
 */
@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tbl_files")
@EntityListeners(AuditingEntityListener.class)
public class Files {
    @Id
    @GeneratedValue(generator = "uuid2")
    @UuidGenerator
    @Column(name = "id")
    private UUID id;

    @Column(name = "judul")
    @Size(max = 120)
    private String judul;

    @Column(name = "deskripsi")
    private String deskripsi;

    @Column(name = "author")
    @Size(max = 100)
    private String author;

    @Column(name = "filename")
    @Size(max = 50)
    private String filename;

    @Column(name = "file_content")
    private byte[] fileContent;

    @Column(name = "download")
    @PositiveOrZero
    private int download;

    @Column(name = "data")
    @Size(max = 120)
    private String data;

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
        if (!(o instanceof Files files)) return false;

        if (download != files.download) return false;
        if (!Objects.equals(id, files.id)) return false;
        if (!Objects.equals(judul, files.judul)) return false;
        if (!Objects.equals(deskripsi, files.deskripsi)) return false;
        if (!Objects.equals(author, files.author)) return false;
        if (!Objects.equals(filename, files.filename)) return false;
        if (!Arrays.equals(fileContent, files.fileContent)) return false;
        if (!Objects.equals(data, files.data)) return false;
        if (!Objects.equals(createdBy, files.createdBy)) return false;
        if (!Objects.equals(createdOn, files.createdOn)) return false;
        if (!Objects.equals(modifiedBy, files.modifiedBy)) return false;
        return Objects.equals(modifiedOn, files.modifiedOn);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (judul != null ? judul.hashCode() : 0);
        result = 31 * result + (deskripsi != null ? deskripsi.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (filename != null ? filename.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(fileContent);
        result = 31 * result + download;
        result = 31 * result + (data != null ? data.hashCode() : 0);
        result = 31 * result + (createdBy != null ? createdBy.hashCode() : 0);
        result = 31 * result + (createdOn != null ? createdOn.hashCode() : 0);
        result = 31 * result + (modifiedBy != null ? modifiedBy.hashCode() : 0);
        result = 31 * result + (modifiedOn != null ? modifiedOn.hashCode() : 0);
        return result;
    }
}
