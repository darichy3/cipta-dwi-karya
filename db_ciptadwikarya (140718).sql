-- phpMyAdmin SQL Dump
-- version 3.4.5
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Waktu pembuatan: 14. Juli 2018 jam 06:00
-- Versi Server: 5.5.16
-- Versi PHP: 5.3.8

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `db_ciptadwikarya`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `customers`
--

CREATE TABLE IF NOT EXISTS `customers` (
  `id_customer` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `address` varchar(255) NOT NULL,
  `phone` bigint(13) NOT NULL,
  `created_date` date NOT NULL,
  `created_by` varchar(30) NOT NULL,
  PRIMARY KEY (`id_customer`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

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

CREATE TABLE IF NOT EXISTS `inventory` (
  `id_inventory` int(5) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `price_buy` int(7) NOT NULL,
  `price_sell` int(7) NOT NULL,
  `sum_in` int(5) NOT NULL,
  `sum_out` int(5) NOT NULL,
  `sum_end` int(5) NOT NULL,
  `date_in` date NOT NULL,
  `note` varchar(100) NOT NULL,
  PRIMARY KEY (`id_inventory`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data untuk tabel `inventory`
--

INSERT INTO `inventory` (`id_inventory`, `name`, `price_buy`, `price_sell`, `sum_in`, `sum_out`, `sum_end`, `date_in`, `note`) VALUES
(1, 'Buku', 10000, 15000, 1000, 330, 670, '2018-07-01', 'Buku'),
(2, 'Meja', 200000, 250000, 100, 100, 0, '2018-06-29', 'Meja lipat @unit'),
(3, 'Payung', 40000, 55000, 500, 0, 0, '2018-06-28', '@pcs');

-- --------------------------------------------------------

--
-- Struktur dari tabel `roles`
--

CREATE TABLE IF NOT EXISTS `roles` (
  `id_roles` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(15) DEFAULT NULL,
  `id_user` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_roles`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

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

CREATE TABLE IF NOT EXISTS `status` (
  `id_status` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `note` text NOT NULL,
  PRIMARY KEY (`id_status`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

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

CREATE TABLE IF NOT EXISTS `transaction` (
  `id_transaction` int(10) NOT NULL AUTO_INCREMENT,
  `transaction_date` date NOT NULL,
  `delivery_date` date NOT NULL,
  `no_surat_jalan` varchar(15) NOT NULL,
  `tgl_surat_jalan` date NOT NULL,
  `quantity` int(10) NOT NULL,
  `id_user` int(10) NOT NULL,
  `id_inventory` int(5) NOT NULL,
  `id_customer` int(10) NOT NULL,
  `id_status` int(5) NOT NULL,
  `note` varchar(255) NOT NULL,
  PRIMARY KEY (`id_transaction`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=20 ;

--
-- Dumping data untuk tabel `transaction`
--

INSERT INTO `transaction` (`id_transaction`, `transaction_date`, `delivery_date`, `no_surat_jalan`, `tgl_surat_jalan`, `quantity`, `id_user`, `id_inventory`, `id_customer`, `id_status`, `note`) VALUES
(11, '2018-07-01', '2018-07-01', 'SJ/011/2018', '2018-07-01', 100, 1, 1, 3, 4, 'Harap konfirmasi sebelum kirim'),
(12, '2018-07-01', '2018-07-02', 'SJ/012/2018', '2018-07-01', 100, 1, 1, 4, 4, 'konfirmasi ekspedisi'),
(13, '2018-07-01', '2018-07-01', 'SJ/013/2018', '2018-07-01', 100, 1, 1, 5, 4, 'Harap konfirmasi sebelum kirim'),
(14, '2018-07-01', '2018-07-03', 'SJ/014/2018', '2018-07-01', 100, 1, 1, 5, 1, 'packing dengan baik'),
(15, '2018-07-01', '2018-07-02', 'SJ/015/2018', '2018-07-01', 100, 1, 1, 6, 1, 'Harap konfirmasi sebelum kirim'),
(16, '2018-07-02', '2018-07-02', 'SJ/016/2018', '2018-07-02', 100, 1, 1, 3, 1, 'Harap konfirmasi sebelum kirim'),
(17, '2018-07-03', '2018-07-04', 'SJ/017/2018', '2018-07-03', 100, 1, 1, 4, 1, '@pcs'),
(18, '2018-07-04', '2018-07-04', '', '2018-07-04', 100, 1, 2, 4, 1, 'ke ekspedisi maju jaya, kalideres blok b '),
(19, '2018-07-08', '2018-07-08', 'SJ/019/2018', '2018-07-08', 30, 1, 1, 6, 1, 'Harap konfirmasi sebelum kirim');

-- --------------------------------------------------------

--
-- Struktur dari tabel `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `id_user` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(15) NOT NULL,
  `name` varchar(30) NOT NULL,
  `password` varchar(32) NOT NULL,
  `enable` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id_user`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=14 ;

--
-- Dumping data untuk tabel `users`
--

INSERT INTO `users` (`id_user`, `username`, `name`, `password`, `enable`) VALUES
(1, 'admin', 'Admin', 'admin', 1),
(13, 'nella', 'nella', 'nella', 1);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
