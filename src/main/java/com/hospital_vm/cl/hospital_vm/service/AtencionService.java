package com.hospital_vm.cl.hospital_vm.service;

import java.util.List;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hospital_vm.cl.hospital_vm.repository.AtencionRepository;
import com.hospital_vm.cl.hospital_vm.model.Atencion;
import jakarta.transaction.Transactional;



@Service
@Transactional
public class AtencionService {

    @Autowired
    private AtencionRepository atencionRepository;

    public List<Atencion> findAll(){
        return atencionRepository.findAll();
    }
    
    public Atencion findById(long id){
        return atencionRepository.findById(id).get();
    }

    public List<Atencion> findByFecha(Date fechaAtencion){
        return atencionRepository.findByFecha(fechaAtencion);
    }

    public List<Atencion> findByHora(Date horaAtencion){
        return atencionRepository.findByHora(horaAtencion);
    }

    public Atencion save(Atencion atencion){
        return atencionRepository.save(atencion);
    }

    public void delete(Long id){
        atencionRepository.deleteById(id);
    }

    public List<Atencion> findByPaciente(Long idPaciente){
        return atencionRepository.findByPaciente(idPaciente);
        
    }


}
