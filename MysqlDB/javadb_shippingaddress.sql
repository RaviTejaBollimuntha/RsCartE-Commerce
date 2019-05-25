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
-- Table structure for table `shippingaddress`
--

DROP TABLE IF EXISTS `shippingaddress`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `shippingaddress` (
  `SHIPPING_ID` int(10) NOT NULL,
  `ADDRESS_1` varchar(200) NOT NULL,
  `ADDRESS_2` varchar(45) NOT NULL,
  `CITY` varchar(30) NOT NULL,
  `ZIP` varchar(45) NOT NULL,
  `STATE` varchar(45) NOT NULL,
  `FULLNAME` varchar(45) NOT NULL,
  `CUSTOMER_ID` int(10) NOT NULL,
  `COUNTRY` varchar(40) NOT NULL,
  PRIMARY KEY (`SHIPPING_ID`),
  KEY `fk_custid_shipadd_idx` (`CUSTOMER_ID`),
  CONSTRAINT `fk_custid_shipadd` FOREIGN KEY (`CUSTOMER_ID`) REFERENCES `customer` (`CUSTOMER_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shippingaddress`
--

LOCK TABLES `shippingaddress` WRITE;
/*!40000 ALTER TABLE `shippingaddress` DISABLE KEYS */;
INSERT INTO `shippingaddress` VALUES (338326,'SR Nagar phase-1','SR nagar','hyd','500038','TS','Ravi Teja',1,'India'),(368249,'SR Nagar','SR nagar','hyd','500038','TS','Ravi Teja',1,'India'),(1784995,'Mgh-35,Ameerpet','Sathyam hall','Addanki','500037','Andhra Pradesh','Jagadeesh',4,'India'),(102378254,'1234-3,NZ','NZ','Adoni','522306','Andhra Pradesh','RAM',604,'India'),(165037943,'4-54,Athota','nadhiveylugu','Tenali','522306','Andhra Pradesh','sai',602,'India'),(202627629,'1234-3,NZ','NZ','Addanki','522306','Andhra Pradesh','RAM',604,'India'),(211647978,'4-50,Athota','nadhiveylugu','Tenali','522306','Andhra Pradesh','ram',604,'India'),(237456865,'1234-3,NZ','NZ','Amur','522306','Andhra Pradesh','RAM',604,'India'),(290560413,'4-54,Athota','nadhiveylugu','Tenali','522306','Andhra Pradesh','ram',604,'India');
/*!40000 ALTER TABLE `shippingaddress` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-05-25 18:57:42
