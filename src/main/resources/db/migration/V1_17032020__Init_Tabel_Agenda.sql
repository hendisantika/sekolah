CREATE TABLE IF NOT EXISTS tbl_agenda(
                                         id          UUID           DEFAULT uuid_generate_v4() NOT NULL,
                                         nama        varchar(200)   DEFAULT NULL,
                                         deskripsi   text,
                                         mulai       date           DEFAULT NULL,
                                         selesai     date           DEFAULT NULL,
                                         tempat      varchar(90)    DEFAULT NULL,
                                         waktu       varchar(30)    DEFAULT NULL,
                                         keterangan  varchar(200)   DEFAULT NULL,
                                         created_by  varchar(50),
                                         created_on  timestamp NULL DEFAULT CURRENT_TIMESTAMP,
                                         modified_by varchar(50),
                                         modified_on timestamp NULL DEFAULT CURRENT_TIMESTAMP,
                                         status_record CHARACTER VARYING(150) NOT NULL,
                                         version BIGINT,
                                         PRIMARY KEY (id)
);

--
-- Dumping data untuk tabel tbl_agenda
--

INSERT INTO tbl_agenda (nama, deskripsi, mulai, selesai, tempat, waktu, keterangan, created_by, status_record)
VALUES ('Penyembelihan Hewan Kurban Idul Adha 2019',
        'Idul Adha yang biasa disebut lebaran haji atapun lebaran kurban sangat identik dengan penyembelihan hewan kurban. M-Sekolah tahun ini juga melakukan penyembelihan hewan kurban. Yang rencananya akan dihadiri oleh guru-guru, siswa dan pengurus OSIS.',
        '2019-01-22', '2019-01-22', 'M-Sekolah', '08.00 - 11.00 WIB',
        'Dihadiri oleh guru-guru, siswa dan pengurus OSIS', 'Hendi Santika', 'ACTIVE'),
       ('Peluncuran Website Resmi M-Sekolah',
        'Peluncuran website resmi  M-Sekolah, sebagai media informasi dan akademik online untuk pelayanan pendidikan yang lebih baik kepada siswa, orangtua, dan masyarakat pada umumnya semakin meningkat.',
        '2019-01-04', '2019-01-04', 'M-Sekolah', '07.30 - 12.00 WIB', '-', 'Hendi Santika', 'ACTIVE'),
       ('Penerimaan Raport Semester Ganjil Tahun Ajaran 2019-2018',
        'Berakhirnya semester ganjil tahun pelajaran 2016-2019, ditandai dengan pembagian laporan hasil belajar.',
        '2019-02-17', '2019-02-17', 'M-Sekolah', '07.30 - 12.00 WIB',
        'Untuk kelas XI dan XII, pembagian raport dimulai pukul 07.30 WIB. Sedangkan untuk kelas X pada pukul 09.00 WIB. Raport diambil oleh orang tua/wali murid masing-masing.',
        'Hendi Santika', 'ACTIVE');
