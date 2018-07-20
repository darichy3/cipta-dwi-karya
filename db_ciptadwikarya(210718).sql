-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 21 Jul 2018 pada 00.48
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
(3, 'Oejho', 'Jl. Kampung Utan No. 30, lebak bulus', 628123456788, '2018-06-24', 'admin'),
(4, 'PT Gudang Garam', 'jalan taman nusa bakti blok a nomor 12 ', 21, '2018-06-30', 'nella'),
(5, 'PT Modera', 'Jalan kamal raya blok b ', 5555559, '2018-07-01', 'admin'),
(6, 'toko selaras', 'jalan muara karang blok g nomor 12', 54566714, '2018-07-01', 'admin');

-- --------------------------------------------------------

--
-- Struktur dari tabel `inventory`
--

CREATE TABLE `inventory` (
  `id_inventory` int(5) NOT NULL,
  `name` varchar(30) NOT NULL,
  `price_buy` int(7) NOT NULL,
  `price_sell` int(7) NOT NULL,
  `sum_in` int(5) NOT NULL,
  `sum_out` int(5) NOT NULL,
  `sum_end` int(5) NOT NULL,
  `date_in` date NOT NULL,
  `note` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `inventory`
--

INSERT INTO `inventory` (`id_inventory`, `name`, `price_buy`, `price_sell`, `sum_in`, `sum_out`, `sum_end`, `date_in`, `note`) VALUES
(1, 'Buku gambar', 14000, 20000, 1000, 210, 790, '2018-07-01', 'Buku Gambar'),
(2, 'Meja', 200000, 250000, 100, 40, 60, '2018-06-29', 'Meja lipat @unit'),
(3, 'Payung', 40000, 55000, 500, 0, 500, '2018-06-28', '@pcs'),
(4, 'Printer', 800000, 1000000, 20, 0, 20, '2018-07-15', 'new'),
(5, 'Pulpen', 2000, 4000, 5000, 0, 5000, '2018-07-17', 'standart satuan');

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
(4, 'ROLE_ADMIN', 12),
(5, 'ROLE_ADMIN', 13),
(6, 'ROLE_ADMIN', 14),
(7, 'ROLE_ADMIN', 15),
(8, 'ROLE_ADMIN', 14);

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
(4, 'Close Order', 'Ketika Transaksi sudah slesai'),
(5, 'Retur', 'Untuk menu retur');

-- --------------------------------------------------------

--
-- Struktur dari tabel `transaction`
--

CREATE TABLE `transaction` (
  `id_transaction` int(10) NOT NULL,
  `transaction_date` date NOT NULL,
  `delivery_date` date NOT NULL,
  `no_surat_jalan` varchar(15) NOT NULL,
  `tgl_surat_jalan` date NOT NULL,
  `quantity` int(10) NOT NULL,
  `total_harga` int(20) NOT NULL,
  `id_user` int(10) NOT NULL,
  `id_inventory` int(5) NOT NULL,
  `id_customer` int(10) NOT NULL,
  `id_status` int(5) NOT NULL,
  `note` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `transaction`
--

INSERT INTO `transaction` (`id_transaction`, `transaction_date`, `delivery_date`, `no_surat_jalan`, `tgl_surat_jalan`, `quantity`, `total_harga`, `id_user`, `id_inventory`, `id_customer`, `id_status`, `note`) VALUES
(11, '2018-07-01', '2018-07-01', 'SJ/011/2018', '2018-07-01', 100, 0, 1, 1, 3, 4, 'Harap konfirmasi sebelum kirim'),
(12, '2018-07-01', '2018-07-02', 'SJ/012/2018', '2018-07-01', 100, 0, 1, 1, 4, 4, 'konfirmasi ekspedisi'),
(13, '2018-07-01', '2018-07-01', 'SJ/013/2018', '2018-07-01', 100, 0, 1, 1, 5, 4, 'Harap konfirmasi sebelum kirim'),
(14, '2018-07-01', '2018-07-03', 'SJ/014/2018', '2018-07-01', 100, 0, 1, 1, 5, 1, 'packing dengan baik'),
(15, '2018-07-01', '2018-07-02', 'SJ/015/2018', '2018-07-01', 100, 0, 1, 1, 6, 1, 'Harap konfirmasi sebelum kirim'),
(16, '2018-07-02', '2018-07-02', 'SJ/016/2018', '2018-07-02', 100, 0, 1, 1, 3, 1, 'Harap konfirmasi sebelum kirim'),
(17, '2018-07-03', '2018-07-04', 'SJ/017/2018', '2018-07-03', 100, 0, 1, 1, 4, 1, '@pcs'),
(18, '2018-07-04', '2018-07-04', '', '2018-07-04', 100, 0, 1, 2, 4, 1, 'ke ekspedisi maju jaya, kalideres blok b '),
(19, '2018-07-08', '2018-07-08', 'SJ/019/2018', '2018-07-08', 30, 0, 1, 1, 6, 1, 'Harap konfirmasi sebelum kirim'),
(20, '2018-07-15', '2018-07-16', '', '2018-07-15', -100, -2000000, 1, 1, 5, 5, 'Order untuk keperluan sd'),
(21, '2018-07-15', '2018-07-17', '', '2018-07-15', -5, -5000000, 1, 4, 3, 5, 'Untuk warnet'),
(22, '2018-07-15', '2018-07-17', '', '2018-07-15', -20, -5000000, 1, 2, 5, 5, 'buat kantor'),
(23, '2018-07-15', '2018-07-20', '', '2018-07-15', -300, -16500000, 1, 3, 6, 5, 'Reseller'),
(24, '2018-07-15', '2018-07-24', '', '2018-07-15', 10, 200000, 1, 1, 3, 1, 'beliin anak'),
(25, '2018-07-17', '2018-07-18', '', '2018-07-17', 500, 2000000, 1, 5, 3, 5, 'sesuai jumlah');

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
(13, 'nella', 'nella', 'nella', 1);

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
  MODIFY `id_customer` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `inventory`
--
ALTER TABLE `inventory`
  MODIFY `id_inventory` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `roles`
--
ALTER TABLE `roles`
  MODIFY `id_roles` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `status`
--
ALTER TABLE `status`
  MODIFY `id_status` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `transaction`
--
ALTER TABLE `transaction`
  MODIFY `id_transaction` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id_user` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
