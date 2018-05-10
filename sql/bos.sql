/*
SQLyog Ultimate v11.11 (64 bit)
MySQL - 5.5.22 : Database - bos
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`bos` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `bos`;

/*Table structure for table `bc_decidedzone` */

DROP TABLE IF EXISTS `bc_decidedzone`;

CREATE TABLE `bc_decidedzone` (
  `id` varchar(32) NOT NULL,
  `staff_id` varchar(32) DEFAULT NULL,
  `name` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKh0xplk12o52a6eryw4hcqnfwt` (`staff_id`),
  CONSTRAINT `FKh0xplk12o52a6eryw4hcqnfwt` FOREIGN KEY (`staff_id`) REFERENCES `bc_staff` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `bc_decidedzone` */

/*Table structure for table `bc_region` */

DROP TABLE IF EXISTS `bc_region`;

CREATE TABLE `bc_region` (
  `id` varchar(32) NOT NULL,
  `province` varchar(50) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `district` varchar(50) DEFAULT NULL,
  `postcode` varchar(50) DEFAULT NULL,
  `shortcode` varchar(30) DEFAULT NULL,
  `citycode` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `bc_region` */

insert  into `bc_region`(`id`,`province`,`city`,`district`,`postcode`,`shortcode`,`citycode`) values ('QY001','北京市','北京市','东城区','110101','BJBJDC','beijing'),('QY002','北京市','北京市','西城区','110102','BJBJXC','beijing'),('QY003','北京市','北京市','朝阳区','110105','BJBJCY','beijing'),('QY004','北京市','北京市','丰台区','110106','BJBJFT','beijing'),('QY005','北京市','北京市','石景山区','110107','BJBJSJS','beijing'),('QY006','北京市','北京市','海淀区','110108','BJBJHD','beijing'),('QY007','北京市','北京市','门头沟区','110109','BJBJMTG','beijing'),('QY008','北京市','北京市','房山区','110111','BJBJFS','beijing'),('QY009','北京市','北京市','通州区','110112','BJBJTZ','beijing'),('QY010','北京市','北京市','顺义区','110113','BJBJSY','beijing'),('QY011','北京市','北京市','昌平区','110114','BJBJCP','beijing'),('QY012','北京市','北京市','大兴区','110115','BJBJDX','beijing'),('QY013','北京市','北京市','怀柔区','110116','BJBJHR','beijing'),('QY014','北京市','北京市','平谷区','110117','BJBJPG','beijing'),('QY015','北京市','北京市','密云县','110228','BJBJMY','beijing'),('QY016','北京市','北京市','延庆县','110229','BJBJYQ','beijing'),('QY017','河北省','石家庄市','长安区','130102','HBSJZZA','shijiazhuang'),('QY018','河北省','石家庄市','桥东区','130103','HBSJZQD','shijiazhuang'),('QY019','河北省','石家庄市','桥西区','130104','HBSJZQX','shijiazhuang'),('QY020','河北省','石家庄市','新华区','130105','HBSJZXH','shijiazhuang'),('QY021','河北省','石家庄市','井陉矿区','130107','HBSJZJXK','shijiazhuang'),('QY022','河北省','石家庄市','裕华区','130108','HBSJZYH','shijiazhuang'),('QY023','河北省','石家庄市','井陉县','130121','HBSJZJX','shijiazhuang'),('QY024','河北省','石家庄市','正定县','130123','HBSJZZD','shijiazhuang'),('QY025','河北省','石家庄市','栾城县','130124','HBSJZLC','shijiazhuang'),('QY026','河北省','石家庄市','行唐县','130125','HBSJZXT','shijiazhuang'),('QY027','河北省','石家庄市','灵寿县','130126','HBSJZLS','shijiazhuang'),('QY028','河北省','石家庄市','高邑县','130127','HBSJZGY','shijiazhuang'),('QY029','河北省','石家庄市','深泽县','130128','HBSJZSZ','shijiazhuang'),('QY030','河北省','石家庄市','赞皇县','130129','HBSJZZH','shijiazhuang'),('QY031','河北省','石家庄市','无极县','130130','HBSJZWJ','shijiazhuang'),('QY032','河北省','石家庄市','平山县','130131','HBSJZPS','shijiazhuang'),('QY033','河北省','石家庄市','元氏县','130132','HBSJZYS','shijiazhuang'),('QY034','河北省','石家庄市','赵县','130133','HBSJZZ','shijiazhuang'),('QY035','河北省','石家庄市','辛集市','130181','HBSJZXJ','shijiazhuang'),('QY036','河北省','石家庄市','藁城市','130182','HBSJZGC','shijiazhuang'),('QY037','河北省','石家庄市','晋州市','130183','HBSJZJZ','shijiazhuang'),('QY038','河北省','石家庄市','新乐市','130184','HBSJZXL','shijiazhuang'),('QY039','河北省','石家庄市','鹿泉市','130185','HBSJZLQ','shijiazhuang'),('QY040','天津市','天津市','和平区','120101','TJTJHP','tianjin'),('QY041','天津市','天津市','河东区','120102','TJTJHD','tianjin'),('QY042','天津市','天津市','河西区','120103','TJTJHX','tianjin'),('QY043','天津市','天津市','南开区','120104','TJTJNK','tianjin'),('QY044','天津市','天津市','河北区','120105','TJTJHB','tianjin'),('QY045','天津市','天津市','红桥区','120106','TJTJHQ','tianjin'),('QY046','天津市','天津市','滨海新区','120116','TJTJBHX','tianjin'),('QY047','天津市','天津市','东丽区','120110','TJTJDL','tianjin'),('QY048','天津市','天津市','西青区','120111','TJTJXQ','tianjin'),('QY049','天津市','天津市','津南区','120112','TJTJJN','tianjin'),('QY050','天津市','天津市','北辰区','120113','TJTJBC','tianjin'),('QY051','天津市','天津市','武清区','120114','TJTJWQ','tianjin'),('QY052','天津市','天津市','宝坻区','120115','TJTJBC','tianjin'),('QY053','天津市','天津市','宁河县','120221','TJTJNH','tianjin'),('QY054','天津市','天津市','静海县','120223','TJTJJH','tianjin'),('QY055','天津市','天津市','蓟县','120225','TJTJJ','tianjin'),('QY056','山西省','太原市','小店区','140105','SXTYXD','taiyuan'),('QY057','山西省','太原市','迎泽区','140106','SXTYYZ','taiyuan'),('QY058','山西省','太原市','杏花岭区','140107','SXTYXHL','taiyuan'),('QY059','山西省','太原市','尖草坪区','140108','SXTYJCP','taiyuan'),('QY060','山西省','太原市','万柏林区','140109','SXTYWBL','taiyuan'),('QY061','山西省','太原市','晋源区','140110','SXTYJY','taiyuan'),('QY062','山西省','太原市','清徐县','140121','SXTYQX','taiyuan'),('QY063','山西省','太原市','阳曲县','140122','SXTYYQ','taiyuan'),('QY064','山西省','太原市','娄烦县','140123','SXTYLF','taiyuan'),('QY065','山西省','太原市','古交市','140181','SXTYGJ','taiyuan');

/*Table structure for table `bc_staff` */

DROP TABLE IF EXISTS `bc_staff`;

CREATE TABLE `bc_staff` (
  `id` varchar(32) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  `haspda` varchar(1) DEFAULT NULL,
  `deltag` varchar(1) DEFAULT NULL,
  `station` varchar(40) DEFAULT NULL,
  `standard` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `bc_staff` */

insert  into `bc_staff`(`id`,`name`,`telephone`,`haspda`,`deltag`,`station`,`standard`) values ('4028748162d20ab60162d20bca620000','张三','13111111111','1','1','国企','10公斤'),('4028748162d69a4e0162d69d836d0000','李四','18000000000','1','1','私企','标准一'),('4028748162d790e80162d796e3600000',' 王五','14243443443','1','1','中转站','30公斤'),('4028940d6335494501633551e3a60000','张大航','15552333333','0','0','私企','5公斤');

/*Table structure for table `bc_subarea` */

DROP TABLE IF EXISTS `bc_subarea`;

CREATE TABLE `bc_subarea` (
  `id` varchar(32) NOT NULL,
  `decidedzone_id` varchar(32) DEFAULT NULL,
  `region_id` varchar(32) DEFAULT NULL,
  `addresskey` varchar(100) DEFAULT NULL,
  `startnum` varchar(30) DEFAULT NULL,
  `endnum` varchar(30) DEFAULT NULL,
  `single` varchar(1) DEFAULT NULL,
  `position` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKlndbc8oldgbg3k1x63n3n6t7n` (`decidedzone_id`),
  KEY `FKcjwxm19mx5njn3xyqgqp431mb` (`region_id`),
  CONSTRAINT `FKcjwxm19mx5njn3xyqgqp431mb` FOREIGN KEY (`region_id`) REFERENCES `bc_region` (`id`),
  CONSTRAINT `FKlndbc8oldgbg3k1x63n3n6t7n` FOREIGN KEY (`decidedzone_id`) REFERENCES `bc_decidedzone` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `bc_subarea` */

insert  into `bc_subarea`(`id`,`decidedzone_id`,`region_id`,`addresskey`,`startnum`,`endnum`,`single`,`position`) values ('4028748162ddaeb10162ddb24a060000',NULL,'QY011','昌平','234324','234324','0','天堂一号'),('4028748162e1ee7a0162e1f0b3d60000',NULL,'QY024','正定县','3424','23423','2','地狱2号');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` varchar(32) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(32) NOT NULL,
  `salary` double DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `station` varchar(40) DEFAULT NULL,
  `telephone` varchar(11) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`password`,`salary`,`birthday`,`gender`,`station`,`telephone`,`remark`) values ('1','admin','e10adc3949ba59abbe56e057f20f883e',NULL,NULL,NULL,NULL,NULL,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
