--delete from PUBLIC.EXERCISE where id < 1000;
--delete from PUBLIC.LOGIN where id < 1000;
--delete from PUBLIC.LOGIN;

insert into PUBLIC.LOGIN (ID, userid, password, birthday, created_date, created_by, modified_date, modified_by)
values (NEXTVAL('login_sequence'), 'testscripts_test1@test.com', 'testscripts_Test1', '1981-12-10',  '2023-02-26 11:17:41.712000', 'duc', '2023-02-26 11:17:41.712000', 'duc');

insert into PUBLIC.LOGIN (ID, userid, password, birthday, created_date, created_by, modified_date, modified_by)
values (NEXTVAL('login_sequence'), 'testscripts_test2@test.com', 'testscripts_Test2',  '1982-12-10', '2023-02-26 11:17:41.712000', 'duc', '2023-02-26 11:17:41.712000', 'duc');

insert into PUBLIC.LOGIN (ID, userid, password, birthday, created_date, created_by, modified_date, modified_by)
values (NEXTVAL('login_sequence'), 'testscripts_test3@test.com', 'testscripts_Test3',  '1983-12-10', '2023-02-26 11:17:41.712000', 'duc', '2023-02-26 11:17:41.712000', 'duc');

insert into PUBLIC.LOGIN (ID, userid, password, birthday, created_date, created_by, modified_date, modified_by)
values (NEXTVAL('login_sequence'), 'testscripts_test4@test.com', 'testscripts_Test4', '1984-12-10', '2023-02-26 11:17:41.712000', 'duc', '2023-02-26 11:17:41.712000', 'duc');

insert into PUBLIC.LOGIN (ID, userid, password, birthday, created_date, created_by, modified_date, modified_by)
values (NEXTVAL('login_sequence'), 'testscripts_test5@test.com', 'testscripts_Test5', '1984-12-10', '2023-02-26 11:17:41.712000', 'duc', '2023-02-26 11:17:41.712000', 'duc');



