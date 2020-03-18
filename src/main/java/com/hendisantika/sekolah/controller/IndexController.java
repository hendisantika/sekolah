package com.hendisantika.sekolah.controller;

import com.hendisantika.sekolah.entity.Agenda;
import com.hendisantika.sekolah.entity.Guru;
import com.hendisantika.sekolah.entity.Pengumuman;
import com.hendisantika.sekolah.entity.Siswa;
import com.hendisantika.sekolah.entity.Tulisan;
import com.hendisantika.sekolah.repository.AgendaRepository;
import com.hendisantika.sekolah.repository.FilesRepository;
import com.hendisantika.sekolah.repository.GuruRepository;
import com.hendisantika.sekolah.repository.PengumumanRepository;
import com.hendisantika.sekolah.repository.SiswaRepository;
import com.hendisantika.sekolah.repository.TulisanRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


/**
 * Created by IntelliJ IDEA.
 * Project : sekolah
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 17/03/20
 * Time: 21.05
 */
@Slf4j
@Controller
@RequestMapping("/")
public class IndexController {
    private static long TOT_GURU = 0;
    private static long TOT_SISWA = 0;
    private static long TOT_FILES = 0;
    private static long TOT_AGENDA = 0;

    @Autowired
    private TulisanRepository tulisanRepository;

    @Autowired
    private PengumumanRepository pengumumanRepository;

    @Autowired
    private AgendaRepository agendaRepository;

    @Autowired
    private GuruRepository guruRepository;

    @Autowired
    private FilesRepository filesRepository;

    @Autowired
    private SiswaRepository siswaRepository;

    @GetMapping
    public String index(Model model) {
        log.info("Menampilkan data untuk home.");
        List<Tulisan> tulisanList = tulisanRepository.findTop4();
        List<Pengumuman> pengumuman = pengumumanRepository.findTop4();
        List<Agenda> agenda = agendaRepository.findTop4();

        TOT_GURU = guruRepository.count();
        TOT_AGENDA = agendaRepository.count();
        TOT_FILES = filesRepository.count();
        TOT_SISWA = siswaRepository.count();

        model.addAttribute("tulisanList", tulisanList);
        model.addAttribute("pengumuman", pengumuman);
        model.addAttribute("agenda", agenda);
        model.addAttribute("totGuru", TOT_GURU);
        model.addAttribute("totAgenda", TOT_AGENDA);
        model.addAttribute("totFiles", TOT_FILES);
        model.addAttribute("totSiswa", TOT_SISWA);
        return "index";
    }

    @GetMapping("about")
    public String about(Model model) {
        log.info("Menampilkan data untuk about.");
        return "about";
    }

    @GetMapping("guru")
    public String showGuru(Model model) {
        List<Guru> guruList = guruRepository.findAll();
        model.addAttribute("guruList", guruList);
        return "guru";
    }

    @GetMapping("siswa")
    public String showSiswa(Model model) {
        List<Siswa> siswaList = siswaRepository.findAll();
        model.addAttribute("siswaList", siswaList);
        return "siswa";
    }

}
