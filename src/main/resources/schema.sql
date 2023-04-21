CREATE DATABASE  IF NOT EXISTS `techtalksdb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `techtalksdb`;
-- MySQL dump 10.13  Distrib 8.0.31, for macos12 (x86_64)
--
-- Host: 127.0.0.1    Database: techtalksdb
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `talks`
--
SET FOREIGN_KEY_CHECKS=0;

DROP TABLE IF EXISTS `talks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `talks` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `author_id` bigint DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `resources` varchar(2000) DEFAULT NULL,
  `talk_date` datetime DEFAULT NULL,
  `vid_url` varchar(1000) DEFAULT NULL,
  `talk_icon` varchar(500) DEFAULT NULL,
  `timezone_info` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKjlspbfdi7ssqv2rka00ls326p` (`author_id`),
  CONSTRAINT `FKjlspbfdi7ssqv2rka00ls326p` FOREIGN KEY (`author_id`) REFERENCES `authors` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=164 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `authors`
--

DROP TABLE IF EXISTS `authors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `authors` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `author_name` varchar(255) DEFAULT NULL,
  `linkedin` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=139 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authors`
--

LOCK TABLES `authors` WRITE;
/*!40000 ALTER TABLE `authors` DISABLE KEYS */;
INSERT INTO `authors` VALUES (1,'john doe','www.linkedin.com/johndoe','johndoe@corp.com'),(2,'Olga Roberts','www.linkedin.com/olgaR','olgarobs@corp.com'),(3,'Gandalf','www.linkedin.com/therealG','gthegrey@corp.com'),(4,'pepito','www.linkedin.com/pepito','pepito@corp.com'),(96,'Peter Parker','www.linkedin.com/pparker','pparker@corp.com'),(97,'Foo bar','www.linkedin.com/foobar','foobar@corp.com'),(98,'john doe jr.','www.linkedin.com/johnDjunior','johndoejr@company.com'),(99,'Michael Jackson','www.linkedin.com/MJackson','heehee@corp.com'),(100,'mary jane','www.linkedin.com/mj','mj-@corp.com');
/*!40000 ALTER TABLE `authors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resources`
--

DROP TABLE IF EXISTS `resources`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `resources` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `link` varchar(255) DEFAULT NULL,
  `src_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resources`
--

LOCK TABLES `resources` WRITE;
/*!40000 ALTER TABLE `resources` DISABLE KEYS */;
/*!40000 ALTER TABLE `resources` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `talks`
--

LOCK TABLES `talks` WRITE;
/*!40000 ALTER TABLE `talks` DISABLE KEYS */;
INSERT INTO `talks` VALUES (1,'Medium kubernetes',1,'A class for people who are familiar with Kubernetes','www.google.com http://www.yahoo.com','2023-03-16 12:56:00','https://grupovass-my.sharepoint.com/personal/antoniojose_pizarro_vass_es/_layouts/15/stream.aspx?id=%2Fpersonal%2Fantoniojose%5Fpizarro%5Fvass%5Fes%2FDocuments%2FRecordings%2FCertificaci%C3%B3n%20de%20Clave%20P%C3%BAblica%20%2D%20PKI%20%2D%20Sesi%C3%B3n%201%20de%203%2D20230314%5F150454%2DGrabaci%C3%B3n%20de%20la%20reuni%C3%B3n%2Emp4&ga=1',NULL,-60),(11,'Java for beginners',2,'An introductory course for java','www.lloremipsum.com','2023-03-08 23:11:00','',NULL,-60),(13,'Database modeling',1,'Tips on how to improve database modeling','www.serbatic.com','2023-03-16 12:56:00',NULL,NULL,-60),(14,'JS for experts',2,'An advance course that focuses on best practices','www.vdshop.com www.drums.com www.sometjhing.com www.moreexample.com www.jsforexperts.com',NULL,'www.est.com',NULL,-60),(17,'Ultimate C presentation',99,'C','www.test.com www.something.com','2023-03-16 12:56:00','https://www.youtube.com/embed/dQw4w9WgXcQ',NULL,-60),(106,'Basic C concepts',1,'lorem','','2023-03-30 16:00:00','ipsum','',-120),(107,'Django for beginners',99,'lorem','','2023-03-16 16:00:00','ipsum','',-60),(108,NULL,1,NULL,NULL,NULL,NULL,NULL,-60),(113,NULL,99,NULL,NULL,NULL,NULL,NULL,-60),(114,NULL,1,NULL,NULL,NULL,NULL,NULL,-60),(115,NULL,3,NULL,NULL,NULL,NULL,NULL,-60),(116,NULL,4,NULL,NULL,NULL,NULL,NULL,-60),(117,NULL,2,NULL,NULL,NULL,NULL,NULL,-60),(118,NULL,1,NULL,NULL,NULL,NULL,NULL,-60),(119,NULL,99,NULL,NULL,NULL,NULL,NULL,-60),(120,NULL,96,NULL,NULL,NULL,NULL,NULL,-60),(121,NULL,1,NULL,NULL,NULL,NULL,NULL,-60),(122,NULL,97,NULL,NULL,NULL,NULL,NULL,-60),(123,NULL,98,NULL,NULL,NULL,NULL,NULL,-60),(124,NULL,98,NULL,NULL,NULL,NULL,NULL,-60),(125,NULL,98,NULL,NULL,NULL,NULL,NULL,-60),(126,'What are React hooks?',98,'An explanation of react hooks','www.reactjsofficialdoc.com','1970-02-07 03:02:00','www.embedvid.com/joaj0a9uaghaoig',NULL,-60),(127,NULL,98,NULL,NULL,NULL,NULL,NULL,-60),(128,NULL,98,NULL,NULL,NULL,NULL,NULL,-60),(129,NULL,1,NULL,NULL,NULL,NULL,NULL,-60),(130,NULL,1,NULL,NULL,NULL,NULL,NULL,-60),(131,NULL,1,NULL,NULL,NULL,NULL,NULL,-60),(132,NULL,1,NULL,NULL,NULL,NULL,NULL,-60),(133,NULL,1,NULL,NULL,NULL,NULL,NULL,-60),(134,NULL,1,NULL,NULL,NULL,NULL,NULL,-60),(135,NULL,1,NULL,NULL,NULL,NULL,NULL,-60),(136,NULL,1,NULL,NULL,NULL,NULL,NULL,-60),(137,NULL,1,NULL,NULL,NULL,NULL,NULL,-60),(138,NULL,1,NULL,NULL,NULL,NULL,NULL,-60),(139,NULL,1,NULL,NULL,NULL,NULL,NULL,-60),(140,NULL,1,NULL,NULL,NULL,NULL,NULL,-60),(141,NULL,1,NULL,NULL,NULL,NULL,NULL,-60),(142,NULL,1,NULL,NULL,NULL,NULL,NULL,-60),(143,NULL,1,NULL,NULL,NULL,NULL,NULL,-60),(144,NULL,1,NULL,NULL,NULL,NULL,NULL,-60),(145,NULL,1,NULL,NULL,NULL,NULL,NULL,-60),(146,NULL,1,NULL,NULL,NULL,NULL,NULL,-60),(147,NULL,1,NULL,NULL,NULL,NULL,NULL,-60),(148,NULL,1,NULL,NULL,NULL,NULL,NULL,-60),(149,NULL,1,NULL,NULL,NULL,NULL,NULL,-60),(150,NULL,1,NULL,NULL,NULL,NULL,NULL,-60),(151,NULL,1,NULL,NULL,NULL,NULL,NULL,-60),(152,NULL,1,NULL,NULL,NULL,NULL,NULL,-60),(153,NULL,1,NULL,NULL,NULL,NULL,NULL,-60),(154,NULL,1,NULL,NULL,NULL,NULL,NULL,-60),(155,NULL,2,NULL,NULL,NULL,NULL,NULL,-60),(156,'Java for beginners',4,'A talk about java for beginners','','2023-03-31 19:14:00','www.vide.com/o35u32th4th','',-120),(157,'java para principiantes',4,'una charla sobre java','','2023-04-05 12:20:00','www.gasiohgoeaihgoiah','',-120),(158,'grsgrgs',1,'grsgrsgs','','2023-03-23 13:45:00','grsgrsgs','',-60),(159,'frr',1,'grgrdgd','','2023-04-05 14:52:00','grdgrd','',-120),(160,'brwbwbw',1,'bwbwbw','','2023-04-04 13:52:00','bwbwbwb','',-120),(161,'fafava',1,'aeava','www.serbatic.com','2023-03-30 09:50:00','fafafa','',-120),(162,'bg53g3',1,'grg4g','','2023-04-06 14:55:00','g4g4gs','',-120),(163,'vavavava',1,'eavaeva','www.serbatic.com','2023-04-07 15:05:00','vavavav','',-120);
/*!40000 ALTER TABLE `talks` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
SET FOREIGN_KEY_CHECKS=1;
-- Dump completed on 2023-03-28 15:12:01
