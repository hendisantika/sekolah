package com.hendisantika.sekolah.config;

import com.hendisantika.sekolah.repository.PenggunaRepository;
import com.hendisantika.sekolah.security.AuthenticationFailureHandler;
import com.hendisantika.sekolah.service.impl.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * Created by IntelliJ IDEA.
 * Project : sekolah
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 17/03/20
 * Time: 21.22
 */
@Configuration
@EnableMethodSecurity
@EnableWebSecurity
public class SecurityConfig {
    private static final String LOGIN = "/login";
    private static final String[] PUBLIC_LINK = new String[]{
            "/", "/about", "/guru", "/siswa", "/blog", "/pengumuman", "/agenda", "/download",
            "/galeri", "/contact", LOGIN, "/logout", "/v1/api/**",
            "/test", "/test2", "/test3", "/tes/**"
    };

    private final PenggunaRepository userRepository;
    private static final String[] PRIVATE_LINK = new String[]{
            "/admin/**"
    };

    public SecurityConfig(PenggunaRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationFailureHandler authenticationFailureHandler() {
        return new AuthenticationFailureHandler();
    }
    /*
     * Tell Spring Security to use the custom built UserDetailsServiceImpl class
     *
     */


    protected void configure(AuthenticationManagerBuilder authBuilder) throws Exception {
        authBuilder.userDetailsService(userDetailsServiceBean()).passwordEncoder(passwordEncoder());
    }

    public UserDetailsService userDetailsServiceBean() {
        return new UserDetailsServiceImpl(userRepository);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                //you can either disable this or
                //put <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                //inside the login form
                .csrf((csrf) -> csrf.disable())
                .authorizeHttpRequests((authz) -> authz
                        .requestMatchers("/ignore1", "/ignore2" , "/assets/**", "/css/**", "/img/**",
                                "/js**", "/plugins/**", "/theme/**", "/templates/**").permitAll()
                        .requestMatchers(PUBLIC_LINK).permitAll()
                        .requestMatchers(PRIVATE_LINK).hasAnyAuthority("ADMIN", "USER")
                        .anyRequest().authenticated()
                )
                .formLogin(formLogin -> formLogin
                        .loginPage(LOGIN) //enable this to go to your own custom login page
                        .loginProcessingUrl(LOGIN) //enable this to use login page provided by spring security
                        .defaultSuccessUrl("/admin/dashboard", true)
                        .failureUrl("/login?error")
                )
                .logout(logout -> logout
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                        .logoutSuccessUrl("/login?logout")
                );
        return http.build();
    }

    /*
     *
     * These resources are available to every users
     */

    // by spring "You are asking Spring Security to ignore Mvc [pattern='/ignore1']" This is not recommended
//    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer() {
//        return (web) -> web.ignoring()
//                .requestMatchers("/ignore1", "/ignore2")
//                .requestMatchers("/assets/**")
//                .requestMatchers("/css/**")
//                .requestMatchers("/img/**")
//                .requestMatchers("/js**")
//                .requestMatchers("/plugins/**")
//                .requestMatchers("/theme/**")
//                .requestMatchers("/templates/**");
//    }
}
