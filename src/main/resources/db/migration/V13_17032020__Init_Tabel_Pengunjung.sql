CREATE TABLE IF NOT EXISTS tbl_pengunjung
(
    pengunjung_id              UUID             DEFAULT uuid_generate_v4() NOT NULL,
    session_id                 varchar(50) NOT NULL,
    cookie_name                varchar(50) NOT NULL,
    url                        varchar(50) NOT NULL,
    pengunjung_ip              varchar(40)      DEFAULT NULL,
    pengunjung_os_type         varchar(50),
    pengunjung_os_version      varchar(50),
    pengunjung_browser_name    varchar(50),
    pengunjung_browser_type    varchar(50),
    pengunjung_browser_version varchar(50),
    pengunjung_device_type     varchar(50),
    pengunjung_host_address    varchar(50),
    pengunjung_host_name       varchar(50),
    pengunjung_tanggal         timestamp   NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (pengunjung_id)
);
