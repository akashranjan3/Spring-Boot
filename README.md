#sql queries 


-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jul 19, 2024 at 08:26 AM
-- Server version: 8.0.31
-- PHP Version: 8.0.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `learnspring`
--

-- --------------------------------------------------------

--
-- Table structure for table `authorities`
--

DROP TABLE IF EXISTS `authorities`;
CREATE TABLE IF NOT EXISTS `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `authorities_idx_1` (`username`,`authority`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `authorities`
--

INSERT INTO `authorities` (`username`, `authority`) VALUES
('ram', 'ROLE_EMPLOYEE'),
('shiv', 'ROLE_ADMIN'),
('shiv', 'ROLE_EMPLOYEE'),
('shiv', 'ROLE_MANAGER'),
('sita', 'ROLE_EMPLOYEE'),
('sita', 'ROLE_MANAGER');

-- --------------------------------------------------------

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
CREATE TABLE IF NOT EXISTS `course` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(128) DEFAULT NULL,
  `instructor_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `TITLE_UNIQUE` (`title`),
  KEY `FK_INSTRUCTOR_idx` (`instructor_id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `course`
--

INSERT INTO `course` (`id`, `title`, `instructor_id`) VALUES
(22, 'hindi', NULL),
(24, 'korean', NULL),
(25, 'bengali', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `course_student`
--

DROP TABLE IF EXISTS `course_student`;
CREATE TABLE IF NOT EXISTS `course_student` (
  `course_id` int NOT NULL,
  `student_id` int NOT NULL,
  PRIMARY KEY (`course_id`,`student_id`),
  KEY `FK_STUDENT_idx` (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `course_student`
--

INSERT INTO `course_student` (`course_id`, `student_id`) VALUES
(22, 1);

-- --------------------------------------------------------

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
CREATE TABLE IF NOT EXISTS `department` (
  `id` int NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
CREATE TABLE IF NOT EXISTS `employee` (
  `department_id` int DEFAULT NULL,
  `id` int NOT NULL,
  `salary` int NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKbejtwvg9bxus2mffsm3swj3u9` (`department_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `employee2`
--

DROP TABLE IF EXISTS `employee2`;
CREATE TABLE IF NOT EXISTS `employee2` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee2`
--

INSERT INTO `employee2` (`id`, `first_name`, `last_name`, `email`) VALUES
(1, 'Leslie', 'Andrews', 'leslie@luv2code.com'),
(2, 'Emma', 'Baumgarten', 'emma@luv2code.com'),
(3, 'Avani', 'Gupta', 'avani@luv2code.com'),
(4, 'Yuri', 'Petrov', 'yuri@luv2code.com'),
(5, 'Juan', 'Vega', 'juan@luv2code.com'),
(6, 'Amit', 'Mishra', 'mishra@luv2code.com'),
(7, 'Virat', 'Kohli', 'Kohli@luv2code.com'),
(10, 'king', 'kohli', 'king@luv2code.com');

-- --------------------------------------------------------

--
-- Table structure for table `employee3`
--

DROP TABLE IF EXISTS `employee3`;
CREATE TABLE IF NOT EXISTS `employee3` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee3`
--

INSERT INTO `employee3` (`id`, `first_name`, `last_name`, `email`) VALUES
(2, 'Emma ndsi', 'Baumgarten m i ', 'emma@luv2code.com'),
(4, 'Yuri', 'Petrov', 'yuri@luv2code.com'),
(5, 'Juan', 'Vega', 'juan@luv2code.com'),
(6, 'Amit', 'Mishra', 'mishra@luv2code.com'),
(7, 'rahul', 'dravin', 'rahul@luv2code.com'),
(10, 'mister', 'mean', 'mean@luv2code.com'),
(11, 'rahul', 'dravin', 'rahul@luv2code.com'),
(12, 'man', 'veer', 'manveer@luv2code.com'),
(13, 'verno', 'kumar ', 'leslie@luv2code.com');

-- --------------------------------------------------------

--
-- Table structure for table `employeethyme`
--

DROP TABLE IF EXISTS `employeethyme`;
CREATE TABLE IF NOT EXISTS `employeethyme` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employeethyme`
--

INSERT INTO `employeethyme` (`id`, `first_name`, `last_name`, `email`) VALUES
(4, 'Yuri', 'Petrov', 'yuri@luv2code.com'),
(5, 'Juan', 'Vega', 'juan@luv2code.com'),
(6, 'Amit', 'Mishra', 'mishra@luv2code.com'),
(7, 'rahul', 'dravin', 'rahulraja@luv2code.com'),
(10, 'ram', 'laka', 'ta@fi'),
(11, 'rahul', 'dravin', 'rahul@luv2code.com'),
(12, 'man', 'veer', 'manveer@luv2code.com'),
(13, 'verAkas', 'kumar ', 'leslie@luv2code.com'),
(16, 'ram', 'mokan', 'ji@ham');

-- --------------------------------------------------------

--
-- Table structure for table `instructor`
--

DROP TABLE IF EXISTS `instructor`;
CREATE TABLE IF NOT EXISTS `instructor` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `instructor_detail_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_DETAIL_idx` (`instructor_detail_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `instructor_detail`
--

DROP TABLE IF EXISTS `instructor_detail`;
CREATE TABLE IF NOT EXISTS `instructor_detail` (
  `id` int NOT NULL AUTO_INCREMENT,
  `youtube_channel` varchar(128) DEFAULT NULL,
  `hobby` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `instructor_detail`
--

INSERT INTO `instructor_detail` (`id`, `youtube_channel`, `hobby`) VALUES
(8, 'youtube.com/pp', 'Ludo'),
(12, 'youtube.com/ram', 'Ludo');

-- --------------------------------------------------------

--
-- Table structure for table `learn`
--

DROP TABLE IF EXISTS `learn`;
CREATE TABLE IF NOT EXISTS `learn` (
  `name` varchar(10) NOT NULL,
  `dob` varchar(10) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `member_security`
--

DROP TABLE IF EXISTS `member_security`;
CREATE TABLE IF NOT EXISTS `member_security` (
  `user_id` varchar(50) NOT NULL,
  `pw` char(68) NOT NULL,
  `active` tinyint NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `member_security`
--

INSERT INTO `member_security` (`user_id`, `pw`, `active`) VALUES
('akash', '{noop}ranjan', 1),
('john', '{noop}test123', 1),
('mary', '{noop}test123', 1),
('ram', '{noop}singh', 1),
('susan', '{noop}test123', 1);

-- --------------------------------------------------------

--
-- Table structure for table `review`
--

DROP TABLE IF EXISTS `review`;
CREATE TABLE IF NOT EXISTS `review` (
  `id` int NOT NULL AUTO_INCREMENT,
  `comment` varchar(256) DEFAULT NULL,
  `course_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_COURSE_ID_idx` (`course_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `roles_security`
--

DROP TABLE IF EXISTS `roles_security`;
CREATE TABLE IF NOT EXISTS `roles_security` (
  `user_id` varchar(50) NOT NULL,
  `role` varchar(50) NOT NULL,
  UNIQUE KEY `authorities5_idx_1` (`user_id`,`role`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `roles_security`
--

INSERT INTO `roles_security` (`user_id`, `role`) VALUES
('akash', 'ROLE_ADMIN'),
('akash', 'ROLE_EMPLOYE'),
('john', 'ROLE_EMPLOYEE'),
('mary', 'ROLE_EMPLOYEE'),
('mary', 'ROLE_MANAGER'),
('susan', 'ROLE_ADMIN'),
('susan', 'ROLE_EMPLOYEE'),
('susan', 'ROLE_MANAGER');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
CREATE TABLE IF NOT EXISTS `student` (
  `id` int NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `students`
--

DROP TABLE IF EXISTS `students`;
CREATE TABLE IF NOT EXISTS `students` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `students`
--

INSERT INTO `students` (`id`, `email`, `first_name`, `last_name`) VALUES
(1, 'ram@gmail.com', 'ram', 'sankar '),
(2, 'ji@gmail.com', 'vijay', 'ji '),
(3, 'ji@gmail.com', 'vijay', 'ji ');

-- --------------------------------------------------------

--
-- Table structure for table `student_udemy`
--

DROP TABLE IF EXISTS `student_udemy`;
CREATE TABLE IF NOT EXISTS `student_udemy` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student_udemy`
--

INSERT INTO `student_udemy` (`id`, `first_name`, `last_name`, `email`) VALUES
(1, 'st1', 'st_1', 'st1@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(150) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `enabled` tinyint NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`username`, `password`, `enabled`) VALUES
('ram', '{noop}test123', 1),
('shiv', '{bcrypt}$2a$12$VbWCyUFxr9KMPx3p1aU39.I9WtAJy9gECUP7MjirDFEpKntZ7YQh6', 1),
('sita', '{noop}test123', 1);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `authorities`
--
ALTER TABLE `authorities`
  ADD CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`);

--
-- Constraints for table `course`
--
ALTER TABLE `course`
  ADD CONSTRAINT `FK_INSTRUCTOR` FOREIGN KEY (`instructor_id`) REFERENCES `instructor` (`id`);

--
-- Constraints for table `course_student`
--
ALTER TABLE `course_student`
  ADD CONSTRAINT `FK_COURSE_05` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`),
  ADD CONSTRAINT `FK_STUDENT` FOREIGN KEY (`student_id`) REFERENCES `student_udemy` (`id`);

--
-- Constraints for table `employee`
--
ALTER TABLE `employee`
  ADD CONSTRAINT `FKbejtwvg9bxus2mffsm3swj3u9` FOREIGN KEY (`department_id`) REFERENCES `department` (`id`);

--
-- Constraints for table `instructor`
--
ALTER TABLE `instructor`
  ADD CONSTRAINT `FK_DETAIL` FOREIGN KEY (`instructor_detail_id`) REFERENCES `instructor_detail` (`id`);

--
-- Constraints for table `review`
--
ALTER TABLE `review`
  ADD CONSTRAINT `FK_COURSE` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`);

--
-- Constraints for table `roles_security`
--
ALTER TABLE `roles_security`
  ADD CONSTRAINT `authorities5_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `member_security` (`user_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
