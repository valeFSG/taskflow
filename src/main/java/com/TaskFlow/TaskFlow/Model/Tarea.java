package com.TaskFlow.TaskFlow.Model;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Tarea {
    private Long id;

    @NotBlank
    private String titulo;

    @NotBlank
    private String descripcion;

    @NotNull
    private Estado estado;

    @NotNull
    private Prioridad prioridad;

    @NotBlank
    private String responsable;

    private LocalDate fechaCreacion;

    @NotNull
    private LocalDate fechaLimite;
}


