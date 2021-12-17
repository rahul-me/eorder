-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: orderingdb
-- ------------------------------------------------------
-- Server version	5.7.9-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `audit_itemprice`
--

DROP TABLE IF EXISTS `audit_itemprice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `audit_itemprice` (
  `audit_itemPriceId` int(11) NOT NULL AUTO_INCREMENT,
  `itemMasterId` int(11) NOT NULL,
  `price` float NOT NULL,
  `new price` float NOT NULL,
  `createdBy` int(11) NOT NULL,
  `createdDTTM` varchar(45) NOT NULL,
  `modifiedBy` int(11) NOT NULL,
  `modifiedDTTM` varchar(45) NOT NULL,
  PRIMARY KEY (`audit_itemPriceId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `audit_itemprice`
--

LOCK TABLES `audit_itemprice` WRITE;
/*!40000 ALTER TABLE `audit_itemprice` DISABLE KEYS */;
/*!40000 ALTER TABLE `audit_itemprice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mapping_itemcustomerpricemapping`
--

DROP TABLE IF EXISTS `mapping_itemcustomerpricemapping`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mapping_itemcustomerpricemapping` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `ItemId` int(11) NOT NULL,
  `companyId` int(11) NOT NULL,
  `customerId` int(11) NOT NULL,
  `ItemPrice` float NOT NULL,
  `itemStatus` int(11) DEFAULT '0',
  `createdBy` int(11) DEFAULT NULL,
  `modifiedBy` int(11) DEFAULT NULL,
  `createdDTTM` datetime DEFAULT NULL,
  `modifiedDTTM` datetime DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `unique` (`customerId`,`companyId`,`ItemId`),
  KEY `itemId` (`ItemId`),
  KEY `companyId` (`companyId`),
  KEY `customerId` (`customerId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mapping_itemcustomerpricemapping`
--

LOCK TABLES `mapping_itemcustomerpricemapping` WRITE;
/*!40000 ALTER TABLE `mapping_itemcustomerpricemapping` DISABLE KEYS */;
INSERT INTO `mapping_itemcustomerpricemapping` VALUES (1,1,7,62,20,0,61,61,'2015-09-15 18:31:14','2015-09-15 18:31:14'),(2,2,7,62,50,1,61,61,'2015-09-15 19:17:15','2015-09-15 19:17:15'),(3,15,14,22,20,1,21,21,'2015-09-30 17:59:25','2015-09-30 17:59:25'),(4,19,16,28,30000,1,28,28,'2015-09-30 18:41:34','2015-09-30 18:41:34'),(5,46,35,65,2500,1,64,64,'2015-11-23 16:34:36','2015-11-23 16:34:36');
/*!40000 ALTER TABLE `mapping_itemcustomerpricemapping` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mdm_audit`
--

DROP TABLE IF EXISTS `mdm_audit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mdm_audit` (
  `auditId` int(11) NOT NULL AUTO_INCREMENT,
  `auditName` varchar(45) DEFAULT NULL,
  `auditDescription` varchar(45) DEFAULT NULL,
  `auditBranchCode` varchar(10) DEFAULT NULL,
  `auditKey` int(11) NOT NULL DEFAULT '-1',
  `auditUserId` int(11) DEFAULT '-1',
  `companyId` int(11) DEFAULT '-1',
  `siteId` int(11) DEFAULT '-1',
  `createdBy` int(11) DEFAULT '-1',
  `createdDTTM` datetime DEFAULT NULL,
  `modifiedBy` int(11) DEFAULT '-1',
  `modifiedDTTM` datetime DEFAULT NULL,
  `syncStatus` int(11) DEFAULT '-1',
  `syncStartDTTM` datetime DEFAULT NULL,
  `syncEndDTTM` datetime DEFAULT NULL,
  PRIMARY KEY (`auditId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mdm_audit`
--

LOCK TABLES `mdm_audit` WRITE;
/*!40000 ALTER TABLE `mdm_audit` DISABLE KEYS */;
/*!40000 ALTER TABLE `mdm_audit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mdm_item`
--

DROP TABLE IF EXISTS `mdm_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mdm_item` (
  `itemMasterId` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(150) DEFAULT NULL,
  `SKU` varchar(150) DEFAULT NULL,
  `life` float DEFAULT '0',
  `state` int(11) DEFAULT '-1',
  `isCritical` int(11) DEFAULT '-1',
  `minOrderQuantity` float DEFAULT '0',
  `itemPrice` float DEFAULT '0',
  `returnAllowed` varchar(3) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `isActive` int(11) DEFAULT '1',
  `createdBy` int(11) DEFAULT NULL,
  `createdDTTM` varchar(22) DEFAULT NULL,
  `modifiedBy` varchar(45) DEFAULT NULL,
  `modifiedDTTM` varchar(45) DEFAULT NULL,
  `photo` varchar(100) DEFAULT NULL,
  `itemType` varchar(45) DEFAULT NULL,
  `brand` varchar(45) DEFAULT NULL,
  `modelNo` varchar(45) DEFAULT NULL,
  `tax1` float DEFAULT '0',
  `tax2` float DEFAULT '0',
  `tax3` float DEFAULT '0',
  `itemCategoryMasterId` varchar(45) DEFAULT NULL,
  `measurementMasterId` int(11) DEFAULT '-1',
  `companyMasterId` int(10) DEFAULT '-1',
  `stockQuantity` int(11) DEFAULT '0',
  PRIMARY KEY (`itemMasterId`),
  KEY `itemCategoryId` (`itemCategoryMasterId`),
  KEY `itemMeasurementId` (`measurementMasterId`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mdm_item`
--

LOCK TABLES `mdm_item` WRITE;
/*!40000 ALTER TABLE `mdm_item` DISABLE KEYS */;
INSERT INTO `mdm_item` VALUES (1,'HP Pavellion Laptop ','undefined',0,0,0,0,60000,NULL,'Core-i7 , 4GB RAM, 2TB Memory',1,2,'2015-09-24 10:50:06',NULL,NULL,NULL,NULL,NULL,NULL,0,0,0,NULL,1,3,0),(2,'Camera','CAMERA',0,0,0,0,13000,NULL,'Company : Cannon\r\nMP : 20mpx',1,2,'2015-09-24 10:49:52',NULL,NULL,NULL,NULL,NULL,NULL,0,0,0,NULL,1,3,0),(3,'Basketball','undefined',0,0,0,0,250,NULL,'Reebok have well known reputation in making of sports thing',1,2,'2015-09-24 15:59:32',NULL,NULL,NULL,NULL,NULL,NULL,0,0,0,NULL,1,3,0),(4,'Casual T Shirt','CASUALTSHIRT',0,0,0,0,550,NULL,'Roadster is well known brand for its good quality product',1,2,'2015-09-24 16:23:24',NULL,NULL,NULL,NULL,NULL,NULL,0,0,0,NULL,1,3,0),(5,'Surround System','SURROUNDSYSTEM',0,0,0,0,8000,NULL,'Brand: Sony\r\nType : 5.1',1,2,'2015-09-24 16:45:34',NULL,NULL,NULL,NULL,NULL,NULL,0,0,0,NULL,1,3,0),(6,'Trimmer','TRIMMER',0,0,0,0,2300,NULL,'Brand : Phillips\r\nType : Trimmer only\r\nCharging type : Through cable',1,2,'2015-09-24 17:02:48',NULL,NULL,NULL,NULL,NULL,NULL,0,0,0,NULL,1,3,0),(7,'camera','CAMERA',0,0,0,0,0,NULL,'canon',1,12,'2015-09-30 15:17:49',NULL,NULL,NULL,NULL,NULL,NULL,0,0,0,NULL,4,10,0),(8,'basketball','BASKETBALL',0,0,0,0,60,NULL,'Zooper',1,12,'2015-09-30 15:18:41',NULL,NULL,NULL,NULL,NULL,NULL,0,0,0,NULL,3,10,0),(9,'Cookie and cream','COOKIEANDCREAM',0,0,0,0,200,NULL,'family pack',1,14,'2015-09-30 15:37:00',NULL,NULL,NULL,NULL,NULL,NULL,0,0,0,NULL,9,11,0),(10,'Umbrella','UMBRELLA',0,0,0,0,200,NULL,'altufaltu',1,16,'2015-09-30 15:44:39',NULL,NULL,NULL,NULL,NULL,NULL,0,0,0,NULL,10,12,0),(11,'camera','CAMERA',0,0,0,0,60,NULL,'vastu',1,16,'2015-09-30 15:46:48',NULL,NULL,NULL,NULL,NULL,NULL,0,0,0,NULL,10,12,0),(12,'Kellogs','KELLOGS',0,0,0,0,160,NULL,'nothing nice',1,16,'2015-09-30 15:50:53',NULL,NULL,NULL,NULL,NULL,NULL,0,0,0,NULL,10,12,0),(13,'Powerbank','POWERBANK',0,0,0,0,1299,NULL,'Nice Condition',1,18,'2015-09-30 16:24:50',NULL,NULL,NULL,NULL,NULL,NULL,0,0,0,NULL,11,13,0),(14,'Scroch Pad','SCROCHPAD',0,0,0,0,60,NULL,'Brand : Scroch',1,21,'2015-09-30 16:43:57',NULL,NULL,NULL,NULL,NULL,NULL,0,0,0,NULL,12,14,0),(15,'Arial','ARIAL',0,0,0,0,90,NULL,'Clean and efficient',1,21,'2015-09-30 16:44:44',NULL,NULL,NULL,NULL,NULL,NULL,0,0,0,NULL,12,14,0),(16,'Hide and Seek','HIDEANDSEEK',0,0,0,0,500,NULL,'NIce',1,26,'2015-09-30 18:08:23',NULL,NULL,NULL,NULL,NULL,NULL,0,0,0,NULL,13,15,0),(17,'Bread','BREAD',0,0,0,0,300,NULL,'fine',1,26,'2015-09-30 18:09:00',NULL,NULL,NULL,NULL,NULL,NULL,0,0,0,NULL,13,15,0),(18,'Nokia lumia 620','NOKIALUMIA620',0,0,0,0,8000,NULL,'nice',1,28,'2015-09-30 18:38:48',NULL,NULL,NULL,NULL,NULL,NULL,0,0,0,NULL,14,16,0),(19,'Trimmer','TRIMMER',0,0,0,0,300,NULL,'Phillips',1,28,'2015-09-30 18:39:21',NULL,NULL,NULL,NULL,NULL,NULL,0,0,0,NULL,14,16,0),(20,'Havmor family pack','HAVMORFAMILYPACK',0,0,0,0,500,NULL,'nice',1,30,'2015-09-30 18:49:43',NULL,NULL,NULL,NULL,NULL,NULL,0,0,0,NULL,15,17,0),(21,'Trimmer','TRIMMER',0,0,0,0,1300,NULL,'Nice',1,33,'2015-10-01 11:15:17',NULL,NULL,NULL,NULL,NULL,NULL,0,0,0,NULL,17,19,0),(22,'Maggi','MAGGI',0,0,0,0,10,NULL,'Nestle',1,37,'2015-10-09 11:19:35',NULL,NULL,NULL,NULL,NULL,NULL,0,0,0,NULL,18,24,0),(23,'Food Processor','FOODPROCESSOR',0,0,0,0,1500,NULL,'Glen',1,37,'2015-10-09 11:20:28',NULL,NULL,NULL,NULL,NULL,NULL,0,0,0,NULL,18,24,0),(24,'parleg','PARLEG',0,0,0,0,5,NULL,'Nice',1,42,'2015-10-09 16:55:28',NULL,NULL,NULL,NULL,NULL,NULL,0,0,0,NULL,19,25,0),(25,'pen','PEN',0,0,0,0,3,NULL,'nice',1,42,'2015-10-09 16:55:55',NULL,NULL,NULL,NULL,NULL,NULL,0,0,0,NULL,19,25,0),(26,'Fan','FAN',0,0,0,0,1000,NULL,'Nice',1,44,'2015-10-09 19:12:10',NULL,NULL,NULL,NULL,NULL,NULL,0,0,0,NULL,20,26,0),(27,'Cooker','COOKER',0,0,0,0,450,NULL,'Nice',1,44,'2015-10-09 19:12:41',NULL,NULL,NULL,NULL,NULL,NULL,0,0,0,NULL,20,26,0),(28,'Jandubam','JANDUBAM',0,0,0,0,45,NULL,'Bhai',1,46,'2015-10-09 19:19:52',NULL,NULL,NULL,NULL,NULL,NULL,0,0,0,NULL,21,27,0),(29,'britania gooday','BRITANIAGOODAY',0,0,0,0,20,NULL,'nice',1,46,'2015-10-09 19:20:37',NULL,NULL,NULL,NULL,NULL,NULL,0,0,0,NULL,21,27,0),(30,'parleg','PARLEG',0,0,0,0,5,NULL,'nice',1,48,'2015-10-09 19:32:26',NULL,NULL,NULL,NULL,NULL,NULL,0,0,0,NULL,22,28,0),(31,'britania','BRITANIA',0,0,0,0,10,NULL,'nice',1,48,'2015-10-09 19:32:48',NULL,NULL,NULL,NULL,NULL,NULL,0,0,0,NULL,22,28,0),(32,'parleg','PARLEG',0,0,0,0,5,NULL,'nice',1,50,'2015-10-09 19:53:58',NULL,NULL,NULL,NULL,NULL,NULL,0,0,0,NULL,23,29,0),(33,'thumbsup','THUMBSUP',0,0,0,0,20,NULL,'nice',1,50,'2015-10-09 19:54:33',NULL,NULL,NULL,NULL,NULL,NULL,0,0,0,NULL,23,29,0),(34,'toothbrush','TOOTHBRUSH',0,0,0,0,10,NULL,'oralb',1,52,'2015-10-19 09:41:59',NULL,NULL,NULL,NULL,NULL,NULL,0,0,0,NULL,24,30,0),(35,'soap','SOAP',0,0,0,0,25,NULL,'detol',1,52,'2015-10-19 09:42:29',NULL,NULL,NULL,NULL,NULL,NULL,0,0,0,NULL,24,30,0),(36,'shampoo','SHAMPOO',0,0,0,0,98,NULL,'sunsilk',1,52,'2015-10-19 09:49:54',NULL,NULL,NULL,NULL,NULL,NULL,0,0,0,NULL,24,30,0),(37,'Laptop','LAPTOP',0,0,0,0,40000,NULL,'HP',1,52,'2015-10-22 15:46:15',NULL,NULL,NULL,NULL,NULL,NULL,0,0,0,NULL,24,30,0),(38,'soap','SOAP',0,0,0,0,38,NULL,'nice',1,57,'2015-12-12 14:05:18',NULL,NULL,NULL,NULL,NULL,NULL,0,0,0,NULL,25,33,100),(39,'blezar','BLEZAR',0,0,0,0,5000,NULL,'nice',1,57,'2015-11-16 18:39:46',NULL,NULL,NULL,NULL,NULL,NULL,0,0,0,NULL,25,33,84),(40,'vartul','VARTUL',0,0,0,0,30,NULL,'Nice',1,57,'2015-11-17 10:25:58',NULL,NULL,NULL,NULL,NULL,NULL,0,0,0,NULL,27,33,200),(41,'vasu','VASU',0,0,0,0,50,NULL,'',1,57,'2015-11-17 10:51:09',NULL,NULL,NULL,NULL,NULL,NULL,0,0,0,NULL,27,33,1000),(42,'blezar','BLEZAR',0,0,0,0,3000,NULL,'arrow',1,60,'2015-11-17 16:32:27',NULL,NULL,NULL,NULL,NULL,NULL,0,0,0,NULL,32,34,0),(43,'trouser','TROUSER',0,0,0,0,2890,NULL,'arrow',1,60,'2015-11-17 16:35:19',NULL,NULL,NULL,NULL,NULL,NULL,0,0,0,NULL,32,34,0),(44,'wallet','WALLET',0,0,0,0,500,NULL,'Woodland',1,64,'2015-11-23 12:45:49',NULL,NULL,NULL,NULL,NULL,NULL,0,0,0,NULL,33,35,0),(45,'loffar','LOFFAR',0,0,0,0,1800,NULL,'VC',1,64,'2015-11-23 12:46:22',NULL,NULL,NULL,NULL,NULL,NULL,0,0,0,NULL,33,35,0),(46,'watch','WATCH',0,0,0,0,2300,NULL,'fast-track',1,64,'2015-11-23 12:47:13',NULL,NULL,NULL,NULL,NULL,NULL,0,0,0,NULL,33,35,0),(47,'Camera','CAMERA',0,0,0,0,8000,NULL,'Nikon coolpix, 800R',1,57,'2015-12-12 14:49:58',NULL,NULL,NULL,NULL,NULL,NULL,0,0,0,NULL,25,33,94),(48,'Iphone','IPHONE',0,0,0,0,60000,NULL,'Apple iphone ZRSC',1,57,'2015-12-12 14:57:47',NULL,NULL,NULL,NULL,NULL,NULL,0,0,0,NULL,25,33,98);
/*!40000 ALTER TABLE `mdm_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mdm_itemcategory`
--

DROP TABLE IF EXISTS `mdm_itemcategory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mdm_itemcategory` (
  `itemCategoryMasterId` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(75) DEFAULT NULL,
  `description` varchar(245) DEFAULT NULL,
  `superCategoryId` int(11) DEFAULT '-1',
  `createdBy` int(11) DEFAULT '-1',
  `createdDTTM` datetime DEFAULT NULL,
  `modifiedBy` int(11) DEFAULT NULL,
  `modifiedDTTM` datetime DEFAULT NULL,
  `companyMasterId` int(11) DEFAULT NULL,
  `isActive` int(11) DEFAULT '1',
  PRIMARY KEY (`itemCategoryMasterId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mdm_itemcategory`
--

LOCK TABLES `mdm_itemcategory` WRITE;
/*!40000 ALTER TABLE `mdm_itemcategory` DISABLE KEYS */;
/*!40000 ALTER TABLE `mdm_itemcategory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mdm_measurement`
--

DROP TABLE IF EXISTS `mdm_measurement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mdm_measurement` (
  `measurementMasterId` int(11) NOT NULL AUTO_INCREMENT,
  `unit` varchar(20) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `symbol` varchar(10) DEFAULT NULL,
  `createdBy` int(11) DEFAULT '-1',
  `createdDTTM` datetime DEFAULT NULL,
  `modifiedBy` int(11) DEFAULT '-1',
  `modifiedDTTM` datetime DEFAULT NULL,
  `isActive` int(11) DEFAULT '1',
  `companyMasterId` int(11) DEFAULT NULL,
  PRIMARY KEY (`measurementMasterId`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mdm_measurement`
--

LOCK TABLES `mdm_measurement` WRITE;
/*!40000 ALTER TABLE `mdm_measurement` DISABLE KEYS */;
INSERT INTO `mdm_measurement` VALUES (1,'Number','Quantity','nums',2,'2015-09-24 10:44:58',0,NULL,1,3),(2,'Number','Quantity','num',6,'2015-09-30 10:18:48',0,NULL,1,4),(3,'Number','Quantity','num',12,'2015-09-30 14:05:46',0,NULL,1,10),(4,'Mega Byte','Memory','MB',12,'2015-09-30 14:14:41',0,NULL,1,10),(5,'Giga Byte','Memoery','GB',12,'2015-09-30 14:27:51',0,NULL,1,10),(6,'nibble','Memory','nibble',12,'2015-09-30 15:05:40',0,NULL,1,10),(7,'nb','nb','nb',12,'2015-09-30 15:09:10',0,NULL,1,10),(8,'cel','Temp','c',14,'2015-09-30 15:23:45',0,NULL,1,11),(9,'Quantity','Number','num',14,'2015-09-30 15:33:57',0,NULL,1,11),(10,'Quantity','Number','num',16,'2015-09-30 15:43:55',0,NULL,1,12),(11,'Quantity','Number','num',18,'2015-09-30 16:21:19',0,NULL,1,13),(12,'num','qua','num',21,'2015-09-30 16:41:36',0,NULL,1,14),(13,'qua','num','num',26,'2015-09-30 18:05:37',0,NULL,1,15),(14,'num','qua','qua',28,'2015-09-30 18:34:09',0,NULL,1,16),(15,'Number','qua','num',30,'2015-09-30 18:45:55',0,NULL,1,17),(16,'qua','qua','qua',32,'2015-10-01 10:38:58',0,NULL,1,18),(17,'kg','kg','kg',33,'2015-10-01 11:14:00',0,NULL,1,19),(18,'Quantity','Number','num',37,'2015-10-09 11:18:28',0,NULL,1,24),(19,'Quantity','Number','num',42,'2015-10-09 16:52:56',0,NULL,1,25),(20,'Quality','num','num',44,'2015-10-09 19:11:43',0,NULL,1,26),(21,'num','num','num',46,'2015-10-09 19:18:13',0,NULL,1,27),(22,'qua','num','num',48,'2015-10-09 19:30:45',0,NULL,1,28),(23,'num','qua','num',50,'2015-10-09 19:52:15',0,NULL,1,29),(24,'num','num','num',52,'2015-10-19 09:29:54',0,NULL,1,30),(25,'Number','Quantity','n',57,'2015-11-16 15:29:00',0,NULL,1,33),(26,'kilogram','Weight','kg',57,'2015-11-16 15:29:24',0,NULL,1,33),(27,'ton','weight','ton',57,'2015-11-16 15:32:08',0,NULL,1,33),(28,'Byte','Memory','byte',57,'2015-11-16 16:00:43',0,NULL,1,33),(29,'kilobyte','memory','kb',57,'2015-11-16 16:57:55',0,NULL,1,33),(30,'kilogram','weight','kg',60,'2015-11-17 16:16:36',0,NULL,1,34),(31,'ton','weight','ton',60,'2015-11-17 16:17:09',0,NULL,1,34),(32,'number','Quantity','piece',60,'2015-11-17 16:31:38',0,NULL,1,34),(33,'Number','Quantity','n',64,'2015-11-23 12:40:39',0,NULL,1,35),(34,'KiloGram','WEight','kg',64,'2015-11-23 12:41:04',0,NULL,1,35);
/*!40000 ALTER TABLE `mdm_measurement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mdm_orderstage`
--

DROP TABLE IF EXISTS `mdm_orderstage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mdm_orderstage` (
  `orderStageMasterId` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `createdBy` int(11) DEFAULT NULL,
  `modifiedBy` int(11) DEFAULT NULL,
  `createdDTTM` datetime DEFAULT NULL,
  `modifiedDTTM` datetime DEFAULT NULL,
  `isActive` int(11) DEFAULT '1',
  `companyMasterId` int(11) DEFAULT NULL,
  PRIMARY KEY (`orderStageMasterId`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mdm_orderstage`
--

LOCK TABLES `mdm_orderstage` WRITE;
/*!40000 ALTER TABLE `mdm_orderstage` DISABLE KEYS */;
INSERT INTO `mdm_orderstage` VALUES (1,'Placed','When customer will place order. This order will be displayed to company user and its customer to be named \"PLACED\"',2,0,'2015-09-24 11:24:51',NULL,1,3),(2,'Cancel','When customer will cancel order. These orders are considered as cancel orders',2,0,'2015-09-24 11:26:33',NULL,1,3),(3,'Dispacthed','When order will dispatched from the company it will be considered as dispatched orders.',2,0,'2015-09-24 11:28:43',NULL,1,3),(4,'Received ','When order products will be hand over to concerned person it\'s status will be changed from \"Dispatched\" to \"Received\"',2,0,'2015-09-24 11:35:04',NULL,1,3),(5,'Placed','When customer will first place the order',6,0,'2015-09-30 10:21:10',NULL,1,4),(6,'Canceled','Canceled',12,0,'2015-09-30 15:10:55',NULL,1,10),(7,'Placed','place',12,0,'2015-09-30 15:11:35',NULL,1,10),(8,'placed','placed',14,0,'2015-09-30 15:24:44',NULL,1,11),(9,'cancel','cancel',14,0,'2015-09-30 15:27:31',NULL,1,11),(10,'Placed','pl',16,0,'2015-09-30 15:47:54',NULL,1,12),(11,'Placed','placed',18,0,'2015-09-30 16:21:37',NULL,1,13),(12,'cancel','cancel',18,0,'2015-09-30 16:21:56',NULL,1,13),(13,'Placed','Placed',21,0,'2015-09-30 16:41:54',NULL,1,14),(14,'Placed','Placed',26,0,'2015-09-30 18:05:55',NULL,1,15),(15,'Placed','placed',28,0,'2015-09-30 18:34:41',NULL,1,16),(16,'Place','Place',30,0,'2015-09-30 18:47:50',NULL,1,17),(17,'Place','Place',32,0,'2015-10-01 10:44:53',NULL,1,18),(18,'Place','place',33,0,'2015-10-01 11:14:13',NULL,1,19),(19,'place','place',50,0,'2015-10-09 19:52:29',NULL,1,29),(20,'recieve','receive',50,0,'2015-10-09 19:52:58',NULL,1,29),(21,'placed','first stage',52,0,'2015-10-19 09:30:22',NULL,1,30),(22,'cancel','cancel',52,0,'2015-10-19 09:30:43',NULL,1,30),(23,'cancel','When customer will cancel the order',57,0,'2015-11-16 17:47:17',NULL,1,33),(24,'submit','when place',57,0,'2015-11-16 17:47:54',NULL,1,33),(25,'dispatch','when order is out of delivery',57,0,'2015-11-16 17:17:18',NULL,1,33),(26,'submit','when order will first place',60,0,'2015-11-17 16:17:53',NULL,1,34),(27,'cancel','when order will be canceled by either customer or company',60,0,'2015-11-17 16:28:42',NULL,1,34),(28,'Placed','When user First place order',64,0,'2015-11-23 12:41:37',NULL,1,35),(29,'cancel','when customer will cancel that order',64,0,'2015-11-23 12:42:07',NULL,1,35),(30,'Dispatch','when item will dispatch',64,0,'2015-11-24 10:13:04',NULL,1,35),(31,'Delivered','When items will recieved and verified by customer',64,0,'2015-11-24 10:28:42',NULL,1,35);
/*!40000 ALTER TABLE `mdm_orderstage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mdm_package`
--

DROP TABLE IF EXISTS `mdm_package`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mdm_package` (
  `packageMasterId` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  `duration` int(11) DEFAULT NULL,
  `isActive` varchar(45) DEFAULT NULL,
  `createdDate` date DEFAULT NULL,
  `createdDTTM` datetime DEFAULT NULL,
  `createdBy` int(11) DEFAULT NULL,
  `modifyDate` date DEFAULT NULL,
  `modifyDTTM` datetime DEFAULT NULL,
  `attr1` varchar(45) DEFAULT NULL,
  `attr2` varchar(45) DEFAULT NULL,
  `attr3` varchar(45) DEFAULT NULL,
  `attr4` varchar(45) DEFAULT NULL,
  `attr5` varchar(45) DEFAULT NULL,
  `attr6` varchar(45) DEFAULT NULL,
  `attr7` varchar(45) DEFAULT NULL,
  `attr8` varchar(45) DEFAULT NULL,
  `attr9` varchar(45) DEFAULT NULL,
  `attr10` varchar(45) DEFAULT NULL,
  `charge` int(11) DEFAULT NULL,
  PRIMARY KEY (`packageMasterId`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COMMENT='This table is for order pakaging for different clients those who will use this system.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mdm_package`
--

LOCK TABLES `mdm_package` WRITE;
/*!40000 ALTER TABLE `mdm_package` DISABLE KEYS */;
INSERT INTO `mdm_package` VALUES (13,'Super_Action','Action_pack_for Children',12,'1',NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,5900),(14,'December_Special','Movies pack for all',6,'1',NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1400),(15,'Diwali_Special','One month entertainment',12,'1',NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,23100),(16,'Double Dhamal','Extra Packages Included',12,'1',NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,3400),(17,'SimpleDay','nice',12,'1',NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,2300),(18,'Dunkin','Donut',12,'1',NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,14300),(19,'Navadhya','Solo',8,'1',NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,20001),(20,'SuperFun','Enatertainment',14,'1',NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,10000),(21,'SuperAttractive','Attractive Subscription, Good Offer',12,'1','2015-09-18','2015-09-18 17:30:30',2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,34000),(22,'Fun ','Attractive offers',12,'1','2015-09-19','2015-09-19 19:15:13',2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,3400),(23,'Durable','long lasting',12,'1','2015-09-20','2015-09-20 19:15:13',2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,3400),(24,'Super Fun','In Budget',12,'1','2015-09-21','2015-09-21 19:15:13',2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,3400);
/*!40000 ALTER TABLE `mdm_package` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mdm_userauthorizationmatrix`
--

DROP TABLE IF EXISTS `mdm_userauthorizationmatrix`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mdm_userauthorizationmatrix` (
  `authMatrixId` int(11) NOT NULL AUTO_INCREMENT,
  `RoleId` int(11) DEFAULT NULL,
  `companyId` int(11) DEFAULT NULL,
  `modulekey` varchar(45) DEFAULT NULL,
  `mappingStatus` int(11) DEFAULT NULL,
  `createdDTTM` varchar(45) DEFAULT NULL,
  `createdBY` int(11) DEFAULT NULL,
  `authMatrix_of` int(2) DEFAULT '0',
  PRIMARY KEY (`authMatrixId`)
) ENGINE=InnoDB AUTO_INCREMENT=1294 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mdm_userauthorizationmatrix`
--

LOCK TABLES `mdm_userauthorizationmatrix` WRITE;
/*!40000 ALTER TABLE `mdm_userauthorizationmatrix` DISABLE KEYS */;
INSERT INTO `mdm_userauthorizationmatrix` VALUES (303,6,1,'order_AccessControl',1,'2015-09-22 16:47:10',1,1),(304,6,1,'orderList_AccessControl',1,'2015-09-22 16:47:10',1,1),(305,6,1,'showHideOrder_AccessControl',1,'2015-09-22 16:47:10',1,1),(306,6,1,'orderManagment_AccessControl',1,'2015-09-22 16:47:10',1,1),(307,6,1,'accessControl',1,'2015-09-22 16:47:10',1,1),(308,6,1,'itemPrice_AccessControl',1,'2015-09-22 16:47:10',1,1),(309,6,1,'settingConfigure_AccessControl',1,'2015-09-22 16:47:10',1,1),(310,6,1,'showHideSetting_AccessControl',1,'2015-09-22 16:47:10',1,1),(311,6,1,'package_AccessControl',1,'2015-09-22 16:47:10',1,1),(312,6,1,'packageList_AccessControl',1,'2015-09-22 16:47:10',1,1),(313,6,1,'showHidePackage_AccessControl',1,'2015-09-22 16:47:10',1,1),(314,6,1,'item_AccessControl',1,'2015-09-22 16:47:10',1,1),(315,6,1,'itemList_AccessControl',1,'2015-09-22 16:47:10',1,1),(316,6,1,'showHideItem_AccessControl',1,'2015-09-22 16:47:10',1,1),(317,6,1,'itemCategory_AccessControl',1,'2015-09-22 16:47:10',1,1),(318,6,1,'itemCategoryList_AccessControl',1,'2015-09-22 16:47:10',1,1),(319,6,1,'showHideItemCategory_AccessControl',1,'2015-09-22 16:47:10',1,1),(320,6,1,'orderStage_AccessControl',1,'2015-09-22 16:47:10',1,1),(321,6,1,'orderStageList_AccessControl',1,'2015-09-22 16:47:10',1,1),(322,6,1,'showHideOrderStage_AccessControl',1,'2015-09-22 16:47:10',1,1),(323,6,1,'measurement_AccessControl',1,'2015-09-22 16:47:10',1,1),(324,6,1,'measurementList_AccessControl',1,'2015-09-22 16:47:10',1,1),(325,6,1,'showHideMeasurement_AccessControl',1,'2015-09-22 16:47:10',1,1),(326,6,1,'user_AccessControl',1,'2015-09-22 16:47:10',1,1),(327,6,1,'userList_AccessControl',1,'2015-09-22 16:47:10',1,1),(328,6,1,'showHideUser_AccessControl',1,'2015-09-22 16:47:10',1,1),(329,6,1,'userRole_AccessControl',1,'2015-09-22 16:47:10',1,1),(330,6,1,'userRoleList_AccessControl',1,'2015-09-22 16:47:10',1,1),(331,6,1,'showHideUserRole_AccessControl',1,'2015-09-22 16:47:10',1,1),(332,6,1,'showHideMasterData_AccessControl',1,'2015-09-22 16:47:10',1,1),(610,13,3,'order_AccessControl',1,'2015-09-26 11:21:16',2,1),(611,13,3,'orderList_AccessControl',1,'2015-09-26 11:21:16',2,1),(612,13,3,'showHideOrder_AccessControl',1,'2015-09-26 11:21:16',2,1),(1192,55,30,'order_AccessControl',1,'2015-10-19 09:44:49',52,1),(1193,55,30,'orderList_AccessControl',1,'2015-10-19 09:44:49',52,1),(1194,55,30,'showHideOrder_AccessControl',1,'2015-10-19 09:44:49',52,1),(1236,1,1,'report_AccessControl',1,'2015-11-16 15:09:32',1,1),(1237,1,1,'accessControl',1,'2015-11-16 15:09:32',1,1),(1238,1,1,'showHideSetting_AccessControl',1,'2015-11-16 15:09:32',1,1),(1239,1,1,'package_AccessControl',1,'2015-11-16 15:09:32',1,1),(1240,1,1,'packageList_AccessControl',1,'2015-11-16 15:09:32',1,1),(1241,1,1,'showHidePackage_AccessControl',1,'2015-11-16 15:09:32',1,1),(1242,1,1,'company_AccessControl',1,'2015-11-16 15:09:32',1,1),(1243,1,1,'companyList_AccessControl',1,'2015-11-16 15:09:32',1,1),(1244,1,1,'showHideCompany_AccessControl',1,'2015-11-16 15:09:32',1,1),(1245,1,1,'customer_AccessControl',1,'2015-11-16 15:09:32',1,1),(1246,1,1,'customerList_AccessControl',1,'2015-11-16 15:09:32',1,1),(1247,1,1,'showHideCustomer_AccessControl',1,'2015-11-16 15:09:32',1,1),(1248,1,1,'user_AccessControl',1,'2015-11-16 15:09:32',1,1),(1249,1,1,'userList_AccessControl',1,'2015-11-16 15:09:32',1,1),(1250,1,1,'showHideUser_AccessControl',1,'2015-11-16 15:09:32',1,1),(1251,1,1,'userRole_AccessControl',1,'2015-11-16 15:09:32',1,1),(1252,1,1,'userRoleList_AccessControl',1,'2015-11-16 15:09:32',1,1),(1253,1,1,'showHideUserRole_AccessControl',1,'2015-11-16 15:09:32',1,1),(1254,1,1,'showHideMasterData_AccessControl',1,'2015-11-16 15:09:32',1,1),(1255,2,1,'order_AccessControl',1,'2015-11-16 15:20:19',1,1),(1256,2,1,'orderList_AccessControl',1,'2015-11-16 15:20:19',1,1),(1257,2,1,'showHideOrder_AccessControl',1,'2015-11-16 15:20:19',1,1),(1258,2,1,'report_AccessControl',1,'2015-11-16 15:20:19',1,1),(1259,2,1,'orderManagment_AccessControl',1,'2015-11-16 15:20:19',1,1),(1260,2,1,'accessControl',1,'2015-11-16 15:20:19',1,1),(1261,2,1,'itemPrice_AccessControl',1,'2015-11-16 15:20:19',1,1),(1262,2,1,'settingConfigure_AccessControl',1,'2015-11-16 15:20:19',1,1),(1263,2,1,'showHideSetting_AccessControl',1,'2015-11-16 15:20:19',1,1),(1264,2,1,'item_AccessControl',1,'2015-11-16 15:20:19',1,1),(1265,2,1,'itemList_AccessControl',1,'2015-11-16 15:20:19',1,1),(1266,2,1,'showHideItem_AccessControl',1,'2015-11-16 15:20:19',1,1),(1267,2,1,'itemCategory_AccessControl',1,'2015-11-16 15:20:19',1,1),(1268,2,1,'itemCategoryList_AccessControl',1,'2015-11-16 15:20:19',1,1),(1269,2,1,'showHideItemCategory_AccessControl',1,'2015-11-16 15:20:19',1,1),(1270,2,1,'orderStage_AccessControl',1,'2015-11-16 15:20:19',1,1),(1271,2,1,'orderStageList_AccessControl',1,'2015-11-16 15:20:19',1,1),(1272,2,1,'showHideOrderStage_AccessControl',1,'2015-11-16 15:20:19',1,1),(1273,2,1,'measurement_AccessControl',1,'2015-11-16 15:20:19',1,1),(1274,2,1,'measurementList_AccessControl',1,'2015-11-16 15:20:19',1,1),(1275,2,1,'showHideMeasurement_AccessControl',1,'2015-11-16 15:20:19',1,1),(1276,2,1,'customer_AccessControl',1,'2015-11-16 15:20:19',1,1),(1277,2,1,'customerList_AccessControl',1,'2015-11-16 15:20:19',1,1),(1278,2,1,'showHideCustomer_AccessControl',1,'2015-11-16 15:20:19',1,1),(1279,2,1,'user_AccessControl',1,'2015-11-16 15:20:19',1,1),(1280,2,1,'userList_AccessControl',1,'2015-11-16 15:20:19',1,1),(1281,2,1,'showHideUser_AccessControl',1,'2015-11-16 15:20:19',1,1),(1282,2,1,'userRole_AccessControl',1,'2015-11-16 15:20:19',1,1),(1283,2,1,'userRoleList_AccessControl',1,'2015-11-16 15:20:19',1,1),(1284,2,1,'showHideUserRole_AccessControl',1,'2015-11-16 15:20:19',1,1),(1285,2,1,'showHideMasterData_AccessControl',1,'2015-11-16 15:20:19',1,1),(1288,57,33,'order_AccessControl',1,'2015-11-17 13:20:22',57,1),(1289,57,33,'orderList_AccessControl',1,'2015-11-17 13:20:22',57,1),(1290,57,33,'showHideOrder_AccessControl',1,'2015-11-17 13:20:22',57,1),(1291,59,35,'order_AccessControl',1,'2015-11-23 16:00:29',64,1),(1292,59,35,'orderList_AccessControl',1,'2015-11-23 16:00:29',64,1),(1293,59,35,'showHideOrder_AccessControl',1,'2015-11-23 16:00:29',64,1);
/*!40000 ALTER TABLE `mdm_userauthorizationmatrix` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `msg_messagedetails`
--

DROP TABLE IF EXISTS `msg_messagedetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `msg_messagedetails` (
  `messageDetailsMasterId` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(45) DEFAULT NULL,
  `attachment` varchar(45) DEFAULT NULL,
  `fileType` varchar(45) DEFAULT NULL,
  `fileSize` varchar(45) DEFAULT NULL,
  `messageMasterId` int(11) DEFAULT NULL,
  PRIMARY KEY (`messageDetailsMasterId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `msg_messagedetails`
--

LOCK TABLES `msg_messagedetails` WRITE;
/*!40000 ALTER TABLE `msg_messagedetails` DISABLE KEYS */;
/*!40000 ALTER TABLE `msg_messagedetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `msg_messagemaster`
--

DROP TABLE IF EXISTS `msg_messagemaster`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `msg_messagemaster` (
  `messageMasterId` int(11) NOT NULL AUTO_INCREMENT,
  `senderMasterId` int(11) DEFAULT NULL,
  `receiverMasterId` int(11) DEFAULT NULL,
  `senderState` int(11) DEFAULT NULL,
  `receiverState` int(11) DEFAULT NULL,
  `subject` longtext,
  `companyMasterId` int(11) DEFAULT NULL,
  `isActive` int(11) DEFAULT '1',
  PRIMARY KEY (`messageMasterId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `msg_messagemaster`
--

LOCK TABLES `msg_messagemaster` WRITE;
/*!40000 ALTER TABLE `msg_messagemaster` DISABLE KEYS */;
/*!40000 ALTER TABLE `msg_messagemaster` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `neetai_company`
--

DROP TABLE IF EXISTS `neetai_company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `neetai_company` (
  `companyMasterId` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `address` varchar(245) DEFAULT NULL,
  `contactPersonNumber` varchar(45) DEFAULT NULL,
  `phoneNumber1` varchar(45) DEFAULT NULL,
  `phoneNumber2` varchar(45) DEFAULT NULL,
  `contactEmail` varchar(45) DEFAULT NULL,
  `createdBy` int(11) DEFAULT NULL,
  `modifiedBy` int(11) DEFAULT NULL,
  `createdDTTM` datetime DEFAULT NULL,
  `modifiedDTTM` datetime DEFAULT NULL,
  `logo` longtext,
  `isActive` tinyint(11) DEFAULT '1',
  PRIMARY KEY (`companyMasterId`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `neetai_company`
--

LOCK TABLES `neetai_company` WRITE;
/*!40000 ALTER TABLE `neetai_company` DISABLE KEYS */;
INSERT INTO `neetai_company` VALUES (1,'neetai','145 Suncity Paradise','8460873424','02658010',NULL,'crahul10101991@gmail.com',1,0,'2015-09-23 10:06:43',NULL,NULL,1),(3,'ISKON MEGAMALL','Science Square, Ahmedabad','Nimesh Patel','9988776655','8866775544','ism@gmail.com',1,0,'2015-09-23 19:08:42',NULL,NULL,1),(4,'VillCity','Sector-10, Ahmedabad','Suresh','8899776644','8899776655','s@gmail.com',1,0,'2015-09-30 10:16:32',NULL,NULL,1),(5,'Temp Company','Vadodara','1234567890','1234567890','','abc@gamil.com',1,0,'2015-09-30 10:27:23',NULL,NULL,1),(6,'ABC','pune','1234567890','1234567890','','abc@gamil.com',1,0,'2015-09-30 10:52:47',NULL,NULL,1),(7,'XYZ','gh','1221','2343','','abc@gamil.com',1,0,'2015-09-30 11:01:14',NULL,NULL,1),(8,'DFD','shdh','1232','1221','2334','xyz@gmail.com',1,0,'2015-09-30 11:05:44',NULL,NULL,1),(9,'PQR','ss','332','2322','2332','abc@gmail.com',1,0,'2015-09-30 11:22:59',NULL,NULL,1),(10,'Vartul','Plot-23, Andhrapradesh','8799007755','8877997766q','','var@gmail.com',1,0,'2015-09-30 12:02:51',NULL,NULL,1),(11,'RedCartMall','Plot-21, Bharuch','Bharat','9988006677','8899776655','b@gmail.com',1,0,'2015-09-30 15:20:53',NULL,NULL,1),(12,'Vista Vison','Sector-22, Gandhinagar','Vikas','8800667788','','vik@gmail.com',1,0,'2015-09-30 15:40:26',NULL,NULL,1),(13,'Sales Corner','Vadodara','Vaikunth','8899006655','9988776655','vaikunth@gmail.com',1,0,'2015-09-30 16:17:45',NULL,NULL,1),(14,'Comline','Aksharchowk','Raj','8899776644','','r@gmail.com',1,0,'2015-09-30 16:33:42',NULL,NULL,1),(15,'DMART','vad','jahan','8899776644','8877996655','j@gmail.com',1,0,'2015-09-30 18:04:09',NULL,NULL,1),(16,'Google','Bhachu','Chirag','8899776644','','c@gmail.com',1,0,'2015-09-30 18:29:41',NULL,NULL,1),(17,'Pizza Palace','chankyapuri','naman','9988006677','','n@gmail.com',1,0,'2015-09-30 18:43:51',NULL,NULL,1),(18,'Vision Creation','vad','ishika','8899776655','','i@gmail.com',1,0,'2015-10-01 10:37:44',NULL,NULL,1),(19,'Cinemax','Vad','vihar','9988006677','','v@gmail.com',1,0,'2015-10-01 11:13:01',NULL,NULL,1),(20,'megamore','vad','shivam','9988776655','','s@gmail.com',1,0,'2015-10-01 18:27:53',NULL,NULL,1),(21,'Cinepolis','Vad','sana','9988776655','','s@gmail.com',1,0,'2015-10-01 18:37:54',NULL,NULL,1),(22,'Dwarkesh','Ahe','Vyomesh','9988776655','','s@gmail.com',1,0,'2015-10-01 18:41:09',NULL,NULL,1),(23,'somya','nenital','Varun','8988997766','08460870595','crahul10101991@gmail.com',1,0,'2015-10-06 11:22:13',NULL,NULL,1),(24,'Sahara','Sector-10, Gandhinagar','vasantbhai','8899776688','','v@gmail.com',1,0,'2015-10-09 11:00:30',NULL,NULL,1),(25,'vinevihar','Vad','halo','8899776688','','rahul.chauhan@neetai.com',1,0,'2015-10-09 16:49:40',NULL,NULL,1),(26,'Sathiya','Vad','hazi','8899776688','','c@gmail.com',1,0,'2015-10-09 18:42:48',NULL,NULL,1),(27,'Jahan','Vad','Rahul','9988998877','','rahul.chauhan@neetai.com',1,0,'2015-10-09 19:16:28',NULL,NULL,1),(28,'Detol','Det','Detio','7898098787','','rahul.chauhan@neetai.com',1,0,'2015-10-09 19:26:41',NULL,NULL,1),(29,'Starbajar','Ahe','nahil','8899776688','','rahul.chauhan@neetai.com',1,0,'2015-10-09 19:49:56',NULL,NULL,1),(30,'vasant','vasant','vasant','8899887766','8899776655','sd@gmail.com',1,0,'2015-11-16 12:23:22',NULL,NULL,1),(31,'MACD','Ellora park','Santan','8899887766','','crahul10101991@gmail.com',1,0,'2015-11-16 14:12:08',NULL,NULL,1),(32,'Vijay ele','vad','vishakha','1099887766','','crahul10101991@gmail.com',1,0,'2015-11-16 14:12:16',NULL,NULL,1),(33,'Shakti Sandwich','In Front of MS uni','Vishal','8899889977','','rahul.chauhan@neetai.com',1,0,'2015-11-16 15:12:50',NULL,NULL,1),(34,'vegas','Bharuch','vansh','9900990099','','v@g.c',1,0,'2015-11-17 16:13:36',NULL,NULL,1),(35,'Airlift Foundation','Delhi','Vijay Dinanath','9900990099','','v@g.c',1,0,'2015-11-23 12:38:22',NULL,NULL,1),(36,'woodland products','vadodara','vicky','9988998899','','v@c.c',1,0,'2015-11-24 16:24:15',NULL,NULL,1),(37,'megha ele','vad','megha','9988998899','','m@g.c',1,0,'2015-11-24 16:43:12',NULL,NULL,1),(38,'vasundhara','vad','neeta','8899889988','','c@g.c',1,0,'2015-11-24 16:59:45',NULL,NULL,1),(39,'vasudhara','chennai','vedika','9988998899','','v@g.c',1,0,'2015-11-26 16:06:38',NULL,NULL,1);
/*!40000 ALTER TABLE `neetai_company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `neetai_configuration`
--

DROP TABLE IF EXISTS `neetai_configuration`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `neetai_configuration` (
  `property` varchar(45) NOT NULL DEFAULT '',
  `propertytype` varchar(250) DEFAULT NULL,
  `value` varchar(45) DEFAULT NULL,
  `companyid` int(10) NOT NULL DEFAULT '0',
  PRIMARY KEY (`property`,`companyid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `neetai_configuration`
--

LOCK TABLES `neetai_configuration` WRITE;
/*!40000 ALTER TABLE `neetai_configuration` DISABLE KEYS */;
INSERT INTO `neetai_configuration` VALUES ('DefaultMail','DefaultMail','rahul.chauhan@neetai.com',31),('DefaultPassword','DefaultPassword','rahul@123',31),('DefaultHost','DefaultHost','mail.neetai.com',31),('DefaultCompanyPort','DefaultCompanyPort','587',31),('DefaultCompanyTrust','DefaultCompanyTrust','mail.neetai.com',31),('DefaultMail','DefaultMail','rahul.chauhan@neetai.com',35),('DefaultPassword','DefaultPassword','rahul@123',35),('DefaultHost','DefaultHost','mail.neetai.com',35),('DefaultCompanyPort','DefaultCompanyPort','587',35),('DefaultCompanyTrust','DefaultCompanyTrust','mail.neetai.com',35);
/*!40000 ALTER TABLE `neetai_configuration` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `neetai_userroles`
--

DROP TABLE IF EXISTS `neetai_userroles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `neetai_userroles` (
  `userRolesMasterId` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  `createdBy` int(11) DEFAULT '-1',
  `modifiedBy` int(11) DEFAULT '-1',
  `createdDTTM` datetime DEFAULT NULL,
  `modifiedDTTM` datetime DEFAULT NULL,
  `isActive` int(11) DEFAULT '1',
  `companyMasterId` int(11) DEFAULT '1',
  PRIMARY KEY (`userRolesMasterId`),
  UNIQUE KEY `unique` (`name`,`companyMasterId`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `neetai_userroles`
--

LOCK TABLES `neetai_userroles` WRITE;
/*!40000 ALTER TABLE `neetai_userroles` DISABLE KEYS */;
INSERT INTO `neetai_userroles` VALUES (1,'super admin','Privilleged with all access',1,-1,'2015-09-23 00:00:00',NULL,1,1),(2,'admin',NULL,1,0,'2015-09-23 17:56:34',NULL,1,1),(12,'cmanager','Can operate order module',2,0,'2015-09-23 19:11:51',NULL,1,3),(13,'customer','Can place order',2,0,'2015-09-23 19:17:14',NULL,1,3),(14,'cmanager','Can operate order module',1,0,'2015-09-23 19:29:12',NULL,1,1),(15,'Henry','Can Access Order Peoples also',1,0,'2015-11-16 15:00:51',NULL,1,1),(16,'Visitor','can see reportsdsric',1,0,'2015-09-24 10:25:59',NULL,1,1),(17,'cclerk','can see orders',2,0,'2015-09-28 15:22:57',NULL,1,3),(18,'customer','customer',7,0,'2015-09-30 10:29:42',NULL,1,5),(19,'Accounting','Accounting',7,0,'2015-09-30 10:35:46',NULL,1,5),(20,'Manager','Manager',7,0,'2015-09-30 10:37:04',NULL,1,5),(21,'Assistan','Assistan',7,0,'2015-09-30 10:44:13',NULL,1,5),(22,'customer','customer',8,0,'2015-09-30 10:54:58',NULL,1,6),(24,'Cust','cust',9,0,'2015-09-30 11:02:27',NULL,1,7),(25,'account','account',9,0,'2015-09-30 11:02:56',NULL,1,7),(26,'asasas','asas',9,0,'2015-09-30 11:03:31',NULL,1,7),(27,'Custoo','custoo',10,0,'2015-09-30 11:08:43',NULL,1,8),(28,'account','dsf',11,0,'2015-09-30 11:24:20',NULL,1,9),(29,'customer','can place order',12,0,'2015-09-30 12:22:51',NULL,1,10),(31,'manager','can see orders',12,0,'2015-09-30 15:13:13',NULL,1,10),(32,'customer','customer',14,0,'2015-09-30 15:28:59',NULL,1,11),(33,'manager','can see orders',14,0,'2015-09-30 15:29:43',NULL,1,11),(34,'accountant','accountant',14,0,'2015-09-30 15:30:24',NULL,1,11),(35,'customer','can place orders',16,0,'2015-09-30 15:48:30',NULL,1,12),(36,'customer','customer',18,0,'2015-09-30 16:22:25',NULL,1,13),(37,'manager','manager',18,0,'2015-09-30 16:22:54',NULL,1,13),(38,'customer','customer',21,0,'2015-09-30 16:42:15',NULL,1,14),(39,'manager','can see orders',21,0,'2015-09-30 17:07:34',NULL,1,14),(40,'customer','cut',26,0,'2015-09-30 18:06:23',NULL,1,15),(41,'manager','man',26,0,'2015-09-30 18:06:48',NULL,1,15),(42,'customer','customer',28,0,'2015-09-30 18:35:09',NULL,1,16),(43,'manager','manager',28,0,'2015-09-30 18:35:32',NULL,1,16),(44,'customer','customer',30,0,'2015-09-30 18:48:09',NULL,1,17),(45,'customer','can place orders',32,0,'2015-10-01 10:44:37',NULL,1,18),(46,'customer','cust',33,0,'2015-10-01 11:14:26',NULL,1,19),(47,'customer','customer',37,0,'2015-10-09 11:13:58',NULL,1,24),(48,'manager','manager',37,0,'2015-10-09 11:14:19',NULL,1,24),(49,'customer','customer',42,0,'2015-10-09 16:53:10',NULL,1,25),(50,'customer','customer',44,0,'2015-10-09 19:10:27',NULL,1,26),(51,'cust','cust',46,0,'2015-10-09 19:18:31',NULL,1,27),(52,'cust','hey',48,0,'2015-10-09 19:31:04',NULL,1,28),(53,'cust','cust',50,0,'2015-10-09 19:52:42',NULL,1,29),(54,'customer','customer',52,0,'2015-10-19 09:31:08',NULL,1,30),(55,'manager','manager',52,0,'2015-10-19 09:31:26',NULL,1,30),(56,'Tantri','financial dept',1,0,'2015-11-16 15:00:10',NULL,1,1),(57,'customer','purchase items',57,0,'2015-11-16 16:47:56',NULL,1,33),(58,'customer','can place order',60,0,'2015-11-17 16:29:09',NULL,1,34),(59,'customer','who can place order',64,0,'2015-11-23 12:42:32',NULL,1,35);
/*!40000 ALTER TABLE `neetai_userroles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `neetai_users`
--

DROP TABLE IF EXISTS `neetai_users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `neetai_users` (
  `userMasterId` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `firstName` varchar(45) DEFAULT NULL,
  `lastName` varchar(45) DEFAULT NULL,
  `phoneNumber1` varchar(45) DEFAULT NULL,
  `address` varchar(245) DEFAULT NULL,
  `userRoleName` varchar(45) DEFAULT NULL,
  `createdDTTM` datetime DEFAULT NULL,
  `modifiedDTTM` datetime DEFAULT NULL,
  `createdBy` int(11) DEFAULT '-1',
  `modifiedBy` int(11) DEFAULT '-1',
  `email` varchar(45) DEFAULT NULL,
  `phoneNumber2` varchar(45) DEFAULT NULL,
  `isActive` int(10) DEFAULT '1',
  `userRoleMasterId` int(10) DEFAULT '0',
  `companyMasterId` int(11) DEFAULT NULL,
  `userCode` int(11) DEFAULT '-1',
  `city` varchar(45) DEFAULT NULL,
  `state` varchar(45) DEFAULT NULL,
  `country` varchar(45) DEFAULT NULL,
  `pincode` int(11) DEFAULT '-1',
  PRIMARY KEY (`userMasterId`)
) ENGINE=InnoDB AUTO_INCREMENT=68 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `neetai_users`
--

LOCK TABLES `neetai_users` WRITE;
/*!40000 ALTER TABLE `neetai_users` DISABLE KEYS */;
INSERT INTO `neetai_users` VALUES (1,'superadmin','superadmin','neetai','tech','8460870595','Suncity Paradise','superadmin',NULL,NULL,-1,-1,NULL,NULL,1,1,1,-1,NULL,NULL,NULL,390011),(2,'nims','nims','Nimesh','Patel','8899776677','Torrento','admin','2015-09-23 19:10:33',NULL,1,0,'nims@gmail.com',NULL,1,2,3,NULL,NULL,NULL,NULL,0),(3,'kmashru','kmashru','Kurpa','Mashru','9988778866','KBaug, Vadodara','customer','2015-09-23 19:15:39',NULL,2,0,'kmashru@gmail.com',NULL,1,13,3,NULL,NULL,NULL,NULL,0),(4,'harsh','harsh','Harsh','Chapaneria','8899778866','125-Suncity Paradise, Manjalpur, Vadodara','customer','2015-09-26 11:38:17',NULL,2,0,'harsh@gmail.com',NULL,1,13,3,NULL,NULL,NULL,NULL,0),(5,'Dhar','Dhar','Dharmistha','Chapaneria','8899667744','125-Paradise, Vadodara','customer','2015-09-26 11:41:27',NULL,2,0,'db@gmail.com',NULL,1,13,3,NULL,NULL,NULL,NULL,0),(6,'sj','sj','Suresh','Joshi','8899667744','Sector-10, Ahmedabad','admin','2015-09-30 10:17:44',NULL,1,0,'s@gmail.com',NULL,1,2,4,NULL,NULL,NULL,NULL,0),(7,'temp','temp','Temp','Temp','1234567890','Pune','admin','2015-09-30 10:28:40',NULL,1,0,'abc@gmail.com',NULL,1,2,5,NULL,NULL,NULL,NULL,0),(8,'abc','abc','sds','fg','1234567890','pune','admin','2015-09-30 10:53:44',NULL,1,0,'abc@gmail.com',NULL,1,2,6,NULL,NULL,NULL,NULL,0),(9,'xyz','xyz','fdd','xyz','1234567890','hj','admin','2015-09-30 11:01:50',NULL,1,0,'abc@gmail.com',NULL,1,2,7,NULL,NULL,NULL,NULL,0),(10,'aaa','aaa','FGF','FGFG','1234567890','ASSAS','admin','2015-09-30 11:07:29',NULL,1,0,'abc@gmail.com',NULL,1,2,8,NULL,NULL,NULL,NULL,0),(11,'pqr','pqr','GHG','GHGH','12121212','Pune','admin','2015-09-30 11:23:57',NULL,1,0,'abc@gmail.com',NULL,1,2,9,NULL,NULL,NULL,NULL,0),(12,'ak','ak','Akshay','Chaval','9988779966','plot-21, Andhrapradesh','admin','2015-09-30 12:08:15',NULL,1,0,'ak@gmail.com',NULL,1,2,10,NULL,NULL,NULL,NULL,0),(13,'san','san','Sanjay','Patel','9988007766','Sector-10, Gandhinagar','customer','2015-09-30 15:15:06',NULL,12,0,'san@gmail.com',NULL,1,29,10,NULL,NULL,NULL,NULL,0),(14,'bhau','bhau','Bharat','Champaneria','8800334466','Vadodara','admin','2015-09-30 15:22:06',NULL,1,0,'b@gmail.com',NULL,1,2,11,NULL,NULL,NULL,NULL,0),(15,'jadi','jadi','Bharti','Kapoor','8800667755','Vastrapur, Ahe','customer','2015-09-30 15:32:48',NULL,14,0,'j@gmail.com',NULL,1,32,11,NULL,NULL,NULL,NULL,0),(16,'vik','vik','Vikas','Chaudhary','9900997799','Sector-10,Gandhinagar','admin','2015-09-30 15:42:44',NULL,1,0,'vik@gmail.com',NULL,1,2,12,NULL,NULL,NULL,NULL,0),(17,'cb','cb','bharti','chauhan','08460870595','abcv','customer','2015-09-30 15:50:13',NULL,16,0,'cb@gmail.com',NULL,1,35,12,NULL,NULL,NULL,NULL,0),(18,'vshah','vshah','vaikunth','shah','8800665544','Sector-22, Gandhinagar','admin','2015-09-30 16:20:22',NULL,1,0,'vs@gmail.com',NULL,1,2,13,NULL,NULL,NULL,NULL,0),(19,'daya','daya','Daya','Gada','9909988776','Mumbai','customer','2015-09-30 16:23:55',NULL,18,0,'d@gmail.com',NULL,1,36,13,NULL,NULL,NULL,NULL,0),(20,'bhavi','bhavi','Bhavi','Solanki','8899776655','Sector-20, Ahe','customer','2015-09-30 16:29:10',NULL,18,0,'b@gmail.com',NULL,1,36,13,NULL,NULL,NULL,NULL,0),(21,'raj','raj','Raj','thakkar','7788776655','145 Suncity','admin','2015-09-30 16:40:52',NULL,1,0,'raj@gmail.com',NULL,1,2,14,NULL,NULL,NULL,NULL,0),(22,'vasu','vasu','vansudhara','gautam','8899665544','145 Suncity P','customer','2015-09-30 16:43:21',NULL,21,0,'vas@gmail.com',NULL,1,38,14,NULL,NULL,NULL,NULL,0),(23,'varun','varun','varun','dhavan','8899776655','sector-10, akshardham','customer','2015-09-30 17:00:57',NULL,21,0,'varun@gmail.com',NULL,1,38,14,NULL,NULL,NULL,NULL,0),(24,'ekta','ekta','Ekta ','Patel','08460870595','145 Suncity Paradise Vadodara\r\nBungalow','manager','2015-09-30 17:09:46',NULL,21,0,'crahul10101991@gmail.com',NULL,1,39,14,NULL,NULL,NULL,NULL,0),(25,'palak','palak','Palak','Patel','667788445533','145 Suncity Par','manager','2015-09-30 17:15:31',NULL,21,0,'palak@gmail.com',NULL,1,39,14,NULL,NULL,NULL,NULL,0),(26,'jan','jan','jan','jan','8460870595','145 Suncity P','admin','2015-09-30 18:05:08',NULL,1,0,'crahul10101991@gmail.com',NULL,1,2,15,NULL,NULL,NULL,NULL,0),(27,'bhavi','bhavi','bhavi','bhavi','9988007766','vad','customer','2015-09-30 18:07:41',NULL,26,0,'bhavi@gmail.com',NULL,1,40,15,NULL,NULL,NULL,NULL,0),(28,'chir','chir','chirag','patel','8877005544','145 Suncity Para','admin','2015-09-30 18:33:11',NULL,1,0,'chir@gmail.com',NULL,1,2,16,NULL,NULL,NULL,NULL,0),(29,'ekta','ekta','ekta','ekta','8899665544','Vadodara','customer','2015-09-30 18:36:51',NULL,28,0,'ekta@gmail.com',NULL,1,42,16,NULL,NULL,NULL,NULL,0),(30,'naman','naman','Naman','Vishwas','08460870595','145 Suncity Paradi','admin','2015-09-30 18:44:58',NULL,1,0,'naman@gmail.com',NULL,1,2,17,NULL,NULL,NULL,NULL,0),(31,'sana','sana','sanah','panchal','8988776655','145 Suncity Pa','customer','2015-09-30 18:48:53',NULL,30,0,'s@gmail.com',NULL,1,44,17,NULL,NULL,NULL,NULL,0),(32,'ishika','ishika','ishika','ishika','8899776655','Ahe','admin','2015-10-01 10:38:32',NULL,1,0,'ishika@gmail.com',NULL,1,2,18,NULL,NULL,NULL,NULL,0),(33,'vihar','vihar','vihar','vihar','8766556655','Vad','admin','2015-10-01 11:13:36',NULL,1,0,'vihar@g.com',NULL,1,2,19,NULL,NULL,NULL,NULL,0),(34,'namta','namta','namta','namta','8899776654','Vad','customer','2015-10-01 11:14:59',NULL,33,0,'n@gmail.com',NULL,1,46,19,NULL,NULL,NULL,NULL,0),(35,'sana','sana','sana','sana','9877665544','Vad','admin','2015-10-01 18:39:38',NULL,1,0,'s@g.com',NULL,1,2,21,NULL,NULL,NULL,NULL,0),(36,'Dhamo','Dhamo','Dhamo','Dhamo','9988776655','Ahe','admin','2015-10-01 18:42:20',NULL,1,0,'d@g.com',NULL,1,2,22,NULL,NULL,NULL,NULL,0),(37,'lakhulatpat','lakhulatpat','Vasant','Chaudhari','9877887766','Ahe','admin','2015-10-09 11:01:41',NULL,1,0,'lakhulatpat@gmail.com',NULL,1,2,24,NULL,NULL,NULL,NULL,0),(38,'dharashah','dharashah','dhara','shah','9988776655','Vadodara','customer','2015-10-09 11:15:11',NULL,37,0,'dharashah@gmail.com',NULL,1,47,24,NULL,NULL,NULL,NULL,0),(39,'dishajoshi','dishajoshi','disha','joshi','9988776655','Vadodar','customer','2015-10-09 11:17:59',NULL,37,0,'dishajoshi@gmail.om',NULL,1,47,24,NULL,NULL,NULL,NULL,0),(40,'sidjoshi','sidjoshi','sid','joshi','sidjoshi','sidjoshi','customer','2015-10-09 12:21:33',NULL,37,0,'sidjoshi',NULL,1,47,24,NULL,NULL,NULL,NULL,0),(41,'jagabhai','jagabhai','vasantb','jagu','9988776688','Vadodara','customer','2015-10-09 16:25:55',NULL,37,0,'jagabhai',NULL,1,47,24,NULL,NULL,NULL,NULL,0),(42,'gogaji','gogaji','gogaji','gogaji','8977665544','gogaji','admin','2015-10-09 16:50:41',NULL,1,0,'rahul.chauhan@neetai.com',NULL,1,2,25,NULL,NULL,NULL,NULL,0),(43,'sanubhai','sanubhai','sanu','bhai','8989898989','Vad','customer','2015-10-09 16:55:00',NULL,42,0,'dhananjay.gautam@neetai.com',NULL,1,49,25,NULL,NULL,NULL,NULL,0),(44,'kakaka','kakaka','kaka','kaka','8989768767','Vanraja','admin','2015-10-09 18:44:14',NULL,1,0,'k@gmail.com',NULL,1,2,26,NULL,NULL,NULL,NULL,0),(45,'rahulc','rahulc','Rahul','Chauhan','8899887766','Vad','customer','2015-10-09 19:11:16',NULL,44,0,'crahul10101991@gmail.com',NULL,1,50,26,NULL,NULL,NULL,NULL,0),(46,'dmpatel','dmpatel','Drumil','Patel','9988997766','Vad','admin','2015-10-09 19:17:46',NULL,1,0,'rahul.chauhan@gmail.com',NULL,1,2,27,NULL,NULL,NULL,NULL,0),(47,'saraji','saraji','sara','saraji','9988776655','Vad','cust','2015-10-09 19:19:25',NULL,46,0,'crahul10101991@gmail.com',NULL,1,51,27,NULL,NULL,NULL,NULL,0),(48,'detolji','saraji','datotra','dattodjk','8899889988','Vad','admin','2015-10-09 19:27:39',NULL,1,0,'rahul.chauhan@neetai.com',NULL,1,2,28,NULL,NULL,NULL,NULL,0),(49,'pcRahul','pcRahul','shanabhai','sakia','08460870595','145 Suncity Paradise Vadodara\r\nBungalow','cust','2015-10-09 19:31:56',NULL,48,0,'crahul10101991@gmail.com',NULL,1,52,28,NULL,NULL,NULL,NULL,0),(50,'vidhya','vidhya','vidhya','kunj','8899889976','Ahe','admin','2015-10-09 19:51:27',NULL,1,0,'rahul.chauhan@neetai.com',NULL,1,2,29,NULL,NULL,NULL,NULL,0),(51,'bhaisab','bhaisab','bhaisab','Patel','08460870595','145 Suncity Paradise Vadodara\r\nBungalow','cust','2015-10-09 19:53:29',NULL,50,0,'crahul10101991@gmail.com',NULL,1,53,29,NULL,NULL,NULL,NULL,0),(52,'vspanchal','vspanchal','vasant','panchal','8460870595','145 Suncity Paradise Vadodara\r\nBungalow','admin','2015-10-19 09:28:27',NULL,1,0,'crahul10101991@gmail.com',NULL,1,2,30,NULL,NULL,NULL,NULL,0),(53,'varseth','varseth','varsha','seth','8460870595','145 Suncity Paradise Vadodara\r\nBungalow','customer','2015-10-19 09:38:08',NULL,52,0,'crahul10101991@gmail.com',NULL,1,54,30,NULL,NULL,NULL,NULL,0),(54,'sangat','sangat','sangat','sangat','8460870595','145 Suncity Paradise Vadodara\r\nBungalow','manager','2015-10-19 09:39:59',NULL,52,0,'crahul10101991@gmail.com',NULL,1,55,30,NULL,NULL,NULL,NULL,0),(55,'santan','santan','Santan','Kumar','8460870595','145 SunderVan','admin','2015-10-21 11:32:22',NULL,1,0,'crahul10101991@gmail.com',NULL,1,2,31,NULL,NULL,NULL,NULL,0),(56,'rahulpc','rahulpc','Rahul','Chauhan','8460870595','145 Suncity Paradise Vadodara\r\nBungalow','Tantri','2015-11-16 15:07:07',NULL,1,0,'crahul10101991@gmail.com',NULL,1,56,1,NULL,NULL,NULL,NULL,0),(57,'vishubhai','vishubhai','vishal','bharadwaj','8460870595','145 Suncity Paradise Vadodara\r\nBungalow','admin','2015-11-16 15:17:37',NULL,1,0,'crahul10101991@gmail.com',NULL,1,2,33,NULL,NULL,NULL,NULL,0),(58,'rkgokul','rkgokul','radha','krishna','8899778866','vad','customer','2015-11-16 16:54:21','2015-11-16 16:55:05',57,57,'rkgokul@g.c',NULL,1,57,33,NULL,NULL,NULL,NULL,0),(59,'tripatel','tripatel','trisha','patel','1234567890','asdfg','customer','2015-11-17 13:12:39',NULL,57,0,'t@g.c',NULL,1,57,33,NULL,NULL,NULL,NULL,0),(60,'vanjaha','vanjaha','vansh','jaha','9988990099','bharuch','admin','2015-11-17 16:15:20',NULL,1,0,'c@c.g',NULL,1,2,34,NULL,NULL,NULL,NULL,0),(61,'vidbal','vidbal','vidhya','balan','9999999988','US','customer','2015-11-17 16:30:06',NULL,60,0,'v@b.c',NULL,1,58,34,NULL,NULL,NULL,NULL,0),(62,'sanjkr','sanjkr','santa','joker','9988998899','Bharuch','customer','2015-11-17 16:36:24',NULL,60,0,'s@g.c',NULL,1,58,34,NULL,NULL,NULL,NULL,0),(63,'visrana','visrana','vishakha','rana','8899776688','b-501, Navrang exotic, Behind Shayona City, Vasad','customer','2015-11-19 09:43:01',NULL,57,0,'visrana@gmail.com',NULL,1,57,33,NULL,NULL,NULL,NULL,0),(64,'vdchauhan','vdchauhan','Vijay','Chauhan','9090909090','Delhi','admin','2015-11-23 12:39:50',NULL,1,0,'v@g.com',NULL,1,2,35,NULL,NULL,NULL,NULL,0),(65,'rkshah','rkshah','radha','kishan','8899889988','Delhi','customer','2015-11-23 12:43:27',NULL,64,0,'crahul10101991@gmail.com',NULL,1,59,35,NULL,NULL,NULL,NULL,0),(66,'jcriver','jcriver','jamna','yamuna','9999999999','delhi','customer','2015-11-23 12:44:47',NULL,64,0,'jc@g.c',NULL,1,59,35,NULL,NULL,NULL,NULL,0),(67,'vasudhara','vasudhara','dhara','dhara','9999889988','Chennai','admin','2015-11-26 16:09:28',NULL,1,0,'v@g.c',NULL,1,2,39,NULL,NULL,NULL,NULL,0);
/*!40000 ALTER TABLE `neetai_users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_audit`
--

DROP TABLE IF EXISTS `order_audit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_audit` (
  `auditId` int(10) NOT NULL AUTO_INCREMENT,
  `orderMasterId` int(10) DEFAULT NULL,
  `companyMasterId` int(10) DEFAULT NULL,
  `modifiedDate` date DEFAULT NULL,
  `dispatchedQuantity` int(11) DEFAULT NULL,
  `orderQuantity` int(11) DEFAULT NULL,
  `itemMasterId` int(11) DEFAULT NULL,
  PRIMARY KEY (`auditId`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_audit`
--

LOCK TABLES `order_audit` WRITE;
/*!40000 ALTER TABLE `order_audit` DISABLE KEYS */;
INSERT INTO `order_audit` VALUES (8,66,NULL,'2015-12-12',20000,23000,38),(9,66,NULL,'2015-12-12',200,1000,39),(10,66,NULL,'2015-12-12',20,100,41),(11,68,NULL,'2015-12-12',5000,10000,38),(12,68,NULL,'2015-12-12',250,500,39),(13,68,NULL,'2015-12-12',500,1000,40),(14,68,NULL,'2015-12-12',-5000,10000,38),(15,68,NULL,'2015-12-12',-250,500,39),(16,68,NULL,'2015-12-12',-500,1000,40),(17,68,NULL,'2015-12-12',5000,10000,38),(18,68,NULL,'2015-12-12',250,500,39),(19,68,NULL,'2015-12-12',500,1000,40),(20,67,NULL,'2015-12-12',5000,10000,38),(21,67,NULL,'2015-12-12',4000,5000,39),(22,67,NULL,'2015-12-12',1999,2000,40),(23,66,NULL,'2015-12-12',3000,23000,38),(24,66,NULL,'2015-12-12',800,1000,39),(25,66,NULL,'2015-12-12',80,100,41),(26,67,NULL,'2015-12-12',1000,10000,38),(27,67,NULL,'2015-12-12',1000,5000,39),(28,67,NULL,'2015-12-12',1,2000,40),(29,67,NULL,'2015-12-12',4000,10000,38),(30,68,NULL,'2015-12-12',5000,10000,38),(31,68,NULL,'2015-12-12',250,500,39),(32,68,NULL,'2015-12-12',500,1000,40),(33,69,NULL,'2015-12-12',2,3,48),(34,69,NULL,'2015-12-12',1,5,47),(35,69,NULL,'2015-12-12',5,10,39),(36,69,NULL,'2015-12-12',1,10,39),(37,69,NULL,'2015-12-12',4,10,39),(38,69,NULL,'2015-12-12',1,3,48),(39,69,NULL,'2015-12-12',2,5,47),(40,69,NULL,'2015-12-12',2,5,47);
/*!40000 ALTER TABLE `order_audit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_orderdetail`
--

DROP TABLE IF EXISTS `order_orderdetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_orderdetail` (
  `orderDetailId` int(11) NOT NULL AUTO_INCREMENT,
  `itemMasterId` int(11) DEFAULT '-1',
  `description` varchar(150) DEFAULT NULL,
  `quantity` float DEFAULT '0',
  `rate` float DEFAULT '0',
  `amount` float DEFAULT '0',
  `orderMasterId` int(11) DEFAULT '-1',
  `dispatchedQuantity` int(11) DEFAULT NULL,
  PRIMARY KEY (`orderDetailId`)
) ENGINE=InnoDB AUTO_INCREMENT=152 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_orderdetail`
--

LOCK TABLES `order_orderdetail` WRITE;
/*!40000 ALTER TABLE `order_orderdetail` DISABLE KEYS */;
INSERT INTO `order_orderdetail` VALUES (1,1,'Deliver at my old address',1,60000,60000,1,NULL),(2,2,'Do pack it with gift wrapper',1,13000,13000,1,NULL),(3,3,'Do pack with gift wrap. Get blue color piece',2,250,500,2,NULL),(4,18,'',200,8000,1600000,3,NULL),(5,19,'',400,300,120000,3,NULL),(6,23,'deliver early as possible',1,1500,1500,4,NULL),(7,23,'Deliver early as possible',1,1500,1500,5,NULL),(8,23,'Deliver early as possible',1,1500,1500,6,NULL),(9,22,'deliver at my home',1,10,10,7,NULL),(10,22,'',20,10,200,8,NULL),(11,22,'',30,10,300,8,NULL),(12,22,'',4,10,40,9,NULL),(13,22,'',5,10,50,9,NULL),(14,23,'',1,1500,1500,9,NULL),(15,23,'',20,1500,30000,10,NULL),(16,22,'',20,10,200,10,NULL),(17,23,'',2,1500,3000,11,NULL),(18,23,'',2,1500,3000,12,NULL),(19,22,'',5,10,50,12,NULL),(20,22,'',5,10,50,12,NULL),(21,23,'',2,1500,3000,13,NULL),(22,22,'',5,10,50,13,NULL),(23,23,'',3,1500,4500,14,NULL),(24,23,'',3,1500,4500,15,NULL),(25,23,'',2,1500,3000,16,NULL),(26,23,'',1,1500,1500,16,NULL),(27,22,'',5,10,50,16,NULL),(28,25,'',50,3,150,17,NULL),(29,25,'',20,3,60,17,NULL),(30,24,'',50,5,250,17,NULL),(31,27,'',30,450,13500,18,NULL),(32,27,'',1,450,450,18,NULL),(33,26,'',5,1000,5000,18,NULL),(34,29,'',30,20,600,19,NULL),(35,28,'',300,45,13500,19,NULL),(36,29,'',400,20,8000,19,NULL),(37,31,'',10,10,100,20,NULL),(38,30,'',20,5,100,20,NULL),(39,31,'',25,10,250,20,NULL),(40,31,'',40,10,400,21,NULL),(41,32,'',10,5,50,22,NULL),(42,33,'',50,20,1000,22,NULL),(43,36,'',20,98,1960,23,NULL),(44,36,'noth',10,98,980,24,NULL),(45,36,'',7,98,686,25,NULL),(46,36,'',30,98,2940,26,NULL),(47,36,'',30,98,2940,27,NULL),(48,36,'',20,98,1960,28,NULL),(49,34,'',20,10,200,29,NULL),(50,35,'',30,25,750,29,NULL),(51,36,'',10,98,980,29,NULL),(52,37,'',1,40000,40000,29,NULL),(53,38,'',2,38,76,31,NULL),(54,40,'',3,30,90,32,NULL),(55,39,'nice',2,5000,10000,33,NULL),(56,39,'',1,5000,5000,34,NULL),(57,39,'',1,5000,5000,35,NULL),(58,40,'',3,30,90,36,NULL),(59,40,'',5,30,150,37,NULL),(60,38,'',4,38,152,38,NULL),(62,38,'',10,38,380,39,NULL),(63,39,'',1,5000,5000,40,NULL),(64,40,'',2,30,60,40,NULL),(65,41,'',3,50,150,40,NULL),(66,42,'b',2,3000,6000,41,NULL),(67,43,'t',3,2890,8670,41,NULL),(68,43,'t',5,2890,14450,42,NULL),(69,42,'',2,3000,6000,43,NULL),(70,43,'',1,2890,2890,43,NULL),(71,42,'',2,3000,6000,43,NULL),(72,38,'',2,38,76,44,NULL),(73,38,'',2,38,76,45,NULL),(74,39,'',1,5000,5000,45,NULL),(75,40,'',1,30,30,45,NULL),(76,38,'',3,38,114,46,NULL),(77,39,'',5,5000,25000,46,NULL),(78,39,'',3,5000,15000,47,NULL),(79,41,'',2,50,100,47,NULL),(80,40,'',1,30,30,47,NULL),(81,38,'',2,38,76,48,0),(82,39,'',1,5000,5000,48,0),(83,40,'',1,30,30,48,0),(84,41,'',1,50,50,48,0),(85,40,'',6,30,180,49,0),(86,38,'',5,38,190,50,2),(87,40,'',1,30,30,50,1),(88,41,'',1,50,50,50,1),(89,40,'',1,30,30,51,1),(90,41,'',2,50,100,51,1),(91,40,'',2,30,60,52,1),(92,38,'',5,38,190,52,1),(93,39,'',2,5000,10000,52,1),(94,38,'',10,38,380,53,10),(95,39,'',3,5000,15000,53,3),(96,40,'',2,30,60,53,2),(97,41,'',4,50,200,53,4),(98,38,'',15,38,570,54,15),(99,39,'',5,5000,25000,54,6),(100,40,'',20,30,600,54,20),(101,41,'',50,50,2500,54,50),(102,38,'',50,38,1900,55,3),(103,39,'',20,5000,100000,55,0),(104,40,'',30,30,900,55,5),(105,41,'',30,50,1500,55,15),(106,38,'',500,38,19000,56,50),(107,39,'',100,5000,500000,56,50),(108,40,'',30,30,900,56,20),(109,41,'',100,50,5000,56,50),(110,38,'',20,38,760,57,20),(111,39,'',10,5000,50000,57,10),(112,40,'',20,30,600,57,20),(113,41,'',10,50,500,57,10),(114,44,'',50,500,25000,58,50),(115,45,'',25,1800,45000,58,25),(116,46,'',40,2300,92000,58,40),(117,44,'',100,500,50000,59,100),(118,45,'',1000,1800,1800000,59,1000),(119,46,'',3000,2300,6900000,59,3000),(120,44,'',1000,500,500000,60,1000),(121,45,'',200,1800,360000,60,200),(122,46,'',500,2300,1150000,60,500),(123,46,'',30,2500,75000,61,30),(124,45,'',25000,1800,45000000,61,25000),(125,44,'',10000,500,5000000,61,10000),(126,44,'',4000,500,2000000,62,4000),(127,44,'',3000,500,1500000,62,3000),(128,46,'',5000,2500,12500000,62,5000),(129,44,'',20,500,10000,63,20),(130,45,'',30,1800,54000,63,30),(131,46,'',60,2500,150000,63,60),(132,45,'',25000,1800,45000000,64,10000),(133,45,'',5000,1800,9000000,64,4000),(134,44,'',30000,500,15000000,64,13000),(135,46,'',30000,2500,75000000,64,12000),(136,44,'',25000,500,12500000,65,0),(137,45,'',10000,1800,18000000,65,0),(138,46,'',5000,2300,11500000,65,0),(139,46,'',5000,2300,11500000,65,0),(140,38,'',23000,38,874000,66,23000),(141,39,'',1000,5000,5000000,66,1000),(142,41,'',100,50,5000,66,100),(143,38,'',10000,38,380000,67,10000),(144,39,'',5000,5000,25000000,67,5000),(145,40,'',2000,30,60000,67,2000),(146,38,'',10000,38,380000,68,10000),(147,39,'',500,5000,2500000,68,500),(148,40,'',1000,30,30000,68,1000),(149,48,'',3,60000,180000,69,3),(150,47,'',5,8000,40000,69,5),(151,39,'',10,5000,50000,69,10);
/*!40000 ALTER TABLE `order_orderdetail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_ordermaster`
--

DROP TABLE IF EXISTS `order_ordermaster`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_ordermaster` (
  `orderMasterId` int(11) NOT NULL AUTO_INCREMENT,
  `orderNumber` varchar(45) DEFAULT NULL,
  `state` int(11) DEFAULT '-1',
  `total` float DEFAULT '0',
  `remark` varchar(100) DEFAULT NULL,
  `createdDate` date DEFAULT NULL,
  `createdDTTM` datetime DEFAULT NULL,
  `createdBy` int(11) DEFAULT '-1',
  `modifiedBy` int(11) DEFAULT '0',
  `isClose` tinyint(4) DEFAULT '0',
  `closeBy` int(11) DEFAULT '0',
  `modifiedDTTM` datetime DEFAULT NULL,
  `closedDTTM` datetime DEFAULT NULL,
  `isActive` int(11) DEFAULT '1',
  `companyMasterId` int(11) DEFAULT '-1',
  `userMasterId` int(11) DEFAULT '-1',
  `orderQuantity` int(11) DEFAULT NULL,
  `dispatchedQuantity` int(11) DEFAULT NULL,
  PRIMARY KEY (`orderMasterId`)
) ENGINE=InnoDB AUTO_INCREMENT=70 DEFAULT CHARSET=utf8 COMMENT='				';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_ordermaster`
--

LOCK TABLES `order_ordermaster` WRITE;
/*!40000 ALTER TABLE `order_ordermaster` DISABLE KEYS */;
INSERT INTO `order_ordermaster` VALUES (1,'2015092400001',1,73000,'','2015-09-24','2015-09-24 11:41:13',3,0,0,0,NULL,NULL,1,3,3,NULL,NULL),(2,'2015092500002',1,500,'','2015-09-25','2015-09-25 15:37:09',2,0,0,0,NULL,NULL,1,3,3,NULL,NULL),(3,'2015093000003',1,1720000,'','2015-09-30','2015-09-30 18:40:20',28,0,0,0,NULL,NULL,1,16,28,NULL,NULL),(4,'2015100900004',1,1500,'','2015-10-09','2015-10-09 11:25:39',37,0,0,0,NULL,NULL,1,24,38,NULL,NULL),(5,'2015100900005',1,1500,'','2015-10-09','2015-10-09 11:34:12',37,0,0,0,NULL,NULL,1,24,38,NULL,NULL),(6,'2015100900006',1,1500,'','2015-10-09','2015-10-09 11:34:13',37,0,0,0,NULL,NULL,1,24,38,NULL,NULL),(7,'2015100900007',1,10,'','2015-10-09','2015-10-09 11:35:17',37,0,0,0,NULL,NULL,1,24,39,NULL,NULL),(8,'2015100900008',1,500,'','2015-10-09','2015-10-09 11:43:00',37,0,0,0,NULL,NULL,1,24,39,NULL,NULL),(9,'2015100900009',1,1590,'','2015-10-09','2015-10-09 11:45:37',37,0,0,0,NULL,NULL,1,24,39,NULL,NULL),(10,'2015100900010',1,30200,'','2015-10-09','2015-10-09 12:06:02',37,0,0,0,NULL,NULL,1,24,38,NULL,NULL),(11,'2015100900011',1,3000,'','2015-10-09','2015-10-09 12:13:57',37,0,0,0,NULL,NULL,1,24,39,NULL,NULL),(12,'2015100900012',1,3100,'','2015-10-09','2015-10-09 12:22:31',37,0,0,0,NULL,NULL,1,24,40,NULL,NULL),(13,'2015100900013',1,3050,'','2015-10-09','2015-10-09 12:38:43',37,0,0,0,NULL,NULL,1,24,40,NULL,NULL),(14,'2015100900014',1,4500,'','2015-10-09','2015-10-09 12:40:54',37,0,0,0,NULL,NULL,1,24,40,NULL,NULL),(15,'2015100900015',1,4500,'','2015-10-09','2015-10-09 12:42:43',37,0,0,0,NULL,NULL,1,24,38,NULL,NULL),(16,'2015100900016',1,4550,'','2015-10-09','2015-10-09 16:26:43',37,0,0,0,NULL,NULL,1,24,41,NULL,NULL),(17,'2015100900017',1,460,'','2015-10-09','2015-10-09 16:56:53',42,0,0,0,NULL,NULL,1,25,43,NULL,NULL),(18,'2015100900018',1,18950,'','2015-10-09','2015-10-09 19:13:21',44,0,0,0,NULL,NULL,1,26,45,NULL,NULL),(19,'2015100900019',1,22100,'','2015-10-09','2015-10-09 19:21:29',46,0,0,0,NULL,NULL,1,27,47,NULL,NULL),(20,'2015100900020',1,450,'','2015-10-09','2015-10-09 19:33:40',48,0,0,0,NULL,NULL,1,28,49,NULL,NULL),(21,'2015100900021',1,400,'','2015-10-09','2015-10-09 19:42:28',48,0,0,0,NULL,NULL,1,28,49,NULL,NULL),(22,'2015100900022',20,1050,'','2015-10-09','2015-10-09 19:56:21',50,50,0,0,'2015-10-09 19:59:57',NULL,1,29,51,NULL,NULL),(23,'2015101900023',21,1960,'','2015-10-19','2015-10-19 09:50:55',54,52,0,0,'2015-10-19 18:57:12',NULL,1,30,54,NULL,NULL),(24,'2015101900024',22,980,'','2015-10-19','2015-10-19 09:58:57',54,52,0,0,'2015-10-19 18:55:30',NULL,1,30,54,NULL,NULL),(25,'2015101900025',21,686,'','2015-10-19','2015-10-19 10:05:49',54,52,0,0,'2015-10-19 18:26:15',NULL,1,30,54,NULL,NULL),(26,'2015101900026',1,2940,'','2015-10-19','2015-10-19 10:09:22',54,0,0,0,NULL,NULL,1,30,54,NULL,NULL),(27,'2015101900027',22,2940,'','2015-10-19','2015-10-19 11:59:31',54,52,0,0,'2015-10-19 19:00:15',NULL,1,30,54,NULL,NULL),(28,'2015101900028',1,1960,'','2015-10-19','2015-10-19 15:25:30',52,0,0,0,NULL,NULL,1,30,54,NULL,NULL),(29,'2015102200029',1,41930,'','2015-10-22','2015-10-22 15:47:14',52,0,0,0,NULL,NULL,1,30,53,NULL,NULL),(30,'2015111700030',25,0,'','2015-11-17','2015-11-17 10:54:54',57,57,0,0,'2015-11-17 12:55:06',NULL,1,33,58,NULL,NULL),(31,'2015111700031',24,76,'','2015-11-17','2015-11-17 11:04:36',57,57,0,0,'2015-11-17 12:17:19',NULL,1,33,58,NULL,NULL),(32,'2015111700032',24,90,'','2015-11-17','2015-11-17 11:04:53',57,57,0,0,'2015-11-17 12:17:20',NULL,1,33,58,NULL,NULL),(33,'2015111700033',24,10000,'','2015-11-17','2015-11-17 11:06:13',57,57,0,0,'2015-11-17 12:17:20',NULL,1,33,58,NULL,NULL),(34,'2015111700034',25,5000,'','2015-11-17','2015-11-17 11:08:37',57,57,0,0,'2015-11-17 13:04:33',NULL,1,33,58,NULL,NULL),(35,'2015111700035',1,5000,'','2015-11-17','2015-11-17 13:09:17',58,0,0,0,NULL,NULL,1,33,58,NULL,NULL),(36,'2015111700036',1,90,'','2015-11-17','2015-11-17 13:12:59',57,0,0,0,NULL,NULL,1,33,59,NULL,NULL),(37,'2015111700037',1,150,'','2015-11-17','2015-11-17 13:17:07',59,0,0,0,NULL,NULL,1,33,59,NULL,NULL),(38,'2015111700038',1,152,'','2015-11-17','2015-11-17 13:18:19',58,57,0,0,'2015-11-17 13:23:16',NULL,0,33,58,NULL,NULL),(39,'2015111700039',1,380,'','2015-11-17',NULL,57,57,0,0,'2015-11-17 14:22:46',NULL,0,33,59,NULL,NULL),(40,'2015111700040',1,5210,'','2015-11-17','2015-11-17 15:12:39',57,0,0,0,NULL,NULL,1,33,59,NULL,NULL),(41,'2015111700041',26,14670,'','2015-11-17','2015-11-17 16:40:39',60,60,0,0,'2015-11-17 16:47:29',NULL,1,34,61,NULL,NULL),(42,'2015111700042',1,14450,'','2015-11-17','2015-11-17 17:03:21',60,0,0,0,NULL,NULL,1,34,61,NULL,NULL),(43,'2015111700043',1,14890,'','2015-11-17','2015-11-17 17:34:37',60,0,0,0,NULL,NULL,1,34,62,NULL,NULL),(44,'2015111800044',1,76,'','2015-11-18','2015-11-18 14:21:40',57,0,0,0,NULL,NULL,1,33,59,NULL,NULL),(45,'2015111800045',1,5106,'','2015-11-18','2015-11-18 14:37:01',57,0,0,0,NULL,NULL,1,33,59,NULL,NULL),(46,'2015111800046',1,25114,'','2015-11-18','2015-11-18 15:34:41',57,0,0,0,NULL,NULL,1,33,59,0,0),(47,'2015111800047',1,15130,'','2015-11-18','2015-11-18 15:37:51',57,0,0,0,NULL,NULL,1,33,59,6,0),(48,'2015111800048',1,5156,'','2015-11-18','2015-11-18 16:44:35',57,0,0,0,NULL,NULL,1,33,59,5,0),(49,'2015111800049',1,180,'','2015-11-18','2015-11-18 17:33:57',57,0,0,0,NULL,NULL,1,33,58,6,0),(50,'2015111900050',1,270,'','2015-11-19','2015-11-19 09:43:40',57,0,0,0,NULL,NULL,1,33,63,7,0),(51,'2015112300051',1,130,'','2015-11-23','2015-11-23 09:38:07',57,0,0,0,NULL,NULL,1,33,63,3,1),(52,'2015112300052',1,10250,'','2015-11-23','2015-11-23 10:27:23',57,0,0,0,NULL,NULL,1,33,63,9,0),(53,'2015112300053',1,15640,'','2015-11-23','2015-11-23 10:31:37',57,0,0,0,NULL,NULL,1,33,59,19,0),(54,'2015112300054',1,28670,'','2015-11-23','2015-11-23 10:59:16',57,0,0,0,NULL,NULL,1,33,63,90,0),(55,'2015112300055',1,104300,'','2015-11-23','2015-11-23 11:02:35',57,0,0,0,NULL,NULL,1,33,58,130,0),(56,'2015112300056',1,524900,'','2015-11-23','2015-11-23 11:16:45',57,0,0,0,NULL,NULL,1,33,59,730,40),(57,'2015112300057',1,51860,'','2015-11-23','2015-11-23 11:59:18',57,0,0,0,NULL,NULL,1,33,58,60,60),(58,'2015112300058',29,162000,'','2015-11-23','2015-11-23 12:48:12',64,64,0,0,'2015-11-24 13:01:08',NULL,1,35,65,115,115),(59,'2015112300059',29,8750000,'','2015-11-23','2015-11-23 12:51:58',64,64,0,0,'2015-11-24 13:02:21',NULL,1,35,65,4100,4100),(60,'2015112300060',31,2010000,'','2015-11-23','2015-11-23 16:26:09',65,64,0,0,'2015-11-24 11:58:16',NULL,1,35,65,1700,1700),(61,'2015112300061',31,50075000,'','2015-11-23','2015-11-23 16:35:53',64,64,0,0,'2015-11-24 12:06:37',NULL,1,35,65,35030,35030),(62,'2015112300062',31,16000000,'','2015-11-23','2015-11-23 16:38:27',65,64,0,0,'2015-11-24 10:29:42',NULL,1,35,65,12000,12000),(63,'2015112400063',31,214000,'','2015-11-24','2015-11-24 13:09:40',64,64,0,0,'2015-11-24 13:35:15',NULL,1,35,65,110,110),(64,'2015112400064',30,144000000,'','2015-11-24','2015-11-24 13:15:00',64,64,0,0,'2015-11-24 14:37:06',NULL,1,35,65,90000,39000),(65,'2015112600065',1,53500000,'','2015-11-26','2015-11-26 15:41:55',64,0,0,0,NULL,NULL,1,35,66,45000,0),(66,'2015121200066',25,5879000,'','2015-12-12','2015-12-12 11:29:27',57,57,0,0,'2015-12-12 13:59:43',NULL,1,33,63,24100,24100),(67,'2015121200067',25,25440000,'','2015-12-12','2015-12-12 11:36:54',57,57,0,0,'2015-12-12 14:00:03',NULL,1,33,58,17000,17000),(68,'2015121200068',25,2910000,'','2015-12-12','2015-12-12 11:43:17',57,57,0,0,'2015-12-12 14:00:15',NULL,1,33,59,11500,11500),(69,'2015121200069',1,270000,'','2015-12-12','2015-12-12 17:16:27',57,0,0,0,NULL,NULL,1,33,58,18,18);
/*!40000 ALTER TABLE `order_ordermaster` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-12-12 17:51:17
