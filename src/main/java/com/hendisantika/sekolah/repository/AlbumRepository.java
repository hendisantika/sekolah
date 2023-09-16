package com.hendisantika.sekolah.repository;

import com.hendisantika.sekolah.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * Project : sekolah
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 03/04/20
 * Time: 07.53
 */
@Repository
public interface AlbumRepository extends JpaRepository<Album, UUID> {
}
