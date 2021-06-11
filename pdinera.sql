-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 11, 2021 at 12:56 PM
-- Server version: 10.4.18-MariaDB
-- PHP Version: 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pdinera`
--

-- --------------------------------------------------------

--
-- Table structure for table `booking`
--

CREATE TABLE `booking` (
  `id` int(11) NOT NULL,
  `cust_id` int(11) NOT NULL,
  `seats` int(11) NOT NULL,
  `startHH` int(11) NOT NULL,
  `startmm` int(11) NOT NULL,
  `endHH` int(11) NOT NULL,
  `endmm` int(11) NOT NULL,
  `table_id` int(11) NOT NULL,
  `Name` tinytext NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `booking`
--

INSERT INTO `booking` (`id`, `cust_id`, `seats`, `startHH`, `startmm`, `endHH`, `endmm`, `table_id`, `Name`) VALUES
(1, 12, 3, 17, 30, 19, 5, 2, 'Kostas'),
(2, 14, 6, 13, 30, 15, 15, 2, 'Lola');

-- --------------------------------------------------------

--
-- Table structure for table `food`
--

CREATE TABLE `food` (
  `Fagito` tinytext DEFAULT NULL,
  `Posotita` int(11) NOT NULL DEFAULT 1,
  `Imerominia` date NOT NULL,
  `Oriaellipsis` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `food`
--

INSERT INTO `food` (`Fagito`, `Posotita`, `Imerominia`, `Oriaellipsis`) VALUES
('mudia', 100, '2021-06-09', 10),
('garides', 95, '2021-06-09', 10),
('kotopoulo', 29, '2021-06-09', 2),
('mosxari', 15, '2021-06-09', 2),
('xoirino', 10, '2021-06-09', 2),
('makaronia', 35, '2021-06-09', 2),
('mapa', 40, '2021-06-09', 2),
('marouli', 39, '2021-06-09', 5),
('ryzi', 20, '2021-06-09', 21),
('manitaria', 47, '2021-06-09', 2),
('Cheese', 2, '2021-06-09', 2);

-- --------------------------------------------------------

--
-- Table structure for table `lastlog`
--

CREATE TABLE `lastlog` (
  `id` int(11) NOT NULL,
  `Role` tinytext NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `lastlog`
--

INSERT INTO `lastlog` (`id`, `Role`) VALUES
(22, 'Delivery');

-- --------------------------------------------------------

--
-- Table structure for table `notification`
--

CREATE TABLE `notification` (
  `id` int(11) NOT NULL,
  `role` text NOT NULL,
  `type` int(11) NOT NULL,
  `info` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `notification`
--

INSERT INTO `notification` (`id`, `role`, `type`, `info`) VALUES
(3, 'delivery', 1, '1'),
(4, 'owner', 1, '1'),
(22, 'delivery', 1, '18'),
(23, 'delivery', 1, '17'),
(24, 'delivery', 1, '24'),
(28, 'chef', 3, 'Cheese shortage'),
(33, 'chef', 3, 'ryzi shortage');

-- --------------------------------------------------------

--
-- Table structure for table `orario`
--

CREATE TABLE `orario` (
  `Employee` text NOT NULL,
  `Clock_In` text NOT NULL,
  `Clock_Out` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `orario`
--

INSERT INTO `orario` (`Employee`, `Clock_In`, `Clock_Out`) VALUES
('chef', '8', '16'),
('chef2', '9', '5'),
('delivery', '13', '23'),
('delivery2', '17', '00');

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `order_id` int(10) NOT NULL,
  `customer_id` int(10) NOT NULL,
  `quantity1` int(10) NOT NULL,
  `quantity2` int(10) NOT NULL,
  `quantity3` int(10) NOT NULL,
  `quantity4` int(10) NOT NULL,
  `flag` tinytext NOT NULL,
  `delivery` text NOT NULL,
  `orderstable` int(10) DEFAULT NULL,
  `address` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`order_id`, `customer_id`, `quantity1`, `quantity2`, `quantity3`, `quantity4`, `flag`, `delivery`, `orderstable`, `address`) VALUES
(17, 17, 0, 1, 1, 2, 'ready', 'Entos tou xwrou', 4, NULL),
(24, 12, 0, 3, 2, 0, 'ready', 'TakeAway', 0, NULL),
(26, 12, 0, 0, 2, 0, 'canceled', 'TakeAway', 0, NULL),
(27, 17, 1, 3, 2, 0, 'delivered', 'Entos tou xwrou', 3, NULL),
(30, 14, 2, 2, 3, 4, 'submitted', 'Delivery', 0, 'Kalamata 99'),
(31, 18, 0, 3, 2, 5, 'delivered', 'Entos tou xwrou', 1, NULL),
(32, 18, 0, 3, 1, 0, 'submitted', 'Delivery', 1, 'Salonika 9'),
(33, 18, 0, 0, 0, 3, 'submitted', 'TakeAway', 1, NULL),
(34, 18, 2, 0, 2, 1, 'delivered', 'Delivery', 1, 'Creta 88'),
(35, 18, 0, 3, 3, 0, 'submitted', 'Entos tou xwrou', 3, NULL),
(36, 12, 2, 2, 1, 0, 'submitted', 'Delivery', 0, 'Patra 33'),
(37, 21, 0, 3, 3, 0, 'submitted', 'Delivery', 0, 'Georgioy 1'),
(38, 21, 0, 2, 2, 0, 'submitted', 'Delivery', 0, 'Athens 23');

-- --------------------------------------------------------

--
-- Table structure for table `plate`
--

CREATE TABLE `plate` (
  `id` int(10) NOT NULL,
  `name` varchar(20) NOT NULL,
  `price` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `plate`
--

INSERT INTO `plate` (`id`, `name`, `price`) VALUES
(1, 'Rise', 8),
(2, 'Pizza', 12),
(3, 'Chicken', 8),
(4, 'Beef', 10);

-- --------------------------------------------------------

--
-- Table structure for table `schedule`
--

CREATE TABLE `schedule` (
  `User` tinytext NOT NULL,
  `Start` time NOT NULL,
  `End` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `schedule`
--

INSERT INTO `schedule` (`User`, `Start`, `End`) VALUES
('Chef', '09:00:00', '17:00:00'),
('Dianomeas', '10:00:00', '17:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `tables`
--

CREATE TABLE `tables` (
  `id` int(11) NOT NULL,
  `isOccupied` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tables`
