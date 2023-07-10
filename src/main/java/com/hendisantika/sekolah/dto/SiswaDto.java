package com.hendisantika.sekolah.dto;

import com.hendisantika.sekolah.entity.Kelas;
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
 * Time: 18.49
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SiswaDto {
    @NotNull
    private UUID id;

    @NotEmpty
    @NotBlank
    private String nis;

    @NotEmpty
    @NotBlank
    private String nama;

    @NotEmpty
    @NotBlank
    private String jenkel;

    @NotEmpty
    @NotBlank
    private String photo;

    @NotEmpty
    @NotBlank
    private String photoBase64;

    @NotNull
    private Kelas kelas;

    @NotEmpty
    @NotBlank
    private String filename;

    private byte[] fileContent;

    @NotEmpty
    @NotBlank
    private String createdBy;

    private LocalDateTime createdOn;

    @NotEmpty
    @NotBlank
    private String modifiedBy;

    private LocalDateTime modifiedOn;
}
