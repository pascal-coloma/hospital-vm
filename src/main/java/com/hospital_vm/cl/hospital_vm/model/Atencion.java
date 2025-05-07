package com.hospital_vm.cl.hospital_vm.model;

import java.util.Date;

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
    private int id;

    @Column(nullable = false)
    private Date fechaAtencion;

    @Column(nullable = false)
    private Date horaAtencion;

    @Column(nullable = false)
    private float costo;
    @Column(nullable = true)
    private String comentario;

}
