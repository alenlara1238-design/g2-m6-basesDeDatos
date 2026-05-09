package com.devsenior.relaciones_empleado_dpto.models.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmpleadoRequestDTO {

    @NotBlank(message = "La cédula del empleado no puede estar vacía")
    private String cedula;

    @NotBlank(message = "El nombre del empleado no puede estar vacío")
    private String nombre;
    
    /*
        El cliente No enviará el departamento, solo enviará el código 
        del departamento al que pertenece el empleado, por lo tanto, no es necesario 
        incluir un campo de tipo DepartamentoRequestDTO en este DTO.
    */
   @NotNull(message = "El código del departamento no puede ser nulo")
   private Long departamentoCodigo;
}
