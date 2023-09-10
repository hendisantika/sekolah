package com.hendisantika.sekolah.repository;

import com.hendisantika.sekolah.entity.Files;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * Project : sekolah
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 18/03/20
 * Time: 18.31
 */
@Repository
public interface FilesRepository extends JpaRepository<Files, UUID> {
}
