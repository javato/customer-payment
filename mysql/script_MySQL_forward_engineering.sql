-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema customer-payment
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema customer-payment
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `customer-payment` DEFAULT CHARACTER SET utf8 ;
USE `customer-payment` ;

-- -----------------------------------------------------
-- Table `customer-payment`.`CUSTOMER`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `customer-payment`.`CUSTOMER` ;

CREATE TABLE IF NOT EXISTS `customer-payment`.`CUSTOMER` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `FIRST_NAME` VARCHAR(45) NULL,
  `LAST_NAME` VARCHAR(45) NULL,
  `IBAN_ENCRYPTED` VARCHAR(45) NULL,
  `HASH_IBAN` VARCHAR(45) NULL,
  `ADDRESS` VARCHAR(45) NULL,
  `CONTRACT_ID` INT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `ID_UNIQUE` (`ID` ASC) VISIBLE,
  UNIQUE INDEX `CONTRACT_ID_UNIQUE` (`CONTRACT_ID` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `customer-payment`.`PAYMENT`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `customer-payment`.`PAYMENT` ;

CREATE TABLE IF NOT EXISTS `customer-payment`.`PAYMENT` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `NAME` VARCHAR(45) NULL,
  `ADDRESS` VARCHAR(120) NULL,
  `IBAN` VARCHAR(45) NULL,
  `COMMENT` VARCHAR(250) NULL,
  `CUSTOMER_ID` INT NOT NULL,
  PRIMARY KEY (`ID`, `CUSTOMER_ID`),
  UNIQUE INDEX `ID_UNIQUE` (`ID` ASC) VISIBLE,
  INDEX `fk_PAYMENT_CUSTOMER_idx` (`CUSTOMER_ID` ASC) VISIBLE,
  CONSTRAINT `fk_PAYMENT_CUSTOMER`
    FOREIGN KEY (`CUSTOMER_ID`)
    REFERENCES `customer-payment`.`CUSTOMER` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data inserts
-- -----------------------------------------------------

INSERT INTO `customer-payment`.`CUSTOMER` (`FIRST_NAME`, `LAST_NAME`, `IBAN_ENCRYPTED`, `HASH_IBAN`, `ADDRESS`, `CONTRACT_ID`) VALUES ('Alice', 'Novette', 'b59c6b236ece066f145c2a195d68c4ef640de2b9', '9393117fc22175732ea7042f33d89efb', 'Rue du Moulin 2 Lausanne', '111');
INSERT INTO `customer-payment`.`CUSTOMER` (`FIRST_NAME`, `LAST_NAME`, `IBAN_ENCRYPTED`, `HASH_IBAN`, `ADDRESS`, `CONTRACT_ID`) VALUES ('Bob', 'Novet', '026f86219b64a1fc1d4ef177b4537c47fd27b258', '094171314505c1458b85388df50457d1', 'Rue du Moulin 3 Lausanne', '113');
INSERT INTO `customer-payment`.`CUSTOMER` (`FIRST_NAME`, `LAST_NAME`, `IBAN_ENCRYPTED`, `HASH_IBAN`, `ADDRESS`, `CONTRACT_ID`) VALUES ('Céline', 'Carou', '0aadc241c06c54f09429dfecc0934b7f015fabfc', '4d93c7c2a242d413a793df2ba0b6b26d', 'Rue Etraz 4 Lausanne', '58');

INSERT INTO `customer-payment`.`PAYMENT` (`NAME`, `ADDRESS`, `IBAN`, `COMMENT`, `CUSTOMER_ID`) VALUES ('Alice Novett', 'Rue du Moulin 2 Lausanne', 'AAAABBBBCCCCDDDD', 'Alice Novette', '1');
INSERT INTO `customer-payment`.`PAYMENT` (`NAME`, `ADDRESS`, `IBAN`, `COMMENT`, `CUSTOMER_ID`) VALUES ('Bob Novet', 'Rue du Moulin 2 Lausanne', 'BBBBCCCCDDDDEEEE', '113', '2');
INSERT INTO `customer-payment`.`PAYMENT` (`NAME`, `ADDRESS`, `IBAN`, `COMMENT`, `CUSTOMER_ID`) VALUES ('Céline Carou', 'Rue du Moulin 3 Lausanne', 'CCCCDDDDEEEEFFFF', 'Useless stuff', '3');