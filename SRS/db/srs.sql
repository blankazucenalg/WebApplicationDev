-- MySQL Script generated by MySQL Workbench
-- vie 06 mar 2015 16:44:55 CST
-- Model: New Model    Version: 1.0
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema srs
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `srs` ;
CREATE SCHEMA IF NOT EXISTS `srs` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `srs` ;

-- -----------------------------------------------------
-- Table `srs`.`usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `srs`.`usuario` ;

CREATE TABLE IF NOT EXISTS `srs`.`usuario` (
  `iduser` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(80) NOT NULL,
  `lastname` VARCHAR(60) NULL,
  `surname` VARCHAR(60) NULL,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `role` INT NOT NULL,
  `date` DATE NOT NULL,
  PRIMARY KEY (`iduser`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `srs`.`asignatura`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `srs`.`asignatura` ;

CREATE TABLE IF NOT EXISTS `srs`.`asignatura` (
  `idasignatura` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(80) NOT NULL,
  PRIMARY KEY (`idasignatura`),
  UNIQUE INDEX `nombre_UNIQUE` (`nombre` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `srs`.`curso`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `srs`.`curso` ;

CREATE TABLE IF NOT EXISTS `srs`.`curso` (
  `idcurso` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `fecha_inicio` DATE NOT NULL,
  `fecha_fin` VARCHAR(45) NULL,
  `ubicacion` VARCHAR(50) NOT NULL,
  `horario` VARCHAR(45) NOT NULL,
  `precio` FLOAT NOT NULL,
  `usuario_idinstructor` INT NOT NULL,
  `asignatura_idasignatura` INT NOT NULL,
  PRIMARY KEY (`idcurso`),
  INDEX `fk_curso_usuario1_idx` (`usuario_idinstructor` ASC),
  INDEX `fk_curso_asignatura1_idx` (`asignatura_idasignatura` ASC),
  CONSTRAINT `fk_curso_usuario1`
    FOREIGN KEY (`usuario_idinstructor`)
    REFERENCES `srs`.`usuario` (`iduser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_curso_asignatura1`
    FOREIGN KEY (`asignatura_idasignatura`)
    REFERENCES `srs`.`asignatura` (`idasignatura`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `srs`.`pendiente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `srs`.`pendiente` ;

