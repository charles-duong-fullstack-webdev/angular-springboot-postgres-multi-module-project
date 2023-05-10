create table calendar
(
    id                 decimal(10, 0)                    not null,
    title              varchar(128)                      not null,
    description        varchar(3000)                     not null,
    location           varchar(128),
    start_date         timestamp(6)                      not null,
    end_date           timestamp(6),
    ISS                boolean DEFAULT false           NOT NULL,
    IRC                boolean DEFAULT false           NOT NULL,
    WMC                boolean DEFAULT false            NOT NULL,
    RDC                boolean DEFAULT false            NOT NULL,
    LZDAS              boolean DEFAULT false            NOT NULL,
    eingabe_user       varchar(50)                       not null,
    eingabe_timestamp  timestamp(6) default current_date not null,
    mutation_user      varchar(50)                       not null,
    mutation_timestamp timestamp(6) default current_date not null,
    version            integer                           not null,
    constraint calendar_pk primary key (id)
);

create sequence calendar_seq start with 1001;


create table message
(
    id                 decimal(10, 0)                    not null,
    title              varchar(128)                      not null,
    text               CLOB                              not null,
    start_date         timestamp(6)                      not null,
    end_date           timestamp(6)                      not null,
    eingabe_user       varchar(50)                       not null,
    eingabe_timestamp  timestamp(6) default current_date not null,
    mutation_user      varchar(50)                       not null,
    mutation_timestamp timestamp(6) default current_date not null,
    version            integer                           not null,
    constraint message_pk primary key (id)
);

create sequence message_seq start with 1001;


create table feed
(
    id                 decimal(10, 0) not null,
    external_id        varchar(50)    not null,
    title              varchar(1000)  not null,
    type               varchar(25),
    description        varchar(4000),
    category           varchar(120),
    priority           varchar(20),
    status             varchar(20),
    resolution         varchar(4000),
    assigned_group     varchar(20),
    submit_timestamp   timestamp,
    close_timestamp    timestamp,
    company            varchar(50),
    organization       varchar(50),
    source             varchar(20)    not null,
    eingabe_timestamp  timestamp      not null,
    eingabe_user       varchar(50)    not null,
    mutation_timestamp timestamp      not null,
    mutation_user      varchar(50)    not null,
    version            integer        not null,
    constraint feed_pk primary key (id),
    constraint feed_external_id_unique unique (external_id, source)
);

create sequence feed_seq start with 1001;


create table feed_notification
(
    id                 decimal(10, 0) not null,
    external_id        varchar(50)    not null,
    portal_id          varchar(30)    not null,
    source             varchar(20)    not null,
    email              varchar(200)   not null,
    eingabe_timestamp  timestamp      not null,
    eingabe_user       varchar(50)    not null,
    mutation_timestamp timestamp      not null,
    mutation_user      varchar(50)    not null,
    version            integer        not null,
    constraint feed_notification_pk primary key (id),
    constraint feed_notification_unique unique (external_id, portal_id, source)
);

create sequence feed_notification_seq start with 1001;


create table liid_group
(
    id                 decimal(10, 0)       not null,
    description_de     varchar(50) not null,
    description_it     varchar(50) not null,
    description_fr     varchar(50) not null,
    description_en     varchar(50) not null,
    no_tab             decimal(10, 0) not null ,
    eingabe_user       varchar(50) not null,
    eingabe_timestamp  timestamp   not null,
    mutation_user      varchar(50) not null,
    mutation_timestamp timestamp   not null,
    version            integer     not null,
    constraint liid_group_pk primary key (id)
);

create sequence liid_group_seq start with 1001;


create table liid_group_iss_monitor_rel
(
    id                 decimal(10, 0)      not null,
    group_id           decimal(10, 0)      not null,
    monitor_id         decimal(10, 0)      not null,
    liid               varchar(25) not null,
    description        varchar(4000),
    provider_id         varchar(5) not null,
    product_type        decimal(10, 0)       not null,
    eingabe_user       varchar(50)         not null,
    eingabe_timestamp  timestamp           not null,
    mutation_user      varchar(50)    not null,
    mutation_timestamp timestamp           not null,
    version            integer             not null,
    constraint liid_group_iss_monitor_rel_pk primary key (id)
);

create sequence liid_group_iss_monitor_rel_seq start with 1001;