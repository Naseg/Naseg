-- phpMyAdmin SQL Dump
-- version 3.3.7deb5build0.10.10.1
-- http://www.phpmyadmin.net
--
-- Host: test.liquidpub.org:3306
-- Generato il: 07 apr, 2012 at 11:01 AM
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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- Dump dei dati per la tabella `countries`
--

INSERT INTO `countries` (`country_ID`, `name`, `region`, `citizenship`, `deleted`) VALUES
(1, 'Italy', 'Europe', 'Italian', 0);

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
  `is_payment_completed` tinyint(1) NOT NULL default '0' COMMENT 'did the guy get the money?',
  `deleted` tinyint(1) NOT NULL default '0',
  `professor` int(11) default NULL,
  PRIMARY KEY  (`course_ID`),
  KEY `Professor` (`professor`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

--
-- Dump dei dati per la tabella `courses`
--

INSERT INTO `courses` (`course_ID`, `notes`, `actual_start_date`, `institution`, `place`, `credits`, `course_name`, `academic_year`, `is_in_manifesto`, `is_by_UNITN`, `is_paid`, `budgeted_cost`, `actual_cost`, `planned_course_period`, `are_all_marks_defined`, `url`, `is_payment_completed`, `deleted`, `professor`) VALUES
(1, 'internal course / not started', NULL, 'University of Trento', 'Povo 0, room 202', 3, 'Web Engineering', 2012, 1, 1, 1, 1000, 0, 'Summer 2012', 0, 'http://summer-course.org', 0, 0, 1),
(2, 'external course', NULL, 'University of Bolzano', 'Bolzano', 3, 'Human Computer Interaction', 2012, 0, 0, 0, 0, 0, 'UNKNOWN', 0, 'http://bolzano-courses.edu/hci', 0, 0, NULL),
(3, 'internal course / started', '2012-04-05', 'Universiti of Trento', 'Povo 1, room 12', 3, 'Research Methodology II', 2012, 1, 1, 1, 3000, 0, 'Spring 2012', 0, 'http://research-methodology.net', 0, 0, 1),
(4, 'internal course / finished', '2012-02-01', 'University of Trento', 'Povo 0, room Ofek', 3, 'Research Methodology I', 2012, 1, 1, 1, 5000, 4500, 'Winter 2012', 1, 'http://research-methodology.net', 0, 0, 1);

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
  PRIMARY KEY  (`enrollment_ID`),
  KEY `index_courses_users_on_course_id` (`qualification`),
  KEY `index_courses_users_on_user_id` (`is_finished`),
  KEY `index_courses_users_on_course_id_and_user_id` (`qualification`,`is_finished`),
  KEY `fk_courses_enrollments_courses1` (`course`),
  KEY `fk_courses_enrollments_students1` (`student`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Dump dei dati per la tabella `courses_enrollments`
--


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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- Dump dei dati per la tabella `funding_institutions`
--

INSERT INTO `funding_institutions` (`funding_institution_ID`, `name`, `deleted`, `type`) VALUES
(1, 'DISI', 0, 'UNKNOWN');

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Dump dei dati per la tabella `students`
--

INSERT INTO `students` (`user_ID`, `first_name`, `last_name`, `full_name`, `phd_cycle`, `is_suspended`, `course_year`, `admitted_conditionally`, `legal_residence`, `current_domicile`, `date_of_birth`, `place_of_birth`, `office_phone`, `mobile_phone`, `office_working_place`, `locker_number`, `phd_scholarship`, `scholarship_type`, `yearly_fee_to_center`, `yearly_fee_to_school`, `has_pc_rights`, `pre_doctoral_scholarship`, `months_predoc_scholarship`, `year_extension_scholarship`, `months`, `personal_funds_available`, `is_graduated`, `graduation_date`, `commitee_members`, `email`, `deleted`, `funding_institution`, `university`, `country_of_provenance`, `university_of_provenance`, `citizenship`, `current_advisor`, `tutor`, `funds_owner`, `Italian_Taxpayer_Code`, `user`) VALUES
(1, 'John Erik', 'Smith', 'John E. Smith', '28', 0, 2, 0, 'via manci 27, Trento', '', '1998-10-12', 'New York, NY, USA', '123-456789', '1231-23456', 'P1-S5-14', '27-A', 0, 'UNKNOWN', 0, 0, 0, NULL, 0, '0', 0, 0, 0, NULL, 'UNKNOWN', 'joele.smith@anal.com', 0, 1, 1, 1, 1, 1, 1, 1, 1, NULL, 1),
(2, 'Paolo', 'Bitta', 'Paolo Bitta', '30', 0, 1, 0, 'via verdi 3, Fanstasticville', 'via verdi 3, Fanstasticville', '1436-12-02', 'Wonderland, PM, Fourchankistan', '123-123123', '123-123123', 'P1-S1-12', '28-!', 0, 'Grappa di Lello School', 0, 0, 0, '0', 0, '0', 0, 750, 0, '2009-01-01', 'UNKOWN', 'paolo.bitta@alcolisti.com', 0, 1, 1, 1, 1, 1, 1, 1, 1, NULL, 2);

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- Dump dei dati per la tabella `supervisors`
--

INSERT INTO `supervisors` (`supervisor_ID`, `first_name`, `last_name`, `can_be_advisor`, `is_active`, `is_internal`, `email`, `deleted`, `user`) VALUES
(1, 'Joe', 'Doe', 1, 1, 1, 'joe.doe@gmail.com', 0, 10);

-- --------------------------------------------------------

--
-- Struttura della tabella `trips`
--

CREATE TABLE IF NOT EXISTS `trips` (
  `trip_ID` int(11) NOT NULL auto_increment,
  `academic_year_id` int(11) default NULL,
  `Date_of_request` int(11) default NULL,
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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=7 ;

--
-- Dump dei dati per la tabella `trips`
--

INSERT INTO `trips` (`trip_ID`, `academic_year_id`, `Date_of_request`, `Planned_start_date`, `Planned_Reason_for_Travel`, `status`, `Planned_end_date`, `Planned_destination`, `Planned_means_of_transport`, `is_stopover_requested`, `Reason_for_extraordinary_transport`, `Reason_for_stopover`, `type_of_transportation`, `is_approved`, `are_personal_funds_used`, `personal_funds_amount`, `alternative_fund_1_name`, `alternative_fund_1_manager`, `alternative_fund_1_amount`, `alternative_fund_2_name`, `alternative_fund_2_amount`, `alternative_fund_2_manager`, `has_advisor_approved`, `foreseen_meals_cost`, `foreseen_lodging_cost`, `foreseen_transportation_cost`, `expenses_sustained_before_trip`, `is_advance_payment_requested`, `actual_begin_date_time`, `actual_end_date_time`, `departure_border_cross_datetime`, `arrival_border_cross_datetime`, `actual_destination`, `current_address`, `advance_payment_received`, `requested_payment_method`, `self_declaration_missing_recepits`, `other_declarations`, `Travel_tickets`, `personal_veichle_KM_travelled`, `personal_veichle_colleagues`, `highway_toll_fees`, `total_transport_expenses`, `total_lodging_expenses`, `number_of_nights`, `num_lodging_receipts`, `num_meals_invoices`, `num_days_of_meals`, `total_meal_expenses`, `registration_fee`, `other_costs_amount`, `other_costs_description`, `total_expenses`, `created_at`, `updated_at`, `reimb_transport_expenses`, `date_reim_request_submitted`, `reimb_lodging_expenses`, `reimb_extra_costs`, `deleted`, `student`, `has_coord_approved`, `has_fund_1_mgr_approved`, `has_fund_2_mgr_approved`) VALUES
(1, NULL, NULL, '2001-01-01', NULL, 's', '2001-01-01', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'a', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 0, 0, 0),
(2, NULL, NULL, '2001-01-01', NULL, 's', '2001-01-01', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'a', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 0, 0, 0),
(3, NULL, NULL, '2001-01-01', NULL, 's', '2001-01-01', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'a', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 0, 0, 0),
(4, NULL, NULL, '2001-01-01', NULL, 's', '2001-01-01', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'a', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 0, 0, 0),
(5, NULL, NULL, '2001-01-01', NULL, 's', '2001-01-01', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'a', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 0, 0, 0),
(6, NULL, NULL, '2001-01-01', NULL, 's', '2001-01-01', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'a', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 0, 0, 0);

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- Dump dei dati per la tabella `universities`
--

INSERT INTO `universities` (`university_ID`, `name_university`, `location`, `deleted`, `country`) VALUES
(1, 'UNITN', 'Rome', 0, 1);

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
(1, 'demo', '12345', 3),
(10, 'doe', 'doe', 2),
(2, 'bitta', 'password', 3),
(654321, 'sempronio', 'poppea', 3);

-- --------------------------------------------------------

--
-- Struttura della tabella `users_roles`
--

CREATE TABLE IF NOT EXISTS `users_roles` (
  `user_rol_ID` int(11) NOT NULL auto_increment,
  `role` varchar(100) character set latin1 NOT NULL default 'UNKNOWN',
  `deleted` tinyint(1) NOT NULL,
  PRIMARY KEY  (`user_rol_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=7 ;

--
-- Dump dei dati per la tabella `users_roles`
--

INSERT INTO `users_roles` (`user_rol_ID`, `role`, `deleted`) VALUES
(1, 'admin', 0),
(2, 'supervisor', 0),
(3, 'student', 0),
(4, 'guest', 0);

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

