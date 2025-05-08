package com.hospital_vm.cl.hospital_vm.controller;

import org.springframework.web.bind.annotation.RestController;

import com.hospital_vm.cl.hospital_vm.model.Paciente;
import com.hospital_vm.cl.hospital_vm.service.PacienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/api/v1/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public ResponseEntity<List<Paciente>> listar(){
        List<Paciente> pacientes = pacienteService.findAll();
        if (pacientes.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(pacientes);
    }

    @PostMapping("/guardar")
    public ResponseEntity<Paciente> guardar(@RequestBody Paciente paciente){
        Paciente pcteNuevo = pacienteService.save(paciente);
        return ResponseEntity.status(HttpStatus.CREATED).body(pcteNuevo); 
    } 

    @GetMapping("/buscarId/{id}")
    public ResponseEntity<Paciente> buscar(@PathVariable Integer id){
        try {
            Paciente paciente = pacienteService.findById(id);
            return ResponseEntity.ok(paciente); 

        } catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/buscarApellido")
    public ResponseEntity<List<Paciente>> buscarApellido(@RequestParam String apellido){
        try{
            List<Paciente> paciente = pacienteService.findByLastName(apellido);
            return ResponseEntity.ok(paciente); 
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/buscarCorreo")
    public ResponseEntity<Paciente> buscarCorreo(@RequestParam String correo) {
        try{
            Paciente paciente = pacienteService.findByCorreo(correo);
            return ResponseEntity.ok(paciente); 
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/busqNomApell")
    public ResponseEntity<List<Paciente>> buscarNomApell(@RequestParam String nombre, @RequestParam String apellido){
        try {
            List<Paciente> paciente = pacienteService.findByNames(nombre, apellido);
            return ResponseEntity.ok(paciente); 
            
        } catch (Exception e) {
            return ResponseEntity.notFound().build(); 
        }
    }
    
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable long id){ 
        try {
            pacienteService.delete(id);
            return ResponseEntity.noContent().build(); 
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Paciente> actualizarPcte(@PathVariable Integer id, @RequestBody Paciente paciente) {
        try {
            Paciente pac = pacienteService.findById(id);
            pac.setId(id);
            pac.setRun(paciente.getRun());
            pac.setNombre(paciente.getNombre());
            pac.setApellido(paciente.getApellido());
            pac.setFechaNacimiento(paciente.getFechaNacimiento());
            pac.setCorreo(paciente.getCorreo());

            pacienteService.save(pac);
            return ResponseEntity.ok(paciente);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    
    
    
    
    
    


    
    
    
    
}
