-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 04, 2021 at 09:02 PM
-- Server version: 10.4.19-MariaDB
-- PHP Version: 8.0.6

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
('Chicken', 10, '2021-06-02', 2),
('Spaghetti', 22, '2021-06-02', 2),
('Pork', 7, '2021-06-02', 2);

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
(16, 'Delivery', 'nomos.ilias');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `user2`
--
ALTER TABLE `user2`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `user2`
--
ALTER TABLE `user2`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;
COMMIT;


-- --------------------------------------------------------

CREATE TABLE `orders` (
  `order_id` int(10) NOT NULL,
  `customer_id` int(10) NOT NULL,
  `quantity1` int(10) NOT NULL,
  `quantity2` int(10) NOT NULL,
  `quantity3` int(10) NOT NULL,
  `quantity4` int(10) NOT NULL,
  `flag` tinytext NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `orders`
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

--
-- Indexes for dumped tables
--

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`order_id`);

--
-- Indexes for table `plate`
--
ALTER TABLE `plate`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
  MODIFY `order_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `plate`
--
ALTER TABLE `plate`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;



/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
