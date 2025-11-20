-- phpMyAdmin SQL Dump
-- version 5.2.2
-- https://www.phpmyadmin.net/
--
-- Servidor: database:3306
-- Tiempo de generación: 20-11-2025 a las 10:36:08
-- Versión del servidor: 8.4.6
-- Versión de PHP: 8.2.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

--
-- Base de datos: `persutildb`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `blog`
--

CREATE TABLE `blog` (
  `id` bigint NOT NULL,
  `titulo` varchar(1024) CHARACTER SET utf32 COLLATE utf32_unicode_ci NOT NULL,
  `contenido` longtext CHARACTER SET utf32 COLLATE utf32_unicode_ci NOT NULL,
  `etiquetas` varchar(1024) CHARACTER SET utf32 COLLATE utf32_unicode_ci NOT NULL,
  `fecha_creacion` datetime NOT NULL,
  `fecha_modificacion` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `castanyera`
--

CREATE TABLE `castanyera` (
  `id` bigint NOT NULL,
  `titulo` varchar(255) NOT NULL,
  `comentario` longtext NOT NULL,
  `fecha_creación` datetime NOT NULL,
  `fecha_modificación` datetime NOT NULL,
  `publico` tinyint(1) NOT NULL,
  `imagen` varchar(255) NOT NULL,
  `etiquetas` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `blog`
--
ALTER TABLE `blog`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `castanyera`
--
ALTER TABLE `castanyera`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `blog`
--
ALTER TABLE `blog`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=57;

--
-- AUTO_INCREMENT de la tabla `castanyera`
--
ALTER TABLE `castanyera`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT;
COMMIT;
