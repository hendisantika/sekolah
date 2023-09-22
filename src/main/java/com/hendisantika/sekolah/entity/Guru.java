package com.hendisantika.sekolah.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.time.LocalDate;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * Project : sekolah
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 17/03/20
 * Time: 15.19
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode(callSuper = false)
@ToString
@Entity(name = "tbl_guru")
@SQLDelete(sql = "UPDATE tbl_guru SET status_record='INACTIVE' WHERE id=? AND version=?")
@Where(clause = "status_record='ACTIVE'")
public class Guru extends AuditTableEntity<UUID> {
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
}
