## Create Database
CREATE DATABASE tourismagencysystem;

## Create tables

CREATE TABLE `tbl_hotel` (
`hotel_id` int(11) NOT NULL AUTO_INCREMENT,
`name` varchar(255) NOT NULL,
`city` varchar(150) NOT NULL,
`region` varchar(255) NOT NULL,
`address` varchar(255) NOT NULL,
`email` varchar(255) NOT NULL,
`phoneNumber` varchar(15) NOT NULL,
`stars` int(10) NOT NULL,
PRIMARY KEY (`hotel_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci


CREATE TABLE `tbl_featuretype` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`feature_name` varchar(150) NOT NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci


CREATE TABLE `tbl_hotel_feature` (
`hotel_id` int(11) NOT NULL,
`feature_id` int(11) NOT NULL,
`feature_name` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci


CREATE TABLE `tbl_hotel_pension` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`hotel_id` int(11) NOT NULL,
`pension_id` int(11) NOT NULL,
`pension_name` varchar(150) NOT NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci


CREATE TABLE `tbl_hotel_room` (
`room_id` int(11) NOT NULL AUTO_INCREMENT,
`hotel_id` int(11) NOT NULL,
`season_id` int(11) NOT NULL,
`pension_id` int(11) NOT NULL,
`room_type` varchar(150) NOT NULL,
`bed_number` int(11) NOT NULL,
`stock` int(11) NOT NULL,
`price_child` int(11) NOT NULL,
`price_adult` int(11) NOT NULL,
PRIMARY KEY (`room_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci


CREATE TABLE `tbl_pensiontype` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`pension_name` varchar(150) NOT NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci


CREATE TABLE `tbl_reservation` (
`reservation_id` int(11) NOT NULL AUTO_INCREMENT,
`hotel_id` int(11) NOT NULL,
`room_id` int(11) NOT NULL,
`customer_name` varchar(150) NOT NULL,
`customer_tc` varchar(150) NOT NULL,
`customer_phone` varchar(150) NOT NULL,
`customer_email` varchar(150) NOT NULL,
`child_number` int(11) NOT NULL,
`adult_number` int(11) NOT NULL,
PRIMARY KEY (`reservation_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci


CREATE TABLE `tbl_room_property` (
`room_id` int(11) NOT NULL,
`property_name` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci


CREATE TABLE `tbl_season` (
`season_id` int(11) NOT NULL AUTO_INCREMENT,
`hotel_id` int(11) NOT NULL,
`season_name` varchar(150) NOT NULL,
`start_date` date NOT NULL,
`end_date` date NOT NULL,
PRIMARY KEY (`season_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci


CREATE TABLE `tbl_user` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`tcNo` varchar(11) NOT NULL,
`username` varchar(100) NOT NULL,
`password` varchar(50) NOT NULL,
`name` varchar(255) NOT NULL,
`surname` varchar(255) NOT NULL,
`usertype` enum('admin','employee','','') NOT NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci

## Sample Data Insertion

INSERT INTO `tbl_featuretype` (`id`, `feature_name`) VALUES (1, 'Ücretsiz Otopark')

INSERT INTO `tbl_featuretype` (`id`, `feature_name`) VALUES (2, '7/24 Oda Servisi')

INSERT INTO `tbl_featuretype` (`id`, `feature_name`) VALUES (3, 'Yüzme Havuzu')

INSERT INTO `tbl_featuretype` (`id`, `feature_name`) VALUES (4, 'Fitness Center')


INSERT INTO `tbl_hotel` (`hotel_id`, `name`, `city`, `region`, `address`, `email`, `phoneNumber`, `stars`) VALUES (1, 'Kodluyoruz Life İstanbul', 'İstanbul', 'Beyoglu', 'Şahkulu, Şişhane Metro Durağı, Meşrutiyet Cd. No:125, 34421', 'info@kodluyoruz.org', '02122561423', '5')

INSERT INTO `tbl_hotel` (`hotel_id`, `name`, `city`, `region`, `address`, `email`, `phoneNumber`, `stars`) VALUES (2, 'Balıkesir Hotel', 'Balıkesir', 'Nilüfer', 'Nilüfer kanalıcı mahallesi No:14', 'blkotel@gmail.com', '05564123259', '3')

INSERT INTO `tbl_hotel_feature`(`hotel_id`, `feature_id`, `feature_name`) VALUES ('1','1','Ücretsiz Otopark')

INSERT INTO `tbl_hotel_feature`(`hotel_id`, `feature_id`, `feature_name`) VALUES ('1','2','7/24 Oda Servisi')


INSERT INTO `tbl_pensiontype` (`id`, `pension_name`) VALUES (1, 'Ultra Herşey Dahil')

INSERT INTO `tbl_pensiontype` (`id`, `pension_name`) VALUES (2, 'Herşey Dahil')

INSERT INTO `tbl_pensiontype` (`id`, `pension_name`) VALUES (3, 'Oda Kahvaltı')

INSERT INTO `tbl_pensiontype` (`id`, `pension_name`) VALUES (5, 'Yarım Pansiyon')


INSERT INTO `tbl_hotel_pension` (`id`, `hotel_id`, `pension_id`, `pension_name`) VALUES (1, '1', '1', 'Ultra Herşey Dahil')

INSERT INTO `tbl_hotel_pension` (`id`, `hotel_id`, `pension_id`, `pension_name`) VALUES (2, '1', '3', 'Oda Kahvaltı')


INSERT INTO `tbl_season` (`season_id`, `hotel_id`, `season_name`, `start_date`, `end_date`) VALUES (1, '1', 'Kış Sezonu', '2023-01-01', '2023-05-31')

INSERT INTO `tbl_season` (`season_id`, `hotel_id`, `season_name`, `start_date`, `end_date`) VALUES (2, '1', 'Yaz Sezonu', '2023-06-01', '2023-09-31')


INSERT INTO `tbl_hotel_room` (`room_id`, `hotel_id`, `season_id`, `pension_id`, `room_type`, `bed_number`, `stock`, `price_child`, `price_adult`) VALUES (1, '1', '1', '1', 'Single', '70', '200', '200', '300')

INSERT INTO `tbl_hotel_room` (`room_id`, `hotel_id`, `season_id`, `pension_id`, `room_type`, `bed_number`, `stock`, `price_child`, `price_adult`) VALUES (2, '1', '1', '2', 'Double', '10', '100', '200', '500')


INSERT INTO `tbl_user` (`id`, `tcNo`, `username`, `password`, `name`, `surname`, `usertype`) VALUES (1, '45678912345', 'admin1', 'a4', 'Batuhan', 'Toy', 'admin')

INSERT INTO `tbl_user` (`id`, `tcNo`, `username`, `password`, `name`, `surname`, `usertype`) VALUES (2, '12345685165', 'employee1', 'b4', 'Elon', 'Musk', 'employee')



















