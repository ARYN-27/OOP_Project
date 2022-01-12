-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 12, 2022 at 07:44 PM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 8.0.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `library`
--

-- --------------------------------------------------------

--
-- Table structure for table `books`
--

CREATE TABLE `books` (
  `BookID` int(11) NOT NULL,
  `BookName` varchar(50) NOT NULL,
  `Genre` varchar(10) NOT NULL,
  `Author` varchar(30) DEFAULT NULL,
  `Publisher` varchar(30) DEFAULT NULL,
  `Shelf` varchar(5) NOT NULL,
  `Row` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `books`
--

INSERT INTO `books` (`BookID`, `BookName`, `Genre`, `Author`, `Publisher`, `Shelf`, `Row`) VALUES
(1, 'Beginning Programming All-in-One Desk Reference Fo', 'Education', 'Wallace Wang', 'For Dummies', 'A', '1'),
(2, 'Think Like A Programmer', 'Education', 'V. Anton Spraul', 'No Starch Press', 'A', '2'),
(3, 'Clean Code', 'Education', 'Robert Cecil Martin', 'Pearson', 'A', '3'),
(4, 'Learn Python the Hard Way: A Very Simple Introduct', 'Education', 'Zed Shaw', 'Addison-Wesley Professional', 'A', '4'),
(5, 'The C Programming Language. 2nd Edition', 'Education', 'Brian Kernighan and Dennis Rit', 'Pearson', 'A', '5'),
(6, 'Head First Java, 2nd Edition', 'Education', 'Kathy Sierra and Bert Bates', 'O Reilly Media', 'A', '6'),
(7, 'Java: A Beginners Guide, Eighth Edition', 'Education', 'Herbert Schildt', 'McGraw Hill', 'A', '7'),
(8, 'Think Java : How to Think Like a Computer Scientis', 'Education', 'Allen B Downey and Chris Mayfi', 'O Reilly Media', 'A', '8'),
(9, 'Learn Java The Easy Way : A Hands-On Introduction ', 'Education', 'Bryson Payne', 'No Starch Press', 'A', '9'),
(10, 'Optimizing Java : Practical techniques for improvi', 'Education', 'Benjamin J. Evans ,James Gough', 'O Reilly Media', 'A', '10'),
(11, 'C++ Crash Course : A Fast-Paced Introduction', 'Education', 'Joshua Alfred Lospinoso', 'No Starch Press', 'A', '11');

-- --------------------------------------------------------

--
-- Table structure for table `book_count`
--

CREATE TABLE `book_count` (
  `BookNo` int(11) DEFAULT 0,
  `UserID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `book_count`
--

INSERT INTO `book_count` (`BookNo`, `UserID`) VALUES
(1, 1),
(2, 2),
(0, 3),
(0, 4),
(0, 5),
(0, 6),
(0, 7),
(0, 8);

-- --------------------------------------------------------

--
-- Table structure for table `fullname`
--

CREATE TABLE `fullname` (
  `UserID` int(11) DEFAULT NULL,
  `FirstName` varchar(30) NOT NULL,
  `LastName` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `issuedbook`
--

CREATE TABLE `issuedbook` (
  `BookID` int(11) NOT NULL,
  `MatricsNo` varchar(8) NOT NULL,
  `IssueDate` date NOT NULL,
  `ReturnDate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `issuedbook`
--

INSERT INTO `issuedbook` (`BookID`, `MatricsNo`, `IssueDate`, `ReturnDate`) VALUES
(1, 'test6', '2022-01-13', '2022-01-28');

-- --------------------------------------------------------

--
-- Table structure for table `librarian`
--

CREATE TABLE `librarian` (
  `LibrarianID` int(11) NOT NULL,
  `FullName` varchar(30) NOT NULL,
  `UserName` varchar(30) NOT NULL,
  `Password` varchar(30) NOT NULL,
  `Email` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `librarian`
--

INSERT INTO `librarian` (`LibrarianID`, `FullName`, `UserName`, `Password`, `Email`) VALUES
(1, 'Enco Sier', 'Encosier', '1234', 'enco.cs.doc@gmail.com'),
(2, 'Leloush Britannia', 'Zero', '9876', 'leloush.zero@bitannia.com');

-- --------------------------------------------------------

--
-- Table structure for table `publisher`
--

CREATE TABLE `publisher` (
  `PublisherID` int(11) NOT NULL,
  `PublisherName` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `publisher`
--

INSERT INTO `publisher` (`PublisherID`, `PublisherName`) VALUES
(1, 'hjkhdkj'),
(2, 'Pottermore'),
(3, 'dsd'),
(4, 'Whittaker'),
(5, 'ewhkje'),
(6, 'dhskj'),
(7, 'hkjdfh'),
(8, 'gsjf'),
(9, 'dshh'),
(10, 'gdsh'),
(11, 'Water'),
(12, 'ew'),
(13, 'dgjs'),
(14, 'SGAJ'),
(15, 'WHOKNOW'),
(16, 'Doubleday'),
(17, 'Pearson'),
(18, 'McGraw'),
(19, 'Klett'),
(20, 'Pushpalata'),
(21, 'Cambridge'),
(22, 'TMH');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `UserID` int(11) NOT NULL,
  `UserPass` varchar(30) NOT NULL,
  `RegDate` date NOT NULL,
  `UserName` varchar(30) NOT NULL,
  `Email` varchar(30) NOT NULL,
  `MatricsNo` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`UserID`, `UserPass`, `RegDate`, `UserName`, `Email`, `MatricsNo`) VALUES
(1, 'test1', '2012-05-15', 'Test1', 'test1@gmail.com', 'CI200028'),
(2, 'test2', '2016-11-07', 'Test2', 'test2@gmail.com', 'CI200016'),
(3, 'test3', '2016-11-25', 'test3', 'test3@gmail.com', 'CI200025'),
(5, 'test4', '2022-01-12', 'test4', 'test4', NULL),
(6, 'test5', '2022-01-13', 'test5', 'test5', 'test5'),
(7, 'test6', '2022-01-13', 'test6', 'test6', 'test6'),
(8, 'test7', '2022-01-13', 'test7', 'test7', 'AI200028');

--
-- Triggers `users`
--
DELIMITER $$
CREATE TRIGGER `Users_AFTER_INSERT` AFTER INSERT ON `users` FOR EACH ROW BEGIN
INSERT INTO Book_Count
values(0,New.UserID);
END
$$
DELIMITER ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `books`
--
ALTER TABLE `books`
  ADD PRIMARY KEY (`BookID`);

--
-- Indexes for table `librarian`
--
ALTER TABLE `librarian`
  ADD PRIMARY KEY (`LibrarianID`);

--
-- Indexes for table `publisher`
--
ALTER TABLE `publisher`
  ADD PRIMARY KEY (`PublisherID`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`UserID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `books`
--
ALTER TABLE `books`
  MODIFY `BookID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `librarian`
--
ALTER TABLE `librarian`
  MODIFY `LibrarianID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `publisher`
--
ALTER TABLE `publisher`
  MODIFY `PublisherID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `UserID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
