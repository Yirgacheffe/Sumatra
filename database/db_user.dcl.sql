-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: 127.0.0.1    Database: NSV_TIMENTRY
-- -----------------------------------------------------------------------------------------------------
-- Server version 5.7.11

--
-- Create user 'Olge' and grant previleges -------------------------------------------------------------
--
CREATE USER 'Oleg'@'localhost' IDENTIFIED BY 'Oleg#local1234';
GRANT ALL PRIVILEGES ON NSV_TIMENTRY.* TO 'Oleg'@'localhost' IDENTIFIED BY 'Oleg#local1234';
