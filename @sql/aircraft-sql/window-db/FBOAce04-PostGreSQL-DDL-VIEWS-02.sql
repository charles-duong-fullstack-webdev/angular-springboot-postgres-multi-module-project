set search_path='fboace04_oltp_tab';

drop view if exists vw_airport;
CREATE view vw_airport
as
select airport_id, iata_code || ':' || short_name as name, iata_code, short_name, port_type, description, elevation_feet, lattitude, longitude
  from airport;

drop view if exists vw_pilot;
create view vw_pilot 
as 
  select pilot_id
     , last_name || ', ' || first_name || ' ' ||  middle_initial name
     , last_name
     , first_name
     , middle_initial
     , national_id_number
     , birthdate
     , notes
  from pilot
 order by last_name, first_name, middle_initial, birthdate;


drop view if exists vw_aircraft_type;
create or replace view vw_aircraft_type
as 
  select aircraft_type_id
     , short_name
     , short_name || ': ' || long_name name
     , long_name
     , description
     , notes
  from aircraft_type
 order by short_name;


drop view if exists vw_aircraft;
create view vw_aircraft
as
  select a.aircraft_id
     , a.aircraft_type_id
     , a.short_name
     , t.short_name || ' ' || a.short_name name
     , a.long_name
     , t.short_name aircraft_type_short_name
     , t.long_name aircraft_type_long_name
     , a.description
     , a.notes
  from aircraft a
  join aircraft_type t on t.aircraft_type_id = a.aircraft_type_id
 order by t.short_name, a.short_name;


drop view if exists vw_pilot_certification;
create view vw_pilot_certification 
as
  select pc.pilot_id
     , pt.last_name last_name
     , pt.first_name first_name
     , pt.last_name || ', ' || pt.first_name pilot_name
     , pt.middle_initial
     , pt.national_id_number
     , pt.birthdate
     , pc.aircraft_type_id
     , at.short_name aircraft_type_short_name
     , at.long_name aircraft_type_name
     , pt.last_name || ', ' || pt.first_name || ': ' || at.short_name || ': ' || pc.certification_number name
     , pc.certification_number
     , pc.valid_from_date
     , pc.EXpiration_date
     , pc.notes
  from pilot_certification pc
  join pilot pt on pt.pilot_id = pc.pilot_id
  join aircraft_type at on at.aircraft_type_id = pc.aircraft_type_id
 order by pt.last_name, pt.first_name, at.short_name;


drop view if exists vw_flight;
create view vw_flight
as
  select f.flight_id
     , f.aircraft_type_id
     , f.aircraft_id
     , at.short_name aircraft_type_short_name
     , at.long_name aircraft_type_long_name
     , f.long_name name
     , f.short_name
     , f.long_name
     , a.short_name aircraft_short_name
     , at.short_name || ' ' || a.short_name aircraft_name
     , f.airport_id_departure
     , dp.iata_code airport_name_departure
     , f.departure_date_time
     , f.airport_id_destination
     , dt.iata_code airport_name_destination
     , f.arrival_date_time
     , f.notes
  from flight f
  join aircraft a on a.aircraft_type_id = f.aircraft_type_id
                 and a.aircraft_id = f.aircraft_id
  join aircraft_type at on at.aircraft_type_id = a.aircraft_type_id
  left join airport  dp on f.airport_id_departure = dp.airport_id
  left join airport  dt on f.airport_id_destination = dt.airport_id
 order by f.departure_date_time desc, f.short_name;


drop view if exists vw_flight_crew_member;
create view vw_flight_crew_member
as
  select m.flight_id
     , m.aircraft_type_id
     , t.short_name as aircraft_type_short_name
     , m.pilot_id
     , p.last_name || ', ' || p.first_name pilot_name
     , f.short_name flight_short_name
     , f.long_name flight_long_name
     , f.long_name flight_name
     , p.first_name || ' ' || p.last_name  || ' is a Member of the Crew for Flight: ' || f.long_name name
     , c.certification_number pilot_certification_number
     , m.notes
  from flight_crew_member m
  join flight f on f.flight_id = m.flight_id
  join pilot_certification c on c.pilot_id = m.pilot_id and c.aircraft_type_id = m.aircraft_type_id
  join pilot  p on p.pilot_id = c.pilot_id
  join aircraft_type t on t.aircraft_type_id = c.aircraft_type_id
 order by f.short_name, p.last_name, p.first_name, f.short_name desc;


drop view if exists vw_airport;
create view vw_airport
as
  select AIRPORT_ID,
      iata_code || ': ' || short_name name,
      SHORT_NAME,
      IATA_CODE,
      DESCRIPTION,
      PORT_TYPE,
      elevation_feet,
      lattitude,
      longitude
      from airport
      order by iata_code, short_name;


