/*
 Navicat Premium Data Transfer

 Source Server         : mysql_localhost
 Source Server Type    : MySQL
 Source Server Version : 80025
 Source Host           : localhost:3306
 Source Schema         : blog

 Target Server Type    : MySQL
 Target Server Version : 80025
 File Encoding         : 65001

 Date: 25/02/2022 15:42:38
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for Blog
-- ----------------------------
DROP TABLE IF EXISTS `Blog`;
CREATE TABLE `Blog` (
                        `id` int NOT NULL AUTO_INCREMENT,
                        `cid` int DEFAULT NULL,
                        `title` varchar(255) DEFAULT NULL,
                        `subtitle` varchar(255) DEFAULT NULL,
                        `content` text,
                        `htmlContent` text,
                        `status` int DEFAULT NULL,
                        `createdDate` datetime DEFAULT NULL,
                        `modifiedDate` datetime DEFAULT NULL,
                        PRIMARY KEY (`id`),
                        KEY `cid` (`cid`),
                        CONSTRAINT `blog_ibfk_1` FOREIGN KEY (`cid`) REFERENCES `Category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of Blog
-- ----------------------------
BEGIN;
INSERT INTO `Blog` VALUES (6, 5, 'Java-01', 'Javaからプログラミングを学びましょう！', '![](http://localhost:8088/img/blog/7cce1aac94764fe58cb120d8239fad2b_field-g6165213c2_1280.jpg)\n\n## 01-Hello World\n#### @alatai\n\n### The First Java Program\n```\n/**\n  * Java class\n  */\npublic class Main {\n  // main method \n  public static void main (String[] args) {\n    // print out sentence\n    System.out.println(\"Hello World!\");\n  }\n}\n```\n\n', '<p><img src=\"http://localhost:8088/img/blog/7cce1aac94764fe58cb120d8239fad2b_field-g6165213c2_1280.jpg\" alt=\"\" /></p>\n<h2>01-Hello World</h2>\n<h4>@alatai</h4>\n<h3>The First Java Program</h3>\n<pre><code>/**\n  * Java class\n  */\npublic class Main {\n  // main method \n  public static void main (String[] args) {\n    // print out sentence\n    System.out.println(&quot;Hello World!&quot;);\n  }\n}\n</code></pre>\n', 1, '2022-02-17 21:59:46', '2022-02-25 14:23:07');
INSERT INTO `Blog` VALUES (23, 5, 'Java-02', 'Javaの変数、型', '![](http://localhost:8088/img/blog/24527c5ff2b0436eb4c5726692293382_nature-gcd5138a67_1280.jpg)\n\n## Javaの変数、型\n#### ＠alatai\n\n### 変数とは\n変数とは、データを格納するための箱のようなものです。この変数を用いて、数字や文字列などの情報を格納したり、取り出したりすることができます。\n\n### 変数の宣言\n```\npublic class JavaTest {\n  public static void main (String[] args) {\n    // 変数の宣言\n    int age;\n    // ageという箱に38を入れる\n    age = 38;\n    // ageの中身を表示\n    System.out.println(age);\n  }\n}\n```', '<p><img src=\"http://localhost:8088/img/blog/24527c5ff2b0436eb4c5726692293382_nature-gcd5138a67_1280.jpg\" alt=\"\" /></p>\n<h2>Javaの変数、型</h2>\n<h4>＠alatai</h4>\n<h3>変数とは</h3>\n<p>変数とは、データを格納するための箱のようなものです。この変数を用いて、数字や文字列などの情報を格納したり、取り出したりすることができます。</p>\n<h3>変数の宣言</h3>\n<pre><code>public class JavaTest {\n  public static void main (String[] args) {\n    // 変数の宣言\n    int age;\n    // ageという箱に38を入れる\n    age = 38;\n    // ageの中身を表示\n    System.out.println(age);\n  }\n}\n</code></pre>\n', 1, '2022-02-25 14:22:42', '2022-02-25 14:25:57');
INSERT INTO `Blog` VALUES (24, 5, 'Java-03', '演算子、条件分岐', '![](http://localhost:8088/img/blog/3574782bb9f042ba87defb05cfd010fc_mountains-g267b7b34d_1280.jpg)\n\n## 演算子、条件分岐\n#### @alatai\n\n### 演算子について\n私達が日常で足し算や引き算を行うように、Javaでも他の言語でも足し算や引き算を行うための記述方法が定義されています。これを「演算子」と言います。\n\n### 繰り返し構文\n#### while文\n```\npublic class JavaTest {\n  public static void main (String[] args) {\n    int i = 0;\n    \n    while (i <= 5) {\n      System.out.println(\"iの中身は\" + i);\n      i++;\n    }\n  }\n}\n```', '<p><img src=\"http://localhost:8088/img/blog/3574782bb9f042ba87defb05cfd010fc_mountains-g267b7b34d_1280.jpg\" alt=\"\" /></p>\n<h2>演算子、条件分岐</h2>\n<h4>@alatai</h4>\n<h3>演算子について</h3>\n<p>私達が日常で足し算や引き算を行うように、Javaでも他の言語でも足し算や引き算を行うための記述方法が定義されています。これを「演算子」と言います。</p>\n<h3>繰り返し構文</h3>\n<h4>while文</h4>\n<pre><code>public class JavaTest {\n  public static void main (String[] args) {\n    int i = 0;\n    \n    while (i &lt;= 5) {\n      System.out.println(&quot;iの中身は&quot; + i);\n      i++;\n    }\n  }\n}\n</code></pre>\n', 1, '2022-02-25 14:32:14', '2022-02-25 14:32:17');
INSERT INTO `Blog` VALUES (25, 4, '雪降ったあとの京都', '昨日雪が降りました。', '![](http://localhost:8088/img/blog/56c6e85c6d154264a88df82ea42ed013_WechatIMG10.jpeg)\n#### 翌日の朝１０ごろ、窓の外はこんな風景です。好きです！\n\n## 雪降ったあとの京都\n#### @alatai\n\n### XXXXX\nXXXXX', '<p><img src=\"http://localhost:8088/img/blog/56c6e85c6d154264a88df82ea42ed013_WechatIMG10.jpeg\" alt=\"\" /></p>\n<h4>翌日の朝１０ごろ、窓の外はこんな風景です。好きです！</h4>\n<h2>雪降ったあとの京都</h2>\n<h4>@alatai</h4>\n<h3>XXXXX</h3>\n<p>XXXXX</p>\n', 1, '2022-02-25 14:45:26', '2022-02-25 14:49:00');
INSERT INTO `Blog` VALUES (26, 4, '京都タワーです！', '京都市の一番高い建物です〜', '![](http://localhost:8088/img/blog/5dd6320cef9a475f8724c7094e516a37_WechatIMG11.jpeg)\n#### 京都市の一番高い建物です。東京に行ったら、スカイツリーへ行ってみたいな\n\n## 京都市の一番高い建物\n#### @alatai\n\n### XXX\nXXXXX', '<p><img src=\"http://localhost:8088/img/blog/5dd6320cef9a475f8724c7094e516a37_WechatIMG11.jpeg\" alt=\"\" /></p>\n<h4>京都市の一番高い建物です。東京に行ったら、スカイツリーへ行ってみたいな</h4>\n<h2>京都市の一番高い建物</h2>\n<h4>@alatai</h4>\n<h3>XXX</h3>\n<p>XXXXX</p>\n', 1, '2022-02-25 15:02:30', '2022-02-25 15:02:35');
COMMIT;

-- ----------------------------
-- Table structure for Category
-- ----------------------------
DROP TABLE IF EXISTS `Category`;
CREATE TABLE `Category` (
                            `id` int NOT NULL AUTO_INCREMENT,
                            `name` varchar(40) DEFAULT NULL,
                            `createdDate` datetime DEFAULT NULL,
                            `modifiedDate` datetime DEFAULT NULL,
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of Category
-- ----------------------------
BEGIN;
INSERT INTO `Category` VALUES (4, '日常', '2022-02-17 17:01:21', '2022-02-25 00:14:56');
INSERT INTO `Category` VALUES (5, 'Java', '2022-02-17 17:01:29', '2022-02-25 15:15:40');
INSERT INTO `Category` VALUES (6, 'データベース', '2022-02-17 17:01:40', NULL);
INSERT INTO `Category` VALUES (7, 'フロントエンド', '2022-02-17 17:02:14', NULL);
INSERT INTO `Category` VALUES (9, 'ネットワーク', '2022-02-17 17:02:37', NULL);
INSERT INTO `Category` VALUES (21, 'ミドルウェア', '2022-02-25 15:14:30', NULL);
INSERT INTO `Category` VALUES (24, 'Python', '2022-02-25 15:15:50', NULL);
INSERT INTO `Category` VALUES (25, 'Linux', '2022-02-25 15:15:58', NULL);
COMMIT;

-- ----------------------------
-- Table structure for Tag
-- ----------------------------
DROP TABLE IF EXISTS `Tag`;
CREATE TABLE `Tag` (
                       `id` int NOT NULL AUTO_INCREMENT,
                       `name` varchar(40) DEFAULT NULL,
                       `createdDate` datetime DEFAULT NULL,
                       `modifiedDate` datetime DEFAULT NULL,
                       PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of Tag
-- ----------------------------
BEGIN;
INSERT INTO `Tag` VALUES (5, 'test0', '2022-02-21 21:57:31', '2022-02-21 21:59:41');
COMMIT;

-- ----------------------------
-- Table structure for User
-- ----------------------------
DROP TABLE IF EXISTS `User`;
CREATE TABLE `User` (
                        `id` int NOT NULL AUTO_INCREMENT,
                        `name` varchar(40) DEFAULT NULL,
                        `password` varchar(40) DEFAULT NULL,
                        `salt` varchar(255) DEFAULT NULL,
                        `createdDate` datetime DEFAULT NULL,
                        `modifiedDate` datetime DEFAULT NULL,
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of User
-- ----------------------------
BEGIN;
INSERT INTO `User` VALUES (1, 'admin', '352ed489e41eddd4dda5284317caab75', 'yEPSu//0Dmr7volzCdsI3g==', '2022-02-14 21:36:16', '2022-02-21 22:45:45');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
