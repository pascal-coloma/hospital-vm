package com.hospital_vm.cl.hospital_vm.service;

import com.hospital_vm.cl.hospital_vm.model.Paciente;
import com.hospital_vm.cl.hospital_vm.repository.PacienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public List<Paciente> findAll(){
        return pacienteRepository.findAll();
    }

    public Paciente findById(long id){
        return pacienteRepository.findById(id).get();
    }

    public List<Paciente> findByLastName(String apellido){
        return pacienteRepository.findByApellido(apellido);
    }

    public Paciente save(Paciente paciente){
        return pacienteRepository.save(paciente);    
    }

    public void delete(Long id){
        pacienteRepository.deleteById(id);
    }

    public Paciente findByCorreo(String correo){
        return pacienteRepository.findByCorreo(correo);
    }

    public List<Paciente> findByNames(String nombre, String apellido){
        return pacienteRepository.findByNombreandApellidos(nombre, apellido);
    }
}
