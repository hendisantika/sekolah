package com.hendisantika.sekolah.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * Project : sekolah
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 17/03/20
 * Time: 13.59
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tbl_agenda")
@EntityListeners(AuditingEntityListener.class)
public class Agenda {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "agenda_id")
    private UUID agendaId;

    @Column(name = "agenda_nama")
    private String agendaNama;

    @Column(name = "agenda_tanggal")
    private LocalDateTime agendaTanggal;

    @Column(name = "agenda_deskripsi")
    @Lob
    private String agendaDeskripsi;

    @Column(name = "agenda_mulai")
    private LocalDate agendaMulai;

    @Column(name = "agenda_selesai")
    private LocalDate agendaSelesai;

    @Column(name = "agenda_tempat")
    private String agendaTempat;

    @Column(name = "agenda_waktu")
    private String agendaWaktu;

    @Column(name = "agenda_keterangan")
    private String agendaKeterangan;

    @Column(name = "agenda_author")
    private String agendaAuthor;

    @Column(name = "agenda_created_on")
    @CreatedDate
    private LocalDateTime createdOn;

    @Column(name = "agenda_modified_on")
    @LastModifiedDate
    private LocalDateTime modified_on;

}
