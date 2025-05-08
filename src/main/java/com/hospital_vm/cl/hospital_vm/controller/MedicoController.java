package com.hospital_vm.cl.hospital_vm.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital_vm.cl.hospital_vm.service.MedicoService;
import com.hospital_vm.cl.hospital_vm.model.Medico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;


@RestController
@RequestMapping("/api/v1/medicos")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @GetMapping
    public ResponseEntity<List<Medico>> listar(){
        List<Medico> medicos = medicoService.findAll();
        if (medicos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(medicos);
    }

    @PostMapping("/guardar")
    public ResponseEntity<Medico> guardar(@RequestBody Medico medico){
        Medico medicoNuevo = medicoService.save(medico);
        return ResponseEntity.status(HttpStatus.CREATED).body(medicoNuevo); 
    } 

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable long id){ 
        try {
            medicoService.delete(id);
            return ResponseEntity.noContent().build(); 
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Medico> actualizarMedico(@PathVariable Integer id, @RequestBody Medico medico) {
        try {
            Medico med = medicoService.findById(id);
            med.setIdMedico(id);
            med.setRun_medico(medico.getRun_medico());
            med.setPnombre(medico.getPnombre());
            med.setAppaterno(medico.getAppaterno());
            med.setApmaterno(medico.getApmaterno());
            med.setEspecialidad(medico.getEspecialidad());
            med.setJefe_turno(medico.getJefe_turno());

            medicoService.save(med);
            return ResponseEntity.ok(medico);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/buscarId/{id}")
    public ResponseEntity<Medico> buscar(@PathVariable Integer id){
        try {
            Medico medico = medicoService.findById(id);
            return ResponseEntity.ok(medico); 

        } catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/buscarApellido")
    public ResponseEntity<List<Medico>> buscarApellido(@RequestParam String apellido){
        try{
            List<Medico> medico = medicoService.findByLastName(apellido);
            return ResponseEntity.ok(medico); 
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/buscarRun")
    public ResponseEntity<Medico> buscarRun(@RequestParam String run){
        try{
            Medico medico = medicoService.findByRun(run);
            return ResponseEntity.ok(medico); 
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }


    

}
