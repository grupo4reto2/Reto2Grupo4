CREATE SCHEMA IF NOT EXISTS `reto2_g4` DEFAULT CHARACTER SET utf8mb4;
USE`reto2_g4`;

-- =========================
-- CLIENTE
-- =========================

DROP TABLE IF EXISTS `cliente`;
CREATE TABLE `cliente` (
  `DNICliente` varchar(9) NOT NULL,
  `Nombre` char(30) NOT NULL,
  `Apellido` char(30) NOT NULL,
  `Correo` char(30) NOT NULL,
  `Contraseña` varchar(20) NOT NULL,
  PRIMARY KEY (`DNICliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- =========================
-- COMPRA
-- =========================

DROP TABLE IF EXISTS `compra`;
CREATE TABLE `compra` (
  `IDCompra` varchar(3) NOT NULL,
  `Fecha` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `DNICliente` varchar(9) NOT NULL,
  `descuento` double NOT NULL,
  `Canal` tinyint(4) NOT NULL,
  `Importe` double NOT NULL,
  PRIMARY KEY (`IDCompra`),
  KEY `fk_Compra_Cliente` (`DNICliente`),
  CONSTRAINT `fk_Compra_Cliente` FOREIGN KEY (`DNICliente`) REFERENCES `cliente` (`DNICliente`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- =========================
-- ENTRADA
-- =========================

DROP TABLE IF EXISTS `entrada`;
CREATE TABLE `entrada` (
  `IDEntrada` int(10) unsigned NOT NULL,
  `NumPers` int(10) unsigned NOT NULL,
  `IDSesion` varchar(6) NOT NULL,
  `IDCompra` varchar(3) NOT NULL,
  PRIMARY KEY (`IDEntrada`),
  KEY `fk_Entrada_Compra` (`IDCompra`),
  KEY `fk_Entrada_Sesion` (`IDSesion`),
  CONSTRAINT `fk_Entrada_Compra` FOREIGN KEY (`IDCompra`) REFERENCES `compra` (`IDCompra`) ON UPDATE CASCADE,
  CONSTRAINT `fk_Entrada_Sesion` FOREIGN KEY (`IDSesion`) REFERENCES `sesion` (`IDSesion`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

-- =========================
-- GENERO
-- =========================

DROP TABLE IF EXISTS `genero`;
CREATE TABLE `genero` (
  `IDGenero` int(10) unsigned NOT NULL,
  `NomGenero` char(20) NOT NULL,
  PRIMARY KEY (`IDGenero`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- =========================
-- PELICULA
-- =========================

DROP TABLE IF EXISTS `pelicula`;
CREATE TABLE `pelicula` (
  `IDPelicula` int(10) unsigned NOT NULL,
  `NomPelicula` varchar(50) NOT NULL,
  `Duracion` int(10) unsigned NOT NULL,
  `IDGenero` int(10) unsigned NOT NULL,
  PRIMARY KEY (`IDPelicula`),
  KEY `FK_Pelicula_Genero` (`IDGenero`),
  CONSTRAINT `FK_Pelicula_Genero` FOREIGN KEY (`IDGenero`) REFERENCES `genero` (`IDGenero`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- =========================
-- SALA
-- =========================

DROP TABLE IF EXISTS `sala`;
CREATE TABLE `sala` (
  `IDSala` varchar(3) NOT NULL,
  `NomSala` char(30) NOT NULL,
  `Aforo` int(10) unsigned NOT NULL DEFAULT 200,
  PRIMARY KEY (`IDSala`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- =========================
-- SESION
-- =========================

DROP TABLE IF EXISTS `sesion`;
CREATE TABLE `sesion` (
  `IDSesion` varchar(6) NOT NULL,
  `FecHoraIni` timestamp NOT NULL DEFAULT current_timestamp(),
  `FecHoraFin` timestamp NULL DEFAULT NULL,
  `Precio` double unsigned NOT NULL,
  `IDSala` varchar(3) NOT NULL,
  `IDPelicula` int(10) unsigned NOT NULL,
  PRIMARY KEY (`IDSesion`),
  KEY `FK_Sesion_Sala` (`IDSala`),
  KEY `FK_Sesion_Pelicula` (`IDPelicula`),
  CONSTRAINT `FK_Sesion_Pelicula` FOREIGN KEY (`IDPelicula`) REFERENCES `pelicula` (`IDPelicula`) ON UPDATE CASCADE,
  CONSTRAINT `FK_Sesion_Sala` FOREIGN KEY (`IDSala`) REFERENCES `sala` (`IDSala`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

insert into Sala(IDSala, NomSala, Aforo)
values('S01', 'Sala 1', 200),
('S02', 'Sala 2', 200);

Update Pelicula
Set Caratula = 'https://imgs.search.brave.com/1fyE5g2uMLQXGifPBcEBod79aHjSjz-KlDjWQjLJ3vk/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9tLm1l/ZGlhLWFtYXpvbi5j/b20vaW1hZ2VzL00v/TVY1Qll6Y3labVl6/WldNdE1qUmlNeTAw/WXpsakxUazFObUl0/TjJFM016bGhObVUz/TlRjelhrRXlYa0Zx/Y0djQC5qcGc'
Where IDPelicula = 5;
