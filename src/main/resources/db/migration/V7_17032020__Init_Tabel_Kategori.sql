CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS tbl_kategori
(
    id          UUID           DEFAULT uuid_generate_v4() NOT NULL,
    nama        varchar(30)    DEFAULT NULL,
    created_by  varchar(50),
    created_on  timestamp NULL DEFAULT CURRENT_TIMESTAMP,
    modified_by varchar(50),
    modified_on timestamp NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
);

--
-- Dumping data untuk tabel tbl_kategori
--

INSERT INTO tbl_kategori (id, nama, created_on)
VALUES ('804333aa-becc-4a36-8fca-fad56a7ce3da', 'Pendidikan', '2019-09-06 05:49:04'),
       ('e2a7bccd-b218-4262-8e22-6a7f5c7e8887', 'Politik', '2019-09-06 05:50:01'),
       ('a1570c97-45c3-47bf-959c-4fdeb14d731e', 'Sains', '2019-09-06 05:59:39'),
       ('5bf287e3-c722-43b0-87aa-2a0e1f32f743', 'Penelitian', '2019-09-06 06:19:26'),
       ('b2381449-09af-4f1b-b1cc-8ff7dfd56268', 'Prestasi', '2019-09-07 02:51:09'),
       ('82d9b12f-1716-4d9a-adaa-b5ab488e4b87', 'Olah Raga', '2019-01-13 13:20:31');