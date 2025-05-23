-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 23, 2025 at 11:20 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `novi_pocetak`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_kreiraj_psihoterapeuta` (IN `p_ime` VARCHAR(50), IN `p_prezime` VARCHAR(50), IN `p_email` VARCHAR(100), IN `p_telefon` VARCHAR(30), IN `p_jmbg` CHAR(13), IN `p_lozinka` CHAR(64), IN `p_datum_rodjenja` DATE, IN `p_prebivaliste` VARCHAR(100), IN `p_stepen_id` INT, IN `p_fakultet_id` INT, IN `p_centar_id` INT, IN `p_status_id` INT, IN `p_is_psiholog` TINYINT(1), IN `p_is_supervizor` TINYINT(1), OUT `p_novi_id` INT)  MODIFIES SQL DATA BEGIN
    INSERT INTO psihoterapeut (
        ime, prezime, email, telefon, jmbg, lozinka,
        datum_rodjenja, prebivaliste,
        stepen_id, fakultet_id, centar_id, status_id,
        is_psiholog, is_supervizor
    )
    VALUES (
        p_ime, p_prezime, p_email, p_telefon, p_jmbg, p_lozinka,
        p_datum_rodjenja, p_prebivaliste,
        p_stepen_id, p_fakultet_id, p_centar_id, p_status_id,
        p_is_psiholog, p_is_supervizor
    );

    SET p_novi_id = LAST_INSERT_ID();
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `centarzaobuku`
--

CREATE TABLE `centarzaobuku` (
  `centar_id` int(11) NOT NULL,
  `naziv` varchar(20) NOT NULL,
  `email` varchar(40) NOT NULL,
  `telefon` varchar(15) NOT NULL,
  `ulica` varchar(40) NOT NULL,
  `broj` int(11) NOT NULL,
  `posting` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `centarzaobuku`
--

INSERT INTO `centarzaobuku` (`centar_id`, `naziv`, `email`, `telefon`, `ulica`, `broj`, `posting`) VALUES
(1, 'Centar Genesis', 'genesis@centar.rs', '0112456781', 'Kralja Petra', 12, 'Stari Grad'),
(2, 'Centar Harmonia', 'harmonia@centar.rs', '0112456782', 'Bulevar Oslobođenja', 46, 'Voždovac'),
(3, 'Centar Optimus', 'optimus@centar.rs', '0112456783', 'Cara Dušana', 88, 'Zemun'),
(4, 'Centar Aurora', 'aurora@centar.rs', '0112456784', 'Takovska', 33, 'Palilula'),
(5, 'Centar Equilibrium', 'equilibrium@centar.rs', '0112456785', 'Narodnog fronta', 17, 'Novi Beograd'),
(6, 'Centar Insight', 'insight@centar.rs', '0112456786', 'Vojvode Stepe', 187, 'Voždovac'),
(7, 'Centar Balance', 'balance@centar.rs', '0112456787', 'Gospodar Jevremova', 23, 'Dorćol'),
(8, 'Centar Veritas', 'veritas@centar.rs', '0112456788', 'Požeška', 70, 'Čukarica'),
(9, 'Centar Tranquilo', 'tranquilo@centar.rs', '0112456789', 'Omladinskih brigada', 121, 'Novi Beograd'),
(10, 'Centar Solaris', 'solaris@centar.rs', '0112456790', 'Njegoševa', 59, 'Vračar');

-- --------------------------------------------------------

--
-- Table structure for table `dan`
--

CREATE TABLE `dan` (
  `dan_id` int(11) NOT NULL,
  `naziv` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `dan`
--

INSERT INTO `dan` (`dan_id`, `naziv`) VALUES
(1, 'Ponedeljak'),
(2, 'Utorak'),
(3, 'Sreda'),
(4, 'Četvrtak'),
(5, 'Petak'),
(6, 'Subota'),
(7, 'Nedelja');

-- --------------------------------------------------------

--
-- Table structure for table `fakultet`
--

CREATE TABLE `fakultet` (
  `fakultet_id` int(11) NOT NULL,
  `naziv` varchar(50) NOT NULL,
  `univerzitet_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `fakultet`
--

INSERT INTO `fakultet` (`fakultet_id`, `naziv`, `univerzitet_id`) VALUES
(1, 'Fakultet psihologije', 1),
(2, 'Fakultet za primenjenu psihologiju', 1),
(3, 'Fakultet humanističkih nauka', 2),
(4, 'Fakultet filozofije', 1),
(5, 'Fakultet medicinske psihologije', 3),
(6, 'Filozofski fakultet Novi Sad', 2),
(7, 'Pedagoški fakultet', 2),
(8, 'Fakultet socijalnog rada', 1),
(9, 'Fakultet psihoterapije', 3),
(10, 'Fakultet humanističkih studija', 3);

-- --------------------------------------------------------

--
-- Table structure for table `fakultetoblast`
--

