package com.hendisantika.sekolah.repository;

import com.hendisantika.sekolah.entity.Guru;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuruRepository extends JpaRepository<Guru, UUID> {
}
