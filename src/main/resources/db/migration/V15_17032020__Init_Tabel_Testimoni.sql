CREATE TABLE IF NOT EXISTS tbl_testimoni
(
    id          UUID           DEFAULT uuid_generate_v4() NOT NULL,
    nama        varchar(30)    DEFAULT NULL,
    isi         varchar(120)   DEFAULT NULL,
    email       varchar(35)    DEFAULT NULL,
    created_by  varchar(50),
    created_on  timestamp NULL DEFAULT CURRENT_TIMESTAMP,
    modified_by varchar(50),
    modified_on timestamp NULL DEFAULT CURRENT_TIMESTAMP,
    status_record CHARACTER VARYING(150) NOT NULL,
    version BIGINT,
    PRIMARY KEY (id)
);

-- --------------------------------------------------------
