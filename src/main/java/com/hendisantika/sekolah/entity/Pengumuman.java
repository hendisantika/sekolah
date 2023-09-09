package com.hendisantika.sekolah.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * Created by IntelliJ IDEA.
 * Project : sekolah
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 18/03/20
 * Time: 06.41
 */
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tbl_pengumuman")
@EntityListeners(AuditingEntityListener.class)
public class Pengumuman {
    @Id
    @GeneratedValue(generator = "uuid2")
    @UuidGenerator
    @Column(name = "id")
    private UUID id;

    @Column(name = "judul")
    @Size(max = 150)
    private String judul;

    @Column(name = "deskripsi")
    private String deskripsi;

    @Column(name = "author")
    @Size(max = 60)
    private String author;

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
        if (!(o instanceof Pengumuman that)) return false;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (getJudul() != null ? !getJudul().equals(that.getJudul()) : that.getJudul() != null) return false;
        if (getDeskripsi() != null ? !getDeskripsi().equals(that.getDeskripsi()) : that.getDeskripsi() != null)
            return false;
        if (getAuthor() != null ? !getAuthor().equals(that.getAuthor()) : that.getAuthor() != null) return false;
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
        result = 31 * result + (getJudul() != null ? getJudul().hashCode() : 0);
        result = 31 * result + (getDeskripsi() != null ? getDeskripsi().hashCode() : 0);
        result = 31 * result + (getAuthor() != null ? getAuthor().hashCode() : 0);
        result = 31 * result + (getCreatedBy() != null ? getCreatedBy().hashCode() : 0);
        result = 31 * result + (getCreatedOn() != null ? getCreatedOn().hashCode() : 0);
        result = 31 * result + (getModifiedBy() != null ? getModifiedBy().hashCode() : 0);
        result = 31 * result + (getModifiedOn() != null ? getModifiedOn().hashCode() : 0);
        return result;
    }
}
