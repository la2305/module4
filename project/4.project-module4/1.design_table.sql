CREATE DATABASE simple_man;
use simple_man;
CREATE TABLE admin(
	account_admin varchar(40) primary key not null,
    `password` varchar(40) not null,
    `name` varchar(40) not null,
    date_of_birth DATETIME,
    phone_number varchar(40) not null,
    email varchar(40) not null,
    location varchar(40) not null,
    gender BIT(1)
);
CREATE TABLE user(
	account_user varchar(40) primary key not null,
    `password` varchar(40) not null,
    `name` varchar(40) not null,
    date_of_birth DATETIME,
    phone_number varchar(40) not null,
    email varchar(40) not null,
    location varchar(40) not null,
    gender BIT(1)
);

CREATE TABLE product_type (
    product_type_id INT PRIMARY KEY AUTO_INCREMENT,
    product_type_name VARCHAR(255) NOT NULL
);
CREATE TABLE product (
	product_id int PRIMARY KEY  AUTO_INCREMENT,
    product_name VARCHAR(255) NOT null,
    product_price DOUBLE NOT NULL,
    product_description VARCHAR(255),
    product_type_id INT NOT NULL,
    product_img_path text not null,
    product_inventory int NOT NULL,
    producer varchar(255) not null,
    foreign key(product_type_id) references product_type (product_type_id)
);

CREATE TABLE `order`(
	order_id int PRIMARY KEY not null,
    quantity int not null,
    total_of_money DOUBLE not null,
    order_date DATETIME,
    estimated_delivery_order DATETIME,
    account_admin varchar(40),
    account_user varchar(40),
    FOREIGN KEY (account_admin) REFERENCES `admin`(account_admin),
	FOREIGN KEY (account_user) REFERENCES user(account_user)
);

CREATE table detail_order(
	detail_order_id int PRIMARY KEY not null,
    order_id int,
    product_id int,
    quanlity int,
    price double,
    FOREIGN KEY (product_id) REFERENCES product (product_id),
    FOREIGN KEY (order_id) REFERENCES `order`(order_id)
);








