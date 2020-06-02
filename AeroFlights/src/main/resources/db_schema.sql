drop schema aeroflights;

create schema aeroflights;

use aeroflights;

create table admin(
username varchar(30) PRIMARY KEY,
email varchar(30),
password varchar(30),
phone_no varchar(10)
);

create table user(
username varchar(30) PRIMARY KEY,
email varchar(30),
password varchar(30),
phone_no varchar(10)
);


create table flight(
flight_no varchar(10) PRIMARY KEY,
source varchar(30),
destination varchar(30),
departure datetime,
arrival datetime,
no_of_seats int,
price double
);

create table offer(
offer_title varchar(20) PRIMARY KEY,
discount double,
status varchar(10)
);

create table booking(
booking_id int AUTO_INCREMENT PRIMARY KEY,
username varchar(30),
flight_no varchar(10),
offer_title varchar(20),
no_of_tickets int,
total_amount decimal,
FOREIGN KEY(username) REFERENCES user(username),
FOREIGN KEY(flight_no) REFERENCES flight(flight_no),
FOREIGN KEY(offer_title) REFERENCES offer(offer_title)
);

create table passenger(
booking_id int,
name varchar(30),
age int,
gender varchar(10),
FOREIGN KEY(booking_id) REFERENCES booking(booking_id)
);