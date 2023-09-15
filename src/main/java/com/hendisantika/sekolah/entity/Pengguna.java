package com.hendisantika.sekolah.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@ToString
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

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;

    @Column(name = "created_by")
    @CreatedBy
    @Size(max = 50)
    private String createdBy;

    @Column(name = "created_on")
    @CreatedDate
    private LocalDateTime createdOn;

    @Column(name = "modified_by")
    @LastModifiedBy
    @Size(max = 50)
    private String modifiedBy;

    @Column(name = "modified_on")
    @LastModifiedDate
    private LocalDateTime modifiedOn;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pengguna pengguna)) return false;

        if (getStatus() != pengguna.getStatus()) return false;
        if (isActive() != pengguna.isActive()) return false;
        if (getId() != null ? !getId().equals(pengguna.getId()) : pengguna.getId() != null) return false;
        if (getFullname() != null ? !getFullname().equals(pengguna.getFullname()) : pengguna.getFullname() != null)
            return false;
        if (getMoto() != null ? !getMoto().equals(pengguna.getMoto()) : pengguna.getMoto() != null) return false;
        if (getJenkel() != null ? !getJenkel().equals(pengguna.getJenkel()) : pengguna.getJenkel() != null)
            return false;
        if (getUsername() != null ? !getUsername().equals(pengguna.getUsername()) : pengguna.getUsername() != null)
            return false;
        if (getPassword() != null ? !getPassword().equals(pengguna.getPassword()) : pengguna.getPassword() != null)
            return false;
        if (getTentang() != null ? !getTentang().equals(pengguna.getTentang()) : pengguna.getTentang() != null)
            return false;
        if (getEmail() != null ? !getEmail().equals(pengguna.getEmail()) : pengguna.getEmail() != null) return false;
        if (getNohp() != null ? !getNohp().equals(pengguna.getNohp()) : pengguna.getNohp() != null) return false;
        if (getFacebook() != null ? !getFacebook().equals(pengguna.getFacebook()) : pengguna.getFacebook() != null)
            return false;
        if (getWitter() != null ? !getWitter().equals(pengguna.getWitter()) : pengguna.getWitter() != null)
            return false;
        if (getLinkedin() != null ? !getLinkedin().equals(pengguna.getLinkedin()) : pengguna.getLinkedin() != null)
            return false;
        if (getLevel() != null ? !getLevel().equals(pengguna.getLevel()) : pengguna.getLevel() != null) return false;
        if (getPhoto() != null ? !getPhoto().equals(pengguna.getPhoto()) : pengguna.getPhoto() != null) return false;
        if (getPhotoBase64() != null ? !getPhotoBase64().equals(pengguna.getPhotoBase64()) : pengguna.getPhotoBase64() != null)
            return false;
        if (getFilename() != null ? !getFilename().equals(pengguna.getFilename()) : pengguna.getFilename() != null)
            return false;
        if (!Arrays.equals(getFileContent(), pengguna.getFileContent())) return false;
        if (getRegister() != null ? !getRegister().equals(pengguna.getRegister()) : pengguna.getRegister() != null)
            return false;
        if (getRoles() != null ? !getRoles().equals(pengguna.getRoles()) : pengguna.getRoles() != null) return false;
        if (getCreatedBy() != null ? !getCreatedBy().equals(pengguna.getCreatedBy()) : pengguna.getCreatedBy() != null)
            return false;
        if (getCreatedOn() != null ? !getCreatedOn().equals(pengguna.getCreatedOn()) : pengguna.getCreatedOn() != null)
            return false;
        if (getModifiedBy() != null ? !getModifiedBy().equals(pengguna.getModifiedBy()) : pengguna.getModifiedBy() != null)
            return false;
        return getModifiedOn() != null ? getModifiedOn().equals(pengguna.getModifiedOn()) : pengguna.getModifiedOn() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getFullname() != null ? getFullname().hashCode() : 0);
        result = 31 * result + (getMoto() != null ? getMoto().hashCode() : 0);
        result = 31 * result + (getJenkel() != null ? getJenkel().hashCode() : 0);
        result = 31 * result + (getUsername() != null ? getUsername().hashCode() : 0);
        result = 31 * result + (getPassword() != null ? getPassword().hashCode() : 0);
        result = 31 * result + (getTentang() != null ? getTentang().hashCode() : 0);
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        result = 31 * result + (getNohp() != null ? getNohp().hashCode() : 0);
        result = 31 * result + (getFacebook() != null ? getFacebook().hashCode() : 0);
        result = 31 * result + (getWitter() != null ? getWitter().hashCode() : 0);
        result = 31 * result + (getLinkedin() != null ? getLinkedin().hashCode() : 0);
        result = 31 * result + getStatus();
        result = 31 * result + (getLevel() != null ? getLevel().hashCode() : 0);
        result = 31 * result + (getPhoto() != null ? getPhoto().hashCode() : 0);
        result = 31 * result + (getPhotoBase64() != null ? getPhotoBase64().hashCode() : 0);
        result = 31 * result + (getFilename() != null ? getFilename().hashCode() : 0);
        result = 31 * result + Arrays.hashCode(getFileContent());
        result = 31 * result + (isActive() ? 1 : 0);
        result = 31 * result + (getRegister() != null ? getRegister().hashCode() : 0);
        result = 31 * result + (getRoles() != null ? getRoles().hashCode() : 0);
        result = 31 * result + (getCreatedBy() != null ? getCreatedBy().hashCode() : 0);
        result = 31 * result + (getCreatedOn() != null ? getCreatedOn().hashCode() : 0);
        result = 31 * result + (getModifiedBy() != null ? getModifiedBy().hashCode() : 0);
        result = 31 * result + (getModifiedOn() != null ? getModifiedOn().hashCode() : 0);
        return result;
    }
}
