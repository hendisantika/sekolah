package com.hendisantika.sekolah.repository;

import com.hendisantika.sekolah.entity.LogAktivitas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LogAktivitasRepository extends JpaRepository<LogAktivitas, UUID> {
}
