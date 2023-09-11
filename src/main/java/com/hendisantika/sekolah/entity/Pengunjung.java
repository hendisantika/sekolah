package com.hendisantika.sekolah.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

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
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tbl_pengunjung")
public class Pengunjung {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private UUID id;

    @Column(name = "session_id")
    private String sessionId;

    @Column(name = "cookie_name")
    private String cookieName;

    @Column(name = "url")
    private String url;

    @Column(name = "ip")
    private String ipAddress;

    @Column(name = "os_type")
    private String osType;

    @Column(name = "os_version")
    private String osVersion;

    @Column(name = "browser_name")
    private String browserName;

    @Column(name = "browser_type")
    private String browserType;

    @Column(name = "browser_version")
    private String browserVersion;

    @Column(name = "device_type")
    private String deviceType;

    @Column(name = "host_address")
    private String hostAddress;

    @Column(name = "host_name")
    private String hostName;

    @Column(name = "created_on")
    private LocalDateTime createdOn;
}
