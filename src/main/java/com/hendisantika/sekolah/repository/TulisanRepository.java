package com.hendisantika.sekolah.repository;

import com.hendisantika.sekolah.entity.Tulisan;
import org.springframework.data.jpa.repository.JpaRepository;

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
}
