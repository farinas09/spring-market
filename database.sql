CREATE DATABASE  IF NOT EXISTS `market` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `market`;
-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: market
-- ------------------------------------------------------
-- Server version	8.0.26

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
-- Table structure for table `categories`
--

DROP TABLE IF EXISTS `categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categories` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `description` varchar(45) NOT NULL,
  `status` tinyint(1) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modified_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories` VALUES (1,'Frutas',1,'2021-10-24 19:35:52','2021-10-25 04:06:11'),(2,'Pastelería',1,'2021-10-24 19:35:52','2021-10-24 19:35:52'),(3,'Carnes y pescados',1,'2021-10-24 19:35:52','2021-10-24 19:35:52'),(4,'Lácteos y huevos',1,'2021-10-24 19:35:52','2021-10-24 19:35:52'),(5,'Bebidas',1,'2021-10-24 19:35:52','2021-10-24 19:35:52'),(6,'Licores',1,'2021-10-24 19:35:52','2021-10-24 19:35:52'),(7,'Cuidado personal',1,'2021-10-24 19:35:52','2021-10-24 19:35:52'),(8,'Despensa',1,'2021-10-24 19:35:52','2021-10-24 19:35:52'),(20,'asdfsadfdsg',1,'2021-10-24 22:13:38','2021-10-24 22:13:38'),(21,'Muebles',1,'2021-10-24 22:17:37','2021-10-25 04:18:30');
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `products` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `category_id` bigint unsigned NOT NULL,
  `sale_price` decimal(16,2) DEFAULT NULL,
  `status` tinyint(1) DEFAULT '1',
  `purchase_cost` decimal(16,2) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modified_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `fk_PRODUCTS_CATEGORIES` (`category_id`),
  CONSTRAINT `fk_PRODUCTS_CATEGORIES` FOREIGN KEY (`category_id`) REFERENCES `categories` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,'Guayaba',1,25.00,1,20.00,'2021-10-24 19:35:52','2021-10-25 04:21:40'),(2,'Mango',1,500.00,1,300.00,'2021-10-24 19:35:52','2021-10-24 19:35:52'),(3,'Manzana',1,500.00,1,300.00,'2021-10-24 19:35:52','2021-10-24 19:35:52'),(4,'Aguacate',1,500.00,1,300.00,'2021-10-24 19:35:52','2021-10-24 19:35:52'),(5,'Lechuga',1,500.00,1,300.00,'2021-10-24 19:35:52','2021-10-24 19:35:52'),(6,'Tomate',1,500.00,1,300.00,'2021-10-24 19:35:52','2021-10-24 19:35:52'),(7,'Pera',1,500.00,1,300.00,'2021-10-24 19:35:52','2021-10-24 19:35:52'),(8,'Apio',1,500.00,1,300.00,'2021-10-24 19:35:52','2021-10-24 19:35:52'),(9,'Papaya',1,500.00,1,300.00,'2021-10-24 19:35:52','2021-10-24 19:35:52'),(10,'Limón',1,500.00,1,300.00,'2021-10-24 19:35:52','2021-10-24 19:35:52'),(11,'Brownie',2,500.00,1,300.00,'2021-10-24 19:35:52','2021-10-24 19:35:52'),(12,'Pan tajado',2,500.00,1,300.00,'2021-10-24 19:35:52','2021-10-24 19:35:52'),(13,'Torta',2,500.00,1,300.00,'2021-10-24 19:35:52','2021-10-24 19:35:52'),(14,'Tortilla',2,500.00,1,300.00,'2021-10-24 19:35:52','2021-10-24 19:35:52'),(15,'Tostadas',2,500.00,1,300.00,'2021-10-24 19:35:52','2021-10-24 19:35:52'),(16,'Chocorramo',2,500.00,1,300.00,'2021-10-24 19:35:52','2021-10-24 19:35:52'),(17,'Salmón',3,500.00,1,300.00,'2021-10-24 19:35:52','2021-10-24 19:35:52'),(18,'Punta de anca',3,500.00,1,300.00,'2021-10-24 19:35:52','2021-10-24 19:35:52'),(19,'Posta',3,500.00,1,300.00,'2021-10-24 19:35:52','2021-10-24 19:35:52'),(20,'Costilla de cerdo',3,500.00,1,300.00,'2021-10-24 19:35:52','2021-10-24 19:35:52'),(21,'Tilapia',3,500.00,1,300.00,'2021-10-24 19:35:52','2021-10-24 19:35:52'),(22,'Merluza',3,500.00,1,300.00,'2021-10-24 19:35:52','2021-10-24 19:35:52'),(23,'Leche de vaca',4,500.00,1,300.00,'2021-10-24 19:35:52','2021-10-24 19:35:52'),(24,'Queso',4,500.00,1,300.00,'2021-10-24 19:35:52','2021-10-24 19:35:52'),(25,'Huevos de gallina feliz',4,500.00,1,300.00,'2021-10-24 19:35:52','2021-10-24 19:35:52'),(26,'Clara de huevo',4,500.00,1,300.00,'2021-10-24 19:35:52','2021-10-24 19:35:52'),(27,'Suero costeño',4,500.00,1,300.00,'2021-10-24 19:35:52','2021-10-24 19:35:52'),(28,'Agua',5,500.00,1,300.00,'2021-10-24 19:35:52','2021-10-24 19:35:52'),(29,'Jugo de naranja',5,500.00,1,300.00,'2021-10-24 19:35:52','2021-10-24 19:35:52'),(30,'Gaseosa Colombiana',5,500.00,1,300.00,'2021-10-24 19:35:52','2021-10-24 19:35:52'),(31,'Jugo de Lulo',5,500.00,1,300.00,'2021-10-24 19:35:52','2021-10-24 19:35:52'),(32,'Tea',5,500.00,1,300.00,'2021-10-24 19:35:52','2021-10-24 19:35:52'),(33,'Cerveza',6,500.00,1,300.00,'2021-10-24 19:35:52','2021-10-24 19:35:52'),(34,'Tequila',6,500.00,1,300.00,'2021-10-24 19:35:52','2021-10-24 19:35:52'),(35,'Ron',6,500.00,1,300.00,'2021-10-24 19:35:52','2021-10-24 19:35:52'),(36,'Aguardiente Antioqueño',6,500.00,1,300.00,'2021-10-24 19:35:52','2021-10-24 19:35:52'),(37,'Vino',6,500.00,1,300.00,'2021-10-24 19:35:52','2021-10-24 19:35:52'),(38,'Crema dental',7,500.00,1,300.00,'2021-10-24 19:35:52','2021-10-24 19:35:52'),(39,'Jabón de manos',7,500.00,1,300.00,'2021-10-24 19:35:52','2021-10-24 19:35:52'),(40,'Enjuague bucal',7,500.00,1,300.00,'2021-10-24 19:35:52','2021-10-24 19:35:52'),(41,'Shampoo',7,500.00,1,300.00,'2021-10-24 19:35:52','2021-10-24 19:35:52'),(42,'Desodorante',7,500.00,1,300.00,'2021-10-24 19:35:52','2021-10-24 19:35:52'),(43,'Arroz',8,500.00,1,300.00,'2021-10-24 19:35:52','2021-10-24 19:35:52'),(44,'Lentejas',8,500.00,1,300.00,'2021-10-24 19:35:52','2021-10-24 19:35:52'),(45,'Harina',8,500.00,1,300.00,'2021-10-24 19:35:52','2021-10-24 19:35:52'),(46,'Sal',8,500.00,1,300.00,'2021-10-24 19:35:52','2021-10-24 19:35:52'),(47,'Aceite',8,500.00,1,300.00,'2021-10-24 19:35:52','2021-10-24 19:35:52'),(48,'Cereal',8,500.00,1,300.00,'2021-10-24 19:35:52','2021-10-24 19:35:52'),(49,'Frijol',8,500.00,1,300.00,'2021-10-24 19:35:52','2021-10-24 19:35:52'),(50,'Café',8,500.00,1,300.00,'2021-10-24 19:35:52','2021-10-24 19:35:52');
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `id_role` int NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_role`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'ROLE_ADMIN'),(2,'ROLE_USER');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_role` (
  `id_user` int NOT NULL,
  `id_role` int NOT NULL,
  PRIMARY KEY (`id_user`,`id_role`),
  KEY `FK2yqlxhjhgilevh7qvt2ve6udh` (`id_role`),
  CONSTRAINT `FK2yqlxhjhgilevh7qvt2ve6udh` FOREIGN KEY (`id_role`) REFERENCES `roles` (`id_role`),
  CONSTRAINT `FKr53t650tbjk5yipcm228wf1nc` FOREIGN KEY (`id_user`) REFERENCES `users` (`id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,1),(1,2),(2,2);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id_user` int NOT NULL AUTO_INCREMENT,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `last_login` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'2021-10-24 22:38:22','2021-10-25 04:38:23','admin','$2a$10$.jZv9pBV2xnWI8bYGeNrT.jnBRjOqLrW68nSGjLjHt2fP03TTvPJm',_binary '','admin'),(2,'2021-10-24 23:00:05','2021-10-25 05:00:05','test','$2a$10$RrpSLp9RNeleecV2HCQaXOpGJGTT3hr2UsAUDxoweld0iLtaE/6Lm',_binary '','test');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-10-24 17:42:26
