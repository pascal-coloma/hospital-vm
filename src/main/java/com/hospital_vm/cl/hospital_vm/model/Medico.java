package com.hospital_vm.cl.hospital_vm.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Table(name = "medico")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMedico;

    @Column(unique = true, length = 13, nullable = false)
    private String run_medico;

    @Column(nullable = false)
    private String pnombre;
    
    @Column(nullable = false)
    private String snombre;

    @Column(nullable = false)
    private String appaterno;

    @Column(nullable = false)
    private String apmaterno;

    @Column(nullable = true)
    private String especialidad;

    @Column(nullable = false)
    private char jefe_turno;

    @OneToMany(mappedBy = "medico")
    @JsonIgnoreProperties("medico")
    private List<Atencion> atenciones;




}
