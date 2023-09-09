package com.hendisantika.sekolah.security;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

/**
 * Created by IntelliJ IDEA.
 * Project : sekolah
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 21/03/20
 * Time: 06.39
 */
@Slf4j
public class AuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException {
        String errorMessage = "failed login attempt. invalid username or password";
        log.error(errorMessage);
        if (exception.getMessage().equalsIgnoreCase("blocked")) {
            errorMessage = "you have been blocked for 3 unsuccessful login attempt";
            log.error(errorMessage);
        }
        log.info("path {}", request.getPathInfo());
        response.sendRedirect(request.getPathInfo());
    }

}