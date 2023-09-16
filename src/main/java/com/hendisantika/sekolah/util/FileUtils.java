package com.hendisantika.sekolah.util;

import org.apache.tomcat.util.codec.binary.Base64;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * Created by IntelliJ IDEA.
 * Project : sekolah
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 25/03/20
 * Time: 21.45
 */
public class FileUtils {
    private FileUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static String encodeFileToBase64Binary(File file) {
        byte[] bytes;
        try (FileInputStream fileInputStreamReader = new FileInputStream(file)) {
            bytes = new byte[(int) file.length()];
            fileInputStreamReader.read(bytes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return new String(Base64.encodeBase64(bytes, false), StandardCharsets.UTF_8);
    }

    /**
     * Encodes the byte array into base64 string
     *
     * @param imageByteArray - byte array
     * @return String a {@link String}
     */
    public static String encodeBase64URLSafeString(byte[] imageByteArray) {
        return Base64.encodeBase64URLSafeString(imageByteArray);
    }

    /**
     * Decodes the base64 string into byte array
     *
     * @param imageDataString - a {@link String}
     * @return byte array
     */
    public static byte[] decodeBase64(String imageDataString) {
        return Base64.decodeBase64(imageDataString);
    }
}
