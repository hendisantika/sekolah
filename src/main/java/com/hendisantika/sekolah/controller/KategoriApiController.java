package com.hendisantika.sekolah.controller;

import com.hendisantika.sekolah.entity.Kategori;
import com.hendisantika.sekolah.exception.KategoriNotFoundException;
import com.hendisantika.sekolah.repository.KategoriRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/v1/api/news")
public class KategoriApiController {

    @Autowired
    private KategoriRepository kategoriRepository;

    @PostMapping("categories")
    @ResponseBody
    public Kategori addNewKategori(@RequestBody @Valid Kategori kategori) {
        log.info("menambahkan kategori berita");
        return kategoriRepository.save(kategori);
    }

    @GetMapping("categories/{kategoriId}")
    public Kategori findKategoriById(@PathVariable(value = "kategoriId") UUID kategoriId) throws KategoriNotFoundException {
        log.info("filter kategori by id {}", kategoriId);
        return kategoriRepository.findById(kategoriId).orElseThrow(() -> {
            log.warn("Kategori Not Found not found.");
            return new KategoriNotFoundException("Kategori Not Found");
        });
    }
}