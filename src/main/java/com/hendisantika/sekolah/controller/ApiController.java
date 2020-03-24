package com.hendisantika.sekolah.controller;

import com.hendisantika.sekolah.entity.Kategori;
import com.hendisantika.sekolah.repository.KategoriRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@Slf4j
@RestController
public class ApiController {

    @Autowired
    private KategoriRepository kategoriRepository;

    @PostMapping("/v1/api/news/categories")
    @ResponseBody
    public Kategori addNewKategori(@RequestBody @Valid Kategori kategori) {
        log.info("menambahkan kategori berita");
        return kategoriRepository.save(kategori);
    }

    @GetMapping("/v1/api/news/categories/{kategoriId}")
    public Kategori findKategoriById(@PathVariable(value = "kategoriId") UUID kategoriId) {
        log.info("filter kategori by id {}", kategoriId);
        Kategori kategori = kategoriRepository.findById(kategoriId).orElse(null);
        return kategori;
    }
}
