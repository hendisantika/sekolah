CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS tbl_log_aktivitas
(
    id          UUID           DEFAULT uuid_generate_v4() NOT NULL,
    nama        text,
    tanggal     timestamp NULL DEFAULT CURRENT_TIMESTAMP,
    ip          varchar(20)    DEFAULT NULL,
    pengguna_id UUID           DEFAULT NULL,
    icon        bytea,
    jenis_icon  varchar(50)    DEFAULT NULL,
    created_by  varchar(50),
    created_on  timestamp NULL DEFAULT CURRENT_TIMESTAMP,
    modified_by varchar(50),
    modified_on timestamp NULL DEFAULT CURRENT_TIMESTAMP,
    status_record varchar(50) DEFAULT 'ACTIVE' NOT NULL,
    version BIGINT DEFAULT 0,
    PRIMARY KEY (id)
);
CREATE INDEX log_pengguna_idx ON tbl_log_aktivitas (pengguna_id);
-- --------------------------------------------------------