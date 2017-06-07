CREATE DATABASE /*!32312 IF NOT EXISTS*/ `todo` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE todo;
--
-- 表的结构 ``table_to_do
--
CREATE TABLE IF NOT EXISTS `table_to_do` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `to_do` int(11) NOT NULL,
  `remark` bigint(20) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;


CREATE DATABASE /*!32312 IF NOT EXISTS*/ `demo` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `demo`;
--
-- 表的结构 `table_demo`
--
CREATE TABLE IF NOT EXISTS `table_demo` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `number` int(11) NOT NULL,
  `version` bigint(20) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;
