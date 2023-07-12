package com.hendisantika.sekolah.controller;

import com.hendisantika.sekolah.dto.UserAgentInfo;
import com.hendisantika.sekolah.entity.*;
import com.hendisantika.sekolah.enumeration.IndexAllArgConstructor;
import com.hendisantika.sekolah.enumeration.IndexAllArgConstructor1;
import com.hendisantika.sekolah.enumeration.IndexAllArgConstructor2;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import net.sf.uadetector.UserAgentStringParser;
import net.sf.uadetector.service.UADetectorServiceFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import static com.hendisantika.sekolah.util.WebUtils.getUserAgent;
import static com.hendisantika.sekolah.util.WebUtils.showUserAgentInfo;


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

    @Value("${cookie.maxAge}")
    private Integer COOKIE_MAX_AGE;

    private static final String[] IP_HEADER_CANDIDATES = {
            "X-Forwarded-For",
            "Proxy-Client-IP",
            "WL-Proxy-Client-IP",
            "HTTP_X_FORWARDED_FOR",
            "HTTP_X_FORWARDED",
            "HTTP_X_CLUSTER_CLIENT_IP",
            "HTTP_CLIENT_IP",
            "HTTP_FORWARDED_FOR",
            "HTTP_FORWARDED",
            "HTTP_VIA",
            "REMOTE_ADDR"
    };

    private final IndexAllArgConstructor indexAllArgConstructor;
    private final IndexAllArgConstructor1 indexAllArgConstructor1;
    private final IndexAllArgConstructor2 indexAllArgConstructor2;

    public static final UserAgentStringParser parser = UADetectorServiceFactory.getResourceModuleParser();

    public IndexController(IndexAllArgConstructor indexAllArgConstructor,
                           IndexAllArgConstructor1 indexAllArgConstructor1,
                           IndexAllArgConstructor2 indexAllArgConstructor2) {
        this.indexAllArgConstructor = indexAllArgConstructor;
        this.indexAllArgConstructor1 = indexAllArgConstructor1;
        this.indexAllArgConstructor2 = indexAllArgConstructor2;
    }

    public static String getClientIpAddress(HttpServletRequest request) {
        for (String header : IP_HEADER_CANDIDATES) {
            String ip = request.getHeader(header);
            String hostName = request.getRemoteHost();
            if (ip != null && ip.length() != 0 && !"unknown" .equalsIgnoreCase(ip)) {
                return ip;
            }
        }
        return request.getRemoteAddr();
    }

    @GetMapping
    public String index(Model model, HttpServletRequest request, HttpServletResponse response) {
        long TOT_AGENDA;
        long TOT_FILES;
        long TOT_SISWA;
        long TOT_GURU;
        createCookieAndSave(request, response, "HOME");

        log.info("Menampilkan data untuk Halaman Home.");
        List<Tulisan> tulisanList = indexAllArgConstructor.getTulisanRepository().findTop4();
        List<Pengumuman> pengumuman = indexAllArgConstructor.getPengumumanRepository().findTop4();
        List<Agenda> agenda = indexAllArgConstructor.getAgendaRepository().findTop4();

        TOT_GURU = indexAllArgConstructor.getGuruRepository().count();
        TOT_AGENDA = indexAllArgConstructor.getAgendaRepository().count();
        TOT_FILES = indexAllArgConstructor1.getFilesRepository().count();
        TOT_SISWA = indexAllArgConstructor1.getSiswaRepository().count();

        model.addAttribute("tulisanList", tulisanList);
        model.addAttribute("pengumuman", pengumuman);
        model.addAttribute("agenda", agenda);
        model.addAttribute("totGuru", TOT_GURU);
        model.addAttribute("totAgenda", TOT_AGENDA);
        model.addAttribute("totFiles", TOT_FILES);
        model.addAttribute("totSiswa", TOT_SISWA);
        return "index";
    }

    private void createCookieAndSave(HttpServletRequest request, HttpServletResponse response, String cookieName) {
        String remoteIpAddr = "";
        String remoteHostAddr = "";
        if (request != null) {
            remoteIpAddr = request.getHeader("X-FORWARDED-FOR");
            if (remoteIpAddr == null || "".equals(remoteIpAddr)) {
                remoteIpAddr = request.getRemoteAddr();
                remoteHostAddr = request.getRemoteHost();
            }
        }
        log.info("create a cookie.");
        Cookie cookie = new Cookie(cookieName, RequestContextHolder.currentRequestAttributes().getSessionId());
        cookie.setMaxAge(COOKIE_MAX_AGE);
        cookie.setSecure(true);
        cookie.setHttpOnly(true);
        cookie.setPath("/"); // global cookie accessible every where
        UserAgentInfo userAgentInfo = showUserAgentInfo(parser.parse(Objects.requireNonNull(request).getHeader("User-Agent")));
        userAgentInfo.setHostAddress(remoteIpAddr);
        userAgentInfo.setHostName(remoteHostAddr);

        Pengunjung pengunjung = Pengunjung.builder()
                .sessionId(cookie.getValue())
                .cookieName(cookie.getName())
                .url(request.getRequestURI())
                .ipAddress(userAgentInfo.getHostAddress())
                .osType(userAgentInfo.getOsType())
                .osVersion(userAgentInfo.getOsVersion())
                .browserName(userAgentInfo.getBrowserName())
                .browserType(userAgentInfo.getBrowserType())
                .browserVersion(userAgentInfo.getBrowserVersion())
                .deviceType(userAgentInfo.getDeviceType())
                .hostAddress(userAgentInfo.getHostAddress())
                .hostName(userAgentInfo.getHostName())
                .createdOn(LocalDateTime.now())
                .build();
        indexAllArgConstructor2.getPengunjungRepository().save(pengunjung);
        //add cookie to response
        response.addCookie(cookie);
    }

    @GetMapping("about")
    public String about(Model model, HttpServletRequest request, HttpServletResponse response) {
        createCookieAndSave(request, response, "ABOUT");
        log.info("Menampilkan data untuk Halaman about.");
        return "about";
    }

    @GetMapping("guru")
    public String showGuru(Model model, HttpServletRequest request, HttpServletResponse response) {
        createCookieAndSave(request, response, "GURU");
        log.info("Menampilkan data untuk Halaman Guru.");
        List<Guru> guruList = indexAllArgConstructor.getGuruRepository().findAll();
        model.addAttribute("guruList", guruList);
        return "guru";
    }

    @GetMapping("siswa")
    public String showSiswa(Model model, HttpServletRequest request, HttpServletResponse response) {
        createCookieAndSave(request, response, "SISWA");
        log.info("Menampilkan data untuk Halaman Siswa.");
        List<Siswa> siswaList = indexAllArgConstructor1.getSiswaRepository().findAll();
        model.addAttribute("siswaList", siswaList);
        return "siswa";
    }

    @GetMapping("blog")
    public String showBlog(Model model, HttpServletRequest request, HttpServletResponse response) {
        createCookieAndSave(request, response, "BLOG");
        log.info("Menampilkan data untuk Halaman Blog.");
        List<Tulisan> tulisanList = indexAllArgConstructor.getTulisanRepository().findAll();
        List<Kategori> kategoriList = indexAllArgConstructor1.getKategoriRepository().findAll();
        model.addAttribute("tulisanList", tulisanList);
        model.addAttribute("kategoriList", kategoriList);
        return "blog";
    }

    @GetMapping("artikel/{slug}")
    public String showBlogDetails(Model model, @PathVariable(value = "slug") String slug, HttpServletRequest request,
                                  HttpServletResponse response) {
        createCookieAndSave(request, response, "ARTIKEL");
        String[] colors = {"#ff9e67", "#10bdff", "#14b5c7", "#f98182", "#8f9ce2", "#ee2b33", "#d4ec15", "#613021"};
        log.info("Menampilkan data untuk Halaman Details Blog.");
        Tulisan tulisan = indexAllArgConstructor.getTulisanRepository().findBySlug(slug);
        List<Tulisan> populer = indexAllArgConstructor.getTulisanRepository().findByOrderByViewsDesc();
        List<Kategori> kategoriList = indexAllArgConstructor1.getKategoriRepository().findAll();
        List<Komentar> komentarList = indexAllArgConstructor1.getKomentarRepository().findByTulisanIdAndStatusAndParent(tulisan.getId(), "1", 0);
        List<Komentar> parentKomentarList = indexAllArgConstructor1.getKomentarRepository().findByStatusAndParentOrderByCreatedOnAsc("1", 0);
        model.addAttribute("tulisan", tulisan);
        model.addAttribute("populer", populer);
        model.addAttribute("kategoriList", kategoriList);
        model.addAttribute("komentarList", komentarList);
        model.addAttribute("parentKomentarList", parentKomentarList);
        model.addAttribute("colors", colors);
        return "artikel";
    }

    @GetMapping("pengumuman")
    public String showPengumuman(Model model, HttpServletRequest request, HttpServletResponse response) {
        createCookieAndSave(request, response, "PENGUMUMAN");
        log.info("Menampilkan data untuk Halaman Pengumuman.");
        List<Pengumuman> pengumumanList = indexAllArgConstructor.getPengumumanRepository().findByOrderByCreatedOnDesc();
        model.addAttribute("pengumumanList", pengumumanList);
        return "pengumuman";
    }

    @GetMapping("agenda")
    public String showAgenda(Model model, HttpServletRequest request, HttpServletResponse response) {
        createCookieAndSave(request, response, "AGENDA");
        log.info("Menampilkan data untuk Halaman Agenda.");
        List<Agenda> agendaList = indexAllArgConstructor.getAgendaRepository().findAll();
        model.addAttribute("agendaList", agendaList);
        return "agenda";
    }

    @GetMapping("download")
    public String showDownload(Model model, HttpServletRequest request, HttpServletResponse response) {
        createCookieAndSave(request, response, "DOWNLOAD");
        log.info("Menampilkan data untuk Halaman Download.");
        List<Files> filesList = indexAllArgConstructor1.getFilesRepository().findAll();
        model.addAttribute("filesList", filesList);
        return "download";
    }

    @GetMapping("galeri")
    public String showGaleri(Model model, HttpServletRequest request, HttpServletResponse response) {
        createCookieAndSave(request, response, "GALERI");
        log.info("Menampilkan data untuk Halaman Galeri.");
        List<Galeri> galeriList = indexAllArgConstructor2.getGaleriRepository().findAll();
        model.addAttribute("galeriList", galeriList);
        return "galeri";
    }

    @GetMapping("contact")
    public String showContact(HttpServletRequest request, HttpServletResponse response) {
        createCookieAndSave(request, response, "CONTACT");
        log.info("Menampilkan data untuk Halaman Contact Us.");
        return "contact";
    }

    @GetMapping("login")
    public String showLoginForm(Model model) {
        log.info("Menampilkan data untuk Halaman Login.");
        model.addAttribute("user", new Pengguna());
        return "admin/login";
    }

    @GetMapping("test")
    public String getUserAgent2(Model model, HttpServletRequest request) {
        String remoteIpAddr = "";
        String remoteHostAddr = "";
        if (request != null) {
            remoteIpAddr = request.getHeader("X-FORWARDED-FOR");
            if (remoteIpAddr == null || "" .equals(remoteIpAddr)) {
                remoteIpAddr = request.getRemoteAddr();
                remoteHostAddr = request.getRemoteHost();
            }
        }

        // Get client's IP address
        String clientIP = getClientIpAddress(request);

        // Get client's host name
        String clientHost = Objects.requireNonNull(request).getRemoteHost();

        UserAgentInfo userAgentInfo = getUserAgent(request);
        UserAgentInfo userAgentInfo2 = showUserAgentInfo(parser.parse(userAgentInfo.getUserAgent()));
        userAgentInfo2.setHostAddress(remoteIpAddr);
        userAgentInfo2.setHostName(remoteHostAddr);

        log.info("clientIP: {}", clientIP);
        log.info("clientHost: {}", clientHost);
        model.addAttribute("userAgentInfo", userAgentInfo2);
        model.addAttribute("waktu", LocalDateTime.now());
        return "samples/userAgent";
    }

}
