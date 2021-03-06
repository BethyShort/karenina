-- MySQL Script generated by MySQL Workbench
-- mié 28 feb 2018 20:23:27 CET
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema karenina
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `karenina` ;

-- -----------------------------------------------------
-- Schema karenina
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `karenina` DEFAULT CHARACTER SET utf8 ;
USE `karenina` ;

-- -----------------------------------------------------
-- Table `karenina`.`EMPLEADOS`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `karenina`.`EMPLEADOS` ;

CREATE TABLE IF NOT EXISTS `karenina`.`EMPLEADOS` (
  `id_empleado` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(40) NOT NULL,
  `apellido1` VARCHAR(80) NOT NULL,
  `apellido2` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_empleado`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `karenina`.`TP_IDENTIFICADORES`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `karenina`.`TP_IDENTIFICADORES` ;

CREATE TABLE IF NOT EXISTS `karenina`.`TP_IDENTIFICADORES` (
  `id_tipo_identificador` TINYINT(3) NOT NULL,
  `descripcion` VARCHAR(45) NULL,
  PRIMARY KEY (`id_tipo_identificador`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `karenina`.`IDENTIFICADORES_FISCALES`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `karenina`.`IDENTIFICADORES_FISCALES` ;

CREATE TABLE IF NOT EXISTS `karenina`.`IDENTIFICADORES_FISCALES` (
  `id_identificador` VARCHAR(10) NOT NULL,
  `id_empleado` INT NOT NULL,
  `id_tipo_identificador` TINYINT(3) NOT NULL,
  PRIMARY KEY (`id_identificador`, `id_empleado`),
  CONSTRAINT `fk_IDENTIFICADORES_TP_IDENTIFICADORES2`
    FOREIGN KEY (`id_tipo_identificador`)
    REFERENCES `karenina`.`TP_IDENTIFICADORES` (`id_tipo_identificador`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_IDENTIFICADORES_EMPLEADOS1`
    FOREIGN KEY (`id_empleado`)
    REFERENCES `karenina`.`EMPLEADOS` (`id_empleado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_IDENTIFICADORES_TP_IDENTIFICADORES2_idx` ON `karenina`.`IDENTIFICADORES_FISCALES` (`id_tipo_identificador` ASC);

CREATE INDEX `fk_IDENTIFICADORES_EMPLEADOS1_idx` ON `karenina`.`IDENTIFICADORES_FISCALES` (`id_empleado` ASC);


-- -----------------------------------------------------
-- Table `karenina`.`TP_CONTACTOS`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `karenina`.`TP_CONTACTOS` ;

CREATE TABLE IF NOT EXISTS `karenina`.`TP_CONTACTOS` (
  `tipo_contacto` TINYINT(3) NOT NULL,
  `descripcion` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`tipo_contacto`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `karenina`.`CONTACTOS`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `karenina`.`CONTACTOS` ;

CREATE TABLE IF NOT EXISTS `karenina`.`CONTACTOS` (
  `id_contacto` INT NOT NULL AUTO_INCREMENT,
  `id_empleado` INT NOT NULL,
  `descripcion` VARCHAR(45) NOT NULL,
  `tipo_contacto` TINYINT(3) NOT NULL,
  PRIMARY KEY (`id_contacto`, `id_empleado`),
  CONSTRAINT `fk_CONTACTOS_TP_CONTACTOS1`
    FOREIGN KEY (`tipo_contacto`)
    REFERENCES `karenina`.`TP_CONTACTOS` (`tipo_contacto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_CONTACTOS_EMPLEADOS1`
    FOREIGN KEY (`id_empleado`)
    REFERENCES `karenina`.`EMPLEADOS` (`id_empleado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_CONTACTOS_TP_CONTACTOS1_idx` ON `karenina`.`CONTACTOS` (`tipo_contacto` ASC);

CREATE INDEX `fk_CONTACTOS_EMPLEADOS1_idx` ON `karenina`.`CONTACTOS` (`id_empleado` ASC);


-- -----------------------------------------------------
-- Table `karenina`.`TP_PAISES`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `karenina`.`TP_PAISES` ;

CREATE TABLE IF NOT EXISTS `karenina`.`TP_PAISES` (
  `id_pais` SMALLINT(4) NOT NULL,
  `descripcion` VARCHAR(45) NULL,
  PRIMARY KEY (`id_pais`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `karenina`.`TP_PROVINCIAS`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `karenina`.`TP_PROVINCIAS` ;

CREATE TABLE IF NOT EXISTS `karenina`.`TP_PROVINCIAS` (
  `id_provincia` SMALLINT(4) NOT NULL,
  `id_pais` SMALLINT(4) NOT NULL,
  PRIMARY KEY (`id_provincia`),
  CONSTRAINT `fk_TP_PROVINCIAS_TP_PAISES1`
    FOREIGN KEY (`id_pais`)
    REFERENCES `karenina`.`TP_PAISES` (`id_pais`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_TP_PROVINCIAS_TP_PAISES1_idx` ON `karenina`.`TP_PROVINCIAS` (`id_pais` ASC);


-- -----------------------------------------------------
-- Table `karenina`.`DIRECCIONES`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `karenina`.`DIRECCIONES` ;

CREATE TABLE IF NOT EXISTS `karenina`.`DIRECCIONES` (
  `id_direccion` INT NOT NULL AUTO_INCREMENT,
  `puerta` VARCHAR(2) NULL,
  `id_provincia` SMALLINT(4) NOT NULL,
  `planta` SMALLINT(3) NULL,
  `bloque` VARCHAR(10) NULL,
  `portal` SMALLINT(4) NULL,
  `calle` VARCHAR(50) NULL,
  `ciudad` VARCHAR(50) NULL,
  `codigo_postal` VARCHAR(10) NULL,
  `id_pais` SMALLINT(4) NOT NULL,
  PRIMARY KEY (`id_direccion`),
  CONSTRAINT `fk_DIRECCIONES_TP_PROVINCIAS1`
    FOREIGN KEY (`id_provincia`)
    REFERENCES `karenina`.`TP_PROVINCIAS` (`id_provincia`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_DIRECCIONES_TP_PAISES1`
    FOREIGN KEY (`id_pais`)
    REFERENCES `karenina`.`TP_PAISES` (`id_pais`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_DIRECCIONES_TP_PROVINCIAS1_idx` ON `karenina`.`DIRECCIONES` (`id_provincia` ASC);

CREATE INDEX `fk_DIRECCIONES_TP_PAISES1_idx` ON `karenina`.`DIRECCIONES` (`id_pais` ASC);


-- -----------------------------------------------------
-- Table `karenina`.`REL_CONTACTO_DIRECCIONES`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `karenina`.`REL_CONTACTO_DIRECCIONES` ;

CREATE TABLE IF NOT EXISTS `karenina`.`REL_CONTACTO_DIRECCIONES` (
  `id_contacto` INT NOT NULL,
  `id_direccion` INT NOT NULL,
  PRIMARY KEY (`id_contacto`, `id_direccion`),
  CONSTRAINT `fk_REL_CONTACTO_DIRECCIONES_CONTACTOS1`
    FOREIGN KEY (`id_contacto`)
    REFERENCES `karenina`.`CONTACTOS` (`id_contacto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_REL_CONTACTO_DIRECCIONES_DIRECCIONES1`
    FOREIGN KEY (`id_direccion`)
    REFERENCES `karenina`.`DIRECCIONES` (`id_direccion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_REL_CONTACTO_DIRECCIONES_CONTACTOS1_idx` ON `karenina`.`REL_CONTACTO_DIRECCIONES` (`id_contacto` ASC);

CREATE INDEX `fk_REL_CONTACTO_DIRECCIONES_DIRECCIONES1_idx` ON `karenina`.`REL_CONTACTO_DIRECCIONES` (`id_direccion` ASC);


-- -----------------------------------------------------
-- Table `karenina`.`TP_AUSENCIA`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `karenina`.`TP_AUSENCIA` ;

CREATE TABLE IF NOT EXISTS `karenina`.`TP_AUSENCIA` (
  `id_tipo_ausencia` TINYINT(2) NOT NULL,
  `descripcion` VARCHAR(45) NULL,
  PRIMARY KEY (`id_tipo_ausencia`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `karenina`.`AUSENCIAS`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `karenina`.`AUSENCIAS` ;

CREATE TABLE IF NOT EXISTS `karenina`.`AUSENCIAS` (
  `id_ausencia` INT NOT NULL AUTO_INCREMENT,
  `id_empleado` INT NOT NULL,
  `id_tipo_ausencia` TINYINT(2) NOT NULL,
  `fecha_desde` BIGINT(8) NOT NULL,
  `fecha_hasta` BIGINT(8) NOT NULL,
  `observaciones` VARCHAR(300) NULL,
  PRIMARY KEY (`id_ausencia`, `id_empleado`, `id_tipo_ausencia`),
  CONSTRAINT `fk_AUSENCIAS_EMPLEADOS1`
    FOREIGN KEY (`id_empleado`)
    REFERENCES `karenina`.`EMPLEADOS` (`id_empleado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_AUSENCIAS_TP_AUSENCIA1`
    FOREIGN KEY (`id_tipo_ausencia`)
    REFERENCES `karenina`.`TP_AUSENCIA` (`id_tipo_ausencia`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_AUSENCIAS_EMPLEADOS1_idx` ON `karenina`.`AUSENCIAS` (`id_empleado` ASC);

CREATE INDEX `fk_AUSENCIAS_TP_AUSENCIA1_idx` ON `karenina`.`AUSENCIAS` (`id_tipo_ausencia` ASC);


-- -----------------------------------------------------
-- Table `karenina`.`VACACIONES`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `karenina`.`VACACIONES` ;

CREATE TABLE IF NOT EXISTS `karenina`.`VACACIONES` (
  `id_empleado` INT NOT NULL,
  `id_tipo_ausencia` TINYINT(2) NOT NULL,
  `ejercicio_fiscal` SMALLINT(5) NOT NULL,
  `timestamp` BIGINT(14) NOT NULL,
  `dias_permitidos` VARCHAR(45) NOT NULL,
  `dias_disfrutados` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_empleado`, `id_tipo_ausencia`, `ejercicio_fiscal`),
  CONSTRAINT `fk_VACACIONES_EMPLEADOS1`
    FOREIGN KEY (`id_empleado`)
    REFERENCES `karenina`.`EMPLEADOS` (`id_empleado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_VACACIONES_TP_AUSENCIA1`
    FOREIGN KEY (`id_tipo_ausencia`)
    REFERENCES `karenina`.`TP_AUSENCIA` (`id_tipo_ausencia`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_VACACIONES_TP_AUSENCIA1_idx` ON `karenina`.`VACACIONES` (`id_tipo_ausencia` ASC);


-- -----------------------------------------------------
-- Table `karenina`.`TP_DOCUMENTO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `karenina`.`TP_DOCUMENTO` ;

CREATE TABLE IF NOT EXISTS `karenina`.`TP_DOCUMENTO` (
  `id_tp_documento` TINYINT(2) NOT NULL,
  `descripcion` VARCHAR(45) NULL,
  PRIMARY KEY (`id_tp_documento`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `karenina`.`DOCUMENTOS`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `karenina`.`DOCUMENTOS` ;

CREATE TABLE IF NOT EXISTS `karenina`.`DOCUMENTOS` (
  `id_documento` INT NOT NULL,
  `id_tp_documento` TINYINT(2) NOT NULL,
  `documento` VARCHAR(45) NULL,
  `descripcion` VARCHAR(45) NULL,
  PRIMARY KEY (`id_documento`),
  CONSTRAINT `fk_DOCUMENTOS_TP_DOCUMENTO1`
    FOREIGN KEY (`id_tp_documento`)
    REFERENCES `karenina`.`TP_DOCUMENTO` (`id_tp_documento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_DOCUMENTOS_TP_DOCUMENTO1_idx` ON `karenina`.`DOCUMENTOS` (`id_tp_documento` ASC);


-- -----------------------------------------------------
-- Table `karenina`.`REL_AUSENCIA_DOCUMENTO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `karenina`.`REL_AUSENCIA_DOCUMENTO` ;

CREATE TABLE IF NOT EXISTS `karenina`.`REL_AUSENCIA_DOCUMENTO` (
  `id_ausencia` INT NOT NULL,
  `id_documento` INT NOT NULL,
  `id_tp_documento` TINYINT(2) NOT NULL,
  PRIMARY KEY (`id_ausencia`, `id_documento`),
  CONSTRAINT `fk_REL_AUSENCIA_DOCUMENTO_TP_DOCUMENTO1`
    FOREIGN KEY (`id_tp_documento`)
    REFERENCES `karenina`.`TP_DOCUMENTO` (`id_tp_documento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_REL_AUSENCIA_DOCUMENTO_AUSENCIAS1`
    FOREIGN KEY (`id_ausencia`)
    REFERENCES `karenina`.`AUSENCIAS` (`id_ausencia`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_REL_AUSENCIA_DOCUMENTO_DOCUMENTOS1`
    FOREIGN KEY (`id_documento`)
    REFERENCES `karenina`.`DOCUMENTOS` (`id_documento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_REL_AUSENCIA_DOCUMENTO_TP_DOCUMENTO1_idx` ON `karenina`.`REL_AUSENCIA_DOCUMENTO` (`id_tp_documento` ASC);

CREATE INDEX `fk_REL_AUSENCIA_DOCUMENTO_AUSENCIAS1_idx` ON `karenina`.`REL_AUSENCIA_DOCUMENTO` (`id_ausencia` ASC);

CREATE INDEX `fk_REL_AUSENCIA_DOCUMENTO_DOCUMENTOS1_idx` ON `karenina`.`REL_AUSENCIA_DOCUMENTO` (`id_documento` ASC);


-- -----------------------------------------------------
-- Table `karenina`.`PERIODOS_VACACIONES`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `karenina`.`PERIODOS_VACACIONES` ;

CREATE TABLE IF NOT EXISTS `karenina`.`PERIODOS_VACACIONES` (
  `id_empleado` INT NOT NULL,
  `id_tipo_ausencia` TINYINT(2) NOT NULL,
  `ejercicio_fiscal` SMALLINT(5) NOT NULL,
  `fecha_desde` BIGINT(8) NOT NULL,
  `fecha_hasta` BIGINT(8) NOT NULL,
  PRIMARY KEY (`id_empleado`, `id_tipo_ausencia`, `ejercicio_fiscal`),
  CONSTRAINT `fk_PERIODOS_VACACIONES_VACACIONES1`
    FOREIGN KEY (`id_empleado` , `id_tipo_ausencia` , `ejercicio_fiscal`)
    REFERENCES `karenina`.`VACACIONES` (`id_empleado` , `id_tipo_ausencia` , `ejercicio_fiscal`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `karenina`.`HORARIOS`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `karenina`.`HORARIOS` ;

CREATE TABLE IF NOT EXISTS `karenina`.`HORARIOS` (
  `id_horario` INT NOT NULL AUTO_INCREMENT,
  `id_empleado` INT NOT NULL,
  `ejercicio_fiscal` SMALLINT(5) NOT NULL,
  `semana` TINYINT(2) NOT NULL,
  `activo` TINYINT(1) NOT NULL,
  PRIMARY KEY (`id_horario`, `id_empleado`, `ejercicio_fiscal`, `semana`),
  CONSTRAINT `fk_HORARIOS_EMPLEADOS1`
    FOREIGN KEY (`id_empleado`)
    REFERENCES `karenina`.`EMPLEADOS` (`id_empleado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_HORARIOS_EMPLEADOS1_idx` ON `karenina`.`HORARIOS` (`id_empleado` ASC);


-- -----------------------------------------------------
-- Table `karenina`.`TP_DIA_SEMANA`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `karenina`.`TP_DIA_SEMANA` ;

CREATE TABLE IF NOT EXISTS `karenina`.`TP_DIA_SEMANA` (
  `id_tipo_dia` TINYINT(1) NOT NULL,
  `descripcion` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_tipo_dia`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `karenina`.`TURNOS`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `karenina`.`TURNOS` ;

CREATE TABLE IF NOT EXISTS `karenina`.`TURNOS` (
  `id_turno` TINYINT(1) NOT NULL,
  `descripcion` VARCHAR(45) NOT NULL,
  `hora_inicio` SMALLINT(4) NOT NULL,
  `hora_finalizacion` SMALLINT(4) NOT NULL,
  PRIMARY KEY (`id_turno`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `karenina`.`DETALLE_HORARIO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `karenina`.`DETALLE_HORARIO` ;

CREATE TABLE IF NOT EXISTS `karenina`.`DETALLE_HORARIO` (
  `id_horario` INT NOT NULL,
  `id_tipo_dia` TINYINT(1) NOT NULL,
  `id_turno` TINYINT(1) NOT NULL,
  PRIMARY KEY (`id_horario`, `id_tipo_dia`, `id_turno`),
  CONSTRAINT `fk_DETALLE_HORARIO_HORARIOS1`
    FOREIGN KEY (`id_horario`)
    REFERENCES `karenina`.`HORARIOS` (`id_horario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_DETALLE_HORARIO_TP_DIA_SEMANA1`
    FOREIGN KEY (`id_tipo_dia`)
    REFERENCES `karenina`.`TP_DIA_SEMANA` (`id_tipo_dia`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_DETALLE_HORARIO_TURNOS1`
    FOREIGN KEY (`id_turno`)
    REFERENCES `karenina`.`TURNOS` (`id_turno`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_DETALLE_HORARIO_HORARIOS1_idx` ON `karenina`.`DETALLE_HORARIO` (`id_horario` ASC);

CREATE INDEX `fk_DETALLE_HORARIO_TP_DIA_SEMANA1_idx` ON `karenina`.`DETALLE_HORARIO` (`id_tipo_dia` ASC);

CREATE INDEX `fk_DETALLE_HORARIO_TURNOS1_idx` ON `karenina`.`DETALLE_HORARIO` (`id_turno` ASC);


-- -----------------------------------------------------
-- Table `karenina`.`TP_CONTRATOS`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `karenina`.`TP_CONTRATOS` ;

CREATE TABLE IF NOT EXISTS `karenina`.`TP_CONTRATOS` (
  `id_tp_contrato` TINYINT(3) NOT NULL,
  `descripcion` VARCHAR(45) NULL,
  PRIMARY KEY (`id_tp_contrato`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `karenina`.`CONTRATO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `karenina`.`CONTRATO` ;

CREATE TABLE IF NOT EXISTS `karenina`.`CONTRATO` (
  `id_contrato` INT NOT NULL AUTO_INCREMENT,
  `id_tp_contrato` TINYINT(3) NOT NULL,
  `id_empleado` INT NOT NULL,
  `fecha_inicio` BIGINT(8) NULL,
  `fecha_finalizacion` BIGINT(8) NULL,
  `activo` TINYINT(1) NOT NULL,
  PRIMARY KEY (`id_contrato`, `id_empleado`),
  CONSTRAINT `fk_CONTRATO_TP_CONTRATOS1`
    FOREIGN KEY (`id_tp_contrato`)
    REFERENCES `karenina`.`TP_CONTRATOS` (`id_tp_contrato`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_CONTRATO_EMPLEADOS1`
    FOREIGN KEY (`id_empleado`)
    REFERENCES `karenina`.`EMPLEADOS` (`id_empleado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_CONTRATO_TP_CONTRATOS1_idx` ON `karenina`.`CONTRATO` (`id_tp_contrato` ASC);

CREATE INDEX `fk_CONTRATO_EMPLEADOS1_idx` ON `karenina`.`CONTRATO` (`id_empleado` ASC);


-- -----------------------------------------------------
-- Table `karenina`.`EMPRESA`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `karenina`.`EMPRESA` ;

CREATE TABLE IF NOT EXISTS `karenina`.`EMPRESA` (
  `id_contrato` INT NOT NULL,
  `id_empresa` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_contrato`, `id_empresa`),
  CONSTRAINT `fk_EMPRESA_CONTRATO1`
    FOREIGN KEY (`id_contrato`)
    REFERENCES `karenina`.`CONTRATO` (`id_contrato`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `karenina`.`TP_MESES`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `karenina`.`TP_MESES` ;

CREATE TABLE IF NOT EXISTS `karenina`.`TP_MESES` (
  `id_mes` TINYINT(2) NOT NULL,
  `descripcion` VARCHAR(45) NULL,
  PRIMARY KEY (`id_mes`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `karenina`.`TP_HABERES`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `karenina`.`TP_HABERES` ;

CREATE TABLE IF NOT EXISTS `karenina`.`TP_HABERES` (
  `id_haber` TINYINT(3) NOT NULL,
  `descripcion` VARCHAR(45) NULL,
  PRIMARY KEY (`id_haber`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `karenina`.`HABERES`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `karenina`.`HABERES` ;

CREATE TABLE IF NOT EXISTS `karenina`.`HABERES` (
  `id_remuneracion` INT NOT NULL,
  `id_contrato` INT NOT NULL,
  `id_empleado` INT NOT NULL,
  `id_documento` INT NOT NULL,
  `id_mes` TINYINT(2) NOT NULL,
  `id_haber` TINYINT(3) NOT NULL,
  `ejercicio_fiscal` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_remuneracion`, `id_contrato`, `id_empleado`, `id_documento`, `id_mes`, `id_haber`),
  CONSTRAINT `fk_NOMINAS_CONTRATO1`
    FOREIGN KEY (`id_contrato` , `id_empleado`)
    REFERENCES `karenina`.`CONTRATO` (`id_contrato` , `id_empleado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_NOMINAS_DOCUMENTOS1`
    FOREIGN KEY (`id_documento`)
    REFERENCES `karenina`.`DOCUMENTOS` (`id_documento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_HABERES_TP_MESES1`
    FOREIGN KEY (`id_mes`)
    REFERENCES `karenina`.`TP_MESES` (`id_mes`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_HABERES_TP_HABERES1`
    FOREIGN KEY (`id_haber`)
    REFERENCES `karenina`.`TP_HABERES` (`id_haber`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_NOMINAS_CONTRATO1_idx` ON `karenina`.`HABERES` (`id_contrato` ASC, `id_empleado` ASC);

CREATE INDEX `fk_NOMINAS_DOCUMENTOS1_idx` ON `karenina`.`HABERES` (`id_documento` ASC);

CREATE INDEX `fk_HABERES_TP_MESES1_idx` ON `karenina`.`HABERES` (`id_mes` ASC);

CREATE INDEX `fk_HABERES_TP_HABERES1_idx` ON `karenina`.`HABERES` (`id_haber` ASC);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
