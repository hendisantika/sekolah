package com.hendisantika.sekolah.controller;

import com.hendisantika.sekolah.dto.UserAgentInfo;
import com.hendisantika.sekolah.entity.Agenda;
import com.hendisantika.sekolah.entity.Files;
import com.hendisantika.sekolah.entity.Galeri;
import com.hendisantika.sekolah.entity.Guru;
import com.hendisantika.sekolah.entity.Kategori;
import com.hendisantika.sekolah.entity.Komentar;
import com.hendisantika.sekolah.entity.Pengguna;
import com.hendisantika.sekolah.entity.Pengumuman;
import com.hendisantika.sekolah.entity.Pengunjung;
import com.hendisantika.sekolah.entity.Siswa;
import com.hendisantika.sekolah.entity.Tulisan;
import com.hendisantika.sekolah.repository.AgendaRepository;
import com.hendisantika.sekolah.repository.FilesRepository;
import com.hendisantika.sekolah.repository.GaleriRepository;
import com.hendisantika.sekolah.repository.GuruRepository;
import com.hendisantika.sekolah.repository.KategoriRepository;
import com.hendisantika.sekolah.repository.KomentarRepository;
import com.hendisantika.sekolah.repository.PengumumanRepository;
import com.hendisantika.sekolah.repository.PengunjungRepository;
import com.hendisantika.sekolah.repository.SiswaRepository;
import com.hendisantika.sekolah.repository.TulisanRepository;
import com.hendisantika.sekolah.util.WordUtils;
import lombok.extern.slf4j.Slf4j;
import net.sf.uadetector.UserAgentStringParser;
import net.sf.uadetector.service.UADetectorServiceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.List;

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
    private static long TOT_GURU = 0;
    private static long TOT_SISWA = 0;
    private static long TOT_FILES = 0;
    private static long TOT_AGENDA = 0;

    @Value("${cookie.maxAge}")
    private int COOKIE_MAX_AGE;

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
            "REMOTE_ADDR"};

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

    @Autowired
    private KategoriRepository kategoriRepository;

    @Autowired
    private KomentarRepository komentarRepository;

    @Autowired
    private GaleriRepository galeriRepository;

    @Autowired
    private PengunjungRepository pengunjungRepository;

    @ModelAttribute("WordUtil")
    public WordUtils addWordUtil() {
        return new WordUtils();
    }

    public static UserAgentStringParser parser = UADetectorServiceFactory.getResourceModuleParser();

    @GetMapping
    public String index(Model model, HttpServletRequest request, HttpServletResponse response) {
        createCookieAndSave(request, response, "HOME");

        log.info("Menampilkan data untuk Halaman Home.");
        List<Tulisan> tulisanList = tulisanRepository.findTop4();
        List<Pengumuman> pengumuman = pengumumanRepository.findTop4();
        List<Agenda> agenda = agendaRepository.findTop4();

        TOT_GURU = guruRepository.count();
        TOT_AGENDA = agendaRepository.count();
        TOT_FILES = filesRepository.count();
        TOT_SISWA = siswaRepository.count();

        model.addAttribute("WordUtil", new WordUtils());

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
        UserAgentInfo userAgentInfo = showUserAgentInfo(parser.parse(request.getHeader("User-Agent")));
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
        pengunjungRepository.save(pengunjung);
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
        List<Guru> guruList = guruRepository.findAll();
        model.addAttribute("guruList", guruList);
        return "guru";
    }

    @GetMapping("siswa")
    public String showSiswa(Model model, HttpServletRequest request, HttpServletResponse response) {
        createCookieAndSave(request, response, "SISWA");
        log.info("Menampilkan data untuk Halaman Siswa.");
        List<Siswa> siswaList = siswaRepository.findAll();
        model.addAttribute("siswaList", siswaList);
        return "siswa";
    }

    @GetMapping("blog")
    public String showBlog(Model model, HttpServletRequest request, HttpServletResponse response) {
        createCookieAndSave(request, response, "BLOG");
        log.info("Menampilkan data untuk Halaman Blog.");
        List<Tulisan> tulisanList = tulisanRepository.findAll();
        List<Kategori> kategoriList = kategoriRepository.findAll();
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
        Tulisan tulisan = tulisanRepository.findBySlug(slug);
        List<Tulisan> populer = tulisanRepository.findByOrderByViewsDesc();
        List<Kategori> kategoriList = kategoriRepository.findAll();
        List<Komentar> komentarList = komentarRepository.findByTulisanIdAndStatusAndParent(tulisan.getId(), "1", 0);
        List<Komentar> parentKomentarList = komentarRepository.findByStatusAndParentOrderByCreatedOnAsc("1", 0);
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
        List<Pengumuman> pengumumanList = pengumumanRepository.findByOrderByCreatedOnDesc();
        model.addAttribute("pengumumanList", pengumumanList);
        return "pengumuman";
    }

    @GetMapping("agenda")
    public String showAgenda(Model model, HttpServletRequest request, HttpServletResponse response) {
        createCookieAndSave(request, response, "AGENDA");
        log.info("Menampilkan data untuk Halaman Agenda.");
        List<Agenda> agendaList = agendaRepository.findAll();
        model.addAttribute("agendaList", agendaList);
        return "agenda";
    }

    @GetMapping("download")
    public String showDownload(Model model, HttpServletRequest request, HttpServletResponse response) {
        createCookieAndSave(request, response, "DOWNLOAD");
        log.info("Menampilkan data untuk Halaman Download.");
        List<Files> filesList = filesRepository.findAll();
        model.addAttribute("filesList", filesList);
        return "download";
    }

    @GetMapping("galeri")
    public String showGaleri(Model model, HttpServletRequest request, HttpServletResponse response) {
        createCookieAndSave(request, response, "GALERI");
        log.info("Menampilkan data untuk Halaman Galeri.");
        List<Galeri> galeriList = galeriRepository.findAll();
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
        String clientHost = request.getRemoteHost();

        UserAgentInfo userAgentInfo = getUserAgent(request);
        UserAgentInfo userAgentInfo2 = showUserAgentInfo(parser.parse(userAgentInfo.getUserAgent()));
        userAgentInfo2.setHostAddress(remoteIpAddr);
        userAgentInfo2.setHostName(remoteHostAddr);

        log.info("clientIP: ", clientIP);
        log.info("clientHost: ", clientHost);
        model.addAttribute("userAgentInfo", userAgentInfo2);
        model.addAttribute("waktu", LocalDateTime.now());
        return "samples/userAgent";
    }

}