--

INSERT INTO `tables` (`id`, `isOccupied`) VALUES
(1, 0),
(2, 0),
(3, 0),
(4, 0),
(5, 0);

-- --------------------------------------------------------

--
-- Table structure for table `user2`
--

CREATE TABLE `user2` (
  `id` int(11) NOT NULL,
  `Role` tinytext NOT NULL,
  `Password` tinytext DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user2`
--

INSERT INTO `user2` (`id`, `Role`, `Password`) VALUES
(1, 'Owner', 'ow1'),
(11, 'Chef', 'ch1'),
(12, 'Customer', 'hunter2'),
(13, 'Chef', 'vvv'),
(14, 'Customer', 'panos'),
(15, 'Delivery', 'velos'),
(16, 'Delivery', 'nomos.ilias'),
(17, 'Customer', 'andreas'),
(18, 'Customer', 'ch1'),
(21, 'Customer', 'stefanos'),
(22, 'Delivery', 'stefanos');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `notification`
--
ALTER TABLE `notification`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`order_id`);

--
-- Indexes for table `user2`
--
ALTER TABLE `user2`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `notification`
--
ALTER TABLE `notification`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;

--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
  MODIFY `order_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=39;

--
-- AUTO_INCREMENT for table `user2`
--
ALTER TABLE `user2`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
