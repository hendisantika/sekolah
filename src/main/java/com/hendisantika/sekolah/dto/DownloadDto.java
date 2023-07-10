package com.hendisantika.sekolah.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DownloadDto {
    @NotNull
    private UUID id;

    @NotEmpty
    @NotBlank
    private String judul;

    @NotBlank
    @NotEmpty
    private String deskripsi;

    @NotEmpty
    @NotBlank
    private String author;

    @NotBlank
    @NotEmpty
    private String filename;

    private byte[] fileContent;

    @PositiveOrZero
    private int download;

    @NotEmpty
    @NotBlank
    private String data;

    @NotEmpty
    @NotBlank
    private String createdBy;

    private LocalDateTime createdOn;

    @NotEmpty
    @NotBlank
    private String modifiedBy;

    private LocalDateTime modifiedOn;

}
