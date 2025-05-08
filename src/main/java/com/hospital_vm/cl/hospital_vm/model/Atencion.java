package com.hospital_vm.cl.hospital_vm.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "atencion")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Atencion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date fechaAtencion;

    @Column(nullable = false)
    @JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
    private Date horaAtencion;

    @Column(nullable = false)
    private Integer costo;

    @Column(nullable = true)
    private String comentario;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    @JsonIgnoreProperties("atenciones")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "medico_id")
    @JsonIgnoreProperties("atenciones")
    private Medico medico;
}
