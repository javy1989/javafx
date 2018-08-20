-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: localhost    Database: ayuda
-- ------------------------------------------------------
-- Server version	8.0.12

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
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `categoria` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  `estado` tinyint(4) DEFAULT NULL,
  `posicion` int(11) DEFAULT NULL,
  `padre` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_categoria_categoria1_idx` (`padre`),
  CONSTRAINT `padre_categoria_fket` FOREIGN KEY (`padre`) REFERENCES `categoria` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` VALUES (1,'Hardware','Problemas com pc',1,0,NULL),(2,'Software','Aplicaciones',1,0,NULL),(3,'Email','Correo',1,0,NULL),(4,'Impresion','Impresion',1,0,NULL),(5,'Monitor','Monitor',1,1,1),(6,'Teclado','Teclado',1,2,1),(7,'Office','Office',1,1,2),(8,'Contraseña','Contraseña',1,1,3),(9,'Toner','Toner',1,1,4);
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `codigo`
--

DROP TABLE IF EXISTS `codigo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `codigo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `codigo` varchar(45) DEFAULT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  `parametros` varchar(45) DEFAULT NULL,
  `maestro` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_codigo_maestro_idx` (`maestro`),
  CONSTRAINT `codigo_maestro_fkey` FOREIGN KEY (`maestro`) REFERENCES `maestro` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `codigo`
--

LOCK TABLES `codigo` WRITE;
/*!40000 ALTER TABLE `codigo` DISABLE KEYS */;
INSERT INTO `codigo` VALUES (1,'Usuario Area','USRA','Usuario normal','USR',1),(2,'Usuario Tecnico','USRTEC','Usuario tecnico','TEC',1),(3,'Modulo de ticket','MODTCK','Modulos de ticket',NULL,2),(4,'Incidente','INC','Tipo incidente',NULL,3),(5,'Solicitud','SOL','Tipo solicitud',NULL,3);
/*!40000 ALTER TABLE `codigo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grupo_usuario`
--

DROP TABLE IF EXISTS `grupo_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `grupo_usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `usuario` varchar(45) DEFAULT NULL,
  `grupo` int(11) NOT NULL,
  `modulo` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_grupo_usuario_codigo1_idx` (`grupo`),
  KEY `fk_grupo_usuario_codigo2_idx` (`modulo`),
  CONSTRAINT `grupo_codigo_fkey` FOREIGN KEY (`grupo`) REFERENCES `codigo` (`id`),
  CONSTRAINT `modulo_codigo_fkey` FOREIGN KEY (`modulo`) REFERENCES `codigo` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grupo_usuario`
--

LOCK TABLES `grupo_usuario` WRITE;
/*!40000 ALTER TABLE `grupo_usuario` DISABLE KEYS */;
INSERT INTO `grupo_usuario` VALUES (1,'usuario',1,3),(2,'tecnico',2,3);
/*!40000 ALTER TABLE `grupo_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `maestro`
--

DROP TABLE IF EXISTS `maestro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `maestro` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `codigo` varchar(45) DEFAULT NULL,
  `descripcion` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `maestro`
--

LOCK TABLES `maestro` WRITE;
/*!40000 ALTER TABLE `maestro` DISABLE KEYS */;
INSERT INTO `maestro` VALUES (1,'Grupo usuarios','GRPUSR|','Grupo de usuario sistema'),(2,'Modulos sistema','MODS','Modulos del sistema'),(3,'Tipo Incidente','TIPINC','Tipo de incidente');
/*!40000 ALTER TABLE `maestro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tarea`
--

DROP TABLE IF EXISTS `tarea`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tarea` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(200) DEFAULT NULL,
  `ingreso` datetime DEFAULT NULL,
  `cierre` datetime DEFAULT NULL,
  `observacion` varchar(100) DEFAULT NULL,
  `estado` varchar(2) DEFAULT NULL,
  `ticket` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_tarea_ticket1_idx` (`ticket`),
  CONSTRAINT `ticket_tarea_fkey` FOREIGN KEY (`ticket`) REFERENCES `ticket` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tarea`
--

LOCK TABLES `tarea` WRITE;
/*!40000 ALTER TABLE `tarea` DISABLE KEYS */;
/*!40000 ALTER TABLE `tarea` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket`
--

DROP TABLE IF EXISTS `ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `ticket` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `estado` varchar(2) DEFAULT NULL,
  `titulo` varchar(45) DEFAULT NULL,
  `descripcion` varchar(200) DEFAULT NULL,
  `ingreso` datetime DEFAULT NULL,
  `solucion` datetime DEFAULT NULL,
  `observacion` varchar(200) DEFAULT NULL,
  `fuente` int(11) DEFAULT NULL,
  `tipo` int(11) NOT NULL,
  `solicitante` int(11) NOT NULL,
  `tecnico` int(11) DEFAULT NULL,
  `categoria` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_ticket_codigo1_idx` (`fuente`),
  KEY `fk_ticket_codigo2_idx` (`tipo`),
  KEY `fk_ticket_usuario1_idx` (`solicitante`),
  KEY `fk_ticket_usuario2_idx` (`tecnico`),
  KEY `fk_ticket_categoria1_idx` (`categoria`),
  CONSTRAINT `categoria_ticket_fkey` FOREIGN KEY (`categoria`) REFERENCES `categoria` (`id`),
  CONSTRAINT `fuente_codigo_fkey` FOREIGN KEY (`fuente`) REFERENCES `codigo` (`id`),
  CONSTRAINT `solicitante_ticket_fkey` FOREIGN KEY (`solicitante`) REFERENCES `usuario` (`id`),
  CONSTRAINT `tecnico_ticket_fkey` FOREIGN KEY (`tecnico`) REFERENCES `usuario` (`id`),
  CONSTRAINT `tipo_codigo_fkey` FOREIGN KEY (`tipo`) REFERENCES `codigo` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket`
--

LOCK TABLES `ticket` WRITE;
/*!40000 ALTER TABLE `ticket` DISABLE KEYS */;
INSERT INTO `ticket` VALUES (1,'CR','a','a','2018-08-20 01:37:31',NULL,NULL,NULL,4,1,NULL,5),(2,'AT','Prueba uno','Prueba dos','2018-08-20 01:53:28','2018-08-20 03:17:18','Se procedio a la atencion del requerimiento',NULL,5,1,2,6);
/*!40000 ALTER TABLE `ticket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `usuario` varchar(10) DEFAULT NULL,
  `pwd` varchar(45) DEFAULT NULL,
  `correo` varchar(45) DEFAULT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  `estado` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'usuario','123456','usuario@ayudat.com','usuario','a',1),(2,'tecnico','123456','tecnivo@ayudat.com','tecnico','a',1);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-08-19 22:45:03
