package com.hendisantika.sekolah.repository;

import com.hendisantika.sekolah.entity.Kelas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface KelasRepository extends JpaRepository<Kelas, UUID> {
}
