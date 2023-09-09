package com.hendisantika.sekolah.repository;

import com.hendisantika.sekolah.entity.Testimoni;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 * Project : sekolah
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 18/03/20
 * Time: 18.56
 */
@Repository
public interface TestimoniRepository extends JpaRepository<Testimoni, UUID> {
}
