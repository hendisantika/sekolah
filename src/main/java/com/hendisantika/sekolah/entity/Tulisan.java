package com.hendisantika.sekolah.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

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
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode(callSuper = false)
@ToString
@Entity(name = "tbl_tulisan")
@SQLDelete(sql = "UPDATE tbl_tulisan SET status_record='INACTIVE' WHERE id=? AND version=?")
@Where(clause = "status_record='ACTIVE'")
public class Tulisan extends AuditTableEntity<UUID> {
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "kategori_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    @ToString.Exclude
    private Kategori kategori;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pengguna_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ToString.Exclude
    @NotNull
    private Pengguna pengguna;

    @Column(name = "judul")
    @Size(max = 100)
    private String judul;

    @Column(name = "isi")
    private String isi;

    @Column(name = "author")
    @Size(max = 100)
    private String author;

    @Column(name = "views")
    @PositiveOrZero
    private int views;

    @Column(name = "gambar")
    private String gambar;

    @Column(name = "photo_base64")
    private String photoBase64;

    @Column(name = "filename")
    private String filename;

    @Column(name = "file_content")
    private byte[] fileContent;

    @Column(name = "img_slider")
    @PositiveOrZero
    private int imgSlider;

    @Column(name = "slug")
    @Size(max = 200)
    private String slug;
}
