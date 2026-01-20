-- MySQL dump 10.13  Distrib 8.0.43, for Win64 (x86_64)
--
-- Host: 10.5.6.136    Database: reto2_g4_true
-- ------------------------------------------------------
-- Server version	8.4.3

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
-- Table structure for table `pelicula`
--

DROP TABLE IF EXISTS `pelicula`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pelicula` (
  `IDPelicula` int unsigned NOT NULL AUTO_INCREMENT,
  `NomPelicula` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `Duracion` int unsigned NOT NULL,
  `IDGenero` int unsigned NOT NULL,
  `Portada` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`IDPelicula`),
  KEY `FK_Pelicula_Genero` (`IDGenero`),
  CONSTRAINT `FK_Pelicula_Genero` FOREIGN KEY (`IDGenero`) REFERENCES `genero` (`IDGenero`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pelicula`
--

LOCK TABLES `pelicula` WRITE;
/*!40000 ALTER TABLE `pelicula` DISABLE KEYS */;
INSERT INTO `pelicula` VALUES (1,'El Rey Leon',88,1,'https://imgs.search.brave.com/_5dc4VhCTZLut53Ht3d8uT-NhqR8VIYqfLrSNTT3whE/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9tZWRp/YS50aGVtb3ZpZWRi/Lm9yZy90L3AvdzMw/MF9hbmRfaDQ1MF9m/YWNlL2IwTXhVMzdk/Tm1Nd0t0b1BWWVBL/T1pTSXJJbi5qcGc'),(2,'No respires',88,2,'https://imgs.search.brave.com/ihzEF6bQUrQjgOa8v10o5CYMji89rS3OoKlqiyNkS-Q/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9tLm1l/ZGlhLWFtYXpvbi5j/b20vaW1hZ2VzL00v/TVY1QllUZzVOamho/TlRJdE5EUmtaaTAw/TXpSa0xUa3daVGd0/TnpCa1lqRTFaR1Uz/TTJabFhrRXlYa0Zx/Y0djQC5qcGc\n'),(3,'Senderos de gloria',86,5,'https://imgs.search.brave.com/qLvrskRm0rEIlVyGuaZG_kKW0kBz-_9LWOTGSJmUAoc/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9tLm1l/ZGlhLWFtYXpvbi5j/b20vaW1hZ2VzL00v/TVY1QlpqZzBNV0pq/TTJJdFl6TmpaUzAw/TVRreUxUaGlOekF0/T1RsbVpHWmlaV0U1/T1dKaFhrRXlYa0Zx/Y0djQC5qcGc'),(4,'Cop Car',88,3,'https://imgs.search.brave.com/BGqrP5PYce2gCY9ZUfLp4lgmhbSpl9Y33kWFOAJkvKU/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9tZWRp/YXByb3h5LnR2dHJv/cGVzLm9yZy93aWR0/aC8xMjAwL2h0dHBz/Oi8vc3RhdGljLnR2/dHJvcGVzLm9yZy9w/bXdpa2kvcHViL2lt/YWdlcy9pbWdfOTE0/NV8zLmpwZWc\n'),(5,'¡Aterriza como puedas!',92,4,'https://imgs.search.brave.com/1fyE5g2uMLQXGifPBcEBod79aHjSjz-KlDjWQjLJ3vk/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9tLm1l/ZGlhLWFtYXpvbi5j/b20vaW1hZ2VzL00v/TVY1Qll6Y3labVl6/WldNdE1qUmlNeTAw/WXpsakxUazFObUl0/TjJFM016bGhObVUz/TlRjelhrRXlYa0Zx/Y0djQC5qcGc\n');
/*!40000 ALTER TABLE `pelicula` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-01-20 17:29:54
