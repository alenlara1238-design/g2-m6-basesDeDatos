package com.devsenior.alara.jpa_demo.model;

import jakarta.persistence.*;

@Entity //Indica que esta clase es una entidad de JPA(tabla de BD)
@Table(name = "personas") //Especifica el nombre de la tabla en la base de datos que representa esta entidad
public class Persona {
    @Id //Indica que el campo es la clave primaria de la entidad
    @Column(name = "cedula") //Especifica el nombre de la columna en la base de datos, que no puede ser nula y debe ser única
    private Long cedula;


    @Column(name = "nombre", length = 150, nullable = false) //Especifica el nombre de la columna en la base de datos, que no puede ser nula
    private String nombre;

    @Column(name = "telefono", length = 15) //Especifica el nombre de la columna en la base de datos, que puede ser nula
    private String telefono;

    @Column(name = "email", length = 150) //Especifica el nombre de la columna en la base de datos, que puede ser nula y debe ser única
    private String email;


    //constuctor vació para JPA
    public Persona() {
    }

    public Persona(Long cedula, String nombre, String telefono, String email) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
    }

    public Long getCedula() {
        return cedula;
    }

    public void setCedula(Long cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
}
