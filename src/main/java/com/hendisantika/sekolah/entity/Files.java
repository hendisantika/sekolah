package com.hendisantika.sekolah.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
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
 * Time: 15.55
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tbl_files")
@EntityListeners(AuditingEntityListener.class)
public class Files {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "file_id")
    private UUID id;

    @Column(name = "file_judul")
    private String judul;

    @Column(name = "file_deskripsi")
    private String deskripsi;

    @Column(name = "file_oleh")
    @CreatedBy
    private String createdBy;

    @Column(name = "file_tanggal")
    @CreatedDate
    private LocalDateTime createdOn;

    @Column(name = "file_download")
    private int download;

    @Column(name = "file_data")
    private String data;

}
