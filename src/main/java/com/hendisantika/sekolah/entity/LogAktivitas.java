package com.hendisantika.sekolah.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UuidGenerator;
import org.hibernate.annotations.Where;
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
@Entity(name = "tbl_log_aktivitas")
@SQLDelete(sql = "UPDATE tbl_log_aktivitas SET status_record='INACTIVE' WHERE id=?")
@Where(clause = "status_record='ACTIVE'")
public class LogAktivitas extends AuditTableEntity<UUID> {
    @Column(name = "nama")
    @Size(max = 200)
    private String nama;

    @Column(name = "ip")
    @Size(max = 20)
    private String ip;

    @Column(name = "icon")
    private byte[] icon;

    @Column(name = "jenis_icon")
    @Size(max = 50)
    private String jenisIcon;
}
