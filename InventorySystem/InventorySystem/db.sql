
CREATE DATABASE inventory;

USE inventory;


CREATE TABLE Customer (
       id	    INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
       name	    VARCHAR(32) NOT NULL
) ;


CREATE TABLE Item (
       item_id	    INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
       item_name	    VARCHAR(32) NOT NULL,
       item_value VARCHAR(32) NOT NULL
) ;

CREATE TABLE Orders (
       order_id	INT NOT NULL,
       customer_id int,
       item_id int,
       FOREIGN KEY (customer_id) REFERENCES Customer(id),
       FOREIGN KEY (item_id) REFERENCES Item(item_id)
) ;