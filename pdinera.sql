-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 02, 2021 at 12:34 AM
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
('Zanzikin', 8, '2021-06-01', 6),
('Kromydi', 9, '2021-06-01', 2),
('Potaten', 29, '2021-06-01', 8),
('Maroyli', 35, '2021-06-01', 2),
('Ntomata', 40, '2021-06-01', 11),
('Chicken', 10, '2021-06-02', 2),
('Spaghetti', 22, '2021-06-02', 2),
('Pork', 7, '2021-06-02', 2);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
