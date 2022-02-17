-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 16, 2022 at 07:43 AM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 8.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `project`
--

-- --------------------------------------------------------

--
-- Table structure for table `activity`
--

CREATE TABLE `activity` (
  `Acti_Id` int(11) NOT NULL,
  `Activity_Name` varchar(255) DEFAULT NULL,
  `proId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `activity`
--

INSERT INTO `activity` (`Acti_Id`, `Activity_Name`, `proId`) VALUES
(1, 'Mask', 1),
(2, 'Vitamin', 1),
(3, 'Medical Help', 1);

-- --------------------------------------------------------

--
-- Table structure for table `donation_details`
--

CREATE TABLE `donation_details` (
  `payment_Id` int(11) NOT NULL,
  `activity` varchar(255) DEFAULT NULL,
  `amount` double NOT NULL,
  `date` date DEFAULT NULL,
  `doner` varchar(255) DEFAULT NULL,
  `project_Name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `donation_details`
--

INSERT INTO `donation_details` (`payment_Id`, `activity`, `amount`, `date`, `doner`, `project_Name`) VALUES
(1, 'Mask', 1200, '2022-02-15', 'Mote', 'Covid-19'),
(2, 'Mask', 1250, '2022-02-16', 'Bhadji', 'Covid-19'),
(3, 'Mask', 125, '2022-02-16', 'ABC', 'Covid-19'),
(4, 'Mask', 13, '2022-02-16', 'adf', 'Covid-19'),
(5, 'Mask', 1, '2022-02-16', 'as1', 'Covid-19');

-- --------------------------------------------------------

--
-- Table structure for table `donor`
--

CREATE TABLE `donor` (
  `volId` int(11) NOT NULL,
  `volEmail` varchar(255) DEFAULT NULL,
  `volMob` bigint(20) NOT NULL,
  `volName` varchar(255) DEFAULT NULL,
  `volPass` varchar(255) DEFAULT NULL,
  `volUserId` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `donor`
--

INSERT INTO `donor` (`volId`, `volEmail`, `volMob`, `volName`, `volPass`, `volUserId`) VALUES
(1, 'Mahesh@gmail.com', 1234567890, 'Mahesh', 'Mahesh@123', 'mahe02'),
(2, 'ojas@Gmail.com', 9876543210, 'ojas', 'Ojas@123', 'ojas'),
(3, 'wakleatul6@gmail.com', 9767789525, 'Atul', 'Atul@1998', 'atul');

-- --------------------------------------------------------

--
-- Table structure for table `payment_release`
--

CREATE TABLE `payment_release` (
  `payment_Id` int(11) NOT NULL,
  `SchemeName` varchar(255) DEFAULT NULL,
  `activity` varchar(255) DEFAULT NULL,
  `amount` double NOT NULL,
  `date` date DEFAULT NULL,
  `project_Name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `payment_release`
--

INSERT INTO `payment_release` (`payment_Id`, `SchemeName`, `activity`, `amount`, `date`, `project_Name`) VALUES
(1, 'Covid-19', 'Mask', 1215, '2022-02-16', 'Covid-19');

-- --------------------------------------------------------

--
-- Table structure for table `project`
--

CREATE TABLE `project` (
  `project_Id` int(11) NOT NULL,
  `projectName` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `project`
--

INSERT INTO `project` (`project_Id`, `projectName`) VALUES
(1, 'Covid-19');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `uname` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `password`, `role`, `uname`) VALUES
(1, 'Atul@1998', 'Admin', 'atul'),
(2, 'Amol@123', 'Admin', 'amol'),
(3, 'Anil@123', 'Admin', 'anil'),
(4, 'Atul@1998', 'Admin', 'Atul');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `activity`
--
ALTER TABLE `activity`
  ADD PRIMARY KEY (`Acti_Id`);

--
-- Indexes for table `donation_details`
--
ALTER TABLE `donation_details`
  ADD PRIMARY KEY (`payment_Id`);

--
-- Indexes for table `donor`
--
ALTER TABLE `donor`
  ADD PRIMARY KEY (`volId`);

--
-- Indexes for table `payment_release`
--
ALTER TABLE `payment_release`
  ADD PRIMARY KEY (`payment_Id`);

--
-- Indexes for table `project`
--
ALTER TABLE `project`
  ADD PRIMARY KEY (`project_Id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `activity`
--
ALTER TABLE `activity`
  MODIFY `Acti_Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `donation_details`
--
ALTER TABLE `donation_details`
  MODIFY `payment_Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `payment_release`
--
ALTER TABLE `payment_release`
  MODIFY `payment_Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `project`
--
ALTER TABLE `project`
  MODIFY `project_Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
