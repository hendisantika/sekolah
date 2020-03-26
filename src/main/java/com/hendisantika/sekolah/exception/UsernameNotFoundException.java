package com.hendisantika.sekolah.exception;

/**
 * Created by IntelliJ IDEA.
 * Project : sekolah
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 26/03/20
 * Time: 09.41
 */
public class UsernameNotFoundException extends RuntimeException {
    public UsernameNotFoundException() {
        super("Username Not Found.");
    }

    public UsernameNotFoundException(String message) {
        super(message);
    }
}
