package com.hendisantika.sekolah.controller;

import com.hendisantika.sekolah.entity.Agenda;
import com.hendisantika.sekolah.entity.Kategori;
import com.hendisantika.sekolah.entity.Pengguna;
import com.hendisantika.sekolah.entity.Tulisan;
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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;
import java.security.Principal;
import java.time.LocalDateTime;


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
        log.info("Menampilkan data untuk Halaman Agenda.");
        model.addAttribute("agendaList", agendaRepository.findAll());
        model.addAttribute("waktu", LocalDateTime.now());
        return "admin/agenda";
    }

    @GetMapping("/add")
    public String tampilkanFormAgenda(Model model) {
        log.info("Menampilkan Form Agenda");
        model.addAttribute("agendaList", agendaRepository.findAll());
        model.addAttribute("agenda", new Agenda());
        return "admin/agenda-form";
    }

    @PostMapping
    public String tambahAgenda(@Valid Agenda agenda, Principal principal, BindingResult errors,
                                 SessionStatus status) {
        log.info("Menambahkan Agenda baru");
        if (errors.hasErrors()) {
            return "admin/agenda";
        }
        agenda.setCreated_by(principal.getName());
        agendaRepository.save(agenda);
        status.setComplete();
        log.info("Data agenda yang baru {}", agenda);
        return "redirect:/admin/agenda/add";
    }

    @GetMapping("/edit")
    public String editAgenda(Model model, Agenda agenda){
        log.info("edit data Agenda");
        model.addAttribute("kategoriList", kategoriRepository.findAll());
        model.addAttribute("agenda", new Agenda());
        return "admin/agenda/edit";
    }
    @GetMapping("/delete")
    public String deleteAgenda(Model model) {
        log.info("Hapus data Agenda");
        model.addAttribute("kategoriList", kategoriRepository.findAll());
        model.addAttribute("agenda", new Agenda());
        return "admin/agenda-form";
    }
}
