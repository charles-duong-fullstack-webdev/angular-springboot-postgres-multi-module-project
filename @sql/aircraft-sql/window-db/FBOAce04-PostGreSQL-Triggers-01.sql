--FBOACE04_OLTP_TAB Triggers and Trigger Functions

set search_path = 'fboace04_oltp_tab';

CREATE or replace FUNCTION FN_AIRCRAFT_BE4_IXX_ROW()
   RETURNS TRIGGER
   LANGUAGE PLPGSQL
AS $$
BEGIN
  if new.aircraft_type_id is not null and new.aircraft_id is null then
    select coalesce(max(aircraft_id) + 1, 1) into new.aircraft_id
      from AIRCRAFT
     where aircraft_type_id = new.aircraft_type_id;
  end if;
  RETURN NEW;
END;
$$
;

CREATE or replace TRIGGER TRG_AIRCRAFT_BE4_IXX_ROW
  before insert on aircraft
  for each row
       EXECUTE PROCEDURE FN_AIRCRAFT_BE4_IXX_ROW();



CREATE or replace FUNCTION FN_VAIRCRAFT_nst_IUD_row()
   RETURNS TRIGGER
   LANGUAGE PLPGSQL
AS $$
BEGIN
  IF TG_OP = 'INSERT' THEN
    INSERT INTO fboace04_oltp_tab.AIRCRAFT
               (AIRCRAFT_TYPE_ID, AIRCRAFT_ID, SHORT_NAME, LONG_NAME, DESCRIPTION, NOTES)
           VALUES (NEW.AIRCRAFT_TYPE_ID, NEW.AIRCRAFT_ID, NEW.SHORT_NAME, NEW.LONG_NAME, NEW.DESCRIPTION, NEW.NOTES);
    return new;
  ELSIF TG_OP = 'UPDATE' THEN
    UPDATE fboace04_oltp_tab.AIRCRAFT
       SET SHORT_NAME=NEW.SHORT_NAME, LONG_NAME=NEW.LONG_NAME, DESCRIPTION=NEW.DESCRIPTION, NOTES=NEW.NOTES
     WHERE AIRCRAFT_TYPE_ID=OLD.AIRCRAFT_TYPE_ID AND AIRCRAFT_ID=OLD.AIRCRAFT_ID;
    RETURN NEW;
  ELSIF TG_OP = 'DELETE' THEN
    DELETE FROM fboace04_oltp_tab.AIRCRAFT
     WHERE AIRCRAFT_TYPE_ID=OLD.AIRCRAFT_TYPE_ID AND AIRCRAFT_ID=OLD.AIRCRAFT_ID;
    RETURN old;
  END IF;
END;
$$
;

CREATE or replace TRIGGER trg_vaircraft_nts_iud_row
  INSTEAD OF insert OR update or delete on vw_aircraft
  for each row
       EXECUTE PROCEDURE FN_VAIRCRAFT_nst_IUD_row();



CREATE or replace FUNCTION FN_FLIGHT_BE4_IXX_ROW()
   RETURNS TRIGGER
   LANGUAGE PLPGSQL
AS $$
declare
  v_aircraft_type_short_name VARCHAR(8);
  v_aircraft_short_name VARCHAR(8);
  v_airport_iata_code_departure VARCHAR(4) := null;
  v_airport_iata_code_destination VARCHAR(4) := null;
begin
  if ((new.short_name is null) or (length(new.short_name) = 0) or (new.long_name is null) or (length(new.long_name) = 0)) then
  select short_name, AIRCRAFT_TYPE_SHORT_NAME
    into v_aircraft_short_name, v_aircraft_type_short_name
    from fboace04_oltp_tab.vw_aircraft
   where aircraft_type_id = new.aircraft_type_id
     and aircraft_id = new.aircraft_id;
  end if;
  if new.departure_date_time is null then
    new.departure_date_time := to_date(to_char(current_date+2, 'yyyy-mm-dd hh24:mi'), 'yyyy-mm-dd hh24:mi');
  end if;
  if new.arrival_date_time is null then
    new.arrival_date_time := DATE_TRUNC(new.departure_date_time + (3/24), 'mi');
  end if;
  if ((new.short_name is null) or (length(new.short_name) = 0)) then
    new.short_name :=  v_aircraft_short_name || ': ' || to_char(new.departure_date_time, 'yyyy.mm.dd hh24:mi');
  end if;
  if ((new.long_name is null) or (length(new.long_name) = 0)) then
    if new.airport_id_departure is not null then
      select iata_code || ' ' into v_airport_iata_code_departure
        from fboace04_oltp_tab.airport
       where airport_id = new.airport_id_departure;
    end if;
    if new.airport_id_destination is not null then
      select iata_code || ' ' into v_airport_iata_code_destination
        from fboace04_oltp_tab.airport
       where airport_id = new.airport_id_destination;
    end if;
    new.long_name := v_aircraft_type_short_name || ' ' || v_aircraft_short_name || ': ' || v_airport_iata_code_departure
      || v_airport_iata_code_destination || to_char(new.departure_date_time, 'yyyy.mm.dd hh24:mi');
  end if;
  RETURN NEW;
END;
$$
;

CREATE or replace TRIGGER TRG_flight_BE4_IXX_ROW
  before insert on flight
  for each row
       EXECUTE PROCEDURE FN_FLIGHT_BE4_IXX_ROW();


CREATE or replace FUNCTION fn_vflight_nst_iud_row()
   RETURNS TRIGGER
   LANGUAGE PLPGSQL
