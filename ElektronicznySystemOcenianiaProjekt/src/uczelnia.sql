-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 15 Cze 2024, 18:23
-- Wersja serwera: 10.4.24-MariaDB
-- Wersja PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `uczelnia`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `oceny`
--

CREATE TABLE `oceny` (
  `ocena_id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  `przedmiot_id` int(11) NOT NULL,
  `ocena` decimal(3,2) NOT NULL CHECK (`ocena` >= 2.0 and `ocena` <= 5.0)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `oceny`
--

INSERT INTO `oceny` (`ocena_id`, `student_id`, `przedmiot_id`, `ocena`) VALUES
(4, 1, 4, '3.00'),
(5, 1, 5, '2.50'),
(7, 2, 2, '2.50'),
(8, 2, 3, '4.00'),
(9, 2, 4, '4.50'),
(10, 2, 5, '5.00'),
(13, 3, 3, '3.50'),
(14, 3, 4, '3.50'),
(15, 3, 5, '4.50'),
(16, 4, 1, '4.50'),
(17, 4, 2, '4.00'),
(18, 4, 3, '3.00'),
(19, 4, 5, '3.50'),
(20, 4, 5, '3.00'),
(21, 5, 1, '3.50'),
(22, 5, 2, '4.00'),
(23, 5, 3, '3.00'),
(24, 5, 4, '5.00'),
(25, 5, 5, '3.00'),
(27, 6, 2, '2.50'),
(28, 6, 3, '3.00'),
(29, 6, 4, '3.50'),
(30, 6, 5, '4.00'),
(31, 7, 1, '2.50'),
(32, 7, 2, '4.00'),
(33, 7, 3, '4.50'),
(34, 7, 4, '5.00'),
(35, 7, 5, '2.00'),
(37, 8, 2, '3.00'),
(38, 8, 3, '3.50'),
(39, 8, 4, '4.00'),
(40, 8, 5, '4.50'),
(41, 9, 1, '3.50'),
(42, 9, 2, '5.00'),
(43, 9, 3, '2.00'),
(44, 9, 4, '2.50'),
(45, 9, 5, '3.00'),
(46, 10, 1, '3.50'),
(47, 10, 2, '5.00'),
(48, 10, 3, '4.50'),
(49, 10, 4, '2.50'),
(50, 10, 5, '2.00'),
(51, 11, 6, '2.00'),
(52, 11, 7, '2.50'),
(53, 11, 8, '3.00'),
(54, 11, 9, '3.50'),
(55, 11, 10, '4.00'),
(56, 12, 6, '3.50'),
(57, 12, 7, '4.00'),
(58, 12, 8, '4.50'),
(59, 12, 9, '5.00'),
(60, 12, 10, '2.00'),
(61, 13, 6, '2.50'),
(62, 13, 7, '3.00'),
(63, 13, 8, '3.50'),
(64, 13, 9, '4.00'),
(65, 13, 10, '4.50'),
(66, 14, 6, '4.50'),
(67, 14, 7, '5.00'),
(68, 14, 8, '2.00'),
(69, 14, 9, '2.50'),
(70, 14, 10, '3.00'),
(71, 15, 6, '3.50'),
(72, 15, 7, '4.00'),
(73, 15, 8, '4.50'),
(74, 15, 9, '5.00'),
(75, 15, 10, '2.00'),
(76, 16, 6, '2.00'),
(77, 16, 7, '2.50'),
(78, 16, 8, '3.00'),
(79, 16, 9, '3.50'),
(80, 16, 10, '4.00'),
(81, 17, 6, '3.50'),
(82, 17, 7, '4.00'),
(83, 17, 8, '4.50'),
(84, 17, 9, '5.00'),
(85, 17, 10, '2.00'),
(86, 18, 6, '2.50'),
(87, 18, 7, '3.00'),
(88, 18, 8, '3.50'),
(89, 18, 9, '4.00'),
(90, 18, 10, '4.50'),
(91, 19, 6, '4.50'),
(92, 19, 7, '5.00'),
(93, 19, 8, '2.00'),
(94, 19, 9, '2.50'),
(95, 19, 10, '3.00'),
(96, 20, 6, '3.50'),
(97, 20, 7, '4.00'),
(98, 20, 8, '4.50'),
(99, 20, 9, '5.00'),
(100, 20, 10, '2.00'),
(101, 21, 11, '2.00'),
(102, 21, 12, '2.50'),
(103, 21, 13, '3.00'),
(104, 21, 14, '3.50'),
(105, 21, 15, '4.00'),
(106, 22, 11, '3.50'),
(107, 22, 12, '4.00'),
(108, 22, 13, '4.50'),
(109, 22, 14, '5.00'),
(110, 22, 15, '2.00'),
(111, 23, 11, '2.50'),
(112, 23, 12, '3.00'),
(113, 23, 13, '3.50'),
(114, 23, 14, '4.00'),
(115, 23, 15, '4.50'),
(116, 24, 11, '4.50'),
(117, 24, 12, '5.00'),
(118, 24, 13, '2.00'),
(119, 24, 14, '2.50'),
(120, 24, 15, '3.00'),
(121, 25, 11, '3.50'),
(122, 25, 12, '4.00'),
(123, 25, 13, '4.50'),
(124, 25, 14, '5.00'),
(125, 25, 15, '2.00'),
(126, 26, 11, '2.00'),
(127, 26, 12, '2.50'),
(128, 26, 13, '3.00'),
(129, 26, 14, '3.50'),
(130, 26, 15, '4.00'),
(131, 27, 11, '3.50'),
(132, 27, 12, '4.00'),
(133, 27, 13, '4.50'),
(134, 27, 14, '5.00'),
(135, 27, 15, '2.00'),
(136, 28, 11, '2.50'),
(137, 28, 12, '3.00'),
(138, 28, 13, '3.50'),
(139, 28, 14, '4.00'),
(140, 28, 15, '4.50'),
(141, 29, 11, '4.50'),
(142, 29, 12, '5.00'),
(143, 29, 13, '2.00'),
(144, 29, 14, '2.50'),
(145, 29, 15, '3.00'),
(146, 30, 11, '3.50'),
(147, 30, 12, '4.00'),
(148, 30, 13, '4.50'),
(149, 30, 14, '5.00'),
(150, 30, 15, '2.00'),
(151, 31, 16, '2.00'),
(152, 31, 17, '2.50'),
(153, 31, 18, '3.00'),
(154, 31, 19, '3.50'),
(155, 31, 20, '4.00'),
(156, 32, 16, '3.50'),
(157, 32, 17, '4.00'),
(158, 32, 18, '4.50'),
(159, 32, 19, '5.00'),
(160, 32, 20, '2.00'),
(161, 33, 16, '2.50'),
(162, 33, 17, '3.00'),
(163, 33, 18, '3.50'),
(164, 33, 19, '4.00'),
(165, 33, 20, '4.50'),
(166, 34, 16, '4.50'),
(167, 34, 17, '5.00'),
(168, 34, 18, '2.00'),
(169, 34, 19, '2.50'),
(170, 34, 20, '3.00'),
(171, 35, 16, '3.50'),
(172, 35, 17, '4.00'),
(173, 35, 18, '4.50'),
(174, 35, 19, '5.00'),
(175, 35, 20, '2.00'),
(176, 36, 16, '2.00'),
(177, 36, 17, '2.50'),
(178, 36, 18, '3.00'),
(179, 36, 19, '3.50'),
(180, 36, 20, '4.00'),
(181, 37, 16, '3.50'),
(182, 37, 17, '4.00'),
(183, 37, 18, '4.50'),
(184, 37, 19, '5.00'),
(185, 37, 20, '2.00'),
(186, 38, 16, '2.50'),
(187, 38, 17, '3.00'),
(188, 38, 18, '3.50'),
(189, 38, 19, '4.00'),
(190, 38, 20, '4.50'),
(191, 39, 16, '4.50'),
(192, 39, 17, '5.00'),
(193, 39, 18, '2.00'),
(194, 39, 19, '2.50'),
(195, 39, 20, '3.00'),
(196, 40, 16, '3.50'),
(197, 40, 17, '4.00'),
(198, 40, 18, '4.50'),
(199, 40, 19, '5.00'),
(200, 40, 20, '2.00'),
(201, 41, 21, '2.00'),
(202, 41, 22, '2.50'),
(203, 41, 23, '3.00'),
(204, 41, 24, '3.50'),
(205, 41, 25, '4.00'),
(206, 42, 21, '3.50'),
(207, 42, 22, '4.00'),
(208, 42, 23, '4.50'),
(209, 42, 24, '5.00'),
(210, 42, 25, '2.00'),
(211, 43, 21, '2.50'),
(212, 43, 22, '3.00'),
(213, 43, 23, '3.50'),
(214, 43, 24, '4.00'),
(215, 43, 25, '4.50'),
(216, 44, 21, '4.50'),
(217, 44, 22, '5.00'),
(218, 44, 23, '2.00'),
(219, 44, 24, '2.50'),
(220, 44, 25, '3.00'),
(221, 45, 21, '3.50'),
(222, 45, 21, '3.50'),
(223, 45, 22, '4.00'),
(224, 45, 23, '4.50'),
(225, 45, 24, '5.00'),
(226, 45, 25, '2.00'),
(227, 46, 21, '2.00'),
(228, 46, 22, '2.50'),
(229, 46, 23, '3.00'),
(230, 46, 24, '3.50'),
(231, 46, 25, '4.00'),
(232, 47, 21, '3.50'),
(233, 47, 22, '4.00'),
(234, 47, 23, '4.50'),
(235, 47, 24, '5.00'),
(236, 47, 25, '2.00'),
(237, 48, 21, '2.50'),
(238, 48, 22, '3.00'),
(239, 48, 23, '3.50'),
(240, 48, 24, '4.00'),
(241, 48, 25, '4.50'),
(242, 49, 21, '4.50'),
(243, 49, 22, '5.00'),
(244, 49, 23, '2.00'),
(245, 49, 24, '2.50'),
(246, 49, 25, '3.00'),
(247, 50, 21, '3.50'),
(248, 50, 22, '4.00'),
(249, 50, 23, '4.50'),
(250, 50, 24, '5.00'),
(436, 4, 3, '4.00'),
(437, 4, 4, '5.00'),
(444, 2, 1, '3.00'),
(445, 1, 3, '3.50'),
(447, 1, 1, '3.00'),
(448, 1, 2, '3.00'),
(449, 2, 2, '3.00'),
(450, 3, 2, '4.00'),
(455, 6, 1, '2.00'),
(456, 3, 1, '4.00'),
(457, 5, 1, '3.50'),
(458, 5, 1, '2.50'),
(461, 3, 3, '3.50');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `przedmioty`
--

CREATE TABLE `przedmioty` (
  `przedmiot_id` int(11) NOT NULL,
  `nazwa` varchar(100) NOT NULL,
  `wykladowca_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `przedmioty`
--

INSERT INTO `przedmioty` (`przedmiot_id`, `nazwa`, `wykladowca_id`) VALUES
(1, 'Matematyka', 1),
(2, 'Fizyka', 1),
(3, 'Chemia', 1),
(4, 'Biologiac', 1),
(5, 'Informatyka', 1),
(6, 'Statystyka', 2),
(7, 'Algebra', 2),
(8, 'Geometria', 2),
(9, 'Logika', 2),
(10, 'Programowanie', 2),
(11, 'Elektronika', 3),
(12, 'Mechanika', 3),
(13, 'Teoria obwodów', 3),
(14, 'Automatyka', 3),
(15, 'Robotyka', 3),
(16, 'Zarządzanie', 4),
(17, 'Ekonomia', 4),
(18, 'Finanse', 4),
(19, 'Marketing', 4),
(20, 'Prawo', 4),
(21, 'Socjologia', 5),
(22, 'Psychologia', 5),
(23, 'Pedagogika', 5),
(24, 'Filozofia', 5),
(25, 'Etyka', 5);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `studenci`
--

CREATE TABLE `studenci` (
  `student_id` int(11) NOT NULL,
  `imie` varchar(50) NOT NULL,
  `nazwisko` varchar(50) NOT NULL,
  `login` varchar(50) NOT NULL,
  `haslo` varchar(255) NOT NULL,
  `email` varchar(100) NOT NULL,
  `rok` int(11) NOT NULL CHECK (`rok` between 1 and 5)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `studenci`
--

INSERT INTO `studenci` (`student_id`, `imie`, `nazwisko`, `login`, `haslo`, `email`, `rok`) VALUES
(1, 'Jan', 'Kowalski', 'jk1', 'haslo123', 'jan.kowalski1@example.com', 1),
(2, 'Anna', 'Nowak', 'an2', 'haslo123', 'anna.nowak1@example.com', 1),
(3, 'Piotr', 'Zieliński', 'pz3', 'haslo123', 'piotr.zielinski1@example.com', 1),
(4, 'Katarzyna', 'Wiśniewska', 'kw4', 'haslo123', 'katarzyna.wisniewska1@example.com', 1),
(5, 'Michał', 'Wójcik', 'mw5', 'haslo123', 'michal.wojcik1@example.com', 1),
(6, 'Monika', 'Kowalczyk', 'mk6', 'haslo123', 'monika.kowalczyk1@example.com', 1),
(7, 'Paweł', 'Kamiński', 'pk7', 'haslo123', 'pawel.kaminski1@example.com', 1),
(8, 'Małgorzata', 'Lewandowska', 'ml8', 'haslo123', 'malgorzata.lewandowska1@example.com', 1),
(9, 'Tomasz', 'Zając', 'tz9', 'haslo123', 'tomasz.zajac1@example.com', 1),
(10, 'Barbara', 'Król', 'bk10', 'haslo123', 'barbara.krol1@example.com', 1),
(11, 'Karol', 'Wiśniewski', 'kw11', 'haslo123', 'karol.wisniewski2@example.com', 2),
(12, 'Ewa', 'Kamińska', 'ek12', 'haslo123', 'ewa.kaminska2@example.com', 2),
(13, 'Łukasz', 'Dąbrowski', 'ld13', 'haslo123', 'lukasz.dabrowski2@example.com', 2),
(14, 'Natalia', 'Zielińska', 'nz14', 'haslo123', 'natalia.zielinska2@example.com', 2),
(15, 'Wojciech', 'Woźniak', 'ww15', 'haslo123', 'wojciech.wozniak2@example.com', 2),
(16, 'Aleksandra', 'Kowalczyk', 'ak16', 'haslo123', 'aleksandra.kowalczyk2@example.com', 2),
(17, 'Rafał', 'Mazur', 'rm17', 'haslo123', 'rafal.mazur2@example.com', 2),
(18, 'Magdalena', 'Krawczyk', 'mk18', 'haslo123', 'magdalena.krawczyk2@example.com', 2),
(19, 'Grzegorz', 'Kaczmarek', 'gk19', 'haslo123', 'grzegorz.kaczmarek2@example.com', 2),
(20, 'Agnieszka', 'Piotrowska', 'ap20', 'haslo123', 'agnieszka.piotrowska2@example.com', 2),
(21, 'Krzysztof', 'Kwiatkowski', 'kk21', 'haslo123', 'krzysztof.kwiatkowski3@example.com', 3),
(22, 'Marta', 'Grabowska', 'mg22', 'haslo123', 'marta.grabowska3@example.com', 3),
(23, 'Mariusz', 'Zieliński', 'mz23', 'haslo123', 'mariusz.zielinski3@example.com', 3),
(24, 'Dorota', 'Wojciechowska', 'dw24', 'haslo123', 'dorota.wojciechowska3@example.com', 3),
(25, 'Szymon', 'Jankowski', 'sj25', 'haslo123', 'szymon.jankowski3@example.com', 3),
(26, 'Joanna', 'Wróblewska', 'jw26', 'haslo123', 'joanna.wroblewska3@example.com', 3),
(27, 'Andrzej', 'Pawlak', 'ap27', 'haslo123', 'andrzej.pawlak3@example.com', 3),
(28, 'Beata', 'Kruk', 'bk28', 'haslo123', 'beata.kruk3@example.com', 3),
(29, 'Artur', 'Sikorski', 'as29', 'haslo123', 'artur.sikorski3@example.com', 3),
(30, 'Izabela', 'Nowak', 'in30', 'haslo123', 'izabela.nowak3@example.com', 3),
(31, 'Patryk', 'Adamski', 'pa31', 'haslo123', 'patryk.adamski4@example.com', 4),
(32, 'Sylwia', 'Bąk', 'sb32', 'haslo123', 'sylwia.bak4@example.com', 4),
(33, 'Dawid', 'Górski', 'dg33', 'haslo123', 'dawid.gorski4@example.com', 4),
(34, 'Klaudia', 'Szymańska', 'ks34', 'haslo123', 'klaudia.szymanska4@example.com', 4),
(35, 'Przemysław', 'Kołodziej', 'pk35', 'haslo123', 'przemyslaw.kolodziej4@example.com', 4),
(36, 'Martyna', 'Malinowska', 'mm36', 'haslo123', 'martyna.malinowska4@example.com', 4),
(37, 'Sebastian', 'Pietrzak', 'sp37', 'haslo123', 'sebastian.pietrzak4@example.com', 4),
(38, 'Zuzanna', 'Rogowska', 'zr38', 'haslo123', 'zuzanna.rogowska4@example.com', 4),
(39, 'Adam', 'Nowicki', 'an39', 'haslo123', 'adam.nowicki4@example.com', 4),
(40, 'Dominika', 'Michalak', 'dm40', 'haslo123', 'dominika.michalak4@example.com', 4),
(41, 'Adrian', 'Wysocki', 'aw41', 'haslo123', 'adrian.wysocki5@example.com', 5),
(42, 'Emilia', 'Ostrowska', 'eo42', 'haslo123', 'emilia.ostrowska5@example.com', 5),
(43, 'Konrad', 'Lis', 'kl43', 'haslo123', 'konrad.lis5@example.com', 5),
(44, 'Ewelina', 'Czarnecka', 'ec44', 'haslo123', 'ewelina.czarnecka5@example.com', 5),
(45, 'Bartosz', 'Makowski', 'bm45', 'haslo123', 'bartosz.makowski5@example.com', 5),
(46, 'Weronika', 'Jasińskawefsdfsdf', 'wj46', 'haslo123', 'weronika.jasinska5@example.com', 5),
(47, 'Wiktor', 'Sadowski', 'ws47', 'haslo123', 'wiktor.sadowski5@example.com', 5),
(48, 'Julia', 'Kubiak', 'jk48', 'haslo123', 'julia.kubiak5@example.com', 5),
(49, 'Igor', 'Łuczak', 'iŁ49', 'haslo123', 'igor.luczak5@example.com', 5),
(50, 'Justyna', 'Błaszczyk', 'jb50', 'haslo123', 'justyna.blaszczyk5@example.com', 5);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `wykladowcy`
--

CREATE TABLE `wykladowcy` (
  `wykladowca_id` int(11) NOT NULL,
  `imie` varchar(50) NOT NULL,
  `nazwisko` varchar(50) NOT NULL,
  `login` varchar(50) NOT NULL,
  `haslo` varchar(255) NOT NULL,
  `email` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `wykladowcy`
--

INSERT INTO `wykladowcy` (`wykladowca_id`, `imie`, `nazwisko`, `login`, `haslo`, `email`) VALUES
(1, 'Adam', 'Wiśniewski', '1aw', 'haslo123', 'adam.wisniewski@example.com'),
(2, 'Maria', 'Kaczmarek', '2mk', 'haslo123', 'maria.kaczmarek@example.com'),
(3, 'Michał', 'Lewandowski', '3ml', 'haslo123', 'michal.lewandowski@example.comxd'),
(4, 'Magdalena', 'Szymańska', '4ms', 'haslo123', 'magdalena.szymanska@example.com'),
(5, 'Rafał', 'Woźniakskibidi', '5rw', 'haslo123', 'rafal.wozniak@example.com');

--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `oceny`
--
ALTER TABLE `oceny`
  ADD PRIMARY KEY (`ocena_id`),
  ADD KEY `student_id` (`student_id`),
  ADD KEY `przedmiot_id` (`przedmiot_id`);

--
-- Indeksy dla tabeli `przedmioty`
--
ALTER TABLE `przedmioty`
  ADD PRIMARY KEY (`przedmiot_id`),
  ADD KEY `wykladowca_id` (`wykladowca_id`);

--
-- Indeksy dla tabeli `studenci`
--
ALTER TABLE `studenci`
  ADD PRIMARY KEY (`student_id`),
  ADD UNIQUE KEY `login` (`login`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Indeksy dla tabeli `wykladowcy`
--
ALTER TABLE `wykladowcy`
  ADD PRIMARY KEY (`wykladowca_id`),
  ADD UNIQUE KEY `login` (`login`),
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT dla zrzuconych tabel
--

--
-- AUTO_INCREMENT dla tabeli `oceny`
--
ALTER TABLE `oceny`
  MODIFY `ocena_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=463;

--
-- AUTO_INCREMENT dla tabeli `przedmioty`
--
ALTER TABLE `przedmioty`
  MODIFY `przedmiot_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=49;

--
-- AUTO_INCREMENT dla tabeli `studenci`
--
ALTER TABLE `studenci`
  MODIFY `student_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=57;

--
-- AUTO_INCREMENT dla tabeli `wykladowcy`
--
ALTER TABLE `wykladowcy`
  MODIFY `wykladowca_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=239;

--
-- Ograniczenia dla zrzutów tabel
--

--
-- Ograniczenia dla tabeli `oceny`
--
ALTER TABLE `oceny`
  ADD CONSTRAINT `oceny_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `studenci` (`student_id`),
  ADD CONSTRAINT `oceny_ibfk_2` FOREIGN KEY (`przedmiot_id`) REFERENCES `przedmioty` (`przedmiot_id`);

--
-- Ograniczenia dla tabeli `przedmioty`
--
ALTER TABLE `przedmioty`
  ADD CONSTRAINT `przedmioty_ibfk_1` FOREIGN KEY (`wykladowca_id`) REFERENCES `wykladowcy` (`wykladowca_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
