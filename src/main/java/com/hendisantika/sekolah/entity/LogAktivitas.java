package com.hendisantika.sekolah.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.Arrays;
import java.util.UUID;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tbl_log_aktivitas")
@SQLDelete(sql = "UPDATE tbl_log_aktivitas SET status_record='INACTIVE' WHERE id=?")
@Where(clause = "status_record='ACTIVE'")
public class LogAktivitas extends AuditTableEntity<UUID> {

    @Column(name = "nama")
    private String nama;

    @Column(name = "ip")
    private String ip;

    @Column(name = "icon")
    private byte[] icon;

    @Column(name = "jenis_icon")
    private String jenisIcon;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LogAktivitas that)) return false;
        if (!super.equals(o)) return false;

        if (!getNama().equals(that.getNama())) return false;
        if (!getIp().equals(that.getIp())) return false;
        if (!Arrays.equals(getIcon(), that.getIcon())) return false;
        return getJenisIcon().equals(that.getJenisIcon());
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getNama().hashCode();
        result = 31 * result + getIp().hashCode();
        result = 31 * result + Arrays.hashCode(getIcon());
        result = 31 * result + getJenisIcon().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "LogAktivitas{" +
                "nama='" + nama + '\'' +
                ", ip='" + ip + '\'' +
                ", icon=" + Arrays.toString(icon) +
                ", jenisIcon='" + jenisIcon + '\'' +
                '}';
    }
}
