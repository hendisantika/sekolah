CREATE TABLE IF NOT EXISTS tbl_agenda (
  agenda_id UUID DEFAULT uuid_generate_v4 () NOT NULL,
  agenda_nama varchar(200) DEFAULT NULL,
  agenda_tanggal timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  agenda_deskripsi text,
  agenda_mulai date DEFAULT NULL,
  agenda_selesai date DEFAULT NULL,
  agenda_tempat varchar(90) DEFAULT NULL,
  agenda_waktu varchar(30) DEFAULT NULL,
  agenda_keterangan varchar(200) DEFAULT NULL,
  agenda_author varchar(60) DEFAULT NULL,
  agenda_created_on timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  agenda_modified_on timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (agenda_id)
);

--
-- Dumping data untuk tabel tbl_agenda
--

INSERT INTO tbl_agenda (agenda_nama, agenda_tanggal, agenda_deskripsi, agenda_mulai, agenda_selesai, agenda_tempat, agenda_waktu, agenda_keterangan, agenda_author) VALUES
('Penyembelihan Hewan Kurban Idul Adha 2017', '2017-01-22 06:18:01', 'Idul Adha yang biasa disebut lebaran haji atapun lebaran kurban sangat identik dengan penyembelihan hewan kurban. M-Sekolah tahun ini juga melakukan penyembelihan hewan kurban. Yang rencananya akan dihadiri oleh guru-guru, siswa dan pengurus OSIS.', '2017-01-22', '2017-01-22', 'M-Sekolah', '08.00 - 11.00 WIB', 'Dihadiri oleh guru-guru, siswa dan pengurus OSIS', 'Hendi Santika'),
('Peluncuran Website Resmi M-Sekolah', '2017-01-22 06:26:33', 'Peluncuran website resmi  M-Sekolah, sebagai media informasi dan akademik online untuk pelayanan pendidikan yang lebih baik kepada siswa, orangtua, dan masyarakat pada umumnya semakin meningkat.', '2017-01-04', '2017-01-04', 'M-Sekolah', '07.30 - 12.00 WIB', '-', 'Hendi Santika'),
('Penerimaan Raport Semester Ganjil Tahun Ajaran 2017-2018', '2017-01-22 06:29:49', 'Berakhirnya semester ganjil tahun pelajaran 2016-2017, ditandai dengan pembagian laporan hasil belajar.', '2017-02-17', '2017-02-17', 'M-Sekolah', '07.30 - 12.00 WIB', 'Untuk kelas XI dan XII, pembagian raport dimulai pukul 07.30 WIB. Sedangkan untuk kelas X pada pukul 09.00 WIB. Raport diambil oleh orang tua/wali murid masing-masing.', 'Hendi Santika');
