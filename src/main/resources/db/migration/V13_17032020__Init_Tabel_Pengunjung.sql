CREATE TABLE IF NOT EXISTS tbl_pengunjung
(
    id              UUID              DEFAULT uuid_generate_v4() NOT NULL,
    session_id      varchar(50)  NOT NULL,
    cookie_name     varchar(50)  NOT NULL,
    url             varchar(150) NOT NULL,
    ip              varchar(40)       DEFAULT NULL,
    os_type         varchar(50),
    os_version      varchar(50),
    browser_name    varchar(50),
    browser_type    varchar(50),
    browser_version varchar(50),
    device_type     varchar(50),
    host_address    varchar(50),
    host_name       varchar(50),
    created_by  varchar(50),
    created_on  timestamp NULL DEFAULT CURRENT_TIMESTAMP,
    modified_by varchar(50),
    modified_on timestamp NULL DEFAULT CURRENT_TIMESTAMP,
    status_record CHARACTER VARYING(150) NOT NULL,
    version BIGINT,
    PRIMARY KEY (id)
);
