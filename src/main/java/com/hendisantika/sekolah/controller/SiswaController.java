package com.hendisantika.sekolah.controller;

import com.hendisantika.sekolah.dto.SiswaDto;
import com.hendisantika.sekolah.repository.KelasRepository;
import com.hendisantika.sekolah.repository.SiswaRepository;
import lombok.extern.log4j.Log4j2;
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
 * Date: 30/03/20
 * Time: 18.31
 */
@Log4j2
@PreAuthorize("hasAuthority('ADMIN')")
@Controller
@RequestMapping("admin/siswa")
public class SiswaController {
    @Autowired
    private SiswaRepository siswaRepository;

    @Autowired
    private KelasRepository kelasRepository;

    @GetMapping
    public String showListSiswa(Model model, Pageable pageable) {
        log.info("Menampilkan data untuk Halaman List Siswa.");
        model.addAttribute("siswaList", siswaRepository.findAll(pageable));
        return "admin/siswa/siswa-list";
    }

    @GetMapping("add")
    public String showFormAddSiswa(Model model) {
        log.info("Menampilkan data untuk Halaman Tambah Siswa.");
        model.addAttribute("kelasList", kelasRepository.findAll());
        model.addAttribute("siswa", new SiswaDto());
        return "admin/siswa/siswa-form";
    }
}
