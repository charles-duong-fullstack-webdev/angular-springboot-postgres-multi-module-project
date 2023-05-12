DROP TABLE IF EXISTS login;
DROP sequence IF EXISTS login_sequence;
create sequence login_sequence start with 1;

CREATE TABLE login
(
    id            BIGINT NOT NULL,
    created_by    VARCHAR(255),
    modified_by   VARCHAR(255),
    birthday      DATE,
    created_date  TIMESTAMP,
    modified_date TIMESTAMP,
    userid        VARCHAR(255),
    password      VARCHAR(255),
    CONSTRAINT pk_login PRIMARY KEY (id)
);

