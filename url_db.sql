-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost
-- Généré le : sam. 31 juil. 2021 à 23:48
-- Version du serveur :  10.4.18-MariaDB
-- Version de PHP : 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `url_db`
--

-- --------------------------------------------------------

--
-- Structure de la table `link`
--

CREATE TABLE `link` (
  `id` int(11) NOT NULL,
  `url` varchar(255) DEFAULT NULL,
  `code` varchar(45) DEFAULT NULL,
  `creation_date` date DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  `visit` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `link`
--

INSERT INTO `link` (`id`, `url`, `code`, `creation_date`, `username`, `visit`) VALUES
(2, 'https://app.trueability.com/', 'oHJrDlAiIU', '2021-07-31', 'theMonster237', 42),
(3, 'https://mail.google.com/', 'akb348o2', '2021-07-22', 'gabrielthecode', 1),
(5, 'https://www.youtube.com/watch?v=fK3URy0UiBU', 'FeifCPHoyt', '2021-07-27', 'Teks', 3),
(6, 'https://beginnersbook.com/2013/11/jstl-cout-core-tag/', 'hXfQgXmQzz', '2021-07-27', 'Le Precurseur', 3),
(7, 'https://github.com/gabriel-TheCode', 'MOitsNSiQT', '2021-07-27', '', 1),
(11, 'https://coderanch.com/f/93/Android', 'zvABgDBxEs', '2021-07-31', 'Android Fellow', 0);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `link`
--
ALTER TABLE `link`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `link`
--
ALTER TABLE `link`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
