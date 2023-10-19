-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th10 19, 2023 lúc 10:50 AM
-- Phiên bản máy phục vụ: 10.4.28-MariaDB
-- Phiên bản PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `question`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `game`
--

CREATE TABLE `game` (
  `id` int(11) NOT NULL,
  `question` text NOT NULL,
  `a` varchar(200) NOT NULL,
  `b` varchar(200) NOT NULL,
  `c` varchar(200) NOT NULL,
  `d` varchar(200) NOT NULL,
  `keys` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `game`
--

INSERT INTO `game` (`id`, `question`, `a`, `b`, `c`, `d`, `keys`) VALUES
(1, 'The charity aims to ____ food and shelter for underprivileged in the remote areas of the country', 'present', 'assist', 'provide', 'offer', 'provide'),
(2, 'We need to promote a lifestyle that is ____ to the environment', 'friendly', 'friend', 'friendship', 'friendliness', 'friendly'),
(3, 'My parents will have celebrated 30 years of ____ by next week.', 'marry', 'married', 'marriageable', 'marriage', 'marriage'),
(4, 'The singer was ____ on the piano by her sister.', 'discarded', 'accompanied', 'performed', 'played', 'played'),
(5, 'She ____ her success to hard work.', 'described', 'devoted', 'blamed', 'ascribed', 'devoted'),
(6, 'People have used coal and oil to ____ electricity for a long time.', 'bred', 'raise', 'cultivate', 'generate', 'generate'),
(7, 'Water is ____ of two elements: hydrogen and oxygen.', 'consisted', 'composed', 'making', 'comprising', 'composed'),
(8, 'I want to ____ a table at the Bamboo Restaurant.', 'maintain', 'manage', 'reserve', 'allow', 'reserve'),
(9, 'The manager ____ his temper with the employees and shouted at them.', 'had', 'lost', 'took', 'kept', 'lost'),
(10, 'I’d like to ____ this old car for a new model but I can’t afford it.', 'convert', 'exchange', 'replace', 'interchange', 'exchange'),
(11, 'My father sometimes ____ the washing up after dinner.', 'takes', 'does', 'washes', 'makes', 'does'),
(12, 'How are you ____ on with your work? - It’s Ok.', 'calling', 'getting', 'laying', 'looking', 'getting'),
(13, 'I must tell you about my ____ when I first arrived in London.', 'incidents', 'happenings', 'experiences', 'events', 'experiences'),
(14, 'With so much ____, I’m lucky to be in work.', 'employees', 'employers', 'employment', 'unemployment', 'unemployment'),
(15, 'The old houses were ____ down to make way for a block of flats.', 'banged', 'hit', 'knocked', 'put', 'knocked'),
(16, 'Violent films may have a negative ____ on children', 'opinion', 'influence', 'dependence', 'decision', 'influence'),
(17, 'Your handwriting tells a lot about your ____', 'characteristic', 'characterless', 'character', 'characterize', 'character'),
(18, 'From the hotel there’s a good ____	of the mountain.', 'view', 'vision', 'picture', 'sight', 'view'),
(19, 'Violence on TV can have a bad ____ on children', 'affect', 'consequence', 'influence', 'result', 'influence'),
(20, 'Carbon-dioxide traps	in the atmosphere and increases global warming.', 'dirt', 'snow', 'heat', 'ice', 'heat');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `game`
--
ALTER TABLE `game`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `game`
--
ALTER TABLE `game`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
