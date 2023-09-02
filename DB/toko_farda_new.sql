-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 02, 2023 at 05:19 PM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `toko_farda_new`
--

DELIMITER $$
--
-- Functions
--
CREATE DEFINER=`root`@`localhost` FUNCTION `cetakBilanganGanjil` (`n` INT) RETURNS TEXT CHARSET utf8mb4 COLLATE utf8mb4_general_ci  BEGIN
  DECLARE i INT DEFAULT 1;
  DECLARE output TEXT DEFAULT '';
  WHILE (i <= n) DO
    IF (i % 2 <> 0) THEN
      SET output = CONCAT(output, i, ' ');
    END IF;
    SET i = i + 1;
  END WHILE;
  RETURN output;
END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `getDateToday` () RETURNS CHAR(30) CHARSET utf8mb4 COLLATE utf8mb4_general_ci  BEGIN
RETURN DATE_FORMAT(NOW(), '%D %m %Y');
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `barang`
--

CREATE TABLE `barang` (
  `Kode_Barang` char(20) NOT NULL,
  `Nama_Barang` varchar(45) NOT NULL,
  `Tgl_Expired` date NOT NULL,
  `Harga_Beli` int(11) NOT NULL,
  `Harga_Jual` int(10) NOT NULL,
  `Stok` int(11) NOT NULL,
  `id_JenisBarang` int(11) NOT NULL,
  `id_Supplier` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `barang`
--

INSERT INTO `barang` (`Kode_Barang`, `Nama_Barang`, `Tgl_Expired`, `Harga_Beli`, `Harga_Jual`, `Stok`, `id_JenisBarang`, `id_Supplier`) VALUES
('711844130111', 'ABC Saus Tomat', '2024-08-13', 10000, 12000, 3, 2, 3),
('8991102230308', 'Blaster Neapolitan', '2024-06-10', 5000, 8000, 1, 4, 1),
('8992775315095', 'Gery Salut Sweet Cheese', '2023-06-28', 6000, 7000, 3, 4, 2),
('8996129803504', 'Cleo 550ml', '2024-04-25', 2000, 4000, 2, 5, 3),
('8997025914059', 'Hatari', '2020-06-10', 4500, 5000, 9, 4, 3),
('8998866107952', 'Posh Charcoal', '2025-08-03', 2000, 15000, 2, 6, 3),
('8998866202343', 'Mie Sedap ', '2023-10-24', 2000, 3000, 2, 1, 1),
('8998866203401', ' Mie Sedap Soto Madura', '2024-07-18', 2500, 3000, 10, 1, 3),
('8998866500708', 'Floridina', '2020-06-10', 2000, 3000, 7, 3, 3);

-- --------------------------------------------------------

--
-- Stand-in structure for view `barangpakeko`
-- (See below for the actual view)
--
CREATE TABLE `barangpakeko` (
`Nama_Barang` varchar(45)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `databarang`
-- (See below for the actual view)
--
CREATE TABLE `databarang` (
`Nama_Barang` varchar(45)
,`Jenis_Barang` varchar(45)
,`Nama_Supplier` varchar(45)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `databarangmurah`
-- (See below for the actual view)
--
CREATE TABLE `databarangmurah` (
`Nama_Barang` varchar(45)
,`Harga_Jual` int(10)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `datadetailtransaksi`
-- (See below for the actual view)
--
CREATE TABLE `datadetailtransaksi` (
`Kode_TransaksiJual` char(6)
,`Tanggal` date
,`Subtotal_Barang` int(11)
);

-- --------------------------------------------------------

--
-- Table structure for table `detail_transaksi_beli`
--

CREATE TABLE `detail_transaksi_beli` (
  `Kode_TransaksiBeli` char(6) DEFAULT NULL,
  `Kode_Barang` char(20) DEFAULT NULL,
  `Jumlah` int(11) NOT NULL,
  `Subtotal_Barang` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `detail_transaksi_beli`
--

INSERT INTO `detail_transaksi_beli` (`Kode_TransaksiBeli`, `Kode_Barang`, `Jumlah`, `Subtotal_Barang`) VALUES
('TB0005', '8998866107952', 9, 18000),
('TB0005', '8998866500708', 9, 18000),
('TB0006', '8998866500708', 2, 4000),
('TB0008', '8998866500708', 2, 4000),
('TB0009', '8997025914059', 6, 27000),
('TB0010', '8996129803504', 6, 12000),
('TB0011', '8998866107952', 6, 12000),
('TB0012', '8996129803504', 6, 12000),
('TB0012', '8997025914059', 6, 27000),
('TB0012', '8998866107952', 6, 12000),
('TB0012', '8998866500708', 9, 18000),
('TB0014', '8997025914059', 4500, 1),
('TB0014', '8998866500708', 2000, 1),
('TB0015', '8997025914059', 4500, 4500),
('TB0015', '8998866500708', 2000, 2000),
('TB0016', '8997025914059', 4500, 4500),
('TB0017', '8998866500708', 1, 2000),
('TB0018', '8997025914059', 1, 4500),
('TB0019', '8998866500708', 1, 2000),
('TB0020', '8991102230308', 1, 5000),
('TB0022', '711844130111', 1, 10000),
('TB0023', '711844130111', 1, 10000),
('TB0024', '8992775315095', 5, 30000);

--
-- Triggers `detail_transaksi_beli`
--
DELIMITER $$
CREATE TRIGGER `tambahStock` AFTER INSERT ON `detail_transaksi_beli` FOR EACH ROW UPDATE barang
SET Stok = Stok + NEW.Jumlah
WHERE Kode_Barang = NEW.Kode_Barang
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `detail_transaksi_jual`
--

CREATE TABLE `detail_transaksi_jual` (
  `Kode_TransaksiJual` char(6) NOT NULL,
  `Kode_Barang` char(20) NOT NULL,
  `Jumlah_Barang` int(11) NOT NULL,
  `Subtotal_Barang` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `detail_transaksi_jual`
--

INSERT INTO `detail_transaksi_jual` (`Kode_TransaksiJual`, `Kode_Barang`, `Jumlah_Barang`, `Subtotal_Barang`) VALUES
('TR0001', '8997025914059', 2, 10000),
('TR0002', '8996129803504', 2, 8000),
('TR0003', '8998866500708', 2, 6000),
('TR0003', '8996129803504', 1, 4000),
('TR0004', '8997025914059', 1, 5000),
('TR0006', '8998866500708', 2, 6000),
('TR0008', '8998866107952', 1, 15000),
('TR0009', '8998866107952', 1, 15000),
('TR0010', '8997025914059', 1, 5000),
('TR0011', '8997025914059', 1, 5000),
('TR0012', '8996129803504', 1, 4000),
('TR0013', '8996129803504', 1, 4000),
('TR0014', '8996129803504', 1, 4000),
('TR0015', '8997025914059', 1, 5000),
('TR0016', '8998866107952', 1, 15000),
('TR0017', '8998866500708', 1, 3000),
('TR0017', '8998866107952', 1, 15000),
('TR0017', '8997025914059', 1, 5000),
('TR0017', '8996129803504', 1, 4000),
('TR0018', '8996129803504', 1, 4000),
('TR0018', '8997025914059', 1, 5000),
('TR0018', '8998866107952', 1, 15000),
('TR0018', '8998866500708', 1, 3000),
('TR0019', '8996129803504', 1, 4000),
('TR0019', '8997025914059', 1, 5000),
('TR0019', '8998866107952', 1, 15000),
('TR0019', '8998866500708', 1, 3000),
('TR0020', '8996129803504', 1, 4000),
('TR0020', '8997025914059', 1, 5000),
('TR0020', '8998866107952', 1, 15000),
('TR0020', '8998866500708', 1, 3000),
('TR0021', '8996129803504', 2, 8000),
('TR0021', '8997025914059', 2, 10000),
('TR0021', '8998866107952', 2, 30000),
('TR0024', '8991102230308', 1, 16000),
('TR0025', '8991102230308', 1, 8000),
('TR0026', '8996129803504', 1, 4000),
('TR0027', '8998866107952', 1, 15000),
('TR0029', '8991102230308', 5, 40000),
('TR0030', '8998866107952', 2, 30000),
('TR0030', '8991102230308', 1, 8000),
('TR0030', '8996129803504', 2, 8000),
('TR0031', '8997025914059', 2, 10000),
('TR0031', '8996129803504', 2, 8000),
('TR0031', '8998866500708', 5, 15000),
('TR0033', '8998866107952', 1, 15000),
('TR0033', '8996129803504', 1, 4000),
('TR0034', '8991102230308', 1, 8000),
('TR0035', '8998866107952', 1, 15000),
('TR0036', '8998866107952', 1, 15000),
('TR0037', '711844130111', 2, 24000),
('TR0040', '711844130111', 2, 24000),
('TR0041', '8998866107952', 1, 15000),
('TR0043', '8992775315095', 1, 7000),
('TR0044', '8992775315095', 1, 7000),
('TR0045', '8998866203401', 1, 3000),
('TR0046', '8996129803504', 1, 4000),
('TR0046', '8998866107952', 1, 15000),
('TR0047', '8998866203401', 1, 3000),
('TR0048', '8996129803504', 1, 4000),
('TR0048', '8991102230308', 1, 8000),
('TR0049', '8992775315095', 2, 14000);

--
-- Triggers `detail_transaksi_jual`
--
DELIMITER $$
CREATE TRIGGER `kurangiStock` AFTER INSERT ON `detail_transaksi_jual` FOR EACH ROW UPDATE barang
    SET Stok = Stok - NEW.Jumlah_Barang
    WHERE Kode_Barang = NEW.Kode_Barang
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `hutang`
--

CREATE TABLE `hutang` (
  `id_Hutang` int(11) NOT NULL,
  `Nama_Pelanggan` varchar(45) NOT NULL,
  `No_Telp` char(13) NOT NULL,
  `Alamat` varchar(45) NOT NULL,
  `Jumlah_Hutang` int(10) NOT NULL,
  `Kode_TransaksiJual` char(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `hutang`
--

INSERT INTO `hutang` (`id_Hutang`, `Nama_Pelanggan`, `No_Telp`, `Alamat`, `Jumlah_Hutang`, `Kode_TransaksiJual`) VALUES
(28, 'Farid', '88803722077', 'Jl. ikan Paus', 1000, 'TR0039'),
(32, 'Fian', '823456789', 'Jalan mastrip', 4000, 'TR0049');

-- --------------------------------------------------------

--
-- Table structure for table `jenis_barang`
--

CREATE TABLE `jenis_barang` (
  `id_JenisBarang` int(11) NOT NULL,
  `Jenis_Barang` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `jenis_barang`
--

INSERT INTO `jenis_barang` (`id_JenisBarang`, `Jenis_Barang`) VALUES
(1, 'Sembako'),
(2, 'Bumbu Dapurr'),
(3, 'Minuman Ringan'),
(4, 'Makanan Ringan'),
(5, 'Konsumsi Lainnya'),
(6, 'Keperluan Mandi dan Cuci');

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE `supplier` (
  `id_Supplier` int(11) NOT NULL,
  `Nama_Supplier` varchar(45) NOT NULL,
  `No_Telp` char(13) NOT NULL,
  `Alamat` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `supplier`
--

INSERT INTO `supplier` (`id_Supplier`, `Nama_Supplier`, `No_Telp`, `Alamat`) VALUES
(1, 'Bu Sari', '082345789123', 'Jalan Ikan Hiu, Kota Probolinggo'),
(2, 'Bu Luluk', '089987890344', 'Jalan Patiunus, Kota Probolinggo'),
(3, 'Pak Eko', '085876123654', 'Jalan Raya Bromo, Kota Probolinggo');

-- --------------------------------------------------------

--
-- Table structure for table `transaksi_beli`
--

CREATE TABLE `transaksi_beli` (
  `Kode_TransaksiBeli` char(6) NOT NULL,
  `Tanggal` date NOT NULL,
  `Total` int(11) NOT NULL,
  `Bayar` int(11) NOT NULL,
  `id_user` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `transaksi_beli`
--

INSERT INTO `transaksi_beli` (`Kode_TransaksiBeli`, `Tanggal`, `Total`, `Bayar`, `id_user`) VALUES
('TB0001', '2023-05-16', 100000, 100000, 1),
('TB0002', '2023-05-16', 60000, 60000, 1),
('TB0003', '2023-05-22', 0, 0, 1),
('TB0004', '2023-05-29', 30000, 50000, 1),
('TB0005', '2023-05-29', 36000, 40000, 1),
('TB0006', '2023-05-30', 4000, 5000, 1),
('TB0007', '2023-05-30', 15000, 20000, 1),
('TB0008', '2023-06-01', 34000, 35000, 1),
('TB0009', '2023-06-03', 27000, 30000, 1),
('TB0010', '2023-06-03', 12000, 15000, 1),
('TB0011', '2023-06-03', 12000, 12000, 1),
('TB0012', '2023-06-08', 204000, 210000, 1),
('TB0013', '2023-06-08', 15000, 15000, 1),
('TB0014', '2023-06-10', 6500, 10000, 1),
('TB0015', '2023-06-10', 6500, 10000, 1),
('TB0016', '2023-06-10', 4500, 5000, 1),
('TB0017', '2023-06-10', 2000, 2000, 1),
('TB0018', '2023-06-10', 4500, 5000, 1),
('TB0019', '2023-06-10', 2000, 2000, 1),
('TB0020', '2023-06-10', 5000, 5000, 1),
('TB0021', '2023-06-12', 950000, 1000000, 1),
('TB0022', '2023-06-13', 10000, 10000, 1),
('TB0023', '2023-06-13', 10000, 10000, 1),
('TB0024', '2023-06-23', 30000, 30000, 1);

-- --------------------------------------------------------

--
-- Table structure for table `transaksi_jual`
--

CREATE TABLE `transaksi_jual` (
  `Kode_TransaksiJual` char(6) NOT NULL,
  `Status_Pembayaran` enum('Lunas','Hutang') NOT NULL,
  `Tanggal` date NOT NULL,
  `Total` int(11) NOT NULL,
  `Bayar` int(11) NOT NULL,
  `id_user` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `transaksi_jual`
--

INSERT INTO `transaksi_jual` (`Kode_TransaksiJual`, `Status_Pembayaran`, `Tanggal`, `Total`, `Bayar`, `id_user`) VALUES
('TR0001', 'Lunas', '2023-06-01', 50000, 50000, 1),
('TR0002', 'Lunas', '2023-06-01', 28000, 30000, 1),
('TR0003', 'Lunas', '2023-06-01', 10000, 10000, 1),
('TR0004', 'Hutang', '2023-06-01', 5000, 2000, 1),
('TR0005', 'Hutang', '2023-06-01', 20000, 10000, 1),
('TR0006', 'Hutang', '2023-06-02', 6000, 5000, 1),
('TR0007', 'Lunas', '2023-06-02', 20000, 20000, 1),
('TR0008', 'Hutang', '2023-06-02', 15000, 10000, 1),
('TR0009', 'Hutang', '2023-06-02', 15000, 10000, 1),
('TR0010', 'Hutang', '2023-06-02', 5000, 4000, 1),
('TR0011', 'Hutang', '2023-06-02', 5000, 4000, 1),
('TR0012', 'Hutang', '2023-06-02', 4000, 2000, 1),
('TR0013', 'Hutang', '2023-06-02', 4000, 2000, 1),
('TR0014', 'Hutang', '2023-06-02', 4000, 2000, 1),
('TR0015', 'Hutang', '2023-06-02', 5000, 2000, 1),
('TR0016', 'Hutang', '2023-06-03', 15000, 10000, 1),
('TR0017', 'Lunas', '2023-06-08', 47000, 50000, 1),
('TR0018', 'Lunas', '2023-06-08', 47000, 50000, 1),
('TR0019', 'Hutang', '2023-06-08', 47000, 40000, 1),
('TR0020', 'Hutang', '2023-06-08', 47000, 40000, 1),
('TR0021', 'Lunas', '2023-06-08', 48000, 50000, 1),
('TR0022', 'Lunas', '2023-06-08', 20000, 20000, 1),
('TR0023', 'Lunas', '2024-06-08', 4000, 4000, 1),
('TR0024', 'Hutang', '2023-06-12', 16000, 2000, 2),
('TR0025', 'Hutang', '2023-06-12', 8000, 5000, 2),
('TR0026', 'Lunas', '2023-06-12', 4000, 4000, 2),
('TR0027', 'Hutang', '2023-06-12', 15000, 10000, 2),
('TR0028', 'Lunas', '2023-06-12', 0, 5000, 1),
('TR0029', 'Lunas', '2023-06-12', 40000, 50000, 1),
('TR0030', 'Lunas', '2023-06-12', 66000, 70000, 1),
('TR0031', 'Lunas', '2023-06-12', 168000, 200000, 1),
('TR0032', 'Lunas', '2023-06-12', 100000, 100000, 1),
('TR0033', 'Lunas', '2023-06-12', 19000, 20000, 1),
('TR0034', 'Hutang', '2023-06-12', 8000, 5000, 1),
('TR0035', 'Lunas', '2023-06-13', 15000, 15000, 1),
('TR0036', 'Hutang', '2023-06-13', 15000, 10000, 1),
('TR0037', 'Lunas', '2023-06-13', 24000, 25000, 1),
('TR0038', 'Hutang', '2023-06-13', 20000, 10000, 1),
('TR0039', 'Hutang', '2023-06-13', 20000, 10000, 1),
('TR0040', 'Lunas', '2023-06-13', 24000, 25000, 1),
('TR0041', 'Hutang', '2023-06-13', 15000, 10000, 1),
('TR0042', 'Hutang', '2023-06-16', 40000, 20000, 1),
('TR0043', 'Lunas', '2023-06-23', 7000, 10000, 2),
('TR0044', 'Lunas', '2023-06-23', 7000, 10000, 2),
('TR0045', 'Lunas', '2023-06-23', 3000, 3000, 1),
('TR0046', 'Hutang', '2023-06-23', 19000, 15000, 1),
('TR0047', 'Lunas', '2023-06-23', 3000, 50000, 1),
('TR0048', 'Hutang', '2023-06-23', 12000, 10000, 1),
('TR0049', 'Hutang', '2023-06-23', 14000, 10000, 1);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `Id_User` int(11) NOT NULL,
  `Username` varchar(25) NOT NULL,
  `Nama_User` varchar(255) DEFAULT NULL,
  `Email` varchar(255) DEFAULT NULL,
  `Password` varchar(20) DEFAULT NULL,
  `Level` enum('Admin','Kasir','Owner') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`Id_User`, `Username`, `Nama_User`, `Email`, `Password`, `Level`) VALUES
(1, 'adminku', 'Admin Farda', 'adminfarda@gmail.com', 'admin123', 'Admin'),
(2, 'kasirkun', 'Kasir Farda', 'kasirfarda@gmail.com', 'kasir123', 'Kasir'),
(3, 'ownerchan', 'Owner Farda', 'ownerfarda@gmail.com', 'owner123', 'Owner');

-- --------------------------------------------------------

--
-- Structure for view `barangpakeko`
--
DROP TABLE IF EXISTS `barangpakeko`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `barangpakeko`  AS SELECT `barang`.`Nama_Barang` AS `Nama_Barang` FROM `barang` WHERE `barang`.`id_Supplier` = '3''3'  ;

-- --------------------------------------------------------

--
-- Structure for view `databarang`
--
DROP TABLE IF EXISTS `databarang`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `databarang`  AS SELECT `b`.`Nama_Barang` AS `Nama_Barang`, `j`.`Jenis_Barang` AS `Jenis_Barang`, `s`.`Nama_Supplier` AS `Nama_Supplier` FROM ((`barang` `b` join `jenis_barang` `j` on(`b`.`id_JenisBarang` = `j`.`id_JenisBarang`)) join `supplier` `s` on(`b`.`id_Supplier` = `s`.`id_Supplier`))  ;

-- --------------------------------------------------------

--
-- Structure for view `databarangmurah`
--
DROP TABLE IF EXISTS `databarangmurah`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `databarangmurah`  AS SELECT `barang`.`Nama_Barang` AS `Nama_Barang`, `barang`.`Harga_Jual` AS `Harga_Jual` FROM `barang` WHERE `barang`.`Harga_Jual` <= 20002000  ;

-- --------------------------------------------------------

--
-- Structure for view `datadetailtransaksi`
--
DROP TABLE IF EXISTS `datadetailtransaksi`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `datadetailtransaksi`  AS SELECT `t`.`Kode_TransaksiJual` AS `Kode_TransaksiJual`, `t`.`Tanggal` AS `Tanggal`, `dt`.`Subtotal_Barang` AS `Subtotal_Barang` FROM (`transaksi_jual` `t` join `detail_transaksi_jual` `dt` on(`t`.`Kode_TransaksiJual` = `dt`.`Kode_TransaksiJual`))  ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `barang`
--
ALTER TABLE `barang`
  ADD PRIMARY KEY (`Kode_Barang`),
  ADD KEY `id_JenisBarang` (`id_JenisBarang`),
  ADD KEY `id_Supplier` (`id_Supplier`),
  ADD KEY `idJenisIndexView` (`id_JenisBarang`),
  ADD KEY `idSupplierIndexView` (`id_Supplier`);

--
-- Indexes for table `detail_transaksi_beli`
--
ALTER TABLE `detail_transaksi_beli`
  ADD KEY `id_transaksibeli` (`Kode_TransaksiBeli`),
  ADD KEY `Kode_Barang` (`Kode_Barang`);

--
-- Indexes for table `detail_transaksi_jual`
--
ALTER TABLE `detail_transaksi_jual`
  ADD KEY `id_Barang` (`Kode_Barang`),
  ADD KEY `Kode_TransaksiJual` (`Kode_TransaksiJual`),
  ADD KEY `KodeTransaksiIndexView` (`Kode_TransaksiJual`);

--
-- Indexes for table `hutang`
--
ALTER TABLE `hutang`
  ADD PRIMARY KEY (`id_Hutang`),
  ADD KEY `Kode_TransaksiJual` (`Kode_TransaksiJual`);

--
-- Indexes for table `jenis_barang`
--
ALTER TABLE `jenis_barang`
  ADD PRIMARY KEY (`id_JenisBarang`);

--
-- Indexes for table `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`id_Supplier`),
  ADD KEY `NamaIndexView` (`Nama_Supplier`);

--
-- Indexes for table `transaksi_beli`
--
ALTER TABLE `transaksi_beli`
  ADD PRIMARY KEY (`Kode_TransaksiBeli`),
  ADD KEY `id_user` (`id_user`);

--
-- Indexes for table `transaksi_jual`
--
ALTER TABLE `transaksi_jual`
  ADD PRIMARY KEY (`Kode_TransaksiJual`),
  ADD KEY `id_user` (`id_user`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`Id_User`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `hutang`
--
ALTER TABLE `hutang`
  MODIFY `id_Hutang` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT for table `jenis_barang`
--
ALTER TABLE `jenis_barang`
  MODIFY `id_JenisBarang` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `supplier`
--
ALTER TABLE `supplier`
  MODIFY `id_Supplier` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1149;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `Id_User` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `barang`
--
ALTER TABLE `barang`
  ADD CONSTRAINT `barang_ibfk_1` FOREIGN KEY (`id_Supplier`) REFERENCES `supplier` (`id_Supplier`) ON UPDATE CASCADE,
  ADD CONSTRAINT `barang_ibfk_2` FOREIGN KEY (`id_JenisBarang`) REFERENCES `jenis_barang` (`id_JenisBarang`) ON UPDATE CASCADE;

--
-- Constraints for table `detail_transaksi_beli`
--
ALTER TABLE `detail_transaksi_beli`
  ADD CONSTRAINT `detail_transaksi_beli_ibfk_2` FOREIGN KEY (`Kode_TransaksiBeli`) REFERENCES `transaksi_beli` (`Kode_TransaksiBeli`) ON UPDATE CASCADE,
  ADD CONSTRAINT `detail_transaksi_beli_ibfk_3` FOREIGN KEY (`Kode_Barang`) REFERENCES `barang` (`Kode_Barang`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `detail_transaksi_jual`
--
ALTER TABLE `detail_transaksi_jual`
  ADD CONSTRAINT `detail_transaksi_jual_ibfk_3` FOREIGN KEY (`Kode_TransaksiJual`) REFERENCES `transaksi_jual` (`Kode_TransaksiJual`) ON UPDATE CASCADE,
  ADD CONSTRAINT `detail_transaksi_jual_ibfk_4` FOREIGN KEY (`Kode_Barang`) REFERENCES `barang` (`Kode_Barang`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `hutang`
--
ALTER TABLE `hutang`
  ADD CONSTRAINT `hutang_ibfk_1` FOREIGN KEY (`Kode_TransaksiJual`) REFERENCES `transaksi_jual` (`Kode_TransaksiJual`) ON UPDATE CASCADE;

--
-- Constraints for table `transaksi_beli`
--
ALTER TABLE `transaksi_beli`
  ADD CONSTRAINT `transaksi_beli_ibfk_3` FOREIGN KEY (`id_user`) REFERENCES `user` (`Id_User`) ON UPDATE CASCADE;

--
-- Constraints for table `transaksi_jual`
--
ALTER TABLE `transaksi_jual`
  ADD CONSTRAINT `transaksi_jual_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `user` (`Id_User`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
