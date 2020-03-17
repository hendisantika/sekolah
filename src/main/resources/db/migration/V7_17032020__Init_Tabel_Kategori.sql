CREATE TABLE IF NOT EXISTS tbl_kategori
(
    kategori_id      UUID           DEFAULT uuid_generate_v4() NOT NULL,
    kategori_nama    varchar(30)    DEFAULT NULL,
    kategori_tanggal timestamp NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (kategori_id)
);

--
-- Dumping data untuk tabel tbl_kategori
--

INSERT INTO tbl_kategori (kategori_nama, kategori_tanggal)
VALUES ('Pendidikan', '2016-09-06 05:49:04'),
       ('Politik', '2016-09-06 05:50:01'),
       ('Sains', '2016-09-06 05:59:39'),
       ('Penelitian', '2016-09-06 06:19:26'),
       ('Prestasi', '2016-09-07 02:51:09'),
       ('Olah Raga', '2017-01-13 13:20:31');

-- ------------------------------------------------