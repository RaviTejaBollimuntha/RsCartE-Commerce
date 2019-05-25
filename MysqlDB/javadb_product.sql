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
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `product` (
  `PRODUCT_ID` int(10) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(45) NOT NULL,
  `PRICE` int(10) NOT NULL,
  `CATEGORY_ID` int(10) NOT NULL,
  `DESCRIPTION` varchar(200) NOT NULL,
  `SUBCATEGORY_ID` int(10) NOT NULL,
  `MANUFACTURER` varchar(45) NOT NULL,
  `CREATED_ON` date NOT NULL,
  `FEATURED` int(10) NOT NULL,
  `AVAILABLE` int(10) NOT NULL,
  PRIMARY KEY (`PRODUCT_ID`),
  KEY `fk_subcategory_prod_idx` (`SUBCATEGORY_ID`),
  KEY `fk_category_prod_idx` (`CATEGORY_ID`),
  CONSTRAINT `fk_category_prod` FOREIGN KEY (`CATEGORY_ID`) REFERENCES `category` (`CATEGORY_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_subcategory_prod` FOREIGN KEY (`SUBCATEGORY_ID`) REFERENCES `subcategory` (`SUBCATEGORY_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=127 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (100,'iPhone 6 16GB',40000,1000125,' iPhone 6 is comfortable to carry ',1000100,'Apple','2019-03-01',1,125),(101,'iPhone 6 32GB',40000,1000125,'iPhone 6 32GB',1000100,'Apple','2019-03-02',0,455),(102,'iPhone 6 64GB',50000,1000125,'iPhone 6 64GB',1000100,'Apple','2019-03-03',1,125),(103,'iPhone 5 64GB',50000,1000125,'iPhone 6 64GB',1000100,'Apple','2019-03-04',0,489),(104,'iPhone 5 32GB',45000,1000125,'iPhone 6 32GB',1000100,'Apple','2019-03-04',1,45846),(105,'iPhone 5 16GB',35000,1000125,'iPhone 6 16GB',1000100,'Apple','2019-03-05',1,785),(106,'Motorola Moto E',7000,1000125,'Motorola Moto E',1000101,'Motorola','2019-03-06',1,45),(107,'Motorola Moto G',10000,1000125,'Motorola Moto G',1000101,'Motorola','2019-03-07',1,85),(108,'Motorola Moto G2',13000,1000125,'Motorola Moto G2',1000101,'Motorola','2019-03-08',1,93),(110,'Motorola Moto X2',35000,1000125,'Motorola Moto X2',1000101,'Motorola','2019-03-08',0,78),(111,'Sony Xperia M2 Black',40000,1000125,'Sony Xperia M2 Black',1000115,'Sony','2019-03-10',1,89),(112,'Sony Xperia M2 Silver',45000,1000125,'Sony Xperia M2 Silver',1000115,'Sony','2019-03-19',0,453),(113,'Sony Xperia M2 White',45000,1000125,'Sony Xperia M2 White',1000115,'Sony','2019-03-19',1,789),(114,'Sony Xperia M2 Gold',40000,1000125,'Sony Xperia M2 Gold',1000115,'Sony','2019-03-18',1,255),(115,'Sony Xperia White',30000,1000125,'Sony Xperia White',1000115,'Sony','2019-03-12',1,4775),(116,'Sony Xperia Black',35000,1000125,'Sony Xperia Black',1000115,'Sony','2019-03-15',1,753),(117,'Blackberry 1',20000,1000125,'Blackberry 1',1000106,'Blackberry','2019-03-14',1,7553),(118,'Blackberry 2',30000,1000125,'Blackberry  phone',1000106,'Blackberry','2019-03-16',1,789),(119,'Blackberry 3',40000,1000125,'Blackberry 3',1000106,'Blackberry','2019-03-12',1,369),(120,'Blackberry 4',50000,1000125,'Blackberry 4',1000106,'Blackberry','2019-03-17',0,752),(121,'Immortals of Meluha',135,1000126,'Immortals of Meluha',1000101,'Meluha','2019-03-20',1,912),(122,'Immortals of Meluha - Secret of Nagas',135,1000126,'Immortals of Meluha - Secret of Nagas',1000101,'Meluha','2016-03-21',1,753),(123,'Immortals of Meluha - Oath of Vayuputras',135,1000126,'Immortals of Meluha - Oath of Vayuputras',1000101,'Meluha','2015-03-12',1,951),(124,'World of Warcraft - Rise of the Horde',500,1000126,'World of Warcraft - Rise of the Horde',1000101,'Warcraft','2018-03-19',1,264),(126,'Captain Marvel (2019)  Telugu Dubbed Movie ',600,1000127,'Carol Danvers as she becomes one of the universe’s most powerful heroes when Earth is caught in the middle of a galactic war between two alien races. ',1000107,'marvel ','2016-03-13',1,20);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-05-25 18:57:35
