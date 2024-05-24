-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: resident_management
-- ------------------------------------------------------
-- Server version	8.1.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_admin_user_idx` (`user_id`),
  CONSTRAINT `fk_admin_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,1);
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `answer`
--

DROP TABLE IF EXISTS `answer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `answer` (
  `id` int NOT NULL AUTO_INCREMENT,
  `content` int NOT NULL,
  `resident_id` int NOT NULL,
  `question_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_answer_question_idx` (`question_id`),
  KEY `fk_answer_resident_idx` (`resident_id`),
  CONSTRAINT `fk_answer_question` FOREIGN KEY (`question_id`) REFERENCES `question` (`id`),
  CONSTRAINT `fk_answer_resident` FOREIGN KEY (`resident_id`) REFERENCES `resident` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `answer`
--

LOCK TABLES `answer` WRITE;
/*!40000 ALTER TABLE `answer` DISABLE KEYS */;
INSERT INTO `answer` VALUES (1,1,1,1),(2,1,2,1),(3,1,3,1),(4,1,1,2),(5,1,2,2),(6,1,3,2);
/*!40000 ALTER TABLE `answer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `electronic_locker`
--

DROP TABLE IF EXISTS `electronic_locker`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `electronic_locker` (
  `id` int NOT NULL AUTO_INCREMENT,
  `resident_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_resident_idx` (`resident_id`),
  KEY `fk_locker_resident_idx` (`resident_id`),
  CONSTRAINT `fk_locker_resident` FOREIGN KEY (`resident_id`) REFERENCES `resident` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `electronic_locker`
--

LOCK TABLES `electronic_locker` WRITE;
/*!40000 ALTER TABLE `electronic_locker` DISABLE KEYS */;
INSERT INTO `electronic_locker` VALUES (1,1),(2,2),(3,3),(4,4),(5,5),(6,6),(7,7),(8,8),(9,9),(10,10);
/*!40000 ALTER TABLE `electronic_locker` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `feedback`
--

DROP TABLE IF EXISTS `feedback`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `feedback` (
  `id` int NOT NULL AUTO_INCREMENT,
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `status` tinyint DEFAULT '0',
  `resident_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_feedback_resident_idx` (`resident_id`),
  CONSTRAINT `fk_feedback_resident` FOREIGN KEY (`resident_id`) REFERENCES `resident` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `feedback`
--

LOCK TABLES `feedback` WRITE;
/*!40000 ALTER TABLE `feedback` DISABLE KEYS */;
INSERT INTO `feedback` VALUES (1,'Cần tăng cường an ninh về đêm',0,3);
/*!40000 ALTER TABLE `feedback` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `invoice`
--

DROP TABLE IF EXISTS `invoice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `invoice` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `amount` decimal(10,0) NOT NULL,
  `due_date` date DEFAULT NULL,
  `status` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT 'unpaid',
  `payment_prove` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `resident_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_invoice_resident_idx` (`resident_id`),
  CONSTRAINT `fk_invoice_resident` FOREIGN KEY (`resident_id`) REFERENCES `resident` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `invoice`
--

LOCK TABLES `invoice` WRITE;
/*!40000 ALTER TABLE `invoice` DISABLE KEYS */;
INSERT INTO `invoice` VALUES (1,'Phí gửi xe',30000,'2025-05-10','unpaid',NULL,1),(2,'Phí gửi xe',30000,'2025-05-10','unpaid',NULL,2),(3,'Phí gửi xe',30000,'2025-05-10','unpaid',NULL,3);
/*!40000 ALTER TABLE `invoice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item`
--

DROP TABLE IF EXISTS `item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item` (
  `id` int NOT NULL AUTO_INCREMENT,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `electronic_locker_id` int NOT NULL,
  `status` tinyint NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `fk_item_locker_idx` (`electronic_locker_id`),
  CONSTRAINT `fk_item_locker` FOREIGN KEY (`electronic_locker_id`) REFERENCES `electronic_locker` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item`
--

LOCK TABLES `item` WRITE;
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
INSERT INTO `item` VALUES (1,'hộp hàng',1,0),(2,'hộp hàng',1,0),(3,'hộp hàng',2,0),(4,'hộp hàng ',3,0);
/*!40000 ALTER TABLE `item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `question`
--

DROP TABLE IF EXISTS `question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `question` (
  `id` int NOT NULL AUTO_INCREMENT,
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `survey_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_question_survey_idx` (`survey_id`),
  CONSTRAINT `fk_question_survey` FOREIGN KEY (`survey_id`) REFERENCES `survey` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question`
--

LOCK TABLES `question` WRITE;
/*!40000 ALTER TABLE `question` DISABLE KEYS */;
INSERT INTO `question` VALUES (1,'Tình hình an ninh có tốt không',1),(2,'Thái độ làm việc của nhân viên',1);
/*!40000 ALTER TABLE `question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resident`
--

DROP TABLE IF EXISTS `resident`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `resident` (
  `id` int NOT NULL AUTO_INCREMENT,
  `balance` decimal(10,0) DEFAULT '0',
  `user_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_resident_user_idx` (`user_id`),
  CONSTRAINT `fk_resident_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resident`
--

LOCK TABLES `resident` WRITE;
/*!40000 ALTER TABLE `resident` DISABLE KEYS */;
INSERT INTO `resident` VALUES (1,0,2),(2,0,3),(3,0,4),(4,0,5),(5,0,6),(6,0,7),(7,0,8),(8,0,9),(9,0,10),(10,0,11);
/*!40000 ALTER TABLE `resident` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resident_visitor`
--

DROP TABLE IF EXISTS `resident_visitor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `resident_visitor` (
  `id` int NOT NULL AUTO_INCREMENT,
  `resident_id` int NOT NULL,
  `visitor_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_resident_idx` (`resident_id`),
  KEY `fk_visitor_idx` (`visitor_id`),
  CONSTRAINT `fk_resident` FOREIGN KEY (`resident_id`) REFERENCES `resident` (`id`),
  CONSTRAINT `fk_visitor` FOREIGN KEY (`visitor_id`) REFERENCES `visitor` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resident_visitor`
--

LOCK TABLES `resident_visitor` WRITE;
/*!40000 ALTER TABLE `resident_visitor` DISABLE KEYS */;
INSERT INTO `resident_visitor` VALUES (1,1,1),(2,2,2),(3,3,3);
/*!40000 ALTER TABLE `resident_visitor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `survey`
--

DROP TABLE IF EXISTS `survey`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `survey` (
  `id` int NOT NULL AUTO_INCREMENT,
  `admin_id` int NOT NULL,
  `title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_survey_admin_idx` (`admin_id`),
  CONSTRAINT `fk_survey_admin` FOREIGN KEY (`admin_id`) REFERENCES `admin` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `survey`
--

LOCK TABLES `survey` WRITE;
/*!40000 ALTER TABLE `survey` DISABLE KEYS */;
INSERT INTO `survey` VALUES (1,1,'Tình hình an ninh');
/*!40000 ALTER TABLE `survey` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `last_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `gender` tinyint DEFAULT '0',
  `dob` date DEFAULT NULL,
  `address` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `phone` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `email` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `username` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `password` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `avatar` varchar(255) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `role` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT 'resident',
  `active` tinyint DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Dương','Bình',0,'2003-08-10','TP HCM','0707920834','binh@gmail.com','admin','123456','https://asset.cloudinary.com/dwdvnztnn/343c81dd2c6600f7dc1e5ad619770d8c','admin',1),(2,'Nguyễn','Kiệt',0,'2003-02-21','TP HCM','0707937952','kiet@gmail.com','user1','123456',NULL,'resident',1),(3,'Trần ','Chinh',0,'2003-07-13','TP HCM','0707064504','chinh@gmail.com','user2','123456',NULL,'resident',1),(4,'Phạm','Vương',0,'2003-02-09','Tây ninh','0939532068','vuong@gmail.com','user3','123456',NULL,'resident',1),(5,'Nguyễn Thị','Hương',1,'1994-04-15','Hà Nội','0939494631','huong@gmail.com','user4','123456',NULL,'resident',1),(6,'Trần Văn ','Nam',0,'2000-08-03','Khánh Hòa','0858037593','nam@gmail.com','user5','123456',NULL,'resident',1),(7,'Lê Ngọc','Mai',1,'1999-02-10','Đồng Nai','0753659461','mai@gmail.com','user6','123456',NULL,'resident',1),(8,'Phạm Đức','Long',0,'2003-09-19','TP HCM','0985205814','long@gmail.com','user7','123456',NULL,'resident',1),(9,'Vũ Minh ','Tuấn',0,'1992-12-06','Hà Nội','0959593751','tuan@gmail.com','user8','123456',NULL,'resident',1),(10,'Dương Tuấn','Kiệt',0,'1999-04-24','Hậu Giang','0507849561','kiet@gmail.com','user9','123456',NULL,'resident',1),(11,'Trần Thái','Sơn',0,'2000-11-02','Quãng Ngải','0909951560','son@gmail.com','user10','123456',NULL,'resident',1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `visitor`
--

DROP TABLE IF EXISTS `visitor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `visitor` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `relation` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `visitor`
--

LOCK TABLES `visitor` WRITE;
/*!40000 ALTER TABLE `visitor` DISABLE KEYS */;
INSERT INTO `visitor` VALUES (1,'Vinh','bạn'),(2,'Tài','bạn'),(3,'Đạt','anh');
/*!40000 ALTER TABLE `visitor` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-24 17:33:05
