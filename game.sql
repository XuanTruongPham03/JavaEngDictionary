-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th10 30, 2023 lúc 03:08 PM
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
-- Cơ sở dữ liệu: `javaeng`
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
  `answer` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `game`
--

INSERT INTO `game` (`id`, `question`, `a`, `b`, `c`, `d`, `answer`) VALUES
(1, 'The charity aims to ____ food and shelter for underprivileged in the remote areas of the country', 'present', 'assist', 'provide', 'offer', 'c'),
(2, 'We need to promote a lifestyle that is ____ to the environment', 'friendly', 'friend', 'friendship', 'friendliness', 'a'),
(3, 'My parents will have celebrated 30 years of ____ by next week.', 'marry', 'married', 'marriageable', 'marriage', 'd'),
(4, 'The singer was ____ on the piano by her sister.', 'discarded', 'accompanied', 'performed', 'played', 'd'),
(5, 'She ____ her success to hard work.', 'described', 'devoted', 'blamed', 'ascribed', 'b'),
(6, 'People have used coal and oil to ____ electricity for a long time.', 'bred', 'raise', 'cultivate', 'generate', 'd'),
(7, 'Water is ____ of two elements: hydrogen and oxygen.', 'consisted', 'composed', 'making', 'comprising', 'b'),
(8, 'I want to ____ a table at the Bamboo Restaurant.', 'maintain', 'manage', 'reserve', 'allow', 'c'),
(9, 'The manager ____ his temper with the employees and shouted at them.', 'had', 'lost', 'took', 'kept', 'b'),
(10, 'I’d like to ____ this old car for a new model but I can’t afford it.', 'convert', 'exchange', 'replace', 'interchange', 'b'),
(11, 'My father sometimes ____ the washing up after dinner.', 'takes', 'does', 'washes', 'makes', 'b'),
(12, 'How are you ____ on with your work? - It’s Ok.', 'calling', 'getting', 'laying', 'looking', 'b'),
(13, 'I must tell you about my ____ when I first arrived in London.', 'incidents', 'happenings', 'experiences', 'events', 'c'),
(14, 'With so much ____, I’m lucky to be in work.', 'employees', 'employers', 'employment', 'unemployment', 'd'),
(15, 'The old houses were ____ down to make way for a block of flats.', 'banged', 'hit', 'knocked', 'put', 'c'),
(16, 'Violent films may have a negative ____ on children', 'opinion', 'influence', 'dependence', 'decision', 'b'),
(17, 'Your handwriting tells a lot about your ____', 'characteristic', 'characterless', 'character', 'characterize', 'c'),
(18, 'From the hotel there’s a good ____	of the mountain.', 'view', 'vision', 'picture', 'sight', 'a'),
(19, 'Violence on TV can have a bad ____ on children', 'affect', 'consequence', 'influence', 'result', 'c'),
(20, 'Carbon-dioxide traps ____ in the atmosphere and increases global warming.', 'dirt', 'snow', 'heat', 'ice', 'c'),
(21, 'Not all teenagers are well-____ for their future job when they are at high school.', 'interested', 'concerned', 'prepared', 'satisfied', 'c'),
(22, 'Some day of rest may help to ____ the pressure of work.', 'lower', 'increase', 'raise up', 'reduce', 'd'),
(23, 'Do you know who ____ the fact that sound travels in waves?', 'invented', 'discovered', 'developed', 'found', 'b'),
(24, 'I always enjoy our school ____ to France.', 'excursion', 'journey', 'trip', 'travel', 'c'),
(25, 'Prices quoted in this package include ____ hours of Internet access for one month.', 'unwarranted', 'uncontrolled', 'unlimited', 'unrecoverable', 'c'),
(26, 'The school was closed for a month because of serious ____ of fever.', 'outcome', 'outburst', 'outbreak', 'outset', 'c'),
(27, 'The clock was ____ by the Chinese in the 11th century.', 'built', 'kept', 'examined', 'made ', 'd'),
(28, 'My math teacher is the one who is the most ____ of the staff in the school.', 'respectable', 'respected', 'respective', 'respectful', 'a'),
(29, ' The government has made a serious attempt to raise the ____ of living.', 'cost', 'standard', 'mode', 'level ', 'd'),
(30, 'Family is a good ____ from which you can join the society with confidence.', 'base', 'basic', 'basis', 'basing', 'a'),
(31, 'The computer has had an enormous ___ on the way we work and enjoy life.', 'impression', 'influence', 'change', 'alternation', 'b'),
(32, 'I am ___ at paying my bills on time.', 'hopeful', 'hopeless', 'hope', 'hoping', 'b'),
(33, 'Students who study far from home often have problems with ____ .', 'houses', 'rooms', 'flats', 'accommodation ', 'd'),
(34, 'The chart ____ the massive amount of food consumed by the young in 2015.', 'occupies', 'illustrates', 'behinds', 'predicts', 'b'),
(35, 'It’s necessary for students to listen to their teacher ____ .', 'attend', 'attentive', 'attentively', 'attention', 'c'),
(36, 'Being well-dressed and punctual can help you create a good ____ on your interviewer.', 'pressure', 'impression', 'effectiveness', 'employment', 'b'),
(37, 'Do you think doing the household chores is the ____ of the women city?', 'responsible', 'responsive', 'responsibility', 'responsibly ', 'c'),
(38, 'With what my parents prepare for me in terms of education. I am ____ about my future.', 'confide', 'confident', 'confidence', 'confidential', 'b'),
(39, 'The goal is to make higher education available to everyone who is will and capable ____ his financial situation.\r\n', 'regardless of', 'owing to', 'in terms of', 'with reference to', 'a'),
(40, 'The course was so difficult that I didn’t ____ any progress at all.', 'do', 'make', 'produce', 'create', 'b'),
(41, 'The social services are chiefly ____ with the poor, the old and the sick.', 'influenced', 'related', 'suffered', 'concerned', 'd'),
(42, 'Thanks to the ____ weather condition, Vietnam owns plentiful kinds of fruits and vegetables.', 'favorite', 'favorable', 'unfavorable', 'favored', 'b'),
(43, 'Housework is less tiring and boring thanks to the invention of ____ devices.', 'environment-friendly', 'time-consuming', 'labor-saving', 'pollution-free', 'b'),
(44, 'Becoming an adult and setting up ____ no longer mean the same thing.', 'housing', 'housework', 'household', 'housemate', 'c'),
(45, 'Unfortunately, not all candidates can be offered a job, some have to be ____. ', 'required', 'rejected', 'remained', 'resigned', 'b'),
(46, 'The proposal will go ahead despite strong ____ from the public.', 'objections', 'refusals', 'resistances', 'disagreements', 'a'),
(47, 'The rise in energy ____ has led to a reduction of fossil fuels that the world must use.', 'redundancy', 'consumption', 'efficiency', 'suitability ', 'b'),
(48, '- How much is this car? – 15,000 dollars. My uncle paid for it by ____. ', 'installments', 'credit', 'hire purchase', 'cash', 'a'),
(49, 'At the end of the film, the young prince ____ in love with a reporter.', 'felt', 'made', 'fell', 'got', 'c'),
(50, 'Those ____ boys often play tricks on their friends.', 'mischievous', 'obedient', 'honest', 'well-behaved', 'a'),
(51, 'Mary is very ____ and caring. - I think she would make a good nurse.', 'mischievous', 'effect', 'efficient', 'disobedient', 'c'),
(52, 'Everyone should travel. As they say, it really ____ the mind.', 'widens', 'opens', 'make', 'broadens', 'a'),
(53, 'Why don’t you make it bigger and more careful to ____ people’s attention?', 'raise', 'attract', 'make', 'keep', 'b'),
(54, ': Body language is a potent form of ____ communication.', 'verbal', 'non-verbal', 'tongue', 'oral', 'b'),
(55, ': These children often share their ____ secrets with their mother.', 'personally', 'person', 'personal', 'personable', 'c'),
(56, 'Stress and tiredness often lead to lack of ____.', 'concentrate', 'concentration', 'concentrated', 'concentrator', 'b'),
(57, 'It was ____ easy for him to learn baseball because he had been a cricket player.', 'purposefully', 'exceedingly', 'relatively', 'normally', 'c'),
(58, 'It was found that he lacked the ____ to pursue a difficult task to the very end.', 'holiday', 'house', 'free', 'decrease', 'b'),
(59, 'I can’t stand the car ____.Therefore, I hate traveling by car.', 'illness', 'sickness', 'ailment', 'disease', 'b'),
(60, 'I ____ hope there won’t be a repetition of these unfortunate events.', 'bitterly', 'sincerely', 'unfailingly', 'completely', 'b'),
(61, 'There was ____ evidence to bring charges against the man.', 'ineffective', 'inadvisable', 'interior', 'insufficient', 'd'),
(62, 'I’d love to try and make that cake. Have you got a(n) ____ for it?', 'receipt', 'prescription', 'ingredient', 'recipe', 'd'),
(63, 'You’ve got to be ____ certain before you decide.', 'deadly', 'deathly', 'dead', 'dearly', 'c'),
(64, 'If you put your money in a bank now, you may get 12% ____ annually.', 'interest', 'profit', 'money', 'income', 'a'),
(65, 'I can’t possibly lend you any more money, it is quite out of the ____.', 'order', 'practice', 'place', 'question ', 'd'),
(66, 'The mirror was ____ broken.', 'accidental', 'by accident', 'accidentally', 'determination ', 'c'),
(67, 'It is very difficult to ____ the exact meaning of an idiom in a foreign language.', 'exert', 'convert', 'transfer', 'convey ', 'd'),
(68, 'No matter how angry he was, he would never ____ to violence.', 'exert', 'resolve', 'resort', 'recourse', 'c'),
(69, 'It never ____ my head that such a teưible thing would happen.', 'struck', 'dawned', 'occurred', 'entered ', 'd'),
(70, 'Dogs make very ____ pets. They will always stay by your side.', 'mental', 'private', 'loyal', 'digital', 'c');

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=71;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
