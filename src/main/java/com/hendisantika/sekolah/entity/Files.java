package com.hendisantika.sekolah.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.Arrays;
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
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tbl_files")
@SQLDelete(sql = "UPDATE tbl_files SET status_record='INACTIVE' WHERE id=?")
@Where(clause = "status_record='ACTIVE'")
public class Files extends AuditTableEntity<UUID> {

    @Column(name = "judul")
    private String judul;

    @Column(name = "deskripsi")
    private String deskripsi;

    @Column(name = "author")
    private String author;

    @Column(name = "filename")
    private String filename;

    @Column(name = "file_content")
    private byte[] fileContent;

    @Column(name = "download")
    private int download;

    @Column(name = "data")
    private String data;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Files files)) return false;
        if (!super.equals(o)) return false;

        if (getDownload() != files.getDownload()) return false;
        if (!getJudul().equals(files.getJudul())) return false;
        if (!getDeskripsi().equals(files.getDeskripsi())) return false;
        if (!getAuthor().equals(files.getAuthor())) return false;
        if (!getFilename().equals(files.getFilename())) return false;
        if (!Arrays.equals(getFileContent(), files.getFileContent())) return false;
        return getData().equals(files.getData());
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getJudul().hashCode();
        result = 31 * result + getDeskripsi().hashCode();
        result = 31 * result + getAuthor().hashCode();
        result = 31 * result + getFilename().hashCode();
        result = 31 * result + Arrays.hashCode(getFileContent());
        result = 31 * result + getDownload();
        result = 31 * result + getData().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Files{" +
                "judul='" + judul + '\'' +
                ", deskripsi='" + deskripsi + '\'' +
                ", author='" + author + '\'' +
                ", filename='" + filename + '\'' +
                ", fileContent=" + Arrays.toString(fileContent) +
                ", download=" + download +
                ", data='" + data + '\'' +
                '}';
    }
}
