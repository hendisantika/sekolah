CREATE TABLE IF NOT EXISTS tbl_log_aktivitas
(
    log_id          UUID           DEFAULT uuid_generate_v4() NOT NULL,
    log_nama        text,
    log_tanggal     timestamp NULL DEFAULT CURRENT_TIMESTAMP,
    log_ip          varchar(20)    DEFAULT NULL,
    log_pengguna_id int            DEFAULT NULL,
    log_icon        bytea,
    log_jenis_icon  varchar(50)    DEFAULT NULL,
    PRIMARY KEY (log_id)
);
CREATE INDEX log_pengguna_idx ON tbl_log_aktivitas (log_pengguna_id);
-- --------------------------------------------------------