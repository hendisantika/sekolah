package com.hendisantika.sekolah.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
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
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tbl_pengunjung")
@EntityListeners(AuditingEntityListener.class)
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
    @CreatedDate
    private LocalDateTime createdOn;
}
