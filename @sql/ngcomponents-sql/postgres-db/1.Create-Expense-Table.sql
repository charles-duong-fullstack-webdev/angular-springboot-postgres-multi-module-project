--
-- TABLE: aexpenses
--
create table if not exists expenses
(
    id          bigserial  primary key,
    amount      numeric(19, 2),
    description varchar(255),
    expense     varchar(255)
    );

alter table expenses
    owner to postgres;

drop sequence if exists expenses_seq;
create sequence expenses_seq start with 1;

Insert into Expense (id,expense,description,amount) values (NEXTVAL('expenses_seq'),21.00,'book-1',21);
Insert into Expense (id,expense,description,amount) values (NEXTVAL('expenses_seq'),22.00,'book-2',22);
Insert into Expense (id,expense,description,amount) values (NEXTVAL('expenses_seq'),23.00,'book-3',23);
Insert into Expense (id,expense,description,amount) values (NEXTVAL('expenses_seq'),24.00,'book-4',24);
Insert into Expense (id,expense,description,amount) values (NEXTVAL('expenses_seq'),25.00,'book-5',25);
Insert into Expense (id,expense,description,amount) values (NEXTVAL('expenses_seq'),26.00,'book-6',27);
Insert into Expense (id,expense,description,amount) values (NEXTVAL('expenses_seq'),27.00,'book-7',28);
Insert into Expense (id,expense,description,amount) values (NEXTVAL('expenses_seq'),28.00,'book-8',29);
