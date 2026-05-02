package com.devsenior.alara.jpa_demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.devsenior.alara.jpa_demo.model.Persona;

// JpaRepository ya trae el CRUD completo sin escribir código
public interface PersonaRepository extends JpaRepository<Persona, Long> {
 //aquí podemos mas adelante realizar consultas personalizadas
 //CRUD: Create, Read, Update, Delete
    //   insert, select, update, delete

    List<Persona> findByNombre(String nombre);

    List<Persona> findByNombreContaining(String nombre);

    Persona findByEmail(String email);

    List<Persona> findByTelefonoStartsWith(String telefono);

    List<Persona> findByNombreIgnoreCase(String nombre);

    @Query("SELECT p FROM Persona p WHERE p.nombre = :nombre AND p.email = :email")
    Persona findByNombreAndEmail(@Param("nombre") String nombre, @Param("email") String email);

    @Query("SELECT p FROM Persona p WHERE p.nombre LIKE %:nombre%")
    List<Persona> buscarPorNombre(@Param("nombre") String nombre);

    @Query("SELECT p FROM Persona p WHERE  LENGTH(p.telefono) > :longitud")
    List<Persona> buscarPorLongitudTelefono(@Param("longitud") int longitud);

    @Query("SELECT p FROM Persona p WHERE p.email LIKE %:dominio%")
    List<Persona> buscarPorEmail(@Param("dominio") String dominio);
}
