package com.hendisantika.sekolah.repository;

import com.hendisantika.sekolah.entity.Inbox;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InboxRepository extends JpaRepository<Inbox, UUID> {
}
