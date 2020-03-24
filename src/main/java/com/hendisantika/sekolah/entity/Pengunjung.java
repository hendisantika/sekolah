package com.hendisantika.sekolah.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
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
 * Date: 18/03/20
 * Time: 18.44
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tbl_pengunjung")
@EntityListeners(AuditingEntityListener.class)
public class Pengunjung {
    @Id
    @Column(name = "pengunjung_id")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private UUID id;

    @Column(name = "pengunjung_tanggal")
    @CreatedDate
    private LocalDateTime createdOn;

    @Column(name = "pengunjung_ip")
    private String ipAddress;

    @Column(name = "pengunjung_os_type")
    private String osType;

    @Column(name = "pengunjung_os_version")
    private String osVersion;

    @Column(name = "pengunjung_browser_name")
    private String browserName;

    @Column(name = "pengunjung_browser_type")
    private String browserType;

    @Column(name = "pengunjung_browser_version")
    private String browserVersion;

    @Column(name = "pengunjung_device_type")
    private String deviceType;

    @Column(name = "pengunjung_host_address")
    private String hostAddress;

    @Column(name = "pengunjung_host_name")
    private String hostName;
}
