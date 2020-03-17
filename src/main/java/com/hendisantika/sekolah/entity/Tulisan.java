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
 * Time: 23.26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tbl_tulisan")
@EntityListeners(AuditingEntityListener.class)
public class Tulisan {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "tulisan_id")
    private UUID id;

    @Column(name = "tulisan_judul")
    private String judul;

    @Column(name = "tulisan_isi")
    private String isi;

    @Column(name = " tulisan_tanggal")
    private LocalDateTime tanggal;

    @Column(name = "tulisan_kategori_id ")
    private int kategoriId;

    @Column(name = "tulisan_kategori_nama")
    private String kategorNama;

    @Column(name = "tulisan_views")
    private int views;

    @Column(name = "tulisan_gambar")
    private String gambar;

    @Column(name = "tulisan_pengguna_id ")
    private int penggunaId;

    @Column(name = "tulisan_author ")
    private String author;

    @Column(name = "tulisan_img_slider")
    private int imgSlider;

    @Column(name = "tulisan_slug ")
    private String slug;
}
