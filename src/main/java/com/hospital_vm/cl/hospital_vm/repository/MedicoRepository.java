package com.hospital_vm.cl.hospital_vm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.hospital_vm.cl.hospital_vm.model.Medico;

import java.util.List;


@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {

    @Query(value = "SELECT * FROM medico WHERE apellido = :apellido", nativeQuery = true)
    List<Medico> findByApellido(String apellido);

    @Query(value = "SELECT * FROM medico WHERE run_medico LIKE :run ", nativeQuery = true)
    Medico findByRun(String run);

    
}
