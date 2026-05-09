package com.devsenior.relaciones_empleado_dpto.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsenior.relaciones_empleado_dpto.models.dto.request.EmpleadoRequestDTO;
import com.devsenior.relaciones_empleado_dpto.models.dto.response.EmpleadoResponseDTO;
import com.devsenior.relaciones_empleado_dpto.service.EmpleadoService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/empleados")
@RequiredArgsConstructor
public class EmpleadoController {
    private final EmpleadoService empleadoService;


    @PostMapping
    public ResponseEntity<EmpleadoResponseDTO> crearEmpleado(
        @Valid
        @RequestBody 
        EmpleadoRequestDTO request
    ) {
        EmpleadoResponseDTO response = empleadoService.crear(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<EmpleadoResponseDTO>> listarEmpleados() {
        return ResponseEntity.ok(empleadoService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpleadoResponseDTO> buscarEmpleadoPorId(@PathVariable Long id) {
        EmpleadoResponseDTO response = empleadoService.buscarPorId(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<EmpleadoResponseDTO>> buscarPorNombre(
        @RequestParam String nombre
    )
        {
            List<EmpleadoResponseDTO> response = empleadoService.buscarPorNombre(nombre);
            return ResponseEntity.ok(response);
        }
        
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEmpleado(@PathVariable Long id) {
        empleadoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

}
