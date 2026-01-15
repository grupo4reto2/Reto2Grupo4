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

alter table cliente
modify Correo varchar(30) not null; 

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

alter table pelicula
add Portada varchar(255) not null;
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

insert into Genero(IDGenero, NomGenero)
values
(1,'Animación'),
(2,'Horror'),
(3,'Thriller'),
(4,'Comedia'),
(5,'Bélico');

insert into Pelicula (IDPelicula, NomPelicula, Duracion, IDGenero)
values
(1,'El Rey Leon', 88, 1),
(2,'No respires', 88, 2),
(3,'Senderos de gloria', 86, 5),
(4,'Cop Car', 88, 3),
(5,'¡Aterriza como puedas!' , 92, 4);

INSERT INTO Sala (IDSala, NomSala, Aforo)
VALUES 
('S01', 'Sala 1', '150'),
('S02', 'Sala 2', '100'),
('S03', 'Sala 3', '150'),
('S04', 'Sala 4', '100'),
('S05', 'Sala 5', '150'),
('S06', 'Sala 6', '100');

DELETE FROM `reto2_g4`.`sala` WHERE (`IDSala` = 'S06');

INSERT INTO `reto2_g4`.`sesion` (`IDSesion`, `FecHoraIni`, `FecHoraFin`, `Precio`, `IDSala`, `IDPelicula`) VALUES ('S02-01', '2026-01-15 10:00:00', '2026-01-15 12:00:00', '6', 'S02', '2');
INSERT INTO `reto2_g4`.`sesion` (`IDSesion`, `FecHoraIni`, `FecHoraFin`, `Precio`, `IDSala`, `IDPelicula`) VALUES ('S02-02', '2026-01-15 12:00:00', '2026-01-15 14:00:00', '6', 'S02', '2');
INSERT INTO `reto2_g4`.`sesion` (`IDSesion`, `FecHoraIni`, `FecHoraFin`, `Precio`, `IDSala`, `IDPelicula`) VALUES ('S02-03', '2026-01-15 14:00:00', '2026-01-15 16:00:00', '6', 'S02', '2');
INSERT INTO `reto2_g4`.`sesion` (`IDSesion`, `FecHoraIni`, `FecHoraFin`, `Precio`, `IDSala`, `IDPelicula`) VALUES ('S02-04', '2026-01-15 16:00:00', '2026-01-15 18:00:00', '9.5', 'S02', '2');
INSERT INTO `reto2_g4`.`sesion` (`IDSesion`, `FecHoraIni`, `FecHoraFin`, `Precio`, `IDSala`, `IDPelicula`) VALUES ('S02-05', '2026-01-15 18:00:00', '2026-01-15 20:00:00', '9.5', 'S02', '2');
INSERT INTO `reto2_g4`.`sesion` (`IDSesion`, `FecHoraIni`, `FecHoraFin`, `Precio`, `IDSala`, `IDPelicula`) VALUES ('S02-06', '2026-01-15 20:00:00', '2026-01-15 22:00:00', '9.5', 'S02', '2');
INSERT INTO `reto2_g4`.`sesion` (`IDSesion`, `FecHoraIni`, `FecHoraFin`, `Precio`, `IDSala`, `IDPelicula`) VALUES ('S02-07', '2026-01-15 22:00:00', '2026-01-16 00:00:00', '12', 'S02', '2');
INSERT INTO `reto2_g4`.`sesion` (`IDSesion`, `FecHoraIni`, `FecHoraFin`, `Precio`, `IDSala`, `IDPelicula`) VALUES ('S02-08', '2026-01-16 00:00:00', '2026-01-16 02:00:00', '12', 'S02', '2');
INSERT INTO `reto2_g4`.`sesion` (`IDSesion`, `FecHoraIni`, `FecHoraFin`, `Precio`, `IDSala`, `IDPelicula`) VALUES ('S03-01', '2026-01-15 10:00:00', '2026-01-15 12:00:00', '6', 'S03', '3');
INSERT INTO `reto2_g4`.`sesion` (`IDSesion`, `FecHoraIni`, `FecHoraFin`, `Precio`, `IDSala`, `IDPelicula`) VALUES ('S03-02', '2026-01-15 12:00:00', '2026-01-15 14:00:00', '6', 'S03', '3');
INSERT INTO `reto2_g4`.`sesion` (`IDSesion`, `FecHoraIni`, `FecHoraFin`, `Precio`, `IDSala`, `IDPelicula`) VALUES ('S03-03', '2026-01-15 14:00:00', '2026-01-15 16:00:00', '6', 'S03', '3');
INSERT INTO `reto2_g4`.`sesion` (`IDSesion`, `FecHoraIni`, `FecHoraFin`, `Precio`, `IDSala`, `IDPelicula`) VALUES ('S03-04', '2026-01-15 16:00:00', '2026-01-15 18:00:00', '9.5', 'S03', '3');
INSERT INTO `reto2_g4`.`sesion` (`IDSesion`, `FecHoraIni`, `FecHoraFin`, `Precio`, `IDSala`, `IDPelicula`) VALUES ('S03-05', '2026-01-15 18:00:00', '2026-01-15 20:00:00', '9.5', 'S03', '3');
INSERT INTO `reto2_g4`.`sesion` (`IDSesion`, `FecHoraIni`, `FecHoraFin`, `Precio`, `IDSala`, `IDPelicula`) VALUES ('S03-06', '2026-01-15 20:00:00', '2026-01-15 22:00:00', '9.5', 'S03', '3');
INSERT INTO `reto2_g4`.`sesion` (`IDSesion`, `FecHoraIni`, `FecHoraFin`, `Precio`, `IDSala`, `IDPelicula`) VALUES ('S03-07', '2026-01-15 22:00:00', '2026-01-16 00:00:00', '12', 'S03', '3');
INSERT INTO `reto2_g4`.`sesion` (`IDSesion`, `FecHoraIni`, `FecHoraFin`, `Precio`, `IDSala`, `IDPelicula`) VALUES ('S03-08', '2026-01-16 00:00:00', '2026-01-16 02:00:00', '12', 'S03', '3');
UPDATE `reto2_g4`.`sesion` SET `Precio` = '12' WHERE (`IDSesion` = 'S01-07');
UPDATE `reto2_g4`.`sesion` SET `Precio` = '12' WHERE (`IDSesion` = 'S01-08');
INSERT INTO `reto2_g4`.`sesion` (`IDSesion`, `FecHoraIni`, `FecHoraFin`, `Precio`, `IDSala`, `IDPelicula`) VALUES ('S04-01', '2026-01-15 10:00:00', '2026-01-15 12:00:00', '6', 'S04', '4');
INSERT INTO `reto2_g4`.`sesion` (`IDSesion`, `FecHoraIni`, `FecHoraFin`, `Precio`, `IDSala`, `IDPelicula`) VALUES ('S04-02', '2026-01-15 12:00:00', '2026-01-15 14:00:00', '6', 'S04', '4');
INSERT INTO `reto2_g4`.`sesion` (`IDSesion`, `FecHoraIni`, `FecHoraFin`, `Precio`, `IDSala`, `IDPelicula`) VALUES ('S04-03', '2026-01-15 14:00:00', '2026-01-15 16:00:00', '6', 'S04', '4');
INSERT INTO `reto2_g4`.`sesion` (`IDSesion`, `FecHoraIni`, `FecHoraFin`, `Precio`, `IDSala`, `IDPelicula`) VALUES ('S04-04', '2026-01-15 16:00:00', '2026-01-15 18:00:00', '9.5', 'S04', '4');
INSERT INTO `reto2_g4`.`sesion` (`IDSesion`, `FecHoraIni`, `FecHoraFin`, `Precio`, `IDSala`, `IDPelicula`) VALUES ('S04-05', '2026-01-15 18:00:00', '2026-01-15 20:00:00', '9.5', 'S04', '4');
INSERT INTO `reto2_g4`.`sesion` (`IDSesion`, `FecHoraIni`, `FecHoraFin`, `Precio`, `IDSala`, `IDPelicula`) VALUES ('S04-06', '2026-01-15 20:00:00', '2026-01-15 22:00:00', '9.5', 'S04', '4');
INSERT INTO `reto2_g4`.`sesion` (`IDSesion`, `FecHoraIni`, `FecHoraFin`, `Precio`, `IDSala`, `IDPelicula`) VALUES ('S04-07', '2026-01-15 22:00:00', '2026-01-16 00:00:00', '12', 'S04', '4');
INSERT INTO `reto2_g4`.`sesion` (`IDSesion`, `FecHoraIni`, `FecHoraFin`, `Precio`, `IDSala`, `IDPelicula`) VALUES ('S04-08', '2026-01-16 00:00:00', '2026-01-16 02:00:00', '12', 'S04', '4');
INSERT INTO `reto2_g4`.`sesion` (`IDSesion`, `FecHoraIni`, `FecHoraFin`, `Precio`, `IDSala`, `IDPelicula`) VALUES ('S05-01', '2026-01-15 10:00:00', '2026-01-15 12:00:00', '6', 'S05', '5');
INSERT INTO `reto2_g4`.`sesion` (`IDSesion`, `FecHoraIni`, `FecHoraFin`, `Precio`, `IDSala`, `IDPelicula`) VALUES ('S05-02', '2026-01-15 12:00:00', '2026-01-15 14:00:00', '6', 'S05', '5');
INSERT INTO `reto2_g4`.`sesion` (`IDSesion`, `FecHoraIni`, `FecHoraFin`, `Precio`, `IDSala`, `IDPelicula`) VALUES ('S05-03', '2026-01-15 14:00:00', '2026-01-15 16:00:00', '6', 'S05', '5');
INSERT INTO `reto2_g4`.`sesion` (`IDSesion`, `FecHoraIni`, `FecHoraFin`, `Precio`, `IDSala`, `IDPelicula`) VALUES ('S05-04', '2026-01-15 16:00:00', '2026-01-15 18:00:00', '9.5', 'S05', '5');
INSERT INTO `reto2_g4`.`sesion` (`IDSesion`, `FecHoraIni`, `FecHoraFin`, `Precio`, `IDSala`, `IDPelicula`) VALUES ('S05-05', '2026-01-15 18:00:00', '2026-01-15 20:00:00', '9.5', 'S05', '5');
INSERT INTO `reto2_g4`.`sesion` (`IDSesion`, `FecHoraIni`, `FecHoraFin`, `Precio`, `IDSala`, `IDPelicula`) VALUES ('S05-06', '2026-01-15 20:00:00', '2026-01-15 22:00:00', '9.5', 'S05', '5');
INSERT INTO `reto2_g4`.`sesion` (`IDSesion`, `FecHoraIni`, `FecHoraFin`, `Precio`, `IDSala`, `IDPelicula`) VALUES ('S05-07', '2026-01-15 22:00:00', '2026-01-16 00:00:00', '12', 'S05', '5');
INSERT INTO `reto2_g4`.`sesion` (`IDSesion`, `FecHoraIni`, `FecHoraFin`, `Precio`, `IDSala`, `IDPelicula`) VALUES ('S05-08', '2026-01-16 00:00:00', '2026-01-16 02:00:00', '12', 'S05', '5');


insert into Cliente (DNICliente, Nombre, Apellido, Correo, Contraseña)
values
('67856221B', 'Julio', 'Verne', 'jverne@gmail.com', 'JVerne00-'),
('76466993C', 'Charles', 'Chaplin', 'tiemposModernos@gmail.com', 'Oona O neill');

insert into Compra (IDCompra, Fecha, DNICliente, descuento, Canal, Importe)
values
('C01', '2026-01-15 17:30:00', '67856221B', '0.00', 'Pagina Web', ''),
('C02', '2026-01-16 16:00:00', '76466993C', '0.00', 'Pagina Web', '');

Update Pelicula
Set Portada = 'https://imgs.search.brave.com/1fyE5g2uMLQXGifPBcEBod79aHjSjz-KlDjWQjLJ3vk/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9tLm1l/ZGlhLWFtYXpvbi5j/b20vaW1hZ2VzL00v/TVY1Qll6Y3labVl6/WldNdE1qUmlNeTAw/WXpsakxUazFObUl0/TjJFM016bGhObVUz/TlRjelhrRXlYa0Zx/Y0djQC5qcGc'
Where IDPelicula = 5;
