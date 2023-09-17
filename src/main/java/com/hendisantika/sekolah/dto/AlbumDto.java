package com.hendisantika.sekolah.dto;

import lombok.*;

import java.util.UUID;

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
public class AlbumDto {
    private UUID id;
    private String nama;
    private String author;
}
