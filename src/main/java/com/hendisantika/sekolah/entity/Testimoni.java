package com.hendisantika.sekolah.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
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
@Entity(name = "tbl_testimoni")
@SQLDelete(sql = "UPDATE tbl_testimoni SET status_record='INACTIVE' WHERE id=?")
@Where(clause = "status_record='ACTIVE'")
public class Testimoni extends AuditTableEntity<UUID> {
    @Column(name = "nama")
    @Size(max = 30)
    private String nama;

    @Column(name = "isi")
    @Size(max = 120)
    private String isi;

    @Column(name = "email")
    @Email
    @Size(max = 35)
    private String email;
}
