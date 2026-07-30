DROP DATABASE IF EXISTS TecnoStore_DB;

CREATE database TecnoStore_DB;

USE TecnoStore_DB;

DROP USER IF EXISTS 'tecnostore'@'localhost';
CREATE USER 'tecnostore'@'localhost'
IDENTIFIED BY 'TecnoStore123!';

GRANT ALL PRIVILEGES
ON TecnoStore_DB.*
TO 'tecnostore'@'localhost';

FLUSH PRIVILEGES;


create table if not exists celulares(
	id_celular INT AUTO_INCREMENT PRIMARY KEY,
	marca VARCHAR(255) NOT NULL,
	modelo VARCHAR(255) NOT NULL,
	precio DECIMAL(10,2) NOT NULL,
	stock int NOT NULL,
	sistema_operativo ENUM('ANDROID','IOS') NOT NULL,
	gama ENUM('BAJA','MEDIA','ALTA') NOT null,
	disponible BOOL not NULL
);


create table if not exists clientes(
	id_cliente INT AUTO_INCREMENT PRIMARY KEY,
	nombre VARCHAR(255) NOT null,
	apellido VARCHAR(255) NOT null,
	identificacion VARCHAR(20) unique not null,
	correo VARCHAR(255) unique NOT null,
	telefono VARCHAR(20) not null
);


create table if not exists ventas(
	id_venta int AUTO_INCREMENT PRIMARY KEY,
	id_cliente int not null,
	fecha_venta TIMESTAMP DEFAULT CURRENT_TIMESTAMP(),
	sub_total decimal(10,2) NOT NULL DEFAULT 0.00,
    iva decimal(10,2) NOT NULL DEFAULT 0.00,
	total DECIMAL(10, 2) NOT NULL DEFAULT 0.00,

	FOREIGN KEY (id_cliente) REFERENCES clientes(id_cliente)
);


create table if not exists detalle_ventas(
	id_detalle INT AUTO_INCREMENT PRIMARY KEY,
	id_venta int not null,
	id_celular INT NOT null,
	cantidad INT NOT NULL,
	precio_unitario_congelado DECIMAL(10, 2) NOT NULL,

	FOREIGN KEY (id_celular) REFERENCES celulares(id_celular) ON DELETE RESTRICT ON UPDATE cascade,
	foreign key (id_venta) references ventas(id_venta) ON DELETE cascade ON UPDATE CASCADE
);


INSERT INTO celulares (marca, modelo, precio, stock, sistema_operativo, gama, disponible) VALUES
('Samsung', 'Galaxy A16', 699900.00, 15, 'ANDROID', 'BAJA', TRUE),
('Xiaomi', 'Redmi Note 14', 999900.00, 12, 'ANDROID', 'MEDIA', TRUE),
('Motorola', 'Moto G85', 1199900.00, 8, 'ANDROID', 'MEDIA', TRUE),
('Samsung', 'Galaxy S25', 4199900.00, 5, 'ANDROID', 'ALTA', TRUE),
('Apple', 'iPhone 16', 4999900.00, 4, 'IOS', 'ALTA', TRUE),
('Apple', 'iPhone 15', 3999900.00, 6, 'IOS', 'ALTA', TRUE),
('Xiaomi', 'POCO X7 Pro', 1899900.00, 9, 'ANDROID', 'ALTA', TRUE),
('Honor', 'X8c', 1099900.00, 10, 'ANDROID', 'MEDIA', TRUE),
('Realme', '12 Pro+', 1699900.00, 7, 'ANDROID', 'ALTA', TRUE),
('OPPO', 'A60', 899900.00, 14, 'ANDROID', 'BAJA', TRUE),
('Infinix', 'Note 40', 1099900.00, 11, 'ANDROID', 'MEDIA', TRUE),
('Tecno', 'Spark 30', 649900.00, 20, 'ANDROID', 'BAJA', TRUE),
('Samsung', 'Galaxy Z Flip6', 5499900.00, 2, 'ANDROID', 'ALTA', TRUE),
('Apple', 'iPhone SE (2022)', 2499900.00, 5, 'IOS', 'MEDIA', TRUE),
('Motorola', 'Edge 50 Fusion', 1799900.00, 6, 'ANDROID', 'ALTA', TRUE);


INSERT INTO clientes (nombre, apellido, identificacion, correo, telefono) VALUES
('Juan', 'Pérez', '1001001001', 'juan.perez@gmail.com', '3001234567'),
('María', 'Gómez', '1001001002', 'maria.gomez@gmail.com', '3012345678'),
('Carlos', 'Rodríguez', '1001001003', 'carlos.rodriguez@gmail.com', '3023456789'),
('Laura', 'Martínez', '1001001004', 'laura.martinez@gmail.com', '3034567890'),
('Andrés', 'López', '1001001005', 'andres.lopez@gmail.com', '3045678901'),
('Sofía', 'Ramírez', '1001001006', 'sofia.ramirez@gmail.com', '3056789012'),
('David', 'Torres', '1001001007', 'david.torres@gmail.com', '3067890123'),
('Valentina', 'Morales', '1001001008', 'valentina.morales@gmail.com', '3078901234'),
('Miguel', 'Castro', '1001001009', 'miguel.castro@gmail.com', '3089012345'),
('Camila', 'Herrera', '1001001010', 'camila.herrera@gmail.com', '3090123456'),
('Daniel', 'Vargas', '1001001011', 'daniel.vargas@gmail.com', '3101234567'),
('Isabella', 'Rojas', '1001001012', 'isabella.rojas@gmail.com', '3112345678'),
('Sebastián', 'Ortiz', '1001001013', 'sebastian.ortiz@gmail.com', '3123456789'),
('Gabriela', 'Navarro', '1001001014', 'gabriela.navarro@gmail.com', '3134567890'),
('Felipe', 'Silva', '1001001015', 'felipe.silva@gmail.com', '3145678901'),
('Natalia', 'Jiménez', '1001001016', 'natalia.jimenez@gmail.com', '3156789012');

