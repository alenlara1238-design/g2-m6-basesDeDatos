package com.devsenior.alara.jpa_demo.service;

import java.util.List;

import com.devsenior.alara.jpa_demo.model.Persona;
import com.devsenior.alara.jpa_demo.model.PersonaDTO;

public interface PersonaService {
    PersonaDTO crear(PersonaDTO personaDTO);
    List<PersonaDTO> listar();
    PersonaDTO obtenerPorId(Long cedula);
    void eliminar(Long cedula);
    List<PersonaDTO> buscarPorNombre(String nombre);
    List<PersonaDTO> buscarPorNombreConteniendo(String nombre);
    PersonaDTO buscarPorEmail(String email);
    List<PersonaDTO> buscarPorTelefonoIniciandoCon(String telefono);
    List<PersonaDTO> buscarPorNombreIgnorandoMayusculas(String nombre);
    List<PersonaDTO> buscarPorNombreJPQL(String nombre);
    List<PersonaDTO> buscarPorNombreConteniendoJPQL(String nombre);
    PersonaDTO buscarPorNombreYEmailJPQL(String nombre, String email);
    List<PersonaDTO> buscarPorLongitudTelefonoJPQL(int longitud);
    List<PersonaDTO> buscarPorEmailJPQL(String gmail);
}
