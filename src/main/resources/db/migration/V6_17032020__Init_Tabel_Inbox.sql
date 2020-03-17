CREATE TABLE IF NOT EXISTS tbl_inbox
(
    inbox_id      UUID           DEFAULT uuid_generate_v4() NOT NULL,
    inbox_nama    varchar(40)    DEFAULT NULL,
    inbox_email   varchar(60)    DEFAULT NULL,
    inbox_kontak  varchar(20)    DEFAULT NULL,
    inbox_pesan   text,
    inbox_tanggal timestamp NULL DEFAULT CURRENT_TIMESTAMP,
    inbox_status  INT            DEFAULT '1',
    PRIMARY KEY (inbox_id)
);

COMMENT ON COLUMN tbl_inbox.inbox_status IS '1=Belum dilihat, 0=Telah dilihat';
--
-- Dumping data untuk tabel tbl_inbox
--

INSERT INTO tbl_inbox (inbox_nama, inbox_email, inbox_kontak, inbox_pesan, inbox_tanggal, inbox_status)
VALUES ('Hendi Santika', 'fikrifiver97@gmail.com', '-', 'Ping !', '2017-06-21 03:44:12', 0),
       ('Hendi Santika', 'fikrifiver97@gmail.com', '-', 'Ini adalah pesan ', '2017-06-21 03:45:57', 0),
       ('Hendi Santika', 'fikrifiver97@gmail.com', '-', 'Ping !', '2017-06-21 03:53:19', 0),
       ('Hendi Santika', 'fikrifiver97@gmail.com', '-', 'Hi, there!', '2017-07-01 07:28:08', 0),
       ('M Fikri', 'fikrifiver97@gmail.com', '084375684364', 'Hi There, Would you please help me about register?',
        '2018-08-06 13:51:07', 0);

-- --------------------------------------------------------
