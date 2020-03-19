CREATE TABLE IF NOT EXISTS tbl_komentar
(
    komentar_id         UUID           DEFAULT uuid_generate_v4() NOT NULL,
    komentar_nama       varchar(30)    DEFAULT NULL,
    komentar_email      varchar(50)    DEFAULT NULL,
    komentar_isi        varchar(120)   DEFAULT NULL,
    komentar_tanggal    timestamp NULL DEFAULT CURRENT_TIMESTAMP,
    komentar_status     varchar(2)     DEFAULT NULL,
    komentar_tulisan_id UUID           DEFAULT NULL,
    komentar_parent     int            DEFAULT '0',
    PRIMARY KEY (komentar_id)
);
CREATE INDEX komentar_tulisan_id_idx ON tbl_komentar (komentar_tulisan_id);
--
-- Dumping data untuk tabel tbl_komentar
--

INSERT INTO tbl_komentar (komentar_nama, komentar_email, komentar_isi, komentar_tanggal, komentar_status,
                          komentar_tulisan_id, komentar_parent)
VALUES ('M Fikri', 'fikrifiver97@gmail.com', ' Nice Post.', '2018-08-07 15:09:07', '1',
        '2588df34-3058-4faf-a5d2-e8d13aba7e49', 0),
       ('Hendi Santika', 'fikrifiver97@gmail.com', ' Awesome Post', '2018-08-07 15:14:26', '1',
        '2588df34-3058-4faf-a5d2-e8d13aba7e49', 0),
       ('Joko', 'joko@gmail.com', 'Thank you.', '2018-08-08 03:54:56', '1', '2588df34-3058-4faf-a5d2-e8d13aba7e49', 1);
