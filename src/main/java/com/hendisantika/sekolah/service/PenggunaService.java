package com.hendisantika.sekolah.service;

import com.hendisantika.sekolah.entity.Pengguna;
import com.hendisantika.sekolah.repository.PenggunaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    @Autowired
    private PenggunaRepository penggunaRepository;

    public Pengguna saveUser(Pengguna user) {
        return penggunaRepository.save(user);
    }
}
