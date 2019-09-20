-- MySQL Workbench Forward Engineering
drop database if exists DBEventos;
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `DBEventos` DEFAULT CHARACTER SET utf8 ;
USE `DBEventos` ;

-- -----------------------------------------------------
-- Table `mydb`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DBEventos`.`cliente` (
  `idcliente` INT NOT NULL AUTO_INCREMENT,
  `nombrecliente` VARCHAR(45) NOT NULL,
  `apellidoscliente` VARCHAR(45) NOT NULL,
  `telefonocliente` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `nit` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idcliente`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`MotivoReservacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DBEventos`.`MotivoReservacion` (
  `idmotivoreservacion` INT NOT NULL AUTO_INCREMENT,
  `cumpleanos` TINYINT NULL,
  `reuniontrabajo` TINYINT NULL,
  `casamiento` TINYINT NULL,
  `otro` VARCHAR(100) NULL,
  PRIMARY KEY (`idmotivoreservacion`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Sucursal`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DBEventos`.`Sucursal` (
  `idsucursal` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`idsucursal`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Salon`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DBEventos`.`Salon` (
  `idsalon` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`idsalon`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Reservacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DBEventos`.`Reservacion` (
  `idreservacion` INT NOT NULL AUTO_INCREMENT,
  `idsucursal` INT NOT NULL,
  `idsalon` INT NOT NULL,
  `fechainicial` DATETIME NOT NULL,
  `fechafinal` DATETIME NOT NULL,
  `idcliente` INT NOT NULL,
  `idmotivoreservacion` INT NOT NULL,
  PRIMARY KEY (`idreservacion`),
  INDEX `idmotivoreservacion_idx` (`idmotivoreservacion` ASC) VISIBLE,
  INDEX `idcliente_idx` (`idcliente` ASC) VISIBLE,
  INDEX `idsucursal_idx` (`idsucursal` ASC) VISIBLE,
  INDEX `idsalon_idx` (`idsalon` ASC) VISIBLE,
  CONSTRAINT `idmotivoreservacion`
    FOREIGN KEY (`idmotivoreservacion`)
    REFERENCES `DBEventos`.`MotivoReservacion` (`idmotivoreservacion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idcliente`
    FOREIGN KEY (`idcliente`)
    REFERENCES `DBEventos`.`cliente` (`idcliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idsucursal`
    FOREIGN KEY (`idsucursal`)
    REFERENCES `DBEventos`.`Sucursal` (`idsucursal`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idsalon`
    FOREIGN KEY (`idsalon`)
    REFERENCES `DBEventos`.`Salon` (`idsalon`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`tipoproductos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DBEventos`.`tipoproductos` (
  `idtipoproductos` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`idtipoproductos`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`productos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DBEventos`.`productos` (
  `idproductos` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(200) NOT NULL,
  `idtipoproducto` INT NOT NULL,
  PRIMARY KEY (`idproductos`),
  INDEX `idtipoproductos_idx` (`idtipoproducto` ASC) VISIBLE,
  CONSTRAINT `idtipoproductos`
    FOREIGN KEY (`idtipoproducto`)
    REFERENCES `DBEventos`.`tipoproductos` (`idtipoproductos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`detallecotizacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DBEventos`.`detallecotizacion` (
  `iddetallecotizacion` INT NOT NULL AUTO_INCREMENT,
  `idproductos` INT NOT NULL,
  `cantidad` INT NOT NULL,
  `precio` DOUBLE NOT NULL,
  PRIMARY KEY (`iddetallecotizacion`),
  INDEX `idproductos_idx` (`idproductos` ASC) VISIBLE,
  CONSTRAINT `idproductos`
    FOREIGN KEY (`idproductos`)
    REFERENCES `DBEventos`.`productos` (`idproductos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`cotizacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DBEventos`.`cotizacion` (
  `idcotizacion` INT NOT NULL AUTO_INCREMENT,
  `fechacotizacion` DATETIME NOT NULL,
  `idreservacion` INT NOT NULL,
  `iddetallecotizacion` INT NOT NULL,
  PRIMARY KEY (`idcotizacion`),
  INDEX `idreservacion_idx` (`idreservacion` ASC) VISIBLE,
  INDEX `iddetallecotizacion_idx` (`iddetallecotizacion` ASC) VISIBLE,
  CONSTRAINT `idreservacion`
    FOREIGN KEY (`idreservacion`)
    REFERENCES `DBEventos`.`Reservacion` (`idreservacion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `iddetallecotizacion`
    FOREIGN KEY (`iddetallecotizacion`)
    REFERENCES `DBEventos`.`detallecotizacion` (`iddetallecotizacion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`facturacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DBEventos`.`facturacion` (
  `idfacturacion` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(45) NOT NULL,
  `idcotizacion` INT NOT NULL,
  PRIMARY KEY (`idfacturacion`),
  INDEX `fk_facturacion_cotizacion1_idx` (`idcotizacion` ASC) VISIBLE,
  CONSTRAINT `fk_facturacion_cotizacion1`
    FOREIGN KEY (`idcotizacion`)
    REFERENCES `DBEventos`.`cotizacion` (`idcotizacion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
ROW_FORMAT = COMPACT;


-- -----------------------------------------------------
-- Table `mydb`.`detallefactura`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DBEventos`.`detallefactura` (
  `iddetallefactura` INT NOT NULL AUTO_INCREMENT,
  `idfacturacion` INT NOT NULL,
  `idproductos` INT NOT NULL,
  `cantidad` INT NOT NULL,
  `precio` DOUBLE NOT NULL,
  PRIMARY KEY (`iddetallefactura`),
  INDEX `idproducto_idx` (`idproductos` ASC) VISIBLE,
  INDEX `idfacturacion_idx` (`idfacturacion` ASC) VISIBLE,
  CONSTRAINT `idproducto`
    FOREIGN KEY (`idproductos`)
    REFERENCES `DBEventos`.`productos` (`idproductos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idfacturacion`
    FOREIGN KEY (`idfacturacion`)
    REFERENCES `DBEventos`.`facturacion` (`idfacturacion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;