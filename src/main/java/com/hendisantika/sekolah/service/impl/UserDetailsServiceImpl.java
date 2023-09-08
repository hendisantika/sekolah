package com.hendisantika.sekolah.service.impl;

import com.hendisantika.sekolah.entity.Pengguna;
import com.hendisantika.sekolah.entity.Role;
import com.hendisantika.sekolah.repository.PenggunaRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * Project : sekolah
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 21/03/20
 * Time: 06.28
 */
public class UserDetailsServiceImpl implements UserDetailsService {

    private final PenggunaRepository penggunaRepository;

    public UserDetailsServiceImpl(PenggunaRepository penggunaRepository) {
        this.penggunaRepository = penggunaRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Pengguna> user = penggunaRepository.findByUsername(username);

        if (user.isPresent()) {
            return new User(user.get().getUsername(),
                    user.get().getPassword(), getAuthorities(user.get()));
        } else {
            throw new UsernameNotFoundException("Invalid user tried to login. User not found exception");
        }

    }


    private List<GrantedAuthority> getAuthorities(Pengguna user) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Role role : user.getRoles()) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getRole());
            authorities.add(grantedAuthority);
        }

        return authorities;
    }

}
