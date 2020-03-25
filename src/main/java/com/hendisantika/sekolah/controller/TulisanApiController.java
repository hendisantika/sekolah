package com.hendisantika.sekolah.controller;

import com.hendisantika.sekolah.repository.TulisanRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * Project : sekolah
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 25/03/20
 * Time: 08.40
 */
@Slf4j
@RestController
@RequestMapping("/v1/api/tulisan")
public class TulisanApiController {
    @Autowired
    private TulisanRepository tulisanRepository;

    @GetMapping
//    public String list(ModelMap model, @SortDefault("username") Pageable pageable) {
    public String list(Model model, Pageable pageable) {
        log.info("List Down Data Tulisan");
        model.addAttribute("tulisanList", tulisanRepository.findAll(pageable));

        return "admin/tulisan";
    }
}
