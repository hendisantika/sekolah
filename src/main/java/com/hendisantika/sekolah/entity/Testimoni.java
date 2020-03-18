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
@Entity(name = "tbl_testimoni")
@EntityListeners(AuditingEntityListener.class)
public class Testimoni {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")

    @Column(name = "testimoni_id")
    private UUID id;

    @Column(name = "testimoni_nama")
    private String nama;

    @Column(name = "testimoni_isi")
    private String isi;

    @Column(name = "testimoni_email")
    private String email;

    @Column(name = "testimoni_tanggal")
    private LocalDateTime tanggal;

}
