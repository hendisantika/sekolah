package com.hendisantika.sekolah.dto;

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
 * Date: 17/03/20
 * Time: 15.55
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DownloadDto {
    private UUID id;

    private String judul;

    private String deskripsi;

    private String author;

    private String filename;

    private byte[] fileContent;

    private int download;

    private String data;

    private String createdBy;

    private LocalDateTime createdOn;

    private String modifiedBy;

    private LocalDateTime modifiedOn;

}
