SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `gamecrush` ;
CREATE SCHEMA IF NOT EXISTS `gamecrush` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `gamecrush` ;

-- -----------------------------------------------------
-- Table `gamecrush`.`Clientes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gamecrush`.`Clientes` ;

CREATE TABLE IF NOT EXISTS `gamecrush`.`Clientes` (
  `idClientes` INT NOT NULL AUTO_INCREMENT,
  `nombres` VARCHAR(45) NOT NULL,
  `apellido_p` VARCHAR(45) NOT NULL,
  `apellido_m` VARCHAR(45) NOT NULL,
  `telefono` VARCHAR(45) NOT NULL,
  `e-mail` VARCHAR(45) NOT NULL DEFAULT 'N/A',
  PRIMARY KEY (`idClientes`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gamecrush`.`Dirección`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gamecrush`.`Dirección` ;

CREATE TABLE IF NOT EXISTS `gamecrush`.`Dirección` (
  `idDirección` INT NOT NULL AUTO_INCREMENT,
  `calle` VARCHAR(45) NOT NULL,
  `colonia` VARCHAR(45) NOT NULL,
  `num_interior` VARCHAR(45) NULL DEFAULT 'N/A',
  `num_exterior` VARCHAR(45) NOT NULL,
  `estado` VARCHAR(45) NOT NULL,
  `pais` VARCHAR(45) NOT NULL,
  `ciudad` VARCHAR(45) NOT NULL,
  `codigo_postal` INT NOT NULL,
  `Clientes_idClientes` INT NOT NULL,
  PRIMARY KEY (`idDirección`, `Clientes_idClientes`),
  CONSTRAINT `fk_Dirección_Clientes1`
    FOREIGN KEY (`Clientes_idClientes`)
    REFERENCES `gamecrush`.`Clientes` (`idClientes`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = '	';

CREATE INDEX `fk_Dirección_Clientes1_idx` ON `gamecrush`.`Dirección` (`Clientes_idClientes` ASC);


-- -----------------------------------------------------
-- Table `gamecrush`.`Productos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gamecrush`.`Productos` ;

CREATE TABLE IF NOT EXISTS `gamecrush`.`Productos` (
  `idProductos` INT NOT NULL AUTO_INCREMENT,
  `nombre_producto` VARCHAR(45) NOT NULL,
  `tipo` VARCHAR(45) NOT NULL,
  `precio` DOUBLE NOT NULL,
  `proveedor` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idProductos`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gamecrush`.`Preventas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gamecrush`.`Preventas` ;

CREATE TABLE IF NOT EXISTS `gamecrush`.`Preventas` (
  `idPreventas` INT NOT NULL AUTO_INCREMENT,
  `fecha_salida` DATETIME NOT NULL,
  `Clientes_idClientes` INT NOT NULL,
  `Productos_idProductos` INT NOT NULL,
  PRIMARY KEY (`idPreventas`),
  CONSTRAINT `fk_Preventas_Clientes1`
    FOREIGN KEY (`Clientes_idClientes`)
    REFERENCES `gamecrush`.`Clientes` (`idClientes`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Preventas_Productos1`
    FOREIGN KEY (`Productos_idProductos`)
    REFERENCES `gamecrush`.`Productos` (`idProductos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = '	';

CREATE INDEX `fk_Preventas_Clientes1_idx` ON `gamecrush`.`Preventas` (`Clientes_idClientes` ASC);

CREATE INDEX `fk_Preventas_Productos1_idx` ON `gamecrush`.`Preventas` (`Productos_idProductos` ASC);


-- -----------------------------------------------------
-- Table `gamecrush`.`Puesto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gamecrush`.`Puesto` ;

CREATE TABLE IF NOT EXISTS `gamecrush`.`Puesto` (
  `idPuesto` INT NOT NULL AUTO_INCREMENT,
  `nombre_puesto` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idPuesto`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gamecrush`.`Empleados`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gamecrush`.`Empleados` ;

CREATE TABLE IF NOT EXISTS `gamecrush`.`Empleados` (
  `idEmpleados` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido_p` VARCHAR(45) NOT NULL,
  `apellido_m` VARCHAR(45) NOT NULL,
  `telefono` VARCHAR(45) NOT NULL,
  `Puesto_idPuesto` INT NOT NULL,
  PRIMARY KEY (`idEmpleados`, `Puesto_idPuesto`),
  CONSTRAINT `fk_Empleados_Puesto1`
    FOREIGN KEY (`Puesto_idPuesto`)
    REFERENCES `gamecrush`.`Puesto` (`idPuesto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_Empleados_Puesto1_idx` ON `gamecrush`.`Empleados` (`Puesto_idPuesto` ASC);


-- -----------------------------------------------------
-- Table `gamecrush`.`Ventas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gamecrush`.`Ventas` ;

CREATE TABLE IF NOT EXISTS `gamecrush`.`Ventas` (
  `idVentas` INT NOT NULL AUTO_INCREMENT,
  `Empleados_idEmpleados` INT NOT NULL,
  PRIMARY KEY (`idVentas`),
  CONSTRAINT `fk_Ventas_Empleados1`
    FOREIGN KEY (`Empleados_idEmpleados`)
    REFERENCES `gamecrush`.`Empleados` (`idEmpleados`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_Ventas_Empleados1_idx` ON `gamecrush`.`Ventas` (`Empleados_idEmpleados` ASC);


-- -----------------------------------------------------
-- Table `gamecrush`.`Pedidos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gamecrush`.`Pedidos` ;

CREATE TABLE IF NOT EXISTS `gamecrush`.`Pedidos` (
  `idPedidos` INT NOT NULL AUTO_INCREMENT,
  `precio_total` DOUBLE NOT NULL,
  `Clientes_idClientes` INT NOT NULL,
  `Empleados_idEmpleados` INT NOT NULL,
  `Empleados_Puesto_idPuesto` INT NOT NULL,
  PRIMARY KEY (`idPedidos`),
  CONSTRAINT `fk_Pedidos_Clientes1`
    FOREIGN KEY (`Clientes_idClientes`)
    REFERENCES `gamecrush`.`Clientes` (`idClientes`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pedidos_Empleados1`
    FOREIGN KEY (`Empleados_idEmpleados` , `Empleados_Puesto_idPuesto`)
    REFERENCES `gamecrush`.`Empleados` (`idEmpleados` , `Puesto_idPuesto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_Pedidos_Clientes1_idx` ON `gamecrush`.`Pedidos` (`Clientes_idClientes` ASC);

CREATE INDEX `fk_Pedidos_Empleados1_idx` ON `gamecrush`.`Pedidos` (`Empleados_idEmpleados` ASC, `Empleados_Puesto_idPuesto` ASC);


-- -----------------------------------------------------
-- Table `gamecrush`.`Productos_has_Pedidos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gamecrush`.`Productos_has_Pedidos` ;

CREATE TABLE IF NOT EXISTS `gamecrush`.`Productos_has_Pedidos` (
  `Productos_idProductos` INT NOT NULL,
  `Pedidos_idPedidos` INT NOT NULL,
  PRIMARY KEY (`Productos_idProductos`, `Pedidos_idPedidos`),
  CONSTRAINT `fk_Productos_has_Pedidos_Productos1`
    FOREIGN KEY (`Productos_idProductos`)
    REFERENCES `gamecrush`.`Productos` (`idProductos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Productos_has_Pedidos_Pedidos1`
    FOREIGN KEY (`Pedidos_idPedidos`)
    REFERENCES `gamecrush`.`Pedidos` (`idPedidos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_Productos_has_Pedidos_Pedidos1_idx` ON `gamecrush`.`Productos_has_Pedidos` (`Pedidos_idPedidos` ASC);

CREATE INDEX `fk_Productos_has_Pedidos_Productos1_idx` ON `gamecrush`.`Productos_has_Pedidos` (`Productos_idProductos` ASC);


-- -----------------------------------------------------
-- Table `gamecrush`.`Productos_has_Ventas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gamecrush`.`Productos_has_Ventas` ;

CREATE TABLE IF NOT EXISTS `gamecrush`.`Productos_has_Ventas` (
  `Productos_idProductos` INT NOT NULL,
  `Ventas_idVentas` INT NOT NULL,
  PRIMARY KEY (`Productos_idProductos`, `Ventas_idVentas`),
  CONSTRAINT `fk_Productos_has_Ventas_Productos1`
    FOREIGN KEY (`Productos_idProductos`)
    REFERENCES `gamecrush`.`Productos` (`idProductos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Productos_has_Ventas_Ventas1`
    FOREIGN KEY (`Ventas_idVentas`)
    REFERENCES `gamecrush`.`Ventas` (`idVentas`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_Productos_has_Ventas_Ventas1_idx` ON `gamecrush`.`Productos_has_Ventas` (`Ventas_idVentas` ASC);

CREATE INDEX `fk_Productos_has_Ventas_Productos1_idx` ON `gamecrush`.`Productos_has_Ventas` (`Productos_idProductos` ASC);

INSERT INTO Puesto VALUES(1,"Administrador");
INSERT INTO Puesto VALUES(2,"Vendedor");


INSERT INTO Empleados VALUES(1,"Administrador","Admin","istrador","123",1);
INSERT INTO Empleados VALUES(2,"Vendedor","Vende","dor","123",2);

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
