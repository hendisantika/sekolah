package com.hendisantika.sekolah.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

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
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode(callSuper = false)
@ToString
@Entity(name = "tbl_album")
@SQLDelete(sql = "UPDATE tbl_album SET status_record='INACTIVE' WHERE id=?")
@Where(clause = "status_record='ACTIVE'")
public class Album extends AuditTableEntity<UUID> {
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pengguna_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ToString.Exclude
    @NotNull
    private Pengguna pengguna;

    @Column(name = "nama")
    @Size(max = 50)
    private String nama;

    @Column(name = "count")
    @PositiveOrZero
    private int count;

    @Column(name = "cover")
    @Size(max = 40)
    private String cover;

    @Column(name = "photo_base64")
    private String photoBase64;

    @Column(name = "filename")
    @Size(max = 50)
    private String filename;

    @Column(name = "file_content")
    private byte[] fileContent;

    @Column(name = "author")
    @Size(max = 60)
    private String author;
}
