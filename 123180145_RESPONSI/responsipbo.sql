-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 20, 2020 at 08:17 AM
-- Server version: 10.4.8-MariaDB
-- PHP Version: 7.3.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `responsipbo`
--

-- --------------------------------------------------------

--
-- Table structure for table `daftarkereta`
--

CREATE TABLE `daftarkereta` (
  `id_kereta` varchar(20) NOT NULL,
  `nm_kereta` varchar(25) NOT NULL,
  `kelas` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `daftarkereta`
--

INSERT INTO `daftarkereta` (`id_kereta`, `nm_kereta`, `kelas`) VALUES
('RTX', 'Bengawan', 'Ekonomi'),
('1445', 'Alpha', 'Bisnis');

-- --------------------------------------------------------

--
-- Table structure for table `daftartiket`
--

CREATE TABLE `daftartiket` (
  `nama` varchar(35) NOT NULL,
  `jenkel` varchar(10) NOT NULL,
  `stasiun` varchar(20) NOT NULL,
  `kereta` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `daftartiket`
--

INSERT INTO `daftartiket` (`nama`, `jenkel`, `stasiun`, `kereta`) VALUES
('Hani', 'Wanita', 'Tugu Jogja', 'Pratameks'),
('Bisma', 'Pria', 'Maguwo', 'Haua');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