AS $$
BEGIN
  IF TG_OP = 'INSERT' THEN
    insert into fboace04_oltp_tab.FLIGHT (flight_id, aircraft_type_id, aircraft_id, SHORT_NAME, LONG_NAME, DEPARTURE_DATE_TIME, ARRIVAL_DATE_TIME, NOTES, AIRPORT_ID_DEPARTURE, AIRPORT_ID_DESTINATION)
                values (NEW.flight_id, NEW.aircraft_type_id, NEW.aircraft_id, NEW.SHORT_NAME, NEW.LONG_NAME, NEW.DEPARTURE_DATE_TIME, NEW.ARRIVAL_DATE_TIME, NEW.NOTES, NEW.AIRPORT_ID_DEPARTURE, NEW.AIRPORT_ID_DESTINATION);
    RETURN NEW;
  END IF;
  IF TG_OP = 'UPDATE' THEN
    UPDATE fboace04_oltp_tab.FLIGHT
       SET SHORT_NAME=NEW.SHORT_NAME, LONG_NAME=NEW.LONG_NAME, DEPARTURE_DATE_TIME=NEW.DEPARTURE_DATE_TIME, ARRIVAL_DATE_TIME=NEW.ARRIVAL_DATE_TIME, NOTES=NEW.NOTES, AIRPORT_ID_DEPARTURE=NEW.AIRPORT_ID_DEPARTURE, AIRPORT_ID_DESTINATION=NEW.AIRPORT_ID_DESTINATION
     WHERE FLIGHT_ID = OLD.FLIGHT_ID;
    RETURN NEW;
  ELSIF TG_OP = 'DELETE' THEN
    DELETE FROM fboace04_oltp_tab.FLIGHT WHERE FLIGHT_ID = OLD.FLIGHT_ID;
    RETURN old;
  END IF;
END;
$$
;

CREATE OR REPLACE TRIGGER TRG_VFLIGHT_nst_IUD_ROW
  INSTEAD OF INSERT OR UPDATE OR DELETE on vw_flight
  for each row
       EXECUTE PROCEDURE fn_vflight_nst_iud_row();




CREATE or replace FUNCTION FN_vflightcrewmember_NST_IUD_ROW()
   RETURNS TRIGGER
   LANGUAGE PLPGSQL
AS $$
BEGIN
  IF TG_OP = 'INSERT' THEN
    INSERT INTO fboace04_oltp_tab.FLIGHT_CREW_MEMBER (FLIGHT_ID, AIRCRAFT_TYPE_ID, PILOT_ID, NOTES)
           VALUES (NEW.FLIGHT_ID, NEW.AIRCRAFT_TYPE_ID, NEW.PILOT_ID, NEW.NOTES);
    RETURN NEW;
  ELSIF TG_OP = 'UPDATE' THEN
    UPDATE fboace04_oltp_tab.FLIGHT_CREW_MEMBER
       SET NOTES=NEW.NOTES
     WHERE FLIGHT_ID = OLD.FLIGHT_ID AND PILOT_ID=OLD.PILOT_ID;
    RETURN NEW;
  ELSIF TG_OP = 'DELETE' THEN
    DELETE FROM fboace04_oltp_tab.FLIGHT_CREW_MEMBER
     WHERE FLIGHT_ID = OLD.FLIGHT_ID AND PILOT_ID=OLD.PILOT_ID;
    RETURN old;
    END IF;
  END;
$$
;

CREATE or replace TRIGGER TRG_Vflightcrewmember_NST_IUD_ROW
  INSTEAD OF INSERT OR UPDATE OR DELETE on vw_flight_crew_member
  for each row
       EXECUTE PROCEDURE FN_vflightcrewmember_NST_IUD_ROW();




CREATE or replace FUNCTION FN_vpilotcertification_nst_iud_row()
   RETURNS TRIGGER
   LANGUAGE PLPGSQL
AS $$
declare
  v_certification_number varchar(20) := new.certification_number;
BEGIN
  IF TG_OP = 'INSERT' THEN
	  if v_certification_number is null or length(v_certification_number)=0 then
		SELECT upper(substring(MD5(random()::text),1,16))
		  into v_certification_number;
	  end if;
	  if new.valid_from_date is null and new.EXpiration_date is null then
		new.valid_from_date := current_date - 364;
		new.EXpiration_date := current_date + 364;
	  end if;
	  INSERT INTO fboace04_oltp_tab.pilot_certification
				  (PILOT_ID, AIRCRAFT_TYPE_ID, CERTIFICATION_NUMBER, VALID_FROM_DATE, EXPIRATION_DATE, NOTES)
			 VALUES(NEW.PILOT_ID, NEW.AIRCRAFT_TYPE_ID, v_certification_number, NEW.VALID_FROM_DATE, NEW.EXPIRATION_DATE, NEW.NOTES);
    RETURN NEW;
  end if;
  IF TG_OP = 'UPDATE' THEN
    UPDATE fboace04_oltp_tab.pilot_certification
	   SET CERTIFICATION_NUMBER=NEW.CERTIFICATION_NUMBER, VALID_FROM_DATE=NEW.VALID_FROM_DATE, EXPIRATION_DATE=NEW.EXPIRATION_DATE, NOTES=NEW.NOTES
	 WHERE pilot_id=new.pilot_id and aircraft_type_id=new.aircraft_type_id; 
    RETURN NEW;
  end if;
  IF TG_OP = 'DELETE' THEN
    DELETE from fboace04_oltp_tab.pilot_certification
	 WHERE pilot_id=old.pilot_id and aircraft_type_id=old.aircraft_type_id; 
    RETURN old;
  end if;
END;
$$
;

CREATE or replace trigger trg_vpilotcertification_nst_iud_row
INSTEAD OF insert or update or delete on VW_pilot_certification
for each row
       EXECUTE PROCEDURE FN_vpilotcertification_nst_iud_row();




