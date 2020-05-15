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
-- Table structure for table `booking`
--

DROP TABLE IF EXISTS `booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `booking` (
  `booking_id` bigint NOT NULL,
  `booking_date` datetime NOT NULL,
  `booking_status` bit(1) NOT NULL,
  `booking_topo_topo_id` bigint NOT NULL,
  `booking_user_user_id` bigint NOT NULL,
  PRIMARY KEY (`booking_id`),
  KEY `FKjonhurn997kg58yxdsqffg3rs` (`booking_topo_topo_id`),
  KEY `FKqpaee4qd80esn1igc9h3e0nt6` (`booking_user_user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comment` (
  `comment_id` bigint NOT NULL,
  `comment_body` varchar(150) NOT NULL,
  `comment_date` datetime NOT NULL,
  `comment_status` bit(1) NOT NULL,
  `comment_author_user_id` bigint NOT NULL,
  `spot_spot_id` bigint NOT NULL,
  `sub_comment_comment_id` bigint DEFAULT NULL,
  PRIMARY KEY (`comment_id`),
  KEY `FK8qlua5g1avregumc58nd87am` (`comment_author_user_id`),
  KEY `FK3o03aulcsno0ta9lsqo651i68` (`spot_spot_id`),
  KEY `FKfw81hx0qfys09ed2v51ermx80` (`sub_comment_comment_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `component`
--

DROP TABLE IF EXISTS `component`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `component` (
  `component_id` bigint NOT NULL,
  `component_code` varchar(5) DEFAULT NULL,
  `component_date` datetime NOT NULL,
  `component_description` varchar(380) DEFAULT NULL,
  `component_height` varchar(3) DEFAULT NULL,
  `component_name` varchar(150) NOT NULL,
  `component_rate` varchar(3) NOT NULL,
  `spits` bit(1) DEFAULT NULL,
  `component_author_user_id` bigint NOT NULL,
  `component_category_component_category_id` bigint NOT NULL,
  `sector_sector_id` bigint NOT NULL,
  PRIMARY KEY (`component_id`),
  KEY `FKl1oi6t1mqdt8jddh3exj183on` (`component_author_user_id`),
  KEY `FKnkneafsm6j1umhueq1fip51c1` (`component_category_component_category_id`),
  KEY `FKt70aecn5g2ssmpevhoeliawsa` (`sector_sector_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `component_category`
--

DROP TABLE IF EXISTS `component_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `component_category` (
  `component_category_id` bigint NOT NULL,
  `component_category_date` datetime NOT NULL,
  `component_category_label` varchar(255) NOT NULL,
  PRIMARY KEY (`component_category_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `pitch`
--

DROP TABLE IF EXISTS `pitch`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pitch` (
  `pitch_id` bigint NOT NULL,
  `pitch_code` varchar(3) DEFAULT NULL,
  `pitch_date` datetime NOT NULL,
  `pitch_height` varchar(3) DEFAULT NULL,
  `pitch_rate` varchar(3) DEFAULT NULL,
  `component_component_id` bigint NOT NULL,
  `pitch_author_user_id` bigint NOT NULL,
  PRIMARY KEY (`pitch_id`),
  KEY `FK1veuiqok1xxkhn46ax5gjb4jq` (`component_component_id`),
  KEY `FKm7mr2meupfuv0ye4ppv0k3tmq` (`pitch_author_user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `role_id` bigint NOT NULL,
  `role_date` datetime NOT NULL,
  `role_name` varchar(100) NOT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sector`
--

DROP TABLE IF EXISTS `sector`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sector` (
  `sector_id` bigint NOT NULL,
  `sector_access_path` varchar(170) DEFAULT NULL,
  `sector_date` datetime NOT NULL,
  `sector_description` varchar(380) DEFAULT NULL,
  `sector_name` varchar(150) NOT NULL,
  `sector_rate` varchar(3) NOT NULL,
  `sector_author_user_id` bigint NOT NULL,
  `spot_spot_id` bigint NOT NULL,
  PRIMARY KEY (`sector_id`),
  KEY `FKkbnt39ka4f0lxllb8k1o0t7kb` (`sector_author_user_id`),
  KEY `FKe8ab3p87pmpm8do2fqa15yyp7` (`spot_spot_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `spot`
--

DROP TABLE IF EXISTS `spot`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `spot` (
  `spot_id` bigint NOT NULL,
  `component_count` varchar(255) DEFAULT NULL,
  `country` varchar(100) NOT NULL,
  `location` varchar(100) NOT NULL,
  `official` bit(1) NOT NULL,
  `sector_count` varchar(255) DEFAULT NULL,
  `spot_access_path` varchar(170) DEFAULT NULL,
  `spot_date` datetime NOT NULL,
  `spot_description` varchar(380) DEFAULT NULL,
  `spot_name` varchar(150) NOT NULL,
  `spot_rate` varchar(3) DEFAULT NULL,
  `spot_author_user_id` bigint NOT NULL,
  PRIMARY KEY (`spot_id`),
  KEY `FKqhq9rv6dbcy89guk3up6w7bck` (`spot_author_user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `topo`
--

DROP TABLE IF EXISTS `topo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `topo` (
  `topo_id` bigint NOT NULL,
  `location` varchar(200) NOT NULL,
  `release_date` datetime NOT NULL,
  `topo_date` datetime NOT NULL,
  `topo_description` varchar(380) DEFAULT NULL,
  `topo_status` bit(1) NOT NULL,
  `topo_title` varchar(200) NOT NULL,
  `topo_owner_user_id` bigint NOT NULL,
  PRIMARY KEY (`topo_id`),
  KEY `FKgouhrm16sbjdq9gy9hw8cd4ht` (`topo_owner_user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` bigint NOT NULL,
  `email` varchar(255) NOT NULL,
  `enabled` bit(1) NOT NULL,
  `firstname` varchar(100) NOT NULL,
  `lastname` varchar(100) NOT NULL,
  `password` varchar(255) NOT NULL,
  `profile` longblob,
  `token_expired` bit(1) NOT NULL,
  `user_date` datetime DEFAULT NULL,
  `username` varchar(50) NOT NULL,
  `role_role_id` bigint NOT NULL,
  PRIMARY KEY (`user_id`),
  KEY `FKs2ym81xl98n65ndx09xpwxm66` (`role_role_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

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

-- Dump completed on 2020-05-15 17:42:29
