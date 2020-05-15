-- MySQL dump 10.13  Distrib 8.0.20, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: db_community_escalade
-- ------------------------------------------------------
-- Server version	8.0.20

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
-- Dumping data for table `booking`
--

LOCK TABLES `booking` WRITE;
/*!40000 ALTER TABLE `booking` DISABLE KEYS */;
/*!40000 ALTER TABLE `booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` VALUES (7,'comment -> le petit daemon !!','2020-05-15 15:02:03',_binary '',2,6,NULL);
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `component`
--

LOCK TABLES `component` WRITE;
/*!40000 ALTER TABLE `component` DISABLE KEYS */;
INSERT INTO `component` VALUES (12,'','2020-05-15 15:09:41','','852','voie de test','6A',_binary '\0',2,8,11),(16,'','2020-05-15 15:19:14','Le départ se fait a gauche de la grotte (strate en toit de la grotte fragile)... Décalez l’assureur de l’entrée de la grotte.\r\n\r\nPas de zig zag, tout passe dans la ligne...','8','Arise','6a',_binary '',2,9,15),(17,'','2020-05-15 15:21:37','Voie courte. Départ direct et passage dans toit. Ca passe avec larrête de gauche, mais vous pouvez le passer droit aussi... plus dur...','7','Coma','6b',_binary '\0',2,8,15),(19,'','2020-05-15 15:25:26','Pilier légèrement déversant','9','dame de caro','6a',_binary '',2,8,18),(20,'','2020-05-15 15:26:34','Dièdre. Equipée par Sarl YDEMS','8','Crouet','5a',_binary '',2,9,18);
/*!40000 ALTER TABLE `component` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `component_category`
--

LOCK TABLES `component_category` WRITE;
/*!40000 ALTER TABLE `component_category` DISABLE KEYS */;
INSERT INTO `component_category` VALUES (8,'2020-05-15 15:02:03','bloc'),(9,'2020-05-15 15:02:03','voie');
/*!40000 ALTER TABLE `component_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (23),(23),(23),(23),(23),(23),(23),(23),(23),(23);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `pitch`
--

LOCK TABLES `pitch` WRITE;
/*!40000 ALTER TABLE `pitch` DISABLE KEYS */;
INSERT INTO `pitch` VALUES (13,'1','2020-05-15 15:09:58','523','6a',12,2),(21,'1','2020-05-15 15:28:57','1','4',20,2),(22,'2','2020-05-15 15:29:13','2','3',20,2);
/*!40000 ALTER TABLE `pitch` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'2020-05-15 15:02:00','grimpeur'),(4,'2020-05-15 15:02:01','membre');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `sector`
--

LOCK TABLES `sector` WRITE;
/*!40000 ALTER TABLE `sector` DISABLE KEYS */;
INSERT INTO `sector` VALUES (11,'','2020-05-15 15:09:24','','secteur de test','6A+',2,6),(15,'','2020-05-15 15:18:31','Secteur tout a gauche, en limite de falaise. Le rocher est court, un peu péteux, mais permet quelques départs assez bloc et intéressants...','Secteur de la grotte','6',2,14),(18,'Allez vers le sud du site','2020-05-15 15:24:39','Les 3 marches !','Diédre est','5',2,14);
/*!40000 ALTER TABLE `sector` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `spot`
--

LOCK TABLES `spot` WRITE;
/*!40000 ALTER TABLE `spot` DISABLE KEYS */;
INSERT INTO `spot` VALUES (6,'1','France','Gard',_binary '\0','1','A1 puis direction Arras','2020-05-15 15:02:02','Spiderman à Arras','L\'ange d\'Arras','6A+',2),(14,'4','France','Ardéche',_binary '\0','2','Depuis Cluny, prendre la direction de Cormatin par la D981. Un peu avant le village prendre à gauche (D14). ','2020-05-15 15:17:45','Petit site ombragé au rocher original pour la région (calcaire grèseux sculpté). Falaise équipée durant\r\n\r\nlautomne et lhiver 2011-2012 par la société YDEMS pour la communauté de communes de Cormatin avec la participation de H. DELACOUR. Deux nouvelles voies ouvertes au printemps 2012 par L. PILLET. De nouvelles voies apparaissent depuis 2014, équipées par le CLIMBING CREW.','Cormatin','6',2);
/*!40000 ALTER TABLE `spot` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `topo`
--

LOCK TABLES `topo` WRITE;
/*!40000 ALTER TABLE `topo` DISABLE KEYS */;
INSERT INTO `topo` VALUES (5,'Gard','2016-08-18 22:00:00','2020-05-15 15:02:01','Fake topo',_binary '','Les roches d\'Arras',2);
/*!40000 ALTER TABLE `topo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (2,'nicolas.desdevises@yahoo.com',_binary '','James','Bond','$2a$10$hJW.aJOSy7uZGinOtRu0Me1xN7Zg62/EjjeXqfta9y1hAsRBIscbC',NULL,_binary '\0','2020-05-15 15:02:00','nico',1),(3,'laure@mail.com',_binary '','laure','desdevises','$2a$10$GFiB7zaW61dKcq65XhgELO5tIo80siwuMlYn.833tuKw.gOl0Atq6',NULL,_binary '\0','2020-05-15 15:02:01','alpha',1),(10,'laure@mail.com',_binary '','Fred','desdevises','$2a$10$jeJq.NyoK94qoUXZnb1VKO8.1wAvTuI3ktfYcNYBhedJOpnXXmzsS',NULL,_binary '\0','2020-05-15 15:02:04','membre',4);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'db_community_escalade'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-05-15 17:40:29
