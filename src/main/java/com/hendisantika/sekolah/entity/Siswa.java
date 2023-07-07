package com.hendisantika.sekolah.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
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
 * Date: 18/03/20
 * Time: 18.49
 */
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tbl_siswa")
@SQLDelete(sql = "UPDATE tbl_siswa SET status_record='INACTIVE' WHERE id=?")
@Where(clause = "status_record='ACTIVE'")
public class Siswa extends AuditTableEntity<UUID> {

    @Column(name = "nis", unique = true)
    private String nis;

    @Column(name = "nama")
    private String nama;

    @Column(name = "jenkel")
    private String jenkel;

    @Column(name = "photo")
    private String photo;

    @Column(name = "photo_base64")
    private String photoBase64;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "kelas_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ToString.Exclude
    private Kelas kelas;

    @Column(name = "filename")
    private String filename;

    @Column(name = "file_content")
    private byte[] fileContent;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Siswa siswa)) return false;
        if (!super.equals(o)) return false;

        if (!getNis().equals(siswa.getNis())) return false;
        if (!getNama().equals(siswa.getNama())) return false;
        if (!getJenkel().equals(siswa.getJenkel())) return false;
        if (!getPhoto().equals(siswa.getPhoto())) return false;
        if (!getPhotoBase64().equals(siswa.getPhotoBase64())) return false;
        if (!getKelas().equals(siswa.getKelas())) return false;
        if (!getFilename().equals(siswa.getFilename())) return false;
        return Arrays.equals(getFileContent(), siswa.getFileContent());
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getNis().hashCode();
        result = 31 * result + getNama().hashCode();
        result = 31 * result + getJenkel().hashCode();
        result = 31 * result + getPhoto().hashCode();
        result = 31 * result + getPhotoBase64().hashCode();
        result = 31 * result + getKelas().hashCode();
        result = 31 * result + getFilename().hashCode();
        result = 31 * result + Arrays.hashCode(getFileContent());
        return result;
    }

    @Override
    public String toString() {
        return "Siswa{" +
                "nis='" + nis + '\'' +
                ", nama='" + nama + '\'' +
                ", jenkel='" + jenkel + '\'' +
                ", photo='" + photo + '\'' +
                ", photoBase64='" + photoBase64 + '\'' +
                ", kelas=" + kelas +
                ", filename='" + filename + '\'' +
                ", fileContent=" + Arrays.toString(fileContent) +
                '}';
    }
}
