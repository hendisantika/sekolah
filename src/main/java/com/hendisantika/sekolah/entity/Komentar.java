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
@Entity(name = "tbl_komentar")
@EntityListeners(AuditingEntityListener.class)
public class Komentar {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")

    @Column(name = "komentar_id")
    private UUID id;

    @Column(name = "komentar_nama")
    private String komentar_nama;

    @Column(name = "komentar_email")
    private String komentar_email;

    @Column(name = "komentar_isi")
    private String komentar_isi;

    @Column(name = "komentar_tanggal")
    private LocalDateTime komentar_tanggal;

    @Column(name = "komentar_status")
    private String komentar_status;

    @Column(name = "komentar_tulisan_id")
    private int komentar_tulisan_id;

    @Column(name = "komentar_parent")
    private int komentar_parent;

}
