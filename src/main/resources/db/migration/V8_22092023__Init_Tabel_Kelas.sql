CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS tbl_kelas
(
    id          UUID           DEFAULT uuid_generate_v4() NOT NULL,
    nama        varchar(25),
    created_by  varchar(50),
    created_on  timestamp NULL DEFAULT CURRENT_TIMESTAMP,
    modified_by varchar(50),
    modified_on timestamp NULL DEFAULT CURRENT_TIMESTAMP,
    status_record varchar(50) DEFAULT 'ACTIVE' NOT NULL,
    version BIGINT DEFAULT 0,
    PRIMARY KEY (id)
);
--
-- Dumping data untuk tabel tbl_kelas
--

INSERT INTO tbl_kelas (id, nama)
VALUES ('d0a2c73c-f916-4019-8588-db8b1c43d237', 'Kelas X.1'),
       ('a0a2c73c-f916-4019-8588-db8b1c43d232', 'Kelas X.2'),
       ('a0a2c73c-f916-4019-8588-db8b1c43d233', 'Kelas X.3'),
       ('a0a2c73c-f916-4019-8588-db8b1c43d234', 'Kelas X.4'),
       ('a0a2c73c-f916-4019-8588-db8b1c43d235', 'Kelas X.5'),
       ('a0a2c73c-f916-4019-8588-db8b1c43d236', 'Kelas X.6'),
       ('a0a2c73c-f916-4019-8588-db8b1c43d237', 'Kelas X.7'),
       ('a0a2c73c-f916-4019-8588-db8b1c43d238', 'Kelas XI IPA.1'),
       ('a0a2c73c-f916-4019-8588-db8b1c43d239', 'Kelas XI IPA.2'),
       ('a0a2c73c-f916-4019-8588-db8b1c43d210', 'Kelas XI IPA.3'),
       ('a0a2c73c-f916-4019-8588-db8b1c43d211', 'Kelas XI IPA.4'),
       ('a0a2c73c-f916-4019-8588-db8b1c43d212', 'Kelas XI IPA.5'),
       ('a0a2c73c-f916-4019-8588-db8b1c43d213', 'Kelas XI IPA.6'),
       ('a0a2c73c-f916-4019-8588-db8b1c43d214', 'Kelas XI IPA.7'),
       ('a0a2c73c-f916-4019-8588-db8b1c43d215', 'Kelas XI IPS.1'),
       ('a0a2c73c-f916-4019-8588-db8b1c43d216', 'Kelas XI IPS.2'),
       ('a0a2c73c-f916-4019-8588-db8b1c43d217', 'Kelas XI IPS.3'),
       ('a0a2c73c-f916-4019-8588-db8b1c43d218', 'Kelas XI IPS.4'),
       ('a0a2c73c-f916-4019-8588-db8b1c43d219', 'Kelas XI IPS.5'),
       ('a0a2c73c-f916-4019-8588-db8b1c43d220', 'Kelas XI IPS.6'),
       ('a0a2c73c-f916-4019-8588-db8b1c43d221', 'Kelas XI IPS.7');