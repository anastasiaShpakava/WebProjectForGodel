-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: godel_tech
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `director`
--

DROP TABLE IF EXISTS `director`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `director` (
  `director_id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(100) NOT NULL,
  `last_name` varchar(100) NOT NULL,
  `birth_date` date NOT NULL,
  PRIMARY KEY (`director_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `director`
--

LOCK TABLES `director` WRITE;
/*!40000 ALTER TABLE `director` DISABLE KEYS */;
INSERT INTO `director` VALUES (1,'Quentin','Tarantino','1963-03-07'),(2,'George','Lucas','1944-05-14'),(3,'Martin','Scorsese','1942-11-17'),(4,'Guy','Ritchie','1968-09-10'),(5,'Steven','Spielberg','1946-12-18'),(6,'Tom','Smith','1990-12-18');
/*!40000 ALTER TABLE `director` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `film`
--

DROP TABLE IF EXISTS `film`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `film` (
  `film_id` int NOT NULL AUTO_INCREMENT,
  `director_id` int NOT NULL,
  `name` varchar(100) NOT NULL,
  `release_date` timestamp(6) NOT NULL,
  `genre` varchar(100) NOT NULL,
  PRIMARY KEY (`film_id`),
  KEY `director_id_idx` (`director_id`),
  CONSTRAINT `director_id` FOREIGN KEY (`director_id`) REFERENCES `director` (`director_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `film`
--

LOCK TABLES `film` WRITE;
/*!40000 ALTER TABLE `film` DISABLE KEYS */;
INSERT INTO `film` VALUES (1,1,'Reservoir Dogs','1992-01-20 21:00:00.000000','Crime'),(2,1,'Pulp Fiction','1994-01-20 21:00:00.000000','Crime'),(3,1,'Kill Bill','2003-01-20 21:00:00.000000','Crime'),(4,1,'Kill Bill 2','2004-01-20 21:00:00.000000','Crime'),(5,2,'Star Wars: The Clone Wars','2008-07-20 21:00:00.000000','Adventure'),(6,2,'Indiana Jones and the Kingdom of the Crystal','2008-07-20 21:00:00.000000','Adventure'),(7,3,'Vinyl','2016-10-31 21:00:00.000000','Historical'),(8,3,'Silence','2016-10-31 21:00:00.000000','Historical'),(9,4,'Swept Away','2002-08-10 21:00:00.000000','Comedy'),(10,5,'Bumblebee','2018-03-17 21:00:00.000000','Adventure');
/*!40000 ALTER TABLE `film` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-02-25 21:08:56
