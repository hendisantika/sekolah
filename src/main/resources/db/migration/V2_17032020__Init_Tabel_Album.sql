CREATE TABLE IF NOT EXISTS tbl_album (
  album_id UUID DEFAULT uuid_generate_v4 () NOT NULL,
  album_nama varchar(50) DEFAULT NULL,
  album_tanggal timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  album_pengguna_id NUMERIC (11) DEFAULT NULL,
  album_author varchar(60) DEFAULT NULL,
  album_count NUMERIC (11) DEFAULT '0',
  album_cover varchar(40) DEFAULT NULL,
  PRIMARY KEY (album_id)
);

--
-- Dumping data untuk tabel tbl_album
--

INSERT INTO tbl_album (album_nama, album_tanggal, album_pengguna_id, album_author, album_count, album_cover) VALUES
('Kedatangan Tamu Asing', '2016-09-08 13:00:55', 1, 'Hendi Santika', 5, '202aa754590dfc1070c624bad294abbc.jpg'),
('Pemilu Osis 2016-2017', '2017-01-21 01:58:16', 1, 'Hendi Santika', 3, 'dc088a9fb62333012ff7a601828219d7.jpg'),
('Kegiatan Belajar Siswa', '2017-01-24 01:31:13', 1, 'Hendi Santika', 7, '203bc0411a07ed0430d39bcc38ec2c56.jpg');