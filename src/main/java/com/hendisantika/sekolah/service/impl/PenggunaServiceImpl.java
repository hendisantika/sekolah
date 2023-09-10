package com.hendisantika.sekolah.service.impl;

import com.hendisantika.sekolah.entity.Pengguna;
import com.hendisantika.sekolah.repository.PenggunaRepository;
import com.hendisantika.sekolah.service.PenggunaService;
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
public class PenggunaServiceImpl implements PenggunaService {
    private final PenggunaRepository penggunaRepository;

    public PenggunaServiceImpl(PenggunaRepository penggunaRepository) {
        this.penggunaRepository = penggunaRepository;
    }

    @Override
    public Pengguna saveUser(Pengguna user) {
        return penggunaRepository.save(user);
    }

    @Override
    public List<Pengguna> getUsers() {
        return penggunaRepository.findAll();
    }

//    public UserDetails loadUserByUsername(String username) {
//        Pengguna user = penggunaRepository.findByUsername(username);
//        if (user == null) {
//            throw new UsernameNotFoundException(username);
//        }
//        return new MyUserPrincipal(user);
//    }
}
