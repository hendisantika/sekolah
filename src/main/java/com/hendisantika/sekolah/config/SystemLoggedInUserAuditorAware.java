package com.hendisantika.sekolah.config;

import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 * Project : sekolah
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 28/03/20
 * Time: 12.46
 */
@Component
@Slf4j
public class SystemLoggedInUserAuditorAware implements AuditorAware<String> {

//  @Override
//  public Optional<String> getCurrentAuditor() {
//    return Optional.ofNullable(System.getProperty("user.name"));
//  }

  @Override
  public Optional<String> getCurrentAuditor() {
    Optional<User> user = Optional.ofNullable(SecurityContextHolder.getContext())
            .map(SecurityContext::getAuthentication)
            .filter(Authentication::isAuthenticated)
            .map(Authentication::getPrincipal)
            .map(User.class::cast);
    if (user.isPresent()) {
      User userLogin = user.get();
      return Optional.ofNullable(userLogin.getUsername());
    }
    return Optional.empty();
  }
}