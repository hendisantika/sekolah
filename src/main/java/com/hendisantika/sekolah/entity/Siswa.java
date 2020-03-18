package com.hendisantika.sekolah.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tbl_siswa")
@EntityListeners(AuditingEntityListener.class)
public class Siswa {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")

    @Column(name = "siswa_id")
    private UUID id;

    @Column(name = "siswa_nis")
    private String nis;

    @Column(name = "siswa_nama")
    private String nama;

    @Column(name = "siswa_jenkel")
    private String jenkel;

    @Column(name = "siswa_kelas")
    private int kelas;

    @Column(name = "siswa_photo")
    private String photo;
}
