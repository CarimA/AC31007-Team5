-
-- Drop tables if they already exist
--
DROP TABLE IF EXISTS `Person`;
DROP TABLE IF EXISTS `Quiz`;
 DROP TABLE IF EXISTS `Question`;
 DROP TABLE IF EXISTS `Answer`;
 DROP TABLE IF EXISTS `Results`;
DROP TABLE IF EXISTS `Result_Answer`;
-- 

-- --------------------------------------------------------

--
-- Table structure for table `person`
--

CREATE TABLE IF NOT EXISTS `Person` (
  `pId` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(255)  NULL,
  `Password` varchar(255)  NULL,
  `Email` varchar(255) NULL,
  `Position` varchar(255) NULL,
  `salt` varchar(255) NULL,
  PRIMARY KEY (`pId`)
)  ;

--
-- Dumping data for table `Person`
--

INSERT INTO `Person` (`pId`, `Name`, `Password`, `Email`, `Position`, `salt`) VALUES
('1', 'admin', 'password','admin@gmail.com','staff','');

-- --------------------------------------------------------

--
-- Table structure for table `Quiz`
--

CREATE TABLE IF NOT EXISTS `Quiz` (
  `qId` int(11) NOT NULL AUTO_INCREMENT,
  `Title` varchar(255)  NULL,
  `Module` varchar(255) NULL,
  `DateCreated` date DEFAULT NULL,
  `Available` tinyint(3) NULL,
  PRIMARY KEY (`qId`)
) ;

--
-- Dumping data for table `Quiz`
--

INSERT INTO `Quiz` (`qId`, `Title`, `Module`, `DateCreated`, `Available`) VALUES
('1', 'testing quiz', 'AC32007', '2017-02-15', '1');


-- --------------------------------------------------------

--
-- Table structure for table `Question`
--

CREATE TABLE IF NOT EXISTS `Question` (
  `qId` int(11) NOT NULL AUTO_INCREMENT,
  `Number` int(11) NULL,
  `Question` varchar(4096) NULL,
  `image` BLOB NULL,
  `points` int(11) NULL,
  PRIMARY KEY (`qId`)
) ;

--
-- Dumping data for table `Question`
--

INSERT INTO `Question` (`qId`, `Number`, `Question`, `image`,`points`) VALUES
(1, '01', 'testQuestion','','23');


-- --------------------------------------------------------

--
-- Table structure for table `Answer`
--

CREATE TABLE IF NOT EXISTS `Answer` (
  `aId` int(11) NOT NULL AUTO_INCREMENT,
  `Number` int(11) NULL,
  `Explanation` varchar (256) NULL,
  `Right` tinyint(3) NULL,
  PRIMARY KEY (`aId`)
) ;

--
-- Dumping data for table `Answer`
--

INSERT INTO `Answer` (`aId`, `Number`,`Explanation`,`Right`) VALUES
('1', 01,'test explanation','1');

-- --------------------------------------------------------

--
-- Table structure for table `Results`
--

CREATE TABLE IF NOT EXISTS `Results` (
  `rId` int(11) NOT NULL AUTO_INCREMENT,
  `Score` int(11) NULL,
  `Date` date DEFAULT NULL,
  PRIMARY KEY (`rId`)
) ;

--
-- Dumping data for table `Results`
--
INSERT INTO `Results` (`rId`, `Score`, `Date`) VALUES
(1, 21, '2017-02-15');

-- --------------------------------------------------------



