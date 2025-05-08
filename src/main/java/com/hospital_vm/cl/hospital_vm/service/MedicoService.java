package com.hospital_vm.cl.hospital_vm.service;

import com.hospital_vm.cl.hospital_vm.model.Medico;
import com.hospital_vm.cl.hospital_vm.repository.MedicoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    public List<Medico> findAll(){
        return medicoRepository.findAll();
    }

    public Medico findById(long id){
        return medicoRepository.findById(id).get();
    }

    public List<Medico> findByLastName(String apellido){
        return medicoRepository.findByApellido(apellido);
    }

    public Medico save(Medico medico){
        return medicoRepository.save(medico);
    }

    public Medico findByRun(String run){
        return medicoRepository.findByRun(run);
    }

    public void delete(Long id){
        medicoRepository.deleteById(id);
    }


}
