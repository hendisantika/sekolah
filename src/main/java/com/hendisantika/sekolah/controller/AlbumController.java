package com.hendisantika.sekolah.controller;

import com.hendisantika.sekolah.dto.AlbumDto;
import com.hendisantika.sekolah.entity.Album;
import com.hendisantika.sekolah.entity.Pengguna;
import com.hendisantika.sekolah.exception.UsernameNotFoundException;
import com.hendisantika.sekolah.repository.AlbumRepository;
import com.hendisantika.sekolah.repository.PenggunaRepository;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;
import java.util.Base64;
import java.util.UUID;

import static com.hendisantika.sekolah.enumeration.ALLCONSTANT.ALBUM;
import static com.hendisantika.sekolah.enumeration.ALLCONSTANT.RIE_ADMIN_ALBM;

/**
 * Created by IntelliJ IDEA.
 * Project : sekolah
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 03/04/20
 * Time: 07.49
 */
@Log4j2
@Controller
@PreAuthorize("hasAuthority('ADMIN')")
@RequestMapping("/admin/album")
public class AlbumController {
    private final AlbumRepository albumRepository;
    private final PenggunaRepository penggunaRepository;

    public AlbumController(AlbumRepository albumRepository, PenggunaRepository penggunaRepository) {
        this.albumRepository = albumRepository;
        this.penggunaRepository = penggunaRepository;
    }

    @GetMapping
    public String album(Model model, Pageable pageable) {
        log.info("Menampilkan data untuk Halaman List Album.");
        model.addAttribute("albumList", albumRepository.findAll(pageable));

        return "/admin/album/album-list";
    }

    @GetMapping("/add")
    public String showAlbumForm(Model model) {
        log.info("Menampilkan Form Tambah Album.");
        model.addAttribute(ALBUM.getDescription(), new AlbumDto());

        return "/admin/album/album-form";
    }

    @GetMapping("/edit/{albumId}")
    public String showAlbumForm(@PathVariable("albumId") UUID albumId, Model model) {
        log.info("Menampilkan Form Edit Album.");
        model.addAttribute(ALBUM.getDescription(), albumRepository.findById(albumId));

        return "/admin/album/album-edit";
    }

    @PostMapping
    public String tambahAlbum(@Valid AlbumDto albumDto, Model model, @RequestParam("file") MultipartFile file,
                              BindingResult errors, Pageable pageable, Principal principal,
                              SessionStatus status) {
        log.info("Menambahkan Data Album yang baru");
        try {
            String username = principal.getName();
            Pengguna pengguna = penggunaRepository.findByUsername(username).orElseThrow(() -> {
                log.error("Username Not Found {}", username);
                return new UsernameNotFoundException("Username Not Found");
            });
            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            String encoded = Base64.getEncoder().encodeToString(bytes);
            Album album = new Album();
            album.setNama(albumDto.getNama());
            album.setAuthor(albumDto.getAuthor());
            album.setPengguna(pengguna);
            album.setPhotoBase64(encoded);
            album.setFileContent(bytes);
            album.setFilename(file.getOriginalFilename());
            albumRepository.save(album);
            status.setComplete();
            log.info("Menambahkan Data Album yang baru sukses.");
        } catch (IOException e) {
            log.error("Menambahkan Data Album yang baru gagal, {}", errors);
            e.printStackTrace();
        }
        model.addAttribute(ALBUM.getDescription(), albumRepository.findAll(pageable));

        return RIE_ADMIN_ALBM.getDescription();
    }

    @PostMapping("/edit")
    public String editDataAlbum(@Valid AlbumDto albumDto, Model model, @RequestParam("file") MultipartFile file,
                                BindingResult errors, Pageable pageable, Principal principal,
                                SessionStatus status) {
        log.info("Memperbaharui Data Album.");
        try {
            String username = principal.getName();
            Pengguna pengguna = penggunaRepository.findByUsername(username).orElseThrow(() -> {
                log.error("Username Not Found {}", username);
                return new UsernameNotFoundException("Username Not Found");
            });
            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            String encoded = Base64.getEncoder().encodeToString(bytes);
            Album album = albumRepository.findById(albumDto.getId()).orElseThrow(() -> {
                log.error("Album Not Found {}", albumDto.getId());
                return new ChangeSetPersister.NotFoundException();
            });
            if (album != null) {
                album.setNama(albumDto.getNama());
                album.setAuthor(albumDto.getAuthor());
                album.setPengguna(pengguna);
                album.setPhotoBase64(encoded);
                album.setFileContent(bytes);
                album.setFilename(file.getOriginalFilename());
                albumRepository.save(album);
                status.setComplete();
                log.info("Memperbaharui Data Album sukses.");
            } else {
                log.error("Album tidak ada {}", errors);
            }
        } catch (IOException | ChangeSetPersister.NotFoundException e) {
            e.printStackTrace();
        }
        model.addAttribute(ALBUM.getDescription(), albumRepository.findAll(pageable));

        return RIE_ADMIN_ALBM.getDescription();
    }

    @GetMapping("/delete/{albumId}")
    public String deleteDataAlbum(@PathVariable("albumId") UUID albumId, Model model, Pageable pageable) {
        log.info("Menghapus Data Album.");
        albumRepository.deleteById(albumId);
        model.addAttribute(ALBUM.getDescription(), albumRepository.findAll(pageable));

        return RIE_ADMIN_ALBM.getDescription();
    }
}
