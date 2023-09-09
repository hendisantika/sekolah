package com.hendisantika.sekolah.repository;

import com.hendisantika.sekolah.entity.Pengguna;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PenggunaRepository extends JpaRepository<Pengguna, Long> {
    Optional<Pengguna> findByUsername(String username);
}
