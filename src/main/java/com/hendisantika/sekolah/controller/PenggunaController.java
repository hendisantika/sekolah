package com.hendisantika.sekolah.controller;

import com.hendisantika.sekolah.repository.PenggunaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by IntelliJ IDEA.
 * Project : sekolah
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 29/03/20
 * Time: 13.13
 */
@Slf4j
@PreAuthorize("hasAuthority('ADMIN')")
@Controller
@RequestMapping("admin/pengguna")
public class PenggunaController {

    @Autowired
    private PenggunaRepository penggunaRepository;

    @GetMapping
    public String pengguna(Model model, Pageable pageable) {
        log.info("Menampilkan data untuk Halaman List Pengguna.");
        model.addAttribute("penggunaList", penggunaRepository.findAll(pageable));
        return "admin/pengguna/pengguna-list";
    }

}
