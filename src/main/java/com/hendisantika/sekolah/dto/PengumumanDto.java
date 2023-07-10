package com.hendisantika.sekolah.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
 * Date: 18/03/20
 * Time: 06.41
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PengumumanDto {
    @NotNull
    private UUID id;

    @NotEmpty
    @NotBlank
    private String judul;

    @NotEmpty
    @NotBlank
    private String deskripsi;

    @NotEmpty
    @NotBlank
    private String author;

    @NotEmpty
    @NotBlank
    private String createdBy;

    private LocalDateTime createdOn;

    @NotEmpty
    @NotBlank
    private String modifiedBy;

    private LocalDateTime modifiedOn;

}
