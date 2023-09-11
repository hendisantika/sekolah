package com.hendisantika.sekolah.dto;

import lombok.AllArgsConstructor;
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
@AllArgsConstructor
@NoArgsConstructor
public class AlbumDto {
    private Long id;
    private String nama;
    private String author;
}
