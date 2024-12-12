-- Crear la base de datos
CREATE DATABASE IF NOT EXISTS GestionEventos;
USE GestionEventos;

-- Crear la tabla de roles
CREATE TABLE IF NOT EXISTS roles (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL UNIQUE
);

-- Crear la tabla de usuarios
CREATE TABLE IF NOT EXISTS usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre_completo VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    rol_id INT NOT NULL,
    FOREIGN KEY (rol_id) REFERENCES roles(id) ON DELETE CASCADE
);

-- Crear la tabla de eventos
CREATE TABLE IF NOT EXISTS eventos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT NOT NULL,
    tipo VARCHAR(50) NOT NULL,
    fecha_inicio DATE NOT NULL,
    fecha_fin DATE NOT NULL,
    capacidad INT NOT NULL
);

-- Crear la tabla de reservas
CREATE TABLE IF NOT EXISTS reservas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    usuario_id INT NOT NULL,
    evento_id INT NOT NULL,
    fecha_reserva TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id) ON DELETE CASCADE,
    FOREIGN KEY (evento_id) REFERENCES eventos(id) ON DELETE CASCADE
);

-- Insertar datos iniciales en la tabla de roles
INSERT INTO roles (nombre) VALUES ('ADMINISTRADOR'), ('CLIENTE');

-- Insertar un administrador inicial (cambiar la contraseña encriptada por una válida)
INSERT INTO usuarios (nombre_completo, email, password, rol_id)
VALUES ('Admin General', 'admin@eventos.com', '$2a$10$abcdef...', 1);  -- Cambia la contraseña encriptada con bcrypt.

-- Insertar eventos iniciales (opcional)
INSERT INTO eventos (nombre, descripcion, tipo, fecha_inicio, fecha_fin, capacidad)
VALUES 
    ('Concierto Rock', 'Un concierto de música rock.', 'Concierto', '2024-12-15', '2024-12-15', 500),
    ('Conferencia Tech', 'Evento de tecnología y startups.', 'Conferencia', '2024-12-20', '2024-12-21', 300),
    ('Taller de Fotografía', 'Aprende técnicas avanzadas de fotografía.', 'Taller', '2024-12-10', '2024-12-10', 50);

-- Crear un usuario con privilegios completos sobre la base de datos
CREATE USER 'usuario_prueba'@'localhost' IDENTIFIED BY 'Usuar1o_Clave.';
GRANT ALL PRIVILEGES ON GestionEventos.* TO 'usuario_prueba'@'localhost';
FLUSH PRIVILEGES;

-- Verificar estructura
SHOW TABLES;
