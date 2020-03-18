package com.hendisantika.sekolah.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tbl_pengunjung")
@EntityListeners(AuditingEntityListener.class)
public class Siswa {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private UUID id;

    @Column(name = "siswa_nis")
    private String nis;

    @Column(name = "siswa_nama")
    private String nama;

    @Column(name = "siswa_jenkel ")
    private String jenkel;

    @Column(name = "siswa_kelas_id")
    private int kelas_id;

    @Column(name = "siswa_photo ")
    private String photo;
}
