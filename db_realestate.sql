/*
SQLyog Community v12.5.0 (64 bit)
MySQL - 10.1.36-MariaDB : Database - realestate
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`realestate` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `realestate`;

/*Table structure for table `city` */

DROP TABLE IF EXISTS `city`;

CREATE TABLE `city` (
  `idcity` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idcity`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `city` */

insert  into `city`(`idcity`,`name`) values 
(1,'Beograd'),
(2,'Novi Sad'),
(3,'Nis'),
(4,'Kragujevac'),
(5,'Subotica');

/*Table structure for table `hibernate_sequence` */

DROP TABLE IF EXISTS `hibernate_sequence`;

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `hibernate_sequence` */

insert  into `hibernate_sequence`(`next_val`) values 
(4);

/*Table structure for table `person` */

DROP TABLE IF EXISTS `person`;

CREATE TABLE `person` (
  `type` varchar(31) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `firstname` varchar(255) DEFAULT NULL,
  `jmbg` varchar(255) DEFAULT NULL,
  `lastname` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `hire_date` date DEFAULT NULL,
  `workbooknumber` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

/*Data for the table `person` */

insert  into `person`(`type`,`id`,`email`,`firstname`,`jmbg`,`lastname`,`phone_number`,`hire_date`,`workbooknumber`) values 
('employee',1,'ana@gmail.com','Ana','23654789','Colovic',NULL,'2019-09-01','1123'),
('employee',2,'jovana@gmail.com','Jovana','12587777','Mitrovic',NULL,'2019-09-01','1456'),
('client',3,'ludidzudi@gmail.com','Ana','12547965','Dzudovic','065555555',NULL,NULL),
('client',5,'ana.colovic996@gmail.com','Maja','1236547896666','Colovic','06396325874',NULL,NULL),
('client',6,'ana.colovic996@gmail.com','Jovan','1236987455555','Colovic','063963852741',NULL,NULL);

/*Table structure for table `real_estate` */

DROP TABLE IF EXISTS `real_estate`;

CREATE TABLE `real_estate` (
  `idrealestate` int(11) NOT NULL AUTO_INCREMENT,
  `adress` varchar(255) DEFAULT NULL,
  `area` double NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `file_name` varchar(255) DEFAULT NULL,
  `floor` int(11) NOT NULL,
  `rooms` double NOT NULL,
  `type` int(11) DEFAULT NULL,
  `city_idcity` int(11) DEFAULT NULL,
  `owner_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`idrealestate`),
  KEY `FK700iy4cqxvgf3suc91s7cms9r` (`city_idcity`),
  KEY `FK1hb5wk2ido4hn02q8o6bx2ha6` (`owner_id`),
  CONSTRAINT `FK1hb5wk2ido4hn02q8o6bx2ha6` FOREIGN KEY (`owner_id`) REFERENCES `person` (`id`),
  CONSTRAINT `FK700iy4cqxvgf3suc91s7cms9r` FOREIGN KEY (`city_idcity`) REFERENCES `city` (`idcity`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

/*Data for the table `real_estate` */

insert  into `real_estate`(`idrealestate`,`adress`,`area`,`description`,`file_name`,`floor`,`rooms`,`type`,`city_idcity`,`owner_id`) values 
(1,'Beogradska 34',300,'Stan u centru grada, na atraktivnoj lokaciji','c267d9b836d99b10e6cc882f42b60d7cl-w0xd-w1020_h770_q80_1567347996130.jpg',7,5,0,1,5),
(2,'Bulevar oslobodjenja 45',150,'Stan u centru Novog Sada. Idealan za mlade porodice','8ecb8b5c10a19ccbe1daba7bc38ec77cw-c291298xd-w685_h860_q80_1567349407808.jpg',3,3,0,2,5),
(3,'Francuska 1',150,'Luksuzna kuca','FetchImage_1567349460751.jpg',1,5,1,1,5),
(4,'Glavna 33',200,'Vila u predgradju Subotice. LUX!','FetchImage (1)_1567349511967.jpg',0,6,1,5,5),
(5,'Bulevar Nikole Tesle 45',100,'Odlican za manje firme','811-office-space-for-rent-on-tonk-road-jaipur_1567373645967.jpg',9,2,2,1,6),
(6,'Bulevar oslobodjenja 1',150,'Lokal za nove start-up firme','78985775-400x300_1567373749745.jpeg',2,3,2,1,6),
(7,'Pozeska 44',220,'Dodatni sadrzaji na upit','banner2_1567373822701.jpg',2,9,1,4,6),
(8,'Niska 1',88,'','west-chester-apartment-Living-room-3_1567373985742.jpg',7,4,0,3,6),
(9,'Simina 12',70,'Pogled na centar grada','17615-308068_1567374026186.jpg',11,1,2,3,6),
(10,'Simina 15',114,'','18237-249259_1567374071709.jpg',8,1,2,3,6),
(11,'Borska 34b',316,'Veliko dvoriste, bazen. U potpunosti opremljena kuca','luxury-houses-with-yellow-light-in-modern-villa-at-night-03-HD-picture_1567587645451.jpg',3,10,1,1,6),
(12,'Rudo 3',115,'','studio-intro_1567587710522.jpg',9,3,0,1,6),
(13,'Adresa ',0,'Opis','FetchImage (1)_1567772944465.jpg',0,0,1,1,6);

/*Table structure for table `real_estate_ad` */

DROP TABLE IF EXISTS `real_estate_ad`;

CREATE TABLE `real_estate_ad` (
  `type` varchar(31) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `creation_date` date DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `minimummonths` int(11) DEFAULT NULL,
  `rentprice` double DEFAULT NULL,
  `price` double DEFAULT NULL,
  `registered` bit(1) DEFAULT NULL,
  `real_estate_idrealestate` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK7i6hehyxutirurfsqg21aop1e` (`real_estate_idrealestate`),
  CONSTRAINT `FK7i6hehyxutirurfsqg21aop1e` FOREIGN KEY (`real_estate_idrealestate`) REFERENCES `real_estate` (`idrealestate`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

/*Data for the table `real_estate_ad` */

insert  into `real_estate_ad`(`type`,`id`,`creation_date`,`description`,`status`,`minimummonths`,`rentprice`,`price`,`registered`,`real_estate_idrealestate`) values 
('RENT',1,'2019-09-01','Izdaje se stan. HITNO',0,5,700,NULL,NULL,1),
('SELL',2,'2019-09-01','',0,NULL,NULL,350000,'',4),
('SELL',3,'2019-09-01','Mogucnost dogovora oko cene',0,NULL,NULL,130000,'',2),
('SELL',4,'2019-09-01','Centar grada. Samo ozbiljni kupci',0,NULL,NULL,400000,'',3),
('RENT',5,'2019-09-01','***NOVO***',0,12,1000,NULL,NULL,6),
('RENT',6,'2019-09-01','Ponovo dostupan za izdavanje',0,8,1500,NULL,NULL,5),
('SELL',7,'2019-09-01','LUX',0,NULL,NULL,500000,'',7),
('SELL',8,'2019-09-02','',0,NULL,NULL,100000,'',8),
('RENT',9,'2019-09-02','',0,2,1100,NULL,NULL,10),
('RENT',10,'2019-09-04','Opremljen stan za izdavanje. Pogodan za mlade',0,3,700,NULL,NULL,12),
('SELL',11,'2019-09-04','Mogucnost dogovora oko cene',0,NULL,NULL,600000,'\0',11);

/*Table structure for table `user_profile` */

DROP TABLE IF EXISTS `user_profile`;

CREATE TABLE `user_profile` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `roles` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `person_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK9551piq2wp9kh4kket0wr65vt` (`username`),
  KEY `FKo60g374y9u090wpxr5k8xmssh` (`person_id`),
  CONSTRAINT `FKo60g374y9u090wpxr5k8xmssh` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

/*Data for the table `user_profile` */

insert  into `user_profile`(`id`,`active`,`password`,`roles`,`username`,`person_id`) values 
(1,'','$2a$10$8wyS38brYB5TPqiyTaxQJ.RbocE6JTr/HvsQWZVV5/xMhusjRy8OW','ADMIN','ana',1),
(2,'','$2a$10$fIGhBj/ETE5J2iEfsGZz3O0pSyZLi.aEQiXuFSXCw/qC3DBx0oIlG','ADMIN','jovana',2),
(3,'','$2a$10$a3J9UPf0NVC7h0MUyNYHF.wCv6ierPD2s3oaFML0Zh581aNGU0JMu','USER','ludidzudi',3),
(5,'','$2a$10$UAtvdcxzRk/gvwjAdHn2Iebs2Kgc9K7HjgyGUYrekERgDSHsWGg5q','USER','maja',5),
(6,'','$2a$10$EMSrnlJtdnP2hBVEVqFRTe.YJ.GI7m06.f5MyKVtb5EQn28x3kzui','USER','jovan',6);

/*Table structure for table `verification_token` */

DROP TABLE IF EXISTS `verification_token`;

CREATE TABLE `verification_token` (
  `tokenid` int(11) NOT NULL,
  `confirmation_token` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`tokenid`),
  KEY `FKe1i5d0gmssrjmtqnrir85t8mc` (`user_id`),
  CONSTRAINT `FKe1i5d0gmssrjmtqnrir85t8mc` FOREIGN KEY (`user_id`) REFERENCES `user_profile` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `verification_token` */

insert  into `verification_token`(`tokenid`,`confirmation_token`,`created_date`,`user_id`) values 
(2,'6bbbe305-a61a-4f8a-9df2-4b30d7113d69','2019-09-01 16:16:10.000000',5),
(3,'18ffecfb-d123-4799-8819-296be765f7d0','2019-09-01 23:31:05.000000',6);

/*Table structure for table `viewing_appointment` */

DROP TABLE IF EXISTS `viewing_appointment`;

CREATE TABLE `viewing_appointment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL,
  `client_id` int(11) DEFAULT NULL,
  `real_estate_ad_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKdwv87efp8arwohn1cuyvd64vq` (`client_id`,`real_estate_ad_id`),
  KEY `FK9fhpww5xhry2q5e8luyf1yx3c` (`real_estate_ad_id`),
  CONSTRAINT `FK9fhpww5xhry2q5e8luyf1yx3c` FOREIGN KEY (`real_estate_ad_id`) REFERENCES `real_estate_ad` (`id`) ON DELETE CASCADE,
  CONSTRAINT `FKiwt73ukeity4uqfma392h9dg5` FOREIGN KEY (`client_id`) REFERENCES `person` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

/*Data for the table `viewing_appointment` */

insert  into `viewing_appointment`(`id`,`date`,`client_id`,`real_estate_ad_id`) values 
(3,'2019-09-12',6,4),
(4,'2019-09-02',6,3),
(8,'2019-09-17',6,1),
(10,'2019-09-26',6,2);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
