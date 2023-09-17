package com.hendisantika.sekolah.repository;

import com.hendisantika.sekolah.entity.Galeri;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GaleriRepository extends JpaRepository<Galeri, Long> {
}
