Create database session3;
use session3;
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
    ALTER TABLE Airports CHANGE name name varchar(100);
CREATE TABLE Routes ( 
	id int auto_increment primary key,
    departure_airport_id int,
    arrival_airport_id int,
    distance int,
    flight_time time,
    foreign key (departure_airport_id) references Airports (id),
   foreign key (arrival_airport_id) references Airports (id)
   );
CREATE TABLE Aircrafts (
	id int auto_increment primary key,
    name varchar(50),
    make_model Varchar(50),
    total_seats int, 
    economy_seats int,
    business_seats int
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
describe Users;
describe Routes;
describe Aircrafts;
describe Shedules;
describe Tickets;

INSERT INTO Countries (name) VALUES ('Colombia'), ('Chile'), ('Canada');

INSERT INTO Offices (country_id, title, phone, contact) VALUES 
(1, 'Sucursal', '123-456-7890','Maryury Gonzalez'),
(2, 'Oficina principal', '234-567-8901', 'John William Corredor');

INSERT INTO Roles (title)  VALUES ('Administrador'), ('Piloto'),('Auxiliar de vuelo');

INSERT INTO CabinTypes (name) VALUES  ('Economica'), ('Negocios'), ('Primera clase');

INSERT INTO Airports (country_id, iata_code, Name) 
VALUES 
(1, 'ABS', 'Aeropuerto Benito Salas'), 
(2, 'AID', 'Aeropuerto Internacional El Dorado'),
(3, 'AIR', 'Aeropuerto Internacional Rafael Nuñez');

INSERT INTO Users (role_id, email, password, first_name, last_name, office_id, birthdate, active) 
VALUES 
(1, 'administrador@gmail.com', 'admin123', 'Marlon', 'Torres', 1, '2000-01-01', TRUE),
(2, 'piloto@gmail.com', 'pilot123', 'Joan', 'Trujillo', 2, '2001-02-02', TRUE),
(3, 'auxiliarvuelo@gmail.com', 'auxiliar123', 'Santiago', 'Cortes', 2, '2002-03-03', TRUE);

INSERT INTO Routes (departure_airport_id, arrival_airport_id, distance,flight_time) 
VALUES 
(1,2,300,'01:00:00'),
(1,3,300,'01:00:00');


INSERT INTO Aircrafts (make_model, total_seats, economy_seats, business_seats) 
VALUES 
('Boeing 1', 180, 150, 30), 
('Airbus 2', 160, 120, 40),
('Ce4ssna 3', 140, 100, 40);


INSERT INTO Shedules (date, time, aircraft_id, route_id, economy_price, confirmed, flight_number) 
VALUES 
('2024-06-15', '03:00:00', 1, 1, 20000, TRUE, 'AABB12'), 
('2024-06-16', '04:00:00', 2, 2, 50000, TRUE, 'AACC23');

INSERT INTO Tickets (user_id, shedule_id, cabin_type_id, first_name, last_name, email, phone, passport_number, passport_country_id, passport_photo, booking_reference, confirmed) 
VALUES 
(1, 1, 1, 'Laura', 'Bonilla', 'laurabonilla@gmail.com', '123-456-7890', 'AB12345', 1, NULL, 'BOOK1234', TRUE),
(2, 2, 2, 'Nicole', 'Cerquera', 'nicolecerquera@gmail.com', '234-567-8901', 'CD67890', 2, NULL, 'BOOK5678', TRUE);

SELECT * FROM Countries;
SELECT * FROM Offices;
SELECT * FROM Roles;
SELECT * FROM CabinTypes;
SELECT * FROM Airports;
SELECT * FROM Users;
SELECT * FROM Routes;
SELECT * FROM Aircrafts;
SELECT * FROM Shedules;
SELECT * FROM Tickets;

drop database Session3;