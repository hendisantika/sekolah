package com.hendisantika.sekolah.controller;

import com.hendisantika.sekolah.entity.Pengguna;
import com.hendisantika.sekolah.entity.Pengumuman;
import com.hendisantika.sekolah.repository.PenggunaRepository;
import com.hendisantika.sekolah.repository.PengumumanRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;
import java.security.Principal;

/**
 * Created by IntelliJ IDEA.
 * Project : sekolah
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 28/03/20
 * Time: 10.53
 */
@Slf4j
@PreAuthorize("hasAuthority('ADMIN')")
@Controller
@RequestMapping("admin/pengumuman")
public class PengumumanController {
    @Autowired
    private PengumumanRepository pengumumanRepository;

    @Autowired
    private PenggunaRepository penggunaRepository;

    @GetMapping
    public String showPengumuman(Model model, Pageable pageable) {
        log.info("Menampilkan data untuk Halaman List Pengumuman.");
        model.addAttribute("pengumumanList", pengumumanRepository.findAll(pageable));
        return "admin/pengumuman/pengumuman-list";
    }

    @GetMapping("add")
    public String showFormPengumuman(Model model) {
        log.info("Menampilkan Form untuk Tambah Pengumuman.");
        model.addAttribute("pengumuman", new Pengumuman());
        return "admin/pengumuman/pengumuman-form";
    }

    @PostMapping
    public String addPengumuman(Model model, @Valid Pengumuman pengumuman,
                                Principal principal, Pageable pageable, SessionStatus status) {
        log.info("Menambahkan data Pengumuman.");
        String username = principal.getName();
        Pengguna pengguna = penggunaRepository.findByUsername(username).orElseThrow(() -> {
            log.warn("Username Not Found {}", username);
            return new UsernameNotFoundException("Username Not Found");
        });
        pengumuman.setAuthor(pengguna.getFullname());
        pengumumanRepository.save(pengumuman);
        model.addAttribute("pengumumanList", pengumumanRepository.findAll(pageable));
        return "admin/pengumuman/pengumuman-list";
    }
}
