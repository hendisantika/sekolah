package com.hendisantika.sekolah.repository;

import com.hendisantika.sekolah.entity.Pengunjung;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PengunjungRepository extends JpaRepository<Pengunjung, UUID> {
}
