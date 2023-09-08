package com.hendisantika.sekolah.dto;

import com.hendisantika.sekolah.entity.Role;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

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
@ToString
@EqualsAndHashCode
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
    private String photoBase64;
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
