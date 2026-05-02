package com.devsenior.alara.jpa_demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsenior.alara.jpa_demo.model.PersonaDTO;
import com.devsenior.alara.jpa_demo.service.PersonaService;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/personas")
public class PersonaController {
    private final PersonaService personaService;

    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

    @GetMapping
    public List<PersonaDTO> listar() {
        return personaService.listar();
    }

    @PostMapping
    public PersonaDTO crear(@RequestBody PersonaDTO personaDTO) {
        return personaService.crear(personaDTO);
    }

    @GetMapping("/{cedula}")
    public PersonaDTO getMethodName(@PathVariable Long cedula) {
        return personaService.obtenerPorId(cedula);
    }

    @DeleteMapping("/{cedula}")
    public void eliminar(@PathVariable Long cedula) {
        personaService.eliminar(cedula);
    }

    @GetMapping("/buscar")
    public List<PersonaDTO> buscarPorNombre(@RequestParam String nombre) {
        return personaService.buscarPorNombre(nombre);
    }

    @GetMapping("/email")
    public PersonaDTO buscarPorEmail(@RequestParam String email) {
        return personaService.buscarPorEmail(email);
    }

    @GetMapping("/telefono")
    public List<PersonaDTO> buscarPorTelefono(@RequestParam String telefono) {
        return personaService.buscarPorTelefonoIniciandoCon(telefono);
    }

    @GetMapping("/nombre-ignorar-mayusculas")
    public List<PersonaDTO> buscarPorNombreIgnorandoMayusculas(@RequestParam String nombre) {
        return personaService.buscarPorNombreIgnorandoMayusculas(nombre);
    }
    
    @GetMapping("/nombre-parcial")
    public List<PersonaDTO> buscarPorNombreConteniendo(@RequestParam String nombre) {
        return personaService.buscarPorNombreConteniendo(nombre);
    }

    @GetMapping("/nombre-jpql")
    public List<PersonaDTO> buscarPorNombreJPQL(@RequestParam String nombre) {
        return personaService.buscarPorNombreJPQL(nombre);
    }

    @GetMapping("/nombre-conteniendo-jpql")
    public List<PersonaDTO> buscarPorNombreConteniendoJPQL(@RequestParam String nombre) {
        return personaService.buscarPorNombreConteniendoJPQL(nombre);
    }

    @GetMapping("/nombre-email-jpql")
    public PersonaDTO buscarPorNombreYEmailJPQL(@RequestParam String nombre, @RequestParam String email) {
        return personaService.buscarPorNombreYEmailJPQL(nombre, email);
    }

    @GetMapping("/longitud-telefono-jpql")
    public List<PersonaDTO> buscarPorLongitudTelefonoJPQL(@RequestParam int longitud) {
        return personaService.buscarPorLongitudTelefonoJPQL(longitud);
    }

    @GetMapping("/email-jpql")
    public List<PersonaDTO> buscarPorEmailJPQL(@RequestParam String dominio) {
        return personaService.buscarPorEmailJPQL(dominio);
    }
}
