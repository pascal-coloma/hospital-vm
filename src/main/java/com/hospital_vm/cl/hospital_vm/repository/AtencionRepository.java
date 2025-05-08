package com.hospital_vm.cl.hospital_vm.repository;

import com.hospital_vm.cl.hospital_vm.model.Atencion;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Date;


@Repository
public interface AtencionRepository extends JpaRepository<Atencion, Long> {

    @Query(value = "SELECT * FROM atencion WHERE fecha_atencion = :fecha_atencion", nativeQuery = true)
    List<Atencion> findByFecha(Date fecha_atencion);

    @Query(value = "SELECT *  FROM atencion WHERE hora_atencion = :hora_atencion", nativeQuery = true)
    List<Atencion> findByHora(Date hora_atencion);

    @Query(value = "SELECT * FROM atencion WHERE paciente_id = :id", nativeQuery = true)
    List<Atencion> findByPaciente(Long id);

    @Query(value = "SELECT * FROM atencion WHERE medico_id =   :idMedico", nativeQuery = true)
    List<Atencion> findByMedico(Long id);

}
