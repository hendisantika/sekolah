CREATE TABLE IF NOT EXISTS tbl_guru
(
    id           UUID           DEFAULT uuid_generate_v4() NOT NULL,
    nip          varchar(30)    DEFAULT NULL,
    nama         varchar(70)    DEFAULT NULL,
    jenkel       varchar(2)     DEFAULT NULL,
    tmp_lahir    varchar(80)    DEFAULT NULL,
    tgl_lahir    varchar(80)    DEFAULT NULL,
    mapel        varchar(120)   DEFAULT NULL,
    photo        varchar(40)    DEFAULT NULL,
    photo_base64 text,
    filename     varchar(50)    DEFAULT NULL,
    file_content bytea          DEFAULT NULL,
    tgl_input    timestamp NULL DEFAULT CURRENT_TIMESTAMP,
    created_by   varchar(50),
    created_on   timestamp NULL DEFAULT CURRENT_TIMESTAMP,
    modified_by  varchar(50),
    modified_on  timestamp NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
);

--
-- Dumping data untuk tabel tbl_guru
--

INSERT INTO tbl_guru (nip, nama, jenkel, tmp_lahir, tgl_lahir, mapel, photo,
                      tgl_input)
VALUES ('927482658274982', 'Hendi Santika', 'L', 'Padang', '1989-09-25', 'Teknik Komputer',
        'f6bbe1e04e78e0d715e9830a605794aa.jpg', '2020-01-26 07:49:43'),
       ('927482658274981', 'Thomas Muller', 'L', 'Germany', '1989-09-25', 'Olahgara', NULL,
        '2020-01-26 13:38:54'),
       ('-', 'Joko Subroto', 'L', 'Jakarta', '1989-09-25', 'PPKN, Matematika', NULL, '2020-01-26 13:41:20'),
       ('-', 'Kusta Otomo', 'L', 'Jakarta', '1989-09-25', 'Seni Budaya', NULL, '2020-01-26 13:42:08'),
       ('-', 'Yuliani Ningsih', 'P', 'Padang', '1989-09-25', 'Bahasa Indonesia', NULL, '2020-01-26 13:42:48'),
       ('927482658274993', 'Ari Hidayat', 'L', 'Padang', '1989-09-25', 'Bahasa Inggris', NULL,
        '2020-01-26 13:43:46'),
       ('927482658274998', 'Irma Cantika', 'P', 'Padang', '1989-09-25', 'Bahasa Inggris, IPA',
        '4200d2514abf45755943526b74474c16.jpg', '2020-01-26 13:45:11'),
       ('-', 'Ririn Febriesta', 'P', 'Padang', '1989-09-25', 'Pend. Agama Islam', NULL, '2020-01-27 04:28:23');

-- -----------------