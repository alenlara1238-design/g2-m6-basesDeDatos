package com.devsenior.relaciones_empleado_dpto.exception;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ApiError {
    private String mensaje;
    private int status;
    private LocalDate fecha;
}
