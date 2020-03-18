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
@Entity(name = "tbl_pengunjung")
@EntityListeners(AuditingEntityListener.class)
public class Pengunjung {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")

    @Column(name = "pengunjung_id")
    private UUID id;

    @Column(name = "pengunjung_tanggal")
    private LocalDateTime tanggal;

    @Column(name = "pengunjung_ip")
    private String ip;

    @Column(name = "pengunjung_perangkat")
    private String perangkat;
}
