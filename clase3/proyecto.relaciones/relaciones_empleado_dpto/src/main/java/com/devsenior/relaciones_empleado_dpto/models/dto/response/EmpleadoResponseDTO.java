package com.devsenior.relaciones_empleado_dpto.models.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class EmpleadoResponseDTO {
    private Long id;
    private String cedula;
    private String nombre;

    // En la respuesta sí podemos mostar infromación mas amigable.
    private String departamentoNombre;

    public record builder() {
    }
}
