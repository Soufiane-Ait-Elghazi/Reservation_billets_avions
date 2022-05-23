-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : lun. 12 juil. 2021 à 12:32
-- Version du serveur :  10.4.14-MariaDB
-- Version de PHP : 7.2.34

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `reservationbilletsavions`
--

-- --------------------------------------------------------

--
-- Structure de la table `tadmin`
--

CREATE TABLE `tadmin` (
  `ID_Admin` int(11) NOT NULL,
  `NomAdmin` varchar(30) NOT NULL,
  `PrenomAdmin` varchar(30) NOT NULL,
  `LoginAdmin` varchar(30) DEFAULT NULL,
  `PasswordAdmin` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `tadmin`
--

INSERT INTO `tadmin` (`ID_Admin`, `NomAdmin`, `PrenomAdmin`, `LoginAdmin`, `PasswordAdmin`) VALUES
(1, 'Ait ELghazi', 'Soufiane', 'root1', '123123'),
(2, 'ait hssaine', 'mohamed', 'root2', '123456'),
(3, 'Bendir', 'Mohammed', 'root3', '12341234');

-- --------------------------------------------------------

--
-- Structure de la table `tavion`
--

CREATE TABLE `tavion` (
  `ID_Avion` int(11) NOT NULL,
  `NomAvion` varchar(30) NOT NULL,
  `Autonomie` double NOT NULL,
  `EtatAvion` varchar(30) NOT NULL,
  `CapaciteTotale` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `tavion`
--

INSERT INTO `tavion` (`ID_Avion`, `NomAvion`, `Autonomie`, `EtatAvion`, `CapaciteTotale`) VALUES
(1, 'TAYLALT01', 10000, 'disponible', 400),
(2, 'TAYLALT02', 9000, 'disponible', 280),
(3, 'TAYLALT03', 5000, 'disponible', 200),
(4, 'TAYLALT04', 7000, 'disponible', 500),
(5, 'TAYLALT05', 15000, 'disponible', 460),
(6, 'TAYLALT06', 9000, 'disponible', 350);

-- --------------------------------------------------------

--
-- Structure de la table `tbillet`
--

CREATE TABLE `tbillet` (
  `ID_Billet` int(11) NOT NULL,
  `ID_Reservation` int(11) NOT NULL,
  `Prix` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `tbillet`
--

INSERT INTO `tbillet` (`ID_Billet`, `ID_Reservation`, `Prix`) VALUES
(1, 1, 1257.242),
(2, 2, 2582.487),
(3, 3, 1210.122),
(4, 4, 10065.364);

-- --------------------------------------------------------

--
-- Structure de la table `tcapacite`
--

CREATE TABLE `tcapacite` (
  `ID_Classe` int(11) NOT NULL,
  `ID_Avion` int(11) NOT NULL,
  `nombreCap` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `tcapacite`
--

INSERT INTO `tcapacite` (`ID_Classe`, `ID_Avion`, `nombreCap`) VALUES
(1, 1, 200),
(2, 1, 113),
(3, 1, 79),
(1, 2, 160),
(2, 2, 80),
(3, 2, 40),
(1, 3, 150),
(2, 3, 50),
(3, 3, 0),
(1, 4, 249),
(2, 4, 200),
(3, 4, 50),
(1, 5, 200),
(2, 5, 199),
(3, 5, 60),
(1, 6, 200),
(2, 6, 100),
(3, 6, 50);

-- --------------------------------------------------------

--
-- Structure de la table `tcategorie`
--

CREATE TABLE `tcategorie` (
  `ID_Categorie` int(11) NOT NULL,
  `LibelleCategorie` varchar(30) NOT NULL,
  `RemiseCategorie` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `tcategorie`
--

INSERT INTO `tcategorie` (`ID_Categorie`, `LibelleCategorie`, `RemiseCategorie`) VALUES
(1, 'Junior', 0.4),
(2, 'Senior', 0.25),
(3, 'Vieux', 0.5);

-- --------------------------------------------------------

--
-- Structure de la table `tclasse`
--

CREATE TABLE `tclasse` (
  `ID_Classe` int(11) NOT NULL,
  `NomClasse` varchar(30) NOT NULL,
  `PrixClasseKM` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `tclasse`
--

INSERT INTO `tclasse` (`ID_Classe`, `NomClasse`, `PrixClasseKM`) VALUES
(1, '1ere', 1.28),
(2, 'Economie', 1.5),
(3, 'Affaire', 1.7);

-- --------------------------------------------------------

--
-- Structure de la table `tclient`
--

CREATE TABLE `tclient` (
  `ID_Client` int(11) NOT NULL,
  `NomClient` varchar(30) DEFAULT NULL,
  `PrenomClient` varchar(30) DEFAULT NULL,
  `DateNaissance` varchar(30) DEFAULT NULL,
  `CINClient` varchar(30) DEFAULT NULL,
  `NumPasseport` varchar(30) DEFAULT NULL,
  `LoginClient` varchar(30) DEFAULT NULL,
  `PasswordClient` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `tclient`
--

INSERT INTO `tclient` (`ID_Client`, `NomClient`, `PrenomClient`, `DateNaissance`, `CINClient`, `NumPasseport`, `LoginClient`, `PasswordClient`) VALUES
(1, 'Hna', 'Mustapha', '1999-07-10', 'PA257784', 'M1245781', 'mustapha', '123123'),
(2, 'Mohammed', 'Bendir', '2000-07-12', 'PO564367', 'Z121233', 'mohammed', '1231234'),
(3, 'Ait Elghazi', 'Soufiane', '2000-06-28', 'PA250006', 'J115152', 'soufiane', '123123'),
(4, 'Haddoudi', 'Abdelkarim', '1998-01-28', 'PA326810', 'T115152', 'karim', '123123'),
(5, 'Ait Hssaine', 'Mohamed', '1998-12-02', 'PA200836', 'P115152', 'mohamed', '123123'),
(6, 'Ait aicha', 'Atmane', '1998-12-12', 'PA234356', 'Y114550', 'atmane', '123123'),
(7, 'Khjaji', 'Mohamed', '1997-04-22', 'PA341256', 'K125423', 'Med', '123123'),
(8, 'Alaoui', 'Ahmed', '1999-07-08', 'GT45327', 'UT67543', 'ahmed', '123123'),
(9, 'Bendir', 'Mohammed', '2021-07-09', 'PI87643', 'Z12198', 'Moha@b', '12341234');

-- --------------------------------------------------------

--
-- Structure de la table `treservation`
--

CREATE TABLE `treservation` (
  `ID_Reservation` int(11) NOT NULL,
  `ID_Client` int(11) DEFAULT NULL,
  `ID_Vol` int(11) NOT NULL,
  `VilleDepart` varchar(30) DEFAULT NULL,
  `VilleArrivee` varchar(30) DEFAULT NULL,
  `DateDepart` date NOT NULL,
  `heureDepart` time NOT NULL,
  `ID_Classe` int(10) DEFAULT NULL,
  `DateReservation` date NOT NULL,
  `NomPersonne` varchar(30) NOT NULL,
  `PrenomPersonne` varchar(30) NOT NULL,
  `ID_Categorie` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `treservation`
--

INSERT INTO `treservation` (`ID_Reservation`, `ID_Client`, `ID_Vol`, `VilleDepart`, `VilleArrivee`, `DateDepart`, `heureDepart`, `ID_Classe`, `DateReservation`, `NomPersonne`, `PrenomPersonne`, `ID_Categorie`) VALUES
(1, 1, 4, 'Agadir', 'Madrid', '2021-07-08', '12:45:00', 3, '2021-06-28', 'Hna', 'Mustapha', 1),
(2, 2, 1, 'Rabat', 'London', '2021-06-01', '16:30:00', 3, '2021-07-09', 'Bendir', 'Mohammed', 2),
(3, 2, 6, 'Fes', 'Dakhla', '2021-06-09', '08:10:00', 1, '2021-07-11', 'Ailali', 'Amine', 1),
(4, 5, 11, 'Istanbul', 'Tokyo', '2021-07-01', '09:00:00', 2, '2021-07-11', 'Ait hssaine', 'Mohamed', 2);

-- --------------------------------------------------------

--
-- Structure de la table `ttrajet`
--

CREATE TABLE `ttrajet` (
  `ID_Trajet` int(11) NOT NULL,
  `VilleDepart` varchar(30) DEFAULT NULL,
  `LatitudeVilleDepart` double DEFAULT NULL,
  `LongitudeVilleDepart` double DEFAULT NULL,
  `VilleArrivee` varchar(30) DEFAULT NULL,
  `LatitudeVilleArrivee` double DEFAULT NULL,
  `LongitudeVilleArrivee` double DEFAULT NULL,
  `Distance` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `ttrajet`
--

INSERT INTO `ttrajet` (`ID_Trajet`, `VilleDepart`, `LatitudeVilleDepart`, `LongitudeVilleDepart`, `VilleArrivee`, `LatitudeVilleArrivee`, `LongitudeVilleArrivee`, `Distance`) VALUES
(1, 'Rabat', 33.9715904, -6.8498129, 'London', 51.5073509, -0.1277583, 2025.48),
(2, 'Paris', 48.85341, 2.3488, 'Casablanca', 33.520593, -7.56806, 1894.17),
(3, 'Ouarzazate', 35.759465, -5.833954, 'Amsterdam', 52.370216, 4.895168, 2033.09),
(4, 'Agadir', 30.427755, -9.598107, 'Madrid', 40.415511, -3.707401, 1232.59),
(5, 'Marrakech', 31.63, -8.008889, 'Oujda', 34.686667, -1.911389, 662.01),
(6, 'Fes', 34.03313, -5.00028, 'Dakhla', 23.562461, -15.906171, 1575.68),
(7, 'Casablanca', 33.520593, -7.56806, 'New York', 40.712784, -74.005941, 5810.61),
(8, 'Rabat', 33.9715904, -6.8498129, 'Algerie', 28.033886, 1.659626, 1046.05),
(9, 'Settet', 33.00103, -7.61662, 'Errachidia', 31.9314, -4.42663, 322.33),
(10, 'Bruxelle', 50.85045, 4.34878, 'Laayoune', 25.44359, -13.174035, 3198.52),
(11, 'Istanbul', 41.049022, 29.031372, 'Tokyo', 35.689487, 139.691706, 8946.99),
(12, 'Meknes', 33.895, -5.554722, 'Dubai', 25.0657, 55.17128, 5882.03),
(13, 'Tanger', 35.759465, -5.833954, 'Berlin', 52.520007, 13.404954, 2401.2);

-- --------------------------------------------------------

--
-- Structure de la table `tvol`
--

CREATE TABLE `tvol` (
  `ID_Vol` int(11) NOT NULL,
  `ID_Trajet` int(11) NOT NULL,
  `ID_Avion` int(11) NOT NULL,
  `DateDepart` date NOT NULL,
  `DateArrivee` date NOT NULL,
  `heureDepart` time NOT NULL,
  `heureArrivee` time NOT NULL,
  `Duree` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `tvol`
--

INSERT INTO `tvol` (`ID_Vol`, `ID_Trajet`, `ID_Avion`, `DateDepart`, `DateArrivee`, `heureDepart`, `heureArrivee`, `Duree`) VALUES
(1, 1, 1, '2021-06-01', '2021-06-02', '16:30:00', '01:30:00', '09 h 00 min'),
(2, 2, 2, '2021-06-04', '2021-06-04', '12:45:00', '16:30:00', '03 h 45 min'),
(3, 3, 3, '2021-06-06', '2021-06-06', '19:00:00', '23:30:00', '04 h 30 min'),
(4, 4, 3, '2021-06-10', '2021-06-11', '21:10:00', '00:20:00', '03 h 10 min'),
(5, 5, 4, '2021-06-01', '2021-06-01', '17:15:00', '19:20:00', '02 h 05 min'),
(6, 6, 4, '2021-06-09', '2021-06-09', '08:10:00', '10:40:00', '02 h 30 min'),
(7, 7, 1, '2021-06-07', '2021-06-08', '16:30:00', '00:30:00', '08 h 00 min'),
(8, 8, 2, '2021-07-01', '2021-07-01', '12:45:00', '16:30:00', '03 h 45 min'),
(9, 9, 3, '2021-07-06', '2021-07-06', '18:00:00', '21:00:00', '03 h 00 min'),
(10, 10, 4, '2021-07-03', '2021-07-04', '19:00:00', '00:30:00', '05 h 30 min'),
(11, 11, 5, '2021-07-01', '2021-07-02', '09:00:00', '01:00:00', '16 h 00 min'),
(12, 12, 1, '2021-06-29', '2021-06-29', '08:30:00', '22:40:00', '14 h 10 min'),
(13, 4, 5, '2021-07-18', '2021-07-18', '09:10:00', '12:15:00', '03 h 05 min'),
(14, 13, 1, '2021-07-15', '2021-07-15', '12:10:00', '14:45:00', '02 h 35 min'),
(15, 8, 1, '2021-07-16', '2021-07-16', '08:10:00', '10:05:00', '01 h 55 min');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `tadmin`
--
ALTER TABLE `tadmin`
  ADD PRIMARY KEY (`ID_Admin`),
  ADD UNIQUE KEY `LoginAdmin` (`LoginAdmin`);

--
-- Index pour la table `tavion`
--
ALTER TABLE `tavion`
  ADD PRIMARY KEY (`ID_Avion`);

--
-- Index pour la table `tbillet`
--
ALTER TABLE `tbillet`
  ADD PRIMARY KEY (`ID_Billet`),
  ADD KEY `tbillet_ibfk_1` (`ID_Reservation`);

--
-- Index pour la table `tcapacite`
--
ALTER TABLE `tcapacite`
  ADD KEY `tclasse_ibfk_1` (`ID_Classe`),
  ADD KEY `tavion_ibfk_1` (`ID_Avion`);

--
-- Index pour la table `tcategorie`
--
ALTER TABLE `tcategorie`
  ADD PRIMARY KEY (`ID_Categorie`),
  ADD UNIQUE KEY `LibelleCategorie` (`LibelleCategorie`);

--
-- Index pour la table `tclasse`
--
ALTER TABLE `tclasse`
  ADD PRIMARY KEY (`ID_Classe`);

--
-- Index pour la table `tclient`
--
ALTER TABLE `tclient`
  ADD PRIMARY KEY (`ID_Client`),
  ADD UNIQUE KEY `LoginClient` (`LoginClient`),
  ADD UNIQUE KEY `CINClient` (`CINClient`),
  ADD UNIQUE KEY `NumPasseport` (`NumPasseport`);

--
-- Index pour la table `treservation`
--
ALTER TABLE `treservation`
  ADD PRIMARY KEY (`ID_Reservation`),
  ADD KEY `c` (`ID_Client`),
  ADD KEY `v` (`ID_Vol`),
  ADD KEY `r` (`ID_Categorie`),
  ADD KEY `avh` (`ID_Classe`);

--
-- Index pour la table `ttrajet`
--
ALTER TABLE `ttrajet`
  ADD PRIMARY KEY (`ID_Trajet`);

--
-- Index pour la table `tvol`
--
ALTER TABLE `tvol`
  ADD PRIMARY KEY (`ID_Vol`),
  ADD KEY `av` (`ID_Avion`),
  ADD KEY `tr` (`ID_Trajet`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `tadmin`
--
ALTER TABLE `tadmin`
  MODIFY `ID_Admin` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT pour la table `tavion`
--
ALTER TABLE `tavion`
  MODIFY `ID_Avion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT pour la table `tbillet`
--
ALTER TABLE `tbillet`
  MODIFY `ID_Billet` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=61;

--
-- AUTO_INCREMENT pour la table `tcategorie`
--
ALTER TABLE `tcategorie`
  MODIFY `ID_Categorie` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `tclasse`
--
ALTER TABLE `tclasse`
  MODIFY `ID_Classe` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `tclient`
--
ALTER TABLE `tclient`
  MODIFY `ID_Client` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=54;

--
-- AUTO_INCREMENT pour la table `treservation`
--
ALTER TABLE `treservation`
  MODIFY `ID_Reservation` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=74;

--
-- AUTO_INCREMENT pour la table `ttrajet`
--
ALTER TABLE `ttrajet`
  MODIFY `ID_Trajet` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT pour la table `tvol`
--
ALTER TABLE `tvol`
  MODIFY `ID_Vol` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `tbillet`
--
ALTER TABLE `tbillet`
  ADD CONSTRAINT `tbillet_ibfk_1` FOREIGN KEY (`ID_Reservation`) REFERENCES `treservation` (`ID_Reservation`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `tcapacite`
--
ALTER TABLE `tcapacite`
  ADD CONSTRAINT `a` FOREIGN KEY (`ID_Avion`) REFERENCES `tavion` (`ID_Avion`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `cl` FOREIGN KEY (`ID_Classe`) REFERENCES `tclasse` (`ID_Classe`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `treservation`
--
ALTER TABLE `treservation`
  ADD CONSTRAINT `avh` FOREIGN KEY (`ID_Classe`) REFERENCES `tclasse` (`ID_Classe`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `c` FOREIGN KEY (`ID_Client`) REFERENCES `tclient` (`ID_Client`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `r` FOREIGN KEY (`ID_Categorie`) REFERENCES `tcategorie` (`ID_Categorie`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `v` FOREIGN KEY (`ID_Vol`) REFERENCES `tvol` (`ID_Vol`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `tvol`
--
ALTER TABLE `tvol`
  ADD CONSTRAINT `av` FOREIGN KEY (`ID_Avion`) REFERENCES `tavion` (`ID_Avion`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tr` FOREIGN KEY (`ID_Trajet`) REFERENCES `ttrajet` (`ID_Trajet`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
