insert into applications (name, monthly_cost)
values ('Spotify', 16.50),
       ('Netflix', 21.50),
       ('Amazon Prime', 12.50),
       ('Disney Plus', 15.50),
       ('Gympass', 35.00);

insert into customers (name, email)
values ('João', 'Joao123@gmail.com'),
       ('Maria', 'maria_rita_321@hotmail.com'),
       ('Pedro', 'pedro-Melo-3@terra.com.br'),
       ('wesley', 'WesleyGoularte@gmail.com'),
       ('Paulo', 'paulo.moreira@gmail.com'),
       ('Felipe', 'felipe.ferreira@gmail.com'),
       ('Antonio', 'antonio.henrique@gmail.com'),
       ('Roberto', 'roberto86.@gmail.com'),
       ('Miguel', 'miguel.schmidtt@gmail.com'),
       ('Julia', 'julia.moreira@gmail.com');

insert into subscriptions (customer_id, application_id, start_date, end_date)
values (1, 1, '2021-02-20', '2021-06-20'),
       (2, 2, '2023-03-29', '2025-07-26'),
       (3, 3, '2015-04-30', '2021-08-23'),
       (4, 4, '2019-05-19', '2024-09-21'),
       (4, 3, '2020-03-13', '2024-05-04');

insert into payments (subscription_id, paid_amount, payment_date)
values (3, 12.50, '2015-04-30'),
       (4, 15.50, '2019-05-19'),
       (1, 16.20, '2021-02-20'),
       (2, 21.50, '2023-03-29');

insert into users (username, password)
values ('admin', 'admin'),
       ('joao', '12341234'),
       ('maria', 'gremioTop321'),
       ('pedro', 'InterTop123'),
       ('wesley', 'VASCODAGAMACAMPEA0');

