
create database mapper;
use mapper;

CREATE TABLE admin (
  id serial PRIMARY KEY NOT NULL,
  email varchar(100) DEFAULT NULL,
  password varchar(45) DEFAULT NULL,
  usertype varchar(45) DEFAULT 'admin'
) ;

CREATE TABLE customer (
  id serial PRIMARY KEY NOT NULL,
  firstname varchar(45) DEFAULT NULL,
  lastname varchar(45) DEFAULT NULL,
  email varchar(45) DEFAULT NULL,
  contact varchar(45) DEFAULT NULL,
  password varchar(45) DEFAULT NULL,
  usertype varchar(45) DEFAULT 'customer'
);

CREATE TABLE executive (
  id serial PRIMARY KEY NOT NULL,
  firstname varchar(45) DEFAULT NULL,
  lastname varchar(45) DEFAULT NULL,
  email varchar(45) DEFAULT NULL,
  contact varchar(45) DEFAULT NULL,
  password varchar(45) DEFAULT NULL,
  usertype varchar(45) DEFAULT 'executive'
  
);

CREATE TABLE store (
  id serial PRIMARY KEY NOT NULL,
  name varchar(45) DEFAULT NULL,
  location varchar(45) DEFAULT NULL,
  ownername varchar(45) DEFAULT NULL,
  contact varchar(45) DEFAULT NULL,
  email varchar(45) DEFAULT NULL,
  password varchar(45) DEFAULT NULL,
  executiveId int NOT NULL,
  storeImagePath varchar(45) DEFAULT NULL,
  usertype varchar(45) DEFAULT 'store'
);


CREATE TABLE visitorDetail (
  id serial PRIMARY KEY NOT NULL,
  visitorcount int DEFAULT NULL
) ;

CREATE TABLE wishlist (
 id serial PRIMARY KEY NOT NULL,
 customerId int DEFAULT NULL,
  storeId int DEFAULT NULL
) ;
