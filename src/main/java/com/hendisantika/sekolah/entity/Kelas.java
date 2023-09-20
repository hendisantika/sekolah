package com.hendisantika.sekolah.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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
import java.util.HashSet;
import java.util.Set;
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
@Entity(name = "tbl_kelas")
@SQLDelete(sql = "UPDATE tbl_kelas SET status_record='INACTIVE' WHERE id=?")
@Where(clause = "status_record='ACTIVE'")
public class Kelas extends AuditTableEntity<UUID> {
    @OneToMany(mappedBy = "kelas", fetch = FetchType.LAZY)
    @NotNull
    @ToString.Exclude
    @Builder.Default
    private Set<Siswa> siswa = new HashSet<>();

    @Column(name = "nama")
    @Size(max = 25)
    private String nama;
}
