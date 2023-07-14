package com.hendisantika.sekolah.dto;

/**
 * Created by IntelliJ IDEA.
 * Project : sekolah
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 03/04/20
 * Time: 08.47
 */
public record AlbumDto(Long id, String nama, String author) {
    public AlbumDto() {
        this(1L, "Default", "yeahbutstill");
    }
}
