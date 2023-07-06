package com.hendisantika.sekolah.enumeration;

import jakarta.servlet.http.HttpServletRequest;


/**
 * Created by IntelliJ IDEA.
 * Project : sekolah
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 24/03/20
 * Time: 05.48
 */
public enum OS {
    WINDOWS,
    MAC,
    LINUX,
    ANDROID,
    IPHONE,
    UNKNOWN;

    public static OS valueOf(HttpServletRequest request) {
        final String userAgent = request.getHeader("User-Agent");
        final OS toReturn;

        if (userAgent == null || userAgent.isEmpty()) {
            toReturn = UNKNOWN;
        } else if (userAgent.toLowerCase().contains("windows")) {
            toReturn = WINDOWS;
        } else if (userAgent.toLowerCase().contains("mac")) {
            toReturn = MAC;
        } else if (userAgent.toLowerCase().contains("x11")) {
            toReturn = LINUX;
        } else if (userAgent.toLowerCase().contains("android")) {
            toReturn = ANDROID;
        } else if (userAgent.toLowerCase().contains("iphone")) {
            toReturn = IPHONE;
        } else {
            toReturn = UNKNOWN;
        }

        return toReturn;
    }
}
