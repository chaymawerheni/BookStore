-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3308
-- Généré le :  jeu. 19 nov. 2020 à 09:40
-- Version du serveur :  8.0.18
-- Version de PHP :  7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `bookstore`
--

-- --------------------------------------------------------

--
-- Structure de la table `book`
--

DROP TABLE IF EXISTS `book`;
CREATE TABLE IF NOT EXISTS `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(40) NOT NULL,
  `author` varchar(30) NOT NULL,
  `price` varchar(255) NOT NULL,
  `release_date` varchar(10) NOT NULL,
  `couverture` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `book`
--

INSERT INTO `book` (`id`, `title`, `author`, `price`, `release_date`, `couverture`) VALUES
(2, 'Limitless', 'Chayma ', '1000', '10/10/2020', 'C:\\Users\\Lucy\\Desktop\\BookStoreProject\\Couvertures\\Couverture1.jpg'),
(13, 'Springboot', 'Chayma', '10000', '30/30/20', 'C:\\Users\\Lucy\\Desktop\\BookStoreProject\\Couvertures\\Couverture3.jpg'),
(5, 'Labirainte', 'Victore Hugo', '1000', '10/10/2020', 'C:\\Users\\Lucy\\Desktop\\BookStoreProject\\Couvertures\\Couverture4.jpg'),
(6, 'The maze', 'Wicky', '1000', '10/10/2020', 'C:\\Users\\Lucy\\Desktop\\BookStoreProject\\Couvertures\\Couverture5.jpg'),
(7, 'King', 'Youssef ', '1000', '10/10/2020', 'C:\\Users\\Lucy\\Desktop\\BookStoreProject\\Couvertures\\Couverture1.jpg'),
(8, 'Rebellion', 'David', '1000', '10/10/2020', 'C:\\Users\\Lucy\\Desktop\\BookStoreProject\\Couvertures\\Couverture2.jpg'),
(9, 'OCA', 'Mezghich', '1000', '10/10/2020', 'C:\\Users\\Lucy\\Desktop\\BookStoreProject\\Couvertures\\Couverture3.jpg'),
(10, 'SpringBoot', 'Mezghich', '1000', '10/10/2020', 'C:\\Users\\Lucy\\Desktop\\BookStoreProject\\Couvertures\\Couverture4.jpg'),
(12, 'Queen', 'chaima', '1000', '10/10/2020', 'C:\\Users\\Lucy\\Desktop\\BookStoreProject\\Couvertures\\Couverture4.jpg'),
(17, 'Fearless', 'NCS', '1500', '02/05/15', 'Ceci est un chemin');

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

DROP TABLE IF EXISTS `client`;
CREATE TABLE IF NOT EXISTS `client` (
  `idClient` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(20) NOT NULL,
  `prenom` varchar(20) NOT NULL,
  `email` varchar(30) NOT NULL,
  `tel` varchar(10) NOT NULL,
  `adresse` text NOT NULL,
  PRIMARY KEY (`idClient`)
) ENGINE=MyISAM AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`idClient`, `nom`, `prenom`, `email`, `tel`, `adresse`) VALUES
(6, 'Youssef', 'Vermeg', 'youssef@sesame.com', '222222', 'Ennasr 2'),
(5, 'chayma', 'youssef', 'hjhjhjkj', '12365478', 'hhhkhjjkhj'),
(14, 'Youssef', 'Hmidi', 'Test', '20202020', 'test'),
(13, 'Yuo', '', '', '', '');

-- --------------------------------------------------------

--
-- Structure de la table `commande`
--

DROP TABLE IF EXISTS `commande`;
CREATE TABLE IF NOT EXISTS `commande` (
  `idCommande` int(11) NOT NULL AUTO_INCREMENT,
  `date` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `idClient` int(11) NOT NULL,
  `id` int(11) NOT NULL,
  PRIMARY KEY (`idCommande`)
) ENGINE=MyISAM AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `commande`
--

INSERT INTO `commande` (`idCommande`, `date`, `idClient`, `id`) VALUES
(15, '17/23/2020 12:23:19', 6, 7),
(14, '17/23/2020 12:23:19', 6, 3),
(13, '17/23/2020 12:23:19', 6, 2),
(12, '17/57/2020 11:57:58', 5, 5),
(11, '17/57/2020 11:57:58', 5, 13),
(16, '17/23/2020 12:23:19', 6, 8),
(17, '17/24/2020 12:24:49', 5, 2),
(18, '17/24/2020 12:24:49', 5, 13),
(19, '17/24/2020 12:24:49', 5, 7),
(20, '17/10/2020 22:10:11', 12, 3),
(21, '17/10/2020 22:10:11', 12, 5),
(22, '17/10/2020 22:10:11', 12, 7),
(23, '17/10/2020 22:10:11', 12, 10),
(24, '17/58/2020 23:58:32', 13, 3),
(25, '17/58/2020 23:58:32', 13, 13),
(26, '17/58/2020 23:58:32', 13, 7),
(27, '18/12/2020 21:12:41', 14, 3),
(28, '18/12/2020 21:12:41', 14, 5),
(29, '18/12/2020 21:12:41', 14, 6),
(30, '18/12/2020 21:12:41', 14, 7),
(31, '18/12/2020 21:12:41', 14, 8);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
