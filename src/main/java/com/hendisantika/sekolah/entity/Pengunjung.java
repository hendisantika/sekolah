package com.hendisantika.sekolah.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

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
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tbl_pengunjung")
public class Pengunjung {
    @Id
    @GeneratedValue(generator = "uuid2")
    @UuidGenerator
    @Column(name = "id")
    private UUID id;

    @Column(name = "session_id")
    @Size(max = 50)
    @NotNull
    private String sessionId;

    @Column(name = "cookie_name")
    @Size(max = 50)
    @NotNull
    private String cookieName;

    @Column(name = "url")
    @Size(max = 150)
    @NotNull
    private String url;

    @Column(name = "ip")
    @Size(max = 40)
    private String ipAddress;

    @Column(name = "os_type")
    @Size(max = 50)
    private String osType;

    @Column(name = "os_version")
    @Size(max = 50)
    private String osVersion;

    @Column(name = "browser_name")
    @Size(max = 50)
    private String browserName;

    @Column(name = "browser_type")
    @Size(max = 50)
    private String browserType;

    @Column(name = "browser_version")
    @Size(max = 50)
    private String browserVersion;

    @Column(name = "device_type")
    @Size(max = 50)
    private String deviceType;

    @Column(name = "host_address")
    @Size(max = 50)
    private String hostAddress;

    @Column(name = "host_name")
    @Size(max = 50)
    private String hostName;

    @Column(name = "created_on")
    private LocalDateTime createdOn;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pengunjung that)) return false;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (getSessionId() != null ? !getSessionId().equals(that.getSessionId()) : that.getSessionId() != null)
            return false;
        if (getCookieName() != null ? !getCookieName().equals(that.getCookieName()) : that.getCookieName() != null)
            return false;
        if (getUrl() != null ? !getUrl().equals(that.getUrl()) : that.getUrl() != null) return false;
        if (getIpAddress() != null ? !getIpAddress().equals(that.getIpAddress()) : that.getIpAddress() != null)
            return false;
        if (getOsType() != null ? !getOsType().equals(that.getOsType()) : that.getOsType() != null) return false;
        if (getOsVersion() != null ? !getOsVersion().equals(that.getOsVersion()) : that.getOsVersion() != null)
            return false;
        if (getBrowserName() != null ? !getBrowserName().equals(that.getBrowserName()) : that.getBrowserName() != null)
            return false;
        if (getBrowserType() != null ? !getBrowserType().equals(that.getBrowserType()) : that.getBrowserType() != null)
            return false;
        if (getBrowserVersion() != null ? !getBrowserVersion().equals(that.getBrowserVersion()) : that.getBrowserVersion() != null)
            return false;
        if (getDeviceType() != null ? !getDeviceType().equals(that.getDeviceType()) : that.getDeviceType() != null)
            return false;
        if (getHostAddress() != null ? !getHostAddress().equals(that.getHostAddress()) : that.getHostAddress() != null)
            return false;
        if (getHostName() != null ? !getHostName().equals(that.getHostName()) : that.getHostName() != null)
            return false;
        return getCreatedOn() != null ? getCreatedOn().equals(that.getCreatedOn()) : that.getCreatedOn() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getSessionId() != null ? getSessionId().hashCode() : 0);
        result = 31 * result + (getCookieName() != null ? getCookieName().hashCode() : 0);
        result = 31 * result + (getUrl() != null ? getUrl().hashCode() : 0);
        result = 31 * result + (getIpAddress() != null ? getIpAddress().hashCode() : 0);
        result = 31 * result + (getOsType() != null ? getOsType().hashCode() : 0);
        result = 31 * result + (getOsVersion() != null ? getOsVersion().hashCode() : 0);
        result = 31 * result + (getBrowserName() != null ? getBrowserName().hashCode() : 0);
        result = 31 * result + (getBrowserType() != null ? getBrowserType().hashCode() : 0);
        result = 31 * result + (getBrowserVersion() != null ? getBrowserVersion().hashCode() : 0);
        result = 31 * result + (getDeviceType() != null ? getDeviceType().hashCode() : 0);
        result = 31 * result + (getHostAddress() != null ? getHostAddress().hashCode() : 0);
        result = 31 * result + (getHostName() != null ? getHostName().hashCode() : 0);
        result = 31 * result + (getCreatedOn() != null ? getCreatedOn().hashCode() : 0);
        return result;
    }
}
