delete from PUBLIC.EXERCISE where id < 1000;
delete from PUBLIC.LOGIN where id < 1000;
delete from PUBLIC.LOGIN;

insert into PUBLIC.LOGIN (ID, userid, password, created_date, created_by, modified_date, modified_by)
values (NEXTVAL('LOGIN_sequence'), 'test1@test.com', 'Test1', '2023-02-26 11:17:41.712000', 'duc', '2023-02-26 11:17:41.712000', 'duc');

insert into PUBLIC.LOGIN (ID, userid, password, created_date, created_by, modified_date, modified_by)
values (NEXTVAL('LOGIN_sequence'), 'test2@test.com', 'Test2', '2023-02-26 11:17:41.712000', 'duc', '2023-02-26 11:17:41.712000', 'duc');

insert into PUBLIC.LOGIN (ID, userid, password, created_date, created_by, modified_date, modified_by)
values (NEXTVAL('LOGIN_sequence'), 'test3@test.com', 'Test3', '2023-02-26 11:17:41.712000', 'duc', '2023-02-26 11:17:41.712000', 'duc');

insert into PUBLIC.LOGIN (ID, userid, password, created_date, created_by, modified_date, modified_by)
values (NEXTVAL('LOGIN_sequence'), 'test4@test.com', 'Test4', '2023-02-26 11:17:41.712000', 'duc', '2023-02-26 11:17:41.712000', 'duc');

COMMIT;
