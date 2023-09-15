package com.hendisantika.sekolah.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tbl_kelas")
@EntityListeners(AuditingEntityListener.class)
public class Kelas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nama")
    @Size(max = 25)
    private String nama;

    @OneToMany(mappedBy = "kelas", fetch = FetchType.LAZY)
    @ToString.Exclude
    @NotNull
    private Set<Siswa> siswa = new HashSet<>();

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
        if (!(o instanceof Kelas kelas)) return false;

        if (getId() != kelas.getId()) return false;
        if (getNama() != null ? !getNama().equals(kelas.getNama()) : kelas.getNama() != null) return false;
        if (getSiswa() != null ? !getSiswa().equals(kelas.getSiswa()) : kelas.getSiswa() != null) return false;
        if (getCreatedBy() != null ? !getCreatedBy().equals(kelas.getCreatedBy()) : kelas.getCreatedBy() != null)
            return false;
        if (getCreatedOn() != null ? !getCreatedOn().equals(kelas.getCreatedOn()) : kelas.getCreatedOn() != null)
            return false;
        if (getModifiedBy() != null ? !getModifiedBy().equals(kelas.getModifiedBy()) : kelas.getModifiedBy() != null)
            return false;
        return getModifiedOn() != null ? getModifiedOn().equals(kelas.getModifiedOn()) : kelas.getModifiedOn() == null;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getNama() != null ? getNama().hashCode() : 0);
        result = 31 * result + (getSiswa() != null ? getSiswa().hashCode() : 0);
        result = 31 * result + (getCreatedBy() != null ? getCreatedBy().hashCode() : 0);
        result = 31 * result + (getCreatedOn() != null ? getCreatedOn().hashCode() : 0);
        result = 31 * result + (getModifiedBy() != null ? getModifiedBy().hashCode() : 0);
        result = 31 * result + (getModifiedOn() != null ? getModifiedOn().hashCode() : 0);
        return result;
    }
}
