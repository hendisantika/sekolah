package com.hendisantika.sekolah.controller;

import com.hendisantika.sekolah.dto.SiswaDto;
import com.hendisantika.sekolah.entity.Siswa;
import com.hendisantika.sekolah.repository.KelasRepository;
import com.hendisantika.sekolah.repository.SiswaRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Base64;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * Project : sekolah
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 30/03/20
 * Time: 18.31
 */
@Log4j2
@PreAuthorize("hasAuthority('ADMIN')")
@Controller
@RequestMapping("admin/siswa")
public class SiswaController {
    @Autowired
    private SiswaRepository siswaRepository;

    @Autowired
    private KelasRepository kelasRepository;

    @GetMapping
    public String showListSiswa(Model model, Pageable pageable) {
        log.info("Menampilkan data untuk Halaman List Siswa.");
        model.addAttribute("siswaList", siswaRepository.findAll(pageable));
        return "admin/siswa/siswa-list";
    }

    @GetMapping("add")
    public String showFormAddSiswa(Model model) {
        log.info("Menampilkan data untuk Halaman Tambah Siswa.");
        model.addAttribute("kelasList", kelasRepository.findAll());
        model.addAttribute("siswa", new SiswaDto());
        return "admin/siswa/siswa-form";
    }

    @GetMapping("edit/{siswaId}")
    public String showFormEditSiswa(@PathVariable("siswaId") UUID siswaId, Model model) {
        log.info("Menampilkan data untuk Halaman Edit Siswa.");
        model.addAttribute("kelasList", kelasRepository.findAll());
        model.addAttribute("siswa", siswaRepository.findById(siswaId));
        return "admin/siswa/siswa-edit";
    }

    @PostMapping("edit")
    public String updateDataSiswa(@Valid SiswaDto siswaDto, Model model, @RequestParam("file") MultipartFile file,
                                  Pageable pageable, SessionStatus status) {
        log.info("Memperbaharui data siswa.");
        try {
            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            String encoded = Base64.getEncoder().encodeToString(bytes);
            Siswa siswa = siswaRepository.findById(siswaDto.getId()).get();
            siswa.setPhotoBase64(encoded);
            siswa.setPhoto(file.getOriginalFilename());
            siswa.setFileContent(bytes);
            siswa.setFilename(file.getOriginalFilename());
            siswaRepository.save(siswa);
            status.setComplete();
            log.info("Update Data Siswa sukses.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        model.addAttribute("siswa", siswaRepository.findAll(pageable));
        return "redirect:/admin/siswa";
    }

    @PostMapping
    public String addSiswa(Model model, @Valid SiswaDto siswaDto, @RequestParam("file") MultipartFile file,
                           Pageable pageable, SessionStatus status) {
        log.info("Menyiapkan Data Tambah Pengguna.");
        try {
            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            String encoded = Base64.getEncoder().encodeToString(bytes);
            Siswa siswa = new Siswa();
            BeanUtils.copyProperties(siswaDto, siswa);
            siswa.setPhotoBase64(encoded);
            siswa.setPhoto(file.getOriginalFilename());
            siswa.setFileContent(bytes);
            siswa.setFilename(file.getOriginalFilename());
            siswaRepository.save(siswa);
            status.setComplete();
            log.info("Tambah Siswa yang baru sukses.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        model.addAttribute("siswaList", siswaRepository.findAll(pageable));
        return "redirect:/admin/siswa";
    }

    @GetMapping("delete/{siswaId}")
    public String deleteSiswa(@PathVariable("siswaId") UUID siswaId, Model model, Pageable pageable) {
        log.info("Menghapus data siswa.");
        siswaRepository.deleteById(siswaId);
        model.addAttribute("siswa", siswaRepository.findAll(pageable));
        return "redirect:/admin/siswa";
    }

}
