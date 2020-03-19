package com.hendisantika.sekolah.repository;

import com.hendisantika.sekolah.entity.Tulisan;
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
 * Date: 17/03/20
 * Time: 23.33
 */
public interface TulisanRepository extends JpaRepository<Tulisan, UUID> {
    @Query(value = "SELECT t.* FROM tbl_tulisan t ORDER BY t.tulisan_tanggal DESC limit 4;", nativeQuery = true)
    List<Tulisan> findTop4();

    Tulisan findBySlug(String slug);

    List<Tulisan> findByOrderByViewsDesc();
}
