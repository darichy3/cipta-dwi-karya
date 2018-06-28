-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 28 Jun 2018 pada 14.59
-- Versi Server: 10.1.28-MariaDB
-- PHP Version: 7.1.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_ciptadwikarya`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `customers`
--

CREATE TABLE `customers` (
  `id_customer` int(10) NOT NULL,
  `name` varchar(30) NOT NULL,
  `address` varchar(255) NOT NULL,
  `phone` bigint(13) NOT NULL,
  `created_date` date NOT NULL,
  `created_by` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `customers`
--

INSERT INTO `customers` (`id_customer`, `name`, `address`, `phone`, `created_date`, `created_by`) VALUES
(1, 'Paijo', 'Kemang, Jl. Kemang Barat No. 150', 628567891111, '2018-06-23', 'darichy'),
(2, 'Darichy', 'Jl. Musyawarah No. 5A, Rt. 008/Rw. 01,Kel. Ragunan, Kec. Pasar Minggu', 6282212345678, '2018-06-24', 'darichy'),
(3, 'Oejho', 'Jl. Kampung Utan No. 30', 628123456789, '2018-06-24', 'Admin');

-- --------------------------------------------------------

--
-- Struktur dari tabel `inventory`
--

CREATE TABLE `inventory` (
  `id_inventory` int(5) NOT NULL,
  `name` varchar(30) NOT NULL,
  `sum_in` int(5) NOT NULL,
  `sum_out` int(5) NOT NULL,
  `sum_end` int(5) NOT NULL,
  `date_in` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `note` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `inventory`
--

INSERT INTO `inventory` (`id_inventory`, `name`, `sum_in`, `sum_out`, `sum_end`, `date_in`, `note`) VALUES
(1, 'Buku', 10, 0, 10, '2018-06-23 01:13:41', 'BUku tulis @pack'),
(2, 'Meja', 100, 0, 0, '2018-06-27 22:43:26', 'Meja lipat @unit');

-- --------------------------------------------------------

--
-- Struktur dari tabel `roles`
--

CREATE TABLE `roles` (
  `id_roles` int(11) NOT NULL,
  `role` varchar(15) DEFAULT NULL,
  `id_user` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `roles`
--

INSERT INTO `roles` (`id_roles`, `role`, `id_user`) VALUES
(1, 'ROLE_ADMIN', 1),
(2, 'ROLE_ADMIN', 2),
(3, 'ROLE_ADMIN', 10),
(4, 'ROLE_ADMIN', 12);

-- --------------------------------------------------------

--
-- Struktur dari tabel `status`
--

CREATE TABLE `status` (
  `id_status` int(11) NOT NULL,
  `name` varchar(30) NOT NULL,
  `note` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `status`
--

INSERT INTO `status` (`id_status`, `name`, `note`) VALUES
(1, 'Open Order', 'Ketika create transaksi'),
(2, 'Process Order', 'Ketika sedang dalam persiapan pengiriman'),
(3, 'Delivered', 'Ketika pengiriman sudah di proses'),
(4, 'Close Order', 'Ketika Transaksi sudah slesai');

-- --------------------------------------------------------

--
-- Struktur dari tabel `transaction`
--

CREATE TABLE `transaction` (
  `id_transaction` int(10) NOT NULL,
  `transaction_date` date NOT NULL,
  `delivery_date` date NOT NULL,
  `quantity` int(10) NOT NULL,
  `id_user` int(10) NOT NULL,
  `id_inventory` int(5) NOT NULL,
  `id_customer` int(10) NOT NULL,
  `id_status` int(5) NOT NULL,
  `note` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `transaction`
--

INSERT INTO `transaction` (`id_transaction`, `transaction_date`, `delivery_date`, `quantity`, `id_user`, `id_inventory`, `id_customer`, `id_status`, `note`) VALUES
(1, '2018-06-23', '2018-06-30', 5, 2, 1, 1, 1, 'coba 1'),
(2, '2018-06-28', '2018-06-29', 13, 2, 1, 3, 2, 'Order untuk keperluan sd'),
(3, '2018-06-28', '2018-06-28', 50, 2, 1, 1, 3, 'coba input'),
(4, '2018-06-28', '2018-06-30', 10, 2, 2, 2, 1, 'Pesan meja lipat bergambar');

-- --------------------------------------------------------

--
-- Struktur dari tabel `users`
--

CREATE TABLE `users` (
  `id_user` int(10) NOT NULL,
  `username` varchar(15) NOT NULL,
  `name` varchar(30) NOT NULL,
  `password` varchar(32) NOT NULL,
  `enable` tinyint(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `users`
--

INSERT INTO `users` (`id_user`, `username`, `name`, `password`, `enable`) VALUES
(1, 'admin', 'Admin', 'admin', 1),
(2, 'darichy', 'darichy', '123456', 1),
(12, 'yus', 'yus aja', 'subakti', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customers`
--
ALTER TABLE `customers`
  ADD PRIMARY KEY (`id_customer`);

--
-- Indexes for table `inventory`
--
ALTER TABLE `inventory`
  ADD PRIMARY KEY (`id_inventory`);

--
-- Indexes for table `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`id_roles`);

--
-- Indexes for table `status`
--
ALTER TABLE `status`
  ADD PRIMARY KEY (`id_status`);

--
-- Indexes for table `transaction`
--
ALTER TABLE `transaction`
  ADD PRIMARY KEY (`id_transaction`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id_user`),
  ADD UNIQUE KEY `username` (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customers`
--
ALTER TABLE `customers`
  MODIFY `id_customer` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `inventory`
--
ALTER TABLE `inventory`
  MODIFY `id_inventory` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `roles`
--
ALTER TABLE `roles`
  MODIFY `id_roles` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `status`
--
ALTER TABLE `status`
  MODIFY `id_status` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `transaction`
--
ALTER TABLE `transaction`
  MODIFY `id_transaction` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id_user` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
