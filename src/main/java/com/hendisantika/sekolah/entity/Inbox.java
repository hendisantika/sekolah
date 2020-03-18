package com.hendisantika.sekolah.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tbl_inbox")
@EntityListeners(AuditingEntityListener.class)
public class Inbox {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "inbox_id")
    private UUID id;

    @Column(name = "inbox_nama")
    private String inbox_nama;

    @Column(name = "inbox_email")
    private String inbox_email;

    @Column(name = "inbox_kontak")
    private String inbox_kontak;

    @Column(name = "inbox_pesan")
    private String inbox_pesan;

    @Column(name = "inbox_tanggal")
    private LocalDateTime inbox_tanggal;

    @Column(name = "inbox_status")
    private int inbox_status;

}
