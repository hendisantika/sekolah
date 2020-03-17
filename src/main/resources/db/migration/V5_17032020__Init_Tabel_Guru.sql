CREATE TABLE IF NOT EXISTS tbl_guru
(
    guru_id        UUID           DEFAULT uuid_generate_v4() NOT NULL,
    guru_nip       varchar(30)    DEFAULT NULL,
    guru_nama      varchar(70)    DEFAULT NULL,
    guru_jenkel    varchar(2)     DEFAULT NULL,
    guru_tmp_lahir varchar(80)    DEFAULT NULL,
    guru_tgl_lahir varchar(80)    DEFAULT NULL,
    guru_mapel     varchar(120)   DEFAULT NULL,
    guru_photo     varchar(40)    DEFAULT NULL,
    guru_tgl_input timestamp NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (guru_id)
);

--
-- Dumping data untuk tabel tbl_guru
--

INSERT INTO tbl_guru (guru_nip, guru_nama, guru_jenkel, guru_tmp_lahir, guru_tgl_lahir, guru_mapel, guru_photo,
                      guru_tgl_input)
VALUES ('927482658274982', 'Hendi Santika', 'L', 'Padang', '25 September 1993', 'Teknik Komputer',
        'f6bbe1e04e78e0d715e9830a605794aa.jpg', '2017-01-26 07:49:43'),
       ('927482658274981', 'Thomas Muller', 'L', 'Germany', '25 September 1989', 'Olahgara', NULL,
        '2017-01-26 13:38:54'),
       ('-', 'Joko Subroto', 'L', 'Jakarta', '25 September 1989', 'PPKN, Matematika', NULL, '2017-01-26 13:41:20'),
       ('-', 'Kusta Otomo', 'L', 'Jakarta', '25 September 1989', 'Seni Budaya', NULL, '2017-01-26 13:42:08'),
       ('-', 'Yuliani Ningsih', 'P', 'Padang', '27 September 1993', 'Bahasa Indonesia', NULL, '2017-01-26 13:42:48'),
       ('927482658274993', 'Ari Hidayat', 'L', 'Padang', '25 September 1993', 'Bahasa Inggris', NULL,
        '2017-01-26 13:43:46'),
       ('927482658274998', 'Irma Cantika', 'P', 'Padang', '25 September 1993', 'Bahasa Inggris, IPA',
        '4200d2514abf45755943526b74474c16.jpg', '2017-01-26 13:45:11'),
       ('-', 'Ririn Febriesta', 'P', 'Padang', '27 September 1994', 'Pend. Agama Islam', NULL, '2017-01-27 04:28:23');

-- -----------------