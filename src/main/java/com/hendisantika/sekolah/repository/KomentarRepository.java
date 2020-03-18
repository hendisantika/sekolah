package com.hendisantika.sekolah.repository;

import com.hendisantika.sekolah.entity.Komentar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface KomentarRepository extends JpaRepository<Komentar, UUID> {
}
