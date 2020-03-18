package com.hendisantika.sekolah.repository;

import com.hendisantika.sekolah.entity.Inbox;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InboxRepository extends JpaRepository<Inbox, UUID> {
}
