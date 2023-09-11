package com.hendisantika.sekolah.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by IntelliJ IDEA.
 * Project : sekolah
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 24/03/20
 * Time: 09.05
 */
/* Name "RequestLogger" to be able to use @Autowired in the configuration */
@Component("RequestLogger")
@Slf4j
public class RequestLogger implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler)
            throws Exception {

        /* Logs the "wrong" ip - the ip of the reverse proxy, in our example 127.0.0.1 */
        log.info("Page {} was requested by IP {}", request.getRequestURI(), request.getRemoteAddr());
        log.info("Page {} was requested by Hostname {}", request.getRequestURI(), request.getRemoteHost());
        /* Logs the "real" remote ip address, as set by Nginx */
        log.info("Page {} was requested by IP {}", request.getRequestURI(), request.getHeader("X-Forwarded-For"));

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {
        // TODO document why this method is empty
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {
        // TODO document why this method is empty
    }
}