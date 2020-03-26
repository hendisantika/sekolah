package com.hendisantika.sekolah.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Email;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tbl_pengguna")
@EntityListeners(AuditingEntityListener.class)
public class Pengguna {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "moto")
    private String moto;

    @Column(name = "jenkel")
    private String jenkel;

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "tentang")
    private String tentang;

    @Column(name = "email", unique = true)
    @Email
    private String email;

    @Column(name = "nohp")
    private String nohp;

    @Column(name = "facebook")
    private String facebook;

    @Column(name = "twitter")
    private String witter;

    @Column(name = "linkedin")
    private String linkedin;

    @Column(name = "status")
    private int status;

    @Column(name = "level")
    private String level;

    @Column(name = "photo")
    private String photo;

    @Column(name = "filename")
    private String filename;

    @Column(name = "file_content")
    private byte[] fileContent;

    @Column(name = "active")
    private boolean active;

    @CreatedDate
    @Column(name = "register")
    private LocalDateTime register;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;

    @Column(name = "created_by")
    @CreatedBy
    private String createdBy;

    @Column(name = "created_on")
    @CreatedDate
    private LocalDateTime createdOn;

    @Column(name = "modified_by")
    @LastModifiedBy
    private String modifiedBy;

    @Column(name = "modified_on")
    @LastModifiedDate
    private LocalDateTime modifiedOn;
}
