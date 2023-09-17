CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS tbl_komentar
(
    id          UUID           DEFAULT uuid_generate_v4() NOT NULL,
    tulisan_id  UUID           DEFAULT NULL,
    nama        varchar(30)    DEFAULT NULL,
    email       varchar(50)    DEFAULT NULL,
    isi         varchar(120)   DEFAULT NULL,
    status      varchar(2)     DEFAULT NULL,
    parent      int            DEFAULT '0',
    created_by  varchar(50),
    created_on  timestamp NULL DEFAULT CURRENT_TIMESTAMP,
    modified_by varchar(50),
    modified_on timestamp NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
);
CREATE INDEX tulisan_id_idx ON tbl_komentar (tulisan_id);
--
-- Dumping data untuk tabel tbl_komentar
--

INSERT INTO tbl_komentar (tulisan_id, nama, email, isi, created_on, status, parent)
VALUES ('2588df34-3058-4faf-a5d2-e8d13aba7e49', 'M Fikri', 'fikrifiver97@gmail.com', ' Nice Post.', '2019-08-07 15:09:07', '1', 0),
       ('2588df34-3058-4faf-a5d2-e8d13aba7e49', 'Hendi Santika', 'fikrifiver97@gmail.com', ' Awesome Post', '2019-08-07 15:14:26', '1', 0),
       ('2588df34-3058-4faf-a5d2-e8d13aba7e49', 'Joko', 'joko@gmail.com', 'Thank you.', '2019-08-08 03:54:56', '1', 1);