delete
from PUBLIC.EXERCISE
where id < 1000;
delete
from PUBLIC.PERSON_EXERCISE
where id < 1000;

insert into PUBLIC.PERSON_EXERCISE (ID, FIRST_NAME, LAST_NAME, EMAIL, DOB, ADDRESS, COUNTRY, GENDER)
values (NEXTVAL('person_exercise_sequence'), 'Charle', 'Test', 'cccc@gmail.com', '1999-01-01', 'adress', 'swiss', 'm');

INSERT INTO PUBLIC.EXERCISE (ID, NAME, DURATION, CALORIES, TRAININGDATE, STATE, PERSON_EXERCISE_ID)
VALUES (NEXTVAL('exercise_sequence'), 'Crunches', 55, 8, '1999-01-01', 'complete', select max(id) from PUBLIC.PERSON_EXERCISE);

INSERT INTO PUBLIC.EXERCISE (ID, NAME, DURATION, CALORIES, TRAININGDATE, STATE, PERSON_EXERCISE_ID)
VALUES (NEXTVAL('exercise_sequence'), 'Touch Toes', 166, 6, '1999-01-01', 'complete', select max(id) from PUBLIC.PERSON_EXERCISE);

INSERT INTO PUBLIC.EXERCISE (ID, NAME, DURATION, CALORIES, TRAININGDATE, STATE, PERSON_EXERCISE_ID)
VALUES (NEXTVAL('exercise_sequence'), 'Side Lunges', 120, 17, '1999-01-01', 'complete', select max(id) from PUBLIC.PERSON_EXERCISE);

INSERT INTO PUBLIC.EXERCISE (ID, NAME, DURATION, CALORIES, TRAININGDATE, STATE, PERSON_EXERCISE_ID)
VALUES (NEXTVAL('exercise_sequence'), 'Burpees', 88, 28, '1999-01-01', 'complete', select max(id) from PUBLIC.PERSON_EXERCISE);

INSERT INTO PUBLIC.EXERCISE (ID, NAME, DURATION, CALORIES, TRAININGDATE, STATE, PERSON_EXERCISE_ID)
VALUES (NEXTVAL('exercise_sequence'), 'Chest', 89, 22, '1999-01-01', 'complete', select max(id) from PUBLIC.PERSON_EXERCISE);

INSERT INTO PUBLIC.EXERCISE (ID, NAME, DURATION, CALORIES, TRAININGDATE, STATE, PERSON_EXERCISE_ID)
VALUES (NEXTVAL('exercise_sequence'), 'Shoulder', 92, 48, '1999-01-01', 'complete', select max(id) from PUBLIC.PERSON_EXERCISE);

INSERT INTO PUBLIC.EXERCISE (ID, NAME, DURATION, CALORIES, TRAININGDATE, STATE, PERSON_EXERCISE_ID)
VALUES (NEXTVAL('exercise_sequence'), 'Biceps', 34, 85, '1999-01-01', 'complete', select max(id) from PUBLIC.PERSON_EXERCISE);

INSERT INTO PUBLIC.EXERCISE (ID, NAME, DURATION, CALORIES, TRAININGDATE, STATE, PERSON_EXERCISE_ID)
VALUES (NEXTVAL('exercise_sequence'), 'Triceps', 26, 23, '1999-01-01', 'complete', select max(id) from PUBLIC.PERSON_EXERCISE);

INSERT INTO PUBLIC.EXERCISE (ID, NAME, DURATION, CALORIES, TRAININGDATE, STATE, PERSON_EXERCISE_ID)
VALUES (NEXTVAL('exercise_sequence'), 'Legs', 33, 56, '1999-01-01', 'complete', select max(id) from PUBLIC.PERSON_EXERCISE);

INSERT INTO PUBLIC.EXERCISE (ID, NAME, DURATION, CALORIES, TRAININGDATE, STATE, PERSON_EXERCISE_ID)
VALUES (NEXTVAL('exercise_sequence'), 'Back', 55, 76, '1999-01-01', 'complete', select max(id) from PUBLIC.PERSON_EXERCISE);

INSERT INTO PUBLIC.EXERCISE (ID, NAME, DURATION, CALORIES, TRAININGDATE, STATE, PERSON_EXERCISE_ID)
VALUES (NEXTVAL('exercise_sequence'), 'Glute', 66, 86, '1999-01-01', 'complete', select max(id) from PUBLIC.PERSON_EXERCISE);

INSERT INTO PUBLIC.EXERCISE (ID, NAME, DURATION, CALORIES, TRAININGDATE, STATE, PERSON_EXERCISE_ID)
VALUES (NEXTVAL('exercise_sequence'), 'Abs', 77, 76, '1999-01-01', 'complete', select max(id) from PUBLIC.PERSON_EXERCISE);

INSERT INTO PUBLIC.EXERCISE (ID, NAME, DURATION, CALORIES, TRAININGDATE, STATE, PERSON_EXERCISE_ID)
VALUES (NEXTVAL('exercise_sequence'), 'Calves', 332, 11, '1999-01-01', 'complete', select max(id) from PUBLIC.PERSON_EXERCISE);

INSERT INTO PUBLIC.EXERCISE (ID, NAME, DURATION, CALORIES, TRAININGDATE, STATE, PERSON_EXERCISE_ID)
VALUES (NEXTVAL('exercise_sequence'), 'Forearm Flexors', 21, 04, '1999-01-01', 'complete', select max(id) from PUBLIC.PERSON_EXERCISE);

INSERT INTO PUBLIC.EXERCISE (ID, NAME, DURATION, CALORIES, TRAININGDATE, STATE, PERSON_EXERCISE_ID)
VALUES (NEXTVAL('exercise_sequence'), 'orearm Extensors', 53, 83, '1999-01-01', 'complete', select max(id) from PUBLIC.PERSON_EXERCISE);