
## Veritabanı
Projede kullanılan tabloları aşağıdaki sorgular ile oluşturabilirsiniz.

```mysql
-- Feature Type Table
CREATE TABLE tbl_featuretype (
  id INT(11) NOT NULL AUTO_INCREMENT,
  feature_name VARCHAR(150) NOT NULL,
  PRIMARY KEY (id)
);

-- Hotel Table
CREATE TABLE tbl_hotel (
  hotel_id INT(11) NOT NULL AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  city VARCHAR(150) NOT NULL,
  region VARCHAR(255) NOT NULL,
  address VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL,
  phoneNumber VARCHAR(15) NOT NULL,
  stars INT(10) NOT NULL,
  PRIMARY KEY (hotel_id)
);

-- Hotel Feature Table
CREATE TABLE tbl_hotel_feature (
  hotel_id INT(11) NOT NULL,
  feature_id INT(11) NOT NULL,
  feature_name VARCHAR(150) NOT NULL
);

-- Hotel Pension Table
CREATE TABLE tbl_hotel_pension (
  id INT(11) NOT NULL AUTO_INCREMENT,
  hotel_id INT(11) NOT NULL,
  pension_id INT(11) NOT NULL,
  pension_name VARCHAR(150) NOT NULL,
  PRIMARY KEY (id)
);

-- Hotel Room Table
CREATE TABLE tbl_hotel_room (
  room_id INT(11) NOT NULL AUTO_INCREMENT,
  hotel_id INT(11) NOT NULL,
  season_id INT(11) NOT NULL,
  pension_id INT(11) NOT NULL,
  room_type VARCHAR(150) NOT NULL,
  bed_number INT(11) NOT NULL,
  stock INT(11) NOT NULL,
  price_child INT(11) NOT NULL,
  price_adult INT(11) NOT NULL,
  PRIMARY KEY (room_id)
);

-- Pension Type Table
CREATE TABLE tbl_pensiontype (
  id INT(11) NOT NULL AUTO_INCREMENT,
  pension_name VARCHAR(150) NOT NULL,
  PRIMARY KEY (id)
);

-- Reservation Table
CREATE TABLE tbl_reservation (
  reservation_id INT(11) NOT NULL AUTO_INCREMENT,
  hotel_id INT(11) NOT NULL,
  room_id INT(11) NOT NULL,
  customer_name VARCHAR(150) NOT NULL,
  customer_tc VARCHAR(150) NOT NULL,
  customer_phone VARCHAR(150) NOT NULL,
  customer_email VARCHAR(150) NOT NULL,
  child_number INT(11) NOT NULL,
  adult_number INT(11) NOT NULL,
  PRIMARY KEY (reservation_id)
);

-- Room Property Table
CREATE TABLE tbl_room_property (
  room_id INT(11) NOT NULL,
  property_name VARCHAR(150) NOT NULL
);

-- Season Table
CREATE TABLE tbl_season (
  season_id INT(11) NOT NULL AUTO_INCREMENT,
  hotel_id INT(11) NOT NULL,
  season_name VARCHAR(150) NOT NULL,
  start_date DATE NOT NULL,
  end_date DATE NOT NULL,
  PRIMARY KEY (season_id)
);

-- User Table
CREATE TABLE tbl_user (
  id INT(11) NOT NULL AUTO_INCREMENT,
  tcNo VARCHAR(11) NOT NULL,
  username VARCHAR(100) NOT NULL,
  password VARCHAR(50) NOT NULL,
  name VARCHAR(255) NOT NULL,
  surname VARCHAR(255) NOT NULL,
  usertype ENUM('admin','employee') NOT NULL,
  PRIMARY KEY (id)
);
```
```mmysql
INSERT INTO tbl_pensiontype (pension_name) VALUES
('Ultra Herşey Dahil'),
('Herşey Dahil'),
('Oda Kahvaltı'),
('Tam Pansiyon'),
('Yarım Pansiyon'),
('Sadece Yatak'),
('Alkol Hariç Full credit');

INSERT INTO tbl_featuretype (id, feature_name) VALUES
(1, 'Ücretsiz Otopark'),
(2, 'SPA'),
(3, '7/24 Oda Servisi'),
(4, 'Ücretsiz WiFi'),
(5, 'Yüzme Havuzu'),
(6, 'Fitness Center'),
(7, 'Hotel Concierge');
```
