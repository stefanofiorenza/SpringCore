-- USEGO

SET FOREIGN_KEY_CHECKS=0;
-- GO


--
-- Table: cd
--
CREATE TABLE `cd` 
(
	`id` bigint (20) NOT NULL, 
	`Artist` varchar (255), 
	`Company` varchar (255), 
	`Price` decimal (13,2), 
	`Title` varchar (255), 
	`Country` varchar (255), 
	`Year` integer (11), 
	`Quantity` integer (11), 
	`Version` bigint (50) NOT NULL,
	PRIMARY KEY (`id`)
); 


BEGIN;
INSERT INTO `cd` (`id`, `Artist`, `Company`, `Price`, `Title`, `Country`, `Year`, `Quantity`, `Version`) VALUES(1, 'Bob Dylan', 'Columbia', 10.90, 'Empire Burlesque', 'USA', 1968, 2, 0);
INSERT INTO `cd` (`id`, `Artist`, `Company`, `Price`, `Title`, `Country`, `Year`, `Quantity`, `Version`) VALUES(2, 'Bonnie Tyler', 'CBS Records', 9.90, 'Hide your heart', 'UK', 1982, 3, 0);
INSERT INTO `cd` (`id`, `Artist`, `Company`, `Price`, `Title`, `Country`, `Year`, `Quantity`, `Version`) VALUES(3, 'Dolly Parton', 'RCA', 9.90, 'Greatest Hits', 'USA', 1988, 34, 4);
INSERT INTO `cd` (`id`, `Artist`, `Company`, `Price`, `Title`, `Country`, `Year`, `Quantity`, `Version`) VALUES(4, 'Gary Moore', 'Virgin records', 10.20, 'Still got the blues', 'UK', 1990, 3, 0);
-- GO
INSERT INTO `cd` (`id`, `Artist`, `Company`, `Price`, `Title`, `Country`, `Year`, `Quantity`, `Version`) VALUES(5, 'Eros Ramazzotti', 'BMG', 9.90, 'Eros', 'EU', 1997, 4, 0);
-- GO
INSERT INTO `cd` (`id`, `Artist`, `Company`, `Price`, `Title`, `Country`, `Year`, `Quantity`, `Version`) VALUES(6, 'Bee Gees', 'Polydor', 10.90, 'One night only', 'UK', 1977, 5, 0);
-- GO
INSERT INTO `cd` (`id`, `Artist`, `Company`, `Price`, `Title`, `Country`, `Year`, `Quantity`, `Version`) VALUES(7, 'Dr.Hook', 'CBS', 8.20, 'Sylvias Mother', 'UK', 1973, 3, 0);
-- GO
INSERT INTO `cd` (`id`, `Artist`, `Company`, `Price`, `Title`, `Country`, `Year`, `Quantity`, `Version`) VALUES(8, 'Rod Stewart', 'Pickwick', 8.50, 'Maggie May', 'UK', 1990, 4, 0);
-- GO
INSERT INTO `cd` (`id`, `Artist`, `Company`, `Price`, `Title`, `Country`, `Year`, `Quantity`, `Version`) VALUES(9, 'Andrea Bocelli', 'Polydor', 10.80, 'Romanza', 'EU', 1996, 3, 0);
-- GO
INSERT INTO `cd` (`id`, `Artist`, `Company`, `Price`, `Title`, `Country`, `Year`, `Quantity`, `Version`) VALUES(10, 'Percy Sledge', 'Atlantic', 8.70, 'When a man loves a woman', 'USA', 1987, 2, 0);
-- GO
INSERT INTO `cd` (`id`, `Artist`, `Company`, `Price`, `Title`, `Country`, `Year`, `Quantity`, `Version`) VALUES(11, 'Savage Rose', 'Mega', 10.90, 'Black angel', 'EU', 1995, 3, 0);
-- GO
INSERT INTO `cd` (`id`, `Artist`, `Company`, `Price`, `Title`, `Country`, `Year`, `Quantity`, `Version`) VALUES(12, 'Many', 'Grammy', 10.20, '1999 Grammy Nominees', 'USA', 1999, 4, 0);
-- GO
INSERT INTO `cd` (`id`, `Artist`, `Company`, `Price`, `Title`, `Country`, `Year`, `Quantity`, `Version`) VALUES(13, 'Kenny Rogers', 'Mucik Master', 8.70, 'For the good times', 'UK', 1995, 5, 0);
-- GO
INSERT INTO `cd` (`id`, `Artist`, `Company`, `Price`, `Title`, `Country`, `Year`, `Quantity`, `Version`) VALUES(14, 'Will Smith', 'Columbia', 9.90, 'Big Willie style', 'USA', 1997, 3, 0);
-- GO
INSERT INTO `cd` (`id`, `Artist`, `Company`, `Price`, `Title`, `Country`, `Year`, `Quantity`, `Version`) VALUES(15, 'Van Morrison', 'Polydor', 8.20, 'Tupelo Honey', 'UK', 1971, 4, 0);
-- GO
INSERT INTO `cd` (`id`, `Artist`, `Company`, `Price`, `Title`, `Country`, `Year`, `Quantity`, `Version`) VALUES(16, 'Jorn Hoel', 'WEA', 7.90, 'Soulsville', 'Norway', 1996, 5, 0);
-- GO
INSERT INTO `cd` (`id`, `Artist`, `Company`, `Price`, `Title`, `Country`, `Year`, `Quantity`, `Version`) VALUES(17, 'Cat Stevens', 'Island', 8.90, 'The very best of', 'UK', 1990, 3, 0);
-- GO
INSERT INTO `cd` (`id`, `Artist`, `Company`, `Price`, `Title`, `Country`, `Year`, `Quantity`, `Version`) VALUES(18, 'Sam Brown', 'A and M', 8.90, 'Stop', 'UK', 1988, 4, 0);
-- GO
INSERT INTO `cd` (`id`, `Artist`, `Company`, `Price`, `Title`, `Country`, `Year`, `Quantity`, `Version`) VALUES(19, 'T Pau', 'Siren', 7.90, 'Bridge OF Spies', 'UK', 1987, 3, 0);
-- GO
INSERT INTO `cd` (`id`, `Artist`, `Company`, `Price`, `Title`, `Country`, `Year`, `Quantity`, `Version`) VALUES(20, 'Tina Turner', 'Capitol', 8.90, 'Private Dancer', 'UK', 1983, 2, 0);
-- GO
INSERT INTO `cd` (`id`, `Artist`, `Company`, `Price`, `Title`, `Country`, `Year`, `Quantity`, `Version`) VALUES(21, 'Kim Larsen', 'Medley', 7.80, 'Midt om natten', 'EU', 1983, 3, 0);
-- GO
INSERT INTO `cd` (`id`, `Artist`, `Company`, `Price`, `Title`, `Country`, `Year`, `Quantity`, `Version`) VALUES(22, 'Luciano Pavarotti', 'DECCA', 9.90, 'Pavarotti Gala Concert', 'UK', 1991, 4, 0);
-- GO
INSERT INTO `cd` (`id`, `Artist`, `Company`, `Price`, `Title`, `Country`, `Year`, `Quantity`, `Version`) VALUES(23, 'Otis Redding', 'Atlantic', 7.90, 'The dock of the bay', 'USA', 1987, 3, 0);
-- GO
INSERT INTO `cd` (`id`, `Artist`, `Company`, `Price`, `Title`, `Country`, `Year`, `Quantity`, `Version`) VALUES(24, 'Simply Red', 'Elektra', 7.20, 'Picture book', 'EU', 1985, 3, 0);
-- GO
INSERT INTO `cd` (`id`, `Artist`, `Company`, `Price`, `Title`, `Country`, `Year`, `Quantity`, `Version`) VALUES(25, 'The Communards', 'London', 7.80, 'Red', 'UK', 1987, 2, 0);
-- GO
INSERT INTO `cd` (`id`, `Artist`, `Company`, `Price`, `Title`, `Country`, `Year`, `Quantity`, `Version`) VALUES(26, 'Joe Cocker', 'EMI', 8.20, 'Unchain my heart', 'USA', 1987, 1, 0);
-- GO
INSERT INTO `cd` (`id`, `Artist`, `Company`, `Price`, `Title`, `Country`, `Year`, `Quantity`, `Version`) VALUES(27, 'The Cure', 'Fiction', 20.34, 'Disintegration', 'UK', 1989, 0, 0);
-- GO
INSERT INTO `cd` (`id`, `Artist`, `Company`, `Price`, `Title`, `Country`, `Year`, `Quantity`, `Version`) VALUES(28, 'Bob Dylan', 'RCA', 13.20, 'Empire Burlesque', 'USA', 1966, 12, 0);
-- GO
INSERT INTO `cd` (`id`, `Artist`, `Company`, `Price`, `Title`, `Country`, `Year`, `Quantity`, `Version`) VALUES(58, 'Radiohead', 'RCA', 20.00, 'The Bends', 'UK', 1998, 12, 0);
-- GO
INSERT INTO `cd` (`id`, `Artist`, `Company`, `Price`, `Title`, `Country`, `Year`, `Quantity`, `Version`) VALUES(59, 'Dr.Hook2', 'CBS', 8.20, 'Sylvias Mother', 'UK', 1973, 3, 0);
-- GO
INSERT INTO `cd` (`id`, `Artist`, `Company`, `Price`, `Title`, `Country`, `Year`, `Quantity`, `Version`) VALUES(60, 'Rod Stewart2', 'Pickwick', 8.50, 'Maggie May', 'UK', 1990, 4, 0);
-- GO
INSERT INTO `cd` (`id`, `Artist`, `Company`, `Price`, `Title`, `Country`, `Year`, `Quantity`, `Version`) VALUES(61, 'Rod Stewart', 'Pickwick', 8.50, 'Maggie May', 'UK', 1990, 4, 0);
-- GO
COMMIT;
-- GO

--
-- Dumping Table Foreign Keys
--

--
-- Dumping Triggers
--
SET FOREIGN_KEY_CHECKS=1;
-- GO

