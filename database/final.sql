-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: qlks
-- ------------------------------------------------------
-- Server version	8.0.21

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
  `EmployeeNumber` int DEFAULT NULL,
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
INSERT INTO `account` VALUES (2,'2','admin'),(1,'20182798','admin'),(3,'3','admin'),(4,'4','admin'),(5,'a','a'),(23,'anh123','123'),(25,'d','admin'),(24,'habui123','admin'),(26,'test1','admin'),(27,'test2','admin'),(28,'test3','admin'),(29,'test4','admin'),(30,'test5','admin');
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cacthue`
--

DROP TABLE IF EXISTS `cacthue`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cacthue` (
  `ThangNam` date NOT NULL,
  `ThueThuNhapCaNhan` double DEFAULT NULL,
  `BHYT` double DEFAULT NULL,
  `BHXH` double DEFAULT NULL,
  PRIMARY KEY (`ThangNam`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cacthue`
--

LOCK TABLES `cacthue` WRITE;
/*!40000 ALTER TABLE `cacthue` DISABLE KEYS */;
/*!40000 ALTER TABLE `cacthue` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chamcong`
--

DROP TABLE IF EXISTS `chamcong`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chamcong` (
  `MaChamCong` int NOT NULL AUTO_INCREMENT,
  `MaChiNhanh` int DEFAULT NULL,
  `MaNhanVien` int DEFAULT NULL,
  `NgayGio` datetime DEFAULT NULL,
  PRIMARY KEY (`MaChamCong`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chamcong`
--

LOCK TABLES `chamcong` WRITE;
/*!40000 ALTER TABLE `chamcong` DISABLE KEYS */;
INSERT INTO `chamcong` VALUES (1,1,3,'2020-10-01 21:02:02'),(2,1,3,'2020-11-01 21:02:11'),(7,3,5,'2020-12-01 22:19:26'),(9,2,3,'2020-12-01 23:02:22'),(10,1,1,'2020-12-01 23:11:29'),(11,1,3,'2020-12-04 16:53:39'),(12,1,1,'2020-12-04 16:55:03'),(13,3,5,'2020-12-15 21:15:50'),(14,1,1,'2020-12-23 13:43:28'),(15,2,23,'2020-12-25 19:56:05'),(16,3,5,'2020-12-27 16:47:12'),(17,2,24,'2020-12-27 16:48:35'),(18,3,5,'2020-12-28 22:29:24'),(19,2,24,'2020-12-28 23:01:33');
/*!40000 ALTER TABLE `chamcong` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chinhanh`
--

DROP TABLE IF EXISTS `chinhanh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chinhanh` (
  `BranchCode` int NOT NULL,
  `BranchName` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `Address` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `Email` varchar(100) DEFAULT NULL,
  `PhoneNumber` int DEFAULT NULL,
  PRIMARY KEY (`BranchCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chinhanh`
--

LOCK TABLES `chinhanh` WRITE;
/*!40000 ALTER TABLE `chinhanh` DISABLE KEYS */;
INSERT INTO `chinhanh` VALUES (1,'Hai Bà Trưng','','',1),(2,'Cầu Giấy','','',1),(3,'Ba Đình','12','221',1111),(4,'Hoàng Mai','1','11',1),(5,'Hoàn Kiếm','','',1);
/*!40000 ALTER TABLE `chinhanh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chitietgiamgia`
--

DROP TABLE IF EXISTS `chitietgiamgia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chitietgiamgia` (
  `MaLoaiKhach` varchar(5) NOT NULL,
  `MaGiamGia` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`MaLoaiKhach`,`MaGiamGia`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chitietgiamgia`
--

LOCK TABLES `chitietgiamgia` WRITE;
/*!40000 ALTER TABLE `chitietgiamgia` DISABLE KEYS */;
INSERT INTO `chitietgiamgia` VALUES ('B','2'),('KC','4'),('THU','THU'),('V','1'),('V','2');
/*!40000 ALTER TABLE `chitietgiamgia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chitiethoadon`
--

DROP TABLE IF EXISTS `chitiethoadon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chitiethoadon` (
  `MaSanPham` int NOT NULL,
  `MaHoaDon` int NOT NULL,
  `SoLuong` int NOT NULL,
  `GiaSanPham` int DEFAULT NULL,
  PRIMARY KEY (`MaSanPham`,`MaHoaDon`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chitiethoadon`
--

LOCK TABLES `chitiethoadon` WRITE;
/*!40000 ALTER TABLE `chitiethoadon` DISABLE KEYS */;
INSERT INTO `chitiethoadon` VALUES (1,57,5,10000),(1,58,6,10000),(3,57,6,10000),(4,59,9,9000),(4,60,5,9000),(5,57,4,12333);
/*!40000 ALTER TABLE `chitiethoadon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chitietkho`
--

DROP TABLE IF EXISTS `chitietkho`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chitietkho` (
  `MaChiNhanh` int NOT NULL,
  `MaSanPham` int NOT NULL,
  `SoLuong` int DEFAULT NULL,
  PRIMARY KEY (`MaSanPham`,`MaChiNhanh`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chitietkho`
--

LOCK TABLES `chitietkho` WRITE;
/*!40000 ALTER TABLE `chitietkho` DISABLE KEYS */;
INSERT INTO `chitietkho` VALUES (1,1,4),(2,1,224),(3,1,129),(1,2,5),(3,2,6),(3,3,6),(1,4,6),(2,4,1198);
/*!40000 ALTER TABLE `chitietkho` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chitietloaikhachhang`
--

DROP TABLE IF EXISTS `chitietloaikhachhang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chitietloaikhachhang` (
  `MaLoaiKhach` varchar(5) NOT NULL,
  `Ten` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `MoTa` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`MaLoaiKhach`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chitietloaikhachhang`
--

LOCK TABLES `chitietloaikhachhang` WRITE;
/*!40000 ALTER TABLE `chitietloaikhachhang` DISABLE KEYS */;
INSERT INTO `chitietloaikhachhang` VALUES ('B','Bạc','20 triệu'),('D','Đồng','50 triệu'),('KC','Kim Cương','100 triệu'),('THU','Thường',''),('V','Vàng','30 triệu');
/*!40000 ALTER TABLE `chitietloaikhachhang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chitietluong`
--

DROP TABLE IF EXISTS `chitietluong`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chitietluong` (
  `ThangNam` date NOT NULL,
  `MaChucVu` int NOT NULL,
  `LuongCoBan` int DEFAULT NULL,
  `PhuCapAnTrua` int DEFAULT NULL,
  `PhuCapTrachNghiem` int DEFAULT NULL,
  `PhuCapXangXe` int DEFAULT NULL,
  PRIMARY KEY (`ThangNam`,`MaChucVu`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chitietluong`
--

LOCK TABLES `chitietluong` WRITE;
/*!40000 ALTER TABLE `chitietluong` DISABLE KEYS */;
/*!40000 ALTER TABLE `chitietluong` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chitietnhapkho`
--

DROP TABLE IF EXISTS `chitietnhapkho`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chitietnhapkho` (
  `MaHoaDon` int NOT NULL,
  `MaSanPham` int NOT NULL,
  `SoLuong` int DEFAULT NULL,
  `GiaSanPham` int DEFAULT NULL,
  PRIMARY KEY (`MaHoaDon`,`MaSanPham`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chitietnhapkho`
--

LOCK TABLES `chitietnhapkho` WRITE;
/*!40000 ALTER TABLE `chitietnhapkho` DISABLE KEYS */;
INSERT INTO `chitietnhapkho` VALUES (6,1,123,1),(7,1,12,12),(8,2,123,12333),(9,1,232,123213),(10,1,12,121212),(13,4,1212,121212);
/*!40000 ALTER TABLE `chitietnhapkho` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chucvu`
--

DROP TABLE IF EXISTS `chucvu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chucvu` (
  `MaChucVu` char(5) NOT NULL,
  `ChucVu` varchar(30) DEFAULT NULL,
  `LuongCoBan` int DEFAULT NULL,
  PRIMARY KEY (`MaChucVu`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chucvu`
--

LOCK TABLES `chucvu` WRITE;
/*!40000 ALTER TABLE `chucvu` DISABLE KEYS */;
INSERT INTO `chucvu` VALUES ('GD','Giám đốc',2000000),('NV','Nhân viên',9000000),('QL','Quản lý',1500000);
/*!40000 ALTER TABLE `chucvu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `giamgia`
--

DROP TABLE IF EXISTS `giamgia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `giamgia` (
  `MaGiamGia` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ChiTiet` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `SoPhanTram` double DEFAULT NULL,
  `TinhTrang` tinyint DEFAULT NULL,
  PRIMARY KEY (`MaGiamGia`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `giamgia`
--

LOCK TABLES `giamgia` WRITE;
/*!40000 ALTER TABLE `giamgia` DISABLE KEYS */;
INSERT INTO `giamgia` VALUES ('1',NULL,0.1,0),('2',NULL,0.2,1),('3',NULL,0.3,1),('4',NULL,0.4,1),('5',NULL,0.5,1),('THU',NULL,0,1);
/*!40000 ALTER TABLE `giamgia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hoadon`
--

DROP TABLE IF EXISTS `hoadon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hoadon` (
  `MaHoaDon` int NOT NULL AUTO_INCREMENT,
  `MaPhong` int DEFAULT NULL,
  `GioVao` datetime DEFAULT NULL,
  `GioRa` datetime DEFAULT NULL,
  `GiaThue` int DEFAULT NULL,
  `ThueVAT` float DEFAULT NULL,
  `MaNhanVien` int DEFAULT NULL,
  `MaKhachHang` int DEFAULT NULL,
  `MaChiNhanh` int DEFAULT NULL,
  PRIMARY KEY (`MaHoaDon`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hoadon`
--

LOCK TABLES `hoadon` WRITE;
/*!40000 ALTER TABLE `hoadon` DISABLE KEYS */;
INSERT INTO `hoadon` VALUES (57,1,'2020-12-28 22:54:30','2020-12-28 22:54:48',500000,0.02,24,23,2),(58,1,'2020-12-29 14:53:21','2020-12-29 15:06:01',500000,0.02,24,24,2),(59,2,'2020-12-29 15:06:25','2020-12-29 15:09:23',500000,0.02,24,12,2),(60,3,'2020-12-29 15:06:38','2020-12-29 15:09:27',500000,0.02,24,25,2);
/*!40000 ALTER TABLE `hoadon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `khachhang`
--

DROP TABLE IF EXISTS `khachhang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `khachhang` (
  `MaKhachHang` int NOT NULL AUTO_INCREMENT,
  `HoVaTen` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `SoDienThoai` varchar(15) DEFAULT NULL,
  `LoaiKhach` varchar(5) DEFAULT 'THU',
  `SoCMT` varchar(15) DEFAULT NULL,
  `DiaChi` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `Email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`MaKhachHang`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `khachhang`
--

LOCK TABLES `khachhang` WRITE;
/*!40000 ALTER TABLE `khachhang` DISABLE KEYS */;
INSERT INTO `khachhang` VALUES (1,'1','1','THU','1','1','1'),(2,'a','a','THU','a','a','a'),(3,'1','1','THU','1','1','1'),(4,'1','1','THU','1','1','1'),(5,'1212','12','V','12','12','12'),(6,'d','d','V','d','d','d'),(7,'sadsad','ádsad','V','ád','đá','ádas'),(8,'2','2','V','2','2','2'),(9,'s','s','B','s','s','s'),(10,'2','1','B','3','5','4'),(11,'32','2','B','2','2','2'),(12,'Nguyễn Việt Thi','0366939260','KC','123','1','123@gmail.com'),(14,'2','2','NO','2','2',NULL),(18,'12',NULL,'THU',NULL,NULL,NULL),(19,'a','a','THU','a','a','a'),(20,'a','a','THU','a','a','a'),(21,'Bùi Thị Hà','038830690','THU','1','Nam Thanh, Nam Đàn, Nghệ An','1'),(23,'Nguyễn Việt Thi','0213456789','THU','11111111111','Nam Thanh, Nam Đàn','nguyenvietthi@gmail.com'),(24,'Thi','012345555','THU','123','123asd','thi@gmail.com'),(25,'qưeqw','1245','THU','eqwewq','ewqewq','qưewq');
/*!40000 ALTER TABLE `khachhang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `luongnhanvien`
--

DROP TABLE IF EXISTS `luongnhanvien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `luongnhanvien` (
  `ThangNam` date NOT NULL,
  `MaNhanVien` int NOT NULL,
  `MaChiNhanh` int DEFAULT NULL,
  `SoNgayCong` int DEFAULT NULL,
  `MaChucVu` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`ThangNam`,`MaNhanVien`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `luongnhanvien`
--

LOCK TABLES `luongnhanvien` WRITE;
/*!40000 ALTER TABLE `luongnhanvien` DISABLE KEYS */;
/*!40000 ALTER TABLE `luongnhanvien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nhanvien`
--

DROP TABLE IF EXISTS `nhanvien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nhanvien` (
  `EmployeeNumber` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `DateOfBirth` date DEFAULT NULL,
  `Address` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `NumberPhone` varchar(15) DEFAULT NULL,
  `CMTNumber` varchar(15) DEFAULT NULL,
  `PositionNumBer` char(5) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `Email` char(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `Sex` bit(1) DEFAULT NULL,
  `Status` bit(1) DEFAULT NULL,
  `BranchCode` int DEFAULT NULL,
  PRIMARY KEY (`EmployeeNumber`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhanvien`
--

LOCK TABLES `nhanvien` WRITE;
/*!40000 ALTER TABLE `nhanvien` DISABLE KEYS */;
INSERT INTO `nhanvien` VALUES (1,'Nguyễn Việt Thi','2000-03-02','Nam Thanh, Nam Đàn, Nghệ An','1638830690','123456','GD','nguyenvietthi.nd@gmail.com',_binary '',_binary '',2),(2,'Vũ Đức Kiên','2000-03-02','Nam Thanh, Nam Đàn, Nghệ An','1638830690','99999999','NV','nguyenvietthi.nd@gmail.com',_binary '',_binary '',2),(4,'Nguyễn Tiến Đạt','1999-03-20','Nam Thanh, Nam Đàn, Nghệ An','1638830690','456','NV','nguyenvietthi.nd@gmail.com',_binary '',_binary '',3),(5,'test','2001-03-14','Nghệ An, Nam Đàn','01638830690','1878111111sdsa','GD','aaaaaaaaaaaaaaaaaaaaaaaaaa',_binary '',_binary '',3),(11,'Nguyễn Văn A','2020-12-09','','','187844444','QL','K@gmail.com',_binary '\0',_binary '',3),(23,'Nguyễn Anh Tài','2020-12-16','Nam Xuân','0333','14444444','NV','tai@gmail.com',_binary '',_binary '',2),(24,'Bùi Thị Hà','1978-02-02','sdasd','ádas','11111','NV','1111',_binary '\0',_binary '',2),(25,'d','2020-12-01','d','d','d','NV','d',_binary '\0',_binary '',1),(26,'test1','2020-12-01','test1','test1','test1','NV','test1',_binary '',_binary '',1),(27,'test2','2020-12-09','test2','test2','test2','NV','test2',_binary '',_binary '',2),(28,'test3','2020-12-09','test3','test3','test3','NV','test3',_binary '\0',_binary '',3),(29,'test4','2020-12-03','test4','test4','test4','NV','test4',_binary '\0',_binary '',4),(30,'test5','2020-12-17','test5','test5','test5','NV','test5',_binary '\0',_binary '',5);
/*!40000 ALTER TABLE `nhanvien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nhapkho`
--

DROP TABLE IF EXISTS `nhapkho`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nhapkho` (
  `MaHoaDon` int NOT NULL AUTO_INCREMENT,
  `MaChiNhanh` int NOT NULL,
  `MaNhanVien` int NOT NULL,
  `NgayGio` datetime DEFAULT NULL,
  `CongTyGiao` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `TenNhanVienGiao` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`MaHoaDon`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhapkho`
--

LOCK TABLES `nhapkho` WRITE;
/*!40000 ALTER TABLE `nhapkho` DISABLE KEYS */;
INSERT INTO `nhapkho` VALUES (6,3,5,'2020-12-28 11:36:09','1233','12323'),(7,2,24,'2020-12-28 11:40:58','123','123'),(8,2,24,'2020-12-28 11:53:09','123','21321'),(9,2,24,'2020-12-28 11:55:38','1212','1212'),(10,2,24,'2020-12-28 11:55:57','12121','2121'),(11,2,24,'2020-12-28 21:39:29','',''),(12,2,24,'2020-12-28 21:40:47','',''),(13,2,24,'2020-12-28 21:41:01','sadsa','sadasdsa');
/*!40000 ALTER TABLE `nhapkho` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phongkhachsan`
--

DROP TABLE IF EXISTS `phongkhachsan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `phongkhachsan` (
  `MaChiNhanh` int NOT NULL,
  `MaPhong` int NOT NULL,
  `TrangThai` bit(1) DEFAULT NULL,
  `GiaThue` int DEFAULT NULL,
  `MoTa` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`MaChiNhanh`,`MaPhong`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phongkhachsan`
--

LOCK TABLES `phongkhachsan` WRITE;
/*!40000 ALTER TABLE `phongkhachsan` DISABLE KEYS */;
INSERT INTO `phongkhachsan` VALUES (1,1,_binary '\0',300000,'VIP'),(1,2,_binary '\0',200000,'VIP'),(1,3,_binary '\0',500000,'VIP'),(1,4,_binary '\0',500000,'VIP'),(1,5,_binary '\0',500000,NULL),(1,6,_binary '\0',500000,NULL),(1,7,_binary '\0',500000,''),(1,8,_binary '\0',500000,NULL),(2,1,_binary '\0',500000,NULL),(2,2,_binary '\0',500000,''),(2,3,_binary '\0',500000,NULL),(2,4,_binary '\0',500000,NULL),(2,5,_binary '\0',500000,'VIP\n'),(2,6,_binary '\0',500000,NULL),(2,7,_binary '\0',500000,NULL),(2,8,_binary '\0',500000,NULL),(2,9,_binary '\0',500000,NULL),(2,10,_binary '\0',500000,NULL),(2,11,_binary '\0',500000,NULL),(2,12,_binary '\0',500000,NULL),(3,1,_binary '\0',500000,NULL),(3,2,_binary '\0',500000,NULL),(3,3,_binary '\0',500000,NULL),(3,4,_binary '\0',500000,NULL),(3,5,_binary '\0',500000,NULL),(3,6,_binary '\0',500000,NULL),(3,7,_binary '\0',500000,NULL),(3,8,_binary '\0',500000,NULL),(3,9,_binary '\0',500000,NULL),(3,10,_binary '\0',500000,NULL),(3,11,_binary '\0',500000,NULL),(4,1,_binary '\0',200000,NULL),(4,2,_binary '\0',NULL,NULL),(4,3,_binary '\0',NULL,NULL),(4,4,_binary '\0',NULL,NULL),(4,5,_binary '\0',NULL,NULL),(4,6,_binary '\0',NULL,NULL),(4,7,_binary '\0',NULL,NULL),(4,8,_binary '\0',NULL,NULL),(4,9,_binary '\0',NULL,NULL),(5,1,_binary '\0',NULL,NULL),(5,2,_binary '\0',NULL,NULL),(5,3,_binary '\0',NULL,NULL),(5,4,_binary '\0',NULL,NULL),(5,5,_binary '\0',NULL,NULL),(5,6,_binary '\0',NULL,NULL),(5,7,_binary '\0',NULL,NULL),(5,8,_binary '\0',NULL,NULL),(5,9,_binary '\0',NULL,NULL),(5,10,_binary '\0',NULL,NULL),(5,11,_binary '\0',NULL,NULL);
/*!40000 ALTER TABLE `phongkhachsan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phucap`
--

DROP TABLE IF EXISTS `phucap`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `phucap` (
  `MaChucVu` varchar(5) NOT NULL,
  `PhuCapAnTrua` int DEFAULT NULL,
  `PhuCapTrachNghiem` int DEFAULT NULL,
  `PhuCapXangXe` int DEFAULT NULL,
  PRIMARY KEY (`MaChucVu`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phucap`
--

LOCK TABLES `phucap` WRITE;
/*!40000 ALTER TABLE `phucap` DISABLE KEYS */;
/*!40000 ALTER TABLE `phucap` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sanpham`
--

DROP TABLE IF EXISTS `sanpham`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sanpham` (
  `MaSanPham` int NOT NULL AUTO_INCREMENT,
  `Ten` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `Gia` int DEFAULT NULL,
  `MoTa` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`MaSanPham`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sanpham`
--

LOCK TABLES `sanpham` WRITE;
/*!40000 ALTER TABLE `sanpham` DISABLE KEYS */;
INSERT INTO `sanpham` VALUES (1,'Mỳ tôm Hảo Hảo',10000,'1'),(2,'Mỳ tôm Ba Miền',10000,'4'),(3,'Bao cao su',10000,'7'),(4,'Giấy ướt',9000,'10'),(5,'BCS',12333,'12321dascasdsa');
/*!40000 ALTER TABLE `sanpham` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'qlks'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-29 16:36:56
