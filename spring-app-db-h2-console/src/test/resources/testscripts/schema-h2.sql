DROP TABLE IF EXISTS exercise;
DROP TABLE IF EXISTS person_exercise;
DROP sequence IF EXISTS person_exercise_sequence;
DROP sequence IF EXISTS exercise_sequence;
create sequence person_exercise_sequence start with 1;
create sequence exercise_sequence start with 1;

CREATE TABLE person_exercise
(
    id         BIGINT NOT NULL,
    first_name VARCHAR(255),
    last_name  VARCHAR(255),
    email      VARCHAR(255),
    dob        TIMESTAMP,
    address    VARCHAR(255),
    country    VARCHAR(255),
    gender     VARCHAR(255),
    CONSTRAINT pk_personexercise PRIMARY KEY (id)
);

CREATE TABLE exercise
(
    id                 BIGINT NOT NULL,
    name               VARCHAR(255),
    duration           BIGINT,
    calories           BIGINT,
    trainingdate       DATE,
    state              VARCHAR(50),
    person_exercise_id BIGINT,
    CONSTRAINT pk_exercise PRIMARY KEY (id)
);

ALTER TABLE exercise
    ADD CONSTRAINT FK_EXERCISE_ON_PERSONEXERCISE FOREIGN KEY (person_exercise_id) REFERENCES person_exercise (id) ON DELETE CASCADE;
