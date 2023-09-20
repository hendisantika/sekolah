package com.hendisantika.sekolah.exception;

/**
 * Created by IntelliJ IDEA.
 * Project : sekolah
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 24/03/20
 * Time: 17.49
 */
public class KategoriNotFoundException extends Exception {
    public KategoriNotFoundException() {
        super("Kategori Not Found Exception");
    }

    public KategoriNotFoundException(String message) {
        super(message);
    }
}
