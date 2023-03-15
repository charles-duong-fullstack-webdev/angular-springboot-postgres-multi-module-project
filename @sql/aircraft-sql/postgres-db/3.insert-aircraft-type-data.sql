-- drop table if exists AIRCRAFT_TYPE;
--
-- CREATE TABLE AIRCRAFT_TYPE
-- (    AIRCRAFT_TYPE_ID integer NOT NULL,
--      SHORT_NAME       VARCHAR(8) NOT NULL,
--      LONG_NAME        VARCHAR(50) NOT NULL,
--      DESCRIPTION      VARCHAR(4000),
--      NOTES            VARCHAR(4000)
-- );

--CREATE UNIQUE INDEX AIRCRTYP_PX ON AIRCRAFT_TYPE (AIRCRAFT_TYPE_ID);
--ALTER TABLE AIRCRAFT_TYPE ADD CONSTRAINT AIRCRTYP_PK PRIMARY KEY (AIRCRAFT_TYPE_ID);

drop sequence if exists AIRCRTYP_PK_SEQ;
create sequence AIRCRTYP_PK_SEQ start with 1;

CREATE UNIQUE INDEX AIRCRTYP_UX ON AIRCRAFT_TYPE (SHORT_NAME);
ALTER TABLE AIRCRAFT_TYPE ADD CONSTRAINT AIRCRTYP_UK UNIQUE (SHORT_NAME);

Insert into AIRCRAFT_TYPE (AIRCRAFT_TYPE_ID,SHORT_NAME,LONG_NAME,DESCRIPTION,NOTES) values (NEXTVAL('AIRCRTYP_PK_SEQ'), 'MESA','Multi-Engine Sea Airplane',null,'');
Insert into AIRCRAFT_TYPE (AIRCRAFT_TYPE_ID,SHORT_NAME,LONG_NAME,DESCRIPTION,NOTES) values (NEXTVAL('AIRCRTYP_PK_SEQ'),'SELA','Single-Engine Land Airplane',null,'');
Insert into AIRCRAFT_TYPE (AIRCRAFT_TYPE_ID,SHORT_NAME,LONG_NAME,DESCRIPTION,NOTES) values (NEXTVAL('AIRCRTYP_PK_SEQ'),'MELA','Multi-Engine Land Airplane',null,'');
Insert into AIRCRAFT_TYPE (AIRCRAFT_TYPE_ID,SHORT_NAME,LONG_NAME,DESCRIPTION,NOTES) values (NEXTVAL('AIRCRTYP_PK_SEQ'),'SJET','Small Jet Airplane',null,'');
Insert into AIRCRAFT_TYPE (AIRCRAFT_TYPE_ID,SHORT_NAME,LONG_NAME,DESCRIPTION,NOTES) values (NEXTVAL('AIRCRTYP_PK_SEQ'),'CJET','Commercial Jet Airplane','Impossible to describe.','No notes to note, he noted in his notebook');
Insert into AIRCRAFT_TYPE (AIRCRAFT_TYPE_ID,SHORT_NAME,LONG_NAME,DESCRIPTION,NOTES) values (NEXTVAL('AIRCRTYP_PK_SEQ'),'SESH','Single-Engine Sea Helicopter',null,null);
Insert into AIRCRAFT_TYPE (AIRCRAFT_TYPE_ID,SHORT_NAME,LONG_NAME,DESCRIPTION,NOTES) values (NEXTVAL('AIRCRTYP_PK_SEQ'),'LBJ','Large Business Jet',null,'N684KQ');
Insert into AIRCRAFT_TYPE (AIRCRAFT_TYPE_ID,SHORT_NAME,LONG_NAME,DESCRIPTION,NOTES) values (NEXTVAL('AIRCRTYP_PK_SEQ'),'HPSELA','High-Performance ...','An airplane with an engine > 200 horsepower.', 'Notes Notes Notes');
