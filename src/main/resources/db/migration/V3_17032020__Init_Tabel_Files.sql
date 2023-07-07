CREATE TABLE IF NOT EXISTS tbl_files
(
    id           UUID           DEFAULT uuid_generate_v4() NOT NULL,
    judul        varchar(120)   DEFAULT NULL,
    author       varchar(100)   DEFAULT NULL,
    deskripsi    text,
    filename     varchar(50)    DEFAULT NULL,
    file_content bytea          DEFAULT NULL,
    download     INT            DEFAULT '0',
    data         varchar(120)   DEFAULT NULL,
    created_by   varchar(50),
    created_on   timestamp NULL DEFAULT CURRENT_TIMESTAMP,
    modified_by  varchar(50),
    modified_on  timestamp NULL DEFAULT CURRENT_TIMESTAMP,
    status_record CHARACTER VARYING(150) NOT NULL,
    version BIGINT,
    PRIMARY KEY (id)
);

--
-- Dumping data untuk tabel tbl_files
--

INSERT INTO tbl_files (judul, deskripsi, created_on, author, download, data, status_record)
VALUES ('Dasar-dasar CSS', 'Modul dasar-dasar CSS 3. Modul ini membantu anda untuk memahami struktur dasar CSS',
        '2019-01-23 04:30:01', 'Drs. Joko', 0, 'ab9a183ff240deadbedaff78e639af2f.pdf', 'ACTIVE'),
       ('14 Teknik Komunikasi Yang Paling Efektif',
        'Ebook 14 teknik komunikasi paling efektif membantu anda untuk berkomunikasi dengan baik dan benar',
        '2019-01-23 15:26:06', 'Drs. Joko', 0, 'ab2cb34682bd94f30f2347523112ffb9.pdf', 'ACTIVE'),
       ('Bagaimana Membentuk Pola Pikir yang Baru', 'Ebook ini membantu anda membentuk pola pikir baru.',
        '2019-01-23 15:27:07', 'Drs. Joko', 0, '30f588eb5c55324f8d18213f11651855.pdf', 'ACTIVE'),
       ('7 Tips Penting mengatasi Kritik', '7 Tips Penting mengatasi Kritik', '2019-01-23 15:27:44', 'Drs. Joko', 0,
        '329a62b25ad475a148e1546aa3db41de.docx', 'ACTIVE'),
       ('8 Racun dalam kehidupan kita', '8 Racun dalam kehidupan kita', '2019-01-23 15:28:17', 'Drs. Joko', 0,
        '8e38ad4948ba13758683dea443fbe6be.docx', 'ACTIVE'),
       ('Jurnal Teknologi Informasi', 'Jurnal Teknologi Informasi', '2019-01-25 03:18:53', 'Gunawan, S.Pd', 0,
        '87ae0f009714ddfdd79e2977b2a64632.pdf', 'ACTIVE'),
       ('Jurnal Teknologi Informasi 2', 'Jurnal Teknologi Informasi', '2019-01-25 03:19:22', 'Gunawan, S.Pd', 0,
        'c4e966ba2c6e142155082854dc5b3602.pdf', 'ACTIVE'),
       ('Naskah Publikasi IT', 'Naskah Teknologi Informasi', '2019-01-25 03:21:04', 'Gunawan, S.Pd', 0,
        '71380b3cf16a17a02382098c028ece9c.pdf', 'ACTIVE'),
       ('Modul Teknologi Informasi', 'Modul Teknologi Informasi', '2019-01-25 03:22:08', 'Gunawan, S.Pd', 0,
        '029143a3980232ab2900d94df36dbb0c.pdf', 'ACTIVE'),
       ('Modul Teknologi Informasi Part II', 'Modul Teknologi Informasi', '2019-01-25 03:22:54', 'Gunawan, S.Pd', 0,
        'ea8f3f732576083156e509657614f551.pdf', 'ACTIVE'),
       ('Modul Teknologi Informasi Part III', 'Modul Teknologi Informasi', '2019-01-25 03:23:21', 'Gunawan, S.Pd', 0,
        'c5e5e7d16e4cd6c3d22c11f64b0db2af.pdf', 'ACTIVE');
