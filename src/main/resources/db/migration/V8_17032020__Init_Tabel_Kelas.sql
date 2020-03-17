CREATE TABLE IF NOT EXISTS tbl_kelas
(
    kelas_id   UUID        DEFAULT uuid_generate_v4() NOT NULL,
    kelas_nama varchar(40) DEFAULT NULL,
    PRIMARY KEY (kelas_id)
);

--
-- Dumping data untuk tabel tbl_kelas
--

INSERT INTO tbl_kelas (kelas_nama)
VALUES ('Kelas X.1'),
       ('Kelas X.2'),
       ('Kelas X.3'),
       ('Kelas X.4'),
       ('Kelas X.5'),
       ('Kelas X.6'),
       ('Kelas X.7'),
       ('Kelas XI IPA.1'),
       ('Kelas XI IPA.2'),
       ('Kelas XI IPA.3'),
       ('Kelas XI IPA.4'),
       ('Kelas XI IPA.5'),
       ('Kelas XI IPA.6'),
       ('Kelas XI IPA.7'),
       ('Kelas XI IPS.1'),
       ('Kelas XI IPS.2'),
       ('Kelas XI IPS.3'),
       ('Kelas XI IPS.4'),
       ('Kelas XI IPS.5'),
       ('Kelas XI IPS.6'),
       ('Kelas XI IPS.7');