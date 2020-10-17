-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: industry_management
-- ------------------------------------------------------
-- Server version	8.0.13

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
-- Table structure for table `industry`
--

DROP TABLE IF EXISTS `industry`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `industry` (
  `industry_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `created_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_updated_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`industry_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `industry`
--

LOCK TABLES `industry` WRITE;
/*!40000 ALTER TABLE `industry` DISABLE KEYS */;
INSERT INTO `industry` VALUES (1,'SAI Industry','Shivaji Nagar,Balapur','2020-09-05 18:25:19','2020-09-05 18:25:19');
/*!40000 ALTER TABLE `industry` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pack_type`
--

DROP TABLE IF EXISTS `pack_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `pack_type` (
  `pack_type_id` int(11) NOT NULL AUTO_INCREMENT,
  `pack_type_name` varchar(45) DEFAULT NULL,
  `pack_capacity` int(11) DEFAULT NULL,
  `pack_type_desc` text,
  `pack_price` int(10) DEFAULT NULL,
  `created_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_updated_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`pack_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pack_type`
--

LOCK TABLES `pack_type` WRITE;
/*!40000 ALTER TABLE `pack_type` DISABLE KEYS */;
INSERT INTO `pack_type` VALUES (1,'Can',5,'Oil can',NULL,'2020-09-05 18:36:23','2020-09-05 18:36:23'),(2,'Pack',1,'oil litre',NULL,'2020-09-05 18:36:23','2020-09-05 18:36:23'),(3,'tin',10,'oil tin',NULL,'2020-09-05 18:36:23','2020-09-05 18:36:23');
/*!40000 ALTER TABLE `pack_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `packed_stock`
--

DROP TABLE IF EXISTS `packed_stock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `packed_stock` (
  `packed_stock_id` int(11) NOT NULL AUTO_INCREMENT,
  `stock_id` int(11) NOT NULL,
  `pack_type_id` int(11) NOT NULL,
  `packed_quantity` int(11) DEFAULT NULL,
  `packed_litre` int(11) DEFAULT NULL,
  `packed_price_per_quantity` varchar(45) DEFAULT NULL,
  `created_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_updated_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`packed_stock_id`),
  KEY `stock_id_idx` (`stock_id`),
  KEY `packed_stock_id_idx` (`pack_type_id`),
  CONSTRAINT `pack_type_id` FOREIGN KEY (`pack_type_id`) REFERENCES `pack_type` (`pack_type_id`),
  CONSTRAINT `stock_id` FOREIGN KEY (`stock_id`) REFERENCES `stock` (`stock_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `packed_stock`
--

LOCK TABLES `packed_stock` WRITE;
/*!40000 ALTER TABLE `packed_stock` DISABLE KEYS */;
INSERT INTO `packed_stock` VALUES (1,1,1,10,NULL,'90','2020-09-05 18:45:20','2020-09-05 18:45:20'),(2,1,1,10,NULL,'90','2020-09-05 18:45:20','2020-09-05 18:45:20'),(3,1,1,10,NULL,'90','2020-09-05 18:45:20','2020-09-05 18:45:20'),(4,1,1,10,NULL,'90','2020-09-05 18:45:20','2020-09-05 18:45:20'),(5,1,1,10,NULL,'90','2020-09-05 18:45:20','2020-09-05 18:45:20'),(6,1,1,10,NULL,'90','2020-09-05 18:45:20','2020-09-05 18:45:20'),(7,1,1,10,NULL,'90','2020-09-05 18:45:20','2020-09-05 18:45:20'),(8,1,1,10,NULL,'90','2020-09-05 18:45:20','2020-09-05 18:45:20'),(9,1,1,10,NULL,'90','2020-09-05 18:45:20','2020-09-05 18:45:20'),(10,1,1,10,NULL,'90','2020-09-05 18:45:20','2020-09-05 18:45:20'),(11,1,1,10,NULL,'90','2020-09-05 18:45:20','2020-09-05 18:45:20'),(12,1,1,10,NULL,'90','2020-09-05 18:45:20','2020-09-05 18:45:20'),(13,7,1,10,NULL,'5','2020-09-05 18:45:20','2020-09-05 18:45:20');
/*!40000 ALTER TABLE `packed_stock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `product` (
  `product_id` int(11) NOT NULL,
  `industry_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(45) DEFAULT NULL,
  `product_des` text,
  `created_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_updated_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`product_id`),
  KEY `industry_id_idx` (`industry_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,1,'palm oil',NULL,'2020-09-05 18:40:07','2020-09-05 18:40:07'),(2,1,'soya oil',NULL,'2020-09-05 18:40:07','2020-09-05 18:40:07'),(3,1,'cotton oil',NULL,'2020-09-05 18:40:07','2020-09-05 18:40:07');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sale`
--

DROP TABLE IF EXISTS `sale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `sale` (
  `sale_id` int(11) NOT NULL AUTO_INCREMENT,
  `packed_stock_id` int(11) NOT NULL,
  `customer_name` varchar(45) DEFAULT NULL,
  `quanity` int(11) DEFAULT NULL,
  `price` int(11) DEFAULT '0',
  `created_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_updated_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`sale_id`),
  KEY `packed_stock_id_idx` (`packed_stock_id`),
  CONSTRAINT `packed_stock_id` FOREIGN KEY (`packed_stock_id`) REFERENCES `packed_stock` (`packed_stock_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sale`
--

LOCK TABLES `sale` WRITE;
/*!40000 ALTER TABLE `sale` DISABLE KEYS */;
INSERT INTO `sale` VALUES (2,1,'Viku',10,10,'2020-09-06 17:41:00','2020-09-06 17:41:00'),(3,1,'Viku',10,10,'2020-09-06 19:11:05','2020-09-06 19:11:05'),(4,1,'Viku',10,10,'2020-09-06 19:11:23','2020-09-06 19:11:23'),(5,1,'Viku chidu',10,10,'2020-09-09 17:34:56','2020-09-09 17:34:56');
/*!40000 ALTER TABLE `sale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stock`
--

DROP TABLE IF EXISTS `stock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `stock` (
  `stock_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) NOT NULL,
  `stock_in_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `stock_quantity_kg` int(11) DEFAULT NULL,
  `stock_quantity_litre` int(11) DEFAULT NULL,
  `stock_price_per_litre` varchar(45) DEFAULT NULL,
  `stock_price` int(11) DEFAULT NULL,
  `created_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_updated_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`stock_id`),
  KEY `product_id_idx` (`product_id`),
  CONSTRAINT `product_id` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stock`
--

LOCK TABLES `stock` WRITE;
/*!40000 ALTER TABLE `stock` DISABLE KEYS */;
INSERT INTO `stock` VALUES (1,1,'2020-09-05 18:30:00',750,700,NULL,5000,'2020-09-05 18:30:00','2020-09-05 18:30:00'),(2,1,'2020-09-05 18:42:39',1000,950,NULL,4900,'2020-09-05 18:42:39','2020-09-05 18:42:39'),(3,3,'2020-09-05 18:42:39',10000,9500,NULL,50000,'2020-09-05 18:42:39','2020-09-05 18:42:39'),(4,3,'2020-09-05 18:42:39',1,1,NULL,1,'2020-09-05 18:42:39','2020-09-05 18:42:39'),(5,3,'2020-09-05 18:42:39',1,1,NULL,1,'2020-09-06 09:58:39','2020-09-06 09:58:39'),(6,3,'2020-09-05 18:30:00',1,1,NULL,1,'2020-09-06 17:36:36','2020-09-06 17:36:36'),(7,3,'2020-09-05 18:30:00',270,220,NULL,3200,'2020-09-08 18:30:00','2020-09-08 18:30:00');
/*!40000 ALTER TABLE `stock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'industry_management'
--

--
-- Dumping routines for database 'industry_management'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-10-17 20:52:49
