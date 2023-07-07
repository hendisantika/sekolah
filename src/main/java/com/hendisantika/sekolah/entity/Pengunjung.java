package com.hendisantika.sekolah.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

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
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tbl_pengunjung")
@SQLDelete(sql = "UPDATE tbl_pengunjung SET status_record='INACTIVE' WHERE id=?")
@Where(clause = "status_record='ACTIVE'")
public class Pengunjung extends AuditTableEntity<UUID> {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pengunjung that)) return false;
        if (!super.equals(o)) return false;

        if (!getSessionId().equals(that.getSessionId())) return false;
        if (!getCookieName().equals(that.getCookieName())) return false;
        if (!getUrl().equals(that.getUrl())) return false;
        if (!getIpAddress().equals(that.getIpAddress())) return false;
        if (!getOsType().equals(that.getOsType())) return false;
        if (!getOsVersion().equals(that.getOsVersion())) return false;
        if (!getBrowserName().equals(that.getBrowserName())) return false;
        if (!getBrowserType().equals(that.getBrowserType())) return false;
        if (!getBrowserVersion().equals(that.getBrowserVersion())) return false;
        if (!getDeviceType().equals(that.getDeviceType())) return false;
        if (!getHostAddress().equals(that.getHostAddress())) return false;
        if (!getHostName().equals(that.getHostName())) return false;
        return getCreatedOn().equals(that.getCreatedOn());
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getSessionId().hashCode();
        result = 31 * result + getCookieName().hashCode();
        result = 31 * result + getUrl().hashCode();
        result = 31 * result + getIpAddress().hashCode();
        result = 31 * result + getOsType().hashCode();
        result = 31 * result + getOsVersion().hashCode();
        result = 31 * result + getBrowserName().hashCode();
        result = 31 * result + getBrowserType().hashCode();
        result = 31 * result + getBrowserVersion().hashCode();
        result = 31 * result + getDeviceType().hashCode();
        result = 31 * result + getHostAddress().hashCode();
        result = 31 * result + getHostName().hashCode();
        result = 31 * result + getCreatedOn().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Pengunjung{" +
                "sessionId='" + sessionId + '\'' +
                ", cookieName='" + cookieName + '\'' +
                ", url='" + url + '\'' +
                ", ipAddress='" + ipAddress + '\'' +
                ", osType='" + osType + '\'' +
                ", osVersion='" + osVersion + '\'' +
                ", browserName='" + browserName + '\'' +
                ", browserType='" + browserType + '\'' +
                ", browserVersion='" + browserVersion + '\'' +
                ", deviceType='" + deviceType + '\'' +
                ", hostAddress='" + hostAddress + '\'' +
                ", hostName='" + hostName + '\'' +
                ", createdOn=" + createdOn +
                '}';
    }
}
