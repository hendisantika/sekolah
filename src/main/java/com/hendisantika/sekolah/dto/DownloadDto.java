package com.hendisantika.sekolah.dto;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * Project : sekolah
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 17/03/20
 * Time: 15.55
 */
public record DownloadDto(UUID id, String judul, String deskripsi, String author, String filename, byte[] fileContent,
        int download,
        String data,
        String createdBy,
        LocalDateTime createdOn,
        String modifiedBy,
        LocalDateTime modifiedOn) {

    public DownloadDto() {
        this(UUID.randomUUID(),
                Random.class.getSimpleName(),
                Random.class.getSimpleName(),
                "yeahbutstill",
                Random.class.getSimpleName(),
                Arrays.copyOf(new byte[0], 0),
                0,
                Random.class.getSimpleName(),
                "yeahbutstill",
                LocalDateTime.now(),
                "yeahbutstill",
                LocalDateTime.now()
                );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DownloadDto that)) return false;

        if (download != that.download) return false;
        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(judul, that.judul)) return false;
        if (!Objects.equals(deskripsi, that.deskripsi)) return false;
        if (!Objects.equals(author, that.author)) return false;
        if (!Objects.equals(filename, that.filename)) return false;
        if (!Arrays.equals(fileContent, that.fileContent)) return false;
        if (!Objects.equals(data, that.data)) return false;
        if (!Objects.equals(createdBy, that.createdBy)) return false;
        if (!Objects.equals(createdOn, that.createdOn)) return false;
        if (!Objects.equals(modifiedBy, that.modifiedBy)) return false;
        return Objects.equals(modifiedOn, that.modifiedOn);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (judul != null ? judul.hashCode() : 0);
        result = 31 * result + (deskripsi != null ? deskripsi.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (filename != null ? filename.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(fileContent);
        result = 31 * result + download;
        result = 31 * result + (data != null ? data.hashCode() : 0);
        result = 31 * result + (createdBy != null ? createdBy.hashCode() : 0);
        result = 31 * result + (createdOn != null ? createdOn.hashCode() : 0);
        result = 31 * result + (modifiedBy != null ? modifiedBy.hashCode() : 0);
        result = 31 * result + (modifiedOn != null ? modifiedOn.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "DownloadDto{" +
                "id=" + id +
                ", judul='" + judul + '\'' +
                ", deskripsi='" + deskripsi + '\'' +
                ", author='" + author + '\'' +
                ", filename='" + filename + '\'' +
                ", fileContent=" + Arrays.toString(fileContent) +
                ", download=" + download +
                ", data='" + data + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", createdOn=" + createdOn +
                ", modifiedBy='" + modifiedBy + '\'' +
                ", modifiedOn=" + modifiedOn +
                '}';
    }
}
