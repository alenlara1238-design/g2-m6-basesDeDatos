package com.devsenior.relaciones_empleado_dpto.models.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepartamentoRequestDTO {

    @NotBlank(message = "El nombre del departamento no puede estar vacío")
    private String nombre;
}
