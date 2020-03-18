package com.hendisantika.sekolah.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * Project : sekolah
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 18/03/20
 * Time: 06.41
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tbl_pengumuman")
@EntityListeners(AuditingEntityListener.class)
public class Pengumuman {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "pengumuman_id")
    private UUID id;

    @Column(name = "pengumuman_judul")
    private String judul;

    @Column(name = "pengumuman_deskripsi")
    private String deskripsi;

    @Column(name = "pengumuman_tanggal")
    private LocalDateTime tanggal;

    @Column(name = "pengumuman_author")
    @CreatedBy
    private String author;
}
