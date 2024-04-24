SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

CREATE DATABASE IF NOT EXISTS `tourismagencysystem` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `tourismagencysystem`;

CREATE TABLE `tbl_featuretype` (
  `id` int NOT NULL,
  `feature_name` varchar(150) COLLATE utf8mb4_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO `tbl_featuretype` (`id`, `feature_name`) VALUES
(1, 'Ücretsiz Otopark'),
(2, 'SPA'),
(3, '7/24 Oda Servisi'),
(4, 'Ücretsiz WiFi'),
(5, 'Yüzme Havuzu'),
(6, 'Fitness Center'),
(7, 'Hotel Concierge');

CREATE TABLE `tbl_hotel` (
  `hotel_id` int NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `city` varchar(150) COLLATE utf8mb4_general_ci NOT NULL,
  `region` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `address` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `email` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `phoneNumber` varchar(15) COLLATE utf8mb4_general_ci NOT NULL,
  `stars` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO `tbl_hotel` (`hotel_id`, `name`, `city`, `region`, `address`, `email`, `phoneNumber`, `stars`) VALUES
(7, 'Kodluyoruz Life İstanbul', 'İstanbul', 'Beyoğlu', 'Şahkulu, Şişhane Metro Durağı, Meşrutiyet Cd. No:125, 34421', 'info@kodluyoruz.org', '02122121122', 5),
(11, 'otel', 'şehir', 'ilçe', 'adres', 'mail@mail.com', '12312313', 5);

CREATE TABLE `tbl_hotel_feature` (
  `hotel_id` int NOT NULL,
  `feature_id` int NOT NULL,
  `feature_name` varchar(150) COLLATE utf8mb4_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO `tbl_hotel_feature` (`hotel_id`, `feature_id`, `feature_name`) VALUES
(3, 2, 'SPA'),
(3, 1, 'Ücretsiz Otopark'),
(3, 5, 'Yüzme Havuzu'),
(4, 2, 'SPA'),
(4, 3, '7/24 Oda Servisi'),
(5, 4, 'Ücretsiz WiFi'),
(6, 1, 'Ücretsiz Otopark'),
(7, 1, 'Ücretsiz Otopark'),
(7, 2, 'SPA'),
(7, 3, '7/24 Oda Servisi'),
(7, 4, 'Ücretsiz WiFi'),
(7, 5, 'Yüzme Havuzu'),
(7, 6, 'Fitness Center'),
(7, 7, 'Hotel Concierge'),
(8, 2, 'SPA'),
(8, 3, '7/24 Oda Servisi'),
(10, 1, 'Ücretsiz Otopark'),
(10, 5, 'Yüzme Havuzu'),
(11, 2, 'SPA'),
(11, 6, 'Fitness Center');

CREATE TABLE `tbl_hotel_pension` (
  `id` int NOT NULL,
  `hotel_id` int NOT NULL,
  `pension_id` int NOT NULL,
  `pension_name` varchar(150) COLLATE utf8mb4_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO `tbl_hotel_pension` (`id`, `hotel_id`, `pension_id`, `pension_name`) VALUES
(8, 4, 2, 'Herşey Dahil'),
(9, 4, 1, 'Ultra Herşey Dahil'),
(10, 4, 4, 'Tam Pansiyon'),
(11, 4, 5, 'Yarım Pansiyon'),
(12, 4, 7, 'Alkol Hariç Full credit'),
(13, 5, 2, 'Herşey Dahil'),
(14, 5, 6, 'Sadece Yatak'),
(15, 5, 7, 'Alkol Hariç Full credit'),
(16, 6, 1, 'Ultra Herşey Dahil'),
(17, 7, 5, 'Yarım Pansiyon'),
(18, 7, 3, 'Oda Kahvaltı'),
(19, 8, 1, 'Ultra Herşey Dahil'),
(20, 8, 3, 'Oda Kahvaltı'),
(21, 10, 4, 'Tam Pansiyon'),
(22, 10, 5, 'Yarım Pansiyon'),
(23, 11, 2, 'Herşey Dahil'),
(24, 11, 5, 'Yarım Pansiyon');

CREATE TABLE `tbl_hotel_room` (
  `room_id` int NOT NULL,
  `hotel_id` int NOT NULL,
  `season_id` int NOT NULL,
  `pension_id` int NOT NULL,
  `room_type` varchar(150) COLLATE utf8mb4_general_ci NOT NULL,
  `bed_number` int NOT NULL,
  `stock` int NOT NULL,
  `price_child` int NOT NULL,
  `price_adult` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO `tbl_hotel_room` (`room_id`, `hotel_id`, `season_id`, `pension_id`, `room_type`, `bed_number`, `stock`, `price_child`, `price_adult`) VALUES
(9, 7, 8, 5, 'Double Room', 2, 9, 200, 500),
(12, 11, 15, 5, 'Double Room', 2, 10, 150, 200),
(13, 11, 15, 2, 'Single Room', 1, 5, 0, 500);

CREATE TABLE `tbl_pensiontype` (
  `id` int NOT NULL,
  `pension_name` varchar(150) COLLATE utf8mb4_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO `tbl_pensiontype` (`id`, `pension_name`) VALUES
(1, 'Ultra Herşey Dahil'),
(2, 'Herşey Dahil'),
(3, 'Oda Kahvaltı'),
(4, 'Tam Pansiyon'),
(5, 'Yarım Pansiyon'),
(6, 'Sadece Yatak'),
(7, 'Alkol Hariç Full credit');

CREATE TABLE `tbl_reservation` (
  `reservation_id` int NOT NULL,
  `hotel_id` int NOT NULL,
  `room_id` int NOT NULL,
  `customer_name` varchar(150) COLLATE utf8mb4_general_ci NOT NULL,
  `customer_tc` varchar(150) COLLATE utf8mb4_general_ci NOT NULL,
  `customer_phone` varchar(150) COLLATE utf8mb4_general_ci NOT NULL,
  `customer_email` varchar(150) COLLATE utf8mb4_general_ci NOT NULL,
  `child_number` int NOT NULL,
  `adult_number` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO `tbl_reservation` (`reservation_id`, `hotel_id`, `room_id`, `customer_name`, `customer_tc`, `customer_phone`, `customer_email`, `child_number`, `adult_number`) VALUES
(11, 7, 9, 'Guest_One', '11111111111', '5555555555', 'guest1@mail.com', 1, 1);

CREATE TABLE `tbl_roomtype` (
  `type_id` int NOT NULL,
  `feature_name` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO `tbl_roomtype` (`type_id`, `feature_name`) VALUES
(1, 'Single Room'),
(2, 'Double Room'),
(3, 'Junior Suit Room'),
(4, 'Suit Room');

CREATE TABLE `tbl_room_property` (
  `room_id` int NOT NULL,
  `property_name` varchar(150) COLLATE utf8mb4_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO `tbl_room_property` (`room_id`, `property_name`) VALUES
(1, 'Televizyon'),
(1, 'Kasa'),
(9, 'TV'),
(10, 'Mİnibar'),
(10, 'Wifi'),
(11, 'Minibar'),
(11, 'Wifi'),
(13, 'Minibar'),
(12, 'Wifi');

CREATE TABLE `tbl_season` (
  `season_id` int NOT NULL,
  `hotel_id` int NOT NULL,
  `season_name` varchar(150) COLLATE utf8mb4_general_ci NOT NULL,
  `start_date` date NOT NULL,
  `end_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO `tbl_season` (`season_id`, `hotel_id`, `season_name`, `start_date`, `end_date`) VALUES
(8, 7, 'KIŞ', '2024-01-01', '2024-05-31'),
(9, 7, 'YAZ', '2024-06-01', '2024-12-01'),
(15, 11, 'YAZ', '2025-04-01', '2025-09-01');

CREATE TABLE `tbl_user` (
  `id` int NOT NULL,
  `tcNo` varchar(11) COLLATE utf8mb4_general_ci NOT NULL,
  `username` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `surname` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `usertype` enum('admin','employee') COLLATE utf8mb4_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO `tbl_user` (`id`, `tcNo`, `username`, `password`, `name`, `surname`, `usertype`) VALUES
(1, '2222222222', 'admin', '0000', 'admin', 'manager', 'admin'),
(6, '22222222221', 'worker', '1111', 'worker', 'W', 'employee');


ALTER TABLE `tbl_featuretype`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `tbl_hotel`
  ADD PRIMARY KEY (`hotel_id`);

ALTER TABLE `tbl_hotel_pension`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `tbl_hotel_room`
  ADD PRIMARY KEY (`room_id`);

ALTER TABLE `tbl_pensiontype`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `tbl_reservation`
  ADD PRIMARY KEY (`reservation_id`);

ALTER TABLE `tbl_roomtype`
  ADD PRIMARY KEY (`type_id`);

ALTER TABLE `tbl_season`
  ADD PRIMARY KEY (`season_id`);

ALTER TABLE `tbl_user`
  ADD PRIMARY KEY (`id`);


ALTER TABLE `tbl_featuretype`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

ALTER TABLE `tbl_hotel`
  MODIFY `hotel_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

ALTER TABLE `tbl_hotel_pension`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

ALTER TABLE `tbl_hotel_room`
  MODIFY `room_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

ALTER TABLE `tbl_pensiontype`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

ALTER TABLE `tbl_reservation`
  MODIFY `reservation_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

ALTER TABLE `tbl_roomtype`
  MODIFY `type_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

ALTER TABLE `tbl_season`
  MODIFY `season_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

ALTER TABLE `tbl_user`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
