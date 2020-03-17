CREATE TABLE IF NOT EXISTS tbl_galeri
(
    galeri_id          UUID           DEFAULT uuid_generate_v4() NOT NULL,
    galeri_judul       varchar(60)    DEFAULT NULL,
    galeri_tanggal     timestamp NULL DEFAULT CURRENT_TIMESTAMP,
    galeri_gambar      varchar(40)    DEFAULT NULL,
    galeri_album_id    INT            DEFAULT NULL,
    galeri_pengguna_id INT            DEFAULT NULL,
    galeri_author      varchar(60)    DEFAULT NULL,
    PRIMARY KEY (galeri_id)
);

CREATE INDEX galeri_pengguna_id_idx ON tbl_galeri (galeri_pengguna_id);
CREATE INDEX galeri_album_id_idx ON tbl_galeri (galeri_album_id);
--
-- Dumping data untuk tabel tbl_galeri
--

INSERT INTO tbl_galeri (galeri_judul, galeri_tanggal, galeri_gambar, galeri_album_id, galeri_pengguna_id, galeri_author)
VALUES ('Diskusi Pemilihan Ketua Osis', '2017-01-21 14:04:53', '9b10fa300633f62f105e9b52789fc8f3.jpg', 3, 1,
        'Hendi Santika'),
       ('Panitia Pemilu Osis', '2017-01-22 04:13:20', '0ec0c2f9aae6501d7ed7930995d48b57.jpg', 3, 1, 'Hendi Santika'),
       ('Proses Pemilu Osis', '2017-01-22 04:13:43', 'bfbe6cc1c8096f5f36c68e93da53c248.jpg', 3, 1, 'Hendi Santika'),
       ('Belajar dengan native speaker', '2017-01-24 01:26:22', '831e5ad43ccc3c851d50c128ff095541.jpg', 1, 1,
        'Hendi Santika'),
       ('Diskusi dengan native speaker', '2017-01-24 01:27:05', '84afbf1d3ad45932f1d7ac47b8a00949.jpg', 1, 1,
        'Hendi Santika'),
       ('Foto bareng native speaker', '2017-01-24 01:27:28', 'a99ab060d5d5bf8c96f24fe385f7dd8b.jpg', 1, 1,
        'Hendi Santika'),
       ('Foto bareng native speaker', '2017-01-24 01:28:40', 'd70cedba6391b7b3c74b914efd82953f.jpg', 1, 1,
        'Hendi Santika'),
       ('Foto bareng native speaker', '2017-01-24 01:28:54', '10de99f425b9961ce1e87c5e5575f8f4.jpg', 1, 1,
        'Hendi Santika'),
       ('Belajar sambil bermain', '2017-01-24 01:31:42', '9df82241493b94d1e06b461129cf57b2.jpg', 4, 1, 'Hendi Santika'),
       ('Belajar sambil bermain', '2017-01-24 01:31:55', '5374415f11683ad6dd31572a7bbf8a7b.jpg', 4, 1, 'Hendi Santika'),
       ('Belajar komputer programming', '2017-01-24 01:32:24', '82b91bd35706b21c3ab04e205e358eb6.jpg', 4, 1,
        'Hendi Santika'),
       ('Belajar komputer programming', '2017-01-24 01:32:34', '93048f2a103987bce8c8ec8d6912de06.jpg', 4, 1,
        'Hendi Santika'),
       ('Belajar komputer programming', '2017-01-24 01:32:44', '41f46be181f2f8452c2041b5e79a05a5.jpg', 4, 1,
        'Hendi Santika'),
       ('Belajar sambil bermain', '2017-01-24 01:33:08', '2858b0555c252690e293d29b922ba8e6.jpg', 4, 1, 'Hendi Santika'),
       ('Makan bersama', '2017-01-24 01:33:24', '90d67328e33a31d3f5eecd7dcb25b55d.jpg', 4, 1, 'Hendi Santika');
