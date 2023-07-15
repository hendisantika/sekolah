package com.hendisantika.sekolah.dto;

import com.hendisantika.sekolah.entity.Kelas;
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
public class SiswaDto {
    private UUID id;
    private String nis;
    private String nama;
    private String jenkel;
    private String photo;
    private String photoBase64;
    private Kelas kelas;
    private String filename;
    private byte[] fileContent;
    private String createdBy;
    private LocalDateTime createdOn;
    private String modifiedBy;
    private LocalDateTime modifiedOn;
}
