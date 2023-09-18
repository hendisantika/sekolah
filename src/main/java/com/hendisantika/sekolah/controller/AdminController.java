package com.hendisantika.sekolah.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

import static com.hendisantika.sekolah.enumeration.ALLCONSTANT.ADMIN_DASH;
import static com.hendisantika.sekolah.enumeration.ALLCONSTANT.WAKTU;

/**
 * Created by IntelliJ IDEA.
 * Project : sekolah
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 21/03/20
 * Time: 08.40
 */
@Slf4j
@Controller
@RequestMapping("/admin")
public class AdminController {
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        log.info("Menampilkan data untuk Halaman Dashboard.");
        model.addAttribute(WAKTU.getDescription(), LocalDateTime.now());

        return ADMIN_DASH.getDescription();
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/inbox")
    public String inbox(Model model) {
        log.info("Menampilkan data untuk Halaman List Inbox.");
        model.addAttribute(WAKTU.getDescription(), LocalDateTime.now());

        return ADMIN_DASH.getDescription();
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/komentar")
    public String komentar(Model model) {
        log.info("Menampilkan data untuk Halaman List Komentar.");
        model.addAttribute(WAKTU.getDescription(), LocalDateTime.now());

        return ADMIN_DASH.getDescription();
    }
}
