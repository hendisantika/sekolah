package com.hendisantika.sekolah.controller;

import com.hendisantika.sekolah.repository.GaleriRepository;
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
 * Date: 03/04/20
 * Time: 09.44
 */
@Log4j2
@Controller
@PreAuthorize("hasAuthority('ADMIN')")
@RequestMapping("admin/galeri")
public class PhotoController {
    @Autowired
    private GaleriRepository galeriRepository;

    @GetMapping
    public String galeri(Model model, Pageable pageable) {
        log.info("Menampilkan data untuk Halaman List Galeri.");
        model.addAttribute("galeriList", galeriRepository.findAll(pageable));
        return "admin/galeri/galeri-list";
    }
}
