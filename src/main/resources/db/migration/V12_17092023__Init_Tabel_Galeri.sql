CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS tbl_galeri
(
    id           UUID           DEFAULT uuid_generate_v4() NOT NULL,
    pengguna_id  UUID           NOT NULL,
    album_id     UUID           NOT NULL,
    judul        varchar(60)    DEFAULT NULL,
    gambar       varchar(40)    DEFAULT NULL,
    author       varchar(60)    DEFAULT NULL,
    photo_base64 text,
    filename     varchar(50)    DEFAULT NULL,
    file_content bytea          DEFAULT NULL,
    created_by   varchar(50),
    created_on   timestamp NULL DEFAULT CURRENT_TIMESTAMP,
    modified_by  varchar(50),
    modified_on  timestamp NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
);

CREATE INDEX pengguna_id_idx ON tbl_galeri (pengguna_id);
CREATE INDEX album_id_idx ON tbl_galeri (album_id);

ALTER TABLE IF EXISTS tbl_galeri
    ADD CONSTRAINT FK7j7xvs7goinl9nq2n004ent0c
        FOREIGN KEY (pengguna_id)
            REFERENCES tbl_pengguna;

ALTER TABLE IF EXISTS tbl_galeri
    ADD CONSTRAINT FK7j7xvs7goinl9nq2n004ent0d
        FOREIGN KEY (album_id)
            REFERENCES tbl_album;

--
-- Dumping data untuk tabel tbl_galeri
--

INSERT INTO tbl_galeri (id, album_id, pengguna_id, judul, created_on, gambar, author)
VALUES ('dc41e8b0-caae-475e-a1dd-fcb03ed23680', 'fa5fd7d5-4813-40f8-80e9-f22ec38af7f3', '5fb19496-c860-4e66-8ff1-41c8c8686c78',
'Diskusi Pemilihan Ketua Osis', '2019-01-21 14:04:53', '9b10fa300633f62f105e9b52789fc8f3.jpg','Hendi Santika'),

('aca4bee8-a6ec-42cf-b365-ae34effe5f0a', 'fa5fd7d5-4813-40f8-80e9-f22ec38af7f3', '5fb19496-c860-4e66-8ff1-41c8c8686c78',
'Panitia Pemilu Osis', '2019-01-21 14:04:53', '0ec0c2f9aae6501d7ed7930995d48b57.jpg', 'Hendi Santika'),

('1d917db9-d268-4f6e-b896-b7ed91b32354', 'fa5fd7d5-4813-40f8-80e9-f22ec38af7f3', '5fb19496-c860-4e66-8ff1-41c8c8686c78',
'Proses Pemilu Osis', '2019-01-21 14:04:53', 'bfbe6cc1c8096f5f36c68e93da53c248.jpg', 'Hendi Santika'),

('cd85417e-c6df-43c3-baf0-2a9797f67f5f', 'fa5fd7d5-4813-40f8-80e9-f22ec38af7f2', '5fb19496-c860-4e66-8ff1-41c8c8686c78',
'Belajar dengan native speaker', '2019-01-21 14:04:53', '831e5ad43ccc3c851d50c128ff095541.jpg', 'Hendi Santika'),

('cd85417e-c6df-43c3-baf0-2a9797f67f52', 'fa5fd7d5-4813-40f8-80e9-f22ec38af7f2', '5fb19496-c860-4e66-8ff1-41c8c8686c78',
'Diskusi dengan native speaker', '2019-01-21 14:04:53', '84afbf1d3ad45932f1d7ac47b8a00949.jpg', 'Hendi Santika'),

('cd85417e-c6df-43c3-baf0-2a9797f67f53', 'fa5fd7d5-4813-40f8-80e9-f22ec38af7f2', '5fb19496-c860-4e66-8ff1-41c8c8686c78',
'Foto bareng native speaker', '2019-01-21 14:04:53', 'a99ab060d5d5bf8c96f24fe385f7dd8b.jpg', 'Hendi Santika'),

('cd85417e-c6df-43c3-baf0-2a9797f67f54', 'fa5fd7d5-4813-40f8-80e9-f22ec38af7f2', '5fb19496-c860-4e66-8ff1-41c8c8686c78',
'Foto bareng native speaker', '2019-01-21 14:04:53', 'd70cedba6391b7b3c74b914efd82953f.jpg', 'Hendi Santika'),

('cd85417e-c6df-43c3-baf0-2a9797f67f55', 'fa5fd7d5-4813-40f8-80e9-f22ec38af7f2', '5fb19496-c860-4e66-8ff1-41c8c8686c78',
'Foto bareng native speaker', '2019-01-21 14:04:53', '10de99f425b9961ce1e87c5e5575f8f4.jpg', 'Hendi Santika'),

('cd85417e-c6df-43c3-baf0-2a9797f67f56', 'fa5fd7d5-4813-40f8-80e9-f22ec38af7f1', '5fb19496-c860-4e66-8ff1-41c8c8686c78',
'Belajar sambil bermain', '2019-01-21 14:04:53', '9df82241493b94d1e06b461129cf57b2.jpg', 'Hendi Santika'),

('cd85417e-c6df-43c3-baf0-2a9797f67f57', 'fa5fd7d5-4813-40f8-80e9-f22ec38af7f1', '5fb19496-c860-4e66-8ff1-41c8c8686c78',
'Belajar sambil bermain', '2019-01-21 14:04:53', '5374415f11683ad6dd31572a7bbf8a7b.jpg', 'Hendi Santika'),

('cd85417e-c6df-43c3-baf0-2a9797f67f58', 'fa5fd7d5-4813-40f8-80e9-f22ec38af7f1', '5fb19496-c860-4e66-8ff1-41c8c8686c78',
'Belajar komputer programming', '2019-01-21 14:04:53', '82b91bd35706b21c3ab04e205e358eb6.jpg', 'Hendi Santika'),

('cd85417e-c6df-43c3-baf0-2a9797f67f59', 'fa5fd7d5-4813-40f8-80e9-f22ec38af7f1', '5fb19496-c860-4e66-8ff1-41c8c8686c78',
'Belajar komputer programming', '2019-01-21 14:04:53', '93048f2a103987bce8c8ec8d6912de06.jpg', 'Hendi Santika'),

('cd85417e-c6df-43c3-baf0-2a9797f67f60', 'fa5fd7d5-4813-40f8-80e9-f22ec38af7f1', '5fb19496-c860-4e66-8ff1-41c8c8686c78',
'Belajar komputer programming', '2019-01-21 14:04:53', '41f46be181f2f8452c2041b5e79a05a5.jpg', 'Hendi Santika'),

('cd85417e-c6df-43c3-baf0-2a9797f67f61', 'fa5fd7d5-4813-40f8-80e9-f22ec38af7f1', '5fb19496-c860-4e66-8ff1-41c8c8686c78',
'Belajar sambil bermain', '2019-01-21 14:04:53', '2858b0555c252690e293d29b922ba8e6.jpg', 'Hendi Santika'),

('cd85417e-c6df-43c3-baf0-2a9797f67f62', 'fa5fd7d5-4813-40f8-80e9-f22ec38af7f1', '5fb19496-c860-4e66-8ff1-41c8c8686c78',
'Makan bersama', '2019-01-21 14:04:53', '90d67328e33a31d3f5eecd7dcb25b55d.jpg', 'Hendi Santika');