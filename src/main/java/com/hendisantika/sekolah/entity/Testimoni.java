package com.hendisantika.sekolah.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
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
 * Date: 18/03/20
 * Time: 18.52
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tbl_testimoni")
@EntityListeners(AuditingEntityListener.class)
public class Testimoni {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private UUID id;

    @Column(name = "  testimoni_nama ")
    private String nama;

    @Column(name = "testimoni_isi ")
    private String isi;

    @Column(name = "testimoni_email")
    private String email;

    @Column(name = "testimoni_tanggal")
    private LocalDateTime tanggal;

}
