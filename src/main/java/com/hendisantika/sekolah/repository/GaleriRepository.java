package com.hendisantika.sekolah.repository;

import com.hendisantika.sekolah.entity.Galeri;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface GaleriRepository extends JpaRepository<Galeri, UUID> {
}
