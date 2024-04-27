insert into applications (id, name, monthly_cost)
values (1, 'Spotify', 16.50),
       (2, 'Netflix', 21.50),
       (3, 'Amazon Prime', 12.50),
       (4, 'Disney Plus', 15.50);

insert into customers (id, name, email)
values (1, 'João', 'Joao123@gmail.com'),
       (2, 'Maria', 'maria_rita_321@hotmail.com'),
       (3, 'Pedro', 'pedro-Melo-3@terra.com.br'),
       (4, 'wesley', 'WesleyGoularte@gmail.com');

insert into subscriptions (id, customer_id, application_id, start_date, end_date)
values (1, 1, 1, '2021-02-20', '2021-06-20'),
       (2, 2, 2, '2023-03-29', '2025-07-26'),
       (3, 3, 3, '2015-04-30', '2021-08-23'),
       (4, 4, 4, '2019-05-19', '2024-09-21');

insert into payments (id, subscription_id, paid_amount, payment_date)
values (1, 3, 12.50, '2015-04-30'),
       (2, 4, 15.50, '2019-05-19'),
       (3, 1, 16.20, '2021-02-20'),
       (4, 2, 21.50, '2023-03-29');

insert into users (id, username, password)
values (1, 'admin', 'admin'),
       (2, 'joao', '12341234'),
       (3, 'maria', 'gremioTop321'),
       (4, 'pedro', 'InterTop123'),
       (5, 'wesley', 'VASCODAGAMACAMPEA0');

