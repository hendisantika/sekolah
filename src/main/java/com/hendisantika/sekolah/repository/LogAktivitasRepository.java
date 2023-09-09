package com.hendisantika.sekolah.repository;

import com.hendisantika.sekolah.entity.LogAktivitas;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogAktivitasRepository extends JpaRepository<LogAktivitas, UUID> {
}
