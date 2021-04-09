create table if not exists CUSTOMERS
(
    id           serial primary key,
    name         char(50)            not null,
    surname      char(50)            not null,
    age          int check (age > 5) not null,
    phone_number int                 not null
);


create table if not exists ORDERS
(
    id           serial,
    date         date,
    customer_id  int,
    product_name varchar(30),
    amount       int check ( amount > 0 ),
    primary key (id),
    foreign key (customer_id) references CUSTOMERS (id)
);

