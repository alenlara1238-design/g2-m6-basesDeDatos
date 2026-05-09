package com.devsenior.relaciones_empleado_dpto.models.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class DepartamentoResponseDTO {
    private Long codigo;
    private String nombre;
}
