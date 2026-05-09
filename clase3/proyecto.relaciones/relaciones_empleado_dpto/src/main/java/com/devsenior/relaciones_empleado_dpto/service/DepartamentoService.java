package com.devsenior.relaciones_empleado_dpto.service;

import java.util.List;

import com.devsenior.relaciones_empleado_dpto.models.dto.request.DepartamentoRequestDTO;
import com.devsenior.relaciones_empleado_dpto.models.dto.response.DepartamentoResponseDTO;

public interface DepartamentoService {
    DepartamentoResponseDTO crear(DepartamentoRequestDTO request);
    List<DepartamentoResponseDTO> listar();
    DepartamentoResponseDTO buscarPorCodigo(Long codigo);
    void eliminar(Long codigo);
}
