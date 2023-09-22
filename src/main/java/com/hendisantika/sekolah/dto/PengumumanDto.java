package com.hendisantika.sekolah.dto;

import com.hendisantika.sekolah.enumeration.STATUSRECORD;
import jakarta.persistence.Version;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * Project : sekolah
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 03/04/20
 * Time: 08.47
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PengumumanDto {
    private UUID id;
    private String judul;
    private String deskripsi;
}
