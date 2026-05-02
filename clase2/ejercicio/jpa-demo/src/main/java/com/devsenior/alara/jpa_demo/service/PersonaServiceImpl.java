package com.devsenior.alara.jpa_demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.devsenior.alara.jpa_demo.model.Persona;
import com.devsenior.alara.jpa_demo.model.PersonaDTO;
import com.devsenior.alara.jpa_demo.repository.PersonaRepository;

@Service
public class PersonaServiceImpl implements PersonaService  {

    private final PersonaRepository personaRepository;

    public PersonaServiceImpl(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    @Override
    public PersonaDTO crear(PersonaDTO personaDTO) {
        Persona persona = mapToEntity(personaDTO);
        Persona savedPersona = personaRepository.save(persona); // la C del crud: create --> insert
        return mapToDTO(savedPersona);
    }

    
    @Override
    public List<PersonaDTO> listar() {
        return personaRepository.findAll().stream()
                .map(this::mapToDTO) // map(persona) -> mapToDTO(persona)
                .toList();
    }

    @Override
    public PersonaDTO obtenerPorId(Long cedula) {
        Persona persona = personaRepository.findById(cedula)
                .orElseThrow(() -> new RuntimeException("Persona no encontrada con cédula: " + cedula));
        return mapToDTO(persona);
    }

    @Override
    public void eliminar(Long cedula) {
        if (!personaRepository.existsById(cedula)) {
            throw new RuntimeException("Persona no encontrada con cédula: " + cedula);
        }
        personaRepository.deleteById(cedula);
    }

    



    private PersonaDTO mapToDTO(Persona savedPersona) {
        PersonaDTO personaDTO = new PersonaDTO();
        personaDTO.setCedula(savedPersona.getCedula());
        personaDTO.setNombre(savedPersona.getNombre());
        personaDTO.setTelefono(savedPersona.getTelefono());
        personaDTO.setEmail(savedPersona.getEmail());
        return personaDTO;
    }

    private Persona mapToEntity(PersonaDTO personaDTO) {
        Persona persona = new Persona();
        persona.setCedula(personaDTO.getCedula());
        persona.setNombre(personaDTO.getNombre());
        persona.setTelefono(personaDTO.getTelefono());
        persona.setEmail(personaDTO.getEmail());
        return persona;
    }

    @Override
    public List<PersonaDTO> buscarPorNombre(String nombre) {
        return personaRepository.findByNombre(nombre).stream()
                .map(this::mapToDTO)
                .toList();
    }

    @Override
    public List<PersonaDTO> buscarPorNombreConteniendo(String nombre) {
        return personaRepository.findByNombreContaining(nombre).stream()
                .map(this::mapToDTO)
                .toList();
    }
    @Override
    public PersonaDTO buscarPorEmail(String email) {
       Persona persona = personaRepository.findByEmail(email);
       return mapToDTO(persona);
    }

    @Override
    public List<PersonaDTO> buscarPorTelefonoIniciandoCon(String telefono) {
        return personaRepository.findByTelefonoStartsWith(telefono).stream()
                .map(this::mapToDTO)
                .toList();
    }

    @Override
    public List<PersonaDTO> buscarPorNombreIgnorandoMayusculas(String nombre) {
        return personaRepository.findByNombreIgnoreCase(nombre).stream()
                .map(this::mapToDTO)
                .toList();
    }

    @Override
    public List<PersonaDTO> buscarPorNombreJPQL(String nombre) {
        return personaRepository.buscarPorNombre(nombre).stream()
                .map(this::mapToDTO)
                .toList();
    
    }

    @Override
    public List<PersonaDTO> buscarPorNombreConteniendoJPQL(String nombre) {
        return personaRepository.buscarPorNombre(nombre).stream()
                .map(this::mapToDTO)
                .toList();
    }

    @Override
    public PersonaDTO buscarPorNombreYEmailJPQL(String nombre, String email) {
        Persona persona = personaRepository.findByNombreAndEmail(nombre, email);
        return mapToDTO(persona);
    }


    @Override
    public List<PersonaDTO> buscarPorLongitudTelefonoJPQL(int longitud) {
        return personaRepository.buscarPorLongitudTelefono(longitud).stream()
                .map(this::mapToDTO)
                .toList();
    }

    @Override
    public List<PersonaDTO> buscarPorEmailJPQL(String dominio) {
        return personaRepository.buscarPorEmail(dominio).stream()
                .map(this::mapToDTO)
                .toList();
    }

}
