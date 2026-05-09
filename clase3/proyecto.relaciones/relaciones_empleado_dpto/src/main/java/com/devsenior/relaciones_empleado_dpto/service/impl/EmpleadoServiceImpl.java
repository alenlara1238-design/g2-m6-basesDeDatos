package com.devsenior.relaciones_empleado_dpto.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.devsenior.relaciones_empleado_dpto.models.dto.request.EmpleadoRequestDTO;
import com.devsenior.relaciones_empleado_dpto.models.dto.response.EmpleadoResponseDTO;
import com.devsenior.relaciones_empleado_dpto.models.entity.Departamento;
import com.devsenior.relaciones_empleado_dpto.models.entity.Empleado;
import com.devsenior.relaciones_empleado_dpto.repository.DepartamentoRepository;
import com.devsenior.relaciones_empleado_dpto.repository.EmpleadoRepository;
import com.devsenior.relaciones_empleado_dpto.service.EmpleadoService;

@Service
public class EmpleadoServiceImpl  implements EmpleadoService{
    private final EmpleadoRepository empleadoRepository;
    private final DepartamentoRepository departamentoRepository;

    public EmpleadoServiceImpl(EmpleadoRepository empleadoRepository, DepartamentoRepository departamentoRepository) {
        this.empleadoRepository = empleadoRepository;
        this.departamentoRepository = departamentoRepository;
    }

    @Override
    public EmpleadoResponseDTO crear(EmpleadoRequestDTO request) {

        //para crear un empleado necesitamos validar existencia previa de empleado y existencia del departamento al que se va a asociar el empleado
        if(empleadoRepository.existsByCedula(request.getCedula())){
            throw new RuntimeException("Ya existe un empleado con la cédula: " + request.getCedula());
        }

        Departamento departamento =
         departamentoRepository.findById(request.getDepartamentoCodigo())
                .orElseThrow(() -> new RuntimeException("Departamento no encontrado con código: " + request.getDepartamentoCodigo()));  
    

        // Si no existe empleado y existe el departamento, entonces podemos crear el empleado
        //creamos la entidad Empleado a partir del DTO de request y la información del departamento
        Empleado empleado = Empleado.builder()
                .nombre(request.getNombre())
                .cedula(request.getCedula())
                .departamento(departamento)
                .build();
            
        // aquí guardamos el empleado en la base de datos y luego convertimos la entidad guardada a un DTO de response para devolverlo al controlador
        Empleado guardado = empleadoRepository.save(empleado);
        return new EmpleadoResponseDTO.builder()
                .id(guardado.getId())
                .nombre(guardado.getNombre())
                .cedula(guardado.getCedula())
                .departamentoNombre(guardado.getDepartamento().getNombre())
                .build();
        
    }


    @Override
    public List<EmpleadoResponseDTO> listar() {
        return empleadoRepository.findAll().stream()
                .map(this::convertirDTO)
                .toList();
    }

    @Override
    public EmpleadoResponseDTO buscarPorId(Long id) {
        Empleado empleado = empleadoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado con id: " + id));
        return convertirDTO(empleado);
    }
        
    public List<EmpleadoResponseDTO> buscarPorNombre(String nombre){
        return empleadoRepository.
                buscarPorNombreParcial(nombre)
                .stream()
                .map(this::convertirDTO)
                .toList();
    }


    @Override
    public void eliminar(Long codigo) {
        if(!empleadoRepository.existsById(codigo)){
            throw new RuntimeException("No existe un empleado con id: " + codigo);
        }
        empleadoRepository.deleteById(codigo);
    }

    private EmpleadoResponseDTO convertirDTO(Empleado empleado){
        return new EmpleadoResponseDTO.builder()
                .id(empleado.getId())
                .nombre(empleado.getNombre())
                .cedula(empleado.getCedula())
                .departamentoNombre(empleado.getDepartamento().getNombre())
                .build();
    }
}
