package com.hendisantika.sekolah.enumeration;

public enum ALLCONSTANT {
    LOGIN("/login"),
    WAKTU("waktu"),
    ADMIN_DASH("/admin/dashboard"),
    UPLOADED_FOLDER(System.getProperty("java.io.tmpdir")),
    AGENDA("agenda"),
    ALBUM("album"),
    RIE_ADMIN_ALBM("redirect:/admin/album"),
    DL("download"),
    RIE_ADMIN_DL("redirect:/admin/download"),
    PENGGUNA("pengguna"),
    RIE_ADMIN_PENGGUNA("redirect:/admin/pengguna"),
    PENGUMUMAN("pengumuman"),
    GALERI("galeri"),
    RIE_ADMIN_GALE("redirect:/admin/galeri"),
    SISWA("siswa"),
    RIE_ADMIN_SISW("redirect:/admin/siswa"),
    TULISANLIST("tulisanList"),
    TULISAN("tulisan"),
    RIE_ADMIN_TUL("redirect:/admin/tulisan"),
    KAT_LIST("kategoriList");

    private final String description;

    ALLCONSTANT(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
