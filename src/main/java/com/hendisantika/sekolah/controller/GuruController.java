package com.hendisantika.sekolah.controller;

import com.hendisantika.sekolah.dto.PenggunaDto;
import com.hendisantika.sekolah.entity.Agenda;
import com.hendisantika.sekolah.entity.Guru;
import com.hendisantika.sekolah.entity.Pengguna;
import com.hendisantika.sekolah.repository.GuruRepository;
import com.hendisantika.sekolah.repository.PenggunaRepository;
import lombok.extern.slf4j.Slf4j;
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
import java.security.Principal;
import java.util.Base64;
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
@RequestMapping("admin/guru")
public class GuruController {

    @Autowired
    private GuruRepository guruRepository;

    @GetMapping
    public String guru(Model model, Pageable pageable) {
        log.info("Menampilkan data untuk Halaman List Guru.");
        model.addAttribute("guruList", guruRepository.findAll(pageable));
        return "admin/guru/guru-list";
    }

    @GetMapping("add")
    public String showFormPengguna(Model model) {
        log.info("Menampilkan Form Tambah Guru.");
        model.addAttribute("guru", new Guru());
        return "admin/guru/guru-form";
    }

    @GetMapping("edit/{guruId}")
    public String showEditGuruForm(@PathVariable("guruId") UUID guruId, Model model) {
        log.info("Menampilkan Form Edit Guru.");
        model.addAttribute("guru", guruRepository.findById(guruId));
        return "admin/guru/guru-edit";
    }

    @PostMapping("edit")
    public String updateGuru(Model model, @Valid Guru guruBaru, Pageable pageable) {
        log.info("Memperbaharui Data Agenda");

        Guru guru = guruRepository.findById(guruBaru.getId()).get();
        guru.setNama(guruBaru.getNama());
        guru.setJenkel(guruBaru.getJenkel());
        guru.setTmpLahir(guruBaru.getTmpLahir());
        guru.setTglLahir(guruBaru.getTglLahir());
        guru.setMapel(guruBaru.getMapel());
        guru.setPhoto(guruBaru.getPhoto());
        guruRepository.save(guru);
        model.addAttribute("guru", guruRepository.findAll(pageable));
        return "redirect:/admin/guru";
    }

    @GetMapping("delete/{guruId}")
    public String showFormGuru(@PathVariable("guruId") UUID guruId, Model model, Pageable pageable) {
        log.info("Menghapus Data Guru.");
        guruRepository.deleteById(guruId);
        model.addAttribute("guru", guruRepository.findAll(pageable));
        return "redirect:/admin/guru";
    }

}
