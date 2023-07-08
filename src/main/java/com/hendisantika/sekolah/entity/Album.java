package com.hendisantika.sekolah.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


import java.time.LocalDateTime;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nama")
    private String nama;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pengguna_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ToString.Exclude
    private Pengguna pengguna;

    @Column(name = "count")
    private int count;

    @Column(name = "cover")
    private String cover;

    @Column(name = "photo_base64")
    private String photoBase64;

    @Column(name = "filename")
    private String filename;

    @Column(name = "file_content")
    private byte[] fileContent;

    @Column(name = "author")
    private String author;

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
