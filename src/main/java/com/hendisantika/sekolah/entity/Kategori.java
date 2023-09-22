package com.hendisantika.sekolah.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

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
@Entity(name = "tbl_kategori")
@SQLDelete(sql = "UPDATE tbl_kategori SET status_record='INACTIVE' WHERE id=? AND version=?")
@Where(clause = "status_record='ACTIVE'")
public class Kategori extends AuditTableEntity<UUID> {
    @Column(name = "nama")
    @Size(max = 30)
    private String nama;
}
