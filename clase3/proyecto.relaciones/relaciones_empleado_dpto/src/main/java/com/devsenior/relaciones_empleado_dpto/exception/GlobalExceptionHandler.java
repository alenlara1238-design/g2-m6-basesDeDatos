package com.devsenior.relaciones_empleado_dpto.exception;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    // ---- RESOURCE NOT FOUND EXCEPTION ----
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiError> manejarNotFound(ResourceNotFoundException ex) {
        ApiError error = ApiError.builder()
                .mensaje(ex.getMessage())
                .status(HttpStatus.NOT_FOUND.value())
                .fecha(LocalDate.now())
                .build();
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(error);
    }

    // ---- DUPLICATE RESOURCE EXCEPTION ----
    @ExceptionHandler(DuplicatedResourceException.class)
    public ResponseEntity<ApiError> manejarDuplicate(DuplicatedResourceException ex) {
        ApiError error = ApiError.builder()
                .mensaje(ex.getMessage())
                .status(HttpStatus.CONFLICT.value())
                .fecha(LocalDate.now())
                .build();
            return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(error);
    }

    // ---- ERRORES MethodArgumentNotValidException ----
    @ExceptionHandler(MethodArgumentNotValidException.class)    
    public ResponseEntity<ApiError> manejarValidation(MethodArgumentNotValidException ex) {
        String mensaje = ex.getBindingResult().getFieldErrors().stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .reduce((msg1, msg2) -> msg1 + "; " + msg2)
                .orElse("Error de validación");
        ApiError error = ApiError.builder()
                .mensaje(mensaje)
                .status(HttpStatus.BAD_REQUEST.value())
                .fecha(LocalDate.now())
                .build();
            return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(error);
    }


    // ----ERRORES GENERALES ----
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> manejarGeneral(Exception ex) {
        ApiError error = ApiError.builder()
                .mensaje("Ocurrió un error inesperado: " + ex.getMessage())
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .fecha(LocalDate.now())
                .build();
            return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(error);
    }



}
