package com.hendisantika.sekolah.dto;

import com.hendisantika.sekolah.entity.Role;
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
    private Long id;

    private String fullname;

    private String moto;

    private String jenkel;

    private String username;

    private String password;

    private String tentang;

    private String email;

    private String nohp;

    private String facebook;

    private String witter;

    private String linkedin;

    private int status;

    private String level;

    private String photo;

    private String filename;

    private byte[] fileContent;

    private boolean active;

    private LocalDateTime register;

    private List<Role> roles;

    private String createdBy;

    private LocalDateTime createdOn;

    private String modifiedBy;

    private LocalDateTime modifiedOn;
}
