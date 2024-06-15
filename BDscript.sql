CREATE TABLE Countries ( 
	id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR (45) NOT NULL
   );
CREATE TABLE Offices (
	id INT auto_increment primary KEY, 
    country_id int,
    title varchar(45) not null,
    phone varchar (20),
    contact varchar (45),
    foreign key (country_id) references Countries (id)
    );
CREATE TABLE Roles ( 
	id int auto_increment primary key,
	title varchar(45) not null
    );
CREATE TABLE CabinTypes (
	id int auto_increment primary key,
    name varchar(50) not null
    );
CREATE TABLE Users (
	id int auto_increment primary key,
    role_id int,
    email varchar(100) not null,
    password varchar(45) Not null,
    first_name varchar(45) not null,
    last_name varchar(45) not null,
    office_id int,
    birthdate date,
    active boolean, 
    foreign key (role_id) references Roles (id),
    foreign key (office_id) references Offices (id)
    );
CREATE TABLE  Airports (
		id int auto_increment primary key,
        country_id int,
        iata_code varchar(10),
        name varchar (100) not null,
        foreign key (country_id) references Countries(id)
	);
CREATE TABLE Routes ( 
	id int auto_increment primary key,
    departure_airport_id int,
    arrival_airport_id int,
    distance int,
    flight time,
    foreign key (departure_airport_id) references Airports (id),
   foreign key (arrival_airport_id) references Airports (id)
   );
CREATE TABLE Aircrafts (
	id int auto_increment primary key,
    make_model Varchar(50),
    total_seats int, 
    economy_seats int,
    businees_seats int
    );
CREATE TABLE Shedules (
	id int auto_increment primary key,
    date date,
    time time,
    aircraft_id int,
    route_id int,
    economy_price decimal (10,2),
    confirmed Boolean,
    flight_number varchar (50), 
    foreign key (aircraft_id) references Aircrafts(id),
    foreign key (route_id) references Routes(id)
    );
CREATE TABLE Tickets (
	id int auto_increment primary key,
    user_id int not null,
    shedule_id int not null,
    cabin_type_id int not null, 
    first_name varchar (45) not null, 
    last_name varchar (45) not null,
    email varchar (100) not null, 
    phone varchar (20) not null, 
    passport_number varchar (50) not null,
    passport_country_id int not null, 
    passport_photo blob,
    booking_reference varchar (50),
    confirmed boolean not null,
    foreign key (user_id) references Users(id),
    foreign key (Shedule_id) references Shedules(id),
    foreign key (cabin_type_id) references CabinTypes(id),
    foreign key (passport_country_id) references Countries(id)
    );
    
    show tables;
    
describe Countries;
describe Offices;
describe Roles; 
describe cabinTypes;
describe Airports;
describe Routes;
describe Aircrafts;
describe Shedules;
describe Tickets;




    