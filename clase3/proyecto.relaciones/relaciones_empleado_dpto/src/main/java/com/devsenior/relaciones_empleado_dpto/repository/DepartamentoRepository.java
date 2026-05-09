package com.devsenior.relaciones_empleado_dpto.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsenior.relaciones_empleado_dpto.models.entity.Departamento;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {
    /*
        save()
        findById()
        findAll()
        deleteById()
        existsById()
        count()
    */

    Optional<Departamento> findByNombre(String nombre);

    boolean existsByNombre(String nombre);
}
