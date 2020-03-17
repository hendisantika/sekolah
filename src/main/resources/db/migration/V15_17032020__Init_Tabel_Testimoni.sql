CREATE TABLE IF NOT EXISTS tbl_testimoni
(
    testimoni_id      UUID           DEFAULT uuid_generate_v4() NOT NULL,
    testimoni_nama    varchar(30)    DEFAULT NULL,
    testimoni_isi     varchar(120)   DEFAULT NULL,
    testimoni_email   varchar(35)    DEFAULT NULL,
    testimoni_tanggal timestamp NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (testimoni_id)
);

-- --------------------------------------------------------
