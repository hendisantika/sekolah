CREATE TABLE IF NOT EXISTS tbl_album (
  id UUID DEFAULT uuid_generate_v4 () NOT NULL,
  nama varchar(50) DEFAULT NULL,
  pengguna_id INT DEFAULT NULL,
  author varchar(60) DEFAULT NULL,
  count INT DEFAULT '0',
  cover varchar(40) DEFAULT NULL,
  created_by varchar(50),
  created_on timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  modified_by varchar(50),
  modified_on timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id)
);

--
-- Dumping data untuk tabel tbl_album
--

INSERT INTO tbl_album (nama, created_by, count, cover) VALUES
('Kedatangan Tamu Asing', 'Hendi Santika', 5, '202aa754590dfc1070c624bad294abbc.jpg'),
('Pemilu Osis 2016-2017', 'Hendi Santika', 3, 'dc088a9fb62333012ff7a601828219d7.jpg'),
('Kegiatan Belajar Siswa', 'Hendi Santika', 7, '203bc0411a07ed0430d39bcc38ec2c56.jpg');