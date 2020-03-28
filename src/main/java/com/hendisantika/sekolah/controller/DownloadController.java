package com.hendisantika.sekolah.controller;

import com.hendisantika.sekolah.repository.FilesRepository;
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
 * Date: 28/03/20
 * Time: 14.41
 */
@Slf4j
@PreAuthorize("hasAuthority('ADMIN')")
@Controller
@RequestMapping("admin/download")
public class DownloadController {
    @Autowired
    private FilesRepository filesRepository;

    @GetMapping
    public String download(Model model, Pageable pageable) {
        log.info("Menampilkan data untuk Halaman List Files.");
        model.addAttribute("downloadList", filesRepository.findAll(pageable));
        return "admin/download/download-list";
    }
}
