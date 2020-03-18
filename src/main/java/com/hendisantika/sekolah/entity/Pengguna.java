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
@Entity(name = "tbl_pengguna")
@EntityListeners(AuditingEntityListener.class)
public class Pengguna {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")

    @Column(name = "pengguna_id")
    private UUID id;

    @Column(name = "pengguna_nama")
    private String nama;

    @Column(name = "pengguna_moto")
    private String moto;

    @Column(name = "pengguna_jenkel")
    private String jenkel;

    @Column(name = "pengguna_username")
    private String username;

    @Column(name = "pengguna_password")
    private String password;

    @Column(name = "pengguna_tentang")
    private String tentang;

    @Column(name = "pengguna_email")
    private String email;

    @Column(name = "pengguna_nohp")
    private String nohp;

    @Column(name = "pengguna_facebook")
    private String facebook;

    @Column(name = "pengguna_twitter")
    private String witter;

    @Column(name = "pengguna_linkdin")
    private String linkdin;

    @Column(name = "pengguna_google_plus")
    private String googlePlus;

    @Column(name = "pengguna_status")
    private int status;

    @Column(name = "pengguna_level")
    private String level;

    @Column(name = "pengguna_register")
    private LocalDateTime register;

    @Column(name = "pengguna_photo")
    private String photo;

}
