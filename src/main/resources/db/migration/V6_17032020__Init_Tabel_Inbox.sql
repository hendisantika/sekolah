CREATE TABLE IF NOT EXISTS tbl_inbox
(
    id          UUID           DEFAULT uuid_generate_v4() NOT NULL,
    nama        varchar(40)    DEFAULT NULL,
    email       varchar(60)    DEFAULT NULL,
    kontak      varchar(20)    DEFAULT NULL,
    pesan       text,
    status      INT            DEFAULT '1',
    created_by  varchar(50),
    created_on  timestamp NULL DEFAULT CURRENT_TIMESTAMP,
    modified_by varchar(50),
    modified_on timestamp NULL DEFAULT CURRENT_TIMESTAMP,
    status_record CHARACTER VARYING(150) NOT NULL,
    version BIGINT,
    PRIMARY KEY (id)
);

COMMENT ON COLUMN tbl_inbox.status IS '1=Belum dilihat, 0=Telah dilihat';
--
-- Dumping data untuk tabel tbl_inbox
--

INSERT INTO tbl_inbox (nama, email, kontak, pesan, created_on, status, status_record)
VALUES ('Hendi Santika', 'naruto@gmail.com', '-', 'Ping !', '2019-06-21 03:44:12', 0, 'ACTIVE'),
       ('Hendi Santika', 'naruto@gmail.com', '-', 'Ini adalah pesan ', '2019-06-21 03:45:57', 0, 'ACTIVE'),
       ('Hendi Santika', 'naruto@gmail.com', '-', 'Ping !', '2019-06-21 03:53:19', 0, 'ACTIVE'),
       ('Hendi Santika', 'naruto@gmail.com', '-', 'Hi, there!', '2019-07-01 07:28:08', 0, 'ACTIVE'),
       ('Uzumaki Naruto', 'naruto@gmail.com', '084375684364', 'Hi There, Would you please help me about register?',
        '2018-08-06 13:51:07', 0, 'ACTIVE');

-- --------------------------------------------------------
