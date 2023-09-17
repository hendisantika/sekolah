package com.hendisantika.sekolah.repository;

import com.hendisantika.sekolah.entity.Pengguna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PenggunaRepository extends JpaRepository<Pengguna, Long> {
    Optional<Pengguna> findByUsername(String username);
}
