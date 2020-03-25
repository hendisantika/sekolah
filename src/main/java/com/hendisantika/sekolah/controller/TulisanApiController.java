package com.hendisantika.sekolah.controller;

import com.hendisantika.sekolah.entity.Tulisan;
import com.hendisantika.sekolah.repository.KategoriRepository;
import com.hendisantika.sekolah.repository.TulisanRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;
import java.time.LocalDateTime;

/**
 * Created by IntelliJ IDEA.
 * Project : sekolah
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 25/03/20
 * Time: 08.40
 */
@Slf4j
@Controller
@RequestMapping("admin/tulisan")
@PreAuthorize("hasAuthority('ADMIN')")
public class TulisanApiController {
    @Autowired
    private TulisanRepository tulisanRepository;

    @Autowired
    private KategoriRepository kategoriRepository;

    @GetMapping
    public String tulisan(Model model, Pageable pageable) {
        log.info("Menampilkan data untuk Halaman List Berita.");
        model.addAttribute("tulisanList", tulisanRepository.findAll(pageable));
        model.addAttribute("waktu", LocalDateTime.now());
        return "admin/tulisan";
    }

    @GetMapping("/add")
    public String tampilkanFormTulisan(Model model) {
        log.info("Menampilkan Form Tulisan");
        model.addAttribute("kategoriList", kategoriRepository.findAll());
        model.addAttribute("tulisan", new Tulisan());
        return "admin/tulisan-form";
    }

    @PostMapping
    public String tambahTulisan(@RequestBody @Valid Tulisan tulisan, BindingResult errors,
                                SessionStatus status) {
        log.info("Menambahkan Tulisan yang baru");
        if (errors.hasErrors()) {
            return "form";
        }

        tulisanRepository.save(tulisan);
        status.setComplete();

        return "admin/tulisan";
    }
}
