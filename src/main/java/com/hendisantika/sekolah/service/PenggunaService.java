package com.hendisantika.sekolah.service;

import com.hendisantika.sekolah.entity.Pengguna;
import com.hendisantika.sekolah.repository.PenggunaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : sekolah
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 20/03/20
 * Time: 05.57
 */
@Service
public class PenggunaService {
    private final PenggunaRepository penggunaRepository;

    public PenggunaService(PenggunaRepository penggunaRepository) {
        this.penggunaRepository = penggunaRepository;
    }

    public Pengguna saveUser(Pengguna user) {
        return penggunaRepository.save(user);
    }

    public List<Pengguna> getUsers() {
        List<Pengguna> userDetails = penggunaRepository.findAll();
        return userDetails;
    }

//    public UserDetails loadUserByUsername(String username) {
//        Pengguna user = penggunaRepository.findByUsername(username);
//        if (user == null) {
//            throw new UsernameNotFoundException(username);
//        }
//        return new MyUserPrincipal(user);
//    }
}
