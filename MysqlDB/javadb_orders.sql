-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: localhost    Database: javadb
-- ------------------------------------------------------
-- Server version	5.7.20-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `orders` (
  `ORDER_ID` bigint(64) NOT NULL,
  `CREATEDDATE` date NOT NULL,
  `UPDATEDDATE` date NOT NULL,
  `EMAIL_ADDRESS` varchar(45) NOT NULL,
  `ORDER_STATUS` varchar(45) NOT NULL,
  `ORDER_SUBTOTAL` int(10) NOT NULL,
  `CUSTOMER_ID` int(10) NOT NULL,
  `SHIPPING_ID` int(10) NOT NULL,
  PRIMARY KEY (`ORDER_ID`),
  KEY `fk_shipid_order_idx` (`SHIPPING_ID`),
  KEY `fk_custid_order_idx` (`CUSTOMER_ID`),
  CONSTRAINT `fk_custid_order` FOREIGN KEY (`CUSTOMER_ID`) REFERENCES `customer` (`CUSTOMER_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_shipid_order` FOREIGN KEY (`SHIPPING_ID`) REFERENCES `shippingaddress` (`SHIPPING_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (2122640,'2018-02-02','2018-02-02','raviteja@gmail.com','IN_PROCESS',185,1,338326),(24703328,'2019-03-03','2019-03-03','ram@gmail.com','COMPLETED',56056,604,102378254),(31467524,'2019-03-03','2019-03-03','ram@gmail.com','IN_PROCESS',245245,604,202627629),(54681640,'2018-02-01','2018-02-01','ram@gmail.com','IN_PROCESS',45045,604,290560413),(54934112,'2018-02-01','2018-02-01','ram@gmail.com','IN_PROCESS',45045,604,290560413),(71573416,'2018-02-02','2018-02-02','ram@gmail.com','IN_PROCESS',165,604,290560413),(74932864,'2018-02-02','2018-02-02','ram@gmail.com','IN_PROCESS',165,604,290560413),(75308552,'2018-02-02','2018-02-02','ram@gmail.com','IN_PROCESS',185,604,290560413),(77844144,'2018-02-02','2018-02-02','ram@gmail.com','IN_PROCESS',500,604,211647978),(80499328,'2018-02-02','2018-02-02','ram@gmail.com','IN_PROCESS',38295,604,290560413);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-05-25 18:57:40
