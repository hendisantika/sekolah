package com.hendisantika.sekolah.repository;

import com.hendisantika.sekolah.entity.Komentar;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KomentarRepository extends JpaRepository<Komentar, UUID> {
    List<Komentar> findByTulisanIdAndStatusAndParent(UUID slug, String status, int parent);

    List<Komentar> findByStatusAndParentOrderByCreatedOnAsc(String status, int parent);
}
