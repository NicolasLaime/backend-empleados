package com.proyectoEmpleado.empleados.service;

import com.proyectoEmpleado.empleados.entity.Empleado;
import com.proyectoEmpleado.empleados.repository.EmpleadoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmpleadoService {

    private final EmpleadoRepository empleadoRepository;

    public Empleado crearEmpleado(Empleado empleado){
        return empleadoRepository.save(empleado);
    }

    public List<Empleado> getAllEmpleados(){
        return  empleadoRepository.findAll();
    }

    public void borrarEmpleado(Long id) {
        System.out.println("Verificando existencia del ID: " + id);
        if (!empleadoRepository.existsById(id)) {
            throw new EntityNotFoundException("Empleado con el id " + id + " no encontrado");
        }
        System.out.println("Eliminando empleado con ID: " + id);
        empleadoRepository.deleteById(id);
        System.out.println("Empleado eliminado con éxito");
    }

    //traer empleado especifico
    public Empleado getEmpleadoById(Long id){
        return empleadoRepository.findById(id).orElse(null);
    }

    //actualizar usuario
    public Empleado actualizarEmpleado(Long id, Empleado empleado){
        Optional<Empleado> optionalEmpleado = empleadoRepository.findById(id);
        if(optionalEmpleado.isPresent()){
            Empleado existeEmpleado = optionalEmpleado.get();
            existeEmpleado.setEmail(empleado.getEmail());
            existeEmpleado.setNombre(empleado.getNombre());
            existeEmpleado.setApellido(empleado.getApellido());
            existeEmpleado.setEmail(empleado.getEmail());
            existeEmpleado.setTelefono(empleado.getTelefono());
            existeEmpleado.setDepartamento(empleado.getDepartamento());
            return  empleadoRepository.save(existeEmpleado);
        }
        return null;
    }




}
