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
@Entity(name = "tbl_log_aktivitas")
@EntityListeners(AuditingEntityListener.class)
public class LogAktivitas {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")

    @Column(name = "log_id")
    private UUID id;

    @Column(name = "log_nama")
    private String nama;

    @Column(name = "log_tanggal")
    private LocalDateTime tanggal;

    @Column(name = "log_ip")
    private String ip;

    @Column(name = "log_pengguna_id")
    private int penggunaId;

    @Column(name = "log_icon")
    private byte[] icon;

    @Column(name = "log_jenis_icon")
    private String jenisIcon;

}
