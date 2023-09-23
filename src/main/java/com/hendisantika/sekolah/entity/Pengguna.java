package com.hendisantika.sekolah.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.List;
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
@Entity(name = "tbl_pengguna")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@SQLDelete(sql = "UPDATE tbl_pengguna SET status_record='INACTIVE' WHERE id=? AND version=?")
@Where(clause = "status_record='ACTIVE'")
public class Pengguna extends AuditTableEntity<UUID> {
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "tbl_pengguna_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;

    @Column(name = "fullname")
    @Size(max = 50)
    private String fullname;

    @Column(name = "moto")
    @Size(max = 120)
    private String moto;

    @Column(name = "jenkel")
    @Size(max = 2)
    private String jenkel;

    @Column(name = "username", unique = true)
    @Size(max = 30)
    private String username;

    @Column(name = "password")
    @Size(max = 75)
    private String password;

    @Column(name = "tentang")
    private String tentang;

    @Column(name = "email", unique = true)
    @Email
    @Size(max = 50)
    private String email;

    @Column(name = "nohp")
    @Size(max = 20)
    private String nohp;

    @Column(name = "facebook")
    @Size(max = 50)
    private String facebook;

    @Column(name = "twitter")
    @Size(max = 50)
    private String witter;

    @Column(name = "linkedin")
    @Size(max = 50)
    private String linkedin;

    @Column(name = "status")
    @PositiveOrZero
    private int status;

    @Column(name = "level")
    @Size(max = 3)
    private String level;

    @Column(name = "photo")
    @Size(max = 40)
    private String photo;

    @Column(name = "photo_base64")
    private String photoBase64;

    @Column(name = "filename")
    @Size(max = 40)
    private String filename;

    @Column(name = "file_content")
    private byte[] fileContent;

    @Column(name = "active")
    private boolean active;

    @CreatedDate
    @Column(name = "register")
    private LocalDateTime register;
}
