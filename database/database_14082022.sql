-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: qlks
-- ------------------------------------------------------
-- Server version	8.0.29

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
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
  `EmployeeCode` int DEFAULT NULL,
  `UserName` varchar(50) NOT NULL,
  `PassWord` varchar(50) DEFAULT 'admin',
  PRIMARY KEY (`UserName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (34,'1','admin'),(1,'20182798','admin'),(3,'3','admin'),(39,'5','admin'),(43,'6','admin'),(52,'9','admin'),(38,'a','a'),(25,'d','admin'),(24,'habui123','admin'),(26,'test1','admin'),(27,'test2','admin'),(28,'test3','admin'),(29,'test4','admin'),(30,'test5','admin'),(32,'thinv0','admin'),(37,'z','z');
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `allowance`
--

DROP TABLE IF EXISTS `allowance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `allowance` (
  `PositionCode` varchar(5) NOT NULL,
  `LunchAllowance` int DEFAULT NULL,
  `ResponsibilityAllowance` int DEFAULT NULL,
  `FuelAllowance` int DEFAULT NULL,
  PRIMARY KEY (`PositionCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `allowance`
--

LOCK TABLES `allowance` WRITE;
/*!40000 ALTER TABLE `allowance` DISABLE KEYS */;
/*!40000 ALTER TABLE `allowance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `attendant`
--

DROP TABLE IF EXISTS `attendant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `attendant` (
  `AttendanceCode` int NOT NULL AUTO_INCREMENT,
  `BranchCode` int DEFAULT NULL,
  `EmployeeCode` int DEFAULT NULL,
  `CheckInTime` datetime DEFAULT NULL,
  PRIMARY KEY (`AttendanceCode`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attendant`
--

LOCK TABLES `attendant` WRITE;
/*!40000 ALTER TABLE `attendant` DISABLE KEYS */;
INSERT INTO `attendant` VALUES (1,1,3,'2020-10-01 21:02:02'),(2,1,3,'2020-11-01 21:02:11'),(7,3,5,'2020-12-01 22:19:26'),(9,2,3,'2020-12-01 23:02:22'),(10,1,1,'2020-12-01 23:11:29'),(11,1,3,'2020-12-04 16:53:39'),(12,1,1,'2020-12-04 16:55:03'),(13,3,5,'2020-12-15 21:15:50'),(14,1,1,'2020-12-23 13:43:28'),(15,2,23,'2020-12-25 19:56:05'),(16,3,5,'2020-12-27 16:47:12'),(17,2,24,'2020-12-27 16:48:35'),(18,3,5,'2020-12-28 22:29:24'),(19,2,24,'2020-12-28 23:01:33'),(20,2,1,'2022-06-30 21:00:04'),(21,5,30,'2022-07-30 15:10:45'),(22,2,1,'2022-07-30 15:11:35'),(23,1,38,'2022-08-02 14:51:17'),(24,1,37,'2022-08-14 10:32:11');
/*!40000 ALTER TABLE `attendant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bill`
--

DROP TABLE IF EXISTS `bill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bill` (
  `BillCode` int NOT NULL AUTO_INCREMENT,
  `RoomCode` int DEFAULT NULL,
  `CheckIn` datetime DEFAULT NULL,
  `CheckOut` datetime DEFAULT NULL,
  `Price` int DEFAULT NULL,
  `VATTax` float DEFAULT NULL,
  `EmployeeCode` int DEFAULT NULL,
  `CustomerCode` int DEFAULT NULL,
  `BranchCode` int DEFAULT NULL,
  PRIMARY KEY (`BillCode`)
) ENGINE=InnoDB AUTO_INCREMENT=76 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bill`
--

LOCK TABLES `bill` WRITE;
/*!40000 ALTER TABLE `bill` DISABLE KEYS */;
INSERT INTO `bill` VALUES (57,1,'2020-12-28 22:54:30','2020-12-28 22:54:48',500000,0.02,24,23,2),(58,1,'2020-12-29 14:53:21','2020-12-29 15:06:01',500000,0.02,24,24,2),(59,2,'2020-12-29 15:06:25','2020-12-29 15:09:23',500000,0.02,24,12,2),(60,3,'2020-12-29 15:06:38','2020-12-29 15:09:27',500000,0.02,24,25,2),(61,1,'2022-06-30 21:12:31','2022-06-30 21:13:07',500000,0.1,32,26,2),(62,7,'2022-07-30 15:25:14',NULL,0,0.1,30,27,5),(63,7,'2022-07-31 08:57:05','2022-07-31 21:09:35',500000,0.1,37,28,1),(64,7,'2022-07-31 21:09:50','2022-07-31 22:09:32',500000,0.1,37,29,1),(65,8,'2022-07-31 21:10:02','2022-07-31 22:10:00',500000,0.1,37,30,1),(66,6,'2022-07-31 21:34:34','2022-07-31 22:10:08',500000,0.1,37,31,1),(67,6,'2022-08-01 15:15:17','2022-08-01 15:15:49',500000,0.1,37,32,1),(68,7,'2022-08-01 15:16:08','2022-08-01 15:16:11',500000,0.1,37,33,1),(69,8,'2022-08-01 15:16:25','2022-08-02 16:48:10',500000,0.1,37,34,1),(70,2,'2022-08-01 15:16:34','2022-08-14 10:32:26',200000,0.1,37,35,1),(71,3,'2022-08-01 15:43:02','2022-08-01 15:43:34',500000,0.1,37,36,1),(72,3,'2022-08-01 16:08:26',NULL,500000,0.1,37,37,1),(73,7,'2022-08-02 04:20:05','2022-08-02 16:06:59',500000,0.1,37,38,1),(74,5,'2022-08-02 15:55:57','2022-08-02 16:07:07',500000,0.1,37,39,1),(75,4,'2022-08-14 10:34:10',NULL,600000,0.1,37,40,1);
/*!40000 ALTER TABLE `bill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `billdetail`
--

DROP TABLE IF EXISTS `billdetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `billdetail` (
  `ProductCode` int NOT NULL,
  `BillCode` int NOT NULL,
  `Amount` int NOT NULL,
  `Price` int DEFAULT NULL,
  PRIMARY KEY (`ProductCode`,`BillCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `billdetail`
--

LOCK TABLES `billdetail` WRITE;
/*!40000 ALTER TABLE `billdetail` DISABLE KEYS */;
INSERT INTO `billdetail` VALUES (1,57,5,10000),(1,58,6,10000),(1,61,9,10000),(1,64,2,10000),(1,67,1,10000),(1,70,1,10000),(1,72,5,50000),(2,69,4,10000),(3,57,6,10000),(4,59,9,9000),(4,60,5,9000),(5,57,4,12333),(5,72,2,12333),(8,70,2,4433);
/*!40000 ALTER TABLE `billdetail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `branch`
--

DROP TABLE IF EXISTS `branch`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `branch` (
  `BranchCode` int NOT NULL,
  `BranchName` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL,
  `Address` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL,
  `Email` varchar(100) DEFAULT NULL,
  `PhoneNumber` int DEFAULT NULL,
  PRIMARY KEY (`BranchCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `branch`
--

LOCK TABLES `branch` WRITE;
/*!40000 ALTER TABLE `branch` DISABLE KEYS */;
INSERT INTO `branch` VALUES (1,'Hai Bà Trưng','','',1),(2,'Cầu Giấy','','',1),(3,'Ba Đình','12','221',1111),(4,'Hoàng Mai','1','11',1),(5,'Hoàn Kiếm','','',1);
/*!40000 ALTER TABLE `branch` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `CustomerCode` int NOT NULL AUTO_INCREMENT,
  `FullName` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL,
  `PhoneNumber` varchar(15) DEFAULT NULL,
  `CustomerType` varchar(5) DEFAULT 'THU',
  `CMTNumber` varchar(15) DEFAULT NULL,
  `Address` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL,
  `Email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`CustomerCode`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'1','1','THU','1','1','1'),(2,'a','a','THU','a','a','a'),(3,'1','1','THU','1','1','1'),(4,'1','1','THU','1','1','1'),(5,'1212','12','V','12','12','12'),(6,'d','d','V','d','d','d'),(7,'sadsad','ádsad','V','ád','đá','ádas'),(8,'2','2','V','2','2','2'),(9,'s','s','B','s','s','s'),(10,'2','1','B','3','5','4'),(11,'32','2','B','2','2','2'),(12,'Nguyễn Việt Thi','0366939260','KC','123','1','123@gmail.com'),(14,'2','2','NO','2','2',NULL),(18,'12',NULL,'THU',NULL,NULL,NULL),(19,'a','a','THU','a','a','a'),(20,'a','a','THU','a','a','a'),(21,'Bùi Thị Hà','038830690','THU','1','Nam Thanh, Nam Đàn, Nghệ An','1'),(23,'Nguyễn Việt Thi','0213456789','THU','11111111111','Nam Thanh, Nam Đàn','nguyenvietthi@gmail.com'),(24,'Thi','012345555','THU','123','123asd','thi@gmail.com'),(25,'qưeqw','1245','THU','eqwewq','ewqewq','qưewq'),(26,'1','1','THU','1','1','1'),(27,'432423','3432','THU','432432','23423','4234'),(28,'1','1','THU','1','1','1'),(29,'33','33','THU','33','333','33'),(30,'44','44','THU','44','44','44'),(31,'1','1','THU','1','1','1'),(32,'1','1','THU','1','1','1'),(33,'1','1','THU','1','1','1'),(34,'1','1','THU','1','1','1'),(35,'1','12','THU','12','2','2'),(36,'3','3','THU','3','3','3'),(37,'Nguyễn Việt Anh','123','THU','123','1','1'),(38,'4','4','THU','4','4','4'),(39,'3','3','THU','3','3','3'),(40,'434','44','THU','44','3424324','444');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customertypedetail`
--

DROP TABLE IF EXISTS `customertypedetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customertypedetail` (
  `CustomerType` varchar(5) NOT NULL,
  `Name` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL,
  `Description` varchar(1000) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`CustomerType`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customertypedetail`
--

LOCK TABLES `customertypedetail` WRITE;
/*!40000 ALTER TABLE `customertypedetail` DISABLE KEYS */;
INSERT INTO `customertypedetail` VALUES ('B','Bạc','20 triệu'),('D','Đồng','50 triệu'),('KC','Kim Cương','100 triệu'),('THU','Thường',''),('V','Vàng','30 triệu');
/*!40000 ALTER TABLE `customertypedetail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `discount`
--

DROP TABLE IF EXISTS `discount`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `discount` (
  `DiscountCode` char(10) NOT NULL,
  `Decription` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL,
  `Percent` double DEFAULT NULL,
  `Status` tinyint DEFAULT NULL,
  PRIMARY KEY (`DiscountCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discount`
--

LOCK TABLES `discount` WRITE;
/*!40000 ALTER TABLE `discount` DISABLE KEYS */;
INSERT INTO `discount` VALUES ('1',NULL,0.1,0),('2',NULL,0.2,1),('3',NULL,0.3,1),('4',NULL,0.4,1),('5',NULL,0.5,1),('THU',NULL,0,1);
/*!40000 ALTER TABLE `discount` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `discountdetail`
--

DROP TABLE IF EXISTS `discountdetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `discountdetail` (
  `CustomerType` varchar(5) NOT NULL,
  `DiscountCode` char(10) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`CustomerType`,`DiscountCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discountdetail`
--

LOCK TABLES `discountdetail` WRITE;
/*!40000 ALTER TABLE `discountdetail` DISABLE KEYS */;
INSERT INTO `discountdetail` VALUES ('B','2'),('KC','4'),('THU','THU'),('V','1'),('V','2');
/*!40000 ALTER TABLE `discountdetail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `EmployeeCode` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL,
  `DateOfBirth` date DEFAULT NULL,
  `Address` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL,
  `NumberPhone` varchar(15) DEFAULT NULL,
  `CMTNumber` varchar(15) DEFAULT NULL,
  `PositionNumBer` char(5) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL,
  `Email` char(100) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL,
  `Sex` bit(1) DEFAULT NULL,
  `Status` bit(1) DEFAULT NULL,
  `BranchCode` int DEFAULT NULL,
  PRIMARY KEY (`EmployeeCode`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'Nguyễn Việt Thi','2000-03-02','Nam Thanh, Nam Đàn, Nghệ An','1638830690','123456','GD','nguyenvietthi.nd@gmail.com',_binary '',_binary '',2),(11,'Nguyễn Văn A','2020-12-09','sdsadsa','sadasdsad','187844444','QL','K@gmail.com',_binary '\0',_binary '',3),(24,'Bùi Thị Hà','1978-02-02','sdasd','ádas','11111','NV','1111',_binary '\0',_binary '',2),(25,'d','2020-12-01','d','d','d','NV','d',_binary '\0',_binary '',1),(26,'test1','2020-12-01','test1','test1','test1','NV','test1',_binary '',_binary '',1),(27,'test2','2020-12-09','test2','test2','test2','NV','test2',_binary '',_binary '',2),(28,'test3','2020-12-09','test3','test3','test3','NV','test3',_binary '\0',_binary '',3),(29,'test4','2020-12-03','test4','test4','test4','NV','test4',_binary '\0',_binary '',4),(30,'test5','2020-12-17','test5','test5','test5','NV','test5',_binary '\0',_binary '',5),(32,'Nguyễn Việt A','2022-06-03','1','1','1','NV','1',_binary '',_binary '',2),(34,'1','2022-07-06','1','1','1','GD','1',_binary '',_binary '',1),(37,'z','2022-07-05','12121aa','1','aasaasasa','NV','asa',_binary '',_binary '',1),(38,'a','2022-08-10','aaaa','a','a','GD','a',_binary '',_binary '',1),(39,'5','2022-08-10','5','5','5','NV','5',_binary '\0',_binary '',3),(43,'5','2022-08-03','5','5','5','GD','5',_binary '',_binary '\0',1),(52,'re','2022-08-05','9','9','9','GD','9',_binary '',_binary '',1);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employeesalary`
--

DROP TABLE IF EXISTS `employeesalary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employeesalary` (
  `MonthYear` date NOT NULL,
  `EmployeeCode` int NOT NULL,
  `BrachCode` int DEFAULT NULL,
  `WorkdayNumber` int DEFAULT NULL,
  `PositionCode` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`MonthYear`,`EmployeeCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employeesalary`
--

LOCK TABLES `employeesalary` WRITE;
/*!40000 ALTER TABLE `employeesalary` DISABLE KEYS */;
/*!40000 ALTER TABLE `employeesalary` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hotelroom`
--

DROP TABLE IF EXISTS `hotelroom`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hotelroom` (
  `BranchCode` int NOT NULL,
  `RoomCode` int NOT NULL,
  `Status` bit(1) DEFAULT NULL,
  `Price` int DEFAULT NULL,
  `Description` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`BranchCode`,`RoomCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hotelroom`
--

LOCK TABLES `hotelroom` WRITE;
/*!40000 ALTER TABLE `hotelroom` DISABLE KEYS */;
INSERT INTO `hotelroom` VALUES (1,1,_binary '\0',300000,'VIP'),(1,2,_binary '\0',200000,'VIP'),(1,3,_binary '',500000,'VIP'),(1,4,_binary '',600000,'VIP'),(1,5,_binary '\0',500000,'rftygfege'),(1,6,_binary '\0',60000000,''),(1,7,_binary '\0',500000,''),(1,8,_binary '\0',5555,''),(2,1,_binary '\0',500000,NULL),(2,2,_binary '\0',500000,''),(2,3,_binary '\0',500000,NULL),(2,4,_binary '\0',500000,NULL),(2,5,_binary '\0',500000,'VIP\n'),(2,6,_binary '\0',500000,NULL),(2,7,_binary '\0',500000,NULL),(2,8,_binary '\0',500000,NULL),(2,9,_binary '\0',500000,NULL),(2,10,_binary '\0',500000,NULL),(2,11,_binary '\0',500000,NULL),(2,12,_binary '\0',500000,NULL),(3,1,_binary '\0',500000,NULL),(3,2,_binary '\0',500000,NULL),(3,3,_binary '\0',500000,NULL),(3,4,_binary '\0',500000,NULL),(3,5,_binary '\0',500000,NULL),(3,6,_binary '\0',500000,NULL),(3,7,_binary '\0',500000,NULL),(3,8,_binary '\0',500000,NULL),(3,9,_binary '\0',500000,NULL),(3,10,_binary '\0',500000,NULL),(3,11,_binary '\0',500000,NULL),(4,1,_binary '\0',200000,NULL),(4,2,_binary '\0',NULL,NULL),(4,3,_binary '\0',NULL,NULL),(4,4,_binary '\0',NULL,NULL),(4,5,_binary '\0',NULL,NULL),(4,6,_binary '\0',NULL,NULL),(4,7,_binary '\0',NULL,NULL),(4,8,_binary '\0',NULL,NULL),(4,9,_binary '\0',NULL,NULL),(5,1,_binary '\0',NULL,NULL),(5,2,_binary '\0',NULL,NULL),(5,3,_binary '\0',NULL,NULL),(5,4,_binary '\0',NULL,NULL),(5,5,_binary '\0',NULL,NULL),(5,6,_binary '\0',NULL,NULL),(5,7,_binary '',NULL,NULL),(5,8,_binary '\0',NULL,NULL),(5,9,_binary '\0',NULL,NULL),(5,10,_binary '\0',NULL,NULL),(5,11,_binary '\0',NULL,NULL);
/*!40000 ALTER TABLE `hotelroom` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `position`
--

DROP TABLE IF EXISTS `position`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `position` (
  `PositionCode` char(5) NOT NULL,
  `Position` varchar(30) DEFAULT NULL,
  `BasicSalary` int DEFAULT NULL,
  PRIMARY KEY (`PositionCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `position`
--

LOCK TABLES `position` WRITE;
/*!40000 ALTER TABLE `position` DISABLE KEYS */;
INSERT INTO `position` VALUES ('GD','Giám đốc',2000000),('NV','Nhân viên',9000000),('QL','Quản lý',1500000);
/*!40000 ALTER TABLE `position` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `ProductCode` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL,
  `Price` int DEFAULT NULL,
  `Description` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`ProductCode`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'Mỳ tôm Hảo Hảo',50000,'1'),(2,'Mỳ tôm Ba Miền',10000,'4'),(3,'Bao cao su',10000,'7'),(4,'Giấy ướt',9000,'10'),(5,'BCS',12333,'12321dascasdsa'),(6,'adu',123,'dsadsa'),(7,'ss',111111,'ss'),(8,'87',4433,'87'),(9,NULL,333,NULL);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salarydetail`
--

DROP TABLE IF EXISTS `salarydetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `salarydetail` (
  `MonthYear` date NOT NULL,
  `PositionCode` int NOT NULL,
  `BasicSalary` int DEFAULT NULL,
  `LunchAllowance` int DEFAULT NULL,
  `ResponsibilityAllowance` int DEFAULT NULL,
  `FuelAllowance` int DEFAULT NULL,
  PRIMARY KEY (`MonthYear`,`PositionCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salarydetail`
--

LOCK TABLES `salarydetail` WRITE;
/*!40000 ALTER TABLE `salarydetail` DISABLE KEYS */;
/*!40000 ALTER TABLE `salarydetail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tax`
--

DROP TABLE IF EXISTS `tax`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tax` (
  `MonthYear` date NOT NULL,
  `VAT` double DEFAULT NULL,
  `BHYT` double DEFAULT NULL,
  `BHXH` double DEFAULT NULL,
  PRIMARY KEY (`MonthYear`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tax`
--

LOCK TABLES `tax` WRITE;
/*!40000 ALTER TABLE `tax` DISABLE KEYS */;
/*!40000 ALTER TABLE `tax` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `warehousedetail`
--

DROP TABLE IF EXISTS `warehousedetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `warehousedetail` (
  `BranchCode` int NOT NULL,
  `ProductCode` int NOT NULL,
  `Amount` int DEFAULT NULL,
  PRIMARY KEY (`ProductCode`,`BranchCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `warehousedetail`
--

LOCK TABLES `warehousedetail` WRITE;
/*!40000 ALTER TABLE `warehousedetail` DISABLE KEYS */;
INSERT INTO `warehousedetail` VALUES (1,1,330),(2,1,215),(3,1,129),(1,2,1),(3,2,6),(5,2,10),(3,3,6),(1,4,6),(2,4,1198),(1,5,23230),(5,6,123),(1,7,11111),(1,8,87876);
/*!40000 ALTER TABLE `warehousedetail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `warehousereceipt`
--

DROP TABLE IF EXISTS `warehousereceipt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `warehousereceipt` (
  `WarehouseReceiptCode` int NOT NULL AUTO_INCREMENT,
  `BranchCode` int NOT NULL,
  `EmployeeCode` int NOT NULL,
  `Time` datetime DEFAULT NULL,
  `DeliveryCompany` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL,
  `DeliveryEmployee` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`WarehouseReceiptCode`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `warehousereceipt`
--

LOCK TABLES `warehousereceipt` WRITE;
/*!40000 ALTER TABLE `warehousereceipt` DISABLE KEYS */;
INSERT INTO `warehousereceipt` VALUES (6,3,5,'2020-12-28 11:36:09','1233','12323'),(7,2,24,'2020-12-28 11:40:58','123','123'),(8,2,24,'2020-12-28 11:53:09','123','21321'),(9,2,24,'2020-12-28 11:55:38','1212','1212'),(10,2,24,'2020-12-28 11:55:57','12121','2121'),(11,2,24,'2020-12-28 21:39:29','',''),(12,2,24,'2020-12-28 21:40:47','',''),(13,2,24,'2020-12-28 21:41:01','sadsa','sadasdsa'),(14,5,30,'2022-07-30 16:14:30','thinv','thinv'),(15,1,37,'2022-08-01 14:10:54','1','1'),(16,1,37,'2022-08-01 16:32:52','1','1'),(17,1,37,'2022-08-01 16:33:14','1','1'),(18,1,37,'2022-08-02 04:28:46','3','3'),(19,1,37,'2022-08-02 16:15:59','66','666'),(20,1,37,'2022-08-02 18:18:50','','');
/*!40000 ALTER TABLE `warehousereceipt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `warehousereceiptdetail`
--

DROP TABLE IF EXISTS `warehousereceiptdetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `warehousereceiptdetail` (
  `WarehouseReceiptCode` int NOT NULL,
  `ProductCode` int NOT NULL,
  `Amount` int DEFAULT NULL,
  `Price` int DEFAULT NULL,
  PRIMARY KEY (`WarehouseReceiptCode`,`ProductCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `warehousereceiptdetail`
--

LOCK TABLES `warehousereceiptdetail` WRITE;
/*!40000 ALTER TABLE `warehousereceiptdetail` DISABLE KEYS */;
INSERT INTO `warehousereceiptdetail` VALUES (6,1,123,1),(7,1,12,12),(8,2,123,12333),(9,1,232,123213),(10,1,12,121212),(13,4,1212,121212),(14,2,10,2),(14,6,123,123213),(15,7,11111,111111),(16,1,333,9000),(17,1,2,3000),(18,5,23232,3232323),(19,8,87878,8787878);
/*!40000 ALTER TABLE `warehousereceiptdetail` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-14 10:35:58