CREATE TABLE `fakultetoblast` (
  `fakultet_id` int(11) NOT NULL,
  `oblast_f_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `fakultetoblast`
--

INSERT INTO `fakultetoblast` (`fakultet_id`, `oblast_f_id`) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 1),
(5, 5),
(6, 4),
(7, 2),
(8, 3),
(9, 1),
(10, 4);

-- --------------------------------------------------------

--
-- Table structure for table `kandidat`
--

CREATE TABLE `kandidat` (
  `kandidat_id` int(11) NOT NULL,
  `ime` varchar(15) NOT NULL,
  `prezime` varchar(15) NOT NULL,
  `JMBG` char(13) NOT NULL,
  `datum_rodjenja` date NOT NULL,
  `prebivaliste` varchar(20) NOT NULL,
  `telefon` varchar(20) NOT NULL,
  `email` varchar(40) NOT NULL,
  `stepen_id` int(11) NOT NULL,
  `fakultet_id` int(11) NOT NULL,
  `centar_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `kandidat`
--

INSERT INTO `kandidat` (`kandidat_id`, `ime`, `prezime`, `JMBG`, `datum_rodjenja`, `prebivaliste`, `telefon`, `email`, `stepen_id`, `fakultet_id`, `centar_id`) VALUES
(1, 'Nikola', 'Petrović', '9812150710023', '1998-12-15', 'Beograd', '0651112223', 'npetrovic@gmail.com', 2, 4, 1),
(2, 'Ana', 'Jelić', '9704050711024', '1997-04-05', 'Novi Sad', '0642223334', 'ajelic@gmail.com', 1, 5, 2),
(3, 'Milan', 'Gajić', '9907030712025', '1999-07-03', 'Kragujevac', '0633334445', 'mgajic@gmail.com', 2, 6, 3),
(4, 'Ivana', 'Popović', '0001014713026', '2000-01-01', 'Niš', '0624445556', 'ipopovic@gmail.com', 1, 7, 4),
(5, 'Petra', 'Stević', '9810314714027', '1998-10-31', 'Subotica', '0615556667', 'pstevic@gmail.com', 3, 8, 5),
(6, 'Aleksandar', 'Vidić', '9702144715028', '1997-02-14', 'Čačak', '0606667778', 'avidic@gmail.com', 2, 9, 6),
(7, 'Tijana', 'Radovanović', '9606224716029', '1996-06-22', 'Beograd', '0697778889', 'trado@gmail.com', 2, 4, 7),
(8, 'Marko', 'Živković', '9512154717030', '1995-12-15', 'Zaječar', '0688889990', 'mzivkovic@gmail.com', 1, 5, 8),
(9, 'Sara', 'Stojić', '9904034718031', '1999-04-03', 'Beograd', '0679990001', 'sstojic@gmail.com', 1, 6, 9),
(10, 'Luka', 'Knežević', '9811184719032', '1998-11-18', 'Valjevo', '0660001112', 'lknezevic@gmail.com', 2, 7, 10);

-- --------------------------------------------------------

--
-- Table structure for table `klijent`
--

CREATE TABLE `klijent` (
  `klijent_id` int(11) NOT NULL,
  `ime` varchar(15) NOT NULL,
  `prezime` varchar(20) NOT NULL,
  `datum_rodjenja` date NOT NULL,
  `pol_id` int(11) NOT NULL,
  `email` varchar(40) NOT NULL,
  `telefon` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `klijent`
--

INSERT INTO `klijent` (`klijent_id`, `ime`, `prezime`, `datum_rodjenja`, `pol_id`, `email`, `telefon`) VALUES
(1, 'Jelena', 'Milinković', '1995-06-15', 2, 'jmilinkovic@gmail.com', '0695287737'),
(2, 'Stefan', 'Jovanović', '1990-11-30', 1, 'sjovanovic@gmail.com', '0668765432'),
(3, 'Milica', 'Stanković', '1985-09-05', 2, 'milica.s@gmail.com', '0677654321'),
(4, 'Petar', 'Milošević', '2000-12-06', 1, 'pmilosevic@gmail.com', '0695119820'),
(5, 'Dragan', 'Aksentijević', '2004-11-05', 1, 'daksentijevic@gmail.com', '0612560681'),
(6, 'Vera', 'Sremčević', '1990-09-05', 2, 'vsremcevic@gmail.com', '0622834749'),
(7, 'Mirjana', 'Golubović', '1995-06-15', 2, 'mgolubovic@gmail.com', '0659876543'),
(8, 'Lazar', 'Sretenović', '1990-11-30', 1, 'lsretenovic@gmail.com', '0668765432'),
(9, 'Gavrilo', 'Milošević', '1985-09-05', 1, 'gmilosevic@gmail.com', '0628742759'),
(10, 'Petar', 'Petrović', '1990-01-12', 1, 'ppetrovic@gmail.com', '061111111');

-- --------------------------------------------------------

--
-- Table structure for table `kurs`
--

CREATE TABLE `kurs` (
  `kurs_id` int(11) NOT NULL,
  `valuta_id` int(11) NOT NULL,
  `datum_promene` date NOT NULL,
  `konverzija` decimal(10,5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `kurs`
--

INSERT INTO `kurs` (`kurs_id`, `valuta_id`, `datum_promene`, `konverzija`) VALUES
(1, 1, '2024-01-01', 1.00000),
(2, 2, '2024-01-01', 117.20000),
(3, 3, '2024-01-01', 123.45000),
(4, 2, '2024-02-01', 117.35000),
(5, 3, '2024-02-01', 108.25000),
(6, 2, '2024-03-01', 117.50000),
(7, 3, '2024-03-01', 110.00000),
(8, 2, '2024-04-01', 117.70000),
(9, 3, '2024-04-01', 111.20000),
(10, 2, '2024-05-01', 118.05000);

-- --------------------------------------------------------

--
-- Table structure for table `objavljivanjepodataka`
--

CREATE TABLE `objavljivanjepodataka` (
  `objavljivanje_id` int(11) NOT NULL,
  `seansa_id` int(11) NOT NULL,
  `datum_objavljivanja` date NOT NULL,
  `kome_objavljeno` varchar(100) NOT NULL,
  `razlog_id` int(11) NOT NULL,
  `zakonska_osnova` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `objavljivanjepodataka`
--

INSERT INTO `objavljivanjepodataka` (`objavljivanje_id`, `seansa_id`, `datum_objavljivanja`, `kome_objavljeno`, `razlog_id`, `zakonska_osnova`) VALUES
(1, 11, '2025-05-12', 'Supervizor', 3, NULL),
(2, 12, '2025-05-13', 'Supervizor', 3, NULL),
(3, 13, '2025-05-14', 'Supervizor', 3, NULL),
(4, 14, '2025-05-15', 'Supervizor', 3, NULL),
(5, 15, '2025-05-16', 'Supervizor', 3, NULL),
(6, 16, '2025-05-17', 'Supervizor', 3, NULL),
(7, 17, '2025-05-18', 'Supervizor', 3, NULL),
(8, 18, '2025-05-19', 'Supervizor', 3, NULL),
(9, 19, '2025-05-20', 'Supervizor', 3, NULL),
(10, 20, '2025-05-21', 'Supervizor', 3, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `oblastfakulteta`
--

CREATE TABLE `oblastfakulteta` (
  `oblast_f_id` int(11) NOT NULL,
  `naziv` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `oblastfakulteta`
--

INSERT INTO `oblastfakulteta` (`oblast_f_id`, `naziv`) VALUES
(1, 'Psihologija'),
(2, 'Pedagogija'),
(3, 'Socijalni rad'),
(4, 'Filozofija'),
(5, 'Medicinska psihologija');

-- --------------------------------------------------------

--
-- Table structure for table `oblastpsihoterapije`
--

CREATE TABLE `oblastpsihoterapije` (
  `oblast_ps_id` int(11) NOT NULL,
  `naziv` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `oblastpsihoterapije`
--

INSERT INTO `oblastpsihoterapije` (`oblast_ps_id`, `naziv`) VALUES
(1, 'Kognitivno-bihevioralna terapi'),
(2, 'ACT'),
(3, 'Humanistička terapija'),
(4, 'Geštalt terapija'),
(5, 'Porodična terapija'),
(6, 'Sistemska terapija'),
(7, 'Psihodinamska terapija'),
(8, 'Mindfulness terapija'),
(9, 'Eksperimentalna terapija'),
(10, 'Somatska terapija');

-- --------------------------------------------------------

--
-- Table structure for table `oblasttesta`
--

CREATE TABLE `oblasttesta` (
  `oblast_testa_id` int(11) NOT NULL,
  `naziv` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `oblasttesta`
--

INSERT INTO `oblasttesta` (`oblast_testa_id`, `naziv`) VALUES
(1, 'Ličnost'),
(2, 'Stres'),
(3, 'Anksioznost'),
(4, 'Depresija'),
(5, 'IQ'),
(6, 'Skala samopoštovanja (RSE)'),
(7, 'Upitnik ličnosti za adolescent'),
(8, 'Inventar emocionalne regulacij'),
(9, 'Test pažnje i koncentracije'),
(10, 'Skala socijalne anksioznosti ');

-- --------------------------------------------------------

--
-- Table structure for table `placanje`
--

CREATE TABLE `placanje` (
  `placanje_id` int(11) NOT NULL,
  `klijent_id` int(11) NOT NULL,
  `seansa_id` int(11) NOT NULL,
  `svrha_placanja` varchar(20) NOT NULL,
  `rata` int(11) NOT NULL,
  `nacin_placanja` varchar(10) NOT NULL,
  `uplaceni_iznos` decimal(8,2) NOT NULL,
  `valuta_id` int(11) NOT NULL,
  `provizija` decimal(5,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `placanje`
--

INSERT INTO `placanje` (`placanje_id`, `klijent_id`, `seansa_id`, `svrha_placanja`, `rata`, `nacin_placanja`, `uplaceni_iznos`, `valuta_id`, `provizija`) VALUES
(1, 1, 1, 'Seansa', 1, 'gotovina', 4500.00, 1, 0.00),
(2, 2, 2, 'Seansa', 1, 'kartica', 4500.00, 2, 0.00),
(3, 3, 3, 'Seansa', 1, 'gotovina', 4500.00, 1, 0.00),
(4, 4, 4, 'Seansa', 1, 'kartica', 4500.00, 2, 0.00),
(5, 5, 5, 'Seansa', 1, 'kartica', 38.00, 2, 0.00),
(6, 6, 6, 'Seansa', 1, 'gotovina', 4500.00, 1, 0.00),
(7, 7, 7, 'Seansa', 1, 'gotovina', 4500.00, 1, 0.00),
(8, 8, 8, 'Seansa', 1, 'kartica', 4500.00, 1, 0.00),
(9, 9, 9, 'Seansa', 1, 'gotovina', 4500.00, 1, 0.00),
(10, 10, 10, 'Seansa', 1, 'kartica', 38.00, 2, 0.00),
(11, 1, 11, 'Seansa', 1, 'gotovina', 4500.00, 1, 0.00),
(12, 2, 12, 'Seansa', 1, 'kartica', 4500.00, 1, 0.00),
(13, 3, 13, 'Seansa', 1, 'gotovina', 4500.00, 1, 0.00),
(14, 4, 14, 'Seansa', 1, 'gotovina', 4500.00, 1, 0.00),
(15, 5, 15, 'Seansa', 1, 'kartica', 38.00, 2, 0.00),
(16, 6, 16, 'Seansa', 1, 'gotovina', 4500.00, 1, 0.00),
(17, 7, 17, 'Seansa', 1, 'kartica', 4500.00, 1, 0.00),
(18, 8, 18, 'Seansa', 1, 'gotovina', 4500.00, 1, 0.00),
(19, 9, 19, 'Seansa', 1, 'gotovina', 4500.00, 1, 0.00),
(20, 10, 20, 'Seansa', 1, 'kartica', 38.00, 2, 0.00);

-- --------------------------------------------------------

--
-- Table structure for table `pol`
--

CREATE TABLE `pol` (
  `pol_id` int(11) NOT NULL,
  `naziv` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pol`
--

INSERT INTO `pol` (`pol_id`, `naziv`) VALUES
(1, 'Muški'),
(2, 'Ženski'),
(3, 'Drugi');

-- --------------------------------------------------------

--
-- Table structure for table `prijava`
--

CREATE TABLE `prijava` (
  `prijava_id` int(11) NOT NULL,
  `klijent_id` int(11) NOT NULL,
  `psihoterapeut_id` int(11) NOT NULL,
  `isao_ranije` tinyint(1) NOT NULL,
  `problem` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `prijava`
--

INSERT INTO `prijava` (`prijava_id`, `klijent_id`, `psihoterapeut_id`, `isao_ranije`, `problem`) VALUES
(1, 1, 1, 0, 'Stres na poslu'),
(2, 2, 2, 1, 'Anksioznost u ispitnim rokovima'),
(3, 3, 3, 0, 'Nisko samopouzdanje'),
(4, 4, 4, 0, 'Porodični konflikti'),
(5, 5, 5, 1, 'Problemi sa pažnjom'),
(6, 6, 6, 0, 'Depresivne epizode'),
(7, 7, 7, 1, 'Fobije'),
(8, 8, 8, 0, 'Problemi u vezi'),
(9, 9, 9, 0, 'Socijalna anksioznost'),
(10, 10, 10, 0, 'Stres zbog posla u IT sektoru');

-- --------------------------------------------------------

--
-- Table structure for table `promenaceneseanse`
--

CREATE TABLE `promenaceneseanse` (
  `cena_id` int(11) NOT NULL,
  `seansa_id` int(11) NOT NULL,
  `datum_promene` date NOT NULL,
  `nova_cena` decimal(7,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `promenaceneseanse`
--

INSERT INTO `promenaceneseanse` (`cena_id`, `seansa_id`, `datum_promene`, `nova_cena`) VALUES
(1, 1, '2025-04-01', 4500.00),
(2, 2, '2025-04-01', 4500.00),
(3, 3, '2025-04-01', 4500.00),
(4, 4, '2025-04-01', 4500.00),
(5, 5, '2025-04-01', 4500.00),
(6, 6, '2025-04-01', 4500.00),
(7, 7, '2025-04-01', 4500.00),
(8, 8, '2025-04-01', 4500.00),
(9, 9, '2025-04-01', 4500.00),
(10, 10, '2025-04-01', 4500.00);

-- --------------------------------------------------------

--
-- Table structure for table `psihoterapeut`
--

CREATE TABLE `psihoterapeut` (
  `psihoterapeut_id` int(11) NOT NULL,
  `ime` varchar(15) NOT NULL,
  `prezime` varchar(15) NOT NULL,
  `JMBG` char(13) NOT NULL,
  `datum_rodjenja` date NOT NULL,
  `prebivaliste` varchar(20) NOT NULL,
  `telefon` varchar(20) NOT NULL,
  `email` varchar(40) NOT NULL,
  `stepen_id` int(11) NOT NULL,
  `fakultet_id` int(11) NOT NULL,
  `centar_id` int(11) NOT NULL,
  `status_id` int(11) NOT NULL,
  `is_psiholog` tinyint(1) NOT NULL,
  `is_supervizor` tinyint(1) NOT NULL,
  `lozinka` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `psihoterapeut`
--

INSERT INTO `psihoterapeut` (`psihoterapeut_id`, `ime`, `prezime`, `JMBG`, `datum_rodjenja`, `prebivaliste`, `telefon`, `email`, `stepen_id`, `fakultet_id`, `centar_id`, `status_id`, `is_psiholog`, `is_supervizor`, `lozinka`) VALUES
(1, 'Jovana', 'Matić', '8601055710023', '1986-01-05', 'Beograd', '0653214321', 'jmatic@gmail.com', 3, 4, 1, 1, 1, 1, 'lozinka1'),
(2, 'Miloš', 'Vuković', '8307225711024', '1983-07-22', 'Novi Sad', '0643314331', 'mvukovic@gmail.com', 3, 5, 2, 1, 1, 1, 'lozinka2'),
(3, 'Katarina', 'Bogdanović', '7903315712025', '1979-03-31', 'Beograd', '0633414341', 'kbog@gmail.com', 3, 6, 3, 1, 1, 1, 'lozinka3'),
(4, 'Ivan', 'Lukić', '9001016713026', '1990-01-01', 'Niš', '0623514351', 'ilukic@gmail.com', 3, 7, 4, 1, 0, 0, 'lozinka4'),
(5, 'Milena', 'Janković', '8808306714027', '1988-08-30', 'Subotica', '0613614361', 'mjankovic@gmail.com', 2, 8, 5, 1, 1, 0, 'lozinka5'),
(6, 'Dragan', 'Pavlović', '8702146715028', '1987-02-14', 'Čačak', '0603714371', 'dpavlovic@gmail.com', 2, 9, 6, 2, 0, 0, 'lozinka6'),
(7, 'Tanja', 'Ilić', '8906226716029', '1989-06-22', 'Beograd', '0693814381', 'tilic@gmail.com', 2, 4, 7, 1, 0, 0, 'lozinka7'),
(8, 'Nemanja', 'Vasić', '8512156717030', '1985-12-15', 'Zaječar', '0683914391', 'nvasic@gmail.com', 2, 5, 8, 1, 1, 0, 'lozinka8'),
(9, 'Sanja', 'Stefanović', '9004036718031', '1990-04-03', 'Beograd', '0674014401', 'sstefanovic@gmail.com', 2, 6, 9, 1, 0, 0, 'lozinka9'),
(10, 'Aleksandra', 'Đurić', '8811186719032', '1988-11-18', 'Valjevo', '0664114411', 'adjuric@gmail.com', 2, 7, 10, 1, 0, 0, 'lozinka10'),
(11, 'Jelena', 'Mitrović', '0501990123456', '1990-03-05', 'Beograd', '0607001234', 'jmitrovic@example.com', 2, 3, 4, 1, 1, 0, 'lozinkaJelena'),
(12, 'Ana', 'Anić', '2901990123456', '1990-01-29', 'Beograd', '060/123-456', 'ana@example.com', 2, 1, 1, 1, 1, 0, '2bb80d537b1da3e38bd30361aa855686bde0ba2e');

-- --------------------------------------------------------

--
-- Table structure for table `psihoterapeutoblastp`
--

CREATE TABLE `psihoterapeutoblastp` (
  `psihoterapeut_id` int(11) NOT NULL,
  `oblast_p_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `psihoterapeutoblastp`
--

INSERT INTO `psihoterapeutoblastp` (`psihoterapeut_id`, `oblast_p_id`) VALUES
(1, 1),
(1, 8),
(2, 2),
(2, 5),
(3, 3),
(4, 4),
(5, 6),
(6, 7),
(7, 1),
(8, 9),
(9, 2),
(10, 10),
(11, 3);

-- --------------------------------------------------------

--
-- Table structure for table `razlogobjavljivanja`
--

CREATE TABLE `razlogobjavljivanja` (
  `razlog_id` int(11) NOT NULL,
  `naziv` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `razlogobjavljivanja`
--

INSERT INTO `razlogobjavljivanja` (`razlog_id`, `naziv`) VALUES
(1, 'Zahtev suda'),
(2, 'Istraga policije'),
(3, 'Supervizija');

-- --------------------------------------------------------

--
-- Table structure for table `rezultattesta`
--

CREATE TABLE `rezultattesta` (
  `seansa_id` int(11) NOT NULL,
  `krajnji_rezultat` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `rezultattesta`
--

INSERT INTO `rezultattesta` (`seansa_id`, `krajnji_rezultat`) VALUES
(1, 22),
(2, 48),
(3, 125),
(4, 30),
(5, 110),
(6, 24),
(7, 70),
(8, 135),
(9, 28),
(10, 102);

-- --------------------------------------------------------

--
-- Table structure for table `seansa`
--

CREATE TABLE `seansa` (
  `seansa_id` int(11) NOT NULL,
  `test_id` int(11) NOT NULL,
  `psihoterapeut_id` int(11) NOT NULL,
  `klijent_id` int(11) NOT NULL,
  `kandidat_id` int(11) DEFAULT NULL,
  `datum` date NOT NULL,
  `dan_id` int(11) NOT NULL,
  `vreme` time NOT NULL,
  `trajanje_min` int(11) NOT NULL,
  `beleske_tekst` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `seansa`
--

INSERT INTO `seansa` (`seansa_id`, `test_id`, `psihoterapeut_id`, `klijent_id`, `kandidat_id`, `datum`, `dan_id`, `vreme`, `trajanje_min`, `beleske_tekst`) VALUES
(1, 1, 1, 1, NULL, '2025-05-02', 5, '10:00:00', 60, 'Razgovor o depresiji.'),
(2, 2, 2, 2, NULL, '2025-05-03', 6, '11:30:00', 50, 'Rad na anksioznosti.'),
(3, 3, 3, 3, NULL, '2025-05-04', 7, '09:15:00', 60, 'Procena ličnosti.'),
(4, 4, 4, 4, NULL, '2025-05-05', 1, '15:00:00', 45, 'Tehnike upravljanja stresom.'),
(5, 5, 5, 5, NULL, '2025-05-06', 2, '13:00:00', 55, 'IQ testiranje i interpretacija.'),
(6, 6, 6, 6, NULL, '2025-05-07', 3, '14:30:00', 60, 'Praćenje depresivnih simptoma.'),
(7, 7, 7, 7, NULL, '2025-05-08', 4, '10:45:00', 50, 'Evaluacija pozitivnog i negativnog afekta.'),
(8, 8, 8, 8, NULL, '2025-05-09', 5, '16:00:00', 60, 'Dubinska analiza ličnosti.'),
(9, 9, 9, 9, NULL, '2025-05-10', 6, '12:30:00', 40, 'Anksioznost u socijalnim situacijama.'),
(10, 10, 10, 10, NULL, '2025-05-11', 7, '09:00:00', 90, 'Detaljna kognitivna procena.'),
(11, 1, 1, 1, 1, '2025-05-12', 1, '11:00:00', 60, 'Kandidat vodio sesiju uz superviziju.'),
(12, 2, 2, 2, 2, '2025-05-13', 2, '10:00:00', 60, 'Session with candidate supervision.'),
(13, 3, 3, 3, 3, '2025-05-14', 3, '12:00:00', 50, 'Candidate assessment.'),
(14, 4, 4, 4, 4, '2025-05-15', 4, '14:00:00', 60, 'Family therapy focus.'),
(15, 5, 5, 5, 5, '2025-05-16', 5, '15:30:00', 45, 'Follow-up IQ analysis.'),
(16, 6, 6, 6, 6, '2025-05-17', 6, '09:30:00', 60, 'CBT techniques practice.'),
(17, 7, 7, 7, 7, '2025-05-18', 7, '11:15:00', 60, 'Emotion regulation training.'),
(18, 8, 8, 8, 8, '2025-05-19', 1, '13:45:00', 50, 'Gestalt dialog exercises.'),
(19, 9, 9, 9, 9, '2025-05-20', 2, '16:15:00', 60, 'Exposure exercise planning.'),
(20, 10, 10, 10, 10, '2025-05-21', 3, '10:20:00', 55, 'Comprehensive WAIS interpretation.');

-- --------------------------------------------------------

--
-- Table structure for table `sertifikat`
--

CREATE TABLE `sertifikat` (
  `sertifikat_id` int(11) NOT NULL,
  `datum_sertifikacije` date NOT NULL,
  `psihoterapeut_id` int(11) NOT NULL,
  `oblast_ps_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `sertifikat`
--

INSERT INTO `sertifikat` (`sertifikat_id`, `datum_sertifikacije`, `psihoterapeut_id`, `oblast_ps_id`) VALUES
(1, '2024-06-15', 1, 1),
(2, '2024-07-20', 2, 2),
(3, '2024-08-05', 3, 3),
(4, '2024-08-30', 4, 4),
(5, '2024-09-12', 5, 6),
(6, '2024-10-01', 6, 7),
(7, '2024-10-25', 7, 1),
(8, '2024-11-18', 8, 9),
(9, '2024-12-02', 9, 2),
(10, '2025-01-10', 10, 10);

-- --------------------------------------------------------

--
-- Table structure for table `status`
--

CREATE TABLE `status` (
  `status_id` int(11) NOT NULL,
  `naziv` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `status`
--

INSERT INTO `status` (`status_id`, `naziv`) VALUES
(1, 'Aktivan'),
(2, 'Pasivan'),
(3, 'Suspendovan'),
(4, 'Pauza'),
(5, 'Penzija');

-- --------------------------------------------------------

--
-- Table structure for table `stepenstudija`
--

CREATE TABLE `stepenstudija` (
  `stepen_id` int(11) NOT NULL,
  `naziv` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `stepenstudija`
--

INSERT INTO `stepenstudija` (`stepen_id`, `naziv`) VALUES
(1, 'Osnovne studije'),
(2, 'Master studije'),
(3, 'Doktorske studije');

-- --------------------------------------------------------

--
-- Table structure for table `supervizija`
--

CREATE TABLE `supervizija` (
  `supervizija_id` int(11) NOT NULL,
  `kandidat_id` int(11) NOT NULL,
  `psihoterapeut_id` int(11) NOT NULL,
  `datum_od` date NOT NULL,
  `datum_do` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `supervizija`
--

INSERT INTO `supervizija` (`supervizija_id`, `kandidat_id`, `psihoterapeut_id`, `datum_od`, `datum_do`) VALUES
(1, 1, 1, '2024-09-01', NULL),
(2, 2, 2, '2024-08-15', NULL),
(3, 3, 3, '2024-09-10', NULL),
(4, 4, 4, '2024-07-20', NULL),
(5, 5, 5, '2024-10-05', NULL),
(6, 6, 6, '2024-11-01', NULL),
(7, 7, 7, '2024-06-25', NULL),
(8, 8, 8, '2024-12-12', NULL),
(9, 9, 9, '2025-01-05', NULL),
(10, 10, 10, '2025-02-02', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `test`
--

CREATE TABLE `test` (
  `test_id` int(11) NOT NULL,
  `naziv` varchar(20) NOT NULL,
  `cena` decimal(8,2) DEFAULT NULL,
  `oblast_testa_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `test`
--

INSERT INTO `test` (`test_id`, `naziv`, `cena`, `oblast_testa_id`) VALUES
(1, 'Beck Depression', 2500.00, 4),
(2, 'STAI Anksioznost', 2200.00, 3),
(3, 'MMPI-2', 5000.00, 1),
(4, 'COPE Stres', 2000.00, 2),
(5, 'Raven IQ', 3000.00, 5),
(6, 'BDI-II', 2500.00, 4),
(7, 'PANAS', 2300.00, 3),
(8, 'NEO PI-R', 4500.00, 1),
(9, 'DASS-21', 2100.00, 2),
(10, 'WAIS-IV', 4800.00, 5);

-- --------------------------------------------------------

--
-- Table structure for table `univerzitet`
--

CREATE TABLE `univerzitet` (
  `univerzitet_id` int(11) NOT NULL,
  `naziv` varchar(30) NOT NULL,
  `uze_usmerenje` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `univerzitet`
--

INSERT INTO `univerzitet` (`univerzitet_id`, `naziv`, `uze_usmerenje`) VALUES
(1, 'Univerzitet u Beogradu', NULL),
(2, 'Univerzitet u Novom Sadu', NULL),
(3, 'Univerzitet primenjenih nauka', 'Prim. nauke'),
(4, 'Univerzitet umetnosti', 'Umetnost'),
(5, 'Univerzitet u Kragujevcu', NULL),
(6, 'Univerzitet u Nišu', NULL),
(7, 'Univerzitet u Prištini', 'Opšte studije'),
(8, 'Metropolitan University', 'Informatika'),
(9, 'Singidunum University', 'Ekonomija'),
(10, 'Megatrend University', 'Menadžment');

-- --------------------------------------------------------

--
-- Table structure for table `valuta`
--

CREATE TABLE `valuta` (
  `valuta_id` int(11) NOT NULL,
  `skraceni_naziv` varchar(3) NOT NULL,
  `puni_naziv` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `valuta`
--

INSERT INTO `valuta` (`valuta_id`, `skraceni_naziv`, `puni_naziv`) VALUES
(1, 'RSD', 'Srpski dinar'),
(2, 'EUR', 'Evro'),
(3, 'USD', 'Američki dolar'),
(4, 'CHF', 'Švajcarski franak'),
(5, 'CZK', 'Češka kruna');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `centarzaobuku`
--
ALTER TABLE `centarzaobuku`
  ADD PRIMARY KEY (`centar_id`);

--
-- Indexes for table `dan`
--
ALTER TABLE `dan`
  ADD PRIMARY KEY (`dan_id`);

--
-- Indexes for table `fakultet`
--
ALTER TABLE `fakultet`
  ADD PRIMARY KEY (`fakultet_id`),
  ADD KEY `Fakultet_Univerzitet` (`univerzitet_id`);

--
-- Indexes for table `fakultetoblast`
--
ALTER TABLE `fakultetoblast`
  ADD PRIMARY KEY (`fakultet_id`,`oblast_f_id`),
  ADD KEY `FakultetOblast_OblastFakulteta` (`oblast_f_id`);

--
-- Indexes for table `kandidat`
--
ALTER TABLE `kandidat`
  ADD PRIMARY KEY (`kandidat_id`),
  ADD UNIQUE KEY `email` (`email`),
  ADD UNIQUE KEY `JMBG` (`JMBG`),
  ADD UNIQUE KEY `telefon` (`telefon`),
  ADD UNIQUE KEY `email_2` (`email`),
  ADD UNIQUE KEY `JMBG_2` (`JMBG`),
  ADD UNIQUE KEY `telefon_2` (`telefon`),
  ADD KEY `Kandidat_StepenStudija` (`stepen_id`),
  ADD KEY `Kandidat_Fakultet` (`fakultet_id`),
  ADD KEY `Kandidat_CentarZaObuku` (`centar_id`);

--
-- Indexes for table `klijent`
--
ALTER TABLE `klijent`
  ADD PRIMARY KEY (`klijent_id`),
  ADD KEY `Klijent_Pol` (`pol_id`);

--
-- Indexes for table `kurs`
--
ALTER TABLE `kurs`
  ADD PRIMARY KEY (`kurs_id`),
  ADD KEY `Kurs_Valuta` (`valuta_id`);

--
-- Indexes for table `objavljivanjepodataka`
--
ALTER TABLE `objavljivanjepodataka`
  ADD PRIMARY KEY (`objavljivanje_id`),
  ADD KEY `ObjavljivanjePodataka_Seansa` (`seansa_id`),
  ADD KEY `ObjavljivanjePodataka_Razlog` (`razlog_id`);

--
-- Indexes for table `oblastfakulteta`
--
ALTER TABLE `oblastfakulteta`
  ADD PRIMARY KEY (`oblast_f_id`);

--
-- Indexes for table `oblastpsihoterapije`
--
ALTER TABLE `oblastpsihoterapije`
  ADD PRIMARY KEY (`oblast_ps_id`);

--
-- Indexes for table `oblasttesta`
--
ALTER TABLE `oblasttesta`
  ADD PRIMARY KEY (`oblast_testa_id`);

--
-- Indexes for table `placanje`
--
ALTER TABLE `placanje`
  ADD PRIMARY KEY (`placanje_id`),
  ADD KEY `Placanje_Klijent` (`klijent_id`),
  ADD KEY `Placanje_Seansa` (`seansa_id`),
  ADD KEY `Placanje_Valuta` (`valuta_id`);

--
-- Indexes for table `pol`
--
ALTER TABLE `pol`
  ADD PRIMARY KEY (`pol_id`);

--
-- Indexes for table `prijava`
--
ALTER TABLE `prijava`
  ADD PRIMARY KEY (`prijava_id`),
  ADD KEY `Prijava_Klijent` (`klijent_id`),
  ADD KEY `Prijava_Psihoterapeut` (`psihoterapeut_id`);

--
-- Indexes for table `promenaceneseanse`
--
ALTER TABLE `promenaceneseanse`
  ADD PRIMARY KEY (`cena_id`),
  ADD KEY `PromenaCeneSeanse_Seansa` (`seansa_id`);

--
-- Indexes for table `psihoterapeut`
--
ALTER TABLE `psihoterapeut`
  ADD PRIMARY KEY (`psihoterapeut_id`),
  ADD KEY `Psihoterapeut_StepenStudija` (`stepen_id`),
  ADD KEY `Psihoterapeut_Fakultet` (`fakultet_id`),
  ADD KEY `Psihoterapeut_CentarZaObuku` (`centar_id`),
  ADD KEY `Psihoterapeut_Status` (`status_id`);

--
-- Indexes for table `psihoterapeutoblastp`
--
ALTER TABLE `psihoterapeutoblastp`
  ADD PRIMARY KEY (`psihoterapeut_id`,`oblast_p_id`),
  ADD KEY `PsihoterapeutOblastP_OblastPsihoterapije` (`oblast_p_id`);

--
-- Indexes for table `razlogobjavljivanja`
--
ALTER TABLE `razlogobjavljivanja`
  ADD PRIMARY KEY (`razlog_id`);

--
-- Indexes for table `rezultattesta`
--
ALTER TABLE `rezultattesta`
  ADD PRIMARY KEY (`seansa_id`);

--
-- Indexes for table `seansa`
--
ALTER TABLE `seansa`
  ADD PRIMARY KEY (`seansa_id`),
  ADD KEY `Seansa_Test` (`test_id`),
  ADD KEY `Seansa_Psihoterapeut` (`psihoterapeut_id`),
  ADD KEY `Seansa_Klijent` (`klijent_id`),
  ADD KEY `Seansa_Kandidat` (`kandidat_id`),
  ADD KEY `Seansa_Dan` (`dan_id`);

--
-- Indexes for table `sertifikat`
--
ALTER TABLE `sertifikat`
  ADD PRIMARY KEY (`sertifikat_id`),
  ADD KEY `Sertifikat_Psihoterapeut` (`psihoterapeut_id`),
  ADD KEY `Sertifikat_OblastPsihoterapije` (`oblast_ps_id`);

--
-- Indexes for table `status`
--
ALTER TABLE `status`
  ADD PRIMARY KEY (`status_id`);

--
-- Indexes for table `stepenstudija`
--
ALTER TABLE `stepenstudija`
  ADD PRIMARY KEY (`stepen_id`);

--
-- Indexes for table `supervizija`
--
ALTER TABLE `supervizija`
  ADD PRIMARY KEY (`supervizija_id`),
  ADD KEY `Supervizija_Kandidat` (`kandidat_id`),
  ADD KEY `Supervizija_Psihoterapeut` (`psihoterapeut_id`);

--
-- Indexes for table `test`
--
ALTER TABLE `test`
  ADD PRIMARY KEY (`test_id`),
  ADD KEY `Test_OblastTesta` (`oblast_testa_id`);

--
-- Indexes for table `univerzitet`
--
ALTER TABLE `univerzitet`
  ADD PRIMARY KEY (`univerzitet_id`);

--
-- Indexes for table `valuta`
--
ALTER TABLE `valuta`
  ADD PRIMARY KEY (`valuta_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `kandidat`
--
ALTER TABLE `kandidat`
  MODIFY `kandidat_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `psihoterapeut`
--
ALTER TABLE `psihoterapeut`
  MODIFY `psihoterapeut_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `fakultet`
--
ALTER TABLE `fakultet`
  ADD CONSTRAINT `Fakultet_Univerzitet` FOREIGN KEY (`univerzitet_id`) REFERENCES `univerzitet` (`univerzitet_id`);

--
-- Constraints for table `fakultetoblast`
--
ALTER TABLE `fakultetoblast`
  ADD CONSTRAINT `FakultetOblast_Fakultet` FOREIGN KEY (`fakultet_id`) REFERENCES `fakultet` (`fakultet_id`),
  ADD CONSTRAINT `FakultetOblast_OblastFakulteta` FOREIGN KEY (`oblast_f_id`) REFERENCES `oblastfakulteta` (`oblast_f_id`);

--
-- Constraints for table `kandidat`
--
ALTER TABLE `kandidat`
  ADD CONSTRAINT `Kandidat_CentarZaObuku` FOREIGN KEY (`centar_id`) REFERENCES `centarzaobuku` (`centar_id`),
  ADD CONSTRAINT `Kandidat_Fakultet` FOREIGN KEY (`fakultet_id`) REFERENCES `fakultet` (`fakultet_id`),
  ADD CONSTRAINT `Kandidat_StepenStudija` FOREIGN KEY (`stepen_id`) REFERENCES `stepenstudija` (`stepen_id`);

--
-- Constraints for table `klijent`
--
ALTER TABLE `klijent`
  ADD CONSTRAINT `Klijent_Pol` FOREIGN KEY (`pol_id`) REFERENCES `pol` (`pol_id`);

--
-- Constraints for table `kurs`
--
ALTER TABLE `kurs`
  ADD CONSTRAINT `Kurs_Valuta` FOREIGN KEY (`valuta_id`) REFERENCES `valuta` (`valuta_id`);

--
-- Constraints for table `objavljivanjepodataka`
--
ALTER TABLE `objavljivanjepodataka`
  ADD CONSTRAINT `ObjavljivanjePodataka_Razlog` FOREIGN KEY (`razlog_id`) REFERENCES `razlogobjavljivanja` (`razlog_id`),
  ADD CONSTRAINT `ObjavljivanjePodataka_Seansa` FOREIGN KEY (`seansa_id`) REFERENCES `seansa` (`seansa_id`);

--
-- Constraints for table `placanje`
--
ALTER TABLE `placanje`
  ADD CONSTRAINT `Placanje_Klijent` FOREIGN KEY (`klijent_id`) REFERENCES `klijent` (`klijent_id`),
  ADD CONSTRAINT `Placanje_Seansa` FOREIGN KEY (`seansa_id`) REFERENCES `seansa` (`seansa_id`),
  ADD CONSTRAINT `Placanje_Valuta` FOREIGN KEY (`valuta_id`) REFERENCES `valuta` (`valuta_id`);

--
-- Constraints for table `prijava`
--
ALTER TABLE `prijava`
  ADD CONSTRAINT `Prijava_Klijent` FOREIGN KEY (`klijent_id`) REFERENCES `klijent` (`klijent_id`);

--
-- Constraints for table `promenaceneseanse`
--
ALTER TABLE `promenaceneseanse`
  ADD CONSTRAINT `PromenaCeneSeanse_Seansa` FOREIGN KEY (`seansa_id`) REFERENCES `seansa` (`seansa_id`);

--
-- Constraints for table `psihoterapeut`
--
ALTER TABLE `psihoterapeut`
  ADD CONSTRAINT `Psihoterapeut_CentarZaObuku` FOREIGN KEY (`centar_id`) REFERENCES `centarzaobuku` (`centar_id`),
  ADD CONSTRAINT `Psihoterapeut_Fakultet` FOREIGN KEY (`fakultet_id`) REFERENCES `fakultet` (`fakultet_id`),
  ADD CONSTRAINT `Psihoterapeut_Status` FOREIGN KEY (`status_id`) REFERENCES `status` (`status_id`),
  ADD CONSTRAINT `Psihoterapeut_StepenStudija` FOREIGN KEY (`stepen_id`) REFERENCES `stepenstudija` (`stepen_id`);

--
-- Constraints for table `psihoterapeutoblastp`
--
ALTER TABLE `psihoterapeutoblastp`
  ADD CONSTRAINT `PsihoterapeutOblastP_OblastPsihoterapije` FOREIGN KEY (`oblast_p_id`) REFERENCES `oblastpsihoterapije` (`oblast_ps_id`),
  ADD CONSTRAINT `PsihoterapeutOblastP_Psihoterapeut` FOREIGN KEY (`psihoterapeut_id`) REFERENCES `psihoterapeut` (`psihoterapeut_id`);

--
-- Constraints for table `rezultattesta`
--
ALTER TABLE `rezultattesta`
  ADD CONSTRAINT `RezultatTesta_Seansa` FOREIGN KEY (`seansa_id`) REFERENCES `seansa` (`seansa_id`);

--
-- Constraints for table `seansa`
--
ALTER TABLE `seansa`
  ADD CONSTRAINT `Seansa_Dan` FOREIGN KEY (`dan_id`) REFERENCES `dan` (`dan_id`),
  ADD CONSTRAINT `Seansa_Klijent` FOREIGN KEY (`klijent_id`) REFERENCES `klijent` (`klijent_id`),
  ADD CONSTRAINT `Seansa_Psihoterapeut` FOREIGN KEY (`psihoterapeut_id`) REFERENCES `psihoterapeut` (`psihoterapeut_id`),
  ADD CONSTRAINT `Seansa_Test` FOREIGN KEY (`test_id`) REFERENCES `test` (`test_id`);

--
-- Constraints for table `sertifikat`
--
ALTER TABLE `sertifikat`
  ADD CONSTRAINT `Sertifikat_OblastPsihoterapije` FOREIGN KEY (`oblast_ps_id`) REFERENCES `oblastpsihoterapije` (`oblast_ps_id`),
  ADD CONSTRAINT `Sertifikat_Psihoterapeut` FOREIGN KEY (`psihoterapeut_id`) REFERENCES `psihoterapeut` (`psihoterapeut_id`);

--
-- Constraints for table `supervizija`
--
ALTER TABLE `supervizija`
  ADD CONSTRAINT `Supervizija_Kandidat` FOREIGN KEY (`kandidat_id`) REFERENCES `kandidat` (`kandidat_id`),
  ADD CONSTRAINT `Supervizija_Psihoterapeut` FOREIGN KEY (`psihoterapeut_id`) REFERENCES `psihoterapeut` (`psihoterapeut_id`);

--
-- Constraints for table `test`
--
ALTER TABLE `test`
  ADD CONSTRAINT `Test_OblastTesta` FOREIGN KEY (`oblast_testa_id`) REFERENCES `oblasttesta` (`oblast_testa_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
