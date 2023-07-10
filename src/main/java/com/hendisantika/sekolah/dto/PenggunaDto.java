package com.hendisantika.sekolah.dto;

import com.hendisantika.sekolah.entity.Role;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PenggunaDto {
    @NotNull
    private Long id;

    @NotEmpty
    @NotBlank
    private String fullname;

    @NotEmpty
    @NotBlank
    private String moto;

    @NotEmpty
    @NotBlank
    private String jenkel;

    @NotEmpty
    @NotBlank
    private String username;

    @NotEmpty
    @NotBlank
    private String password;

    @NotEmpty
    @NotBlank
    private String tentang;

    @NotEmpty
    @NotBlank
    @Email
    private String email;

    @NotEmpty
    @NotBlank
    private String nohp;

    @NotEmpty
    @NotBlank
    private String facebook;

    @NotEmpty
    @NotBlank
    private String witter;

    @NotEmpty
    @NotBlank
    private String linkedin;

    @PositiveOrZero
    private int status;

    @NotEmpty
    @NotBlank
    private String level;

    @NotEmpty
    @NotBlank
    private String photo;

    @NotEmpty
    @NotBlank
    private String photoBase64;

    @NotEmpty
    @NotBlank
    private String filename;

    private byte[] fileContent;

    private boolean active;

    private LocalDateTime register;

    @NotNull
    private List<Role> roles;

    @NotEmpty
    @NotBlank
    private String createdBy;

    private LocalDateTime createdOn;

    @NotEmpty
    @NotBlank
    private String modifiedBy;

    private LocalDateTime modifiedOn;
}
