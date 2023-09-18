package com.hendisantika.sekolah.controller;

import com.hendisantika.sekolah.dto.GaleriDto;
import com.hendisantika.sekolah.entity.Galeri;
import com.hendisantika.sekolah.entity.Pengguna;
import com.hendisantika.sekolah.repository.AlbumRepository;
import com.hendisantika.sekolah.repository.GaleriRepository;
import com.hendisantika.sekolah.repository.PenggunaRepository;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;
import java.util.Base64;
import java.util.Objects;
import java.util.UUID;

import static com.hendisantika.sekolah.enumeration.ALLCONSTANT.GALERI;
import static com.hendisantika.sekolah.enumeration.ALLCONSTANT.RIE_ADMIN_GALE;

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
@RequestMapping("/admin/galeri")
public class PhotoController {
    private final GaleriRepository galeriRepository;
    private final AlbumRepository albumRepository;
    private final PenggunaRepository penggunaRepository;

    public PhotoController(GaleriRepository galeriRepository, AlbumRepository albumRepository, PenggunaRepository penggunaRepository) {
        this.galeriRepository = galeriRepository;
        this.albumRepository = albumRepository;
        this.penggunaRepository = penggunaRepository;
    }

    @GetMapping
    public String galeri(Model model, Pageable pageable) {
        log.info("Menampilkan data untuk Halaman List Galeri.");
        model.addAttribute("galeriList", galeriRepository.findAll(pageable));

        return "/admin/galeri/galeri-list";
    }


    @GetMapping("/add")
    public String showAddGaleriForm(Model model) {
        log.info("Menampilkan form halaman tambah Galeri.");
        model.addAttribute("albumList", albumRepository.findAll());
        model.addAttribute(GALERI.getDescription(), new GaleriDto());

        return "/admin/galeri/galeri-form";
    }

    @GetMapping("/edit/{galeriId}")
    public String showFormEditGaleri(@PathVariable("galeriId") UUID galeriId, Model model) {
        log.info("Menampilkan data untuk Halaman Edit Galeri.");
        model.addAttribute("albumList", albumRepository.findAll());
        model.addAttribute(GALERI.getDescription(), galeriRepository.findById(galeriId));

        return "/admin/galeri/galeri-edit";
    }

    @PostMapping
    public String tambahDataGaleri(@Valid GaleriDto galeriDto, Model model, @RequestParam("file") MultipartFile file,
                                   BindingResult errors, Pageable pageable, Principal principal,
                                   SessionStatus status) {
        log.info("Menambahkan Data Galeri yang baru");
        try {
            String username = principal.getName();
            Pengguna pengguna = penggunaRepository.findByUsername(username).orElseThrow(() -> {
                log.warn("Username Not Found {}", username);
                return new UsernameNotFoundException("Username Not Found");
            });
            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            String encoded = Base64.getEncoder().encodeToString(bytes);
            Galeri galeri = new Galeri();
            galeri.setAlbum(galeriDto.getAlbum());
            galeri.setJudul(galeriDto.getJudul());
            galeri.setAuthor(galeriDto.getAuthor());
            galeri.setPengguna(pengguna);
            galeri.setPhotoBase64(encoded);
            galeri.setFileContent(bytes);
            galeri.setFilename(file.getOriginalFilename());
            galeriRepository.save(galeri);
            status.setComplete();
            log.info("Menambahkan Data Galeri yang baru sukses.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        model.addAttribute(GALERI.getDescription(), galeriRepository.findAll(pageable));

        return RIE_ADMIN_GALE.getDescription();
    }

    @PostMapping("/edit")
    public String editDataGaleri(@Valid GaleriDto galeriDto, Model model, @RequestParam("file") MultipartFile file,
                                 BindingResult errors, Pageable pageable, Principal principal,
                                 SessionStatus status) {
        log.info("Memperbaharui Data Galeri.");
        try {
            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            String encoded = Base64.getEncoder().encodeToString(bytes);
            Galeri galeri = galeriRepository.findById(galeriDto.getId()).orElse(null);
            Objects.requireNonNull(galeri).setAlbum(galeriDto.getAlbum());
            galeri.setJudul(galeriDto.getJudul());
            galeri.setAuthor(galeriDto.getAuthor());
            galeri.setPhotoBase64(encoded);
            galeri.setFileContent(bytes);
            galeri.setFilename(file.getOriginalFilename());
            galeriRepository.save(galeri);
            status.setComplete();
            log.info("Memperbaharui Data Galeri sukses.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        model.addAttribute(GALERI.getDescription(), galeriRepository.findAll(pageable));

        return RIE_ADMIN_GALE.getDescription();
    }

    @GetMapping("/delete/{galeriId}")
    public String deleteGaleri(@PathVariable("galeriId") UUID galeriId, Model model) {
        log.info("Delete data Galeri.");
        galeriRepository.deleteById(galeriId);
        model.addAttribute(GALERI.getDescription(), galeriRepository.findById(galeriId));

        return RIE_ADMIN_GALE.getDescription();
    }
}