package com.hendisantika.sekolah.service;

import com.hendisantika.sekolah.entity.Pengguna;

import java.util.List;

public interface PenggunaService {
    Pengguna saveUser(Pengguna user);
    List<Pengguna> getUsers();
}
