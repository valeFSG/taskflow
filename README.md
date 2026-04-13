# TaskFlow API

Sistema de gestion de tareas desarrollado con Spring Boot.

## Descripción

Este proyecto permite administrar tareas mediante una API REST, aplicando buenas practicas de desarrollo como separacion de capas, validaciones y reglas de negocio.

## Funcionalidades

- Crear tareas
- Listar todas las tareas
- Buscar tarea por ID
- Filtrar tareas por estado
- Actualizar tareas
- Eliminar tareas
- Marcar tareas como completadas

## Reglas de negocio

- No se permiten tareas con títulos duplicados
- La fecha límite no puede ser anterior a la fecha actual
- Una tarea no puede completarse si ya está en estado COMPLETADA

## Tecnologías utilizadas

- Java
- Spring Boot
- Lombok
- Jakarta Validation

## Estructura del proyecto

- Controller: Manejo de endpoints y respuestas HTTP
- Service: Lógica de negocio y validaciones
- Repository: Simulación de base de datos en memoria
- Model: Entidades y enumeraciones

## Ejecución del proyecto

1. Clonar el repositorio
2. Ejecutar el proyecto con Maven
3. Probar los endpoints usando Postman o herramienta similar

## Endpoints principales

- GET /api/tareas
- GET /api/tareas/{id}
- POST /api/tareas
- PUT /api/tareas/{id}
- DELETE /api/tareas/{id}
- GET /api/tareas/estado/{estado}
- PUT /api/tareas/completar/{id}

## Autor

Valentina Santana
