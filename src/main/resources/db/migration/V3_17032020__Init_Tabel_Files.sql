CREATE TABLE IF NOT EXISTS tbl_files
(
    file_id        UUID           DEFAULT uuid_generate_v4() NOT NULL,
    file_judul     varchar(120)   DEFAULT NULL,
    file_deskripsi text,
    file_tanggal   timestamp NULL DEFAULT CURRENT_TIMESTAMP,
    file_oleh      varchar(60)    DEFAULT NULL,
    file_download  INT            DEFAULT '0',
    file_data      varchar(120)   DEFAULT NULL,
    PRIMARY KEY (file_id)
);

--
-- Dumping data untuk tabel tbl_files
--

INSERT INTO tbl_files (file_judul, file_deskripsi, file_tanggal, file_oleh, file_download, file_data)
VALUES ('Dasar-dasar CSS', 'Modul dasar-dasar CSS 3. Modul ini membantu anda untuk memahami struktur dasar CSS',
        '2017-01-23 04:30:01', 'Drs. Joko', 0, 'ab9a183ff240deadbedaff78e639af2f.pdf'),
       ('14 Teknik Komunikasi Yang Paling Efektif',
        'Ebook 14 teknik komunikasi paling efektif membantu anda untuk berkomunikasi dengan baik dan benar',
        '2017-01-23 15:26:06', 'Drs. Joko', 0, 'ab2cb34682bd94f30f2347523112ffb9.pdf'),
       ('Bagaimana Membentuk Pola Pikir yang Baru', 'Ebook ini membantu anda membentuk pola pikir baru.',
        '2017-01-23 15:27:07', 'Drs. Joko', 0, '30f588eb5c55324f8d18213f11651855.pdf'),
       ('7 Tips Penting mengatasi Kritik', '7 Tips Penting mengatasi Kritik', '2017-01-23 15:27:44', 'Drs. Joko', 0,
        '329a62b25ad475a148e1546aa3db41de.docx'),
       ('8 Racun dalam kehidupan kita', '8 Racun dalam kehidupan kita', '2017-01-23 15:28:17', 'Drs. Joko', 0,
        '8e38ad4948ba13758683dea443fbe6be.docx'),
       ('Jurnal Teknolgi Informasi', 'Jurnal Teknolgi Informasi', '2017-01-25 03:18:53', 'Gunawan, S.Pd', 0,
        '87ae0f009714ddfdd79e2977b2a64632.pdf'),
       ('Jurnal Teknolgi Informasi 2', 'Jurnal Teknolgi Informasi', '2017-01-25 03:19:22', 'Gunawan, S.Pd', 0,
        'c4e966ba2c6e142155082854dc5b3602.pdf'),
       ('Naskah Publikasi IT', 'Naskah Teknolgi Informasi', '2017-01-25 03:21:04', 'Gunawan, S.Pd', 0,
        '71380b3cf16a17a02382098c028ece9c.pdf'),
       ('Modul Teknologi Informasi', 'Modul Teknologi Informasi', '2017-01-25 03:22:08', 'Gunawan, S.Pd', 0,
        '029143a3980232ab2900d94df36dbb0c.pdf'),
       ('Modul Teknologi Informasi Part II', 'Modul Teknologi Informasi', '2017-01-25 03:22:54', 'Gunawan, S.Pd', 0,
        'ea8f3f732576083156e509657614f551.pdf'),
       ('Modul Teknologi Informasi Part III', 'Modul Teknologi Informasi', '2017-01-25 03:23:21', 'Gunawan, S.Pd', 0,
        'c5e5e7d16e4cd6c3d22c11f64b0db2af.pdf');
