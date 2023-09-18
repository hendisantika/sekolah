package com.hendisantika.sekolah.controller;

import com.hendisantika.sekolah.entity.Kategori;
import com.hendisantika.sekolah.repository.KategoriRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import java.security.Principal;

/**
 * Created by IntelliJ IDEA.
 * Project : sekolah
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 26/03/20
 * Time: 05.55
 */
@Slf4j
@PreAuthorize("hasAuthority('ADMIN')")
@Controller
@RequestMapping("/admin/kategori")
public class KategoriController {
    private final KategoriRepository kategoriRepository;

    public KategoriController(KategoriRepository kategoriRepository) {
        this.kategoriRepository = kategoriRepository;
    }

    @GetMapping
    public String kategoriForm(Model model) {
        log.info("Menampilkan data untuk Halaman Kategori Berita.");
        model.addAttribute("kategori", new Kategori());

        return "/admin/tulisan/kategori";
    }

    @PostMapping
    public String tambahKategori(@Valid Kategori kategori, Principal principal, BindingResult errors,
                                 SessionStatus status) {
        log.info("Menambahkan Kategori Berita/Tulisan baru");
        if (errors.hasErrors()) {
            return "/admin/kategori";
        }
        kategori.setCreatedBy(principal.getName());
        kategoriRepository.save(kategori);
        status.setComplete();
        log.info("Data kategori yang baru {}", kategori);

        return "redirect:/admin/tulisan/add";
    }
}