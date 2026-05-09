package com.devsenior.relaciones_empleado_dpto.models.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "empleados")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "La cedula del empleado es obligatoria")
    @Column(nullable = false, unique = true)
    private String cedula;

    @NotBlank(message = "El nombre del empleado es obligatorio")
    @Column(nullable = false)
    private String nombre;

    @ManyToOne(fetch = FetchType.LAZY) //carga bajo demanda
    @JoinColumn(name = "departamento_codigo")
    private Departamento departamento;
}
