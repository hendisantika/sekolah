CREATE TABLE IF NOT EXISTS tbl_pengunjung
(
    pengunjung_id        UUID           DEFAULT uuid_generate_v4() NOT NULL,
    pengunjung_tanggal   timestamp NULL DEFAULT CURRENT_TIMESTAMP,
    pengunjung_ip        varchar(40)    DEFAULT NULL,
    pengunjung_perangkat varchar(100)   DEFAULT NULL,
    PRIMARY KEY (pengunjung_id)
);

--
-- Dumping data untuk tabel tbl_pengunjung
--

INSERT INTO tbl_pengunjung (pengunjung_tanggal, pengunjung_ip, pengunjung_perangkat)
VALUES ('2018-08-09 08:04:59', '::1', 'Chrome');
