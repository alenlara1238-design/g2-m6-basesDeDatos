package com.devsenior.relaciones_empleado_dpto.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsenior.relaciones_empleado_dpto.models.dto.request.DepartamentoRequestDTO;
import com.devsenior.relaciones_empleado_dpto.models.dto.response.DepartamentoResponseDTO;
import com.devsenior.relaciones_empleado_dpto.models.entity.Departamento;
import com.devsenior.relaciones_empleado_dpto.service.DepartamentoService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/departamentos")
@RequiredArgsConstructor
public class DepartamentoController {

    private final DepartamentoService departamentoService;

    @PostMapping
    public ResponseEntity<DepartamentoResponseDTO>crear(
        @Valid
        @RequestBody
        DepartamentoRequestDTO request
    ) {
        DepartamentoResponseDTO response = departamentoService.crear(request);

        return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(response);
    }
    
    @GetMapping
    public ResponseEntity<List<DepartamentoResponseDTO>> listar() {
        List<DepartamentoResponseDTO> response = departamentoService.listar();

        return ResponseEntity
        .ok(response);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<DepartamentoResponseDTO> buscarPorCodigo(
        @PathVariable Long codigo
    ) {
        DepartamentoResponseDTO response = departamentoService.buscarPorCodigo(codigo);

        return ResponseEntity
        .ok(response);
    }


    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> eliminar(
        @PathVariable Long codigo
    ) {
        departamentoService.eliminar(codigo);

        return ResponseEntity
        .noContent()
        .build();
    }



}
