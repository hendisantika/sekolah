CREATE TABLE IF NOT EXISTS tbl_pengguna
(
    pengguna_id          UUID           DEFAULT uuid_generate_v4() NOT NULL,
    pengguna_nama        varchar(50)    DEFAULT NULL,
    pengguna_moto        varchar(100)   DEFAULT NULL,
    pengguna_jenkel      varchar(2)     DEFAULT NULL,
    pengguna_username    varchar(30)    DEFAULT NULL,
    pengguna_password    varchar(35)    DEFAULT NULL,
    pengguna_tentang     text,
    pengguna_email       varchar(50)    DEFAULT NULL,
    pengguna_nohp        varchar(20)    DEFAULT NULL,
    pengguna_facebook    varchar(35)    DEFAULT NULL,
    pengguna_twitter     varchar(35)    DEFAULT NULL,
    pengguna_linkdin     varchar(35)    DEFAULT NULL,
    pengguna_google_plus varchar(35)    DEFAULT NULL,
    pengguna_status      int            DEFAULT '1',
    pengguna_level       varchar(3)     DEFAULT NULL,
    pengguna_register    timestamp NULL DEFAULT CURRENT_TIMESTAMP,
    pengguna_photo       varchar(40)    DEFAULT NULL,
    PRIMARY KEY (pengguna_id)
);

--
-- Dumping data untuk tabel tbl_pengguna
--

INSERT INTO tbl_pengguna (pengguna_nama, pengguna_moto, pengguna_jenkel, pengguna_username, pengguna_password,
                          pengguna_tentang, pengguna_email, pengguna_nohp, pengguna_facebook, pengguna_twitter,
                          pengguna_linkdin, pengguna_google_plus, pengguna_status, pengguna_level, pengguna_register,
                          pengguna_photo)
VALUES ('Hendi Santika', 'Just do it', 'L', 'admin', 'e10adc3949ba59abbe56e057f20f883e',
        'I am a mountainner. to me mountainerring is a life', 'fikrifiver97@gmail.com', '081277159401',
        'facebook.com/m_fikri_setiadi', 'twitter.com/fiver_fiver', '', '', 1, '1', '2016-09-03 06:07:55',
        'db5dec647062751f2fb236b9bc3f1c54.png');

-- --------------------------------------------------------
