--
-- ER/Studio Data Architect SQL Code Generation
-- Project :      FBOAce04-01.DM1
--
-- Date Created : Friday, May 27, 2022 18:05:20
-- Target DBMS : PostgreSQL 10.x-12.x
--

-- 
-- TABLE: aircraft 
--
drop table if exists aircraft;
CREATE TABLE aircraft(
                         aircraft_type_id    integer          NOT NULL,
                         aircraft_id         integer          NOT NULL,
                         short_name          varchar(8)       NOT NULL,
                         long_name           varchar(40)      NOT NULL,
                         description         varchar(2000),
                         notes               varchar(2000)
);



-- 
-- TABLE: aircraft_type 
--
drop table if exists aircraft_type;
CREATE TABLE aircraft_type(
                              aircraft_type_id    integer          NOT NULL,
                              short_name          varchar(8)       NOT NULL,
                              long_name           varchar(40)      NOT NULL,
                              description         varchar(2000),
                              notes               varchar(2000)
)
;



-- 
-- TABLE: airport 
--

CREATE TABLE airport(
                        airport_id        integer           NOT NULL,
                        iata_code         character(3)      NOT NULL,
                        short_name        varchar(30),
                        port_type         varchar(20)
                            CHECK (port_type in ( 'Heliport', 'Small Airport', 'Closed', 'Seaplane Base', 'Balloonport', 'Medium Airport', 'Large Airport')),
                        elevation_feet    numeric(5, 0),
                        lattitude         numeric(12, 6),
                        longitude         numeric(12, 6),
                        description       varchar(2000)
)
;



-- 
-- TABLE: flight 
--

CREATE TABLE flight(
                       flight_id                 integer                      NOT NULL,
                       short_name                varchar(48)                  NOT NULL,
                       long_name                 varchar(49)                  NOT NULL,
                       departure_date_time       timestamp,
                       arrival_date_time         timestamp,
                       notes                     varchar(2000),
                       aircraft_type_id          integer                      NOT NULL,
                       aircraft_id               integer                      NOT NULL,
                       airport_id_destination    integer,
                       airport_id_departure      integer
)
;



-- 
-- TABLE: flight_crew_member 
--

CREATE TABLE flight_crew_member(
                                   flight_id           integer          NOT NULL,
                                   aircraft_type_id    integer          NOT NULL,
                                   pilot_id            integer          NOT NULL,
                                   notes               varchar(2000)
)
;



-- 
-- TABLE: pilot 
--

CREATE TABLE pilot(
                      pilot_id              integer          NOT NULL,
                      last_name             varchar(20)      NOT NULL,
                      first_name            varchar(20)      NOT NULL,
                      middle_initial        character(1),
                      birthdate             date,
                      national_id_number    varchar(20),
                      notes                 varchar(2000)
)
;



-- 
-- TABLE: pilot_certification 
--

CREATE TABLE pilot_certification(
                                    aircraft_type_id        integer          NOT NULL,
                                    pilot_id                integer          NOT NULL,
                                    certification_number    varchar(20)      NOT NULL,
                                    valid_from_date         date,
                                    expiration_date         date,
                                    notes                   varchar(2000)
)
;



-- 
-- INDEX: aircraft_short_name_uk 
--

CREATE UNIQUE INDEX aircraft_short_name_uk ON aircraft(short_name)
;
-- 
-- INDEX: aircraft_aircraft_type_fk 
--

CREATE INDEX aircraft_aircraft_type_fk ON aircraft(aircraft_type_id)
;
-- 
-- INDEX: aircraft_type_short_name_uk 
--

CREATE UNIQUE INDEX aircraft_type_short_name_uk ON aircraft_type(short_name)
;
-- 
-- INDEX: airport_short_name_uk 
--

CREATE UNIQUE INDEX airport_short_name_uk ON airport(short_name)
;
-- 
-- INDEX: airport_iata_code_uk 
--

CREATE UNIQUE INDEX airport_iata_code_uk ON airport(iata_code)
;
-- 
-- INDEX: flight_short_name_uk 
--

CREATE UNIQUE INDEX flight_short_name_uk ON flight(short_name)
;
-- 
-- INDEX: flight_super_uk 
--

CREATE UNIQUE INDEX flight_super_uk ON flight(flight_id, aircraft_type_id)
;
-- 
-- INDEX: aircraft_aircraft_type_fk 
--

CREATE INDEX flight_aircraft_type_fk ON flight(aircraft_id, aircraft_type_id)
;
-- 
-- INDEX: flight_airport_destination_fk 
--

