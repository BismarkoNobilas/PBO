-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 16, 2020 at 04:59 AM
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
-- Database: `kirimbarang`
--

-- --------------------------------------------------------

--
-- Table structure for table `biaya`
--

CREATE TABLE `biaya` (
  `id_biaya` int(5) NOT NULL,
  `asal` varchar(20) NOT NULL,
  `tujuan` varchar(20) NOT NULL,
  `biaya` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `biaya`
--

INSERT INTO `biaya` (`id_biaya`, `asal`, `tujuan`, `biaya`) VALUES
(1, 'DKI Jakarta', 'Banten', 10000),
(2, 'DKI Jakarta', 'DKI Jakarta', 5000),
(3, 'DKI Jakarta', 'Jawa Barat', 13000),
(4, 'DKI Jakarta', 'Jawa Tengah', 20000),
(5, 'DKI Jakarta', 'Yogyakarta', 22000),
(6, 'DKI Jakarta', 'Jawa Timur', 25000),
(7, 'Jawa Tengah', 'Banten', 15000),
(8, 'Jawa Tengah', 'DKI Jakarta', 20000),
(9, 'Jawa Tengah', 'Jawa Barat', 10000),
(10, 'Jawa Tengah', 'Jawa Tengah', 5000),
(11, 'Jawa Tengah', 'Yogyakarta', 13000),
(12, 'Jawa Tengah', 'Jawa Timur', 15000),
(13, 'Yogyakarta', 'Banten', 17000),
(14, 'Yogyakarta', 'DKI Jakarta', 22000),
(15, 'Yogyakarta', 'Jawa Barat', 12000),
(16, 'Yogyakarta', 'Jawa Tengah', 13000),
(17, 'Yogyakarta', 'Yogyakarta', 5000),
(18, 'Yogyakarta', 'Jawa Timur', 13000);

-- --------------------------------------------------------

--
-- Table structure for table `kirim`
--

CREATE TABLE `kirim` (
  `id_kirim` int(5) NOT NULL,
  `jeniskirim` varchar(20) NOT NULL,
  `jenisbarang` varchar(40) NOT NULL,
  `berat` int(10) NOT NULL,
  `id_biaya` int(5) NOT NULL,
  `total` int(10) NOT NULL,
  `id_pengirim` int(5) NOT NULL,
  `id_penerima` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `kirim`
--

INSERT INTO `kirim` (`id_kirim`, `jeniskirim`, `jenisbarang`, `berat`, `id_biaya`, `total`, `id_pengirim`, `id_penerima`) VALUES
(12, 'Express', 'Mudah Pecah', 5, 10, 22000, 27, 26);

-- --------------------------------------------------------

--
-- Table structure for table `penerima`
--

CREATE TABLE `penerima` (
  `id_penerima` int(5) NOT NULL,
  `nm_penerima` varchar(50) NOT NULL,
  `tujuan` varchar(20) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `hp_penerima` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `penerima`
--

INSERT INTO `penerima` (`id_penerima`, `nm_penerima`, `tujuan`, `alamat`, `hp_penerima`) VALUES
(26, 'Nadifsa', 'Jawa Tengah', 'Yogya', 788788);

-- --------------------------------------------------------

--
-- Table structure for table `pengirim`
--

CREATE TABLE `pengirim` (
  `id_pengirim` int(5) NOT NULL,
  `nm_pengirim` varchar(50) NOT NULL,
  `asal` varchar(15) NOT NULL,
  `hp_pengirim` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pengirim`
--

INSERT INTO `pengirim` (`id_pengirim`, `nm_pengirim`, `asal`, `hp_pengirim`) VALUES
(27, 'Bismarko', 'Jawa Tengah', 9999999);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `biaya`
--
ALTER TABLE `biaya`
  ADD PRIMARY KEY (`id_biaya`);

--
-- Indexes for table `kirim`
--
ALTER TABLE `kirim`
  ADD PRIMARY KEY (`id_kirim`),
  ADD KEY `id_pengirim` (`id_pengirim`),
  ADD KEY `id_penerima` (`id_penerima`),
  ADD KEY `id_biaya` (`id_biaya`);

--
-- Indexes for table `penerima`
--
ALTER TABLE `penerima`
  ADD PRIMARY KEY (`id_penerima`);

--
-- Indexes for table `pengirim`
--
ALTER TABLE `pengirim`
  ADD PRIMARY KEY (`id_pengirim`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `biaya`
--
ALTER TABLE `biaya`
  MODIFY `id_biaya` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT for table `kirim`
--
ALTER TABLE `kirim`
  MODIFY `id_kirim` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `penerima`
--
ALTER TABLE `penerima`
  MODIFY `id_penerima` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT for table `pengirim`
--
ALTER TABLE `pengirim`
  MODIFY `id_pengirim` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `kirim`
--
ALTER TABLE `kirim`
  ADD CONSTRAINT `id_biaya` FOREIGN KEY (`id_biaya`) REFERENCES `biaya` (`id_biaya`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `id_penerima` FOREIGN KEY (`id_penerima`) REFERENCES `penerima` (`id_penerima`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `id_pengirim` FOREIGN KEY (`id_pengirim`) REFERENCES `pengirim` (`id_pengirim`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
