package com.hendisantika.sekolah.controller;

import com.hendisantika.sekolah.entity.Pengguna;
import com.hendisantika.sekolah.entity.Tulisan;
import com.hendisantika.sekolah.repository.KategoriRepository;
import com.hendisantika.sekolah.repository.PenggunaRepository;
import com.hendisantika.sekolah.repository.TulisanRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;
import java.time.LocalDateTime;
import java.util.Base64;

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
public class TulisanController {
    //Save the uploaded file to this folder
    private static String UPLOADED_FOLDER = System.getProperty("java.io.tmpdir");

    @Autowired
    private TulisanRepository tulisanRepository;

    @Autowired
    private KategoriRepository kategoriRepository;

    @Autowired
    private PenggunaRepository penggunaRepository;

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
    public String tambahTulisan(Model model, Tulisan tulisan, @RequestParam("file") MultipartFile file,
                                Principal principal, Pageable pageable, BindingResult errors, SessionStatus status) {
        log.info("Menambahkan Tulisan yang baru");
        if (errors.hasErrors()) {
            log.info("Tambah Tulisan yang baru gagal. ", errors);
            return "redirect:/admin/tulisan/add";
        }
        try {
            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            String encoded = Base64.getEncoder().encodeToString(bytes);
            String username = principal.getName();
            Pengguna pengguna = penggunaRepository.findByUsername(username).orElseThrow(() -> {
                log.warn("Username Not Found {}", username);
                return new UsernameNotFoundException("Username Not Found");
            });

            tulisan.setPengguna(pengguna);
            tulisan.setCreatedBy(username);
            tulisan.setGambar(encoded);
            tulisan.setFileContent(bytes);
            tulisan.setFilename(file.getOriginalFilename());
            tulisanRepository.save(tulisan);
            status.setComplete();
            log.info("Tambah Tulisan yang baru sukses.");

        } catch (IOException e) {
            e.printStackTrace();
        }
        model.addAttribute("tulisanList", tulisanRepository.findAll(pageable));
        return "redirect:/admin/tulisan";
    }

    @GetMapping("/edit")
    public String editTulisan(Model model) {
        log.info("Mengedit Data Tulisan");
        model.addAttribute("kategoriList", kategoriRepository.findAll());
        model.addAttribute("tulisan", new Tulisan());
        return "admin/tulisan-form";
    }

    @GetMapping("/delete")
    public String deleteTulisan(Model model) {
        log.info("Hapus data Tulisan");
        model.addAttribute("kategoriList", kategoriRepository.findAll());
        model.addAttribute("tulisan", new Tulisan());
        return "admin/tulisan-form";
    }

}
