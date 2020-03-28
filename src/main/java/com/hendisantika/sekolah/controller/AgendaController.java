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

import javax.validation.Valid;
import java.io.IOException;
import java.security.Principal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Base64;

import static com.hendisantika.sekolah.util.WordUtils.pregReplace;
import static com.hendisantika.sekolah.util.WordUtils.stripTags;
import static org.apache.commons.lang3.StringUtils.lowerCase;

@Slf4j
@Controller
@RequestMapping("admin/agenda")
@PreAuthorize("hasAuthority('ADMIN')")
public class AgendaController {

    private static String UPLOADED_FOLDER = System.getProperty("java.io.tmpdir");

    @Autowired
    private AgendaRepository agendaRepository;

    private KategoriRepository kategoriRepository;

    private PenggunaRepository penggunaRepository;

    @GetMapping
    public String agendaForm(Model model, Pageable pageable) {
        log.info("Menampilkan data untuk Halaman Agenda.");
        model.addAttribute("agendaList", agendaRepository.findAll(pageable));
        model.addAttribute("waktu", LocalDateTime.now());
        return "admin/agenda";
    }

    @GetMapping("/add")
    public String tampilkanFormAgenda(Model model) {
        log.info("Menampilkan Form Agenda");
        model.addAttribute("kategoriList", kategoriRepository.findAll());
        model.addAttribute("agenda", new Agenda());
        return "admin/agenda-form";
    }

    public String tambahAgenda(Model model, Agenda agenda, @RequestParam("file") MultipartFile file,
                                Principal principal, Pageable pageable, BindingResult errors, SessionStatus status) {
        log.info("Menambahkan Agenda yang baru");
        if (errors.hasErrors()) {
            log.info("Tambah Agenda yang baru gagal. ", errors);
            return "redirect:/admin/agenda/add";
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

            agenda.setDeskripsi(stripTags(agenda.getDeskripsi()));
            agenda.setCreatedOn(agenda.getCreatedOn());
            agenda.setTempat(agenda.getTempat());
            agenda.setCreated_by(username);
            agenda.setWaktu(agenda.getWaktu());
            agendaRepository.save(agenda);
            status.setComplete();
            log.info("Tambah Agenda yang baru sukses.");

        } catch (IOException e) {
            e.printStackTrace();
        }
        model.addAttribute("agendaList", agendaRepository.findAll(pageable));
        return "redirect:/admin/agenda";
    }

    @GetMapping("/edit")
    public String editAgenda(Model model) {
        log.info("Mengedit Data Agenda");
        model.addAttribute("agendaList", agendaRepository.findAll());
        model.addAttribute("agenda", new Agenda());
        return "admin/agenda-form";
    }

    @GetMapping("/delete")
    public String deleteAgenda(Model model) {
        log.info("Hapus data Agenda");
        model.addAttribute("agendaList", agendaRepository.findAll());
        model.addAttribute("agenda", new Agenda());
        return "admin/agenda-form";
    }

}
