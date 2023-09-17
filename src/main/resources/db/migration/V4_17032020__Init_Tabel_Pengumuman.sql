CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS tbl_pengumuman
(
    id          UUID           DEFAULT uuid_generate_v4() NOT NULL,
    judul       varchar(150)   DEFAULT NULL,
    deskripsi   text,
    author      varchar(60)    DEFAULT NULL,
    created_by  varchar(50),
    created_on  timestamp NULL DEFAULT CURRENT_TIMESTAMP,
    modified_by varchar(50),
    modified_on timestamp NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
);

--
-- Dumping data untuk tabel tbl_pengumuman
--

INSERT INTO tbl_pengumuman (judul, deskripsi, created_on, author)
VALUES ('Pengumuman Libur Semester Ganjil Tahun Ajaran 2016-2017',
        'Libur semester ganjil tahun ajaran 2016-2017 dimulai dari tanggal 3 Maret 2017 sampai dengan tanggal 7 Maret 207.',
        '2019-01-21 01:17:30', 'Hendi Santika'),
       ('Pengumuman Pembagian Raport Semester Ganjil Tahun Ajaran 2016-2017',
        'Menjelang berakhirnya proses belajar-mengajar di semester ganjil tahun ajaran 2016-2017, maka akan diadakan pembagian hasil belajar/raport pada tanggal 4 Maret 2017 pukul 07.30 WIB.\r\nYang bertempat di M-Sekolah. Raport diambil oleh orang tua/wali kelas murid masing-masing',
        '2019-01-21 01:16:20', 'Hendi Santika'),
       ('Pengumuman Peresmian dan Launching Website Perdana M-Sekolah',
        'Peresmian dan launching website resmi M-Sekolah akan diadakan pada hari 23 Desember 2016 pukul 10.00, bertepatan dengan pembagian raport semester ganjil tahun ajaran 2016-2017',
        '2019-01-22 07:16:16', 'Hendi Santika'),
       ('Pengumuman Proses Belajar Mengajar di Semester Genap Tahun Ajaran 2016-2017',
        'Setelah libur semester ganjil tahun ajaran 2016-2017, proses belajar mengajar di semester genap tahun ajaran 2016-2017 mulai aktif kembali tanggal 2 Maret 2017.',
        '2019-01-22 07:15:28', 'Hendi Santika');

-- --------------------------------------------------------
