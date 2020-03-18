package com.hendisantika.sekolah.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tbl_guru")
@EntityListeners(AuditingEntityListener.class)
public class Guru {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "guru_id")
    private UUID id;

    @Column(name = "guru_nip")
    private String guru_nip;

    @Column(name = "guru_nama")
    private String guru_nama;

    @Column(name = "guru_jenkel")
    private String guru_jenkel;

    @Column(name = "guru_tmp_lahir")
    private String guru_tmp_lahir;

    @Column(name = "guru_tgl_lahir")
    private String guru_tgl_lahir;

    @Column(name = "guru_mapel")
    private String guru_mapel;

    @Column(name = "guru_photo")
    private String guru_photo;

    @Column(name = "guru_tgl_input")
    private LocalDateTime guru_tgl_input;
}
