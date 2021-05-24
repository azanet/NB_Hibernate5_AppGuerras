-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 23-05-2021 a las 03:53:30
-- Versión del servidor: 10.5.9-MariaDB-1
-- Versión de PHP: 7.4.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `guerras`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `contendiente`
--

CREATE TABLE `contendiente` (
  `id_contendiente` int(10) UNSIGNED NOT NULL,
  `ganador` int(1) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `id_guerra` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `contendiente`
--

INSERT INTO `contendiente` (`id_contendiente`, `ganador`, `nombre`, `id_guerra`) VALUES
(1, 1, 'Triple Entente', 1),
(2, 0, 'Triple Alianza', 1),
(3, 1, 'Aliados de la Segunda Guerra Mundial', 2),
(4, 0, 'Potencias del Eje', 2),
(5, 0, 'Blancos', 11),
(6, 1, 'Rebeldes', 11),
(7, 0, 'Frente Polisario', 5),
(8, 0, 'Marruecos-Mauritania', 5),
(9, 0, 'España Sublevada', 6),
(10, 0, 'España Republicana', 6),
(11, 0, 'República de Corea', 7),
(12, 0, ' República Popular Democrática de Corea', 7),
(13, 0, 'Imperio Otomano', 8),
(14, 1, 'Liga de los Balcanes', 8),
(15, 0, 'Fuerzas Búlgaras', 9),
(16, 1, 'Fuerzas Serbias y Griegas', 9),
(17, 0, 'Partido NACIONALISTA Chino', 10),
(18, 1, 'Partido COMUNISTA Chino', 10),
(33, 0, 'aaaaa', 12),
(34, 1, 'bbbbbb', 12);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `guerra`
--

CREATE TABLE `guerra` (
  `id_guerra` int(10) UNSIGNED NOT NULL,
  `anio_inicio` varchar(10) NOT NULL,
  `anio_fin` varchar(10) DEFAULT NULL,
  `nombre` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `guerra`
--

INSERT INTO `guerra` (`id_guerra`, `anio_inicio`, `anio_fin`, `nombre`) VALUES
(1, '1914-07-28', '1918-11-11', 'Primera Guerra Mundial'),
(2, '1939-09-01', '1945-08-14', 'Segunda Guerra Mundial'),
(5, '1975-01-01', '1991-01-01', 'Guerra del Sahara Occidental'),
(6, '1936-07-17', '1939-04-01', 'Guerra Civil Española'),
(7, '1950-06-25', '1953-07-27', 'Guerra de Corea'),
(8, '1912-01-01', '1913-01-01', 'Guerra de los Balcanes'),
(9, '1913-07-01', '1913-12-31', 'Segunda Guerra de los Balcanes'),
(10, '1927-08-01', '1950-05-01', 'Guerra Civil China'),
(11, '1964-07-04', '1979-04-24', 'Guerra Civil de Rodesia'),
(12, '2021-456', '2022', 'aaaaa bendito');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pais`
--

CREATE TABLE `pais` (
  `id_pais` int(10) UNSIGNED NOT NULL,
  `nombre` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `pais`
--

INSERT INTO `pais` (`id_pais`, `nombre`) VALUES
(89, 'aaaaaaaaaaaaa'),
(15, 'Alemania Nazi'),
(20, 'Australia'),
(29, 'Bélgica'),
(19, 'Canadá'),
(51, 'China'),
(27, 'Dinamarca'),
(22, 'Dominio de Terranova'),
(40, 'España'),
(35, 'Estados Unidos'),
(12, 'Francia'),
(36, 'Francia Libre'),
(8, 'Imperio Alemán'),
(9, 'Imperio Austrohúngaro'),
(16, 'Imperio de Japón'),
(45, 'Imperio Otomano'),
(13, 'Imperio Ruso'),
(30, 'Luxemburgo'),
(38, 'Marruecos'),
(39, 'Mauritania'),
(28, 'Noruega'),
(21, 'Nueva Zelanda'),
(31, 'Países Bajos'),
(18, 'Polonia'),
(24, 'Raj Británico'),
(49, 'Reino de Bulgaria'),
(32, 'Reino de Grecia'),
(17, 'Reino de Italia'),
(47, 'Reino de Montenegro'),
(26, 'Reino de Nepal'),
(50, 'Reino de Rumania'),
(46, 'Reino de Serbia'),
(33, 'Reino de Yugoslavia'),
(11, 'Reino Unido'),
(42, 'Republica de Corea'),
(44, 'República Popular China'),
(43, 'República Popular Democrática de Corea'),
(37, 'Rodesia'),
(79, 'sdsg3'),
(34, 'Unión Soviética'),
(23, 'Unión Sudáfricana');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `periodo_independecia`
--

CREATE TABLE `periodo_independecia` (
  `id_pais` int(10) UNSIGNED NOT NULL,
  `id_periodo` int(10) UNSIGNED NOT NULL,
  `anio_inicio` int(10) UNSIGNED NOT NULL,
  `anio_fin` int(10) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `periodo_independecia`
--

INSERT INTO `periodo_independecia` (`id_pais`, `id_periodo`, `anio_inicio`, `anio_fin`) VALUES
(8, 5, 1871, 1918),
(9, 6, 1867, 1914),
(13, 7, 1721, 1917),
(16, 9, 1868, 1945),
(15, 10, 1933, 1945),
(17, 11, 1861, 1946),
(18, 12, 1918, 1939),
(22, 13, 1907, 1949),
(23, 14, 1910, 1961),
(24, 15, 1858, 1947),
(26, 16, 900, 2008),
(32, 17, 1832, 1974),
(33, 18, 1929, 1945),
(34, 19, 1922, 1991),
(45, 20, 1281, 1923),
(49, 21, 1908, 1946),
(47, 22, 1910, 1918),
(46, 23, 1882, 1918),
(50, 24, 1881, 1947);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `union_bandos`
--

CREATE TABLE `union_bandos` (
  `id_union_bandos` int(11) NOT NULL,
  `id_contendiente` int(10) UNSIGNED NOT NULL,
  `id_pais` int(10) UNSIGNED NOT NULL,
  `fecha_union` varchar(10) DEFAULT NULL,
  `fecha_abandono` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `union_bandos`
--

INSERT INTO `union_bandos` (`id_union_bandos`, `id_contendiente`, `id_pais`, `fecha_union`, `fecha_abandono`) VALUES
(1, 1, 11, '1914-07-28', '1918-11-11'),
(2, 1, 12, '1914-07-28', '1918-11-11'),
(3, 1, 13, '1914-07-28', '1918-11-11'),
(4, 2, 8, '1914-07-28', '1918-11-11'),
(5, 2, 9, '1914-07-28', '1918-11-11'),
(6, 2, 17, '1914-07-28', '1918-11-11'),
(7, 3, 11, '1939-09-01', '1945-09-02'),
(8, 3, 18, '1939-09-01', '1945-09-02'),
(9, 3, 19, '1939-10-01', '1945-09-02'),
(10, 3, 20, '1939-10-01', '1945-09-02'),
(11, 3, 21, '1939-10-01', '1945-09-02'),
(12, 3, 22, '1939-10-01', '1945-09-02'),
(13, 3, 23, '1939-10-01', '1945-09-02'),
(14, 3, 24, '1939-10-01', '1945-09-02'),
(15, 3, 26, '1939-10-01', '1945-09-02'),
(16, 3, 27, '1940-01-01', '1945-09-02'),
(17, 3, 28, '1940-01-01', '1945-09-02'),
(18, 3, 29, '1940-01-01', '1945-09-02'),
(19, 3, 30, '1940-01-01', '1945-09-02'),
(20, 3, 31, '1940-01-01', '1945-09-02'),
(21, 3, 32, '1940-01-01', '1945-09-02'),
(22, 3, 33, '1941-01-01', '1945-09-02'),
(23, 3, 36, '1940-01-01', '1945-09-02'),
(24, 4, 15, '1939-09-01', '1945-09-02'),
(25, 4, 16, '1939-09-01', '1945-09-02'),
(26, 4, 17, '1939-09-01', '1945-09-02'),
(27, 5, 37, '1964-07-04', '1979-07-04'),
(28, 6, 37, '1964-07-04', '1979-07-04'),
(29, 8, 38, '1975-10-16', ''),
(30, 8, 39, '1975-10-16', ''),
(31, 9, 40, '1936-07-17', '1939-04-01'),
(32, 10, 40, '1936-07-17', '1939-04-01'),
(33, 11, 35, '1950-06-25', '1953-07-27'),
(34, 12, 34, '1950-06-25', '1953-07-27'),
(35, 12, 43, '1950-06-25', '1953-07-27'),
(36, 12, 44, '1950-06-25', '1953-07-27'),
(37, 13, 45, '1912-01-01', ''),
(38, 14, 32, '1912-01-01', ''),
(39, 14, 46, '1912-01-01', ''),
(40, 14, 47, '1912-01-01', ''),
(41, 14, 49, '1912-01-01', ''),
(42, 15, 49, '1913-06-29', ''),
(43, 16, 32, '1913-06-29', ''),
(44, 16, 45, '1913-06-29', ''),
(45, 16, 46, '1913-06-29', ''),
(46, 16, 47, '1913-06-29', ''),
(47, 16, 50, '1913-06-29', ''),
(48, 17, 51, '1927-08-01', ''),
(49, 18, 51, '1927-08-01', ''),
(70, 34, 89, '2021-05-23', ''),
(71, 33, 29, '2021-05-23', '');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `contendiente`
--
ALTER TABLE `contendiente`
  ADD PRIMARY KEY (`id_contendiente`),
  ADD UNIQUE KEY `nombre` (`nombre`),
  ADD KEY `c_fk` (`id_guerra`);

--
-- Indices de la tabla `guerra`
--
ALTER TABLE `guerra`
  ADD PRIMARY KEY (`id_guerra`),
  ADD UNIQUE KEY `nombre` (`nombre`);

--
-- Indices de la tabla `pais`
--
ALTER TABLE `pais`
  ADD PRIMARY KEY (`id_pais`),
  ADD UNIQUE KEY `nombre` (`nombre`);

--
-- Indices de la tabla `periodo_independecia`
--
ALTER TABLE `periodo_independecia`
  ADD PRIMARY KEY (`id_periodo`) USING BTREE,
  ADD UNIQUE KEY `id_pais` (`id_pais`);

--
-- Indices de la tabla `union_bandos`
--
ALTER TABLE `union_bandos`
  ADD PRIMARY KEY (`id_union_bandos`) USING BTREE,
  ADD UNIQUE KEY `uniques_pais_bando` (`id_pais`,`id_contendiente`) USING BTREE,
  ADD KEY `fk_contendiente` (`id_contendiente`) USING BTREE,
  ADD KEY `fk_pais` (`id_pais`) USING BTREE;

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `contendiente`
--
ALTER TABLE `contendiente`
  MODIFY `id_contendiente` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;

--
-- AUTO_INCREMENT de la tabla `guerra`
--
ALTER TABLE `guerra`
  MODIFY `id_guerra` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT de la tabla `pais`
--
ALTER TABLE `pais`
  MODIFY `id_pais` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=90;

--
-- AUTO_INCREMENT de la tabla `periodo_independecia`
--
ALTER TABLE `periodo_independecia`
  MODIFY `id_periodo` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=89;

--
-- AUTO_INCREMENT de la tabla `union_bandos`
--
ALTER TABLE `union_bandos`
  MODIFY `id_union_bandos` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=73;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `contendiente`
--
ALTER TABLE `contendiente`
  ADD CONSTRAINT `c_fk` FOREIGN KEY (`id_guerra`) REFERENCES `guerra` (`id_guerra`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `periodo_independecia`
--
ALTER TABLE `periodo_independecia`
  ADD CONSTRAINT `pi_fk` FOREIGN KEY (`id_pais`) REFERENCES `pais` (`id_pais`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `union_bandos`
--
ALTER TABLE `union_bandos`
  ADD CONSTRAINT `u_fk` FOREIGN KEY (`id_contendiente`) REFERENCES `contendiente` (`id_contendiente`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `u_fk2` FOREIGN KEY (`id_pais`) REFERENCES `pais` (`id_pais`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
