package com.proyectoEmpleado.empleados.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;        // Nombre del empleado
    private String apellido;      //Apellido del empleado
    private String email;         // Correo electrónico
    private String telefono;      // Número de teléfono
    private String departamento;  // Departamento
}