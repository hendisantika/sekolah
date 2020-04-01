package com.hendisantika.sekolah.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GuruDto {

    private UUID id;

    private String nip;

    private String nama;

    private String jenkel;

    private String tmpLahir;

    private LocalDate tglLahir;

    private String mapel;

    private String photo;

    private String photoBase64;

    private String filename;

    private byte[] fileContent;

    private String createdBy;

    private LocalDateTime createdOn;

    private String modifiedBy;

    private LocalDateTime modifiedOn;
}
