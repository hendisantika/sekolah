package com.hendisantika.sekolah.controller;

import com.hendisantika.sekolah.entity.Agenda;
import com.hendisantika.sekolah.entity.Pengumuman;
import com.hendisantika.sekolah.entity.Tulisan;
import com.hendisantika.sekolah.repository.AgendaRepository;
import com.hendisantika.sekolah.repository.PengumumanRepository;
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
    @Autowired
    private TulisanRepository tulisanRepository;

    @Autowired
    private PengumumanRepository pengumumanRepository;

    @Autowired
    private AgendaRepository agendaRepository;

    @GetMapping
    public String index(Model model) {
        log.info("Menampilkan data untuk home.");
        List<Tulisan> tulisanList = tulisanRepository.findTop4();
        List<Pengumuman> pengumuman = pengumumanRepository.findTop4();
        List<Agenda> agenda = agendaRepository.findTop4();
        model.addAttribute("tulisanList", tulisanList);
        model.addAttribute("pengumuman", pengumuman);
        model.addAttribute("agenda", agenda);
        return "index";
    }

}
