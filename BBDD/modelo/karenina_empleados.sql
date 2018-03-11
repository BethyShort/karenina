-- MySQL Script generated by MySQL Workbench
-- dom 25 feb 2018 18:18:35 CET
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `mydb` ;

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`TP_IDENTIFICADORES`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`TP_IDENTIFICADORES` ;

CREATE TABLE IF NOT EXISTS `mydb`.`TP_IDENTIFICADORES` (
  `id_tipo_identificador` TINYINT(3) NOT NULL,
  `descripcion` VARCHAR(45) NULL,
  PRIMARY KEY (`id_tipo_identificador`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`TP_CONTACTOS`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`TP_CONTACTOS` ;

CREATE TABLE IF NOT EXISTS `mydb`.`TP_CONTACTOS` (
  `tipo_contacto` TINYINT(3) NOT NULL,
  `descripcion` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`tipo_contacto`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`CONTACTOS`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`CONTACTOS` ;

CREATE TABLE IF NOT EXISTS `mydb`.`CONTACTOS` (
  `id_contacto` INT NOT NULL,
  `descripcion` VARCHAR(45) NOT NULL,
  `tipo_contacto` TINYINT(3) NOT NULL,
  PRIMARY KEY (`id_contacto`),
  CONSTRAINT `fk_CONTACTOS_TP_CONTACTOS1`
    FOREIGN KEY (`tipo_contacto`)
    REFERENCES `mydb`.`TP_CONTACTOS` (`tipo_contacto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_CONTACTOS_TP_CONTACTOS1_idx` ON `mydb`.`CONTACTOS` (`tipo_contacto` ASC);


-- -----------------------------------------------------
-- Table `mydb`.`IDENTIFICADORES`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`IDENTIFICADORES` ;

CREATE TABLE IF NOT EXISTS `mydb`.`IDENTIFICADORES` (
  `identificador` INT NOT NULL,
  `numero_documento` VARCHAR(10) NOT NULL,
  `tipo_identificador` TINYINT(3) NOT NULL,
  `id_contacto` INT NOT NULL,
  PRIMARY KEY (`identificador`, `numero_documento`),
  CONSTRAINT `fk_IDENTIFICADORES_TP_IDENTIFICADORES1`
    FOREIGN KEY (`tipo_identificador`)
    REFERENCES `mydb`.`TP_IDENTIFICADORES` (`id_tipo_identificador`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_IDENTIFICADORES_CONTACTOS1`
    FOREIGN KEY (`id_contacto`)
    REFERENCES `mydb`.`CONTACTOS` (`id_contacto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_IDENTIFICADORES_TP_IDENTIFICADORES1_idx` ON `mydb`.`IDENTIFICADORES` (`tipo_identificador` ASC);

CREATE INDEX `fk_IDENTIFICADORES_CONTACTOS1_idx` ON `mydb`.`IDENTIFICADORES` (`id_contacto` ASC);


-- -----------------------------------------------------
-- Table `mydb`.`EMPLEADOS`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`EMPLEADOS` ;

CREATE TABLE IF NOT EXISTS `mydb`.`EMPLEADOS` (
  `id_empleado` INT NOT NULL,
  `identificador` INT NOT NULL,
  `nombre` VARCHAR(40) NULL,
  `apellidos` VARCHAR(80) NULL,
  PRIMARY KEY (`id_empleado`),
  CONSTRAINT `fk_EMPLEADOS_IDENTIFICADORES`
    FOREIGN KEY (`identificador`)
    REFERENCES `mydb`.`IDENTIFICADORES` (`identificador`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_EMPLEADOS_IDENTIFICADORES_idx` ON `mydb`.`EMPLEADOS` (`identificador` ASC);

CREATE UNIQUE INDEX `identificador_UNIQUE` ON `mydb`.`EMPLEADOS` (`identificador` ASC);


-- -----------------------------------------------------
-- Table `mydb`.`TP_PAISES`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`TP_PAISES` ;

CREATE TABLE IF NOT EXISTS `mydb`.`TP_PAISES` (
  `id_pais` SMALLINT(4) NOT NULL,
  `descripcion` VARCHAR(45) NULL,
  PRIMARY KEY (`id_pais`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`TP_PROVINCIAS`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`TP_PROVINCIAS` ;

CREATE TABLE IF NOT EXISTS `mydb`.`TP_PROVINCIAS` (
  `id_provincia` SMALLINT(4) NOT NULL,
  `id_pais` SMALLINT(4) NOT NULL,
  PRIMARY KEY (`id_provincia`),
  CONSTRAINT `fk_TP_PROVINCIAS_TP_PAISES1`
    FOREIGN KEY (`id_pais`)
    REFERENCES `mydb`.`TP_PAISES` (`id_pais`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_TP_PROVINCIAS_TP_PAISES1_idx` ON `mydb`.`TP_PROVINCIAS` (`id_pais` ASC);


-- -----------------------------------------------------
-- Table `mydb`.`DIRECCIONES`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`DIRECCIONES` ;

CREATE TABLE IF NOT EXISTS `mydb`.`DIRECCIONES` (
  `id_direccion` INT NOT NULL,
  `puerta` VARCHAR(2) NULL,
  `planta` SMALLINT(3) NULL,
  `bloque` VARCHAR(10) NULL,
  `portal` SMALLINT(4) NULL,
  `calle` VARCHAR(50) NULL,
  `ciudad` VARCHAR(50) NULL,
  `codigo_postal` VARCHAR(10) NULL,
  `id_pais` SMALLINT(4) NOT NULL,
  `id_provincia` SMALLINT(4) NOT NULL,
  PRIMARY KEY (`id_direccion`),
  CONSTRAINT `fk_DIRECCIONES_TP_PAISES1`
    FOREIGN KEY (`id_pais`)
    REFERENCES `mydb`.`TP_PAISES` (`id_pais`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_DIRECCIONES_TP_PROVINCIAS1`
    FOREIGN KEY (`id_provincia`)
    REFERENCES `mydb`.`TP_PROVINCIAS` (`id_provincia`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_DIRECCIONES_TP_PAISES1_idx` ON `mydb`.`DIRECCIONES` (`id_pais` ASC);

CREATE INDEX `fk_DIRECCIONES_TP_PROVINCIAS1_idx` ON `mydb`.`DIRECCIONES` (`id_provincia` ASC);


-- -----------------------------------------------------
-- Table `mydb`.`REL_CONTACTO_DIRECCIONES`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`REL_CONTACTO_DIRECCIONES` ;

CREATE TABLE IF NOT EXISTS `mydb`.`REL_CONTACTO_DIRECCIONES` (
  `id_contacto` INT NOT NULL,
  `id_direccion` INT NOT NULL,
  PRIMARY KEY (`id_contacto`, `id_direccion`),
  CONSTRAINT `fk_CONTACTOS_has_DIRECCIONES_CONTACTOS1`
    FOREIGN KEY (`id_contacto`)
    REFERENCES `mydb`.`CONTACTOS` (`id_contacto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_CONTACTOS_has_DIRECCIONES_DIRECCIONES1`
    FOREIGN KEY (`id_direccion`)
    REFERENCES `mydb`.`DIRECCIONES` (`id_direccion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_CONTACTOS_has_DIRECCIONES_DIRECCIONES1_idx` ON `mydb`.`REL_CONTACTO_DIRECCIONES` (`id_direccion` ASC);

CREATE INDEX `fk_CONTACTOS_has_DIRECCIONES_CONTACTOS1_idx` ON `mydb`.`REL_CONTACTO_DIRECCIONES` (`id_contacto` ASC);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
