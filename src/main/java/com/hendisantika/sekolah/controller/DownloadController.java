package com.hendisantika.sekolah.controller;

import com.hendisantika.sekolah.dto.DownloadDto;
import com.hendisantika.sekolah.entity.Files;
import com.hendisantika.sekolah.repository.FilesRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
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
import java.util.Base64;
import java.util.UUID;

import static com.hendisantika.sekolah.enumeration.ALLCONSTANT.DL;
import static com.hendisantika.sekolah.enumeration.ALLCONSTANT.RIE_ADMIN_DL;

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
@RequestMapping("/admin/download")
public class DownloadController {
    private final FilesRepository filesRepository;

    public DownloadController(FilesRepository filesRepository) {
        this.filesRepository = filesRepository;
    }

    @GetMapping
    public String download(Model model, Pageable pageable) {
        log.info("Menampilkan data untuk Halaman List Files.");
        model.addAttribute("downloadList", filesRepository.findAll(pageable));

        return "/admin/download/download-list";
    }

    @GetMapping("/edit/{downloadId}")
    public String showFormEditDownload(@PathVariable("downloadId") UUID downloadId, Model model) {
        log.info("Menampilkan Form untuk Edit Download.");
        model.addAttribute(DL.getDescription(), filesRepository.findById(downloadId));

        return "/admin/download/download-edit";
    }

    @GetMapping("/add")
    public String showFormDownload(Model model) {
        log.info("Menampilkan Halaman Tambah File Download.");
        model.addAttribute(DL.getDescription(), new Files());

        return "/admin/download/download-form";
    }

    @PostMapping
    public String tambahFile(Model model, Files files, @RequestParam("file") MultipartFile file,
                             Pageable pageable, BindingResult errors, SessionStatus status) {
        log.info("Menambahkan File yang baru");
        if (errors.hasErrors()) {
            log.info("Tambah File yang baru gagal. {}", errors);
            return "redirect:/admin/download/add";
        }
        saveDataFile(files, file, status);
        model.addAttribute("downloadList", filesRepository.findAll(pageable));

        return RIE_ADMIN_DL.getDescription();
    }

    private void saveDataFile(Files files, @RequestParam("file") MultipartFile file,
                              SessionStatus status) {
        try {
            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            String encoded = Base64.getEncoder().encodeToString(bytes);

            files.setData(file.getOriginalFilename());
            files.setFileContent(encoded.getBytes());
            files.setFilename(file.getOriginalFilename());
            filesRepository.save(files);
            status.setComplete();
            log.info("Tambah File Download yang baru sukses.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @PostMapping("/edit")
    public String updatePengumuman(@Valid DownloadDto downloadDto, @RequestParam("file") MultipartFile file,
                                   Model model, SessionStatus status, Pageable pageable) {
        log.info("Memperbaharui data Download File.");
        Files files;
        try {
            files = filesRepository.findById(downloadDto.getId()).orElseThrow(() -> {
                log.error("Download File Not Found {}", downloadDto.getId());
                return new ChangeSetPersister.NotFoundException();
            });
            files.setJudul(downloadDto.getJudul());
            files.setDeskripsi(downloadDto.getDeskripsi());
            files.setAuthor(downloadDto.getAuthor());
            saveDataFile(files, file, status);
        } catch (ChangeSetPersister.NotFoundException e) {
            e.printStackTrace();
        }

        model.addAttribute(DL.getDescription(), filesRepository.findAll(pageable));

        return RIE_ADMIN_DL.getDescription();
    }

    @GetMapping("/delete/{downloadId}")
    public String deletePengumuman(@PathVariable("downloadId") UUID downloadId, Model model, Pageable pageable) {
        log.info("Delete Download Files.");
        filesRepository.deleteById(downloadId);
        model.addAttribute(DL.getDescription(), filesRepository.findAll(pageable));

        return RIE_ADMIN_DL.getDescription();
    }
}
