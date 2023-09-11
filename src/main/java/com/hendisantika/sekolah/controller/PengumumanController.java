package com.hendisantika.sekolah.controller;

import com.hendisantika.sekolah.dto.PengumumanDto;
import com.hendisantika.sekolah.entity.Pengguna;
import com.hendisantika.sekolah.entity.Pengumuman;
import com.hendisantika.sekolah.repository.PenggunaRepository;
import com.hendisantika.sekolah.repository.PengumumanRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import java.security.Principal;
import java.util.UUID;

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

    @GetMapping("edit/{pengumumanId}")
    public String showFormPengumuman(@PathVariable("pengumumanId") UUID pengumumanId, Model model) {
        log.info("Menampilkan Form untuk Edit Pengumuman.");
        model.addAttribute("pengumuman", pengumumanRepository.findById(pengumumanId));
        return "admin/pengumuman/pengumuman-edit";
    }

    @GetMapping("delete/{pengumumanId}")
    public String deletePengumuman(@PathVariable("pengumumanId") UUID pengumumanId, Model model, Pageable pageable) {
        log.info("Delete Pengumuman.");
        pengumumanRepository.deleteById(pengumumanId);
        model.addAttribute("pengumuman", pengumumanRepository.findAll(pageable));
        return "redirect:/admin/pengumuman";
    }

    @PostMapping("edit")
    public String updatePengumuman(@Valid PengumumanDto pengumumanDto, Model model, Pageable pageable) {
        log.info("Memperbaharui data Pengumuman.");
        Pengumuman pengumuman = pengumumanRepository.findById(pengumumanDto.getId()).get();
        pengumuman.setJudul(pengumumanDto.getJudul());
        pengumuman.setDeskripsi(pengumumanDto.getDeskripsi());
        pengumumanRepository.save(pengumuman);
        model.addAttribute("pengumuman", pengumumanRepository.findAll(pageable));
        return "redirect:/admin/pengumuman";
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
        status.setComplete();
        model.addAttribute("pengumumanList", pengumumanRepository.findAll(pageable));
        return "admin/pengumuman/pengumuman-list";
    }
}
