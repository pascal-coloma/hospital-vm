package com.hospital_vm.cl.hospital_vm.repository;

import com.hospital_vm.cl.hospital_vm.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    
    @Query(value = "SELECT * FROM paciente WHERE apellido = :apellido", nativeQuery = true)
    List<Paciente> findByApellido(String apellido);

    @Query(value = "SELECT * FROM paciente WHERE correo LIKE :correo ", nativeQuery = true)
    Paciente findByCorreo(String correo);

    @Query(value = "SELECT * FROM paciente WHERE nombre = :nombre AND apellido = :apellido", nativeQuery = true)
    List<Paciente> findByNombreandApellidos(String nombre, String apellido);

}
