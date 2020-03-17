CREATE TABLE IF NOT EXISTS tbl_pengumuman
(
    pengumuman_id        UUID           DEFAULT uuid_generate_v4() NOT NULL,
    pengumuman_judul     varchar(150)   DEFAULT NULL,
    pengumuman_deskripsi text,
    pengumuman_tanggal   timestamp NULL DEFAULT CURRENT_TIMESTAMP,
    pengumuman_author    varchar(60)    DEFAULT NULL,
    PRIMARY KEY (pengumuman_id)
);

--
-- Dumping data untuk tabel tbl_pengumuman
--

INSERT INTO tbl_pengumuman (pengumuman_judul, pengumuman_deskripsi, pengumuman_tanggal, pengumuman_author)
VALUES ('Pengumuman Libur Semester Ganjil Tahun Ajaran 2016-2017',
        'Libur semester ganjil tahun ajaran 2016-2017 dimulai dari tanggal 3 Maret 2017 sampai dengan tanggal 7 Maret 207.',
        '2017-01-21 01:17:30', 'M Fikri Setiadi'),
       ('Pengumuman Pembagian Raport Semester Ganjil Tahun Ajaran 2016-2017',
        'Menjelang berakhirnya proses belajar-mengajar di semester ganjil tahun ajaran 2016-2017, maka akan diadakan pembagian hasil belajar/raport pada tanggal 4 Maret 2017 pukul 07.30 WIB.\r\nYang bertempat di M-Sekolah. Raport diambil oleh orang tua/wali kelas murid masing-masing',
        '2017-01-21 01:16:20', 'M Fikri Setiadi'),
       ('Pengumuman Peresmian dan Launching Website Perdana M-Sekolah',
        'Peresmian dan launching website resmi M-Sekolah akan diadakan pada hari 23 Desember 2016 pukul 10.00, bertepatan dengan pembagian raport semester ganjil tahun ajaran 2016-2017',
        '2017-01-22 07:16:16', 'M Fikri Setiadi'),
       ('Pengumuman Proses Belajar Mengajar di Semester Genap Tahun Ajaran 2016-2017',
        'Setelah libur semester ganjil tahun ajaran 2016-2017, proses belajar mengajar di semester genap tahun ajaran 2016-2017 mulai aktif kembali tanggal 2 Maret 2017.',
        '2017-01-22 07:15:28', 'M Fikri Setiadi');

-- --------------------------------------------------------
