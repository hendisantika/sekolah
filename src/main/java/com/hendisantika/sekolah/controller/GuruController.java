package com.hendisantika.sekolah.controller;

import com.hendisantika.sekolah.dto.GuruDto;
import com.hendisantika.sekolah.entity.Guru;
import com.hendisantika.sekolah.repository.GuruRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.Objects;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * Project : sekolah
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 29/03/20
 * Time: 13.13
 */
@Slf4j
@PreAuthorize("hasAuthority('ADMIN')")
@Controller
@RequestMapping("/admin/guru")
public class GuruController {
    private final GuruRepository guruRepository;

    public GuruController(GuruRepository guruRepository) {
        this.guruRepository = guruRepository;
    }

    @GetMapping
    public String guru(Model model, Pageable pageable) {
        log.info("Menampilkan data untuk Halaman List Guru.");
        model.addAttribute("guruList", guruRepository.findAll(pageable));

        return "/admin/guru/guru-list";
    }

    @GetMapping("/add")
    public String showFormGuru(Model model) {
        log.info("Menampilkan Form Tambah Guru.");
        model.addAttribute("guru", new Guru());

        return "/admin/guru/guru-form";
    }

    @PostMapping
    public String tambahGuru(@Valid GuruDto guruDto, Model model, @RequestParam("file") MultipartFile file,
                             BindingResult errors, Pageable pageable,
                             SessionStatus status) {
        log.info("Menambahkan Data Guru baru");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String tglLahirDto = guruDto.getTglLahir();

        //convert String to LocalDate
        LocalDate tglLahir = LocalDate.parse(tglLahirDto, formatter);
        try {
            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            String encoded = Base64.getEncoder().encodeToString(bytes);
            Guru guru = new Guru();
            BeanUtils.copyProperties(guruDto, guru);
            guru.setTglLahir(tglLahir);
            guru.setPhotoBase64(encoded);
            guru.setPhoto(file.getOriginalFilename());
            guru.setFileContent(bytes);
            guru.setFilename(file.getOriginalFilename());
            guruRepository.save(guru);
            status.setComplete();
            log.info("Menambahkan Data guru yang baru sukses.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        model.addAttribute("guru", guruRepository.findAll(pageable));

        return "redirect:/admin/guru";
    }

    @GetMapping("/edit/{guruId}")
    public String showEditGuruForm(@PathVariable("guruId") UUID guruId, Model model) {
        log.info("Menampilkan Form Edit Guru.");
        model.addAttribute("guru", guruRepository.findById(guruId));

        return "/admin/guru/guru-edit";
    }

    @PostMapping("/edit")
    public String updateGuru(Model model, @Valid GuruDto guruBaru, @RequestParam("file") MultipartFile file,
                             Pageable pageable, SessionStatus status) {
        log.info("Memperbaharui Data Guru");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String tglLahirDto = guruBaru.getTglLahir();

        //convert String to LocalDate
        LocalDate tglLahir = LocalDate.parse(tglLahirDto, formatter);
        try {
            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            String encoded = Base64.getEncoder().encodeToString(bytes);
            Guru guru = guruRepository.findById(guruBaru.getId()).orElse(null);
            Objects.requireNonNull(guru).setTglLahir(tglLahir);
            guru.setPhotoBase64(encoded);
            guru.setPhoto(file.getOriginalFilename());
            guru.setFileContent(bytes);
            guru.setFilename(file.getOriginalFilename());
            guruRepository.save(guru);
            status.setComplete();
            log.info("Memperbaharui Data guru sukses.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        model.addAttribute("guru", guruRepository.findAll(pageable));

        return "redirect:/admin/guru";
    }

    @GetMapping("/delete/{guruId}")
    public String showFormGuru(@PathVariable("guruId") UUID guruId, Model model, Pageable pageable) {
        log.info("Menghapus Data Guru.");
        guruRepository.deleteById(guruId);
        model.addAttribute("guru", guruRepository.findAll(pageable));

        return "/admin/guru/guru-list";
    }
}
