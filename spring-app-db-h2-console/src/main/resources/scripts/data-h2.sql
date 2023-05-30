delete from PUBLIC.EXERCISE where id < 1000;
delete from PUBLIC.PERSON_EXERCISE where id < 1000;

insert into PUBLIC.PERSON_EXERCISE (ID, FIRST_NAME, LAST_NAME, EMAIL, DOB, ADDRESS, COUNTRY, GENDER)
values (NEXTVAL('person_exercise_sequence'), 'Charle', 'Test', 'cccc@gmail.com', '1999-01-01', 'adress', 'swiss', 'm');

INSERT INTO PUBLIC.EXERCISE (ID, NAME, DURATION, CALORIES, PERSON_EXERCISE_ID)
VALUES (NEXTVAL('exercise_sequence'), 'Crunches', 55, 8, select max(id) from PUBLIC.PERSON_EXERCISE);

INSERT INTO PUBLIC.EXERCISE (ID, NAME, DURATION, CALORIES, PERSON_EXERCISE_ID)
VALUES (NEXTVAL('exercise_sequence'), 'Touch Toes', 166, 6, select max(id) from PUBLIC.PERSON_EXERCISE);

INSERT INTO PUBLIC.EXERCISE (ID, NAME, DURATION, CALORIES, PERSON_EXERCISE_ID)
VALUES (NEXTVAL('exercise_sequence'), 'Side Lunges', 120, 17, select max(id) from PUBLIC.PERSON_EXERCISE);

INSERT INTO PUBLIC.EXERCISE (ID, NAME, DURATION, CALORIES, PERSON_EXERCISE_ID)
VALUES (NEXTVAL('exercise_sequence'), 'Burpees', 88, 8, select max(id) from PUBLIC.PERSON_EXERCISE);
