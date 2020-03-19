package com.hendisantika.sekolah.repository;

import com.hendisantika.sekolah.entity.Pengumuman;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * Project : sekolah
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 18/03/20
 * Time: 06.43
 */
public interface PengumumanRepository extends JpaRepository<Pengumuman, UUID> {
    @Query(value = "SELECT p.* FROM tbl_pengumuman p ORDER BY p.pengumuman_tanggal DESC limit 4;", nativeQuery = true)
    List<Pengumuman> findTop4();

    List<Pengumuman> findByOrderByTanggalDesc();
}
