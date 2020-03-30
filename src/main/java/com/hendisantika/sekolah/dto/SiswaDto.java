package com.hendisantika.sekolah.dto;

import com.hendisantika.sekolah.entity.Kelas;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * Project : sekolah
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 18/03/20
 * Time: 18.49
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SiswaDto {
    private UUID id;

    private String nis;

    private String nama;

    private String jenkel;

    private String photo;

    private Kelas kelas;

    private String filename;

    private byte[] fileContent;

    private String createdBy;

    private LocalDateTime createdOn;

    private String modifiedBy;

    private LocalDateTime modifiedOn;
}