CREATE INDEX flight_airport_destination_fk ON flight(airport_id_destination)
;
-- 
-- INDEX: flight_airport_departure_fk 
--

CREATE INDEX flight_airport_departure_fk ON flight(airport_id_departure)
;
-- 
-- INDEX: flight_crew_member_flight_fk 
--

CREATE INDEX flight_crew_member_flight_fk ON flight_crew_member(aircraft_type_id, flight_id)
;
-- 
-- INDEX: flight_crew_member_pilot_certification_fk 
--

CREATE INDEX flight_crew_member_pilot_certification_fk ON flight_crew_member(aircraft_type_id, pilot_id)
;
-- 
-- INDEX: pilot_national_id_number_uk 
--

CREATE UNIQUE INDEX pilot_national_id_number_uk ON pilot(national_id_number)
;
-- 
-- INDEX: pilot_certification_number_uk 
--

CREATE UNIQUE INDEX pilot_certification_number_uk ON pilot_certification(certification_number)
;
-- 
-- INDEX: pilot_certification_aircraft_type_fk 
--

CREATE INDEX pilot_certification_aircraft_type_fk ON pilot_certification(aircraft_type_id)
;
-- 
-- INDEX: pilot_certification_pilot_fk 
--

CREATE INDEX pilot_certification_pilot_fk ON pilot_certification(pilot_id)
;
-- 
-- TABLE: aircraft 
--

ALTER TABLE aircraft ADD
    CONSTRAINT aircraft_pk PRIMARY KEY (aircraft_type_id, aircraft_id)
;

-- 
-- TABLE: aircraft_type 
--

ALTER TABLE aircraft_type ADD
    CONSTRAINT aircrafttype_pk PRIMARY KEY (aircraft_type_id)
;

-- 
-- TABLE: airport 
--

ALTER TABLE airport ADD
    CONSTRAINT airport_pk PRIMARY KEY (airport_id)
;

-- 
-- TABLE: flight 
--

ALTER TABLE flight ADD
    CONSTRAINT flight_pk PRIMARY KEY (flight_id)
;

-- 
-- TABLE: flight_crew_member 
--

ALTER TABLE flight_crew_member ADD
    CONSTRAINT flight_crew_member_pk PRIMARY KEY (flight_id, aircraft_type_id, pilot_id)
;

-- 
-- TABLE: pilot 
--

ALTER TABLE pilot ADD
    CONSTRAINT pilot_pk PRIMARY KEY (pilot_id)
;

-- 
-- TABLE: pilot_certification 
--

ALTER TABLE pilot_certification ADD
    CONSTRAINT pilot_certification_pk PRIMARY KEY (aircraft_type_id, pilot_id)
;

-- 
-- TABLE: aircraft 
--

ALTER TABLE aircraft ADD CONSTRAINT aircraft_aircraft_type_fk
    FOREIGN KEY (aircraft_type_id)
        REFERENCES aircraft_type(aircraft_type_id)
;


-- 
-- TABLE: flight 
--

ALTER TABLE flight ADD CONSTRAINT flight_aircraft_fk
    FOREIGN KEY (aircraft_type_id, aircraft_id)
        REFERENCES aircraft(aircraft_type_id, aircraft_id)
;

ALTER TABLE flight ADD CONSTRAINT flight_airport_departure_fk
    FOREIGN KEY (airport_id_departure)
        REFERENCES airport(airport_id)
;

ALTER TABLE flight ADD CONSTRAINT flight_airport_destination_fk
    FOREIGN KEY (airport_id_destination)
        REFERENCES airport(airport_id)
;


-- 
-- TABLE: flight_crew_member 
--

ALTER TABLE flight_crew_member ADD CONSTRAINT flight_crew_member_flight_fk
    FOREIGN KEY (flight_id, aircraft_type_id)
        REFERENCES flight(flight_id, aircraft_type_id)
;

ALTER TABLE flight_crew_member ADD CONSTRAINT flight_crew_member_pilot_certification_fk
    FOREIGN KEY (aircraft_type_id, pilot_id)
        REFERENCES pilot_certification(aircraft_type_id, pilot_id)
;


-- 
-- TABLE: pilot_certification 
--

ALTER TABLE pilot_certification ADD CONSTRAINT pilot_certification_aircraft_type_fk
    FOREIGN KEY (aircraft_type_id)
        REFERENCES aircraft_type(aircraft_type_id)
;

ALTER TABLE pilot_certification ADD CONSTRAINT pilot_certification_pilot_fk
    FOREIGN KEY (pilot_id)
        REFERENCES pilot(pilot_id)
;


