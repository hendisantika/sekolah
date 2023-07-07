package com.hendisantika.sekolah.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.UUID;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tbl_guru")
@SQLDelete(sql = "UPDATE tbl_guru SET status_record='INACTIVE' WHERE id=?")
@Where(clause = "status_record='ACTIVE'")
public class Guru extends AuditTableEntity<UUID> {

    @Column(name = "nip")
    private String nip;

    @Column(name = "nama")
    private String nama;

    @Column(name = "jenkel")
    private String jenkel;

    @Column(name = "tmp_lahir")
    private String tmpLahir;

    @Column(name = "tgl_lahir")
    private LocalDate tglLahir;

    @Column(name = "mapel")
    private String mapel;

    @Column(name = "photo")
    private String photo;

    @Column(name = "photo_base64")
    private String photoBase64;

    @Column(name = "filename")
    private String filename;

    @Column(name = "file_content")
    private byte[] fileContent;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Guru guru)) return false;
        if (!super.equals(o)) return false;

        if (!getNip().equals(guru.getNip())) return false;
        if (!getNama().equals(guru.getNama())) return false;
        if (!getJenkel().equals(guru.getJenkel())) return false;
        if (!getTmpLahir().equals(guru.getTmpLahir())) return false;
        if (!getTglLahir().equals(guru.getTglLahir())) return false;
        if (!getMapel().equals(guru.getMapel())) return false;
        if (!getPhoto().equals(guru.getPhoto())) return false;
        if (!getPhotoBase64().equals(guru.getPhotoBase64())) return false;
        if (!getFilename().equals(guru.getFilename())) return false;
        return Arrays.equals(getFileContent(), guru.getFileContent());
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getNip().hashCode();
        result = 31 * result + getNama().hashCode();
        result = 31 * result + getJenkel().hashCode();
        result = 31 * result + getTmpLahir().hashCode();
        result = 31 * result + getTglLahir().hashCode();
        result = 31 * result + getMapel().hashCode();
        result = 31 * result + getPhoto().hashCode();
        result = 31 * result + getPhotoBase64().hashCode();
        result = 31 * result + getFilename().hashCode();
        result = 31 * result + Arrays.hashCode(getFileContent());
        return result;
    }

    @Override
    public String toString() {
        return "Guru{" +
                "nip='" + nip + '\'' +
                ", nama='" + nama + '\'' +
                ", jenkel='" + jenkel + '\'' +
                ", tmpLahir='" + tmpLahir + '\'' +
                ", tglLahir=" + tglLahir +
                ", mapel='" + mapel + '\'' +
                ", photo='" + photo + '\'' +
                ", photoBase64='" + photoBase64 + '\'' +
                ", filename='" + filename + '\'' +
                ", fileContent=" + Arrays.toString(fileContent) +
                '}';
    }
}
