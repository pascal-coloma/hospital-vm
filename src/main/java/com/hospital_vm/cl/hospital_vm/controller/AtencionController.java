package com.hospital_vm.cl.hospital_vm.controller;

import java.util.List;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital_vm.cl.hospital_vm.model.Atencion;
import com.hospital_vm.cl.hospital_vm.service.AtencionService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/v1/atenciones")
public class AtencionController {

    @Autowired
    private AtencionService atencionService;

    @GetMapping
    public ResponseEntity<List<Atencion>> listar(){
        List<Atencion> atenciones = atencionService.findAll();
        if (atenciones.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(atenciones);
    }

    @PostMapping("/guardar")
    public ResponseEntity<Atencion> guardar(@RequestBody Atencion atencion){
        Atencion nuevaAtencion = atencionService.save(atencion);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaAtencion);
    }

    @GetMapping("/buscarId/{id}")
    public ResponseEntity<Atencion> buscar(@PathVariable Long id){
        try {
            Atencion atencion = atencionService.findById(id);
            return ResponseEntity.ok(atencion);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/buscarPorFecha")
    public List<Atencion> buscarHora(
        @RequestParam("fechaAtencion")
        @DateTimeFormat(pattern = "ddMMyyyy") Date fechaAtencion) {
        return atencionService.findByFecha(fechaAtencion);
    }
    
    @GetMapping("/atencionesPcte")
    public List<Atencion> buscarPaciente(@RequestParam Long id){
        return atencionService.findByPaciente(id);
    }
    
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable long id){
        try {
            atencionService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Atencion> actAtencion(@PathVariable Integer id, @RequestBody Atencion atencion) {
        try {
            Atencion ate = atencionService.findById(id);
            ate.setId(id);
            ate.setFechaAtencion(atencion.getFechaAtencion());
            ate.setHoraAtencion(atencion.getHoraAtencion());
            ate.setCosto(atencion.getCosto());
            ate.setPaciente(atencion.getPaciente());
            ate.setMedico(atencion.getMedico());
            ate.setComentario(atencion.getComentario());

            atencionService.save(ate);
            return ResponseEntity.ok(ate);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    


    
    
    
    

}
