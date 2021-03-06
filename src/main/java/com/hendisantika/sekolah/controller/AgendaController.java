package com.hendisantika.sekolah.controller;

import com.hendisantika.sekolah.entity.*;
import com.hendisantika.sekolah.repository.AgendaRepository;
import com.hendisantika.sekolah.repository.KategoriRepository;
import com.hendisantika.sekolah.repository.PenggunaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.security.Principal;
import java.time.LocalDateTime;
import java.util.UUID;


@Slf4j
@Controller
@RequestMapping("admin/agenda")
@PreAuthorize("hasAuthority('ADMIN')")
public class AgendaController {

    private static String UPLOADED_FOLDER = System.getProperty("java.io.tmpdir");

    @Autowired
    private AgendaRepository agendaRepository;

    @Autowired
    private KategoriRepository kategoriRepository;

    @Autowired
    private PenggunaRepository penggunaRepository;

    @GetMapping
    public String agenda(Model model, Pageable pageable) {
        log.info("Menampilkan data untuk Halaman List Agenda.");
        model.addAttribute("agendaList", agendaRepository.findAll(pageable));
        model.addAttribute("waktu", LocalDateTime.now());
        return "admin/agenda/agenda-list";
    }

    @GetMapping("add")
    public String tampilkanFormAgenda(Model model) {
        log.info("Menampilkan Form Agenda");
        model.addAttribute("agenda", new Agenda());
        return "admin/agenda/agenda-form";
    }

    @PostMapping
    public String tambahAgenda(@Valid Agenda agenda, Principal principal, BindingResult errors,
                                 SessionStatus status) {
        log.info("Menambahkan Agenda baru");
        if (errors.hasErrors()) {
            return "admin/agenda";
        }
        agenda.setCreatedBy(principal.getName());
        agendaRepository.save(agenda);
        status.setComplete();
        log.info("Data agenda yang baru {}", agenda);
        return "redirect:/admin/agenda/agenda-list";
    }

    @GetMapping("edit/{agendaId}")
    public String tampilkanFormEditAgenda(@PathVariable("agendaId")UUID agendaId, Model model) {
        log.info("Menampilkan Form Edit Agenda");
        model.addAttribute("agenda", agendaRepository.findById(agendaId));
        return "admin/agenda/agenda-edit";
    }

    @PostMapping("edit")
    public String updateAgenda(Model model, @Valid Agenda agendaBaru, Pageable pageable) {
        log.info("Memperbaharui Data Agenda");

        Agenda agenda = agendaRepository.findById(agendaBaru.getId()).get();
        agenda.setNama(agendaBaru.getNama());
        agenda.setDeskripsi(agendaBaru.getDeskripsi());
        agenda.setMulai(agendaBaru.getMulai());
        agenda.setTempat(agendaBaru.getTempat());
        agendaRepository.save(agenda);
        model.addAttribute("agenda", agendaRepository.findAll(pageable));
        return "redirect:/admin/agenda";
    }

    @GetMapping("/delete/{agendaId}")
    public String deleteAgenda(@PathVariable("agendaId") UUID agendaId, Model model, Pageable pageable) {
        log.info("Hapus data Agenda");
        agendaRepository.deleteById(agendaId);

        model.addAttribute("agendaList", agendaRepository.findAll(pageable));
        return "redirect:/admin/agenda";
    }
}
