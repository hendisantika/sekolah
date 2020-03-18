package com.hendisantika.sekolah.repository;

import com.hendisantika.sekolah.entity.Siswa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SiswaRepository extends JpaRepository<Siswa, UUID> {
}
