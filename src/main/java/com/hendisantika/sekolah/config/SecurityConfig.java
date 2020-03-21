package com.hendisantika.sekolah.config;

import com.hendisantika.sekolah.repository.PenggunaRepository;
import com.hendisantika.sekolah.security.AuthenticationFailureHandler;
import com.hendisantika.sekolah.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

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
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private static final String SQL_LOGIN = "select p.username as username, " +
            "p.password as password " +
            "from pengguna p where p.username = ?";

    private static final String SQL_PERMISSION = "select p.username as username, " +
            "'ROLE_USER' as authority " +
            "from pengguna p where p.username = ?";

    @Autowired
    private DataSource dataSource;

    @Autowired
    private PenggunaRepository penggunaRepository;

    @Bean
    public PasswordEncoder passwordEncoder() {
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
    @Override
    protected void configure(AuthenticationManagerBuilder authBuilder) throws Exception {
        authBuilder.userDetailsService(userDetailsServiceBean()).passwordEncoder(passwordEncoder());
    }

    @Override
    public UserDetailsService userDetailsServiceBean() {
        return new UserDetailsServiceImpl(penggunaRepository);
    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery(SQL_LOGIN)
                .authoritiesByUsernameQuery(SQL_PERMISSION)
                .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/logout").permitAll()
                .antMatchers("/admin/**").hasAuthority("ADMIN")
                .antMatchers("/user/**").hasAnyAuthority("ADMIN", "USER")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login.html")
                .loginProcessingUrl("/login")
//                .loginProcessingUrl("/sign-in-process.html")
//                .loginProcessingUrl("/admin/dashboard.html")
                .usernameParameter("username")
                .passwordParameter("password")
                .failureUrl("/login?error")
                .defaultSuccessUrl("/admin/dashboard", true)
                .permitAll()
                .and()
                .logout()
                .deleteCookies("JSESSIONID")
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login")
                .permitAll();

//        http.sessionManagement()
//                .maximumSessions(1)
//                .expiredUrl("/expired.html")
//                .sessionRegistry(sessionRegistry());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/**")
                .antMatchers("/assets/*")
                .antMatchers("/js/*")
                .antMatchers("/img/*")
                .antMatchers("/css/*")
                .antMatchers("/templates/**")
                .antMatchers("/theme/*");
    }
}
