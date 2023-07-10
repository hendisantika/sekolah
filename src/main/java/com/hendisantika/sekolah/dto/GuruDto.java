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

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GuruDto {

    @NotNull
    private UUID id;

    @NotBlank
    @NotEmpty
    private String nip;

    @NotBlank
    @NotEmpty
    private String nama;

    @NotBlank
    @NotEmpty
    private String jenkel;

    @NotBlank
    @NotEmpty
    private String tmpLahir;

    @NotBlank
    @NotEmpty
    private String tglLahir;

    @NotBlank
    @NotEmpty
    private String mapel;

    @NotBlank
    @NotEmpty
    private String photo;

    @NotBlank
    @NotEmpty
    private String photoBase64;

    @NotBlank
    @NotEmpty
    private String filename;

    private byte[] fileContent;

    @NotBlank
    @NotEmpty
    private String createdBy;

    private LocalDateTime createdOn;

    @NotBlank
    @NotEmpty
    private String modifiedBy;

    private LocalDateTime modifiedOn;
}
