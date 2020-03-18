package com.hendisantika.sekolah.repository;

import com.hendisantika.sekolah.entity.Kelas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface KelasRepository extends JpaRepository<Kelas, UUID> {
}
