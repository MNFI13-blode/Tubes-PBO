-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 18, 2024 at 10:15 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tel-u_market`
--

-- --------------------------------------------------------

--
-- Table structure for table `barang`
--

CREATE TABLE `barang` (
  `id_barang` varchar(10) NOT NULL,
  `id_penjual` varchar(10) DEFAULT NULL,
  `nama_barang` varchar(100) DEFAULT NULL,
  `jenis_barang` varchar(20) DEFAULT NULL,
  `harga` int(80) DEFAULT NULL,
  `jumlah_barang` int(80) DEFAULT NULL,
  `foto` blob DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `keranjang`
--

CREATE TABLE `keranjang` (
  `order_id` int(11) NOT NULL,
  `product_id` varchar(10) NOT NULL,
  `quantity` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `pembayaran`
--

CREATE TABLE `pembayaran` (
  `id_pembayaran` varchar(10) NOT NULL,
  `metode_pembayaran` varchar(100) DEFAULT NULL,
  `tanggal_pembayaran` date DEFAULT NULL,
  `waktu_pembayaran` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `total` int(50) DEFAULT NULL,
  `order_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `pengguna`
--

CREATE TABLE `pengguna` (
  `id_pembeli` varchar(10) NOT NULL,
  `username` varchar(100) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `alamat` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `role` enum('Mahasiswa','Dosen') DEFAULT NULL,
  `foto` blob DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pengguna`
--

INSERT INTO `pengguna` (`id_pembeli`, `username`, `password`, `alamat`, `email`, `role`, `foto`) VALUES
('1', 'Zaki', '123', 'none', 'none@gmail.com', 'Mahasiswa', 0x5b76616c75652d375d),
('1a915e01d', 'Hans', '123', 'cimahi', 'hans@gmail.com', 'Mahasiswa', NULL),
('c044a7b37', 'Naufal', '123', 'Cimahi', 'naufal@gmail.com', 'Mahasiswa', NULL),
('e10842023', 'Sheila', '123', 'cimahi', 'sheila@gmail.com', 'Mahasiswa', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `penjual`
--

CREATE TABLE `penjual` (
  `id_penjual` varchar(10) NOT NULL,
  `id_barang` varchar(10) DEFAULT NULL,
  `username` varchar(100) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `nama_toko` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `lokasi` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `t_order`
--

CREATE TABLE `t_order` (
  `order_id` int(11) NOT NULL,
  `order_date` date DEFAULT NULL,
  `id_pembeli` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `barang`
--
ALTER TABLE `barang`
  ADD PRIMARY KEY (`id_barang`),
  ADD KEY `penjual_FK` (`id_penjual`);

--
-- Indexes for table `keranjang`
--
ALTER TABLE `keranjang`
  ADD PRIMARY KEY (`order_id`,`product_id`),
  ADD KEY `product_id` (`product_id`);

--
-- Indexes for table `pembayaran`
--
ALTER TABLE `pembayaran`
  ADD PRIMARY KEY (`id_pembayaran`),
  ADD KEY `order_id` (`order_id`);

--
-- Indexes for table `pengguna`
--
ALTER TABLE `pengguna`
  ADD PRIMARY KEY (`id_pembeli`);

--
-- Indexes for table `penjual`
--
ALTER TABLE `penjual`
  ADD PRIMARY KEY (`id_penjual`),
  ADD KEY `barang_pj_FK` (`id_barang`);

--
-- Indexes for table `t_order`
--
ALTER TABLE `t_order`
  ADD PRIMARY KEY (`order_id`),
  ADD KEY `id_pembeli` (`id_pembeli`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `t_order`
--
ALTER TABLE `t_order`
  MODIFY `order_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `barang`
--
ALTER TABLE `barang`
  ADD CONSTRAINT `penjual_FK` FOREIGN KEY (`id_penjual`) REFERENCES `penjual` (`id_penjual`);

--
-- Constraints for table `keranjang`
--
ALTER TABLE `keranjang`
  ADD CONSTRAINT `keranjang_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `t_order` (`order_id`),
  ADD CONSTRAINT `keranjang_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `barang` (`id_barang`);

--
-- Constraints for table `pembayaran`
--
ALTER TABLE `pembayaran`
  ADD CONSTRAINT `pembayaran_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `t_order` (`order_id`);

--
-- Constraints for table `penjual`
--
ALTER TABLE `penjual`
  ADD CONSTRAINT `barang_pj_FK` FOREIGN KEY (`id_barang`) REFERENCES `barang` (`id_barang`);

--
-- Constraints for table `t_order`
--
ALTER TABLE `t_order`
  ADD CONSTRAINT `t_order_ibfk_1` FOREIGN KEY (`id_pembeli`) REFERENCES `pengguna` (`id_pembeli`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
