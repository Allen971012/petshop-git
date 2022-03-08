-- MySQL dump 10.16  Distrib 10.3.7-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: petshop
-- ------------------------------------------------------
-- Server version	10.3.7-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `city` varchar(50) NOT NULL COMMENT '瞥庈靡想',
  `district` varchar(50) NOT NULL COMMENT '?^郖靡想',
  `zipcode` int(11) NOT NULL COMMENT '赩綒?^??',
  `detail` varchar(255) NOT NULL COMMENT '????華硊',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (9,'台北市','內湖區',114,'文湖街21巷17弄9號2樓'),(10,'台北市','內湖區',114,'內湖路一段91巷2號1樓'),(14,'台北市','內湖區',114,'文湖街21巷17弄9號2樓'),(15,'台北市','內湖區',114,'文湖街21巷17弄9號2樓'),(16,'台北市','內湖區',114,'文湖街21巷17弄9號2樓'),(17,'台北市','內湖區',114,'文湖街21巷17弄9號2樓');
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `address_order`
--

DROP TABLE IF EXISTS `address_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `address_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` varchar(255) DEFAULT NULL,
  `address_id` int(11) NOT NULL COMMENT '華硊id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address_order`
--

LOCK TABLES `address_order` WRITE;
/*!40000 ALTER TABLE `address_order` DISABLE KEYS */;
INSERT INTO `address_order` VALUES (5,'cada1a32-b0d3-44ea-91d4-d07650ddb560',9),(6,'fbcd4151-92a4-4689-99f2-facfb85ffecc',10),(10,'7010b237-d5f0-466f-936d-3e1649534864',14),(11,'c7652340-1b90-4b1f-bf62-70f18fecb079',15),(12,'852a276a-51d6-4717-837e-6806ad004e24',16),(13,'e8827c79-28de-4ecb-8246-30e81e23a542',17);
/*!40000 ALTER TABLE `address_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_product`
--

DROP TABLE IF EXISTS `order_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(11) NOT NULL COMMENT '???姽d',
  `product_id` int(11) NOT NULL COMMENT '妀こid',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_product`
--

LOCK TABLES `order_product` WRITE;
/*!40000 ALTER TABLE `order_product` DISABLE KEYS */;
INSERT INTO `order_product` VALUES (1,1,1),(2,1,2);
/*!40000 ALTER TABLE `order_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_user`
--

DROP TABLE IF EXISTS `order_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(11) NOT NULL COMMENT '???姽d',
  `user_id` int(11) NOT NULL COMMENT '蚚?灁d',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_user`
--

LOCK TABLES `order_user` WRITE;
/*!40000 ALTER TABLE `order_user` DISABLE KEYS */;
INSERT INTO `order_user` VALUES (1,1,2);
/*!40000 ALTER TABLE `order_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permission`
--

DROP TABLE IF EXISTS `permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL COMMENT '權限網址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permission`
--

LOCK TABLES `permission` WRITE;
/*!40000 ALTER TABLE `permission` DISABLE KEYS */;
INSERT INTO `permission` VALUES (1,'/index/index.html'),(2,'/system/login.html'),(3,'/system/register.html'),(4,'/system/update.html'),(5,'/product/product_dog.html'),(6,'/product/product_cat.html'),(7,'/product/product_detail.html'),(8,'/product/product_food.html'),(9,'/product/product_snack.html'),(10,'/product/product_can.html'),(11,'/product/product_toy.html'),(12,'/product/product_pretty.html'),(13,'/product/product_outdoor.html'),(14,'/product/product_dog_food.html'),(15,'/product/product_dog_snack.html'),(16,'/product/product_dog_can.html'),(17,'/product/product_dog_toy.html'),(18,'/product/product_dog_pretty.html'),(19,'/product/product_dog_outdoor.html'),(20,'/product/product_cat_food.html'),(21,'/product/product_cat_snack.html'),(22,'/product/product_cat_can.html'),(23,'/product/product_cat_toy.html'),(24,'/product/product_cat_pretty.html'),(25,'/product/product_cat_outdoor.html'),(26,'/search/search.html'),(27,'/order/order_tracking.html'),(28,'/order/order_detail.html'),(29,'/shop/shoppingcart.html');
/*!40000 ALTER TABLE `permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL COMMENT '商品標題',
  `price` int(11) NOT NULL COMMENT '商品價格',
  `content` varchar(255) NOT NULL COMMENT '商品介紹html代碼',
  `img` varchar(255) NOT NULL COMMENT '商品圖片',
  `createtime` datetime NOT NULL COMMENT '上架時間',
  `tag_names` varchar(255) NOT NULL COMMENT '商品標籤組',
  `click_count` int(11) NOT NULL COMMENT '點擊次數',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=133 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'希爾思寵物食品 成犬 低卡',1000,'<li><p>低卡路里與左旋肉酸素有助於維持理想體重</p></li><li><p>優質蛋白質與天然纖維可幫助在正餐之間維持飽足感</p></li><li><p>Omega-6 與維生素 E 有助於皮毛亮麗</p></li>','/img/dog_food01.jpg','2021-12-25 13:33:00','狗狗商品,飼料',10),(2,'希爾思寵物食品 成犬 完美體重',1200,'<li><p>10 週內可見到顯著且安全有效的減重成果</p></li><li><p>維持健康體重及長期持續控制體重</p></li><li><p>維持精實肌肉</p></li>','/img/dog_food02.jpg','2021-12-25 13:33:00','狗狗商品,飼料',5),(3,'希爾思寵物食品 小型及迷你成犬 完美體重',1200,'<li><p>10 週內可見到顯著且安全有效的減重成果</p></li><li><p>維持健康體重及長期持續控制體重</p></li><li><p>維持精實肌肉</p></li>','/img/dog_food03.jpg','2021-12-25 13:33:00','狗狗商品,飼料',3),(4,'希爾思寵物食品 成犬 低卡 小顆粒',1100,'<li><p>低卡路里與左旋肉酸素有助於維持理想體重</p></li><li><p>優質蛋白質與天然纖維可幫助在正餐之間維持飽足感</p></li><li><p>維持健康體重與生活型態。美味的雞肉口味小顆粒配方，提供喜愛不同風味的寵物們選擇</p></li>','/img/dog_food04.jpg','2021-12-25 13:33:00','狗狗商品,飼料',4),(5,'希爾思處方食品 犬用 多重管理',1100,'<li><p>醫療級含量的左旋肉酸素</p></li><li><p>可溶性及不可溶性纖維混合配方</p></li><li><p>適當的脂肪含量及卡路里</p></li>','/img/dog_food05.jpg','2021-12-25 13:33:00','狗狗商品,飼料',2),(6,'VeRUS 威洛司 成犬體重控制配方/老犬均衡配方天然糧-糙米.羊肉粉&燕麥',900,'<li><p>適合體重過重、低運動量或體重控制成犬或老年犬</p></li><li><p>可榮獲美國WDJ雜誌連續推薦優質天然糧</p></li>','/img/dog_food06.jpg','2021-12-25 13:33:00','狗狗商品,飼料',0),(7,'VeRUS 威洛司 嚴選天然犬糧-雞肉粉.燕麥&糙米',950,'<li><p>適合全年齡全品種狗狗</p></li><li><p>榮獲美國WDJ雜誌連續推薦優質天然糧</p></li>','/img/dog_food07.jpg','2021-12-25 13:33:00','狗狗商品,飼料',0),(8,'VeRUS 威洛司 嚴選成犬天然糧-羊肉粉.燕麥&糙米',950,'<li><p>適合全年齡全品種狗狗</p></li><li><p>榮獲美國WDJ雜誌連續推薦優質天然糧</p></li>','/img/dog_food08.jpg','2021-12-25 13:33:00','狗狗商品,飼料',0),(9,'Evolve 伊法 天然犬糧-去骨羊肉&糙米配方14LB(6.3KG)',1400,'<li><p>天然犬糧，不含大豆、小麥、玉米及人工添加物、色素</p></li><li><p>榮獲2021年WDJ專業推薦品牌</p></li>','/img/dog_food09.jpg','2021-12-25 13:33:00','狗狗商品,飼料',1),(10,'Evolve 伊法 天然無穀犬糧-高齡犬配方-去骨雞肉甜薯&莓果4LB(約1.81KG)',700,'<li><p>降低熱量配方，但一樣含有相同營養配方</p></li><li><p>葡萄糖胺及軟骨素，有助幫助關節健康</p></li>','/img/dog_food10.jpg','2021-12-25 13:33:00','狗狗商品,飼料',0),(11,'Evolve 伊法 天然無穀犬糧-幼犬配方-去骨雞肉甜薯&藍苺',1600,'<li><p>天然無穀犬糧，不含大豆、小麥、玉米及人工添加物、色素</p></li><li><p>益生菌&益生元添加，有助消化道健康</p></li><li><p>亞麻籽粉，含豐富Omega脂肪酸，有助健康皮膚及明亮毛色</p></li>','/img/dog_food11.jpg','2021-12-25 13:33:00','狗狗商品,飼料',0),(12,'Health Extension 綠野鮮食 天然無穀成幼犬糧-鹿肉配方',2200,'<li><p>獲得ACA(美國犬種協會)的背書認可</p></li><li><p>榮獲2021年美國WDJ雜誌推薦優質品牌</p></li>','/img/dog_food12.jpg','2021-12-25 13:33:00','狗狗商品,飼料',0),(13,'Health Extension 綠野鮮食 天然優質成幼犬-小顆粒',1800,'<li><p>顆粒形狀：圓形扁平狀，直徑約0.5公分(適合迷你型食用)</p></li><li><p>採用自由放養雞肉，沒有抗生素，也不含任何動物副產品</p></li>','/img/dog_food13.jpg','2021-12-25 13:33:00','狗狗商品,飼料',1),(14,'PureLUXE 循味 天然無穀犬糧-室內幼犬(火雞肉&鮭魚)(約10.8KG)',2300,'<li><p>低GI(升醣指數)配方，控制血糖平衡</p></li><li><p>控制食慾及延緩飢餓感，防止肥胖</p></li><li><p>5星級營養&超級食物</p></li>','/img/dog_food14.jpg','2021-12-25 13:33:00','狗狗商品,飼料',1),(15,'PureLUXE 循味 天然無穀成犬糧-鮭魚&豌豆24LB (約10.8KG)',2300,'<li><p>低GI(升醣指數)配方，控制血糖平衡</p></li><li><p>控制食慾及延緩飢餓感，防止肥胖</p></li><li><p>5星級營養&超級食物</p></li>','/img/dog_food15.jpg','2021-12-25 13:33:00','狗狗商品,飼料',0),(16,'Evolve 伊法 天然無穀犬糧-幼犬配方-去骨雞肉甜薯&藍苺 750g分裝包',150,'<li><p>去骨雞肉為第一主要成份來源，高品質蛋白質來源</p></li><li><p>亞麻籽粉，含豐富Omega脂肪酸，有助健康皮膚及明亮毛色</p></li><li><p>天然無穀犬糧，不含大豆、小麥、玉米及人工添加物、色素</p></li>','/img/dog_food16.jpg','2021-12-25 13:33:00','狗狗商品,飼料',0),(17,'Evolve 伊法 天然犬糧-去骨羊肉&糙米配方750g分裝包',125,'<li><p>去骨羊肉為第一主要成份來源，高品質蛋白質來源</p></li><li><p>混合性碳水化合物及蔬果，維生素、礦物質、油質及脂肪，完整均衡營養</p></li><li><p>益生菌&益生元添加，有助消化道健康</p></li>','/img/dog_food17.jpg','2021-12-25 13:33:00','狗狗商品,飼料',0),(18,'Evolve 伊法 天然無穀犬糧-去骨鴨肉.甜薯&鹿肉配方750g分裝包',150,'<li><p>去骨鴨肉為第一主要成份來源</p></li><li><p>專為對食物過敏狗狗，另一種選擇，增加免疫力</p></li><li><p>益生菌&益生元添加，有助消化道健康</p></li>','/img/dog_food18.jpg','2021-12-25 13:33:00','狗狗商品,飼料',21),(19,'Evolve 伊法 天然無穀犬糧-去骨鮭魚&甜薯配方750g分裝包',150,'<li><p>去骨鮭魚為第一主要成份來源</p></li><li><p>專為對食物過敏狗狗，另一種選擇，增加免疫力</p></li><li><p>益生菌&益生元添加，有助消化道健康</p></li>','/img/dog_food19.jpg','2021-12-25 13:33:00','狗狗商品,飼料',0),(20,'Evolve 伊法 天然無穀犬糧-高齡犬配方-去骨雞肉.甜薯&鷹嘴豆750g分裝包',150,'<li><p>去骨雞肉為第一主要成份來源</p></li><li><p>專為對食物過敏狗狗，另一種選擇，增加免疫力</p></li><li><p>益生菌&益生元添加，有助消化道健康</p></li>','/img/dog_food20.jpg','2021-12-25 13:33:00','狗狗商品,飼料',21),(21,'頂級饗宴 犬罐 -雞肉口味400g',38,'<li><p>FUSO頂級饗宴系列罐頭，由專家精心條理</p></li><li><p>特選優質肉類及多種營養成份</p></li><li><p>大幅增進嗜口性，並提供愛犬完整均衡營養</p></li>','/img/dog_can01.jpg','2021-12-25 13:33:00','狗狗商品,罐罐',0),(22,'FUSO 伴你一生-頂級饗宴 犬罐-羊肉400g',38,'<li><p>FUSO頂級饗宴系列罐頭，由專家精心條理</p></li><li><p>特選優質肉類及多種營養成份</p></li><li><p>大幅增進嗜口性，並提供愛犬完整均衡營養</p></li>','/img/dog_can02.jpg','2021-12-25 13:33:00','狗狗商品,罐罐',1),(23,'FUSO 伴你一生-頂級饗宴 犬罐-牛肉400g',38,'<li><p>FUSO頂級饗宴系列罐頭，由專家精心條理</p></li><li><p>特選優質肉類及多種營養成份</p></li><li><p>大幅增進嗜口性，並提供愛犬完整均衡營養</p></li>','/img/dog_can03.jpg','2021-12-25 13:33:00','狗狗商品,罐罐',0),(24,'NatureKE紐崔克犬罐/雞肉泥110g',32,'<li><p>適用寵物：全齡犬皆可食用</p></li><li><p>成份：雞肉及其副產品、動植物膠、水解動物蛋白、維他命E、綜合維他命、水</p></li>','/img/dog_can04.jpg','2021-12-25 13:33:00','狗狗商品,罐罐',0),(25,'NatureKE紐崔克犬罐/羊肉泥110g',32,'<li><p>適用寵物：全齡犬皆可食用</p></li><li><p>成份：羊肉、雞肉及其副產品、動植物膠、水解動物蛋白、維他命E、綜合維他命、水</p></li>','/img/dog_can05.jpg','2021-12-25 13:33:00','狗狗商品,罐罐',0),(26,'NatureKE紐崔克犬罐/牛肉泥110g',32,'<li><p>適用寵物：全齡犬皆可食用</p></li><li><p>成份：紐澳牛肉、牛肉及雞肉及其副產品、動植物膠、水解動物蛋白、維他命E、綜合維他命、水</p></li>','/img/dog_can06.jpg','2021-12-25 13:33:00','狗狗商品,罐罐',0),(27,'NatureKE紐崔克犬罐/幼犬專用110g',32,'<li><p>適用寵物：全齡犬皆可食用</p></li><li><p>成份：雞肉、牛肉及雞肉及其副產品、動植物膠、水解動物蛋白、維他命E、綜合維他命、水</p></li>','/img/dog_can07.jpg','2021-12-25 13:33:00','狗狗商品,罐罐',0),(28,'超級香去骨雞腿犬罐6號(香燉雞腿肉+台灣地瓜)85g',35,'<li><p>富含蛋白質，均衡營養必備要素</p></li><li><p>添加維生素及礦物質，維持生理機能增進健康，幫助骨骼及牙齒發育</p></li><li><p>全方位的最佳營養補給，多種口味選擇滿足愛犬味蕾</p></li>','/img/dog_can08.jpg','2021-12-25 13:33:00','狗狗商品,罐罐',0),(29,'超級香去骨雞腿犬罐5號(香燉雞腿肉+亞麻仁籽)85g',35,'<li><p>富含蛋白質，均衡營養必備要素</p></li><li><p>添加維生素及礦物質，維持生理機能增進健康，幫助骨骼及牙齒發育</p></li><li><p>全方位的最佳營養補給，多種口味選擇滿足愛犬味蕾</p></li>','/img/dog_can09.jpg','2021-12-25 13:33:00','狗狗商品,罐罐',0),(30,'超級香去骨雞腿犬罐4號(香燉雞腿肉+白芝麻)85g',35,'<li><p>富含蛋白質，均衡營養必備要素</p></li><li><p>添加維生素及礦物質，維持生理機能增進健康，幫助骨骼及牙齒發育</p></li><li><p>全方位的最佳營養補給，多種口味選擇滿足愛犬味蕾</p></li>','/img/dog_can10.jpg','2021-12-25 13:33:00','狗狗商品,罐罐',0),(31,'超級香去骨雞腿犬罐3號(香燉雞腿肉+藍莓)85g',35,'<li><p>富含蛋白質，均衡營養必備要素</p></li><li><p>添加維生素及礦物質，維持生理機能增進健康，幫助骨骼及牙齒發育</p></li><li><p>全方位的最佳營養補給，多種口味選擇滿足愛犬味蕾</p></li>','/img/dog_can11.jpg','2021-12-25 13:33:00','狗狗商品,罐罐',0),(32,'超級香去骨雞腿犬罐2號(香燉雞腿肉+奇亞籽)85g',35,'<li><p>富含蛋白質，均衡營養必備要素</p></li><li><p>添加維生素及礦物質，維持生理機能增進健康，幫助骨骼及牙齒發育</p></li><li><p>全方位的最佳營養補給，多種口味選擇滿足愛犬味蕾</p></li>','/img/dog_can12.jpg','2021-12-25 13:33:00','狗狗商品,罐罐',0),(33,'超級香去骨雞腿犬罐1號(香燉雞腿肉+台灣紅藜)85g',35,'<li><p>富含蛋白質，均衡營養必備要素</p></li><li><p>添加維生素及礦物質，維持生理機能增進健康，幫助骨骼及牙齒發育</p></li><li><p>全方位的最佳營養補給，多種口味選擇滿足愛犬味蕾</p></li>','/img/dog_can13.jpg','2021-12-25 13:33:00','狗狗商品,罐罐',0),(34,'冷凍乾燥犬用零食-牛鞭5支',400,'<li><p>獨特採用48小時\"慢時\"冷凍乾燥製作過程，完整保留食材營養</p></li><li><p>不添加任何人工風味、防腐劑、色素</p></li><li><p>不需冷藏，夾鏈袋包裝，出遊、訓練、每日點心的最佳口袋零食</p></li>','/img/dog_snack01.jpg','2021-12-25 13:33:00','狗狗商品,零食',0),(35,'綿綿起司焗雞腿-犬用零食70g',59,'<li><p>人用食材，選用比市面同類商品較大號數雞腿</p></li><li><p>骨頭一捏即碎，避免狗狗因食用骨頭刺傷腸胃</p></li><li><p>無添加人工色素、無添加防腐劑</p></li>','/img/dog_snack02.jpg','2021-12-25 13:33:00','狗狗商品,零食',0),(36,'綿綿義式蕃茄雞腿-犬用零食70g',59,'<li><p>人用食材，選用比市面同類商品較大號數雞腿</p></li><li><p>骨頭一捏即碎，避免狗狗因食用骨頭刺傷腸胃</p></li><li><p>無添加人工色素、無添加防腐劑</p></li>','/img/dog_snack03.jpg','2021-12-25 13:33:00','狗狗商品,零食',0),(37,'綿綿南瓜燒雞腿-犬用零食70g',59,'<li><p>人用食材，選用比市面同類商品較大號數雞腿</p></li><li><p>骨頭一捏即碎，避免狗狗因食用骨頭刺傷腸胃</p></li><li><p>無添加人工色素、無添加防腐劑</p></li>','/img/dog_snack04.jpg','2021-12-25 13:33:00','狗狗商品,零食',0),(38,'健納緹Get Naked-頂級關節保健軟點心(狗狗專用)100g',190,'<li><p>添加重點營養成份，幫助腸胃消化、強化免疫力</p></li><li><p>吃得好又吃得補，輕鬆完成日常保養</p></li><li><p>可與飼料搭配食用，也可做訓練及獎勵零食</p></li>','/img/dog_snack05.jpg','2021-12-25 13:33:00','狗狗商品,零食',0),(39,'健納緹Get Naked-頂級腸胃保健軟點心(狗狗專用)100g',190,'<li><p>添加重點營養成份，幫助腸胃消化、強化免疫力</p></li><li><p>吃得好又吃得補，輕鬆完成日常保養</p></li><li><p>可與飼料搭配食用，也可做訓練及獎勵零食</p></li>','/img/dog_snack06.jpg','2021-12-25 13:33:00','狗狗商品,零食',0),(40,'健納緹Get Naked-頂級眼睛保健軟點心(狗狗專用)100g',190,'<li><p>添加重點營養成份，幫助腸胃消化、強化免疫力</p></li><li><p>吃得好又吃得補，輕鬆完成日常保養</p></li><li><p>可與飼料搭配食用，也可做訓練及獎勵零食</p></li>','/img/dog_snack07.jpg','2021-12-25 13:33:00','狗狗商品,零食',0),(41,'沃野-軟嫩筷子多汁雞肉條130g',139,'<li><p>低脂</p></li><li><p>人用等級製程</p></li><li><p>採用本土優質食材</p></li>','/img/dog_snack08.jpg','2021-12-25 13:33:00','狗狗商品,零食',0),(42,'沃野-特級板腱牛筷子130g',139,'<li><p>低脂</p></li><li><p>人用等級製程</p></li><li><p>採用本土優質食材</p></li>','/img/dog_snack09.jpg','2021-12-25 13:33:00','狗狗商品,零食',0),(43,'沃野-醬燒羊肩肉筷子130g',139,'<li><p>低脂</p></li><li><p>人用等級製程</p></li><li><p>採用本土優質食材</p></li>','/img/dog_snack10.jpg','2021-12-25 13:33:00','狗狗商品,零食',0),(44,'橡膠潔牙玩具-潔牙球',110,'<li><p>橡膠材質，安全無毒，不傷牙齒</p></li><li><p>堅固耐咬</p></li><li><p>適合自己玩耍或是跟主人玩互動也很適合，消耗熱量運動</p></li>','/img/dog_toy01.jpg','2021-12-25 13:33:00','狗狗商品,玩具',0),(45,'有聲咬咬絨毛玩具-狗狗(藍色)',280,'<li><p>造型可愛逗趣，顏色鮮艷</p></li><li><p>按壓會有啾啾聲，吸引狗狗注意</p></li>','/img/dog_toy02.jpg','2021-12-25 13:33:00','狗狗商品,玩具',0),(46,'有聲咬咬絨毛玩具-小豬(粉紅色)',320,'<li><p>造型可愛逗趣，顏色鮮艷</p></li><li><p>按壓會有啾啾聲，吸引狗狗注意</p></li>','/img/dog_toy03.jpg','2021-12-25 13:33:00','狗狗商品,玩具',0),(47,'有聲咬咬絨毛玩具-小熊',225,'<li><p>造型可愛逗趣，顏色鮮艷</p></li><li><p>按壓會有啾啾聲，吸引狗狗注意</p></li>','/img/dog_toy04.jpg','2021-12-25 13:33:00','狗狗商品,玩具',0),(48,'布偶小馬絨毛啾啾玩具(藍色)',225,'<li><p>造型可愛逗趣，顏色鮮艷</p></li><li><p>按壓會有啾啾聲，吸引狗狗注意</p></li>','/img/dog_toy05.jpg','2021-12-25 13:33:00','狗狗商品,玩具',0),(49,'布偶小馬絨毛啾啾玩具(粉色)',225,'<li><p>造型可愛逗趣，顏色鮮艷</p></li><li><p>按壓會有啾啾聲，吸引狗狗注意</p></li>','/img/dog_toy06.jpg','2021-12-25 13:33:00','狗狗商品,玩具',0),(50,'布偶小馬絨毛啾啾玩具(橘色)',225,'<li><p>造型可愛逗趣，顏色鮮艷</p></li><li><p>按壓會有啾啾聲，吸引狗狗注意</p></li>','/img/dog_toy07.jpg','2021-12-25 13:33:00','狗狗商品,玩具',1),(51,'EARTHY PAWZ造型魚毛絨啾啾玩具',72,'<li><p>簡約設計，自然風格</p></li><li><p>按壓會有啾啾聲，吸引狗狗注意</p></li>','/img/dog_toy08.jpg','2021-12-25 13:33:00','狗狗商品,玩具',0),(52,'愛莎蓉 寵物抗打結柔順乳液潤絲精300ml',250,'<li><p>有效舒緩長毛犬毛髮打結問題</p></li><li><p>含抗靜電元素，洗澡後使用可保持毛髮絲柔般柔順及有光澤，不再為毛髮打結而苦</p></li><li><p>調合pH值。適合所有年齡犬隻使用</p></li>','/img/dog_pretty01.jpg','2021-12-25 13:33:00','狗狗商品,美容護理',0),(53,'蕾曼芙-森林SPA犬用洗毛精(驅蚤除蟲/植本茶樹香) 470ml',420,'<li><p>專業醫美．敏弱肌低敏配方</p></li><li><p>有效提升肌膚屏障防護力，舒緩皮膚敏感、修護毛髮</p></li>','/img/dog_pretty02.jpg','2021-12-25 13:33:00','狗狗商品,美容護理',0),(54,'蕾曼芙-森林SPA犬用洗毛精(全犬適用/晨曦花果香)',420,'<li><p>無矽靈/無皂鹼/無PARABEN防腐劑/無酒精/無著色</p></li><li><p>有舒緩肌膚+潔淨消臭+滋養修復 3 in 1</p></li>','/img/dog_pretty03.jpg','2021-12-25 13:33:00','狗狗商品,美容護理',0),(55,'蕾曼芙-森林SPA犬用洗毛精(白毛光澤/清新綠茶香) 470ml',420,'<li><p>無矽靈/無皂鹼/無PARABEN防腐劑/無酒精/無著色</p></li><li><p>有舒緩肌膚+潔淨消臭+滋養修復 3 in 1</p></li>','/img/dog_pretty04.jpg','2021-12-25 13:33:00','狗狗商品,美容護理',0),(56,'蕾曼芙-森林SPA犬用洗毛精(滋養護膚/淡雅白花香)',420,'<li><p>無矽靈/無皂鹼/無PARABEN防腐劑/無酒精/無著色</p></li><li><p>有舒緩肌膚+潔淨消臭+滋養修復 3 in 1</p></li>','/img/dog_pretty05.jpg','2021-12-25 13:33:00','狗狗商品,美容護理',0),(57,'GO VITA樂維他-維他命A 潔淨清爽配方',479,'<li><p>維他命A+魚子萊姆精華</p></li><li><p>肌膚所需維他命，洗澡來補充，打造健康好肌底</p></li>','/img/dog_pretty06.jpg','2021-12-25 13:33:00','狗狗商品,美容護理',0),(58,'GO VITA樂維他-維他命B 抗菌控油配方',479,'<li><p>GO VITA 樂維他維他命洗護專家</p></li><li><p>維他命B 抗菌控油配方</p></li>','/img/dog_pretty07.jpg','2021-12-25 13:33:00','狗狗商品,美容護理',0),(59,'GO VITA樂維他-維他命C 活力光澤配方',479,'<li><p>維他命C+海藻醣</p></li><li><p>肌膚所需維他命，洗澡來補充，打造健康好肌底</p></li>','/img/dog_pretty08.jpg','2021-12-25 13:33:00','狗狗商品,美容護理',0),(60,'GO VITA樂維他-維他命E 絲緞柔順配方',479,'<li><p>維他命E + 山茶花油</p></li><li><p>肌膚所需維他命，洗澡來補充，打造健康好肌底</p></li>','/img/dog_pretty09.jpg','2021-12-25 13:33:00','狗狗商品,美容護理',0),(61,'GO VITA樂維他-維他命H 抗敏重建配方',479,'<li><p>生物素(維他命H) + 尿囊素</p></li><li><p>肌膚所需維他命，洗澡來補充，打造健康好肌底</p></li>','/img/dog_pretty10.jpg','2021-12-25 13:33:00','狗狗商品,美容護理',0),(62,'愛莎蓉 犬用天然驅蟲項圈',220,'<li><p>高品質天然驅蟲項圈</p></li><li><p>有效預防跳蚤，壁蝨，蝨子, 蟎蟲, 蟲子</p></li><li><p>適用給3個月以上的幼犬</p></li>','/img/dog_outdoor01.jpg','2021-12-25 13:33:00','狗狗商品,外出用品',0),(63,'biyaya-透明膠囊寵物提包',1399,'<li><p>表面特殊印刷，質感活潑生動</p></li><li><p>超輕量硬殼行李箱等級側板，材質輕巧耐撞</p></li><li><p>本寵物提包可輕鬆摺疊收納，不佔空間</p></li>','/img/dog_outdoor02.jpg','2021-12-25 13:33:00','狗狗商品,外出用品',0),(64,'德國FLEXI飛萊希伸縮牽繩/時尚星星系列(索狀)',650,'<li><p>符合人體工學的舒適握把</p></li><li><p>採用40年獨家專利軸心技術，操作簡易，順滑耐用，給予愛寵</p></li>','/img/dog_outdoor03.jpg','2021-12-25 13:33:00','狗狗商品,外出用品',0),(65,'德國FLEXI飛萊希伸縮牽繩/炫光系列(帶狀)',1080,'<li><p>安全反光面板</p></li><li><p>專利兩段式鎖定系統</p></li><li><p>專利繩帶引導結構</p></li>','/img/dog_outdoor04.jpg','2021-12-25 13:33:00','狗狗商品,外出用品',15),(66,'德國FLEXI飛萊希伸縮牽繩/炫光系列(帶狀)',859,'<li><p>40年以上專業經驗融合德國頂尖科技，經典系列再進化</p></li><li><p>兩大專利系統，使用更順暢</p></li><li><p>可結合LED照明警示燈及多功能便利盒</p></li>','/img/dog_outdoor05.jpg','2021-12-25 13:33:00','狗狗商品,外出用品',0),(67,'FIDA寵物伸縮牽繩(鮮橙橘)',790,'<li><p>4動感機車時尚造型－外觀設計靈感源自哈雷機車，經典時尚魅力十足</p></li><li><p>人體工學設計把手－垂直提握保持手腕順暢，手臂輕鬆久遛不累</p></li><li><p>鎖定靈敏－按鍵鎖定時間低於0.5秒</p></li>','/img/dog_outdoor06.jpg','2021-12-25 13:33:00','狗狗商品,外出用品',0),(68,'FIDA寵物伸縮牽繩(簡約白)',790,'<li><p>4動感機車時尚造型－外觀設計靈感源自哈雷機車，經典時尚魅力十足</p></li><li><p>人體工學設計把手－垂直提握保持手腕順暢，手臂輕鬆久遛不累</p></li><li><p>鎖定靈敏－按鍵鎖定時間低於0.5秒</p></li>','/img/dog_outdoor07.jpg','2021-12-25 13:33:00','狗狗商品,外出用品',0),(69,'FIDA寵物伸縮牽繩(元氣粉)',790,'<li><p>4動感機車時尚造型－外觀設計靈感源自哈雷機車，經典時尚魅力十足</p></li><li><p>人體工學設計把手－垂直提握保持手腕順暢，手臂輕鬆久遛不累</p></li><li><p>鎖定靈敏－按鍵鎖定時間低於0.5秒</p></li>','/img/dog_outdoor08.jpg','2021-12-25 13:33:00','狗狗商品,外出用品',0),(70,'新萃NS 單一肉種-無穀全齡貓(雞肉餐+超級食物)',324,'<li><p>單一動物性蛋白質：極致低敏呵護</p></li><li><p>鮮鮭魚肉第一主成分：鮮肉滿足貓咪原始食性</p></li><li><p>超級食物：藍莓、薑黃增強免疫力，蔓越莓照護泌尿系統</p></li>','/img/cat_food01.jpg','2021-12-25 13:33:00','貓貓商品,飼料',0),(71,'柏萊富-棒吉無穀海陸直送全齡貓配方',225,'<li><p>海陸鮮肉完美搭配，滿足愛貓挑嘴的食慾</p></li><li><p>小批量低溫慢火烹煮，完整釋放肉類及蔬果營養</p></li><li><p>非基改向日葵卵磷脂，維持愛貓腦部認知及心臟健康</p></li>','/img/cat_food02.jpg','2021-12-25 13:33:00','貓貓商品,飼料',1),(72,'口腔保健貓 腸胃調理健康乾糧',324,'<li><p>添加牛磺酸、離胺酸及維生素A，提供眼睛保健所需營養</p></li><li><p>DL蛋氨酸有助於泌尿道保健，符合美國AAFCO營養建議標準</p></li><li><p>全程台灣製造，雙認證品質有保證，讓毛孩們吃得安心又開心</p></li>','/img/cat_food03.jpg','2021-12-25 13:33:00','貓貓商品,飼料',0),(73,'驕傲貓-無穀火雞肉低敏化毛',860,'<li><p>為所有年齡階段的貓，調配純自然均衡來自澳洲的無穀低敏化毛配方</p></li><li><p>適用對象：全齡貓</p></li><li><p>產地：澳洲</p></li>','/img/cat_food04.jpg','2021-12-25 13:33:00','貓貓商品,飼料',0),(74,'美士全護營養-成貓有效化毛配方(農場鮮雞+糙米)',2160,'<li><p>優質鮮肉為第一成分，適口性強</p></li><li><p>自然食材的纖維有助減少毛球形成</p></li><li><p>抗氧化物有助維持健康的抵抗力</p></li>','/img/cat_food05.jpg','2021-12-25 13:33:00','貓貓商品,飼料',1),(75,'美士全護營養-特級成貓配方(特級鮭魚+糙米)',645,'<li><p>優質食材提供營養完整均衡的食譜</p></li><li><p>優質抗氧化物幫助增強抵抗力</p></li><li><p>鈣質幫助強壯骨骼與關節</p></li>','/img/cat_food06.jpg','2021-12-25 13:33:00','貓貓商品,飼料',0),(76,'優格-成幼貓(雞肉+米)(化毛高纖配方)',1960,'<li><p>添加適量纖維素－化毛球、幫助腸道蠕動</p></li><li><p>添加必需胺基酸(牛磺酸)－眼腦保健、全面發展</p></li><li><p>添加腸益菌/益菌生－整腸助消化、營養好吸收</p></li>','/img/cat_food07.jpg','2021-12-25 13:33:00','貓貓商品,飼料',0),(77,'優格-零穀室內貓(低活動量體重管理配方)',1570,'<li><p>極致零穀配方：100％不含穀物，純天然不含人工香料、色素與防腐劑</p></li><li><p>優質蛋白質：來自雞肉、火雞肉與鮭魚的蛋白質，利體重控制</p></li>','/img/cat_food08.jpg','2021-12-25 13:33:00','貓貓商品,飼料',6),(78,'天然密碼-低敏雞肉體態控制/熟齡貓',990,'<li><p>充足牛磺酸可防止視網膜病變、心臟疾病</p></li><li><p>奇亞籽提供了比鮭魚更高3倍的 OMEGA 3使皮膚更為光澤、毛色亮麗</p></li><li><p>去骨雞肉優質高蛋白，搭配低碳水化合物食材，有助於體重管理與預防肥胖</p></li>','/img/cat_food09.jpg','2021-12-25 13:33:00','貓貓商品,飼料',0),(79,'天然密碼-低敏雞肉幼/成貓( 1.8kg)',990,'<li><p>充足牛磺酸可防止視網膜病變、心臟疾病</p></li><li><p>奇亞籽提供了比鮭魚更高3倍的 OMEGA 3使皮膚更為光澤、毛色亮麗</p></li><li><p>去骨雞肉優質高蛋白，搭配低碳水化合物食材，有助於體重管理與預防肥胖</p></li>','/img/cat_food10.jpg','2021-12-25 13:33:00','貓貓商品,飼料',0),(80,'冠能-熟齡貓7+ 鮮鮭照護配方',648,'<li><p>獨家配方，提升熟齡貓健康</p></li><li><p>富含活性益生菌，13.2億菌落數/公斤</p></li><li><p>請儲存於陰涼處25度，維持活菌效益</p></li>','/img/cat_food11.jpg','2021-12-26 15:13:00','貓貓商品,飼料',4),(81,'冠能-成貓泌尿保健配方',747,'<li><p>低鎂，有助泌尿道保健</p></li><li><p>富含活性益生菌，13.2億菌落數/公斤</p></li><li><p>請儲存於陰涼處25度，維持活菌效益</p></li>','/img/cat_food12.jpg','2021-12-25 13:33:00','貓貓商品,飼料',0),(82,'梅亞奶奶-L.I.D.低敏無穀全齡貓配方',1161,'<li><p>L.I.D.特定動物蛋白</p></li><li><p>非基改食材</p></li><li><p>呵護皮毛健康</p></li>','/img/cat_food13.jpg','2021-12-25 13:33:00','貓貓商品,飼料',1),(83,'梅亞奶奶-私房無穀全齡貓配方(鮮嫩雞)(300g)',189,'<li><p>非基改食材</p></li><li><p>第一食材純雞肉</p></li><li><p>呵護皮毛健康</p></li>','/img/cat_food14.jpg','2021-12-25 13:33:00','貓貓商品,飼料',0),(84,'梅亞奶奶-私房無穀化毛室內成貓/高齡/體重控制配方(鮮嫩雞)(300g)',189,'<li><p>低熱量輕食配方</p></li><li><p>高纖化毛護腸道</p></li><li><p>第一食材純雞肉</p></li>','/img/cat_food15.jpg','2021-12-25 13:33:00','貓貓商品,飼料',0),(85,'成貓無穀燉食(健康低脂)(2.72kg)',1620,'<li><p>人類食物等級新鮮全肉為主食材</p></li><li><p>鮮肉水份含量高，灰份較低，降低結石風險</p></li><li><p>消化力，完整吸收好營養</p></li>','/img/cat_food16.jpg','2021-12-25 13:33:00','貓貓商品,飼料',0),(86,'熟齡貓無穀燉食(新鮮雞肉燉豌豆+馬鈴薯)(2.72kg)',1620,'<li><p>人類食物等級新鮮全肉為主食材</p></li><li><p>鮮肉水份含量高，灰份較低，降低結石風險</p></li><li><p>消化力，完整吸收好營養</p></li>','/img/cat_food17.jpg','2021-12-25 13:33:00','貓貓商品,飼料',0),(87,'奇異廚房 醇鮮風乾貓糧 (草原嫩羊+遠洋鯖魚)(50g)',117,'<li><p>溫和風乾製程</p></li><li><p>高營養蛋白質，均衡維生素、礦物質</p></li><li><p>豐富Omega3 不飽和脂肪酸</p></li>','/img/cat_food18.jpg','2021-12-25 13:33:00','貓貓商品,飼料',0),(88,'奇異廚房 醇鮮風乾貓糧(原野牧牛+穀飼嫩雞)(50g)',117,'<li><p>溫和風乾製程</p></li><li><p>高營養蛋白質，均衡維生素、礦物質</p></li><li><p>豐富Omega3 不飽和脂肪酸</p></li>','/img/cat_food19.jpg','2021-12-25 13:33:00','貓貓商品,飼料',0),(89,'Naturea歐金 天然無穀物貓主食罐(鮮雞肉)85g',59,'<li><p>適用對象：全齡貓</p></li><li><p>保存方法：未拆封請置於陰涼乾燥處，避免陽光直射。開封後請冷藏保存並於兩天內食用完畢</p></li><li><p>原產地：西班牙</p></li>','/img/cat_can01.jpg','2021-12-25 13:33:00','貓貓商品,罐罐',0),(90,'Cats happy day幸福時光-無穀低敏貓營養主食1號罐(雞肉+鮪魚+鮭魚)',45,'<li><p>嚴選食材－鮮嫩雞肉與鮪魚做為基底，低脂高蛋白</p></li><li><p>安心食用－不然任何穀物，絕不添加人工及化學調味</p></li><li><p>適用寵物種類：全貓種適用</p></li>','/img/cat_can02.jpg','2021-12-25 13:33:00','貓貓商品,罐罐',0),(91,'Cats happy day幸福時光-無穀低敏貓營養主食1號罐(雞肉+鮪魚+鮭魚)',45,'<li><p>嚴選食材－鮮嫩雞肉與鮪魚做為基底，低脂高蛋白</p></li><li><p>安心食用－不然任何穀物，絕不添加人工及化學調味</p></li><li><p>適用寵物種類：全貓種適用</p></li>','/img/cat_can03.jpg','2021-12-25 13:33:00','貓貓商品,罐罐',0),(92,'Cats happy day幸福時光-無穀低敏貓營養主食2號罐(雞肉+鮪魚+巴沙魚)',45,'<li><p>嚴選食材－鮮嫩雞肉與鮪魚做為基底，低脂高蛋白</p></li><li><p>安心食用－不然任何穀物，絕不添加人工及化學調味</p></li><li><p>適用寵物種類：全貓種適用</p></li>','/img/cat_can04.jpg','2021-12-25 13:33:00','貓貓商品,罐罐',0),(93,'Cats happy day幸福時光-無穀低敏貓營養主食2號罐(雞肉+鮪魚+巴沙魚)',45,'<li><p>嚴選食材－鮮嫩雞肉與鮪魚做為基底，低脂高蛋白</p></li><li><p>安心食用－不然任何穀物，絕不添加人工及化學調味</p></li><li><p>適用寵物種類：全貓種適用</p></li>','/img/cat_can05.jpg','2021-12-25 13:33:00','貓貓商品,罐罐',0),(94,'汪喵星球 98%低磷無膠 老貓銀養主食罐(鹿野土雞)',48,'<li><p>專屬營養設計，關節、腦部及心血管營養補充</p></li><li><p>慕斯質地＋水解蛋白技術，好舔食與消化吸收</p></li><li><p>完全無人工膠類</p></li>','/img/cat_can06.jpg','2021-12-25 13:33:00','貓貓商品,罐罐',0),(95,'汪喵星球 98%低磷無膠 老貓銀養主食罐(野生鰹魚)',48,'<li><p>專屬營養設計，關節、腦部及心血管營養補充</p></li><li><p>慕斯質地＋水解蛋白技術，好舔食與消化吸收</p></li><li><p>完全無人工膠類</p></li>','/img/cat_can07.jpg','2021-12-25 13:33:00','貓貓商品,罐罐',0),(96,'賀家-貓用無穀主食罐 1號(特濃上湯雞)',62,'<li><p>低碳水、中低磷、低鎂、最佳鈣磷比</p></li><li><p>特色肉絲肉泥二種口感</p></li><li><p>嚴選最優質肉品、天然食材、無防腐劑、無化學添加</p></li>','/img/cat_can08.jpg','2021-12-25 13:33:00','貓貓商品,罐罐',0),(97,'賀家-貓用無穀主食罐 2號(低敏脂香鴨)',62,'<li><p>低碳水、中低磷、低鎂、最佳鈣磷比</p></li><li><p>特色肉絲肉泥二種口感</p></li><li><p>嚴選最優質肉品、天然食材、無防腐劑、無化學添加</p></li>','/img/cat_can09.jpg','2021-12-25 13:33:00','貓貓商品,罐罐',0),(100,'沛奇-單人座貓跳台',660,'<li><p>貓咪遊戲</p></li><li><p>休憩專用</p></li><li><p>尺寸:33x33xH46公分</p></li>','/img/cat_toy01.jpg','2021-12-25 13:33:00','貓貓商品,玩具',0),(101,'沛奇-毛茸茸貓抓板',239,'<li><p>貓咪磨爪</p></li><li><p>遊戲專用</p></li><li><p>尺寸:51x10.5x2公分</p></li>','/img/cat_toy02.jpg','2021-12-25 13:33:00','貓貓商品,玩具',1),(102,'沛奇-淺灰黑斑紋貓跳台',2158,'<li><p>寵物睡覺</p></li><li><p>休憩床窩</p></li><li><p>49x49xH94公分</p></li>','/img/cat_toy03.jpg','2021-12-25 13:33:00','貓貓商品,玩具',0),(103,'沛奇-造型逗貓棒(飛舞蜻蜓)',40,'<li><p>陪伴愛貓玩耍的好幫手</p></li><li><p>拉近與貓咪的關係</p></li>','/img/cat_toy04.jpg','2021-12-25 13:33:00','貓貓商品,玩具',0),(104,'釣竿式毛毛蟲逗貓棒',90,'<li><p>釣竿式的軟性桿身，最長可伸長至60cm，加大了玩耍空間</p></li><li><p>造型逗趣毛毛蟲，顏色鮮艷，激起貓咪的狩獵感玩具</p></li><li><p>藉由遊戲與愛貓培養感情</p></li>','/img/cat_toy05.jpg','2021-12-25 13:33:00','貓貓商品,玩具',0),(105,'Amy Carol花朵系列 伸縮釣竿逗貓棒',165,'<li><p>適當紓壓，增進與寵物之間的互動與感情</p></li><li><p>美麗鮮豔的花朵，容易吸引貓咪注意</p></li><li><p>細緻輕柔的羽毛，觸感質感提升</p></li>','/img/cat_toy06.jpg','2021-12-25 13:33:00','貓貓商品,玩具',0),(106,'沛奇-鈴鈴球架',266,'<li><p>用途:貓咪遊戲專用</p></li><li><p>尺寸:29x13xH15公分</p></li><li><p>材質:刨花板、珊瑚絨</p></li>','/img/cat_toy07.jpg','2021-12-25 13:33:00','貓貓商品,玩具',0),(107,'沛奇-貓跳台',2400,'<li><p>貓咪磨爪、紓壓專用</p></li><li><p>尺寸:56x56xH120公分</p></li><li><p>產地:中國</p></li>','/img/cat_toy08.jpg','2021-12-25 13:33:00','貓貓商品,玩具',0),(108,'沛奇-喵癢癢不求人',380,'<li><p>用途:貓咪按摩、紓壓專用</p></li><li><p>尺寸:32xH34公分</p></li><li><p>產地:中國</p></li>','/img/cat_toy09.jpg','2021-12-25 13:33:00','貓貓商品,玩具',0),(109,'沛奇-塌塌米貓抓板',91,'<li><p>貓咪磨爪、紓壓專用</p></li><li><p>尺寸:45.5x22x3公分</p></li><li><p>產地:中國</p></li>','/img/cat_toy10.jpg','2021-12-25 13:33:00','貓貓商品,玩具',2),(110,'東方森草寵物沐浴保養 薏仁柔潤配方400ml',535,'<li><p>薏仁精華深層保濕滋潤肌膚，好梳理不打結</p></li><li><p>維他命B6調節油脂正常分泌</p></li><li><p>持續保持肌膚與毛髮的清爽</p></li>','/img/cat_pretty01.jpg','2021-12-25 13:33:00','貓貓商品,美容護理',0),(111,'東方森草寵物沐浴保養 牡丹抗菌配方4L',2699,'<li><p>牡丹精華能抗菌</p></li><li><p>針對皮膚容易出狀況的寵物，對抗細菌同時調理肌膚</p></li><li><p>維他命B6調節油脂正常分泌，持續保持肌膚與毛髮的清爽</p></li>','/img/cat_pretty02.jpg','2021-12-25 13:33:00','貓貓商品,美容護理',0),(112,'GO VITA樂維他-維他命B5 貓咪深層潔淨配方250ml',329,'<li><p>主要成分：水，ECOCERT認證葡萄醣苷清潔成分，椰子油清潔成分，維他命B5，積雪草，甘油，香氛</p></li><li><p>適用對象：貓</p></li><li><p>使用方式：沾濕寵物取適量產品搓揉全身，再以清水沖淨即可</p></li>','/img/cat_pretty03.jpg','2021-12-25 13:33:00','貓貓商品,美容護理',0),(113,'皇家草本-貓咪專用洗毛精500ml',279,'<li><p>使用對象：貓適用</p></li><li><p>產地：台灣</p></li>','/img/cat_pretty04.jpg','2021-12-25 13:33:00','貓貓商品,美容護理',0),(114,'皇家草本-貓咪物理性防蚤洗毛精500ml',279,'<li><p>使用對象：貓適用</p></li><li><p>產地：台灣</p></li>','/img/cat_pretty05.jpg','2021-12-25 13:33:00','貓貓商品,美容護理',0),(115,'皇家寶石-貓咪御用洗毛精400ml',359,'<li><p>使用對象：貓適用</p></li><li><p>產地：台灣</p></li>','/img/cat_pretty06.jpg','2021-12-25 13:33:00','貓貓商品,美容護理',0),(116,'YU 東方森草寵物沐浴保養 蓮花舒敏配方400ml',369,'<li><p>敏感性膚質寵物的好選擇</p></li><li><p>蓮花精華幫助敏感肌的不舒服</p></li><li><p>金縷梅、尿囊素形成保護膜，洗澡不癢癢</p></li>','/img/cat_pretty07.jpg','2021-12-25 13:33:00','貓貓商品,美容護理',0),(117,'阿凡達Avender-犬貓用蓬鬆洗毛精300ml',319,'<li><p>使用對象：貓適用</p></li><li><p>產地：台灣</p></li>','/img/cat_pretty08.jpg','2021-12-25 13:33:00','貓貓商品,美容護理',0),(118,'YU 東方森草寵物沐浴保養 山茶花修護配方4L',2699,'<li><p>適合毛髮易乾澀斷裂的寵物</p></li><li><p>山茶花油修護毛髮撫平毛鱗片</p></li><li><p>維持肌膚與毛髮健康</p></li>','/img/cat_pretty09.jpg','2021-12-25 13:33:00','貓貓商品,美容護理',0),(119,'Natura&Cat草本能量-貓咪專用草本洗毛精 潔淨控油(木蘭/鳶尾花)300ml',359,'<li><p>使用對象：貓適用</p></li><li><p>產地：台灣</p></li>','/img/cat_pretty10.jpg','2021-12-25 13:33:00','貓貓商品,美容護理',0),(120,'Felix日本菲力貓 貓脆餅-炙燒烤肉風味(雞肉,牛肉,鮭魚)60g',59,'<li><p>適用：一般成貓適用</p></li>','/img/cat_snack01.jpg','2021-12-25 13:33:00','貓貓商品,零食',1),(121,'Felix日本菲力貓 貓脆餅-海鮮拼盤風味(鮪魚,鮭魚,鯛魚)60g',59,'<li><p>適用：一般成貓適用</p></li>','/img/cat_snack02.jpg','2021-12-25 13:33:00','貓貓商品,零食',0),(122,'Felix日本菲力貓 貓脆餅-海陸三重奏風味(鮪魚,雞肉,鰹魚)60g',59,'<li><p>適用：一般成貓適用</p></li>','/img/cat_snack03.jpg','2021-12-25 13:33:00','貓貓商品,零食',0),(123,'NatureKE紐崔克貓零食No.28-雞肉細切25g',42,'<li><p>適用：一般成貓適用</p></li>','/img/cat_snack04.jpg','2021-12-25 13:33:00','貓貓商品,零食',0),(124,'NatureKE紐崔克貓零食No.22-鱈魚絲25g',42,'<li><p>適用：一般成貓適用</p></li>','/img/cat_snack05.jpg','2021-12-25 13:33:00','貓貓商品,零食',0),(125,'NatureKE紐崔克貓零食No.4-雞肉海苔25g',42,'<li><p>適用：一般成貓適用</p></li>','/img/cat_snack06.jpg','2021-12-25 13:33:00','貓貓商品,零食',28),(126,'NatureKE紐崔克貓零食No.3-雞肉海帶25g',42,'<li><p>適用：一般成貓適用</p></li>','/img/cat_snack07.jpg','2021-12-25 13:33:00','貓貓商品,零食',0),(127,'NatureKE紐崔克貓零食No.1-雞肉小魚25g',42,'<li><p>適用：一般成貓適用</p></li>','/img/cat_snack08.jpg','2021-12-25 13:33:00','貓貓商品,零食',0),(128,'NatureKE紐崔克貓零食No.2-雞肉小蝦25g',42,'<li><p>適用：一般成貓適用</p></li>','/img/cat_snack09.jpg','2021-12-25 13:33:00','貓貓商品,零食',0),(129,'日本CattyMan-貓用簡約鈴鐺項圈',59,'<li><p>使用安全扣環，防止貓咪活蹦亂跳卡住</p></li><li><p>原產地：上海</p></li>','/img/cat_outdoor01.jpg','2021-12-25 13:33:00','貓貓商品,外出用品',0),(130,'日本CattyMan-貓用簡約花紋項圈',59,'<li><p>使用安全扣環，防止貓咪活蹦亂跳卡住</p></li><li><p>原產地：上海</p></li>','/img/cat_outdoor02.jpg','2021-12-25 13:33:00','貓貓商品,外出用品',0),(131,'日本CattyMan-貓用甜蜜附吊飾項圈',59,'<li><p>使用安全扣環，防止貓咪活蹦亂跳卡住</p></li><li><p>原產地：上海</p></li>','/img/cat_outdoor03.jpg','2021-12-25 13:33:00','貓貓商品,外出用品',0),(132,'日本CattyMan-貓用甜蜜鈴鐺附吊飾項圈',59,'<li><p>使用安全扣環，防止貓咪活蹦亂跳卡住</p></li><li><p>原產地：上海</p></li>','/img/cat_outdoor04.jpg','2021-12-25 13:33:00','貓貓商品,外出用品',0);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `promotion`
--

DROP TABLE IF EXISTS `promotion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `promotion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) NOT NULL COMMENT '商品id',
  `expiredate` datetime NOT NULL COMMENT '過期時間',
  `status` int(4) NOT NULL COMMENT '0未特價,1有特價',
  `price` int(11) NOT NULL COMMENT '特價後價格',
  PRIMARY KEY (`id`),
  KEY `product_id` (`product_id`),
  CONSTRAINT `promotion_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `promotion`
--

LOCK TABLES `promotion` WRITE;
/*!40000 ALTER TABLE `promotion` DISABLE KEYS */;
INSERT INTO `promotion` VALUES (1,1,'2022-06-01 12:00:00',0,800),(2,21,'2022-06-01 12:00:00',0,20),(3,34,'2022-06-01 12:00:00',0,320),(4,52,'2022-06-01 12:00:00',0,200),(5,70,'2022-06-01 12:00:00',0,224),(6,89,'2022-06-01 12:00:00',0,42),(7,110,'2022-06-01 12:00:00',0,435),(8,124,'2022-06-01 12:00:00',0,30);
/*!40000 ALTER TABLE `promotion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL COMMENT '用戶角色名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ROLE_ADMIN'),(2,'ROLE_MEMBER');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role_permission`
--

DROP TABLE IF EXISTS `role_permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NOT NULL COMMENT '角色id',
  `permission_id` int(11) NOT NULL COMMENT '權限id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_permission`
--

LOCK TABLES `role_permission` WRITE;
/*!40000 ALTER TABLE `role_permission` DISABLE KEYS */;
INSERT INTO `role_permission` VALUES (1,1,1),(2,1,2),(3,1,3),(4,1,4),(5,1,5),(6,1,6),(7,1,7),(8,1,8),(9,1,9),(10,1,10),(11,1,11),(12,1,12),(13,1,13),(14,1,14),(15,1,15),(16,1,16),(17,1,17),(18,1,18),(19,1,19),(20,1,20),(21,1,21),(22,1,22),(23,1,23),(24,1,24),(25,1,25),(26,1,26),(27,1,27),(28,1,28),(29,1,29),(30,2,1),(31,2,2),(32,2,3),(33,2,4),(34,2,5),(35,2,6),(36,2,7),(37,2,8),(38,2,9),(39,2,10),(40,2,11),(41,2,12),(42,2,13),(43,2,14),(44,2,15),(45,2,16),(46,2,17),(47,2,18),(48,2,19),(49,2,20),(50,2,21),(51,2,22),(52,2,23),(53,2,24),(54,2,25),(55,2,26),(56,2,27),(57,2,28),(58,2,29);
/*!40000 ALTER TABLE `role_permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_order`
--

DROP TABLE IF EXISTS `t_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_num` varchar(255) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `price` int(255) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `createtime` datetime NOT NULL COMMENT '???帠匢??r嶲',
  `phone` varchar(50) NOT NULL COMMENT '窣篌????',
  `pay_status` int(11) NOT NULL COMMENT '0渾葆遴,1眒葆遴',
  PRIMARY KEY (`id`),
  KEY `product_id` (`product_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `t_order_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  CONSTRAINT `t_order_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_order`
--

LOCK TABLES `t_order` WRITE;
/*!40000 ALTER TABLE `t_order` DISABLE KEYS */;
INSERT INTO `t_order` VALUES (22,'cada1a32-b0d3-44ea-91d4-d07650ddb560',18,9,150,2,'2022-01-20 18:23:42','0988907316',1),(23,'cada1a32-b0d3-44ea-91d4-d07650ddb560',34,9,320,3,'2022-01-20 18:23:42','0988907316',1),(24,'fbcd4151-92a4-4689-99f2-facfb85ffecc',4,9,1100,2,'2022-01-21 16:53:52','0935591012',1),(25,'fbcd4151-92a4-4689-99f2-facfb85ffecc',65,9,1080,2,'2022-01-21 16:53:52','0935591012',1),(31,'7010b237-d5f0-466f-936d-3e1649534864',65,9,1080,1,'2022-01-27 16:52:10','0988907316',1),(32,'7010b237-d5f0-466f-936d-3e1649534864',2,9,1200,3,'2022-01-27 16:52:10','0988907316',1),(39,'c7652340-1b90-4b1f-bf62-70f18fecb079',18,9,150,3,'2022-02-11 13:29:09','0935591012',1),(40,'c7652340-1b90-4b1f-bf62-70f18fecb079',52,9,200,2,'2022-02-11 13:29:09','0935591012',1),(41,'852a276a-51d6-4717-837e-6806ad004e24',5,9,1100,1,'2022-02-11 18:58:30','0935591012',1),(42,'e8827c79-28de-4ecb-8246-30e81e23a542',89,9,42,1,'2022-02-11 19:06:20','0935591012',1),(43,'e8827c79-28de-4ecb-8246-30e81e23a542',77,9,1570,1,'2022-02-11 19:06:20','0935591012',1);
/*!40000 ALTER TABLE `t_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tag`
--

DROP TABLE IF EXISTS `tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tag` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL COMMENT '標籤名',
  `createby` varchar(50) NOT NULL COMMENT '標籤創建者姓名',
  `createtime` datetime NOT NULL COMMENT '標籤創立時間',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tag`
--

LOCK TABLES `tag` WRITE;
/*!40000 ALTER TABLE `tag` DISABLE KEYS */;
INSERT INTO `tag` VALUES (1,'狗狗商品','Allen','2021-12-25 13:00:00'),(2,'貓貓商品','Allen','2021-12-25 13:00:00'),(3,'飼料','Allen','2021-12-25 13:00:00'),(4,'罐罐','Allen','2021-12-25 13:00:00'),(5,'零食','Allen','2021-12-25 13:00:00'),(6,'玩具','Allen','2021-12-25 13:00:00'),(7,'美容護理','Allen','2021-12-25 13:00:00'),(8,'外出用品','Allen','2021-12-25 13:00:00');
/*!40000 ALTER TABLE `tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tag_product`
--

DROP TABLE IF EXISTS `tag_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tag_product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) NOT NULL COMMENT '商品id',
  `tag_id` int(11) NOT NULL COMMENT '標籤id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=265 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tag_product`
--

LOCK TABLES `tag_product` WRITE;
/*!40000 ALTER TABLE `tag_product` DISABLE KEYS */;
INSERT INTO `tag_product` VALUES (1,1,1),(2,1,3),(3,2,1),(4,2,3),(5,3,1),(6,3,3),(7,4,1),(8,4,3),(9,5,1),(10,5,3),(11,6,1),(12,6,3),(13,7,1),(14,7,3),(15,8,1),(16,8,3),(17,9,1),(18,9,3),(19,10,1),(20,10,3),(21,11,1),(22,11,3),(23,12,1),(24,12,3),(25,13,1),(26,13,3),(27,14,1),(28,14,3),(29,15,1),(30,15,3),(31,16,1),(32,16,3),(33,17,1),(34,17,3),(35,18,1),(36,18,3),(37,19,1),(38,19,3),(39,20,1),(40,20,3),(41,21,1),(42,21,4),(43,22,1),(44,22,4),(45,23,1),(46,23,4),(47,24,1),(48,24,4),(49,25,1),(50,25,4),(51,26,1),(52,26,4),(53,27,1),(54,27,4),(55,28,1),(56,28,4),(57,29,1),(58,29,4),(59,30,1),(60,30,4),(61,31,1),(62,31,4),(63,32,1),(64,32,4),(65,33,1),(66,33,4),(67,34,1),(68,34,5),(69,35,1),(70,35,5),(71,36,1),(72,36,5),(73,37,1),(74,37,5),(75,38,1),(76,38,5),(77,39,1),(78,39,5),(79,40,1),(80,40,5),(81,41,1),(82,41,5),(83,42,1),(84,42,5),(85,43,1),(86,43,5),(87,44,1),(88,44,6),(89,45,1),(90,45,6),(91,46,1),(92,46,6),(93,47,1),(94,47,6),(95,48,1),(96,48,6),(97,49,1),(98,49,6),(99,50,1),(100,50,6),(101,51,1),(102,51,6),(103,52,1),(104,52,7),(105,53,1),(106,53,7),(107,54,1),(108,54,7),(109,55,1),(110,55,7),(111,56,1),(112,56,7),(113,57,1),(114,57,7),(115,58,1),(116,58,7),(117,59,1),(118,59,7),(119,60,1),(120,60,7),(121,61,1),(122,61,7),(123,62,1),(124,62,8),(125,63,1),(126,63,8),(127,64,1),(128,64,8),(129,65,1),(130,65,8),(131,66,1),(132,66,8),(133,67,1),(134,67,8),(135,68,1),(136,68,8),(137,69,1),(138,69,8),(139,70,2),(140,70,3),(141,71,2),(142,71,3),(143,72,2),(144,72,3),(145,73,2),(146,73,3),(147,74,2),(148,74,3),(149,75,2),(150,75,3),(151,76,2),(152,76,3),(153,77,2),(154,77,3),(155,78,2),(156,78,3),(157,79,2),(158,79,3),(159,80,2),(160,80,3),(161,81,2),(162,81,3),(163,82,2),(164,82,3),(165,83,2),(166,83,3),(167,84,2),(168,84,3),(169,85,2),(170,85,3),(171,86,2),(172,86,3),(173,87,2),(174,87,3),(175,88,2),(176,88,3),(177,89,2),(178,89,4),(179,90,2),(180,90,4),(181,91,2),(182,91,4),(183,92,2),(184,92,4),(185,93,2),(186,93,4),(187,94,2),(188,94,4),(189,95,2),(190,95,4),(191,96,2),(192,96,4),(193,97,2),(194,97,4),(195,98,2),(196,98,4),(197,99,2),(198,99,4),(199,100,2),(200,100,6),(201,101,2),(202,101,6),(203,102,2),(204,102,6),(205,103,2),(206,103,6),(207,104,2),(208,104,6),(209,105,2),(210,105,6),(211,106,2),(212,106,6),(213,107,2),(214,107,6),(215,108,2),(216,108,6),(217,109,2),(218,109,6),(219,110,2),(220,110,7),(221,111,2),(222,111,7),(223,112,2),(224,112,7),(225,113,2),(226,113,7),(227,114,2),(228,114,7),(229,115,2),(230,115,7),(231,116,2),(232,116,7),(233,117,2),(234,117,7),(235,118,2),(236,118,7),(237,119,2),(238,119,7),(239,120,2),(240,120,5),(241,121,2),(242,121,5),(243,122,2),(244,122,5),(245,123,2),(246,123,5),(247,124,2),(248,124,5),(249,125,2),(250,125,5),(251,126,2),(252,126,5),(253,127,2),(254,127,5),(255,128,2),(256,128,5),(257,129,2),(258,129,8),(259,130,2),(260,130,8),(261,131,2),(262,131,8),(263,132,2),(264,132,8);
/*!40000 ALTER TABLE `tag_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL COMMENT '蚚?藽?',
  `password` varchar(255) DEFAULT NULL,
  `email` varchar(50) NOT NULL COMMENT '陓眊',
  `phone` varchar(50) NOT NULL COMMENT '??????徨',
  `createtime` datetime NOT NULL COMMENT '偟???r嶲',
  `enabled` tinyint(4) NOT NULL COMMENT '?厄?岆瘁褫蚚,0瘁,1岆',
  `locked` tinyint(4) NOT NULL COMMENT '?厄?岆瘁掩熵蛂,0瘁,1岆',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `phone` (`phone`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Allen','888888','qwer747485@gmail.com','0988907316','2021-12-25 12:33:00',1,0),(2,'Ben','123456','jony@gmail.com','0911111111','2021-12-25 12:35:00',1,0),(3,'Andy','{bcrypt}$2a$10$ErpTohaocD/6R.Gvgm3ly.2UVgJM0Un2X2sQFR.T5iaaQKCJc6./6','andy123@gmail.com','0978945612','2021-12-28 16:57:09',1,0),(4,'Peter','{bcrypt}$2a$10$U7opoOnoJwI6Q.bONEatcOzRef0TIndAor4Il6vzRcRNCn3GAoxwS','peter@gmail.com','0935350090','2021-12-28 17:02:56',1,0),(5,'Snowbae','{bcrypt}$2a$10$ZkTlQOU7raVP5zG8A5iV5ujb8au5QeT59p.tqro5E64so/YtSHg9K','snowbae@gmail.com','0952052052','2021-12-29 12:12:46',1,0),(6,'test01','{bcrypt}$2a$10$7h.BHoe.sTiRHJogsaGP6u8c2eP5cMEBSO.WtnPZwlP8n9EqHHK12','test01@gmail.com','0974185296','2021-12-29 12:16:16',1,0),(7,'test02','{bcrypt}$2a$10$XwIETYBi2Z106qmhMNejd.loQJWp43V6dlkQferrMVOhu3.u7dq4O','test02@gmail.com','0974185297','2021-12-29 12:19:00',1,0),(8,'test03','{bcrypt}$2a$10$TT1vaOb3JzJ5vWyKHUGF0uuiR1GED3MfcEPw8ogRFZdSzqRmWzaBe','test03@gmail.com','0945896585','2021-12-29 12:27:45',1,0),(9,'test04','{bcrypt}$2a$10$TRq3oWTXJMEJ0DNeUk/G9euSin5xtFmGCfrTX1s43HdHEVR5ZxNZm','ttest04@gmail.com','0988888888','2021-12-29 14:39:40',1,0),(15,'test05','{bcrypt}$2a$10$XnQdsSrapSB4pJFIKifwYuHCsTL/FEqKPEp4Uu/.IT78hJnefwZbO','test05@gmail.com','0955555555','2021-12-30 19:17:44',1,0),(16,'test06','{bcrypt}$2a$10$WdZRY6r.IrGx3ARkMy3.0.qWtau7UDZWd0ZgLwtAwDU1OICMIr/FO','test06@gmail.com','0966666666','2022-01-01 13:17:48',1,0),(17,'test07','{bcrypt}$2a$10$qg7sMMioBtbcvsodpI1XBuUvG4Z3Nug.4mxgGdYOyAuYlI1IqytIm','test07@gmail.com','0977777777','2022-01-01 13:20:09',1,0),(18,'test08','{bcrypt}$2a$10$G9XDdVVhMQLX4pAj2Hvf1egTMOmycVaH99pRIJxtbIdzbrOqzKwDa','test08@gmail.com','0933333333','2022-01-01 13:21:05',1,0),(19,'test09','{bcrypt}$2a$10$6lRr4En3BPcwUAkMetFKG.5wSKLUbb8Ly2GmGNgw4qk5LfS0zDaHe','test09@gmail.com','0945685545','2022-01-01 13:26:07',1,0),(20,'test10','{bcrypt}$2a$10$hdqtZ7E3ZyYtWJn7PIP8Pu52jX3bXY4Ez.hkHQoqxSQxzkoQcBAlK','test10@gmail.com','0999968563','2022-01-02 11:46:15',1,0),(21,'test11','{bcrypt}$2a$10$VJtYFh5Rbg3oA5iLEhPCzuLOB0lbfe3ssQVzovBPsu7LQ6bFGGyZq','test11@gmail.com','0945858856','2022-01-03 14:51:58',1,0),(22,'test12','{bcrypt}$2a$10$bW/EtxDAAOaD1ovgn3CkiemP8CKIloGVMAyQbmuAA90QoW0xGmCUy','test12@gmail.com','0912112121','2022-01-17 14:15:18',1,0),(23,'test13','{bcrypt}$2a$10$.ZcUjlmX/zQ4RH4KOlmO.uulY/nhA/N3rvVpDj4hdOUxm4bQCtAgS','test13@gmail.com','0913131313','2022-01-17 14:16:03',1,0),(24,'test14','{bcrypt}$2a$10$wrCJ.47sc3wGQUOAL9uoGO7YjdqfxdMWNV9hytRDIvfW9jz3RBo5.','test14@gmail.com','0914141414','2022-01-17 14:17:57',1,0),(25,'test15','{bcrypt}$2a$10$qvogy0ndWGj9Rn0p7Zd0p.G84/no1V6/E449nySsN5v2.2BMXKYq6','test15@gmail.com','0915151515','2022-01-17 14:19:31',1,0),(26,'test16','{bcrypt}$2a$10$BwXPOe.66Uw7V6aNdchthe1p0xaZN098yJRQnRfnl8IpuQwbzCkEe','test16@gmail.com','0916161616','2022-02-07 13:58:03',1,0);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_cart`
--

DROP TABLE IF EXISTS `user_cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_cart` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `product_id` (`product_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `user_cart_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  CONSTRAINT `user_cart_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=105 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_cart`
--

LOCK TABLES `user_cart` WRITE;
/*!40000 ALTER TABLE `user_cart` DISABLE KEYS */;
INSERT INTO `user_cart` VALUES (1,2,9,0,'2022-01-12 12:06:47',0),(2,3,9,0,'2022-01-13 13:42:56',17),(3,5,9,0,'2022-01-13 13:45:13',1),(26,125,9,0,'2022-01-13 23:00:47',1),(27,47,9,0,'2022-01-13 23:01:00',1),(28,18,9,0,'2022-01-14 14:28:37',2),(29,18,9,0,'2022-01-15 14:09:06',1),(30,18,9,0,'2022-01-15 14:10:36',1),(31,80,9,0,'2022-01-15 15:07:57',1),(32,20,9,0,'2022-01-16 14:45:14',14),(33,24,9,0,'2022-01-16 15:06:57',4),(34,37,9,0,'2022-01-16 15:15:40',3),(35,110,9,0,'2022-01-16 16:02:07',3),(36,110,9,0,'2022-01-16 18:40:00',1),(37,110,9,0,'2022-01-16 21:11:46',2),(38,110,9,0,'2022-01-16 21:12:23',2),(39,3,9,0,'2022-01-16 21:12:45',3),(40,3,9,0,'2022-01-16 21:13:51',3),(41,3,9,0,'2022-01-16 21:15:29',3),(42,18,9,0,'2022-01-17 14:12:58',3),(43,52,9,0,'2022-01-17 14:13:16',20),(44,65,9,0,'2022-01-17 14:42:32',3),(45,65,9,0,'2022-01-17 14:42:49',3),(46,47,9,0,'2022-01-17 14:42:55',1),(47,45,9,0,'2022-01-17 14:43:19',1),(48,56,9,0,'2022-01-17 14:43:26',1),(49,46,9,0,'2022-01-17 14:45:05',1),(50,24,9,0,'2022-01-17 14:45:10',1),(51,24,9,0,'2022-01-17 14:45:37',2),(52,38,9,0,'2022-01-17 14:45:44',1),(53,38,9,0,'2022-01-17 14:46:24',3),(54,59,9,0,'2022-01-17 14:46:31',2),(55,59,9,0,'2022-01-17 14:47:10',2),(56,47,9,0,'2022-01-17 14:47:13',1),(57,47,9,0,'2022-01-17 14:50:24',1),(58,41,9,0,'2022-01-17 14:50:33',1),(59,18,9,0,'2022-01-17 15:00:30',2),(60,55,9,0,'2022-01-17 15:00:35',2),(61,125,9,0,'2022-01-17 15:02:30',3),(62,125,9,0,'2022-01-17 15:02:34',3),(63,65,9,0,'2022-01-17 15:35:57',7),(64,4,9,0,'2022-01-17 15:36:02',2),(65,21,9,0,'2022-01-17 16:14:38',2),(66,4,9,0,'2022-01-17 16:21:26',2),(67,41,9,0,'2022-01-17 16:25:57',2),(68,3,9,0,'2022-01-17 16:58:37',2),(69,89,9,0,'2022-01-17 16:58:46',2),(70,46,9,0,'2022-01-17 17:02:06',3),(71,18,9,0,'2022-01-17 17:54:41',1),(72,20,9,0,'2022-01-17 17:58:09',1),(73,18,9,0,'2022-01-17 18:39:19',1),(74,34,9,0,'2022-01-17 18:39:30',2),(75,56,9,0,'2022-01-17 18:39:36',1),(76,2,9,0,'2022-01-18 13:43:26',3),(77,124,9,0,'2022-01-18 13:43:36',11),(78,25,9,0,'2022-01-18 13:47:04',13),(79,18,9,0,'2022-01-20 18:23:07',2),(80,34,9,0,'2022-01-20 18:23:14',3),(81,4,9,0,'2022-01-21 16:53:19',2),(82,65,9,0,'2022-01-21 16:53:24',2),(83,11,9,0,'2022-01-22 12:45:07',2),(84,60,9,0,'2022-01-22 12:45:11',1),(85,52,9,0,'2022-01-22 12:45:17',3),(86,24,9,0,'2022-01-22 13:19:53',2),(87,47,9,0,'2022-01-22 13:21:10',1),(88,52,9,0,'2022-01-22 15:46:53',1),(89,52,9,0,'2022-01-22 15:47:03',1),(90,52,9,0,'2022-01-22 15:47:19',3),(91,5,9,0,'2022-01-22 15:54:30',1),(92,65,9,0,'2022-01-25 16:40:05',1),(93,2,9,0,'2022-01-27 16:51:38',3),(94,20,9,0,'2022-02-10 20:41:03',2),(95,4,9,0,'2022-02-10 20:41:24',2),(96,52,9,0,'2022-02-10 20:43:46',3),(97,4,9,0,'2022-02-10 20:49:20',2),(98,18,9,0,'2022-02-11 11:35:21',3),(99,52,9,0,'2022-02-11 13:19:46',2),(100,5,9,0,'2022-02-11 18:58:10',1),(101,89,9,0,'2022-02-11 19:05:46',1),(102,50,9,0,'2022-02-11 19:05:54',2),(103,77,9,0,'2022-02-11 19:06:06',1),(104,101,9,0,'2022-02-15 16:05:40',1);
/*!40000 ALTER TABLE `user_cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT '用戶id',
  `role_id` int(11) NOT NULL COMMENT '角色id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,1,1),(2,2,2),(3,3,2),(4,4,2),(5,5,2),(6,6,2),(7,7,2),(8,8,2),(9,9,2),(10,10,2),(11,11,2),(12,12,2),(13,13,2),(14,14,2),(15,15,2),(16,16,2),(17,17,2),(18,18,2),(19,19,2),(20,20,2),(21,21,2),(22,22,2),(23,23,2),(24,24,2),(25,25,2),(26,26,2);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-02-23  2:36:16
