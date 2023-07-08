package com.hendisantika.sekolah.security;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * Project : sekolah
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 21/03/20
 * Time: 06.39
 */
public class AuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException {
        String errorMessage = "failed login attempt. invalid username or password";
        if (exception.getMessage().equalsIgnoreCase("blocked")) {
            errorMessage = "you have been blocked for 3 unsuccessful login attempt";
        }
        System.out.println("path " + request.getPathInfo());
        response.sendRedirect(request.getPathInfo());
    }

}