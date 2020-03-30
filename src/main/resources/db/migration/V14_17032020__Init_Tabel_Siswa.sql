CREATE TABLE IF NOT EXISTS tbl_siswa
(
    id           UUID           DEFAULT uuid_generate_v4() NOT NULL,
    nama         varchar(75),
    jenkel       varchar(2),
    nis          varchar(20),
    photo        varchar(40),
    filename     varchar(50)    DEFAULT NULL,
    file_content bytea          DEFAULT NULL,
    kelas_id     int4      NOT NULL,
    created_by   varchar(50),
    created_on   timestamp NULL DEFAULT CURRENT_TIMESTAMP,
    modified_by  varchar(50),
    modified_on  timestamp NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
);

ALTER TABLE IF EXISTS tbl_siswa
    ADD CONSTRAINT FK7j7xvs7goinl9nq2n004ent0c
        FOREIGN KEY (kelas_id)
            REFERENCES tbl_kelas;

--
-- Dumping data untuk tabel tbl_siswa
--

INSERT INTO tbl_siswa (nis, nama, jenkel, kelas_id, photo)
VALUES ('9287482', 'Alvaro Sanchez', 'L', 8,
        '083d547659a2d4bb15c0322d15955da5.png'),
       ('9287483', 'Ririn Cantika', 'P', 8,
        '74eec6ad37550cc12fe8fa83d46878af.jpg'),
       ('123083', 'Ari Hidayat', 'L', 1,
        'e371e67618ad53c99de380782c373023.png'),
       ('123084', 'Irma Chaiyo', 'P', 1,
        '1e148b42c71562841ba3018fc97b748a.png'),
       ('123085', 'Nadila Ginting', 'P', 1,
        '8125da21f903803b6992214967239ab3.png'),
       ('123086', 'Anna Marina', 'P', 1,
        '33eaf3e3faf28a0fe31670c022f641f1.png'),
       ('123086', 'Dhea Lubis', 'P', 1, '03e651410e969c3c26e8e0d35380470d.png'),
       ('123087', 'Nadia Ginting', 'P', 1,
        'd7823f8d98d376c085aa284a54d63264.png'),
       ('123088', 'Mita Febrina', 'P', 1,
        'eca0280a4a57c911ee68b8318d1e517f.png'),
       ('123089', 'Elizabeth ', 'P', 1, 'ec1232a08d650bc8c3197c9db95a7fc8.png'),
       ('123090', 'Della Guswono', 'P', 1,
        '6c82fce13bb3eff1fd2e897b2c3cfeeb.png');

-- --------------------------------------------------------
