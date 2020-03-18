package com.hendisantika.sekolah.repository;

import com.hendisantika.sekolah.entity.Galeri;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GaleriRepository extends JpaRepository<Galeri, UUID> {
}
