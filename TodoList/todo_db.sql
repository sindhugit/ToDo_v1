-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Nov 19, 2017 at 04:35 PM
-- Server version: 5.6.34-log
-- PHP Version: 7.1.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `todo_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `assign_task`
--

CREATE TABLE `assign_task` (
  `fromuser` varchar(100) NOT NULL,
  `taskname` varchar(100) NOT NULL,
  `taskdetails` varchar(100) NOT NULL,
  `touser` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `assign_task`
--

INSERT INTO `assign_task` (`fromuser`, `taskname`, `taskdetails`, `touser`) VALUES
('user1', 'Apps', 'Drawing app', 'test'),
('test', 'tfgg', 'yghuh', 'user1'),
('test', 'Movie', 'Go Movie', 'user1');

-- --------------------------------------------------------

--
-- Table structure for table `list_table`
--

CREATE TABLE `list_table` (
  `username` varchar(100) NOT NULL,
  `listname` varchar(100) NOT NULL,
  `items` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `list_table`
--

INSERT INTO `list_table` (`username`, `listname`, `items`) VALUES
('user1', 'Grocery', 'Rice'),
('test', 'Movie', 'watch Movie');

-- --------------------------------------------------------

--
-- Table structure for table `todo_user_details`
--

CREATE TABLE `todo_user_details` (
  `email` varchar(100) NOT NULL,
  `password` varchar(30) NOT NULL,
  `profile_name` varchar(100) NOT NULL,
  `question` varchar(100) NOT NULL,
  `answer` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `todo_user_details`
--

INSERT INTO `todo_user_details` (`email`, `password`, `profile_name`, `question`, `answer`) VALUES
('test', 'test', 'testp', 'what is your pet name?', 'test'),
('user1', 'user1', 'userp', 'what is your pet name?', 'user1'),
('user2', 'user2', 'user2p', 'what is your pet name?', 'user2');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `todo_user_details`
--
ALTER TABLE `todo_user_details`
  ADD PRIMARY KEY (`email`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
