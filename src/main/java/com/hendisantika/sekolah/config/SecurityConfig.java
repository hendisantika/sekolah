package com.hendisantika.sekolah.config;

import com.hendisantika.sekolah.repository.PenggunaRepository;
import com.hendisantika.sekolah.security.AuthenticationFailureHandler;
import com.hendisantika.sekolah.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import static com.hendisantika.sekolah.constant.Constants.LOGIN;

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
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    private static final String[] PUBLIC_LINK = new String[]{
            "/**"
    };

    private static final String[] PRIVATE_LINK = new String[]{
            "/admin/**"
    };

    private final PenggunaRepository userRepository;

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

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

        authProvider.setUserDetailsService(userDetailsServiceBean());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    @Bean
    public UserDetailsService userDetailsServiceBean() {
        return new UserDetailsServiceImpl(userRepository);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                //you can either disable this or
                //put <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                //inside the login form
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(authz -> authz
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

        http.authenticationProvider(authenticationProvider());

        return http.build();
    }

}
