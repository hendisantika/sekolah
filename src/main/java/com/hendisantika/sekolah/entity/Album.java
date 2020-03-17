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
import java.time.LocalDateTime;
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
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tbl_album")
@EntityListeners(AuditingEntityListener.class)
public class Album {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "album_id")
    private UUID id;

    @Column(name = "album_nama")
    private String nama;

    @Column(name = "album_tanggal")
    private LocalDateTime tanggal;

    @Column(name = "album_pengguna_id")
    private int penggunaId;

    @Column(name = "album_author")
    private String author;

    @Column(name = "album_count")
    private int count;

    @Column(name = "album_cover")
    private String cover;
}
