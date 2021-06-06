-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 06, 2021 at 08:37 PM
-- Server version: 10.4.19-MariaDB
-- PHP Version: 7.3.28

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
('KarpUZI', 20, '2021-06-04', 2),
('Ntomates', 30, '2021-06-04', 2),
('PePony', 15, '2021-06-04', 2),
('Zanzikin', 25, '2021-06-04', 15),
('Yaoyrttt', 19, '2021-06-04', 2),
('Xoirino', 27, '2021-06-04', 2),
('Chicken', 41, '2021-06-04', 2),
('Papardelles', 39, '2021-06-04', 2),
('Spaghetti6', 50, '2021-06-04', 2),
('LoukaNikos', 60, '2021-06-04', 2),
('FetaIpiros', 29, '2021-06-04', 2),
('KimAss', 45, '2021-06-04', 10);

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
(17, 'Customer');

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
(1, 1),
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
(17, 'Customer', 'andreas');

--
-- Indexes for dumped tables
--

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
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
  MODIFY `order_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `user2`
--
ALTER TABLE `user2`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
