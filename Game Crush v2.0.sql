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
  `email` VARCHAR(45) NOT NULL DEFAULT 'N/A',
  PRIMARY KEY (`idClientes`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gamecrush`.`Direccion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gamecrush`.`Direccion` ;

CREATE TABLE IF NOT EXISTS `gamecrush`.`Direccion` (
  `idDireccion` INT NOT NULL AUTO_INCREMENT,
  `calle` VARCHAR(45) NOT NULL,
  `colonia` VARCHAR(45) NOT NULL,
  `num_interior` VARCHAR(45) NULL DEFAULT 'N/A',
  `num_exterior` VARCHAR(45) NOT NULL,
  `estado` VARCHAR(45) NOT NULL,
  `pais` VARCHAR(45) NOT NULL,
  `ciudad` VARCHAR(45) NOT NULL,
  `codigo_postal` INT NOT NULL,
  `Clientes_idClientes` INT NOT NULL,
  PRIMARY KEY (`idDireccion`, `Clientes_idClientes`),
  CONSTRAINT `fk_Dirección_Clientes1`
    FOREIGN KEY (`Clientes_idClientes`)
    REFERENCES `gamecrush`.`Clientes` (`idClientes`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = '	';

CREATE INDEX `fk_Dirección_Clientes1_idx` ON `gamecrush`.`Direccion` (`Clientes_idClientes` ASC);


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
  `cantidad` INT NOT NULL,
  PRIMARY KEY (`idProductos`))
ENGINE = InnoDB;


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
  `precio_total` DOUBLE NOT NULL,
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
  `Descuento` DOUBLE NOT NULL,
  PRIMARY KEY (`idPedidos`),
  CONSTRAINT `fk_Pedidos_Clientes1`
    FOREIGN KEY (`Clientes_idClientes`)
    REFERENCES `gamecrush`.`Clientes` (`idClientes`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pedidos_Empleados1`
    FOREIGN KEY (`Empleados_idEmpleados`)
    REFERENCES `gamecrush`.`Empleados` (`idEmpleados`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_Pedidos_Clientes1_idx` ON `gamecrush`.`Pedidos` (`Clientes_idClientes` ASC);

CREATE INDEX `fk_Pedidos_Empleados1_idx` ON `gamecrush`.`Pedidos` (`Empleados_idEmpleados` ASC);


-- -----------------------------------------------------
-- Table `gamecrush`.`Productos_has_Pedidos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gamecrush`.`Productos_has_Pedidos` ;

CREATE TABLE IF NOT EXISTS `gamecrush`.`Productos_has_Pedidos` (
  `Productos_idProductos` INT NOT NULL,
  `Pedidos_idPedidos` INT NOT NULL,
  `Cantidad_Pedido` INT NOT NULL,
  CONSTRAINT `fk_Productos_has_Pedidos_Productos1`
    FOREIGN KEY (`Productos_idProductos`)
    REFERENCES `gamecrush`.`Productos` (`idProductos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Productos_has_Pedidos_Pedidos1`
    FOREIGN KEY (`Pedidos_idPedidos`)
    REFERENCES `gamecrush`.`Pedidos` (`idPedidos`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

CREATE INDEX `fk_Productos_has_Pedidos_Productos1_idx` ON `gamecrush`.`Productos_has_Pedidos` (`Productos_idProductos` ASC);

CREATE INDEX `fk_Productos_has_Pedidos_Pedidos1_idx` ON `gamecrush`.`Productos_has_Pedidos` (`Pedidos_idPedidos` ASC);


-- -----------------------------------------------------
-- Table `gamecrush`.`Productos_has_Ventas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gamecrush`.`Productos_has_Ventas` ;

CREATE TABLE IF NOT EXISTS `gamecrush`.`Productos_has_Ventas` (
  `Productos_idProductos` INT NOT NULL,
  `Ventas_idVentas` INT NOT NULL,
  `Cantidad_Venta` INT NOT NULL,
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


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `gamecrush`.`Clientes`
-- -----------------------------------------------------
START TRANSACTION;
USE `gamecrush`;
INSERT INTO `gamecrush`.`Clientes` (`idClientes`, `nombres`, `apellido_p`, `apellido_m`, `telefono`, `email`) VALUES (1, 'Sami', 'El', 'Salami', '6141967490', 'Salchichon@gmail.com');
INSERT INTO `gamecrush`.`Clientes` (`idClientes`, `nombres`, `apellido_p`, `apellido_m`, `telefono`, `email`) VALUES (2, 'Alan', 'Brito', 'Perez', '6141283530', 'Cables@gmail.com');

COMMIT;


-- -----------------------------------------------------
-- Data for table `gamecrush`.`Direccion`
-- -----------------------------------------------------
START TRANSACTION;
USE `gamecrush`;
INSERT INTO `gamecrush`.`Direccion` (`idDireccion`, `calle`, `colonia`, `num_interior`, `num_exterior`, `estado`, `pais`, `ciudad`, `codigo_postal`, `Clientes_idClientes`) VALUES (1, 'Pepperoni', 'Salchicha', NULL, '2', 'Chorizo', 'Italia', 'Bologna', 31125, 1);
INSERT INTO `gamecrush`.`Direccion` (`idDireccion`, `calle`, `colonia`, `num_interior`, `num_exterior`, `estado`, `pais`, `ciudad`, `codigo_postal`, `Clientes_idClientes`) VALUES (2, 'Hierro', 'Metalera', NULL, '666', 'Heavy', 'Fierro', 'Titanio', 16661, 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `gamecrush`.`Productos`
-- -----------------------------------------------------
START TRANSACTION;
USE `gamecrush`;
INSERT INTO `gamecrush`.`Productos` (`idProductos`, `nombre_producto`, `tipo`, `precio`, `proveedor`, `cantidad`) VALUES (1, 'Nintendo 3DS', 'Consola', 130.0, 'Nintendo', 35);
INSERT INTO `gamecrush`.`Productos` (`idProductos`, `nombre_producto`, `tipo`, `precio`, `proveedor`, `cantidad`) VALUES (2, 'Nintendo Wii', 'Consola', 190.0, 'Nintendo', 40);
INSERT INTO `gamecrush`.`Productos` (`idProductos`, `nombre_producto`, `tipo`, `precio`, `proveedor`, `cantidad`) VALUES (3, 'Pokemon X', 'Juego', 40.0, 'Nintendo', 25);
INSERT INTO `gamecrush`.`Productos` (`idProductos`, `nombre_producto`, `tipo`, `precio`, `proveedor`, `cantidad`) VALUES (4, 'Pokemon Y', 'Juego', 40.0, 'Nintendo', 25);
INSERT INTO `gamecrush`.`Productos` (`idProductos`, `nombre_producto`, `tipo`, `precio`, `proveedor`, `cantidad`) VALUES (5, 'Stylus Pen 3DS', 'Accesorio', 5.0, 'Nintendo', 100);
INSERT INTO `gamecrush`.`Productos` (`idProductos`, `nombre_producto`, `tipo`, `precio`, `proveedor`, `cantidad`) VALUES (6, 'Sony PlayStation 4', 'Consola', 299.0, 'Sony', 40);
INSERT INTO `gamecrush`.`Productos` (`idProductos`, `nombre_producto`, `tipo`, `precio`, `proveedor`, `cantidad`) VALUES (7, 'X-Box One', 'Consola', 299.0, 'Microsoft', 40);

COMMIT;


-- -----------------------------------------------------
-- Data for table `gamecrush`.`Puesto`
-- -----------------------------------------------------
START TRANSACTION;
USE `gamecrush`;
INSERT INTO `gamecrush`.`Puesto` (`idPuesto`, `nombre_puesto`) VALUES (1, 'Administrador');
INSERT INTO `gamecrush`.`Puesto` (`idPuesto`, `nombre_puesto`) VALUES (2, 'Vendedor');

COMMIT;


-- -----------------------------------------------------
-- Data for table `gamecrush`.`Empleados`
-- -----------------------------------------------------
START TRANSACTION;
USE `gamecrush`;
INSERT INTO `gamecrush`.`Empleados` (`idEmpleados`, `nombre`, `apellido_p`, `apellido_m`, `telefono`, `Puesto_idPuesto`) VALUES (1, 'Aquiles', 'Bailo', 'Esa', '1234', 1);
INSERT INTO `gamecrush`.`Empleados` (`idEmpleados`, `nombre`, `apellido_p`, `apellido_m`, `telefono`, `Puesto_idPuesto`) VALUES (2, 'Rosa', 'Flores', 'Ramos', '1234', 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `gamecrush`.`Pedidos`
-- -----------------------------------------------------
START TRANSACTION;
USE `gamecrush`;
INSERT INTO `gamecrush`.`Pedidos` (`idPedidos`, `precio_total`, `Clientes_idClientes`, `Empleados_idEmpleados`, `Descuento`) VALUES (1, 130, 1, 1, 20);

COMMIT;


-- -----------------------------------------------------
-- Data for table `gamecrush`.`Productos_has_Pedidos`
-- -----------------------------------------------------
START TRANSACTION;
USE `gamecrush`;
INSERT INTO `gamecrush`.`Productos_has_Pedidos` (`Productos_idProductos`, `Pedidos_idPedidos`, `Cantidad_Pedido`) VALUES (1, 1, 1);

COMMIT;

