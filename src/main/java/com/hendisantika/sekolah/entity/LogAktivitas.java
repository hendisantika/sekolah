package com.hendisantika.sekolah.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.UUID;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tbl_log_aktivitas")
@EntityListeners(AuditingEntityListener.class)
public class LogAktivitas {

    @Id
    @GeneratedValue(generator = "uuid2")
    @UuidGenerator
    @Column(name = "id")
    private UUID id;

    @Column(name = "nama")
    @Size(max = 200)
    private String nama;

    @Column(name = "ip")
    @Size(max = 20)
    private String ip;

    @Column(name = "icon")
    private byte[] icon;

    @Column(name = "jenis_icon")
    @Size(max = 50)
    private String jenisIcon;

    @Column(name = "created_by")
    @CreatedBy
    @Size(max = 50)
    private String createdBy;

    @Column(name = "created_on")
    @CreatedDate
    private LocalDateTime createdOn;

    @Column(name = "modified_by")
    @LastModifiedBy
    @Size(max = 50)
    private String modifiedBy;

    @Column(name = "modified_on")
    @LastModifiedDate
    private LocalDateTime modifiedOn;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LogAktivitas that)) return false;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (getNama() != null ? !getNama().equals(that.getNama()) : that.getNama() != null) return false;
        if (getIp() != null ? !getIp().equals(that.getIp()) : that.getIp() != null) return false;
        if (!Arrays.equals(getIcon(), that.getIcon())) return false;
        if (getJenisIcon() != null ? !getJenisIcon().equals(that.getJenisIcon()) : that.getJenisIcon() != null)
            return false;
        if (getCreatedBy() != null ? !getCreatedBy().equals(that.getCreatedBy()) : that.getCreatedBy() != null)
            return false;
        if (getCreatedOn() != null ? !getCreatedOn().equals(that.getCreatedOn()) : that.getCreatedOn() != null)
            return false;
        if (getModifiedBy() != null ? !getModifiedBy().equals(that.getModifiedBy()) : that.getModifiedBy() != null)
            return false;
        return getModifiedOn() != null ? getModifiedOn().equals(that.getModifiedOn()) : that.getModifiedOn() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getNama() != null ? getNama().hashCode() : 0);
        result = 31 * result + (getIp() != null ? getIp().hashCode() : 0);
        result = 31 * result + Arrays.hashCode(getIcon());
        result = 31 * result + (getJenisIcon() != null ? getJenisIcon().hashCode() : 0);
        result = 31 * result + (getCreatedBy() != null ? getCreatedBy().hashCode() : 0);
        result = 31 * result + (getCreatedOn() != null ? getCreatedOn().hashCode() : 0);
        result = 31 * result + (getModifiedBy() != null ? getModifiedBy().hashCode() : 0);
        result = 31 * result + (getModifiedOn() != null ? getModifiedOn().hashCode() : 0);
        return result;
    }
}
