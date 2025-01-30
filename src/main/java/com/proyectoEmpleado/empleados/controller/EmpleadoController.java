package com.proyectoEmpleado.empleados.controller;


import com.proyectoEmpleado.empleados.entity.Empleado;
import com.proyectoEmpleado.empleados.service.EmpleadoService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin("*")
public class EmpleadoController {

    private final EmpleadoService  empleadoService;

    @PostMapping("/crearempleado")
    public Empleado crearEmpleado(@RequestBody Empleado empleado){
        return empleadoService.crearEmpleado(empleado);
    }


    @GetMapping("/empleados")
    public List<Empleado> getAllEmpleado(){
        return empleadoService.getAllEmpleados();
    }


    @DeleteMapping("/empleados/{id}")
    public ResponseEntity<?> borrarEmpleado(@PathVariable Long id){
        try{
            empleadoService.borrarEmpleado(id);
            return new ResponseEntity<>("Empleado con el Id" + id + "Borrado exitosamente", HttpStatus.OK);
        } catch (EntityNotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    // para traer un empleado especifico
    @GetMapping("/empleados/{id}")
    public ResponseEntity<?> getEmpleadoById(@PathVariable Long id){
        Empleado empleado = empleadoService.getEmpleadoById(id);
        if(empleado == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(empleado);

    }


    // actualizar empleado

    @PutMapping("/empleados/{id}")
    public ResponseEntity<?> actualizarEmpleado(@PathVariable Long id , @RequestBody Empleado empleado){
        Empleado actualizarEmpleado = empleadoService.actualizarEmpleado(id, empleado);
        if(actualizarEmpleado == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        return ResponseEntity.ok(actualizarEmpleado);
    }


}
