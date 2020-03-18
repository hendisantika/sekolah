package com.hendisantika.sekolah.repository;

import com.hendisantika.sekolah.entity.Guru;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GuruRepository extends JpaRepository<Guru, UUID> {
}
