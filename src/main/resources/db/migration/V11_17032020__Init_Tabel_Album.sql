CREATE TABLE IF NOT EXISTS tbl_album(
    id           UUID           DEFAULT uuid_generate_v4() NOT NULL,
    pengguna_id  UUID           DEFAULT uuid_generate_v4() NOT NULL,
    nama         varchar(50)    DEFAULT NULL,
    author       varchar(60)    DEFAULT NULL,
    count        INT            DEFAULT '0',
    cover        varchar(40)    DEFAULT NULL,
    photo_base64 text,
    filename     varchar(50)    DEFAULT NULL,
    file_content bytea          DEFAULT NULL,
    created_by   varchar(50),
    created_on   timestamp NULL DEFAULT CURRENT_TIMESTAMP,
    modified_by varchar(50),
    modified_on timestamp NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
);

ALTER TABLE IF EXISTS tbl_album
    ADD CONSTRAINT FK7j7xvs7goinl9nq2n004ent0c
        FOREIGN KEY (pengguna_id)
            REFERENCES tbl_pengguna;


--
-- Dumping data untuk tabel tbl_album
--

INSERT INTO tbl_album (id, pengguna_id, nama, author, created_by, count, cover) VALUES
('fa5fd7d5-4813-40f8-80e9-f22ec38af7f1', '5fb19496-c860-4e66-8ff1-41c8c8686c78', 'Kedatangan Tamu Asing', 'Hendi Santika', 'admin', 5, '202aa754590dfc1070c624bad294abbc.jpg'),
('fa5fd7d5-4813-40f8-80e9-f22ec38af7f2', '5fb19496-c860-4e66-8ff1-41c8c8686c78', 'Pemilu Osis 2016-2017',  'Hendi Santika', 'admin', 3, 'dc088a9fb62333012ff7a601828219d7.jpg'),
('fa5fd7d5-4813-40f8-80e9-f22ec38af7f3', '5fb19496-c860-4e66-8ff1-41c8c8686c78', 'Kegiatan Belajar Siswa', 'Hendi Santika', 'admin', 7, '203bc0411a07ed0430d39bcc38ec2c56.jpg');