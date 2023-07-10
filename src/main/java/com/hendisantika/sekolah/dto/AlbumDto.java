package com.hendisantika.sekolah.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by IntelliJ IDEA.
 * Project : sekolah
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 03/04/20
 * Time: 08.47
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AlbumDto {
    @NotNull
    private Long id;

    @NotBlank
    @NotEmpty
    private String nama;

    @NotBlank
    @NotEmpty
    private String author;
}
