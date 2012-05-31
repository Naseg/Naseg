-- phpMyAdmin SQL Dump
-- version 3.3.7deb5build0.10.10.1
-- http://www.phpmyadmin.net
--
-- Host: test.liquidpub.org:3306
-- Versione MySQL: 5.0.51
-- Versione PHP: 5.3.3-1ubuntu9.10

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `phdcourse`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `countries`
--

CREATE TABLE IF NOT EXISTS `countries` (
  `country_ID` int(11) NOT NULL auto_increment,
  `name` varchar(255) character set latin1 NOT NULL default 'UNKNOWN',
  `region` varchar(200) character set latin1 NOT NULL default 'UNKNOWN',
  `citizenship` varchar(255) character set latin1 NOT NULL default 'UNKNOWN',
  `deleted` tinyint(1) NOT NULL default '0',
  PRIMARY KEY  (`country_ID`),
  UNIQUE KEY `name_countries_UNIQUE` (`name`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Dump dei dati per la tabella `countries`
--

INSERT INTO `countries` (`country_ID`, `name`, `region`, `citizenship`, `deleted`) VALUES
(1, 'Italy', 'Europe', 'Italian', 0),
(2, 'USA', 'North America', 'American', 0);

-- --------------------------------------------------------

--
-- Struttura della tabella `courses`
--

CREATE TABLE IF NOT EXISTS `courses` (
  `course_ID` int(11) NOT NULL auto_increment,
  `notes` text character set latin1,
  `actual_start_date` date default NULL,
  `institution` varchar(255) character set latin1 NOT NULL default 'UNKNOWN',
  `place` varchar(255) character set latin1 NOT NULL default 'UNKNOWN',
  `credits` int(11) default '0',
  `course_name` varchar(200) character set latin1 NOT NULL default 'UNKNOWN',
  `academic_year` int(11) NOT NULL default '0',
  `is_in_manifesto` tinyint(1) NOT NULL default '0',
  `is_by_UNITN` tinyint(1) NOT NULL default '0',
  `is_paid` tinyint(1) default NULL,
  `budgeted_cost` int(11) NOT NULL default '0',
  `actual_cost` int(11) NOT NULL default '0',
  `planned_course_period` varchar(255) character set latin1 NOT NULL default 'UNKNOWN' COMMENT 'EG summer 2013',
  `are_all_marks_defined` tinyint(1) NOT NULL default '0' COMMENT 'have all students been graded?',
  `url` varchar(255) character set latin1 NOT NULL default 'UNKNOWN',
--  `votespage` varchar(255) character set latin1 NOT NULL default 'UNKNOWN',
  `is_payment_completed` tinyint(1) NOT NULL default '0' COMMENT 'did the guy get the money?',
  `deleted` tinyint(1) NOT NULL default '0',
  `professor` int(11) default NULL,
  PRIMARY KEY  (`course_ID`),
  KEY `Professor` (`professor`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=12 ;

--
-- Dump dei dati per la tabella `courses`
--

INSERT INTO `courses` (`course_ID`, `notes`, `actual_start_date`, `institution`, `place`, `credits`, `course_name`, `academic_year`, `is_in_manifesto`, `is_by_UNITN`, `is_paid`, `budgeted_cost`, `actual_cost`, `planned_course_period`, `are_all_marks_defined`, `url`, `is_payment_completed`, `deleted`, `professor`) VALUES
(1, 'internal course / not started', NULL, 'University of Trento', 'Povo 0, room 202', 3, 'Web Engineering', 2013, 1, 1, 1, 1000, 0, 'Summer 2013', 0, 'http://summer-course.org', 0, 0, 2),
(2, 'external course', NULL, 'University of Bolzano', 'Bolzano', 3, 'Human Computer Interaction', 2013, 1, 0, 0, 0, 0, 'UNKNOWN', 0, 'http://bolzano-courses.edu/hci', 0, 0, 2),
(3, 'internal course / started', '2013-04-05', 'Universiti of Trento', 'Povo 1, room 12', 3, 'Research Methodology II', 2013, 1, 1, 1, 3000, 0, 'Spring 2013', 0, 'http://research-methodology.net', 0, 0, 2),
(4, 'internal course / finished', '2013-02-01', 'University of Trento', 'Povo 0, room Ofek', 3, 'Research Methodology I', 2013, 1, 1, 1, 5000, 4500, 'Winter 2013', 0, 'http://research-methodology.net', 0, 0, 3),
(5, 'internal course / finished', NULL, 'Università', 'Trento', 3, 'Data and Knowledge Management', 2013, 1, 1, NULL, 10000, 8000, 'Ottobre 2013', 0, 'http://unitn.it/datamanagement', 0, 0, 3),
(6, 'internal course / finished', NULL, 'Università', 'Trento', 3, 'Signal Processing And Recognition', 2013, 1, 0, NULL, 10000, 8000, 'Ottobre 2013', 0, 'http://unitn.it/signalrecog', 0, 0, 3),
(7, 'internal course / finished', NULL, 'Università', 'Trento', 3, 'Remote and Distributed Sensing', 2013, 1, 1, NULL, 10000, 8000, 'Ottobre 2013', 0, 'http://unitn.it/remotesensing', 0, 0, 4),
(8, 'internal course / finished', NULL, 'Università', 'Trento', 3, 'Nano And Microsystems', 2013, 1, 1, NULL, 10000, 8000, 'Ottobre 2013', 0, 'http://unitn.it/nanosystem', 0, 0, 4),
(9, 'internal course / finished', NULL, 'Università', 'Trento', 3, 'End user design', 2013, 1, 0, NULL, 10000, 8000, 'Ottobre 2013', 0, 'http://unitn.it/enduser', 0, 0, 4),
(10, 'internal course / finished', NULL, 'Università', 'Trento', 3, 'Geovisualisation', 2013, 1, 1, NULL, 10000, 8000, 'Ottobre 2013', 0, 'http://unitn.it/geovisualization', 0, 0, 7),
(11, 'internal course / not started', NULL, 'University of Trento', 'Povo 0, room 202', 3, 'Web Engineering', 2012, 1, 1, 1, 1000, 0, 'Summer 2012', 1, 'http://summer-course.org', 0, 0, 2),
(12, 'external course', NULL, 'University of Bolzano', 'Bolzano', 3, 'Human Computer Interaction', 2012, 1, 0, 0, 0, 0, 'UNKNOWN', 1, 'http://bolzano-courses.edu/hci', 0, 0, 2),
(13, 'internal course / started', '2012-04-05', 'Universiti of Trento', 'Povo 1, room 12', 3, 'Research Methodology II', 2012, 1, 1, 1, 3000, 0, 'Spring 2012', 1, 'http://research-methodology.net', 0, 0, 2),
(14, 'internal course / finished', '2012-02-01', 'University of Trento', 'Povo 0, room Ofek', 3, 'Research Methodology I', 2012, 1, 1, 1, 5000, 4500, 'Winter 2012', 1, 'http://research-methodology.net', 0, 0, 3),
(15, 'internal course / finished', NULL, 'Università', 'Trento', 3, 'Data and Knowledge Management', 2012, 1, 1, NULL, 10000, 8000, 'Ottobre 2012', 1, 'http://unitn.it/datamanagement', 0, 0, 3),
(16, 'internal course / finished', NULL, 'Università', 'Trento', 3, 'Signal Processing And Recognition', 2012, 1, 0, NULL, 10000, 8000, 'Ottobre 2012', 1, 'http://unitn.it/signalrecog', 0, 0, 3),
(17, 'internal course / finished', NULL, 'Università', 'Trento', 3, 'Remote and Distributed Sensing', 2012, 1, 1, NULL, 10000, 8000, 'Ottobre 2012', 1, 'http://unitn.it/remotesensing', 0, 0, 4),
(18, 'internal course / finished', NULL, 'Università', 'Trento', 3, 'Nano And Microsystems', 2012, 1, 1, NULL, 10000, 8000, 'Ottobre 2012', 1, 'http://unitn.it/nanosystem', 0, 0, 4),
(19, 'internal course / finished', NULL, 'Università', 'Trento', 3, 'End user design', 2012, 1, 0, NULL, 10000, 8000, 'Ottobre 2012', 1, 'http://unitn.it/enduser', 0, 0, 4),
(20, 'internal course / finished', NULL, 'Università', 'Trento', 3, 'Geovisualisation', 2012, 1, 1, NULL, 10000, 8000, 'Ottobre 2012', 1, 'http://unitn.it/geovisualization', 0, 0, 7),
(21, 'internal course / not started', NULL, 'University of Trento', 'Povo 0, room 202', 3, 'Web Engineering', 2011, 1, 1, 1, 1000, 0, 'Summer 2011', 1, 'http://summer-course.org', 0, 0, 2),
(22, 'external course', NULL, 'University of Bolzano', 'Bolzano', 3, 'Human Computer Interaction', 2011, 1, 0, 0, 0, 0, 'UNKNOWN', 1, 'http://bolzano-courses.edu/hci', 0, 0, 2),
(23, 'internal course / started', '2011-04-05', 'Universiti of Trento', 'Povo 1, room 12', 3, 'Research Methodology II', 2011, 1, 1, 1, 3000, 0, 'Spring 2011', 1, 'http://research-methodology.net', 0, 0, 2),
(24, 'internal course / finished', '2011-02-01', 'University of Trento', 'Povo 0, room Ofek', 3, 'Research Methodology I', 2011, 1, 1, 1, 5000, 4500, 'Winter 2011', 1, 'http://research-methodology.net', 0, 0, 3),
(25, 'internal course / finished', NULL, 'Università', 'Trento', 3, 'Data and Knowledge Management', 2011, 1, 1, NULL, 10000, 8000, 'Ottobre 2011', 1, 'http://unitn.it/datamanagement', 0, 0, 3),
(26, 'internal course / finished', NULL, 'Università', 'Trento', 3, 'Signal Processing And Recognition', 2011, 1, 0, NULL, 10000, 8000, 'Ottobre 2011', 1, 'http://unitn.it/signalrecog', 0, 0, 3),
(27, 'internal course / finished', NULL, 'Università', 'Trento', 3, 'Remote and Distributed Sensing', 2011, 1, 1, NULL, 10000, 8000, 'Ottobre 2011', 1, 'http://unitn.it/remotesensing', 0, 0, 4),
(28, 'internal course / finished', NULL, 'Università', 'Trento', 3, 'Nano And Microsystems', 2011, 1, 1, NULL, 10000, 8000, 'Ottobre 2011', 1, 'http://unitn.it/nanosystem', 0, 0, 4),
(29, 'internal course / finished', NULL, 'Università', 'Trento', 3, 'End user design', 2011, 1, 0, NULL, 10000, 8000, 'Ottobre 2011', 1, 'http://unitn.it/enduser', 0, 0, 4),
(30, 'internal course / finished', NULL, 'Università', 'Trento', 3, 'Geovisualisation', 2011, 1, 1, NULL, 10000, 8000, 'Ottobre 2011', 1, 'http://unitn.it/geovisualization', 0, 0, 7);



-- --------------------------------------------------------

--
-- Struttura della tabella `courses_enrollments`
--

CREATE TABLE IF NOT EXISTS `courses_enrollments` (
  `enrollment_ID` int(11) NOT NULL auto_increment,
  `qualification` varchar(30) character set latin1 NOT NULL default 'UNKNOWN',
  `is_finished` tinyint(1) default NULL,
  `credits` int(11) default NULL,
  `enrolled_at` datetime default NULL,
  `updated_at` datetime default NULL,
  `course` int(11) NOT NULL,
  `student` int(11) NOT NULL,
  `approved_at` datetime default NULL,
  PRIMARY KEY  (`enrollment_ID`),
  KEY `index_courses_users_on_course_id` (`qualification`),
  KEY `index_courses_users_on_user_id` (`is_finished`),
  KEY `index_courses_users_on_course_id_and_user_id` (`qualification`,`is_finished`),
  KEY `fk_courses_enrollments_courses1` (`course`),
  KEY `fk_courses_enrollments_students1` (`student`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=10 ;

--
-- Dump dei dati per la tabella `courses_enrollments`
--

INSERT INTO `courses_enrollments` (`enrollment_ID`, `qualification`, `is_finished`, `credits`, `enrolled_at`, `updated_at`, `course`, `student`, `approved_at`) VALUES
(1, 'none', NULL, 0, '2012-05-04 00:00:00', NULL, 3, 1, NULL),
(2, 'none', NULL, 0, '2012-05-04 00:00:00', NULL, 5, 1, NULL),
(3, 'none', NULL, 0, '2012-05-04 00:00:00', NULL, 7, 1, NULL),
(4, 'none', NULL, 0, '2012-05-04 00:00:00', NULL, 1, 2, NULL),
(5, 'none', NULL, 0, '2012-05-04 00:00:00', NULL, 2, 2, NULL),
(6, 'none', NULL, 0, '2012-05-04 00:00:00', NULL, 3, 2, NULL),
(8, 'none', NULL, 0, '2012-05-07 00:00:00', NULL, 7, 3, NULL),
(9, 'none', NULL, 0, '2012-05-07 00:00:00', NULL, 8, 3, NULL),
(10, 'none', NULL, 0, '2012-05-07 00:00:00', NULL, 10, 3, NULL),
(11, 'none', NULL, 0, '2012-05-07 00:00:00', NULL, 2, 3, NULL),
(12, 'none', NULL, 0, '2012-05-07 00:00:00', NULL, 1, 4, NULL),
(13, 'none', NULL, 0, '2012-05-07 00:00:00', NULL, 5, 4, NULL),
(14, 'none', NULL, 0, '2012-05-07 00:00:00', NULL, 3, 4, NULL),
(15, 'none', NULL, 0, '2012-05-07 00:00:00', NULL, 7, 5, NULL),
(16, 'none', NULL, 0, '2012-05-07 00:00:00', NULL, 6, 5, NULL),
(17, 'none', NULL, 0, '2012-05-07 00:00:00', NULL, 2, 5, NULL),
(18, 'none', NULL, 0, '2012-05-07 00:00:00', NULL, 10, 6, NULL),
(19, 'none', NULL, 0, '2012-05-07 00:00:00', NULL, 4, 6, NULL),
(20, 'none', NULL, 0, '2012-05-07 00:00:00', NULL, 3, 6, NULL),
(21, 'none', NULL, 0, '2012-05-07 00:00:00', NULL, 1, 7, NULL),
(22, 'none', NULL, 0, '2012-05-07 00:00:00', NULL, 2, 7, NULL),
(23, 'none', NULL, 0, '2012-05-07 00:00:00', NULL, 3, 7, NULL),
(24, 'none', NULL, 0, '2012-05-07 00:00:00', NULL, 5, 8, NULL),
(25, 'none', NULL, 0, '2012-05-07 00:00:00', NULL, 3, 8, NULL),
(26, 'none', NULL, 0, '2012-05-07 00:00:00', NULL, 8, 8, NULL),
(27, 'none', NULL, 0, '2012-05-07 00:00:00', NULL, 3, 9, NULL),
(28, 'none', NULL, 0, '2012-05-07 00:00:00', NULL, 4, 9, NULL),
(29, 'none', NULL, 0, '2012-05-07 00:00:00', NULL, 8, 9, NULL),
(30, 'none', NULL, 0, '2012-05-07 00:00:00', NULL, 2, 10, NULL),
(31, 'none', NULL, 0, '2012-05-07 00:00:00', NULL, 3, 10, NULL),
(32, 'none', NULL, 0, '2012-05-07 00:00:00', NULL, 8, 10, NULL),
(33, '26', NULL, 3, '2011-05-07 00:00:00', NULL, 21, 4, NULL),
(34, '10', NULL, 0, '2011-05-07 00:00:00', NULL, 25, 4, NULL),
(35, '24', NULL, 3, '2011-05-07 00:00:00', NULL, 23, 4, NULL),
(36, '--', NULL, 0, '2011-05-07 00:00:00', NULL, 22, 4, NULL),
(37, '30', NULL, 3, '2011-05-07 00:00:00', NULL, 26, 4, NULL),
(38, '18', NULL, 3, '2011-05-07 00:00:00', NULL, 28, 4, NULL),
(39, '25', NULL, 3, '2011-05-07 00:00:00', NULL, 30, 4, NULL),
(40, '26', NULL, 3, '2011-05-07 00:00:00', NULL, 21, 5, NULL),
(41, '10', NULL, 0, '2011-05-07 00:00:00', NULL, 24, 5, NULL),
(42, '24', NULL, 3, '2011-05-07 00:00:00', NULL, 23, 5, NULL),
(43, '--', NULL, 0, '2011-05-07 00:00:00', NULL, 26, 5, NULL),
(44, '30', NULL, 3, '2011-05-07 00:00:00', NULL, 27, 5, NULL),
(45, '18', NULL, 3, '2011-05-07 00:00:00', NULL, 28, 5, NULL),
(46, '25', NULL, 3, '2011-05-07 00:00:00', NULL, 30, 5, NULL),
(47, '26', NULL, 3, '2011-05-07 00:00:00', NULL, 24, 6, NULL),
(48, '10', NULL, 0, '2011-05-07 00:00:00', NULL, 27, 6, NULL),
(49, '24', NULL, 3, '2011-05-07 00:00:00', NULL, 26, 6, NULL),
(50, '--', NULL, 0, '2011-05-07 00:00:00', NULL, 23, 6, NULL),
(51, '30', NULL, 3, '2011-05-07 00:00:00', NULL, 22, 6, NULL),
(52, '18', NULL, 3, '2011-05-07 00:00:00', NULL, 29, 6, NULL),
(53, '25', NULL, 3, '2011-05-07 00:00:00', NULL, 25, 6, NULL),
(54, '26', NULL, 3, '2010-05-07 00:00:00', NULL, 21, 7, NULL),
(55, '10', NULL, 0, '2010-05-07 00:00:00', NULL, 25, 7, NULL),
(56, '24', NULL, 3, '2010-05-07 00:00:00', NULL, 23, 7, NULL),
(57, '--', NULL, 0, '2010-05-07 00:00:00', NULL, 22, 7, NULL),
(58, '30', NULL, 3, '2010-05-07 00:00:00', NULL, 26, 7, NULL),
(59, '18', NULL, 3, '2010-05-07 00:00:00', NULL, 28, 7, NULL),
(60, '25', NULL, 3, '2010-05-07 00:00:00', NULL, 20, 7, NULL),
(61, '26', NULL, 3, '2010-05-07 00:00:00', NULL, 21, 9, NULL),
(62, '30', NULL, 3, '2010-05-07 00:00:00', NULL, 27, 9, NULL),
(63, '18', NULL, 3, '2010-05-07 00:00:00', NULL, 28, 9, NULL),
(64, '25', NULL, 3, '2010-05-07 00:00:00', NULL, 30, 9, NULL),
(65, '26', NULL, 3, '2010-05-07 00:00:00', NULL, 24, 8, NULL),
(66, '10', NULL, 0, '2010-05-07 00:00:00', NULL, 27, 8, NULL),
(67, '24', NULL, 3, '2010-05-07 00:00:00', NULL, 26, 8, NULL),
(68, '--', NULL, 0, '2010-05-07 00:00:00', NULL, 23, 8, NULL),
(69, '30', NULL, 3, '2010-05-07 00:00:00', NULL, 22, 8, NULL),
(70, '18', NULL, 3, '2010-05-07 00:00:00', NULL, 29, 8, NULL),
(71, '25', NULL, 3, '2010-05-07 00:00:00', NULL, 25, 8, NULL),
(72, '26', NULL, 3, '2010-05-07 00:00:00', NULL, 24, 10, NULL),
(73, '10', NULL, 0, '2010-05-07 00:00:00', NULL, 27, 10, NULL),
(74, '24', NULL, 3, '2010-05-07 00:00:00', NULL, 26, 10, NULL),
(75, '--', NULL, 0, '2010-05-07 00:00:00', NULL, 23, 10, NULL),
(76, '30', NULL, 3, '2010-05-07 00:00:00', NULL, 22, 10, NULL),
(77, '18', NULL, 3, '2010-05-07 00:00:00', NULL, 29, 10, NULL),
(78, '25', NULL, 3, '2010-05-07 00:00:00', NULL, 25, 10, NULL),
(79, 'A', NULL, 3, '2011-05-07 00:00:00', NULL, 11, 7, NULL),
(80, 'nan', NULL, 0, '2011-05-07 00:00:00', NULL, 13, 7, NULL),
(81, 'good', NULL, 3, '2011-05-07 00:00:00', NULL, 18, 7, NULL),
(82, '14', NULL, 0, '2011-05-07 00:00:00', NULL, 15, 8, NULL),
(83, '15', NULL, 0, '2011-05-07 00:00:00', NULL, 14, 8, NULL),
(84, '21', NULL, 3, '2011-05-07 00:00:00', NULL, 16, 8, NULL),
(85, 'T', NULL, 0, '2011-05-07 00:00:00', NULL, 17, 10, NULL),
(86, 'B', NULL, 3, '2011-05-07 00:00:00', NULL, 12, 10, NULL),
(87, '10', NULL, 0, '2011-05-07 00:00:00', NULL, 20, 10, NULL);
-- --------------------------------------------------------

--
-- Struttura della tabella `funding_institutions`
--

CREATE TABLE IF NOT EXISTS `funding_institutions` (
  `funding_institution_ID` int(11) NOT NULL auto_increment,
  `name` varchar(200) character set latin1 NOT NULL default 'UNKNOWN' COMMENT 'Who pays their scholarship',
  `deleted` tinyint(1) NOT NULL default '0',
  `type` varchar(20) character set latin1 NOT NULL default 'UNKNOWN',
  PRIMARY KEY  (`funding_institution_ID`),
  UNIQUE KEY `funding_institution_name_UNIQUE` (`name`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

--
-- Dump dei dati per la tabella `funding_institutions`
--

INSERT INTO `funding_institutions` (`funding_institution_ID`, `name`, `deleted`, `type`) VALUES
(1, 'DISI', 0, 'internal'),
(2, 'DIGI', 0, 'internal'),
(3, 'Telecom Italia', 0, 'external'),
(4, 'FBK', 0, 'external');

-- --------------------------------------------------------

--
-- Struttura della tabella `students`
--

CREATE TABLE IF NOT EXISTS `students` (
  `user_ID` int(11) NOT NULL auto_increment,
  `first_name` varchar(120) character set latin1 NOT NULL default 'UNKNOWN' COMMENT 'First and middle name',
  `last_name` varchar(300) character set latin1 NOT NULL default 'UNKNOWN' COMMENT 'family name',
  `full_name` varchar(500) character set latin1 NOT NULL default 'UNKNOWN' COMMENT 'name as we want it displayed',
  `phd_cycle` varchar(10) character set latin1 NOT NULL default 'UNKNOWN',
  `is_suspended` tinyint(1) NOT NULL default '0',
  `course_year` int(3) NOT NULL default '0' COMMENT '1,2,3,4,5',
  `admitted_conditionally` tinyint(1) NOT NULL default '0',
  `legal_residence` varchar(500) character set latin1 NOT NULL default 'UNKNOWN',
  `current_domicile` varchar(500) character set latin1 NOT NULL default 'UNKNOWN',
  `date_of_birth` date default NULL,
  `place_of_birth` varchar(300) character set latin1 NOT NULL default 'UNKNOWN',
  `office_phone` varchar(100) character set latin1 NOT NULL default 'UNKNOWN',
  `mobile_phone` varchar(100) character set latin1 NOT NULL default 'UNKNOWN',
  `office_working_place` varchar(200) character set latin1 NOT NULL default 'UNKNOWN' COMMENT 'P1-S5-14 (Pvo1 - Open space 5 - desk 14)',
  `locker_number` varchar(60) character set latin1 NOT NULL default 'UNKNOWN',
  `phd_scholarship` tinyint(1) default NULL,
  `scholarship_type` varchar(500) character set latin1 NOT NULL default 'UNKNOWN' COMMENT 'Specify name of the grant + fund number',
  `yearly_fee_to_center` int(6) NOT NULL default '0',
  `yearly_fee_to_school` int(6) NOT NULL default '0',
  `has_pc_rights` tinyint(1) NOT NULL default '0' COMMENT 'Has the right to receive a pc?',
  `pre_doctoral_scholarship` varchar(500) character set latin1 default NULL COMMENT 'Specify name fund + fund number ',
  `months_predoc_scholarship` int(2) NOT NULL default '0' COMMENT 'Nr. months of predoc scholarship - maximum 6 months',
  `year_extension_scholarship` varchar(100) character set latin1 NOT NULL default '0' COMMENT 'Specify name fund + fund number',
  `months` int(2) NOT NULL default '0' COMMENT 'maximum 12 months',
  `personal_funds_available` int(10) NOT NULL default '0' COMMENT '750 granted at registration, other 750 when admitted to the second yr',
  `is_graduated` tinyint(1) NOT NULL default '0',
  `graduation_date` date default NULL,
  `commitee_members` varchar(20) character set latin1 NOT NULL default 'UNKNOWN' COMMENT 'Commitee members separated by comma',
  `email` varchar(200) character set latin1 NOT NULL default 'UNKNOWN',
  `deleted` tinyint(1) NOT NULL default '0',
  `funding_institution` int(11) NOT NULL COMMENT 'DISI, UNITN, Fbk...ecc',
  `university` int(11) NOT NULL,
  `country_of_provenance` int(11) NOT NULL,
  `university_of_provenance` int(11) NOT NULL,
  `citizenship` int(11) NOT NULL,
  `current_advisor` int(11) NOT NULL,
  `tutor` int(11) NOT NULL,
  `funds_owner` int(11) NOT NULL,
  `Italian_Taxpayer_Code` int(11) default NULL,
  `photo_profile` varchar(255) default NULL,
  `is_plan_approved` tinyint(4) default NULL,
  `user` int(11) NOT NULL,
  PRIMARY KEY  (`user_ID`),
  KEY `fk_students_universities` (`university`),
  KEY `fk_funding_institution` (`funding_institution`),
  KEY `fk_students_countries1` (`country_of_provenance`),
  KEY `fk_student_university_provenance` (`university_of_provenance`),
  KEY `fk_student_citizenship` (`citizenship`),
  KEY `fk_students_supervisors1` (`current_advisor`),
  KEY `fk_students_supervisors2` (`tutor`),
  KEY `fk_students_supervisors3` (`funds_owner`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=11 ;

--
-- Dump dei dati per la tabella `students`
--

INSERT INTO `students` (`user_ID`, `first_name`, `last_name`, `full_name`, `phd_cycle`, `is_suspended`, `course_year`, `admitted_conditionally`, `legal_residence`, `current_domicile`, `date_of_birth`, `place_of_birth`, `office_phone`, `mobile_phone`, `office_working_place`, `locker_number`, `phd_scholarship`, `scholarship_type`, `yearly_fee_to_center`, `yearly_fee_to_school`, `has_pc_rights`, `pre_doctoral_scholarship`, `months_predoc_scholarship`, `year_extension_scholarship`, `months`, `personal_funds_available`, `is_graduated`, `graduation_date`, `commitee_members`, `email`, `deleted`, `funding_institution`, `university`, `country_of_provenance`, `university_of_provenance`, `citizenship`, `current_advisor`, `tutor`, `funds_owner`, `Italian_Taxpayer_Code`, `photo_profile`, `is_plan_approved`, `user`) VALUES
(1, 'John Erik', 'Smith', 'John E. Smith', '28', 0, 1, 0, 'via manci 27, Trento', '', '1998-10-12', 'New York, NY, USA', '123-456789', '1231-23456', 'P1-S5-14', '27-A', 0, 'UNKNOWN', 0, 0, 0, NULL, 0, '0', 0, 121424, 0, NULL, 'UNKNOWN', 'pollo1_91@yahoo.it', 0, 1, 1, 1, 1, 1, 1, 1, 1, NULL, NULL, 0, 8),
(2, 'Gordon', 'Ramsay', 'Gordon Ramsay', '0', 0, 1, 0, 'Digite', 'Unitn', '1990-10-01', 'Unitn, IT', '+39-1234-123456', '123-12345687', 'P1-S1-01', '01-A', 0, 'PRESIDENZA', 0, 0, 0, '0', 0, '0', 0, 1231, 1, NULL, '--', 'ramsay@unitn.com', 0, 2, 2, 1, 2, 1, 1, 1, 2, NULL, NULL, 0, 9),
(3, 'Augusto', 'De Marinis', 'Augusto De Marinis', '0', 0, 1, 0, 'Unitn', 'Unitn', '1949-12-13', 'Unitn, IT', '+39-9876-987654', '987-9876543', 'P2-S2-01', '02-A', 0, 'DIREZIONE', 0, 0, 0, '0', 0, '0', 0, 1231231231, 1, NULL, '--', 'august.demarinis@unitn.com', 0, 2, 2, 1, 2, 1, 1, 1, 2, NULL, NULL, 0, 10),
(4, 'Guido', 'Geller', 'Guido Geller', '0', 0, 2, 0, 'Unitn', 'Unitn', '1957-03-09', 'Unitn, IT', '+39-2468-135790', '963-8527410', 'P2-S2-02', '02-B', 0, 'RESPONSABILE RISORSE UMANE', 0, 0, 0, '0', 0, '0', 0, 241, 1, NULL, 'PRESIDENTE', 'guido.geller@unitn.com', 0, 2, 2, 1, 2, 2, 2, 1, 2, NULL, NULL, 0, 11),
(5, 'Paolo', 'Bitta', 'Paolo Bitta', '1', 0, 2, 0, 'Unitn', 'Unitn', '1969-07-25', 'Camper Magazine, IT', '+39-1593-786420', '369-2581470', 'P3-S1-01', '03-A', 0, 'SCUOLA DI VITA PAOLO BITTA', 0, 0, 0, '0', 0, '0', 0, 1200, 0, NULL, 'De Marinis, Guido Ge', 'paolo.bitta@alfa.it', 0, 2, 2, 1, 2, 1, 5, 5, 2, NULL, NULL, 0, 12),
(6, 'Luca', 'Nervi', 'Luca Nervi', '1', 0, 2, 0, 'Unitn', 'Unitn', '1971-07-13', 'In un garage di Milano, IT', '+39-1479-632580', '357-1489620', 'P3-S1-02', '03-B', 0, 'drummare', 0, 0, 0, '0', 0, '0', 0, 1234, 0, NULL, 'De Marinis, Guido Ge', 'luca.nervi@tirchioni.it', 0, 2, 2, 1, 2, 1, 6, 6, 2, NULL, NULL, 0, 13),
(7, 'Silvano', 'Rogi', 'Silvano Rogi', '1', 0, 3, 0, 'Unitn', 'Unitn', '1971-08-12', 'Ufficio Contabile', '+39-1843-434299', '352-1489799', 'P2-S1-02', '02-B', 0, 'lamerare', 0, 0, 0, '0', 0, '0', 0, 0, 0, NULL, 'UNKNOWN', 'silvano.rogi@contabile.it', 0, 2, 2, 1, 2, 1, 6, 6, 2, NULL, NULL, 0, 14),
(8, 'Gary', 'Tizio', 'Gary Tizio', '1', 0, 3, 0, 'via rose 18, trento', 'Boh', '1980-08-12', 'Trento, IT', '+39-1479-632581', '357-1489621', 'P3-S1-03', '03-C', 0, 'CHI', 0, 0, 0, '0', 0, '0', 0, 0, 0, NULL, 'UNKNOWN', 'gary@libero.it', 0, 2, 2, 2, 2, 1, 5, 5, 2, NULL, NULL, 0, 15),
(9, 'Yep', 'Darpa', 'Yep Darpa', 'UNKNOWN', 1, 3, 0, 'UNKNOWN', 'UNKNOWN', NULL, 'UNKNOWN', 'UNKNOWN', 'UNKNOWN', 'UNKNOWN', 'UNKNOWN', NULL, 'UNKNOWN', 0, 0, 0, NULL, 0, '0', 0, 0, 0, NULL, 'UNKNOWN', 'yep@inpigiama.it', 0, 2, 2, 1, 2, 2, 3, 3, 2, NULL, NULL, 0, 16),
(10, 'Mario', 'Rossi', 'Mario Rossi', '1', 0, 3, 0, 'via hambuger 20, trento', 'UNKNOWN', '1980-07-12', 'Trento.IT', '32423', '234234234', '23432432', '34234', 0, 'fjofhaoeho', 0, 0, 0, '0', 0, '0', 0, 0, 0, '2012-01-01', 'ewiorwep', 'mariorossi@libero.it', 0, 2, 2, 1, 2, 2, 3, 2, 2, NULL, NULL, 0, 17);

-- --------------------------------------------------------

--
-- Struttura della tabella `supervisors`
--

CREATE TABLE IF NOT EXISTS `supervisors` (
  `supervisor_ID` int(11) NOT NULL auto_increment,
  `first_name` varchar(200) character set latin1 NOT NULL default 'UNKNOWN',
  `last_name` varchar(200) character set latin1 NOT NULL default 'UNKNOWN',
  `can_be_advisor` tinyint(1) NOT NULL default '0',
  `is_active` tinyint(1) NOT NULL default '0',
  `is_internal` tinyint(1) NOT NULL default '0',
  `email` varchar(200) character set latin1 NOT NULL default 'UNKNOWN',
  `deleted` tinyint(1) NOT NULL default '0',
  `user` int(11) NOT NULL,
  PRIMARY KEY  (`supervisor_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- Dump dei dati per la tabella `supervisors`
--

INSERT INTO `supervisors` (`supervisor_ID`, `first_name`, `last_name`, `can_be_advisor`, `is_active`, `is_internal`, `email`, `deleted`, `user`) VALUES
(1, 'Joe', 'Doe', 1, 1, 1, 'pole.matteo@gmail.com', 0, 1),
(2, 'Aldo', 'Meridio', 1, 1, 1, 'ggg@gmail.com', 0, 2),
(3, 'Marcello', 'Macchi', 1, 1, 1, 'macchi@unitn.com', 0, 3),
(4, 'Howard', 'Lovecraft', 1, 1, 1, 'lovecraft@unitn.com', 0, 4),
(5, 'Edgar', 'Poe', 1, 1, 1, 'poe@unitn.com', 0, 5),
(6, 'Reinhardt', 'Django', 1, 1, 1, 'django@unitn.com', 0, 6),
(7, 'Giuseppe', 'Mengoni', 1, 1, 1, 'mengoni@gmail.com', 0, 7);

-- --------------------------------------------------------

--
-- Struttura della tabella `trips`
--

CREATE TABLE IF NOT EXISTS `trips` (
  `trip_ID` int(11) NOT NULL auto_increment,
  `academic_year_id` int(11) default NULL,
  `Date_of_request` date default NULL,
  `Planned_start_date` date NOT NULL,
  `Planned_Reason_for_Travel` varchar(255) character set latin1 default NULL,
  `status` varchar(255) character set latin1 NOT NULL default 'UNKNOWN',
  `Planned_end_date` date NOT NULL,
  `Planned_destination` varchar(255) character set latin1 default NULL,
  `Planned_means_of_transport` varchar(255) character set latin1 default NULL,
  `is_stopover_requested` tinyint(1) default NULL,
  `Reason_for_extraordinary_transport` varchar(255) character set latin1 default NULL,
  `Reason_for_stopover` varchar(255) character set latin1 default NULL,
  `type_of_transportation` varchar(20) character set latin1 default NULL COMMENT 'ORDINARY or EXTRAORDINARY',
  `is_approved` tinyint(1) default NULL,
  `are_personal_funds_used` tinyint(1) default NULL COMMENT 'if used, date of request must be before oct 31st of the 3rd year',
  `personal_funds_amount` int(11) default NULL,
  `alternative_fund_1_name` varchar(100) character set latin1 default NULL,
  `alternative_fund_1_manager` int(11) default NULL,
  `alternative_fund_1_amount` int(11) default NULL,
  `alternative_fund_2_name` varchar(100) character set latin1 default NULL,
  `alternative_fund_2_amount` int(11) default NULL,
  `alternative_fund_2_manager` int(11) default NULL,
  `has_advisor_approved` tinyint(1) NOT NULL,
  `foreseen_meals_cost` float default NULL,
  `foreseen_lodging_cost` float default NULL,
  `foreseen_transportation_cost` float default NULL,
  `expenses_sustained_before_trip` float default NULL COMMENT 'eg flight ticket is bought before',
  `is_advance_payment_requested` tinyint(1) default NULL,
  `actual_begin_date_time` datetime default NULL,
  `actual_end_date_time` datetime default NULL,
  `departure_border_cross_datetime` datetime default NULL,
  `arrival_border_cross_datetime` datetime default NULL,
  `actual_destination` varchar(255) character set latin1 default NULL,
  `current_address` varchar(255) character set latin1 NOT NULL default 'UNKNOWN',
  `advance_payment_received` float default NULL,
  `requested_payment_method` varchar(100) character set latin1 default NULL COMMENT 'ENUM. almost always is BANK ACCOUNT',
  `self_declaration_missing_recepits` text character set latin1,
  `other_declarations` text character set latin1,
  `Travel_tickets` text character set latin1,
  `personal_veichle_KM_travelled` int(11) default NULL,
  `personal_veichle_colleagues` varchar(255) character set latin1 default NULL,
  `highway_toll_fees` float default NULL,
  `total_transport_expenses` float default '0',
  `total_lodging_expenses` float default '0',
  `number_of_nights` int(11) default NULL,
  `num_lodging_receipts` int(11) default NULL,
  `num_meals_invoices` int(11) default NULL,
  `num_days_of_meals` int(11) default NULL,
  `total_meal_expenses` float default NULL,
  `registration_fee` float default NULL,
  `other_costs_amount` float default '0',
  `other_costs_description` int(11) default NULL,
  `total_expenses` float default '0',
  `created_at` datetime default NULL,
  `updated_at` datetime default NULL,
  `reimb_transport_expenses` float default '0',
  `date_reim_request_submitted` date default NULL,
  `reimb_lodging_expenses` float default '0',
  `reimb_extra_costs` float default '0',
  `deleted` tinyint(1) NOT NULL default '0',
  `student` int(11) NOT NULL,
  `has_coord_approved` tinyint(1) NOT NULL,
  `has_fund_1_mgr_approved` tinyint(1) NOT NULL default '0',
  `has_fund_2_mgr_approved` tinyint(1) NOT NULL default '0',
  PRIMARY KEY  (`trip_ID`),
  KEY `index_travels_on_academic_year_id` (`academic_year_id`),
  KEY `index_travels_on_status` (`status`),
  KEY `index_travels_on_begin_date` (`actual_begin_date_time`),
  KEY `index_travels_on_end_date` (`actual_end_date_time`),
  KEY `index_travels_on_total_expenses` (`total_expenses`),
  KEY `index_travels_on_approved` (`is_approved`),
  KEY `fk_travels_users1` (`student`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=77 ;

--
-- Dump dei dati per la tabella `trips`
--

INSERT INTO `trips` (`trip_ID`, `academic_year_id`, `Date_of_request`, `Planned_start_date`, `Planned_Reason_for_Travel`, `status`, `Planned_end_date`, `Planned_destination`, `Planned_means_of_transport`, `is_stopover_requested`, `Reason_for_extraordinary_transport`, `Reason_for_stopover`, `type_of_transportation`, `is_approved`, `are_personal_funds_used`, `personal_funds_amount`, `alternative_fund_1_name`, `alternative_fund_1_manager`, `alternative_fund_1_amount`, `alternative_fund_2_name`, `alternative_fund_2_amount`, `alternative_fund_2_manager`, `has_advisor_approved`, `foreseen_meals_cost`, `foreseen_lodging_cost`, `foreseen_transportation_cost`, `expenses_sustained_before_trip`, `is_advance_payment_requested`, `actual_begin_date_time`, `actual_end_date_time`, `departure_border_cross_datetime`, `arrival_border_cross_datetime`, `actual_destination`, `current_address`, `advance_payment_received`, `requested_payment_method`, `self_declaration_missing_recepits`, `other_declarations`, `Travel_tickets`, `personal_veichle_KM_travelled`, `personal_veichle_colleagues`, `highway_toll_fees`, `total_transport_expenses`, `total_lodging_expenses`, `number_of_nights`, `num_lodging_receipts`, `num_meals_invoices`, `num_days_of_meals`, `total_meal_expenses`, `registration_fee`, `other_costs_amount`, `other_costs_description`, `total_expenses`, `created_at`, `updated_at`, `reimb_transport_expenses`, `date_reim_request_submitted`, `reimb_lodging_expenses`, `reimb_extra_costs`, `deleted`, `student`, `has_coord_approved`, `has_fund_1_mgr_approved`, `has_fund_2_mgr_approved`) VALUES
(26, 2011, '2012-04-15', '2012-01-02', 'work', 'ACCEPT', '2012-02-01', 'Italy', 'bus', 0, 'keep to the class', 'CALIFORNIA', 'plane', 0, 1, 700, NULL, NULL, NULL, NULL, NULL, NULL, 0, 234, 234, 234, 3545, 0, '2012-04-28 00:00:00', '2012-04-28 00:00:00', '2012-02-02 10:22:00', '2012-01-02 10:22:00', 'naples', 'via manci 27, Trento', 2.22222e+06, 'Bank Account', NULL, 'non lo voglio', 'ticket', 22222, '2222', 22.22, NULL, 22.22, 22, 22, 22, 22, 22.22, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2012-05-10', NULL, NULL, 0, 7, 1, 0, 0),
(32, 2012, '2012-04-26', '2012-10-14', 'work', 'REFUSE', '2012-11-14', 'Italy', 'bus', 0, 'keep to the class', 'CALIFORNIA', 'plane', 0, 1, 700, NULL, NULL, NULL, NULL, NULL, NULL, 0, 6456, 3141, 534, 232, 0, '2012-04-28 00:00:00', '2012-04-28 00:00:00', '2012-02-02 10:22:00', '2012-01-02 10:22:00', 'naples', 'via manci 27, Trento', 2.22222e+06, 'Bank Account', ' ', 'non lo voglio', 'ticket', 22222, '2222', 22.22, NULL, 22.22, 22, 22, 22, 22, 22.22, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2012-05-10', NULL, NULL, 1, 1, 1, 1, 0),
(33, 2012, '2012-04-26', '2012-10-14', 'work', 'INWAIT', '2012-11-14', 'Italy', 'bus', 0, 'keep to the class', 'CALIFORNIA', 'plane', 0, 1, 700, NULL, NULL, NULL, NULL, NULL, NULL, 0, 242, 645, 234, 3543, 0, '2012-04-28 00:00:00', '2012-04-28 00:00:00', '2012-02-02 10:22:00', '2012-01-02 10:22:00', 'rome', 'via manci 27, Trento', 2.22222e+06, 'Bank Account', ' ', 'non lo voglio', 'ticket', 22222, '2222', 22.22, NULL, 22.22, 22, 22, 22, 22, 22.22, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2012-05-10', NULL, NULL, 1, 5, 0, 0, 0),
(34, 2012, '2012-04-26', '1998-01-15', 'work', 'INWAIT', '2003-02-02', 'naples', 'bus', 0, 'keep to the class', 'Aperitivo', 'plane', 0, 1, 264, NULL, NULL, NULL, NULL, NULL, NULL, 0, 123, 345, 234, 2342, 0, '2012-04-28 00:00:00', '2012-04-28 00:00:00', '2012-04-28 00:00:00', '2012-04-28 00:00:00', 'naples', 'Via Piazza 9', 0, 'BANK', ' ', 'non lo voglio', 'ticket', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 5, 0, 0, 0),
(35, 2012, '2012-04-26', '1998-01-15', 'work', 'INWAIT', '2003-02-02', 'Italy', 'bus', 0, 'keep to the class', 'CALIFORNIA', 'plane', 0, 1, 700, NULL, NULL, NULL, NULL, NULL, NULL, 0, 245, 234, 534, 435, 0, '2012-04-28 00:00:00', '2012-04-28 00:00:00', '2012-02-02 10:22:00', '2012-01-02 10:22:00', 'naples', 'via manci 27, Trento', 2.22222e+06, 'Bank Account', ' ', 'non lo voglio', 'ticket', 22222, '2222', 22.22, NULL, 22.22, 22, 22, 22, 22, 22.22, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2012-05-10', NULL, NULL, 1, 5, 0, 0, 0),
(36, 2012, '2012-04-26', '2012-05-10', 'work', 'ACCEPT', '2012-06-15', 'rome', 'bus', 0, 'keep to the class', 'Aperitivo', 'plane', 0, 1, 700, '', NULL, NULL, NULL, NULL, NULL, 1, 100, 150, 234, 2342, 0, '2012-04-28 00:00:00', '2012-04-28 00:00:00', '2012-02-02 10:22:00', '2012-01-02 10:22:00', 'rome', 'via manci 27, Trento', 20000, 'MATTE CAZZO', ' ', 'non lo voglio', 'ticket', NULL, 'null', 0, 0, 10, 10, 10, 10, 10, 10, 11, 0, NULL, 0, '2012-04-28 11:24:36', '2012-04-28 11:24:36', 0, '2012-05-10', 0, 0, 0, 1, 1, 0, 0),
(37, 2012, '2012-04-15', '2013-01-01', 'work', 'INWAIT', '2013-02-02', 'Billund', 'taxi', 0, 'keep to the class', 'Aperitivo', 'plane', 0, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1000, 1000, 5000, 0, 0, '2012-04-30 11:17:25', '2012-04-30 11:17:25', '2012-04-30 11:17:25', '2012-04-30 11:17:25', 'rome', 'trento', 0, 'BANK', NULL, 'none', 'ticket', NULL, NULL, NULL, 0, 0, 43, NULL, NULL, NULL, NULL, 1, 0, NULL, 0, '2012-04-30 11:17:25', '2012-04-30 11:17:25', 0, '2012-04-30', 0, 0, 1, 1, 0, 0, 0),
(41, 2012, '2012-04-15', '2014-10-11', 'work', 'REFUSE', '2014-12-11', 'Billund', 'feet', 0, 'keep to the class', 'Aperitivo', 'plane', 0, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 123, 123, 123, 4123, 0, '2012-04-30 11:17:25', '2012-04-30 11:17:25', '2012-04-30 11:17:25', '2012-04-30 11:17:25', 'rome', 'trento', 0, 'BANK', NULL, 'none', 'ticket', NULL, NULL, NULL, 0, 0, 21, NULL, NULL, NULL, NULL, 123.1, 123.1, 12323, 0, NULL, NULL, 0, NULL, 0, 0, 0, 1, 1, 1, 0),
(42, 2012, '2012-04-15', '2015-10-11', 'chissà chi cambia i dati nei record??', 'INWAIT', '2015-12-11', 'prima o poi lo scopro', 'che', 1, 'Tahiti', 'Aperitivo', 'sono', 0, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 123.1, 123.1, 123.1, 0.1, 0, NULL, NULL, NULL, NULL, NULL, 'curioso', NULL, 'BANK', NULL, 'di', 'sapere perchè mai? XD', NULL, NULL, NULL, 0, 0, 21, NULL, NULL, NULL, NULL, 123.1, 123.1, 12323, 0, NULL, NULL, 0, NULL, 0, 0, 1, 1, 0, 0, 0),
(43, 2011, '2012-04-15', '2014-11-01', 'interesting reasons', 'INWAIT', '2015-01-01', 'N.Y.', 'bus', 1, 'Mancester', 'Aperitivo', 'plane', 0, 1, 12431, NULL, NULL, NULL, NULL, NULL, NULL, 1, 1121.31, 1313.13, 1221.2, 10, 0, NULL, NULL, NULL, NULL, NULL, 'trento', NULL, 'BANK', NULL, 'no comment', 'plane ticket number 1, etc..', NULL, NULL, NULL, 0, 0, 60, NULL, NULL, NULL, NULL, 131, 1311.31, 1, 0, NULL, NULL, 0, NULL, 0, 0, 1, 5, 0, 0, 0),
(44, 2011, '2012-04-15', '2016-01-11', 'reason', 'REFUSE', '2016-09-11', 'L.A.', 'car', 1, 'Lisbona', 'Aperitivo', 'plane', 0, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 12412, 21412, 1001, 0, 0, NULL, NULL, NULL, NULL, NULL, 'bologna', NULL, 'CASH', NULL, 'declaration', 'ticket', NULL, NULL, NULL, 0, 0, 8, NULL, NULL, NULL, NULL, 1224, 121212, 21, 0, NULL, NULL, 0, NULL, 0, 0, 1, 5, 0, 0, 0),
(45, 2011, '2012-04-15', '2014-04-28', 'ananas', 'ABORTED', '2015-02-28', 'Australia', 'auto', 1, 'Tripoli', 'Aperitivo', 'plane', 0, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 45745, 21447, 12231, 0, 0, NULL, NULL, NULL, NULL, NULL, 'ora', NULL, 'OTHER', NULL, 'mela', 'arancia', NULL, NULL, NULL, 0, 0, 9, NULL, NULL, NULL, NULL, 536, 0, 0, 0, NULL, NULL, 0, NULL, 0, 0, 0, 5, 0, 0, 0),
(46, 2011, '2012-04-15', '2012-05-11', 'no reason', 'INWAIT', '2012-05-01', 'rome', 'bus', 0, 'no', 'Aperitivo', 'train', 0, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 110, 111, 111, 0, NULL, NULL, NULL, NULL, NULL, NULL, 'london', NULL, 'CASH', NULL, 'afsf', 'asf', NULL, NULL, NULL, 0, 0, 1, NULL, NULL, NULL, NULL, 1, 0, 0, 0, NULL, NULL, 0, NULL, 0, 0, 0, 5, 0, 0, 0),
(47, 2012, '2012-04-16', '2012-05-22', 'lol', 'INWAIT', '2012-05-02', 'bari', 'car', 1, 'fa', 'si', 'train', 0, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 43, 121, 111, 1, NULL, NULL, NULL, NULL, NULL, NULL, 'mezzocorona', NULL, 'CASH', NULL, 'lul', 'lal', NULL, NULL, NULL, 0, 0, 2, NULL, NULL, NULL, NULL, 12, 121, 2, 0, NULL, NULL, 0, NULL, 0, 0, 0, 6, 0, 0, 0),
(48, 2021, '2012-01-01', '2021-12-12', 'ciaoooo', 'ACCEPT', '2021-12-14', 'ginevra', 'bus', 0, 'none', 'null', 'plane', 0, 0, 10000, 'null', 1, 1234, 'null', 0, 0, 1, 123, 123, 123, 12, NULL, NULL, NULL, NULL, NULL, NULL, 'dresda', NULL, 'BANK', NULL, 'ciao', 'ciaojojo', NULL, NULL, NULL, 0, 0, 1, NULL, NULL, NULL, NULL, 111, 111, 1, 603, '2012-05-03 00:00:00', '2012-05-03 00:00:00', 0, NULL, 0, 0, 1, 1, 1, 0, 0),
(49, 2012, '2012-01-01', '2012-01-06', 'I like firenze!', 'INWAIT', '2012-01-16', 'firenze', 'nullcar\n bus\n \n ', 0, 'No extraordinary transport', '', 'nulltrain\n \n ', 0, 0, 0, 'Mimmo', 1, 1234, '', 0, 0, 1, 300, 600, 1232, 123, NULL, NULL, NULL, NULL, NULL, NULL, 'genova', NULL, 'CASH', NULL, 'I really want to go there!', 'Train ticket, bus ticket', NULL, NULL, NULL, 0, 0, 9, NULL, NULL, NULL, NULL, 10, 111, 5, 2376, '2012-05-04 00:00:00', '2012-05-04 00:00:00', 0, NULL, 0, 0, 0, 5, 0, 0, 0),
(50, 2012, '2012-01-01', '2012-07-11', '', 'DELETED', '2012-07-15', 'london', 'nullcar\n \n ', 1, '', 'Plane departure is after twelve hours', 'nulltrain\n plane\n \n ', 0, 0, 0, 'dkfjl', 1, 234, 'fklew', 12, 1213, 0, 0, 0, 1, 111, NULL, NULL, NULL, NULL, NULL, NULL, 'trento', NULL, 'CASH', NULL, '', '', NULL, NULL, NULL, 0, 0, 4, NULL, NULL, NULL, NULL, 0, 0, 0, 112, '2012-05-04 00:00:00', '2012-05-04 00:00:00', 0, NULL, 0, 0, 0, 5, 0, 0, 0),
(51, 2012, '2012-01-01', '2012-07-12', 's', 'ABORTED', '2012-07-14', 'roe', 'nullcar\n bus\n \n ', 1, 'aqwf', 'perchÃ¨ sÃ¬', 'nullelicottero\n ', 0, 0, 1111, 'nome1', 1, 1234, '', 0, 0, 0, 12, 21, 123, 120, NULL, NULL, NULL, NULL, NULL, NULL, 'tute', NULL, 'BANK', NULL, 'n', 'rasdfn', NULL, NULL, NULL, 0, 0, 2, NULL, NULL, NULL, NULL, 11, 11, 1, 298, '2012-05-04 00:00:00', '2012-05-04 00:00:00', 0, NULL, 0, 0, 0, 5, 0, 0, 0),
(52, 2012, '2012-01-01', '2012-07-10', 's', 'INWAIT', '2012-07-14', 'roe', 'nullcar\n bus\n \n ', 1, 'aqwf', 'perchÃ¨ sÃ¬', 'nullelicottero\n ', 0, 0, 1111, 'nome1', 1, 1234, '', 0, 0, 1, 12, 21, 123, 120, NULL, NULL, NULL, NULL, NULL, NULL, 'tute', NULL, 'BANK', NULL, 'n', 'rasdfn', NULL, NULL, NULL, 0, 0, 2, NULL, NULL, NULL, NULL, 11, 11, 1, 298, '2012-05-04 00:00:00', '2012-05-04 00:00:00', 0, NULL, 0, 0, 0, 5, 0, 0, 0),
(53, 2012, '2012-01-01', '2012-12-11', '2fadf', 'ABORTED', '2012-12-14', 'afsaf', 'nullbus ', 1, 'aff', 'zvzvv', 'nullcar bus ', 0, 0, 1213, 'safsfa', 1, 1234, '', 0, 0, 0, 2, 2, 123, 12, NULL, NULL, NULL, NULL, NULL, NULL, 'afasssa', NULL, 'OTHER', NULL, 'adfa', 'afd adf,afafs', NULL, NULL, NULL, 0, 0, 3, NULL, NULL, NULL, NULL, 2, 1, 1, 142, '2012-05-05 00:00:00', '2012-05-05 00:00:00', 0, NULL, 0, 0, 0, 5, 0, 0, 0),
(54, 2012, '2012-01-01', '2012-12-31', 'study', 'INWAIT', '2013-01-01', 'cagliari', 'car', 1, 'afaf', 'plane will stop for 4 hours', 'plane', 0, 0, 0, 'Namone', 1, 1234, '', 0, 0, 1, 0.124, 210, 111, 11, NULL, NULL, NULL, NULL, NULL, NULL, 'verona', NULL, 'CASH', NULL, 'noÃ¨', 'dvkpafÃ²', NULL, NULL, NULL, 0, 0, 1, NULL, NULL, NULL, NULL, 111, 213, 1, 656.124, '2012-05-05 00:00:00', '2012-05-05 00:00:00', 0, NULL, 0, 0, 0, 5, 0, 0, 0),
(55, 2012, '2012-01-01', '2012-12-31', '''', 'REFUSE', '2013-01-02', 'cv<', 'car', 0, '%', '', 'car', 0, 0, 0, 'afaF', 1, 1234, '', 0, 0, 0, 32, 0, 0, 0, NULL, NULL, NULL, NULL, NULL, NULL, 'asdv<', NULL, 'OTHER', NULL, '<', '?', NULL, NULL, NULL, 0, 0, 2, NULL, NULL, NULL, NULL, 0, 0, 0, 32, '2012-05-06 00:00:00', '2012-05-06 00:00:00', 0, NULL, 0, 0, 0, 5, 1, 0, 0),
(56, 2000, '2012-01-01', '2000-02-15', 'uuigu', 'REFUSE', '2013-05-05', 'capruica', 'car', 0, 'poiuy', '', 'car', 0, 0, 0, 'drguhi', 1, 1234, '', 0, 0, 0, 0, 0, 0, 0, 1, NULL, NULL, NULL, NULL, NULL, 'pearl albour', NULL, 'OTHER', NULL, 'asd', 'fds', NULL, NULL, NULL, 0, 0, 148, NULL, NULL, NULL, NULL, 0, 0, 0, 0, '2012-05-07 00:00:00', '2012-05-07 00:00:00', 0, NULL, 0, 0, 0, 5, 0, 0, 0),
(59, 1000, '2012-01-01', '1000-05-05', 'voglio andare su Caprica!', 'REFUSE', '2000-08-05', 'Caprica', 'ship', 0, 'Vi trovero'' prima o poi...', '', 'ship', 0, 1, 250, 'banca intercontinentale', 1, 1234, '', 0, 0, 0, 500, 87, 125, 0, NULL, NULL, NULL, NULL, NULL, NULL, 'via della suora 8', NULL, 'OTHER', NULL, 'Perche'' non mi ci mandi?', 'Occhio a chi cancella dati dal DB!!!!', NULL, NULL, NULL, 0, 0, 15, NULL, NULL, NULL, NULL, 10, 4, 12, 726, '2012-05-07 00:00:00', '2012-05-07 00:00:00', 0, NULL, 0, 0, 0, 5, 0, 0, 0),
(60, 2012, '2012-01-01', '2012-05-16', 'food', 'ON_HOLD', '2012-05-25', 'giovannis home', 'car', 1, 'faccio fatica', 'gnagna', NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'UNKNOWN', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 0, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, 0, NULL, NULL, 0, NULL, 0, 0, 1, 1, 0, 0, 0),
(61, 2012, '2012-04-08', '2012-05-15', 'dadas', 'ON_HOLD', '2012-05-24', 'baciapiselli', 'plane', 1, 'sadasd', 'dfasfas', NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'UNKNOWN', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 0, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, 0, NULL, NULL, 0, NULL, 0, 0, 0, 1, 0, 0, 0),
(62, 2012, '2012-05-08', '2012-05-08', 'saewfscsd<cs<d', 'ON_HOLD', '2012-05-09', 'baciapiselli', 'train', 1, '', '', NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'UNKNOWN', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 0, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, 0, NULL, NULL, 0, NULL, 0, 0, 0, 1, 0, 0, 0),
(63, 2012, '2012-05-08', '2012-05-22', 'giasdad', 'ON_HOLD', '2012-06-01', 'baciapiselli', 'train', 1, 'sadasdad', '', NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'UNKNOWN', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 0, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, 0, NULL, NULL, 0, NULL, 0, 0, 0, 1, 0, 0, 0),
(64, 2012, '2012-05-08', '2012-05-16', 'baciapiselli', 'ON_HOLD', '2012-05-17', 'gianluca', 'bus', 1, 'asd', '', NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'UNKNOWN', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 0, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, 0, NULL, NULL, 0, NULL, 0, 0, 0, 1, 0, 0, 0),
(65, 2012, '2012-05-08', '2012-05-16', 'assassini', 'ON_HOLD', '2012-05-25', 'baciapiselli', 'carcar', 1, '', '', NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'UNKNOWN', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 0, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, 0, NULL, NULL, 0, NULL, 0, 0, 0, 1, 0, 0, 0),
(66, 2012, '2012-05-08', '2012-05-15', 'sdfasf', 'ON_HOLD', '2012-05-18', 'sfdfdfda', 'planeboatbus', 1, 'cx<zc', '', NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'UNKNOWN', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 0, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, 0, NULL, NULL, 0, NULL, 0, 0, 0, 1, 0, 0, 0),
(67, 2012, '2012-05-08', '2012-05-24', 'dasd', 'ON_HOLD', '2012-05-23', 'qwd', ' car plane taxi boat', 1, '', '', NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'UNKNOWN', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 0, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, 0, NULL, NULL, 0, NULL, 0, 0, 0, 1, 0, 0, 0),
(68, 2021, '2012-05-08', '2021-12-12', 'PROVAPROVA', 'INWAIT', '2021-12-14', 'ginevra', 'bus', 0, 'none', 'null', 'plane', NULL, 1, 10000, 'null', 0, 0, 'null', 0, 0, 0, 12214, 123, 123, 12, NULL, NULL, NULL, NULL, NULL, NULL, 'dresda', NULL, 'BANK', NULL, 'ciaadkdo', 'cojo', NULL, NULL, NULL, 0, 0, 1, NULL, NULL, NULL, NULL, 111, 111, 1, 603, '2012-05-08 00:00:00', '2012-05-08 00:00:00', 0, NULL, 0, 0, 0, 1, 0, 0, 0),
(69, 2012, '2012-05-13', '2012-05-15', 'Meeting', 'ACCEPTED', '2012-05-17', 'Chi lo sa', 'car taxi bus ', 1, 'Mi serve', 'Perché si', NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 4124, 34223, 4323, 3242, NULL, '2012-05-18 00:00:00', '2012-05-22 00:00:00', NULL, NULL, 'Onolulu', 'UNKNOWN', NULL, NULL, 'fewrrafa', 'fawrfraewtarygtjhgjnfg', 'Car Plane Blabla', 12, 'Tizio Caio Macross Yeah', 123421, 12312, 34242, 2, 3, 4, 2, NULL, 234, 342, 123123, 3.52253e+08, NULL, NULL, 0, NULL, 0, 0, 1, 6, 0, 0, 0),
(70, 2012, '2012-05-14', '2012-05-15', 'sadf', 'ACCOMPLISHED', '2012-05-10', 'dfsf', 'plane taxi ', 1, 'sdfa', '', NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 2131, 21, 312321, 123, NULL, '2012-05-17 11:11:11', '2012-05-23 23:11:11', NULL, NULL, 'FDSAFAD', 'UNKNOWN', NULL, NULL, 'DSFADFA', 'AFSFA', 'Type of tickets', 21, 'Names and Surnames', 2312, 123, 312, 132, 231, 122, 123, NULL, 131, 2131, 123, 2.31413e+06, NULL, NULL, 0, NULL, 0, 0, 0, 5, 0, 0, 0),
(71, 2012, '2012-05-14', '2012-05-15', 'Vacanze Estive', 'ON_HOLD', '2012-05-18', 'Hawaii', 'car train boat ', 1, '', '', NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'UNKNOWN', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 0, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, 0, NULL, NULL, 0, NULL, 0, 0, 1, 6, 0, 0, 0),
(72, 2012, '2012-05-14', '2012-05-09', 'zf<zc', 'ON_HOLD', '2012-05-26', 'dsfsdfas', 'car plane train bus ', 1, 'fASFFSDA saadad\r\nasdasdasd\r\nsdasd', 'SDAFAFF\r\nasdasd\r\nsadad', NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'UNKNOWN', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 0, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, 0, NULL, NULL, 0, NULL, 0, 0, 0, 2, 0, 0, 0),
(73, 2012, '2012-05-14', '2012-05-13', 'asdad', 'ON_HOLD', '2012-05-23', 'add', 'car boat ', 1, 'dsadads', 'dad\r\nasd\r\nad\r\nadadsad  ascasd', NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'UNKNOWN', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 0, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, 0, NULL, NULL, 0, NULL, 0, 0, 0, 5, 0, 0, 0),
(74, 2012, '2012-05-14', '2012-05-17', 'Devo spedire un pacco', 'ACCOMPLISHED', '2012-05-21', 'New York', 'plane taxi ', 1, '', 'Devo bere il caffè', NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 2342, 42342, 24324, 32432, NULL, '2012-05-17 12:00:11', '2012-05-24 14:30:30', NULL, NULL, 'New York', 'UNKNOWN', NULL, NULL, 'Sorry le ho perse', 'Non ho altro da dire', 'Plane Train Bus', 324, 'Tizio Caio Sempronio', 3422, 24323, 242, 2, 3, 2, 2, NULL, 234, 2423, 23, 423, NULL, NULL, 0, NULL, 0, 0, 0, 10, 0, 0, 0),
(75, 2012, '2012-05-15', '2012-05-16', 'stanchezza', 'ON_HOLD', '2015-05-31', 'Casa', 'train bus ', 1, 'jet privato', '', NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'UNKNOWN', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 0, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, 0, NULL, NULL, 0, NULL, 0, 0, 1, 10, 0, 0, 0),
(76, 2012, '2012-05-15', '2012-05-16', '', 'ACCOMPLISHED', '2015-05-24', 'casa', 'train ', 1, 'jet privato', '', NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 12, 12, 12, 12, NULL, '2012-05-16 15:12:00', '2012-05-17 15:13:00', NULL, NULL, 'casa', 'UNKNOWN', NULL, NULL, 'pizza', 'pizza', 'ciccio', 500, 'mia mamma', 10, 5, 13, 45, 23, 53, 25, NULL, 12, 12, 12, 12, NULL, NULL, 0, NULL, 0, 0, 0, 10, 0, 0, 0);

-- --------------------------------------------------------

--
-- Struttura della tabella `universities`
--

CREATE TABLE IF NOT EXISTS `universities` (
  `university_ID` int(11) NOT NULL auto_increment,
  `name_university` varchar(255) character set latin1 NOT NULL default 'UNKNOWN',
  `location` varchar(255) character set latin1 NOT NULL default 'UNKNOWN',
  `deleted` tinyint(1) NOT NULL default '0',
  `country` int(11) default NULL,
  PRIMARY KEY  (`university_ID`),
  UNIQUE KEY `name_university_UNIQUE` (`name_university`),
  KEY `fk_university_country` (`country`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Dump dei dati per la tabella `universities`
--

INSERT INTO `universities` (`university_ID`, `name_university`, `location`, `deleted`, `country`) VALUES
(1, 'UNITN', 'Rome', 0, 1),
(2, 'UNIDIGITEX', 'Milano', 0, 1);

-- --------------------------------------------------------

--
-- Struttura della tabella `users_credentials`
--

CREATE TABLE IF NOT EXISTS `users_credentials` (
  `user_credential_ID` int(11) NOT NULL auto_increment,
  `user_name` varchar(200) character set latin1 NOT NULL default 'UNKNOWN',
  `password` varchar(500) character set latin1 NOT NULL default 'UNKNOWN',
  `user_rol` int(11) NOT NULL,
  PRIMARY KEY  (`user_credential_ID`),
  KEY `fk_users_credentials_users_roles1` (`user_rol`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=654322 ;

--
-- Dump dei dati per la tabella `users_credentials`
--

INSERT INTO `users_credentials` (`user_credential_ID`, `user_name`, `password`, `user_rol`) VALUES
(2, 'meridio', 'meridio', 2),
(1, 'doe', 'doe', 2),
(3, 'macchi', 'macchi', 2),
(4, 'lovercraft', 'lovercraft', 2),
(5, 'poe', 'poe', 2),
(6, 'django', 'django', 2),
(7, 'mengoni', 'mengoni', 2),
(8, 'smith', 'smith', 3),
(9, 'rasmay', 'rasmay', 3),
(10, 'marinis', 'marinis', 3),
(11, 'geller', 'geller', 3),
(12, 'bitta', 'bitta', 3),
(13, 'nervi', 'nervi', 3),
(14, 'rogi', 'rogi', 3),
(15, 'tizio', 'tizio', 3),
(16, 'darpa', 'darpa', 3),
(17, 'rossi', 'rossi', 3),
(18, 'student1', 'student1', 3),
(19, 'student2', 'student2', 3),
(20, 'supervisor1', 'supervisor1', 2),
(21, 'supervisor2', 'supervisor2', 2),
(22, 'admin', 'admin', 1),
(23, 'admin1', 'admin1', 1),
(24, 'admin2', 'admin2', 1);

-- --------------------------------------------------------

--
-- Struttura della tabella `users_roles`
--

CREATE TABLE IF NOT EXISTS `users_roles` (
  `user_rol_ID` int(11) NOT NULL auto_increment,
  `role` varchar(100) character set latin1 NOT NULL default 'UNKNOWN',
  `deleted` tinyint(1) NOT NULL,
  PRIMARY KEY  (`user_rol_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=9 ;

--
-- Dump dei dati per la tabella `users_roles`
--

INSERT INTO `users_roles` (`user_rol_ID`, `role`, `deleted`) VALUES
(1, 'admin', 0),
(2, 'supervisor', 0),
(3, 'student', 0),
(4, 'guest', 0),
(5, 'bad', 0),
(6, 'coordinator', 0),
(8, 'manager', 0);

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `supervisors`
--
ALTER TABLE `supervisors`
  ADD CONSTRAINT `fk_supervisors_user` FOREIGN KEY (`user`) REFERENCES `users_credentials` (`user_credential_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limiti per la tabella `courses`
--
ALTER TABLE `courses`
  ADD CONSTRAINT `courses_ibfk_1` FOREIGN KEY (`professor`) REFERENCES `supervisors` (`supervisor_ID`) ON UPDATE CASCADE;

--
-- Limiti per la tabella `courses_enrollments`
--
ALTER TABLE `courses_enrollments`
  ADD CONSTRAINT `fk_courses_enrollments_courses1` FOREIGN KEY (`course`) REFERENCES `courses` (`course_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_courses_enrollments_students1` FOREIGN KEY (`student`) REFERENCES `students` (`user_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limiti per la tabella `students`
--
ALTER TABLE `students`
  ADD CONSTRAINT `fk_students_supervisors1` FOREIGN KEY (`current_advisor`) REFERENCES `supervisors` (`supervisor_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_students_supervisors2` FOREIGN KEY (`tutor`) REFERENCES `supervisors` (`supervisor_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_students_supervisors3` FOREIGN KEY (`funds_owner`) REFERENCES `supervisors` (`supervisor_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_student_citizenship` FOREIGN KEY (`citizenship`) REFERENCES `countries` (`country_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_student_country` FOREIGN KEY (`country_of_provenance`) REFERENCES `countries` (`country_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_student_funding_institution` FOREIGN KEY (`funding_institution`) REFERENCES `funding_institutions` (`funding_institution_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_student_university` FOREIGN KEY (`university`) REFERENCES `universities` (`university_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_student_university_provenance` FOREIGN KEY (`university_of_provenance`) REFERENCES `universities` (`university_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_student_user` FOREIGN KEY (`user`) REFERENCES `users_credentials` (`user_credential_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limiti per la tabella `trips`
--
ALTER TABLE `trips`
  ADD CONSTRAINT `fk_travels_users1` FOREIGN KEY (`student`) REFERENCES `students` (`user_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limiti per la tabella `universities`
--
ALTER TABLE `universities`
  ADD CONSTRAINT `fk_university_country` FOREIGN KEY (`country`) REFERENCES `countries` (`country_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limiti per la tabella `users_credentials`
--
ALTER TABLE `users_credentials`
--  ADD CONSTRAINT `fk_users_credentials_users1` FOREIGN KEY (`user`) REFERENCES `students` (`user_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_users_credentials_users_roles1` FOREIGN KEY (`user_rol`) REFERENCES `users_roles` (`user_rol_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

insert into courses_enrollments (qualification,course,student) values ("bo",1,1);

