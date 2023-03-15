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

CREATE TABLE aircraft(
                         aircraft_type_id    integer          NOT NULL,
                         aircraft_id         integer          NOT NULL,
                         short_name          varchar(8)       NOT NULL,
                         long_name           varchar(40)      NOT NULL,
                         description         varchar(2000),
                         notes               varchar(2000)
);



CREATE INDEX aircraft_aircraft_type_fk ON aircraft(aircraft_type_id)
;
-- 
-- INDEX: aircraft_type_short_name_uk 
--

CREATE UNIQUE INDEX aircraft_type_short_name_uk ON aircraft_type(short_name)
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


