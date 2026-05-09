package com.devsenior.relaciones_empleado_dpto.service.impl;

import com.devsenior.relaciones_empleado_dpto.models.dto.request.DepartamentoRequestDTO;
import com.devsenior.relaciones_empleado_dpto.models.dto.response.DepartamentoResponseDTO;
import com.devsenior.relaciones_empleado_dpto.models.entity.Departamento;
import com.devsenior.relaciones_empleado_dpto.repository.DepartamentoRepository;
import com.devsenior.relaciones_empleado_dpto.service.DepartamentoService;

import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class DepartamentoServiceImpl implements DepartamentoService {

    
    private final DepartamentoRepository departamentoRepository;

    DepartamentoServiceImpl(DepartamentoRepository departamentoRepository) {
        this.departamentoRepository = departamentoRepository;
    }

    @Override
    public DepartamentoResponseDTO crear(DepartamentoRequestDTO request) {
        // Implementation for creating a department
        if(departamentoRepository.existsByNombre(request.getNombre())){
            throw new RuntimeException("Ya existe el departamento con el nombre: " + request.getNombre());
        }
        Departamento departamento = Departamento.builder()
                .nombre(request.getNombre())
                .build();
        Departamento guardado = departamentoRepository.save(departamento);

        return DepartamentoResponseDTO.builder()
                .codigo(guardado.getCodigo())
                .nombre(guardado.getNombre())
                .build();
    }

    @Override
    public List<DepartamentoResponseDTO> listar() {
        // Implementation for listing all departments
        return departamentoRepository.findAll().stream()
                .map(departamento -> DepartamentoResponseDTO.builder()
                        .codigo(departamento.getCodigo())
                        .nombre(departamento.getNombre())
                        .build())
                .toList();
    }

    @Override
    public DepartamentoResponseDTO buscarPorCodigo(Long codigo) {
        Departamento departamento = departamentoRepository.findById(codigo)
                .orElseThrow(() -> new RuntimeException("Departamento no encontrado con código: " + codigo));
        return DepartamentoResponseDTO.builder()
                .codigo(departamento.getCodigo())
                .nombre(departamento.getNombre())
                .build();
    }

    @Override
    public void eliminar(Long codigo) {
        if (!departamentoRepository.existsById(codigo)) {
            throw new RuntimeException("Departamento no encontrado con código: " + codigo);
        }
        departamentoRepository.deleteById(codigo);
    }
}
