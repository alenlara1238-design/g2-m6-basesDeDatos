package com.devsenior.relaciones_empleado_dpto.service;

import java.util.List;

import com.devsenior.relaciones_empleado_dpto.models.dto.request.EmpleadoRequestDTO;
import com.devsenior.relaciones_empleado_dpto.models.dto.response.EmpleadoResponseDTO;

public interface EmpleadoService {
    EmpleadoResponseDTO crear(EmpleadoRequestDTO request);
    List<EmpleadoResponseDTO> listar();
    EmpleadoResponseDTO buscarPorId(Long id);
    void eliminar(Long codigo);
    List<EmpleadoResponseDTO> buscarPorNombre(String nombre);
}
