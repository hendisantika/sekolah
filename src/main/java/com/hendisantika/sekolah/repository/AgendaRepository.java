package com.hendisantika.sekolah.repository;

import com.hendisantika.sekolah.entity.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * Project : sekolah
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 18/03/20
 * Time: 07.07
 */
public interface AgendaRepository extends JpaRepository<Agenda, UUID> {
}
