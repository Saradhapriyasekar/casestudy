create database financemanagement;
use financemanagement;
create table users(user_id int primary key auto_increment,
username varchar(255) unique not null,
password varchar(255) not null,
email varchar(255) unique not null
);
create table ExpenseCategories ( category_id int primary key auto_increment,
category_name varchar(255) not null
);
create table Expenses(expense_id int primary key auto_increment,
user_id int ,
amount decimal (10 , 2) not null,
category_id int not null,
date date not null,
description varchar(255) not null,
constraint ui foreign key (user_id) references users (user_id) 
on delete cascade
on update cascade,
constraint ci foreign key (category_id) references ExpenseCategories (category_id) on delete cascade
on update cascade
);
insert into  users(username , password , email ) values
('Arun',     'Arun@897!',     'arun@gmail.com'),
('Murugan',  'Muru#12Ty',     'murugan@yahoo.com'),
('Sankar',   'SankR88x',     'sankar@gmail.com'),
('Ramani',   'R@mani2025',    'ramani@yahoo.com'),
('Bhavani',  'Bhv#n!33T',     'bhavani@gmail.com'),
('Kumaran',  'Kum*an45',     'kumaran@yahoo.com'),
('saradhapriya','Hatch9087','sara@gmail.com'),
('Suganthi', 'Sugi#789!',     'suganthi@gmail.com'),
('Vignesh',  'V!gne@31',     'vignesh@yahoo.com'),
('Janaki',   'Jan@ki!65',     'janaki@gmail.com');
INSERT INTO ExpenseCategories (category_id, category_name)VALUES (1, 'Food'),
(2,'Transportation'),
(3,'Rent'),
(4,'Education'),
(5,'Entertainment');
insert into Expenses(expense_id , user_id , amount , category_id , date , description  ) values
(1, 1, 50.75, 1, '2025-04-01', 'Groceries from supermarket'),
(2, 2, 20.00, 2, '2025-04-02', 'Taxi to office'),
(3, 3, 100.00, 3, '2025-04-03', 'April rent'),
(4, 1, 15.30, 4, '2025-04-04', 'Online course payment'),
(5, 2, 45.50, 5, '2025-04-05', 'Movie and snacks'),
(6, 3, 120.00, 1, '2025-04-06', 'Monthly grocery shopping'),
(7, 1, 18.75, 2, '2025-04-07', 'Bus fare and metro'),
(8, 2, 90.00, 3, '2025-04-08', 'May rent'),
(9, 3, 30.00, 4, '2025-04-09', 'Textbooks for class'),
(10, 1, 60.25, 5, '2025-04-10', 'Concert ticket');











