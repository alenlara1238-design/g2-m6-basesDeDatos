package com.devsenior.relaciones_empleado_dpto.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsenior.relaciones_empleado_dpto.models.entity.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
    /*
        save()
        findById()
        findAll()
        deleteById()
        existsById()
        count()
    */  

    Optional<Empleado> findByCedula(String cedula);

    boolean existsByCedula(String cedula);

    /*
        Buscar empleados pertenecientes
        a un departamento especifico.

        departamento.codigo hace referencia a la relacion ManyToONe que existe entre Empleado y Departamento.
    */
    List<Empleado> findByDepartamentoCodigo(Long codigoDepartamento);
   

    @Query("""
            SELECT e 
            FROM Empleado e
            WHERE e.nombre LIKE %:nombre%   
            """)
            List<Empleado> buscarPorNombreParcial(String nombre);

}
