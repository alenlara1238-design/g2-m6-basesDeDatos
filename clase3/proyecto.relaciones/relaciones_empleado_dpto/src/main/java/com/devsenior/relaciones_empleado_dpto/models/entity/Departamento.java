package com.devsenior.relaciones_empleado_dpto.models.entity;

import java.util.List;
import com.devsenior.relaciones_empleado_dpto.models.entity.*;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "departamento")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Departamento {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long codigo;

    @NotBlank(message = "El nombre del departamento no puede estar vacío")
    @Column(nullable = false, unique = true)
    private String nombre;

    @OneToMany(
            mappedBy = "departamento",
            cascade = jakarta.persistence.CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Empleado> empleados;

}
