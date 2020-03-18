package com.hendisantika.sekolah.repository;

import com.hendisantika.sekolah.entity.Pengguna;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PenggunaRepository extends JpaRepository<Pengguna, UUID> {
}