CREATE TABLE IF NOT EXISTS `srs`.`pendiente` (
  `idpendiente` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(50) NOT NULL,
  `fecha_entrega` DATE NOT NULL,
  `curso` INT NOT NULL,
  PRIMARY KEY (`idpendiente`),
  INDEX `fk_pendiente_curso_idx` (`curso` ASC),
  CONSTRAINT `fk_pendiente_curso`
    FOREIGN KEY (`curso`)
    REFERENCES `srs`.`curso` (`idcurso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `srs`.`estado`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `srs`.`estado` ;

CREATE TABLE IF NOT EXISTS `srs`.`estado` (
  `idestado` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idestado`),
  UNIQUE INDEX `nombre_UNIQUE` (`nombre` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `srs`.`municipio`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `srs`.`municipio` ;

CREATE TABLE IF NOT EXISTS `srs`.`municipio` (
  `idmunicipio` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `estado_idestado` INT NOT NULL,
  PRIMARY KEY (`idmunicipio`, `estado_idestado`),
  INDEX `fk_municipio_estado1_idx` (`estado_idestado` ASC),
  CONSTRAINT `fk_municipio_estado1`
    FOREIGN KEY (`estado_idestado`)
    REFERENCES `srs`.`estado` (`idestado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `srs`.`direccion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `srs`.`direccion` ;

CREATE TABLE IF NOT EXISTS `srs`.`direccion` (
  `iddireccion` INT NOT NULL AUTO_INCREMENT,
  `calle` VARCHAR(45) NOT NULL,
  `no_exterior` VARCHAR(45) NULL,
  `no_interior` VARCHAR(45) NULL,
  `colonia` VARCHAR(45) NOT NULL,
  `cp` VARCHAR(45) NOT NULL,
  `usuario_iduser` INT NOT NULL,
  `municipio_idmunicipio` INT NOT NULL,
  `municipio_estado_idestado` INT NOT NULL,
  PRIMARY KEY (`iddireccion`),
  INDEX `fk_direccion_usuario1_idx` (`usuario_iduser` ASC),
  INDEX `fk_direccion_municipio1_idx` (`municipio_idmunicipio` ASC, `municipio_estado_idestado` ASC),
  CONSTRAINT `fk_direccion_usuario1`
    FOREIGN KEY (`usuario_iduser`)
    REFERENCES `srs`.`usuario` (`iduser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_direccion_municipio1`
    FOREIGN KEY (`municipio_idmunicipio` , `municipio_estado_idestado`)
    REFERENCES `srs`.`municipio` (`idmunicipio` , `estado_idestado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `srs`.`telefono`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `srs`.`telefono` ;

CREATE TABLE IF NOT EXISTS `srs`.`telefono` (
  `idtelefono` INT NOT NULL AUTO_INCREMENT,
  `telefono` VARCHAR(15) NOT NULL,
  `usuario_iduser` INT NOT NULL,
  PRIMARY KEY (`idtelefono`),
  INDEX `fk_telefono_usuario1_idx` (`usuario_iduser` ASC),
  CONSTRAINT `fk_telefono_usuario1`
    FOREIGN KEY (`usuario_iduser`)
    REFERENCES `srs`.`usuario` (`iduser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `srs`.`email`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `srs`.`email` ;

CREATE TABLE IF NOT EXISTS `srs`.`email` (
  `idemail` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(80) NOT NULL,
  `usuario_iduser` INT NOT NULL,
  PRIMARY KEY (`idemail`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC),
  INDEX `fk_email_usuario1_idx` (`usuario_iduser` ASC),
  CONSTRAINT `fk_email_usuario1`
    FOREIGN KEY (`usuario_iduser`)
    REFERENCES `srs`.`usuario` (`iduser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `srs`.`alumno_has_pendiente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `srs`.`alumno_has_pendiente` ;

CREATE TABLE IF NOT EXISTS `srs`.`alumno_has_pendiente` (
  `usuario_idalumno` INT NOT NULL,
  `pendiente_idpendiente` INT NOT NULL,
  `calificacion` FLOAT NOT NULL,
  PRIMARY KEY (`usuario_idalumno`, `pendiente_idpendiente`),
  INDEX `fk_usuario_has_pendiente_pendiente1_idx` (`pendiente_idpendiente` ASC),
  INDEX `fk_usuario_has_pendiente_usuario1_idx` (`usuario_idalumno` ASC),
  CONSTRAINT `fk_usuario_has_pendiente_usuario1`
    FOREIGN KEY (`usuario_idalumno`)
    REFERENCES `srs`.`usuario` (`iduser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuario_has_pendiente_pendiente1`
    FOREIGN KEY (`pendiente_idpendiente`)
    REFERENCES `srs`.`pendiente` (`idpendiente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `srs`.`accion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `srs`.`accion` ;

CREATE TABLE IF NOT EXISTS `srs`.`accion` (
  `idaccion` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idaccion`),
  UNIQUE INDEX `nombre_UNIQUE` (`nombre` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `srs`.`historico`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `srs`.`historico` ;

CREATE TABLE IF NOT EXISTS `srs`.`historico` (
  `idhistorico` INT NOT NULL AUTO_INCREMENT,
  `fecha` DATE NOT NULL,
  `detalle` VARCHAR(80) NOT NULL,
  `accion_idaccion` INT NOT NULL,
  PRIMARY KEY (`idhistorico`),
  INDEX `fk_historico_accion1_idx` (`accion_idaccion` ASC),
  CONSTRAINT `fk_historico_accion1`
    FOREIGN KEY (`accion_idaccion`)
    REFERENCES `srs`.`accion` (`idaccion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
